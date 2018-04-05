package com.example.ratech.contactlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView contactFirstName = (TextView) findViewById(R.id.contact_firstName);
        TextView contactLastName = (TextView) findViewById(R.id.contact_lastName);
        TextView contactEmail = (TextView) findViewById(R.id.textViewEmail);
        TextView contactPhoneNumber = (TextView) findViewById(R.id.textViewPhoneNumber);

        Bundle b = new Bundle();
        b = getIntent().getExtras();

        //TODO: get the rest of contact parameters
        String firstName = b.getString("firstName");
        String lastName = b.getString("lastName");
        String email = b.getString("email");
        int phoneNumber = b.getInt("phoneNumber");

        //TODO: once you have all the values for a contact add them to the views
        contactFirstName.setText(firstName);
        contactLastName.setText(lastName);
        contactEmail.setText(email);
        //contactPhoneNumber.setText(String.valueOf(phoneNumber));
        contactPhoneNumber.setText(String.format("%010d", phoneNumber));
    }
}
