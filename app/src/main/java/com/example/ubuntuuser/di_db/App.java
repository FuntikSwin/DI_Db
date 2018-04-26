package com.example.ubuntuuser.di_db;

import android.app.Application;

import com.example.ubuntuuser.di_db.domain.di.Component.DaggerDatabaseContextComponent;
import com.example.ubuntuuser.di_db.domain.di.Component.DatabaseContextComponent;
import com.example.ubuntuuser.di_db.domain.di.Module.AppModule;

public class App extends Application {

    private static DatabaseContextComponent dbContextComponent;

    public static DatabaseContextComponent getDbContextComponent() {
        return dbContextComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        dbContextComponent = DaggerDatabaseContextComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
