package com.example.megha.scientificcalculator.conversion_number_system;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.megha.scientificcalculator.R;

/**
 * Created by megha on 24/6/16.
 */
public class ConversionFromOctal extends AppCompatActivity {
    TextView textView;
    StringBuffer screenText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversion_ns_octal);
        screenText = new StringBuffer();
        textView = (TextView) findViewById(R.id.octalInputTextView);
    }

    public void convertClicked(View v){
        Intent intent = new Intent();
        intent.setClass(ConversionFromOctal.this, ConvertTo.class);
        startActivity(intent);
    }

    // 0
    public void zeroClicked(View v){
        screenText = screenText.append('0');
        textView.setText(textView.getText() + "0");
    }

    // 1
    public void oneClicked(View v){
        screenText = screenText.append('1');
        textView.setText(textView.getText() + "1");
    }

    // 2
    public void twoClicked(View v){
        screenText = screenText.append('2');
        textView.setText(textView.getText() + "2");
    }

    // 3
    public void threeClicked(View v){
        screenText = screenText.append('3');
        textView.setText(textView.getText() + "3");
    }

    // 4
    public void fourClicked(View v){
        screenText = screenText.append('4');
        textView.setText(textView.getText() + "4");
    }

    // 5
    public void fiveClicked(View v){
        screenText = screenText.append('5');
        textView.setText(textView.getText() + "5");
    }

    // 6
    public void sixClicked(View v){
        screenText = screenText.append('6');
        textView.setText(textView.getText() + "6");
    }

    // 7
    public void sevenClicked(View v){
        screenText = screenText.append('7');
        textView.setText(textView.getText() + "7");
    }

    // .
    public void periodClicked(View v){
        screenText = screenText.append('.');
        textView.setText(textView.getText() + ".");
    }
}
