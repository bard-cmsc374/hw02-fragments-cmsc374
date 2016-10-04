package edu.bard.todolist_lab1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;



/**
 * Created by Dan_Ellis on 9/27/16.
 */

public class ListViewer extends Fragment {

    public static String TAG = "todolab";
    ItemListener mListener;
    private ListView mItemListView;
    private ArrayList<String> mToDoItems;
    private ArrayAdapter<String> aa;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToDoItems = new ArrayList<String>();
        aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mToDoItems);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);

        mItemListView = (ListView) view.findViewById(R.id.list_view);

        return view;
    }

    public void addItem(String newItem){
        mToDoItems.add(0, newItem.toString());
        aa.notifyDataSetChanged();

        mItemListView.setAdapter(aa);
    }

        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(android.R.layout.simple_expandable_list_item_1, parent, false);
            return new ItemHolder(view);
        }

    public interface ItemListener {
        public void itemToSend(String s);
    }

    private class ItemHolder {
        public TextView mTitleTextView;

        public ItemHolder(View itemView) {


            mTitleTextView = (TextView) itemView;

        }
    }



}