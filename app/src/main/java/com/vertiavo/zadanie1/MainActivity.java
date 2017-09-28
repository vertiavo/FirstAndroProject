package com.vertiavo.zadanie1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;

public class MainActivity extends Activity {

    public static final String EDIT_STRING = "com.vertiavo.zadanie1.EDIT_STRING";
    public static final String PROGRESS = "com.vertiavo.zadanie1.PROGRESS";
    public static final String CHECKED = "com.vertiavo.zadanie1.CHECKED";
    public static final String RATING = "com.vertiavo.zadanie1.RATING";
    public static final String CHECKED_RADIO_BUTTON = "com.vertiavo.zadanie1.CHECKED_RADIO_BUTTON";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendInfo(View view) {
        Intent intent = new Intent(this, DisplayInfoActivity.class);

        EditText editText = findViewById(R.id.editText);
        String editString = editText.getText().toString();

        SeekBar seekBar = findViewById(R.id.seekBar);
        int progress = seekBar.getProgress();

        CheckBox checkBox = findViewById(R.id.checkBox);
        boolean checked = checkBox.isChecked();

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        float ratingStars = ratingBar.getRating();

        RadioGroup radioGroup = findViewById(R.id.radio);
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();

        intent.putExtra(EDIT_STRING, editString);
        intent.putExtra(PROGRESS, progress);
        intent.putExtra(CHECKED, checked);
        intent.putExtra(RATING, ratingStars);
        intent.putExtra(CHECKED_RADIO_BUTTON, checkedRadioButtonId);

        startActivity(intent);
    }
}
