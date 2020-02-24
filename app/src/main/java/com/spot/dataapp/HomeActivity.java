package com.spot.dataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void clickHandler(View view) {
        //Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
        Intent mainIntent = new Intent(HomeActivity.this,MainActivity.class);
        mainIntent.putExtra("profession","developer");
        startActivity(mainIntent);
    }
}
