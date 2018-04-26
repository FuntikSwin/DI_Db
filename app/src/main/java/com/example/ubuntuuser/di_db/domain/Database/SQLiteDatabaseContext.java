package com.example.ubuntuuser.di_db.domain.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.ubuntuuser.di_db.domain.Model.Card;
import com.example.ubuntuuser.di_db.domain.Model.CardGroup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLiteDatabaseContext extends SQLiteOpenHelper implements IDatabaseContext {

    private final Context context;

    private static String DB_NAME = "PassKeepers.db";
    private static String DB_PATH = "";
    private static final int DB_VERSION = 1;

    private SQLiteDatabase dataBase;
    private boolean needUpdate = false;

    public SQLiteDatabaseContext(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        if (Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.context = context;

        copyDataBase();
        this.getReadableDatabase();

        try {
            updateDataBase();
        } catch (IOException ex) {
            throw new Error("UnableToUpdateDatabase");
        }
        dataBase = getWritableDatabase();
    }

    public void updateDataBase() throws IOException {
        if (needUpdate) {
            File dbFile = new File(DB_PATH + DB_NAME);
            if (dbFile.exists()) {
                dbFile.delete();
            }

            copyDataBase();
            needUpdate = false;
        }
    }

    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

    private void copyDataBase() {
        if (!checkDataBase()) {
            this.getReadableDatabase();
            this.close();
            try {
                copyDBFile();
            } catch (IOException ex) {
                throw new Error("ErrorCopyingDatabase");
            }
        }
    }

    private void copyDBFile() throws IOException {
        InputStream in = context.getAssets().open(DB_NAME);
        OutputStream out = new FileOutputStream(DB_PATH + DB_NAME);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
        out.flush();
        out.close();
        in.close();
    }

    public boolean openDataBase() {
        dataBase = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        return dataBase != null;
    }

    @Override
    public synchronized void close() {
        if (dataBase != null) {
            dataBase.close();
        }
        super.close();
    }

    @Override
    public List<Card> getCards() {
        return null;
    }

    @Override
    public List<CardGroup> getCardGroups() {
        List<CardGroup> groups = new ArrayList<>();

        Cursor cursor = dataBase.rawQuery("select * from CardGroup", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            groups.add(new CardGroup(cursor.getInt(0), cursor.getString(1)));
            cursor.moveToNext();
        }
        cursor.close();

        return groups;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            needUpdate = true;
        }
    }
}
