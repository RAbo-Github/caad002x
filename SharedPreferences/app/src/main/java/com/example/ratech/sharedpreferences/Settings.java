package com.example.ratech.sharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Settings extends AppCompatActivity {

    private float[] conversionValues = {100f, 0.001f, 39.3701f};
    private String[] conversionLabels = {"Centimeter", "Kilometer", "Inch"};
    private String[] shortconversionLabel = {"cm", "km", "in"};

    // View
    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        createRadioButton();
    }

    private void createRadioButton() {
        mRadioGroup = (RadioGroup) findViewById(R.id.rgConverterOptions);

        for (int i=0; i<conversionLabels.length; i++) {
            RadioButton rbutton = new RadioButton(this);
            rbutton.setText(getString(R.string.option, conversionLabels[i]));
            final float value = conversionValues[i];
            final String shortLabel = shortconversionLabel[i];
            // Listener
            rbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}
