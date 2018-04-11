package com.example.manis_000.cpbooking;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class viewobjects extends AppCompatActivity {

    private static final String Tag= "ListDataActivity";
    DatabaseHelper databaseHelper;
    private ListView mlistview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewobjects);
        mlistview = (ListView) findViewById(R.id.listview);
        databaseHelper =new DatabaseHelper(this);

        populateListView();
    }

    private void populateListView() {
        Log.d(Tag,"populate Listview: displaying data in the listview");

        Cursor data = databaseHelper.getData();
        ArrayList<String> listdata = new ArrayList<>();
        while(data.moveToNext()){
            listdata.add(data.getString(1));
        }
        ListAdapter adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listdata);
        mlistview.setAdapter(adapter);
    }
}
