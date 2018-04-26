package com.example.ubuntuuser.di_db.domain.Model;

public class CardGroup {

    private long Id;
    private String GroupName;

    public CardGroup(long id, String groupName) {
        Id = id;
        GroupName = groupName;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }
}
