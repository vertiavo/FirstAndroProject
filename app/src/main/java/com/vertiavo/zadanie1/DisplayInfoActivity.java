package com.vertiavo.zadanie1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayInfoActivity extends Activity {

    private Intent previousIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);

        previousIntent = getIntent();

        fillTextViewsWithData();
    }

    private void fillTextViewsWithData() {
        String editString = previousIntent.getStringExtra(MainActivity.EDIT_STRING);
        TextView textView = findViewById(R.id.editResult);
        textView.setText(editString);

        int progress = previousIntent.getIntExtra(MainActivity.PROGRESS, 0);
        TextView seekView = findViewById(R.id.seekResult);
        seekView.setText(String.valueOf(progress));

        boolean checkBoxString = previousIntent.getBooleanExtra(MainActivity.CHECKED, false);
        TextView checkView = findViewById(R.id.checkResult);
        checkView.setText(String.valueOf(checkBoxString));

        float ratingString = previousIntent.getIntExtra(MainActivity.NUMSTARS, 0);
        TextView ratingView = findViewById(R.id.ratingResult);
        ratingView.setText(String.valueOf(ratingString));

        int radioString = previousIntent.getIntExtra(MainActivity.CHECKED_RADIO_BUTTON, 0);
        TextView radioView = findViewById(R.id.radioResult);
        radioView.setText(String.valueOf(radioString));
    }

    public void showCycles(View view) {
        Intent intent = new Intent(this, DisplayCycleActivity.class);

        ArrayList<String> cycleLog = previousIntent.getStringArrayListExtra(MainActivity.LIFE_CYCLE_LOG);
        intent.putStringArrayListExtra(MainActivity.LIFE_CYCLE_LOG, cycleLog);

        startActivity(intent);
    }
}
