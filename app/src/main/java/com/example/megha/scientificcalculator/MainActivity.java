package com.example.megha.scientificcalculator;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.megha.scientificcalculator.Fragments.AdvancedOperations;
import com.example.megha.scientificcalculator.Fragments.BasicOperations;
import com.example.megha.scientificcalculator.Fragments.ScientificOperations;
import com.example.megha.scientificcalculator.conversion_number_system.ConversionActivityNS;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
    Button bPlus, bMinus, bMultiply, bDivide, bEqual, bPeriod;
    Button bSin, bCos, bTan, bLog10, bNaturalLog, bExp, bSquareRoot, bPower, bSquare, bOpenBracket, bCloseBracket, bFactorial;
    Button bSinInv, bCosInv, bTanIv, bFloor, bCeil, bPi, bMax, bMin, bComma, bToDegrees, bToRadians;
    TextView textView;
    StringBuffer screenText;
    Stack stackScreen;
    boolean numberInput, periodDone, numAfterPeriod;
    ArrayList<String> infix;

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Home");
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        initialise();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_conversion_number_system) {
            Intent i = new Intent();
            i.setClass(MainActivity.this, ConversionActivityNS.class);
            startActivity(i);
        }

        return true;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            Fragment fragment;
            switch(position){
                case 0:
                    fragment = new BasicOperations();
                    break;
                case 1:
                    fragment = new ScientificOperations();
                    break;
                case 2:
                    fragment = new AdvancedOperations();
                    break;
                default:
                    fragment = new BasicOperations();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Basic";
                case 1:
                    return "Scientific";
                case 2:
                    return "Advanced";
            }
            return null;
        }
    }

    public void initialise(){
        screenText = new StringBuffer();
        textView = (TextView) findViewById(R.id.mainActivityTextView);
        stackScreen = new Stack();
        numberInput = false;
        periodDone = false;
        numAfterPeriod = false;
        infix = new ArrayList<>();
        infix.add(OperatorParameters.bracketopen);

        b0 = (Button) findViewById(R.id.button0);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);

        bPlus = (Button) findViewById(R.id.buttonPlus);
        bMinus = (Button) findViewById(R.id.buttonMinus);
        bMultiply = (Button) findViewById(R.id.buttonMultiply);
        bDivide = (Button) findViewById(R.id.buttonDivide);
        bEqual = (Button) findViewById(R.id.buttonEqual);
        bPeriod = (Button) findViewById(R.id.buttonPeriod);

        bSin = (Button) findViewById(R.id.button1s);
        bCos = (Button) findViewById(R.id.button2s);
        bTan = (Button) findViewById(R.id.button3s);
        bLog10 = (Button) findViewById(R.id.button4s);
        bExp = (Button) findViewById(R.id.button5s);
        bNaturalLog = (Button) findViewById(R.id.button6s);
        bSquareRoot = (Button) findViewById(R.id.button7s);
        bPower = (Button) findViewById(R.id.button8s);
        bSquare = (Button) findViewById(R.id.button9s);
        bOpenBracket = (Button) findViewById(R.id.button10s);
        bCloseBracket = (Button) findViewById(R.id.button11s);
        bFactorial = (Button) findViewById(R.id.button12s);

        bSinInv = (Button) findViewById(R.id.button1a);
        bCosInv = (Button) findViewById(R.id.button2a);
        bTanIv = (Button) findViewById(R.id.button3a);
        bFloor = (Button) findViewById(R.id.button4a);
        bCeil = (Button) findViewById(R.id.button5a);
        bPi = (Button) findViewById(R.id.button6a);
        bMax = (Button) findViewById(R.id.button7a);
        bMin = (Button) findViewById(R.id.button8a);
        bComma = (Button) findViewById(R.id.button9a);
        bToDegrees = (Button) findViewById(R.id.button10a);
        bToRadians = (Button) findViewById(R.id.button11a);

    }

    // CLEAR ALL
    public void clearAllClicked(View v){
        screenText = new StringBuffer();
        numAfterPeriod = false;
        numberInput = false;
        periodDone = false;
        stackScreen.emptyStack();
        textView.setText("");
        infix = new ArrayList<>();
        infix.add(OperatorParameters.bracketopen);
    }

    // BACK
    public void backClicked(View v){
        if(screenText.length() > 0) {
            if(screenText.length() == 1)
                numberInput = false;
            else if(screenText.charAt(screenText.length()-1) == '.')
                periodDone = false;
            else if (screenText.length() >= 2 && screenText.charAt(screenText.length()-2) == '.')
                numAfterPeriod = false;
            screenText = screenText.delete(screenText.length() - 1, screenText.length());
            String newText = textView.getText().subSequence(0, textView.getText().length()-screenText.length()-1).toString() + screenText;
            textView.setText(newText);
            if(screenText.length() >= 1)
                infix.set(infix.size()-1, screenText.toString());
        }else if( !stackScreen.isEmpty() ){
            String fromStack = stackScreen.viewLast();
            char lastChar = fromStack.charAt(fromStack.length()-1);
            if(((int)lastChar >= 48 && (int)lastChar <= 57)){
                screenText = new StringBuffer(stackScreen.pop());
                backClicked(v);
            } else {
                String abc = stackScreen.pop();
                String newText = textView.getText().subSequence(0, textView.getText().length()-abc.length()).toString();
                textView.setText(newText);
                infix.remove(infix.size()-1);
            }
        }
    }

    public void digitClicked(View v){
        String digit;
        char dig;
        switch(v.getId()){
            case R.id.button0:      digit = OperatorParameters.zero;    dig='0';    break;
            case R.id.button1:      digit = OperatorParameters.one;     dig='1';    break;
            case R.id.button2:      digit = OperatorParameters.two;     dig='2';    break;
            case R.id.button3:      digit = OperatorParameters.three;   dig='3';    break;
            case R.id.button4:      digit = OperatorParameters.four;    dig='4';    break;
            case R.id.button5:      digit = OperatorParameters.five;    dig='5';    break;
            case R.id.button6:      digit = OperatorParameters.six;     dig='6';    break;
            case R.id.button7:      digit = OperatorParameters.seven;   dig='7';    break;
            case R.id.button8:      digit = OperatorParameters.eight;   dig='8';    break;
            case R.id.button9:      digit = OperatorParameters.nine;    dig='9';    break;
            case R.id.buttonMinus:  digit = OperatorParameters.minus;   dig='-';    break;
            default:    return;
        }
        if(numberInput)
            infix.set(infix.size()-1, infix.get(infix.size()-1) + digit);
        else
            infix.add(digit);
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append(dig);
        textView.setText(textView.getText() + digit);
    }

    // .
    public void periodClicked(View v){
        if(!numberInput || periodDone)
            Toast.makeText(MainActivity.this, "Enter a valid number", Toast.LENGTH_SHORT).show();
        else{
            periodDone = true;
            screenText = screenText.append('.');
            textView.setText(textView.getText() + OperatorParameters.period);
            infix.set(infix.size()-1, infix.get(infix.size()-1)+OperatorParameters.period);
        }
    }

    public void operatorClicked(View v){
        String op;
        switch (v.getId()){
            case R.id.buttonPlus:       op = OperatorParameters.plus;               break;
            case R.id.buttonMultiply:   op = OperatorParameters.multiply;           break;
            case R.id.buttonDivide:     op = OperatorParameters.divide;             break;
            case R.id.button1s:         op = OperatorParameters.sin;                break;
            case R.id.button2s:         op = OperatorParameters.cos;                break;
            case R.id.button3s:         op = OperatorParameters.tan;                break;
            case R.id.button4s:         op = OperatorParameters.log;                break;
            case R.id.button6s:         op = OperatorParameters.ln;                 break;
            case R.id.button10s:        op = OperatorParameters.bracketopen;        break;
            case R.id.button11s:        op = OperatorParameters.bracketclose;       break;
            case R.id.button1a:         op = OperatorParameters.sinInv;             break;
            case R.id.button2a:         op = OperatorParameters.cosInv;             break;
            case R.id.button3a:         op = OperatorParameters.tanInv;             break;
            case R.id.button4a:         op = OperatorParameters.floor;              break;
            case R.id.button5a:         op = OperatorParameters.ceil;               break;
            case R.id.button7a:         op = OperatorParameters.max;                break;
            case R.id.button8a:         op = OperatorParameters.min;                break;
            case R.id.button9a:         op = OperatorParameters.comma;              break;
            case R.id.button10a:        op = OperatorParameters.toDegrees;          break;
            case R.id.button11a:        op = OperatorParameters.toRadians;          break;
            case R.id.buttonMinus:
                if((infix.size() == 0) || (infix.get(infix.size()-1).equals(OperatorParameters.bracketopen))) {
                    digitClicked(v);
                    return;
                }
                op = OperatorParameters.minus;
                break;
            default:    return;
        }
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + op);
            stackScreen.push(op);
            infix.add(op);
        }
    }

    // e
    public void expClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.exp);
            stackScreen.push(OperatorParameters.exp);
            infix.add(OperatorParameters.exp);
        }
    }

    // square root
    public void srClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.squareroot);
            stackScreen.push(OperatorParameters.squareroot);
            infix.add(OperatorParameters.squareroot);
        }
    }

    // power
    public void powerClicked(View v){
        numberInput = false;
        /* TO DO
        screenText = screenText.append('l');
        textView.setText(textView.getText() + "");*/
    }

    // square
    public void squareClicked(View v){
        numberInput = false;
        /* TO DO
        screenText = screenText.append('l');
        screenText = screenText.append('n');
        textView.setText(textView.getText() + "ln");*/
    }

    // factorial
    public void factorialClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.factorial);
            stackScreen.push(OperatorParameters.factorial);
            infix.add(OperatorParameters.factorial);
        }
    }

    // pi
    public void piClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.pi);
            stackScreen.push(OperatorParameters.pi);
            infix.add(OperatorParameters.pi);
        }
    }

    // equal to =
    public void equalClicked(View v){
        infix.add(OperatorParameters.bracketclose);
        ArrayList<String> postfix = infixToPostfix(infix);
        String result = postfixEvaluation(postfix);
        screenText = new StringBuffer();
        numAfterPeriod = false;
        numberInput = false;
        periodDone = false;
        stackScreen.emptyStack();
        textView.setText(result);
        infix = new ArrayList<>();
        infix.add(OperatorParameters.bracketopen);
        infix.add(result);
    }

    public ArrayList<String> infixToPostfix(ArrayList<String> infixLocal){
        Stack infixStack = new Stack();
        ArrayList<String > postfix = new ArrayList<>();
        int i = 0;
        while(i < infixLocal.size()) {
            String s = infixLocal.get(i);
            if(((int)s.charAt(0) >=48 && (int)s.charAt(0) <= 57) || s.charAt(0) == '.'|| (s.charAt(0) == '-' && s.length() > 1) || s.equals(OperatorParameters.pi)){
                postfix.add(s);
                i++;
            }
            else if(s.equals(OperatorParameters.bracketopen)){
                infixStack.push(OperatorParameters.bracketopen);
                i++;
            }
            else if(s.equals(OperatorParameters.bracketclose)){
                String st = infixStack.pop();
                while(st != OperatorParameters.bracketopen){
                    postfix.add(st);
                    st = infixStack.pop();
                }
                i++;
            }
            else if(s.equals(OperatorParameters.plus) || s.equals(OperatorParameters.minus)){
                String st = infixStack.viewLast();
                while(st.equals(OperatorParameters.plus) || st.equals(OperatorParameters.minus) ||
                        st.equals(OperatorParameters.multiply) || st.equals(OperatorParameters.divide)){
                    postfix.add(infixStack.pop());
                    st = infixStack.viewLast();
                }
                infixStack.push(s);
                i++;
            }
            else if(s.equals(OperatorParameters.multiply) || s.equals(OperatorParameters.divide)){
                infixStack.push(s);
                i++;
            }
            else if(s.equals(OperatorParameters.comma)){
                // Issue Expression
            }
            else {
                if(s.equals(OperatorParameters.max) || s.equals(OperatorParameters.min)){
                    if( i >= infixLocal.size()){
                        // expression error
                    }
                    else if( infixLocal.get(i+1).equals(OperatorParameters.bracketopen)){
                        int j = i+1;
                        ArrayList<Double> values = new ArrayList<>();
                        while( infixLocal.get(j).equals(OperatorParameters.comma) || infixLocal.get(j).equals(OperatorParameters.bracketopen) ) {
                            j++;
                            ArrayList<String> exp = new ArrayList<>();
                            exp.add(OperatorParameters.bracketopen);
                            while (j < infixLocal.size() &&  !infixLocal.get(j).equals(OperatorParameters.bracketclose)) {
                                if( infixLocal.get(j).equals(OperatorParameters.comma) ) break;
                                j++;
                                exp.add(infixLocal.get(j));
                            }
                            exp.add(OperatorParameters.bracketclose);
                            exp = infixToPostfix(exp);
                            String val = postfixEvaluation(exp);
                            values.add(stringToDecimal(val));
                        }
                        if(s.equals(OperatorParameters.max)){
                            double myval = values.get(0);
                            for(int m =1; m<values.size(); m++){
                                myval = Math.max(myval, values.get(m));
                            }
                            postfix.add(myval+"");
                        }else {
                            double myval = values.get(0);
                            for(int m =1; m<values.size(); m++){
                                myval = Math.min(myval, values.get(m));
                            }
                            postfix.add(myval+"");
                        }
                        // a doubt bracketclose will be counted or not
                        i = j+1;
                    }
                    else{
                        if(infixLocal.size() >= i){
                            // Expession error
                        }
                        postfix.add(infixLocal.get(++i));
                    }
                }
                else if( OperatorParameters.exp.equals(s) || OperatorParameters.squareroot.equals(s) ||
                        OperatorParameters.sin.equals(s) || OperatorParameters.cos.equals(s) || OperatorParameters.tan.equals(s) ||
                        OperatorParameters.log.equals(s) ||OperatorParameters.ceil.equals(s) || OperatorParameters.ln.equals(s) ||
                        OperatorParameters.sinInv.equals(s) || OperatorParameters.cosInv.equals(s) || OperatorParameters.tanInv.equals(s) ||
                        OperatorParameters.floor.equals(s) || OperatorParameters.toDegrees.equals(s) || OperatorParameters.toRadians.equals(s)){
                    if( i >= infixLocal.size()){
                        // expression error
                    }
                    else if((int)infixLocal.get(i+1).charAt(0) >= 48 && infixLocal.get(i+1).charAt(0)<=57){
                        Double val = stringToDecimal(infixLocal.get(++i));
                        val = calculate(s, val);
                        postfix.add(val+"");
                        i++;
                    }
                    else if(infixLocal.get(i+1).equals(OperatorParameters.bracketclose)){
                        int j = i+2;
                        int brackOpen = 1, brackClose = 0;
                        ArrayList<String> value = new ArrayList<>();
                        value.add(OperatorParameters.bracketopen);
                        String current = infixLocal.get(j);
                        while(infixLocal.size() > j && brackOpen > brackClose){
                            if(current.equals(OperatorParameters.bracketopen))    brackOpen++;
                            else if(current.equals(OperatorParameters.bracketclose))    brackClose++;
                            value.add(current);
                            current = infixLocal.get(j);
                            j++;
                        }
                        value.add(OperatorParameters.bracketclose);
                        value = infixToPostfix(value);
                        String exp = postfixEvaluation(value);
                        Double val = stringToDecimal(exp);
                        val = calculate(s, val);
                        postfix.add(val+"");
                        i = j;
                    }
                    else{
                        int j = i+1;
                        int brackOpen = 0, brackClose = 0;
                        ArrayList<String> value = new ArrayList<>();
                        value.add(OperatorParameters.bracketopen);
                        boolean digit = false;
                        String current = infixLocal.get(j);
                        while(infixLocal.size() > j && ((brackOpen > 0 && brackOpen > brackClose) || (brackOpen == 0 && brackOpen == brackClose && !digit))){
                            if(current.equals(OperatorParameters.bracketopen))    brackOpen++;
                            else if(current.equals(OperatorParameters.bracketclose))    brackClose++;
                            value.add(current);
                            int lastChar = (int)current.charAt(current.length()-1);
                            if(lastChar >= 48 && lastChar <= 57)
                                digit = true;
                            if(infixLocal.size() > j+1)
                                current = infixLocal.get(++j);
                            else
                                j++;
                        }
                        value = infixToPostfix(value);
                        String exp = postfixEvaluation(value);
                        Double val = stringToDecimal(exp);
                        val = calculate(s, val);
                        postfix.add(val+"");
                        i = j;
                    }
                }
            }
        }
        return postfix;
    }

    private double calculate(String expression, double val){
        if(OperatorParameters.exp.equals(expression)){
            val = Math.exp(val);
        }else if(OperatorParameters.squareroot.equals(expression)){
            val = Math.sqrt(val);
        }else if(OperatorParameters.sin.equals(expression)){
            val = Math.sin(val);
        }else if (OperatorParameters.cos.equals(expression)){
            val = Math.cos(val);
        }else if (OperatorParameters.tan.equals(expression)){
            val = Math.tan(val);
        }else if(OperatorParameters.log.equals(expression)){
            val = Math.log10(val);
        }else if(OperatorParameters.ceil.equals(expression)){
            val = Math.ceil(val);
        } else if(OperatorParameters.sinInv.equals(expression)){
            val = Math.asin(val);
        }else if (OperatorParameters.cosInv.equals(expression)){
            val = Math.acos(val);
        }else if (OperatorParameters.tanInv.equals(expression)){
            val = Math.atan(val);
        }else if (OperatorParameters.floor.equals(expression)){
            val = Math.floor(val);
        }else if (OperatorParameters.ln.equals(expression)){
            val = Math.log(val);
        }else if (OperatorParameters.toDegrees.equals(expression)){
            val = Math.toDegrees(val);
        }else{
            val = Math.toRadians(val);
        }
        return val;
    }

    public String postfixEvaluation(ArrayList<String> postfixLocal){
        Stack postfixStack = new Stack();
        for(int i=0; i<postfixLocal.size(); i++ ){
            String current = postfixLocal.get(i);
            if(((int)current.charAt(0) >=48 && (int) current.charAt(0) <= 57) ||
                    (current.length()>1 && (int)current.charAt(1) >=48 && (int) current.charAt(1) <= 57)){
                postfixStack.push(current);
            }
            else if(postfixStack.size() > 1){
                double first = stringToDecimal(postfixStack.pop());
                double second = stringToDecimal(postfixStack.pop());
                String op = postfixLocal.get(i);
                if(op.equals(OperatorParameters.plus)){
                    postfixStack.push((second+first)+"");
                }
                else if(op.equals(OperatorParameters.minus)){
                    postfixStack.push((second-first)+"");
                }
                else if(op.equals(OperatorParameters.multiply)){
                    postfixStack.push((second*first)+"");
                }
                else if(op.equals(OperatorParameters.divide)){
                    postfixStack.push((second/first)+"");
                }
            }
        }
        if(!postfixStack.isSingleElement()){
            //definetely an error
        }

        return postfixStack.pop();
    }

    public double stringToDecimal(String num){
        double n = 0.0;
        boolean periodEnc = false;
        int j = 1, k = 1;
        for(int i=0; i<num.length(); i++){
            if(i==0 && num.charAt(i) == '-'){
                k = -1;
            }
            else if(num.charAt(i) == '.') {
                if (periodEnc) {
                    //Invalid number
                    Toast.makeText(MainActivity.this, "You entered an invalid number", Toast.LENGTH_SHORT);
                    // TO DO: Clear everything
                }
                periodEnc = true;
            }
            else if (periodEnc)
                n = n + ((int) num.charAt(i) -48) *Math.pow(10, -1 * (j++));
            else
                n = n * 10 + ((int) num.charAt(i) -48);
        }
        return n * k;
    }

}
