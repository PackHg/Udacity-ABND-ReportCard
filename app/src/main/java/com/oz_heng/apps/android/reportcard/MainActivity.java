package com.oz_heng.apps.android.reportcard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final String EOL = "\n";
    private static final String COMMA = ", ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textview);
        String text = "";
        String error = "";

        ReportCard reportCard = new ReportCard(" A ", " B+ ", 80, 95);
        text = reportCard.toString() + EOL;

        reportCard.setEnglishGrade("   E-  ");
        reportCard.setMathGrade("  C+   ");
        reportCard.setHistoryGrade(50.67);
        reportCard.setBiologyGrade(09.13);
        text = text + EOL + reportCard.getEnglishGrade() + COMMA
                + reportCard.getMathGrade() + COMMA
                + reportCard.getHistoryGrade() + COMMA
                + reportCard.getBiologyGrade() + EOL;

        try {
            reportCard.setEnglishGrade("Z");
        } catch (IllegalArgumentException e) {
             error = e.getMessage();
        } finally {
            text = text + EOL + error + EOL;
        }

        try {
            reportCard.setMathGrade("E -");
        } catch (IllegalArgumentException e) {
             error = e.getMessage();
        } finally {
            text = text + EOL + error + EOL;
        }

        try {
            reportCard.setHistoryGrade(-1.0);
        } catch (IllegalArgumentException e) {
             error = e.getMessage();
        } finally {
            text = text + EOL + error + EOL;
        }

       try {
            reportCard.setBiologyGrade(100.1);
        } catch (IllegalArgumentException e) {
             error = e.getMessage();
        } finally {
            text = text + EOL + error + EOL;
        }

        text = text + EOL + reportCard.toString();

        textView.setText(text);

    }
}
