package com.spot.dataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DbActivity extends AppCompatActivity {
    EditText titleEditText,subtitleSetEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        titleEditText = findViewById(R.id.editTextTitle);
        subtitleSetEditText = findViewById(R.id.editTextSubtitle);
    }

    public void DbHandler(View view) {
        switch (view.getId()){
            case R.id.buttonget:
                String title = titleEditText.getText().toString();
                Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonSet:
                String subtitle = subtitleSetEditText.getText().toString();

                Toast.makeText(this, subtitle, Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
