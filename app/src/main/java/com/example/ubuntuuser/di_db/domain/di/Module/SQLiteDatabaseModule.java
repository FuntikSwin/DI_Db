package com.example.ubuntuuser.di_db.domain.di.Module;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.ubuntuuser.di_db.domain.Database.IDatabaseContext;
import com.example.ubuntuuser.di_db.domain.Database.SQLiteDatabaseContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SQLiteDatabaseModule {

    @Provides
    @NonNull
    @Singleton
    public IDatabaseContext provideDatabaseContext(@NonNull Context context) {
        return new SQLiteDatabaseContext(context);
    }

}
