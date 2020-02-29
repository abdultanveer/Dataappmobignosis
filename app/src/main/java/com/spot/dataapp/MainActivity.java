package com.spot.dataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.spot.dataapp.classroom.Student;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();//"MainActivity"
    EditText nameEditText, emailEditText; // int a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"creating");

        setContentView(R.layout.activity_main);//inflating the layout
        nameEditText = findViewById(R.id.editText);  //taking handles of widgets
        emailEditText = findViewById(R.id.editText2);//a = 10;
        TextView resTextView = findViewById(R.id.textViewres);
        /*Intent startingIntent = getIntent();///this will get the intent which started this[mainactivity].
        Bundle extras = startingIntent.getExtras();
        String data = extras.getString("profession");
        resTextView.setText(data);*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"starting");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "resuming", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"resuming");
        restoreData();
    }

    private void restoreData() {
        Log.i(TAG,"restoreData");

        //open file
        SharedPreferences sharedPreferences = getSharedPreferences("preferences",MODE_PRIVATE);
       // read the data
      String data =  sharedPreferences.getString("profession","");
        Log.i(TAG,"data="+data);
        Student abdul = new Student();


        //put the data into edittext
        nameEditText.setText(data);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "pausing", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"pausing");
        saveData();
    }

    private void saveData() {
        Log.i(TAG,"saving data");

        //get data from those edittexts
        String name = nameEditText.getText().toString();
        Log.i(TAG,"data="+name);

        //create a sharedprefs file --preferences
        SharedPreferences sharedPreferences = getSharedPreferences("preferences",MODE_PRIVATE);
        //open the file
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //write the data into file
        editor.putString("profession",name);
        //save file
        editor.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"stopping");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"destroyed");

    }

    public void handleClick(View view) {//2
        String string = emailEditText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("email",string);
        setResult(RESULT_OK,intent);
        finish();
    }
}
