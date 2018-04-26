package com.example.ubuntuuser.di_db.domain.Database;

import com.example.ubuntuuser.di_db.domain.Model.Card;
import com.example.ubuntuuser.di_db.domain.Model.CardGroup;

import java.util.ArrayList;
import java.util.List;

public class MockDatabaseContext implements IDatabaseContext {

    public MockDatabaseContext() {
    }

    @Override
    public List<Card> getCards() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(1, "Card1", null, null));
        return cards;
    }

    @Override
    public List<CardGroup> getCardGroups() {
        return null;
    }
}
