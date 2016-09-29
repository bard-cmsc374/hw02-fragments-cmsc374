package edu.bard.todolist_lab1;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class ItemView extends Fragment {

    private ToDoList mToDoList;
    private EditText mEditText;
    private Button mButton;
    public Listener mListener;


    public interface Listener {
        public void itemToSend(String s);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToDoList = new ToDoList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_view, container, false);

        mEditText = (EditText)v.findViewById(R.id.EditText);


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

}