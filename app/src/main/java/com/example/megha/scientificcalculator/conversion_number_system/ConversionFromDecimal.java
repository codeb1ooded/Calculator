package com.example.megha.scientificcalculator.conversion_number_system;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.megha.scientificcalculator.Constants;
import com.example.megha.scientificcalculator.R;

import java.io.Serializable;

/**
 * Created by megha on 24/6/16.
 */
public class ConversionFromDecimal extends AppCompatActivity {
    TextView textView;
    StringBuffer screenText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversion_ns_decimal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle("Decimal");
        screenText = new StringBuffer();
        textView = (TextView) findViewById(R.id.decimalInputTextView);
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
            Toast.makeText(ConversionFromDecimal.this, "Please enter valid decimal number to proceed", Toast.LENGTH_SHORT).show();
        } else if(isValid()){
            Intent intent = new Intent();
            intent.setClass(ConversionFromDecimal.this, ConvertTo.class);
            intent.putExtra(Constants.digitToConvert, (Serializable) screenText);
            intent.putExtra(Constants.conversionNumberSystem, Constants.convertDecimal);
            startActivity(intent);
        } else {
            Toast.makeText(ConversionFromDecimal.this, "Please enter valid decimal number to proceed", Toast.LENGTH_SHORT).show();
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

    // 8
    public void eightClicked(View v){
        screenText = screenText.append('8');
        textView.setText(textView.getText() + "8");
    }

    // 9
    public void nineClicked(View v){
        screenText = screenText.append('9');
        textView.setText(textView.getText() + "9");
    }
}
