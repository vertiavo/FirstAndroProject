package com.vertiavo.zadanie1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
        if (editString.isEmpty()) {
            textView.setText(R.string.no_text_inserted);
        } else {
            String editTextString = getString(R.string.edit_string_result) + editString;
            textView.setText(editTextString);
        }

        final int INITIAL_ZERO = 0;
        final boolean INITIAL_FALSE = false;

        int progress = previousIntent.getIntExtra(MainActivity.PROGRESS, INITIAL_ZERO);
        TextView seekView = findViewById(R.id.seekResult);
        String seekString = getString(R.string.seekbar_result) + String.valueOf(progress);
        seekView.setText(seekString);

        boolean checkBoxBoolean = previousIntent.getBooleanExtra(MainActivity.CHECKED, INITIAL_FALSE);
        TextView checkView = findViewById(R.id.checkResult);
        String checkString = getString(R.string.checkbox_result) + String.valueOf(checkBoxBoolean);
        checkView.setText(checkString);

        float rating = previousIntent.getFloatExtra(MainActivity.RATING, INITIAL_ZERO);
        TextView ratingView = findViewById(R.id.ratingResult);
        String ratingString = getString(R.string.rating_result) + String.valueOf(rating);
        ratingView.setText(ratingString);

        int radioId = previousIntent.getIntExtra(MainActivity.CHECKED_RADIO_BUTTON, INITIAL_ZERO);
        TextView radioView = findViewById(R.id.radioResult);
        if (radioId == -1) {
            radioView.setText(R.string.no_radio_result);
        } else {
            String radioString = getString(R.string.radio_result) + String.valueOf(radioId);
            radioView.setText(radioString);
        }
    }

    public void showCycles(View view) {
        Intent intent = new Intent(this, DisplayCycleActivity.class);

        startActivity(intent);
    }
}
