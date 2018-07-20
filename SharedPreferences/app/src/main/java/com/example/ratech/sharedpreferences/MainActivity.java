package com.example.ratech.sharedpreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView tvActualUnits;
    private TextView tvResult;
    private EditText etMeter;
    private Button bnConverter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the views items
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        tvActualUnits = (TextView) findViewById(R.id.tvActualUnits);
        tvResult = (TextView) findViewById(R.id.tvResult);
        etMeter = (EditText) findViewById(R.id.etMeters);
        bnConverter = (Button) findViewById(R.id.btConverter);

        // Sets the Toolbar to act as the ActionBar for this Activity window.
        setSupportActionBar(mToolbar);

        bnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Convert(Float.parseFloat(etMeter.getText().toString()));
            }
        });

    }

    private void Convert(float value) {
        // Implement Later
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            startActivity(new Intent(this, Settings.class));
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }
}
