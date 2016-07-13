package com.example.megha.scientificcalculator.conversion_number_system;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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
        if(convertFrom.equals(Constants.convertBinary))
            numberSystem = 0;
        if(convertFrom.equals(Constants.convertOctal))
            numberSystem = 1;
        if(convertFrom.equals(Constants.convertDecimal))
            numberSystem = 2;
        if(convertFrom.equals(Constants.convertHexadecimal))
            numberSystem = 3;
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

    public void binaryClicked(View v){
        textView.setText(binary);
    }
    public void octalClicked(View v){
        textView.setText(octal);
    }
    public void decimalClicked(View v){
        textView.setText(decimal);
    }
    public void hexadecimalClicked(View v){
        textView.setText(hexadecimal);
    }

    private void toBinary(){
        if(numberSystem == 0){
            binary = number;
        } else if(numberSystem == 1){
            binary = octalToBinary(number);
        } else if(numberSystem == 2){
            binary = decimalToBinary(number);
        } else if(numberSystem == 3){
            binary = hexadecimalToBinary(number);
        }
    }
    private void toOctal(){
        if(numberSystem == 0){
            octal = binaryToOctal(number);
        } else if(numberSystem == 1){
            octal = number;
        } else if(numberSystem == 2){
            octal = decimalToOctal(number);
        } else if(numberSystem == 3){
            octal = hexadecimalToOctal(number);
        }
    }
    private void toDecimal(){
        if(numberSystem == 0){
            decimal = binaryToDecimal(number);
        } else if(numberSystem == 1){
            decimal = octalToDecimal(number);
        } else if(numberSystem == 2){
            decimal = number;
        } else if(numberSystem == 3){
            decimal = hexadecimalToDecimal(number);
        }
    }
    private void toHexadecimal(){
        if(numberSystem == 0){
            hexadecimal = binaryToHexadecimal(number);
        } else if(numberSystem == 1){
            hexadecimal = octalToHexadecimal(number);
        } else if(numberSystem == 2){
            hexadecimal = decimalToHexadecimal(number);
        } else if(numberSystem == 3){
            hexadecimal = number;
        }
    }

    private StringBuffer binaryToOctal( StringBuffer num){
        StringBuffer stringBuffer = new StringBuffer();
        int locPer = num.length();
        for(int i=0; i<num.length(); i++){
            if ( num.charAt(i) == '.'){
                locPer = i;
                break;
            }
        }
        for(int i= locPer-1; i>=0;){
            int n;
            if(i>=2){
                int first = (int) (num.charAt(i--)) -48;
                int second = (int) (num.charAt(i--)) -48;
                int third = (int) (num.charAt(i--)) -48;
                n = first*1 +second*2 + third*4;
            }else if(i==1){
                int first = (int) (num.charAt(i--)) -48;
                int second = (int) (num.charAt(i--)) -48;
                n = first*1 +second*2;
            }else {
                int first = (int) (num.charAt(i--)) -48;
                n = first*1;
            }
            stringBuffer = new StringBuffer(n + stringBuffer.toString());
        }
        if(locPer != num.length())
            stringBuffer = stringBuffer.append('.');
        int len = num.length();
        for(int i= locPer+1; i<len;){
            int n;
            if(len-i >= 3){
                int first = (int) (num.charAt(i++)) -48;
                int second = (int) (num.charAt(i++)) -48;
                int third = (int) (num.charAt(i++)) -48;
                n = first*4 +second*2 + third*1;
            }else if(len-i == 2){
                int first = (int) (num.charAt(i++)) -48;
                int second = (int) (num.charAt(i++)) -48;
                n = first*4 +second*2;
            }else {
                int first = (int) (num.charAt(i++)) -48;
                n = first*4;
            }
            stringBuffer = stringBuffer.append(n);
        }
        return stringBuffer;
    }
    private StringBuffer binaryToHexadecimal(StringBuffer num){
        StringBuffer stringBuffer = new StringBuffer();
        int locPer = num.length();
        for(int i=0; i<num.length(); i++){
            if ( num.charAt(i) == '.'){
                locPer = i;
                break;
            }
        }
        for(int i= locPer-1; i>=0;){
            int n;
            if(i >= 3){
                int first = (int) (num.charAt(i--)) -48;
                int second = (int) (num.charAt(i--)) -48;
                int third = (int) (num.charAt(i--)) -48;
                int fourth = (int) (num.charAt(i--)) -48;
                n = first*1 +second*2 + third*4 + fourth*8;
            } else if(i >= 2){
                int first = (int) (num.charAt(i--)) -48;
                int second = (int) (num.charAt(i--)) -48;
                int third = (int) (num.charAt(i--)) -48;
                n = first*1 +second*2 + third*4;
            } else if(i == 1){
                int first = (int) (num.charAt(i--)) -48;
                int second = (int) (num.charAt(i--)) -48;
                n = first*1 +second*2;
            }else {
                int first = (int) (num.charAt(i--)) -48;
                n = first*1;
            }
            if(n == 10)
                stringBuffer = new StringBuffer('A' + stringBuffer.toString());
            else if(n == 11)
                stringBuffer = new StringBuffer('B' + stringBuffer.toString());
            else if(n == 12)
                stringBuffer = new StringBuffer('C' + stringBuffer.toString());
            else if(n == 13)
                stringBuffer = new StringBuffer('D' + stringBuffer.toString());
            else if(n == 14)
                stringBuffer = new StringBuffer('E' + stringBuffer.toString());
            else if(n == 15)
                stringBuffer = new StringBuffer('F' + stringBuffer.toString());
            else
                stringBuffer = new StringBuffer(n + stringBuffer.toString());
        }
        if(locPer != num.length())
            stringBuffer = stringBuffer.append('.');
        int len = num.length();
        for(int i= locPer+1; i<len;){
            int n;
            if(len-i >= 4){
                int first = (int) (num.charAt(i++)) -48;
                int second = (int) (num.charAt(i++)) -48;
                int third = (int) (num.charAt(i++)) -48;
                int fourth = (int) (num.charAt(i++)) -48;
                n = first*8 +second*4 + third*2 + fourth*1;
            } else if(len-i >= 3){
                int first = (int) (num.charAt(i++)) -48;
                int second = (int) (num.charAt(i++)) -48;
                int third = (int) (num.charAt(i++)) -48;
                n = first*8 +second*4 + third*2;
            } else if(len-i == 2){
                int first = (int) (num.charAt(i++)) -48;
                int second = (int) (num.charAt(i++)) -48;
                n = first*8 +second*4;
            } else {
                int first = (int) (num.charAt(i++)) -48;
                n = first*8;
            }
            if(n == 10)
                stringBuffer = stringBuffer.append('A');
            else if(n == 11)
                stringBuffer = stringBuffer.append('B');
            else if(n == 12)
                stringBuffer = stringBuffer.append('C');
            else if(n == 13)
                stringBuffer = stringBuffer.append('D');
            else if(n == 14)
                stringBuffer = stringBuffer.append('E');
            else if(n == 15)
                stringBuffer = stringBuffer.append('F');
            else
                stringBuffer = stringBuffer.append(n);
        }
        return stringBuffer;
    }
    private StringBuffer binaryToDecimal(StringBuffer num){
        StringBuffer stringBuffer = new StringBuffer();
        int locPer = num.length();
        for(int i=0; i<num.length(); i++){
            if ( num.charAt(i) == '.'){
                locPer = i;
                break;
            }
        }
        double n =0;
        int c=0;
        for(int i= locPer-1; i>=0; i--){
            int v = (int) num.charAt(i) -48;
            n = n +  v*Math.pow(2, c);
            c++;
        }
        c = -1;
        for(int i= locPer+1; i<num.length(); i++){
            int v = (int) num.charAt(i) -48;
            n = n +  v*Math.pow(2, c);
            c--;
        }
        stringBuffer = stringBuffer.append(n);
        return stringBuffer;
    }

    private StringBuffer octalToBinary(StringBuffer num){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0; i<num.length(); i++){
            if(num.charAt(i) != '.'){
                String abc = octalInBinary(num.charAt(i));
                stringBuffer = stringBuffer.append(abc);
            } else
                stringBuffer = stringBuffer.append('.');
        }
        return stringBuffer;
    }
    private StringBuffer octalToDecimal(StringBuffer num){
        StringBuffer stringBuffer = new StringBuffer();
        int locPer = num.length();
        for(int i=0; i<num.length(); i++){
            if ( num.charAt(i) == '.'){
                locPer = i;
                break;
            }
        }
        double n =0;
        int c=0;
        for(int i= locPer-1; i>=0; i--){
            int v = (int) num.charAt(i) -48;
            n = n +  v*Math.pow(8, c);
            c++;
        }
        c = -1;
        for(int i= locPer+1; i<num.length(); i++){
            int v = (int) num.charAt(i) -48;
            n = n +  v*Math.pow(8, c);
            c--;
        }
        stringBuffer = stringBuffer.append(n);
        return stringBuffer;
    }
    private StringBuffer octalToHexadecimal(StringBuffer num){
        StringBuffer stringBuffer = octalToBinary(num);
        stringBuffer = binaryToHexadecimal(stringBuffer);
        return stringBuffer;
    }

    private StringBuffer hexadecimalToBinary(StringBuffer num){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0; i<num.length(); i++){
            if(num.charAt(i) != '.'){
                String abc = hexadecimalInBinary(num.charAt(i));
                stringBuffer = stringBuffer.append(abc);
            } else
                stringBuffer = stringBuffer.append('.');
        }
        return stringBuffer;
    }
    private StringBuffer hexadecimalToOctal(StringBuffer num){
        StringBuffer stringBuffer = hexadecimalToBinary(num);
        stringBuffer = binaryToOctal(stringBuffer);
        return stringBuffer;
    }
    private StringBuffer hexadecimalToDecimal(StringBuffer num){
        StringBuffer stringBuffer = new StringBuffer();
        int locPer = num.length();
        for(int i=0; i<num.length(); i++){
            if ( num.charAt(i) == '.'){
                locPer = i;
                break;
            }
        }
        double n =0;
        int c=0;
        for(int i= locPer-1; i>=0; i--){
            int v;
            if(num.charAt(i) == 'A')    v = 10;
            else if(num.charAt(i) == 'B')    v = 11;
            else if(num.charAt(i) == 'C')    v = 12;
            else if(num.charAt(i) == 'D')    v = 13;
            else if(num.charAt(i) == 'E')    v = 14;
            else if(num.charAt(i) == 'F')    v = 15;
            else    v = (int) num.charAt(i) -48;
            n = n +  v*Math.pow(16, c);
            c++;
        }
        c = -1;
        for(int i= locPer+1; i<num.length(); i++){
            int v;
            if(num.charAt(i) == 'A')    v = 10;
            else if(num.charAt(i) == 'B')    v = 11;
            else if(num.charAt(i) == 'C')    v = 12;
            else if(num.charAt(i) == 'D')    v = 13;
            else if(num.charAt(i) == 'E')    v = 14;
            else if(num.charAt(i) == 'F')    v = 15;
            else    v = (int) num.charAt(i) -48;
            n = n +  v*Math.pow(16, c);
            c--;
        }
        stringBuffer = stringBuffer.append(n);
        return stringBuffer;
    }

    private StringBuffer decimalToBinary(StringBuffer num){
        /* TODO */
        StringBuffer stringBuffer = new StringBuffer();
        return stringBuffer;
    }
    private StringBuffer decimalToOctal(StringBuffer num){
        /* TODO */
        StringBuffer stringBuffer = new StringBuffer();
        return stringBuffer;
    }
    private StringBuffer decimalToHexadecimal(StringBuffer num){
        /* TODO */
        StringBuffer stringBuffer = new StringBuffer();
        return stringBuffer;
    }

    private String octalInBinary(char num){
        if(num == '0')
            return "000";
        else if(num == '1')
            return "001";
        else if(num == '2')
            return "010";
        else if(num == '3')
            return "011";
        else if(num == '4')
            return "100";
        else if(num == '5')
            return "101";
        else if(num == '6')
            return "110";
        else
            return "111";
    }
    private String hexadecimalInBinary(char num){
        if(num == '0')
            return "0000";
        else if(num == '1')
            return "0001";
        else if(num == '2')
            return "0010";
        else if(num == '3')
            return "0011";
        else if(num == '4')
            return "=100";
        else if(num == '5')
            return "0101";
        else if(num == '6')
            return "0110";
        else if(num == '7')
            return "0111";
        else if(num == '8')
            return "1000";
        else if(num == '9')
            return "1001";
        else if(num == 'A')
            return "1010";
        else if(num == 'B')
            return "1011";
        else if(num == 'C')
            return "1100";
        else if(num == 'D')
            return "1101";
        else if(num == 'E')
            return "1110";
        else
            return "1111";
    }
}
