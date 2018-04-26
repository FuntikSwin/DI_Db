package com.example.ubuntuuser.di_db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ubuntuuser.di_db.domain.Database.IDatabaseContext;
import com.example.ubuntuuser.di_db.domain.Model.Card;
import com.example.ubuntuuser.di_db.domain.Model.CardGroup;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    IDatabaseContext dbContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.getDbContextComponent().inject(this);

        List<CardGroup> groups = dbContext.getCardGroups();
    }
}
