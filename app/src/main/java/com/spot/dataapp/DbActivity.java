package com.spot.dataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
    }

    public void DbHandler(View view) {
        switch (view.getId()){
            case R.id.buttonget:
                break;
            case R.id.buttonSet://3
                String title = titleEditText.getText().toString();
                String subtitle = subtitleSetEditText.getText().toString();
                dbAccessObject.createRow(title,subtitle);//3a


                break;
        }
    }
}
