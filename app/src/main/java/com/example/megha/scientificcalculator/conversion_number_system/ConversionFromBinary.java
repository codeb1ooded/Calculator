package com.example.megha.scientificcalculator.conversion_number_system;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

    boolean isValid(){
        boolean firstPeriod = false;
        for(int i=0; i<screenText.length(); i++){
            if(screenText.charAt(i) == '.'){
                if(firstPeriod)
                    return false;
                firstPeriod = true;
            }if(screenText.charAt(i) == '.' && i==0){
                return false;
            }
        }
        return true;
    }

    public void convertClicked(View v){
        if(screenText.length() == 0){
            Toast.makeText(ConversionFromBinary.this, "Please enter valid binary number to proceed", Toast.LENGTH_SHORT).show();
        } else if(isValid()){
            Intent intent = new Intent();
            intent.setClass(ConversionFromBinary.this, ConvertTo.class);
            startActivity(intent);
        } else {
            Toast.makeText(ConversionFromBinary.this, "Please enter valid binary number to proceed", Toast.LENGTH_SHORT).show();
        }
    }

    // CLEAR ALL
    public void clearAllClicked(View v){
        screenText = new StringBuffer();
        textView.setText("");
    }

    // CLEAR LAST
    public void clearClicked(View v){
        if(screenText.length() > 1) {
            screenText = screenText.delete(screenText.length() - 1, screenText.length());
            textView.setText(screenText);
        }
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
