package com.spot.dataapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
TextView resTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        resTextView = findViewById(R.id.textViewresult);
    }

    public void clickHandler(View view) {
        //Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
        Intent mainIntent = new Intent(HomeActivity.this,MainActivity.class);
        mainIntent.putExtra("profession","developer");
        startActivityForResult(mainIntent,123);//1
        /*Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"));
        startActivity(dialIntent);*/
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {//3
        super.onActivityResult(requestCode, resultCode, intent);
        String res = intent.getExtras().getString("email");
        resTextView.setText(res);
    }
}
