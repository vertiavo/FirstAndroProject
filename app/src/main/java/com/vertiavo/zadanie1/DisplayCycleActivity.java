package com.vertiavo.zadanie1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.sql.Timestamp;

public class DisplayCycleActivity extends Activity {

    public static final String LIFE_CYCLE_LOG = "LifeCycleLog";

    private String cycleLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_cycle);
        updateLog("onCreate");
    }

    public void onStart() {
        super.onStart();
        updateLog("onStart");
    }

    public void onRestart() {
        super.onRestart();
        updateLog("onRestart");
    }

    public void onResume() {
        super.onResume();
        updateLog("onResume");
    }

    public void onPause() {
        super.onPause();
        updateLog("onPause");
    }

    public void onStop() {
        super.onStop();
        updateLog("onStop");
    }

    public void onDestroy() {
        super.onDestroy();
        updateLog("onDestroy");
    }

    private void updateLog(String methodName) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Log.d(LIFE_CYCLE_LOG, timestamp.toString() + " " + methodName + "() called");

        cycleLog = rebuildLog(timestamp.toString() + " : " + methodName + "() called");
        updateTextView();
    }

    private String rebuildLog(String newLogLine) {
        StringBuilder sb = new StringBuilder();

        if (cycleLog != null) {
            sb.append(cycleLog);
            sb.append("\n");
        }
        sb.append(newLogLine);

        return sb.toString();
    }

    private void updateTextView() {
        TextView cycleView = findViewById(R.id.cycleView);
        cycleView.setText(cycleLog);
    }
}
