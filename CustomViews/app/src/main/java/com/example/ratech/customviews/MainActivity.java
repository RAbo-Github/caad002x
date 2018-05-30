package com.example.ratech.customviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ratech.customviews.views.MyButton;

public class MainActivity extends AppCompatActivity {

    MyButton mbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbutton = (MyButton) findViewById(R.id.myButton);

        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Custom Button! :D", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
