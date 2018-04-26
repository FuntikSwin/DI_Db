package com.example.ubuntuuser.di_db.domain.Database;

import com.example.ubuntuuser.di_db.domain.Model.Card;
import com.example.ubuntuuser.di_db.domain.Model.CardGroup;

import java.util.List;

public interface IDatabaseContext {

    List<Card> getCards();
    List<CardGroup> getCardGroups();

}
