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
    Boolean numberInput, periodDone, numAfterPeriod;
    ArrayList<String> infix;

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_conversion_number_system) {
            Intent i = new Intent();
            i.setClass(MainActivity.this, ConversionActivityNS.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
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
    public void clearClicked(View v){
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
                clearClicked(v);
            } else {
                String abc = stackScreen.pop();
                String newText = textView.getText().subSequence(0, textView.getText().length()-abc.length()).toString();
                textView.setText(newText);
                infix.remove(infix.size()-1);
            }
        }
    }

    // 1
    public void oneClicked(View v){
        if(numberInput)
            infix.set(infix.size()-1, infix.get(infix.size()-1)+OperatorParameters.one);
        else
            infix.add(OperatorParameters.one);
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('1');
        textView.setText(textView.getText() + OperatorParameters.one);
    }

    // 2
    public void twoClicked(View v){
        if(numberInput)
            infix.set(infix.size()-1, infix.get(infix.size()-1)+OperatorParameters.two);
        else
            infix.add(OperatorParameters.two);
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('2');
        textView.setText(textView.getText() + OperatorParameters.two);
    }

    // 3
    public void threeClicked(View v){
        if(numberInput)
            infix.set(infix.size()-1, infix.get(infix.size()-1)+OperatorParameters.three);
        else
            infix.add(OperatorParameters.three);
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('3');
        textView.setText(textView.getText() + OperatorParameters.three);
    }

    // 4
    public void fourClicked(View v){
        if(numberInput)
            infix.set(infix.size()-1, infix.get(infix.size()-1)+OperatorParameters.four);
        else
            infix.add(OperatorParameters.four);
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('4');
        textView.setText(textView.getText() + OperatorParameters.four);
    }

    // 5
    public void fiveClicked(View v){
        if(numberInput)
            infix.set(infix.size()-1, infix.get(infix.size()-1)+OperatorParameters.five);
        else
            infix.add(OperatorParameters.five);
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('5');
        textView.setText(textView.getText() + OperatorParameters.five);
    }

    // 6
    public void sixClicked(View v){
        if(numberInput)
            infix.set(infix.size()-1, infix.get(infix.size()-1)+OperatorParameters.six);
        else
            infix.add(OperatorParameters.six);
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('6');
        textView.setText(textView.getText() + OperatorParameters.six);
    }

    // 7
    public void sevenClicked(View v){
        if(numberInput)
            infix.set(infix.size()-1, infix.get(infix.size()-1)+OperatorParameters.seven);
        else
            infix.add(OperatorParameters.seven);
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('7');
        textView.setText(textView.getText() + OperatorParameters.seven);
    }

    // 8
    public void eightClicked(View v){
        if(numberInput)
            infix.set(infix.size()-1, infix.get(infix.size()-1)+OperatorParameters.eight);
        else
            infix.add(OperatorParameters.eight);
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('8');
        textView.setText(textView.getText() + OperatorParameters.eight);
    }

    // 9
    public void nineClicked(View v){
        if(numberInput)
            infix.set(infix.size()-1, infix.get(infix.size()-1)+OperatorParameters.nine);
        else
            infix.add(OperatorParameters.nine);
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('9');
        textView.setText(textView.getText() + OperatorParameters.nine);
    }

    // 0
    public void zeroClicked(View v){
        if(numberInput)
            infix.set(infix.size()-1, infix.get(infix.size()-1)+OperatorParameters.zero);
        else
            infix.add(OperatorParameters.zero);
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('0');
        textView.setText(textView.getText() + OperatorParameters.zero);
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

    // +
    public void plusClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.plus);
            stackScreen.push(OperatorParameters.plus);
            infix.add(OperatorParameters.plus);
        }
    }

    // -
    public void minusClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.minus);
            stackScreen.push(OperatorParameters.minus);
            infix.add(OperatorParameters.minus);
        }
    }

    // *
    public void multiplyClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.multiply);
            stackScreen.push(OperatorParameters.multiply);
            infix.add(OperatorParameters.multiply);
        }
    }

    // /
    public void divideClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.divide);
            stackScreen.push(OperatorParameters.divide);
            infix.add(OperatorParameters.divide);
        }
    }

    // sin
    public void sinClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.sin);
            stackScreen.push(OperatorParameters.sin);
            infix.add(OperatorParameters.sin);
        }
    }

    // cos
    public void cosClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.cos);
            stackScreen.push(OperatorParameters.cos);
            infix.add(OperatorParameters.cos);
        }
    }

    // tan
    public void tanClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.tan);
            stackScreen.push(OperatorParameters.tan);
            infix.add(OperatorParameters.tan);
        }
    }

    // log
    public void logClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.log);
            stackScreen.push(OperatorParameters.log);
            infix.add(OperatorParameters.log);
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

    // ln
    public void lnClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.ln);
            stackScreen.push(OperatorParameters.ln);
            infix.add(OperatorParameters.ln);
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

    // bracket open
    public void bracketOpenClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.bracketopen);
            stackScreen.push(OperatorParameters.bracketopen);
            infix.add(OperatorParameters.bracketopen);
        }
    }

    // bracket Closed
    public void bracketClosedClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.bracketclose);
            stackScreen.push(OperatorParameters.bracketclose);
            infix.add(OperatorParameters.bracketclose);
        }
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

    // sin-1
    public void sinInvClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.sinInv);
            stackScreen.push(OperatorParameters.sinInv);
            infix.add(OperatorParameters.sinInv);
        }
    }

    // cos-1
    public void cosInvClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.cosInv);
            stackScreen.push(OperatorParameters.cosInv);
            infix.add(OperatorParameters.cosInv);
        }
    }

    // tan-1
    public void tanInvClicked(View v){if(numAfterPeriod || !periodDone){
        if (numberInput){
            periodDone = false;
            numAfterPeriod = false;
            stackScreen.push(screenText.toString());
            numberInput = false;
            screenText = new StringBuffer();
        }
        textView.setText(textView.getText() + OperatorParameters.tanInv);
        stackScreen.push(OperatorParameters.tanInv);
        infix.add(OperatorParameters.tanInv);
    }
    }

    // floor
    public void floorClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.floor);
            stackScreen.push(OperatorParameters.floor);
            infix.add(OperatorParameters.floor);
        }
    }

    // ceil
    public void ceilClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.ceil);
            stackScreen.push(OperatorParameters.ceil);
            infix.add(OperatorParameters.ceil);
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

    // max
    public void maxClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.max);
            stackScreen.push(OperatorParameters.max);
            infix.add(OperatorParameters.max);
        }
    }

    // min
    public void minClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.min);
            stackScreen.push(OperatorParameters.min);
            infix.add(OperatorParameters.min);
        }
    }

    // ,
    public void commaClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.comma);
            stackScreen.push(OperatorParameters.comma);
            infix.add(OperatorParameters.comma);
        }
    }

    // toDegrees
    public void toDegreesClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.toDegrees);
            stackScreen.push(OperatorParameters.toDegrees);
            infix.add(OperatorParameters.toDegrees);
        }
    }

    // toRadians
    public void toRadiansClicked(View v){
        if(numAfterPeriod || !periodDone){
            if (numberInput){
                periodDone = false;
                numAfterPeriod = false;
                stackScreen.push(screenText.toString());
                numberInput = false;
                screenText = new StringBuffer();
            }
            textView.setText(textView.getText() + OperatorParameters.toRadians);
            stackScreen.push(OperatorParameters.toRadians);
            infix.add(OperatorParameters.toRadians);
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
            if(((int)s.charAt(0) >=48 && (int)s.charAt(0) <= 57) || s.charAt(0) == '.' || s.equals(OperatorParameters.pi)){
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
                        OperatorParameters.log.equals(s) ||OperatorParameters.ceil.equals(s) ||
                        OperatorParameters.sinInv.equals(s) || OperatorParameters.cosInv.equals(s) || OperatorParameters.tanInv.equals(s) ||
                        OperatorParameters.floor.equals(s) || OperatorParameters.toDegrees.equals(s) || OperatorParameters.toRadians.equals(s)){
                    if( i >= infixLocal.size()){
                        // expression error
                    }
                    else if( infixLocal.get(i+1).equals(OperatorParameters.bracketopen)) {
                        int j = i+2;
                        ArrayList<String> value = new ArrayList<>();
                        value.add(OperatorParameters.bracketopen);
                        String current = infixLocal.get(j);
                        while(infixLocal.size() > j && !current.equals(OperatorParameters.bracketclose)){
                            j++;
                            value.add(current);
                            current = infixLocal.get(j);
                        }
                        value.add(OperatorParameters.bracketclose);
                        value = infixToPostfix(value);
                        String exp = postfixEvaluation(value);
                        Double val = stringToDecimal(exp);
                        if(OperatorParameters.exp.equals(s)){
                            val = Math.exp(val);
                        }else if(OperatorParameters.squareroot.equals(s)){
                            val = Math.sqrt(val);
                        }else if(OperatorParameters.sin.equals(s)){
                            val = Math.sin(val);
                        }else if (OperatorParameters.cos.equals(s)){
                            val = Math.cos(val);
                        }else if (OperatorParameters.tan.equals(s)){
                            val = Math.tan(val);
                        }else if(OperatorParameters.log.equals(s)){
                            val = Math.log(val);
                        }else if(OperatorParameters.ceil.equals(s)){
                            val = Math.ceil(val);
                        } else if(OperatorParameters.sinInv.equals(s)){
                            val = Math.asin(val);
                        }else if (OperatorParameters.cosInv.equals(s)){
                            val = Math.acos(val);
                        }else if (OperatorParameters.tanInv.equals(s)){
                            val = Math.atan(val);
                        }else if (OperatorParameters.floor.equals(s)){
                            val = Math.floor(val);
                        }else if (OperatorParameters.toDegrees.equals(s)){
                            val = Math.toDegrees(val);
                        }else{
                            val = Math.toRadians(val);
                        }
                        postfix.add(val+"");
                        i = j + 1;
                    }
                    else{
                        Double val = stringToDecimal(infixLocal.get(++i));
                        if(OperatorParameters.exp.equals(s)){
                            val = Math.exp(val);
                        }else if(OperatorParameters.squareroot.equals(s)){
                            val = Math.sqrt(val);
                        }else if(OperatorParameters.sin.equals(s)){
                            val = Math.sin(val);
                        }else if (OperatorParameters.cos.equals(s)){
                            val = Math.cos(val);
                        }else if (OperatorParameters.tan.equals(s)){
                            val = Math.tan(val);
                        }else if(OperatorParameters.log.equals(s)){
                            val = Math.log(val);
                        }else if(OperatorParameters.ceil.equals(s)){
                            val = Math.ceil(val);
                        } else if(OperatorParameters.sinInv.equals(s)){
                            val = Math.asin(val);
                        }else if (OperatorParameters.cosInv.equals(s)){
                            val = Math.acos(val);
                        }else if (OperatorParameters.tanInv.equals(s)){
                            val = Math.atan(val);
                        }else if (OperatorParameters.floor.equals(s)){
                            val = Math.floor(val);
                        }else if (OperatorParameters.toDegrees.equals(s)){
                            val = Math.toDegrees(val);
                        }else{
                            val = Math.toRadians(val);
                        }
                        postfix.add(val+"");
                        i++;
                    }
                }
            }
        }
        return postfix;
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
