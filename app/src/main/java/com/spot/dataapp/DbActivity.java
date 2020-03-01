package com.spot.dataapp;

import androidx.appcompat.app.AppCompatActivity;
import com.spot.dataapp.database.FeedReaderContract.FeedEntry;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.spot.dataapp.database.DbAccessObject;

public class DbActivity extends AppCompatActivity {
    EditText titleEditText,subtitleSetEditText;
    DbAccessObject dbAccessObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        titleEditText = findViewById(R.id.editTextTitle);
        subtitleSetEditText = findViewById(R.id.editTextSubtitle);
        dbAccessObject = new DbAccessObject(this);//1
        dbAccessObject.openDb();//2
        Cursor cursor = dbAccessObject.readRows();
        ListView listView = findViewById(R.id.listview);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2,//row layout
                cursor,
                new String[]{FeedEntry.COLUMN_NAME_TITLE,FeedEntry.COLUMN_NAME_SUBTITLE},//from = db col names
                new int[]{android.R.id.text1,android.R.id.text2});//to -- textview id
        listView.setAdapter(adapter);
    }

    public void DbHandler(View view) {
        switch (view.getId()){
            case R.id.buttonget:
                String result =  dbAccessObject.readRow();
                TextView resTextView = findViewById(R.id.textViewdb);
                resTextView.setText(result);
                break;
            case R.id.buttonSet://3
                String title = titleEditText.getText().toString();
                String subtitle = subtitleSetEditText.getText().toString();
                dbAccessObject.createRow(title,subtitle);//3a


                break;
        }
    }
}
