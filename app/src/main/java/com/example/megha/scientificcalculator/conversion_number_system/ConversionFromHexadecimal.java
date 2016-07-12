package com.example.megha.scientificcalculator.conversion_number_system;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.megha.scientificcalculator.Constants;
import com.example.megha.scientificcalculator.R;

import java.io.Serializable;

/**
 * Created by megha on 24/6/16.
 */
public class ConversionFromHexadecimal extends AppCompatActivity {
    TextView textView;
    StringBuffer screenText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversion_ns_hexadecimal);
        screenText = new StringBuffer();
        textView = (TextView) findViewById(R.id.hexadecimalInputTextView);
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
            Toast.makeText(ConversionFromHexadecimal.this, "Please enter valid hexadecimal number to proceed", Toast.LENGTH_SHORT).show();
        } else if(isValid()){
            Intent intent = new Intent();
            intent.setClass(ConversionFromHexadecimal.this, ConvertTo.class);
            intent.putExtra(Constants.digitToConvert, (Serializable) screenText);
            intent.putExtra(Constants.conversionNumberSystem, Constants.convertHexadecimal);
            startActivity(intent);
        } else {
            Toast.makeText(ConversionFromHexadecimal.this, "Please enter valid hexadecimal number to proceed", Toast.LENGTH_SHORT).show();
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

    // .
    public void periodClicked(View v){
        screenText = screenText.append('.');
        textView.setText(textView.getText() + ".");
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

    // A
    public void aClicked(View v){
        screenText = screenText.append('A');
        textView.setText(textView.getText() + "A");
    }

    // B
    public void bClicked(View v){
        screenText = screenText.append('B');
        textView.setText(textView.getText() + "B");
    }

    // C
    public void cClicked(View v){
        screenText = screenText.append('C');
        textView.setText(textView.getText() + "C");
    }

    // D
    public void dClicked(View v){
        screenText = screenText.append('D');
        textView.setText(textView.getText() + "D");
    }

    // E
    public void eClicked(View v){
        screenText = screenText.append('E');
        textView.setText(textView.getText() + "E");
    }

    // F
    public void fClicked(View v){
        screenText = screenText.append('F');
        textView.setText(textView.getText() + "F");
    }
}
