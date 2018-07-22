package com.example.ratech.sharedpreferences;

import android.content.SharedPreferences;
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
                    setActualUnits(value, shortLabel);
                }
            });
            mRadioGroup.addView(rbutton);

            // Selected
            if (value == getActualUnits()) {
                rbutton.setChecked(true);
            }
        }
    }

    private float getActualUnits() {
        // Shared preferences
        SharedPreferences mSharedPreferences = getSharedPreferences("ActualUnits", MODE_PRIVATE);
        // Retrieve a value
        return mSharedPreferences.getFloat("Unit", 100f); // 100f is a default value for cm
    }

    private void setActualUnits(float value, String shortLabel) {
        // Shared preferences
        SharedPreferences mSharedPreferences = getSharedPreferences("ActualUnits", MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        // Store values in Pairs (KEY, VALUE)
        mEditor.putFloat("Unit", value);
        mEditor.putString("Label", shortLabel);
        // Apply the changes
        mEditor.apply();

    }


}
