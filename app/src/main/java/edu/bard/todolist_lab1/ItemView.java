package edu.bard.todolist_lab1;

import android.app.Activity;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Creat by Gareth Valentin on 9.24
 */

public class ItemView extends Fragment {


    public ItemListener mListener;
    private EditText mEditText;
    private Button mButton;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);


        try {
            mListener = (ItemListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement ItemListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_view, container, false);

        mEditText = (EditText) v.findViewById(R.id.addEditText);


        mButton = (Button)v.findViewById(R.id.addButton);
        mButton.setEnabled(true);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mListener.itemToSend(mEditText.getText().toString());
                mEditText.setText("");
            }
        });

        return v;
    }

    public interface ItemListener {
        public void itemToSend(String s);
    }

}