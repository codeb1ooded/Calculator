package com.example.megha.scientificcalculator.conversion_number_system;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.megha.scientificcalculator.Constants;
import com.example.megha.scientificcalculator.R;

/**
 * Created by megha on 10/7/16.
 */
public class ConvertTo extends AppCompatActivity {

    // 0:binary, 1:octal, 2:decimal 3:hexadecimal
    int numberSystem;
    StringBuffer number;
    String number1;
    String convertFrom;
    TextView textView;
    StringBuffer binary, octal, decimal, hexadecimal;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convert_to_activity);
        Intent intent = getIntent();
        convertFrom = intent.getStringExtra(Constants.conversionNumberSystem);
        number1 = intent.getStringExtra(Constants.digitToConvert);
        textView = (TextView) findViewById(R.id.convertedTextView);
        if(convertFrom == Constants.convertBinary)
            numberSystem = 0;
        number = new StringBuffer(number1);
        binary = new StringBuffer();
        octal = new StringBuffer();
        decimal = new StringBuffer();
        hexadecimal = new StringBuffer();
        toBinary();
        toOctal();
        toDecimal();
        toHexadecimal();
    }

    public void toBinary(){
        if(numberSystem == 0){
            binary = number;
        } else if(numberSystem == 1){

        } else if(numberSystem == 2){

        } else if(numberSystem == 3){

        }
    }
    public void toOctal(){
        if(numberSystem == 0){
            binaryToOctal();
        } else if(numberSystem == 1){
            octal = number;
        } else if(numberSystem == 2){

        } else if(numberSystem == 3){

        }
    }
    public void toDecimal(){
        if(numberSystem == 0){
            binaryToDecimal();
        } else if(numberSystem == 1){

        } else if(numberSystem == 2){
            decimal = number;
        } else if(numberSystem == 3){

        }
    }
    public void toHexadecimal(){
        if(numberSystem == 0){
            binaryToHexadecimal();
        } else if(numberSystem == 1){

        } else if(numberSystem == 2){

        } else if(numberSystem == 3){
            hexadecimal = number;
        }
    }
    public void binaryToOctal(){
        int locPer = number.length();
        for(int i=0; i<number.length(); i++){
            if ( number.charAt(i) == '.'){
                locPer = i;
                break;
            }
        }
        for(int i= locPer-1; i>=0;){
            int n;
            if(i>=2){
                int first = (int) (number.charAt(i--)) -48;
                int second = (int) (number.charAt(i--)) -48;
                int third = (int) (number.charAt(i--)) -48;
                n = first*1 +second*2 + third*4;
            }else if(i==1){
                int first = (int) (number.charAt(i--)) -48;
                int second = (int) (number.charAt(i--)) -48;
                n = first*1 +second*2;
            }else {
                int first = (int) (number.charAt(i--)) -48;
                n = first*1;
            }
            octal = new StringBuffer(n + octal.toString());
        }
        if(locPer != number.length())
            octal = octal.append('.');
        int len = number.length();
        for(int i= locPer+1; i<len;){
            int n;
            if(len-i >= 3){
                int first = (int) (number.charAt(i++)) -48;
                int second = (int) (number.charAt(i++)) -48;
                int third = (int) (number.charAt(i++)) -48;
                n = first*4 +second*2 + third*1;
            }else if(len-i == 2){
                int first = (int) (number.charAt(i++)) -48;
                int second = (int) (number.charAt(i++)) -48;
                n = first*4 +second*2;
            }else {
                int first = (int) (number.charAt(i++)) -48;
                n = first*4;
            }
            octal = octal.append(n);
        }
    }
    public void binaryToHexadecimal(){
        int locPer = number.length();
        for(int i=0; i<number.length(); i++){
            if ( number.charAt(i) == '.'){
                locPer = i;
                break;
            }
        }
        for(int i= locPer-1; i>=0;){
            int n;
            if(i >= 3){
                int first = (int) (number.charAt(i--)) -48;
                int second = (int) (number.charAt(i--)) -48;
                int third = (int) (number.charAt(i--)) -48;
                int fourth = (int) (number.charAt(i--)) -48;
                n = first*1 +second*2 + third*4 + fourth*8;
            } else if(i >= 2){
                int first = (int) (number.charAt(i--)) -48;
                int second = (int) (number.charAt(i--)) -48;
                int third = (int) (number.charAt(i--)) -48;
                n = first*1 +second*2 + third*4;
            } else if(i == 1){
                int first = (int) (number.charAt(i--)) -48;
                int second = (int) (number.charAt(i--)) -48;
                n = first*1 +second*2;
            }else {
                int first = (int) (number.charAt(i--)) -48;
                n = first*1;
            }
            if(n == 10)
                octal = new StringBuffer('A' + octal.toString());
            else if(n == 11)
                octal = new StringBuffer('B' + octal.toString());
            else if(n == 12)
                octal = new StringBuffer('C' + octal.toString());
            else if(n == 13)
                octal = new StringBuffer('D' + octal.toString());
            else if(n == 14)
                octal = new StringBuffer('E' + octal.toString());
            else if(n == 15)
                octal = new StringBuffer('F' + octal.toString());
            else
                octal = new StringBuffer(n + octal.toString());
        }
        if(locPer != number.length())
            octal = octal.append('.');
        int len = number.length();
        for(int i= locPer+1; i<len;){
            int n;
            if(len-i >= 4){
                int first = (int) (number.charAt(i++)) -48;
                int second = (int) (number.charAt(i++)) -48;
                int third = (int) (number.charAt(i++)) -48;
                int fourth = (int) (number.charAt(i++)) -48;
                n = first*8 +second*4 + third*2 + fourth*1;
            } else if(len-i >= 3){
                int first = (int) (number.charAt(i++)) -48;
                int second = (int) (number.charAt(i++)) -48;
                int third = (int) (number.charAt(i++)) -48;
                n = first*4 +second*2 + third*1;
            } else if(len-i == 2){
                int first = (int) (number.charAt(i++)) -48;
                int second = (int) (number.charAt(i++)) -48;
                n = first*4 +second*2;
            } else {
                int first = (int) (number.charAt(i++)) -48;
                n = first*4;
            }
            if(n == 10)
                octal = octal.append('A');
            else if(n == 11)
                octal = octal.append('B');
            else if(n == 12)
                octal = octal.append('C');
            else if(n == 13)
                octal = octal.append('D');
            else if(n == 14)
                octal = octal.append('E');
            else if(n == 15)
                octal = octal.append('F');
            else
                octal = octal.append(n);
        }
    }

    public void binaryToDecimal(){
        int locPer = number.length();
        for(int i=0; i<number.length(); i++){
            if ( number.charAt(i) == '.'){
                locPer = i;
                break;
            }
        }
        double n =0;
        int c=0;
        for(int i= locPer-1; i>=0; i--){
            int v = (int) number.charAt(i) -48;
            n = n +  v*Math.pow(2, c);
            c++;
        }
        c = -1;
        for(int i= locPer+1; i<number.length(); i++){
            int v = (int) number.charAt(i) -48;
            n = n +  v*Math.pow(2, c);
            c--;
        }
        decimal = decimal.append(n);
        Log.i("tag", decimal.toString());
    }
}
