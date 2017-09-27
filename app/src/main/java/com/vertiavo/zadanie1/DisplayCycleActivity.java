package com.vertiavo.zadanie1;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayCycleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_cycle);

        Intent intent = getIntent();
        ArrayList<String> cycleLog = intent.getStringArrayListExtra(MainActivity.LIFE_CYCLE_LOG);

        TextView cycles = findViewById(R.id.cycleView);

        StringBuilder sb = buildOutputFromCycleLog(cycleLog);

        cycles.setText(sb.toString());
    }

    private StringBuilder buildOutputFromCycleLog(ArrayList<String> cycleLog) {
        StringBuilder sb = new StringBuilder();
        for (String s : cycleLog) {
            sb.append(s);
            sb.append("\n");
        }
        return sb;
    }
}
