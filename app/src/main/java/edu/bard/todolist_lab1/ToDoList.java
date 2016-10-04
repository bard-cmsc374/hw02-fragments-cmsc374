package edu.bard.todolist_lab1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.ListView;


public class ToDoList extends FragmentActivity implements ItemView.ItemListener{
    public static String TAG = "todolab";
    private String mItem;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        FragmentManager fm = getSupportFragmentManager();

        Fragment fragment1 = fm.findFragmentById(R.id.Listview);
        if (fragment1 == null) {
            fragment1 = new ListViewer();
            fm.beginTransaction()
                    .add(R.id.Listview, fragment1)
                    .commit(); }

      
        Fragment fragment2 = fm.findFragmentById(R.id.ItemView);
        if (fragment2 == null) {
            fragment2 = new ItemView();
            fm.beginTransaction()
                    .add(R.id.ItemView, fragment2)
                    .commit(); }


        Log.i(TAG, "Entered onCreate");
    }

    public void itemToSend (String item) {

        mItem = item;
        ListViewer Pac = (ListViewer) getSupportFragmentManager().findFragmentById(R.id.Listview);
        Pac.addItem(mItem);

    }

    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Entered onStart");
    }

    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Entered onRestart");
    }

    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Entered onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Entered onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Entered onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Entered onDestroy");
    }


}
