package com.spot.dataapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    TextView resTextView;
    public int REQUEST_SELECT_CONTACT = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        resTextView = findViewById(R.id.textViewresult);
    }

    public void clickHandler(View view) {
        //Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
        Intent mainIntent = new Intent(HomeActivity.this, MainActivity.class);
        mainIntent.putExtra("profession", "developer");
        int a = 10;
        int b = 20 + a;
        startActivityForResult(mainIntent, 123);//1

        /*Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"));
        startActivity(dialIntent);*/
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {//3
        super.onActivityResult(requestCode, resultCode, intent);
        /*String res = intent.getExtras().getString("email");
        resTextView.setText(res);*/
        String cNumber = "";
        if (requestCode == REQUEST_SELECT_CONTACT && resultCode == RESULT_OK) {
            Uri contactUri = intent.getData();
            Cursor c =  managedQuery(contactUri, null, null, null, null);
            if (c.moveToFirst()) {


                String id =c.getString(c.getColumnIndexOrThrow(ContactsContract.Contacts._ID));

                String hasPhone =c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));

                if (hasPhone.equalsIgnoreCase("1")) {
                    Cursor phones = getContentResolver().query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = "+ id,
                            null, null);
                    phones.moveToFirst();
                    cNumber = phones.getString(phones.getColumnIndex("data1"));
                    System.out.println("number is:"+cNumber);
                }
                String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));


            }

           /* Cursor cursor = getContentResolver().query(contactUri, projection,
                    null, null, null);
            // If the cursor returned is valid, get the phone number
            if (cursor != null && cursor.moveToFirst()) {
                int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(numberIndex);*/

                resTextView.setText(cNumber);

                // Do something with the selected contact at contactUri
            }

        }


        public void selectContact (View view){
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, REQUEST_SELECT_CONTACT);
            }
        }

}
