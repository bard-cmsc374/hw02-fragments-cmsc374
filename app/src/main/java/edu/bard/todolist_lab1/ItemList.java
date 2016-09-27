package edu.bard.todolist_lab1;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Dan_Ellis on 9/26/16.
 */

public class ItemList {
    private static ItemList sItemList;

    private List<Item> mItems;

    public static ItemList get(Context context) {
        if (sItemList == null) {
            sItemList = new ItemList(context);
        }
        return sItemList;
    }

    private ItemList(Context context){
        mItems = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Item item = new Item();
            item.setTitle("Item #" + i);
            mItems.add(item);
        }
    }

    public List<Item> getItems() {
        return mItems;
    }

    public Item getItem(UUID id){
        for (Item item : mItems){
            if(item.getID().equals(id)){
                return item;
            }
        }
        return null;
    }
}


