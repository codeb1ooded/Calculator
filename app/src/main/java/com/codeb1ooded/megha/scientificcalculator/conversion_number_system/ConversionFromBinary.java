package com.codeb1ooded.megha.scientificcalculator.conversion_number_system;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.codeb1ooded.megha.scientificcalculator.Constants;
import com.codeb1ooded.megha.scientificcalculator.R;

/**
 * Created by megha on 24/6/16.
 */
public class ConversionFromBinary extends AppCompatActivity implements Constants{

    TextView inputTextView, outputTextView;
    StringBuffer screenText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversion_ns_binary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Binary");
        screenText = new StringBuffer();
        inputTextView = (TextView) findViewById(R.id.binary_input);
        outputTextView = (TextView) findViewById(R.id.output_for_binary);
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
            Toast.makeText(this, "Can't convert invalid binary number", Toast.LENGTH_SHORT).show();
        } else if(isValid()){
            ConversionFunctions con = new ConversionFunctions(convertBinary, new StringBuffer(screenText));
            switch (v.getId()){
                case R.id.to_binary: outputTextView.setText(con.getBinary());
                    break;
                case R.id.to_octal: outputTextView.setText(con.getOctal());
                    break;
                case R.id.to_decimal: outputTextView.setText(con.getDecimal());
                    break;
                case R.id.to_hexadecimal: outputTextView.setText(con.getHexadecimal());
                    break;
            }
        } else {
            Toast.makeText(this, "Can't convert invalid binary number", Toast.LENGTH_SHORT).show();
        }
    }

    // CLEAR ALL
    public void clearAllClicked(View v){
        screenText = new StringBuffer();
        inputTextView.setText("");
    }

    // CLEAR LAST
    public void clearClicked(View v){
        if(screenText.length() > 1) {
            screenText = screenText.delete(screenText.length() - 1, screenText.length());
            inputTextView.setText(screenText);
        }
    }

    // 0
    public void zeroClicked(View v){
        screenText = screenText.append('0');
        inputTextView.setText(inputTextView.getText() + "0");
    }

    // 1
    public void oneClicked(View v){
        screenText = screenText.append('1');
        inputTextView.setText(inputTextView.getText() + "1");
    }

    // .
    public void periodClicked(View v){
        screenText = screenText.append('.');
        inputTextView.setText(inputTextView.getText() + ".");
    }
}
