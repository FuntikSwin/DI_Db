package com.example.ubuntuuser.di_db.domain.di.Component;

import com.example.ubuntuuser.di_db.MainActivity;
import com.example.ubuntuuser.di_db.domain.di.Module.AppModule;
import com.example.ubuntuuser.di_db.domain.di.Module.MockDatabaseModule;
import com.example.ubuntuuser.di_db.domain.di.Module.SQLiteDatabaseModule;

import javax.inject.Singleton;

import dagger.Component;

//@Component(modules = {AppModule.class, MockDatabaseModule.class})
@Component(modules = {AppModule.class, SQLiteDatabaseModule.class})
@Singleton
public interface DatabaseContextComponent {

    void inject(MainActivity mainActivity);

}
