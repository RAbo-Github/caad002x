package com.example.ratech.butterknifedemo_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void displayMessage(String msg) {
        TextView zoneMsg = (TextView) findViewById(R.id.textView);
        zoneMsg.setText(msg);
    }

    public void changeMsg (View view) {
        displayMessage("Button pressed!");
    }

}
