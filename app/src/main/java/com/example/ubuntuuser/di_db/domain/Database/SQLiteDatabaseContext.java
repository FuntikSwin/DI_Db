package com.example.ubuntuuser.di_db.domain.Database;

import android.content.Context;

import com.example.ubuntuuser.di_db.domain.Model.Card;
import com.example.ubuntuuser.di_db.domain.Model.CardGroup;

import java.util.List;

public class SQLiteDatabaseContext implements IDatabaseContext {

    private Context context;
    private String dbName;

    public SQLiteDatabaseContext(Context context) {

        this.context = context;
        dbName = "123456";
    }

    @Override
    public List<Card> getCards() {
        return null;
    }

    @Override
    public List<CardGroup> getCardGroups() {
        return null;
    }

    public String getDbName() {
        return dbName;
    }
}
