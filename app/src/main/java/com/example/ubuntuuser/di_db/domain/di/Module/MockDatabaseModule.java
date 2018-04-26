package com.example.ubuntuuser.di_db.domain.di.Module;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.ubuntuuser.di_db.domain.Database.IDatabaseContext;
import com.example.ubuntuuser.di_db.domain.Database.MockDatabaseContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MockDatabaseModule {

    @Provides
    @NonNull
    @Singleton
    public IDatabaseContext provideMockDatabaseContext(@NonNull Context context) {
        return new MockDatabaseContext();
    }

}
