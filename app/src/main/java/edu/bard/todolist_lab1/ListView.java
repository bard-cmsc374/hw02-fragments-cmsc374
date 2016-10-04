package edu.bard.todolist_lab1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Dan_Ellis on 9/27/16.
 */

public class ListView extends Fragment {

    private RecyclerView mItemRecyclerView;
    private ItemAdapter mAdapter;
    private android.widget.ListView mItemView;

    public static String TAG = "todolab";
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

        mItemRecyclerView = (RecyclerView) view
                .findViewById(R.id.item_recycler_view);
        mItemRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        ItemList itemList = ItemList.get(getActivity());
        List<Item> items = itemList.getItems();

        mAdapter = new ItemAdapter(items);
        mItemRecyclerView.setAdapter(mAdapter);
    }

    public interface ItemListener {
        public void itemToSend(String s);
    }

    ItemListener mListener;

    public void addItem(String newItem){
        mToDoItems.add(0, newItem.toString());
        aa.notifyDataSetChanged();
        mItemView.setAdapter(aa);
    }

    private class ItemHolder extends RecyclerView.ViewHolder {
        public TextView mTitleTextView;

        public ItemHolder(View itemView) {
            super(itemView);

            mTitleTextView = (TextView) itemView;

        }
    }

    private class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {
        private List<Item> mItems;

        public ItemAdapter(List<Item> items) {
            mItems = items;
        }


        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(android.R.layout.simple_expandable_list_item_1, parent, false);
            return new ItemHolder(view);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position) {
            Item item = mItems.get(position);
            holder.mTitleTextView.setText(item.getTitle());
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }
    }



}