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
public class ConversionFromBinary extends AppCompatActivity {
    TextView textView;
    StringBuffer screenText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversion_ns_binary);
        screenText = new StringBuffer();
        textView = (TextView) findViewById(R.id.binaryInputTextView);
    }

    public void convertClicked(View v){
        Intent intent = new Intent();
        intent.setClass(ConversionFromBinary.this, ConvertTo.class);
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

    // .
    public void periodClicked(View v){
        screenText = screenText.append('.');
        textView.setText(textView.getText() + ".");
    }
}
