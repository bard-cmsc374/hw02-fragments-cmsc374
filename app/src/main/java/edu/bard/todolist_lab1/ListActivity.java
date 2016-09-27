package edu.bard.todolist_lab1;

import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;

/**
 * Created by Dan_Ellis on 9/27/16.
 */

public class ListActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return new ItemListFragment();
    }
}
