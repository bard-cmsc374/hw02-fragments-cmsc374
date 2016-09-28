package edu.bard.todolist_lab1;

import java.util.UUID;

/**
 * Created by Dan_Ellis on 9/26/16.
 */

public class Item {

    private UUID mID;
    private String mTitle;

    public Item(){
        mID = UUID.randomUUID();
    }


    public UUID getID() { return mID;}

    public void setTitle(String title) { mTitle = title;}

    public String getTitle() {
        return mTitle;
    }

}
