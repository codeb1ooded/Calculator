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

public class MainActivity extends AppCompatActivity {

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
    Button bPlus, bMinus, bMultiply, bDivide, bEqual, bPeriod;
    Button bSin, bCos, bTan, bLog10, bNaturalLog, bExp, bSquareRoot, bPower, bSquare, bOpenBracket, bCloseBracket, bFactorial;
    Button bSinInv, bCosInv, bTanIv, bFloor, bCeil, bPi, bMax, bMin, bComma, bToDegrees, bToRadians;
    TextView textView;
    StringBuffer screenText;
    Stack stackScreen;
    Boolean numberInput, periodDone, numAfterPeriod;

    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
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
    }

    // CLEAR LAST
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
            }
        }
    }

    // 1
    public void oneClicked(View v){
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('1');
        textView.setText(textView.getText() + "1");
    }

    // 2
    public void twoClicked(View v){
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('2');
        textView.setText(textView.getText() + "2");
    }

    // 3
    public void threeClicked(View v){
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('3');
        textView.setText(textView.getText() + "3");
    }

    // 4
    public void fourClicked(View v){
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('4');
        textView.setText(textView.getText() + "4");
    }

    // 5
    public void fiveClicked(View v){
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('5');
        textView.setText(textView.getText() + "5");
    }

    // 6
    public void sixClicked(View v){
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('6');
        textView.setText(textView.getText() + "6");
    }

    // 7
    public void sevenClicked(View v){
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('7');
        textView.setText(textView.getText() + "7");
    }

    // 8
    public void eightClicked(View v){
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('8');
        textView.setText(textView.getText() + "8");
    }

    // 9
    public void nineClicked(View v){
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('9');
        textView.setText(textView.getText() + "9");
    }

    // 0
    public void zeroClicked(View v){
        numberInput = true;
        if(periodDone) numAfterPeriod = true;
        screenText = screenText.append('0');
        textView.setText(textView.getText() + "0");
    }

    // .
    public void periodClicked(View v){
        if(!numberInput || periodDone)
            Toast.makeText(MainActivity.this, "Enter a valid number", Toast.LENGTH_SHORT).show();
        else{
            periodDone = true;
            screenText = screenText.append('.');
            textView.setText(textView.getText() + ".");
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
            textView.setText(textView.getText() + "+");
            stackScreen.push("+");
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
            textView.setText(textView.getText() + "-");
            stackScreen.push("-");
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
            textView.setText(textView.getText() + "*");
            stackScreen.push("*");
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
            textView.setText(textView.getText() + "/");
            stackScreen.push("/");
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
            textView.setText(textView.getText() + "sin");
            stackScreen.push("sin");
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
            textView.setText(textView.getText() + "cos");
            stackScreen.push("cos");
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
            textView.setText(textView.getText() + "tan");
            stackScreen.push("tan");
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
            textView.setText(textView.getText() + "log");
            stackScreen.push("log");
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
            textView.setText(textView.getText() + "e");
            stackScreen.push("e");
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
            textView.setText(textView.getText() + "ln");
            stackScreen.push("ln");
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
            textView.setText(textView.getText() + "√");
            stackScreen.push("√");
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
            textView.setText(textView.getText() + "(");
            stackScreen.push("(");
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
            textView.setText(textView.getText() + ")");
            stackScreen.push(")");
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
            textView.setText(textView.getText() + "!");
            stackScreen.push("!");
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
            textView.setText(textView.getText() + "sin"+'\u207B'+'\u00B9');
            stackScreen.push("sinIn");
        }
    }

    // cos-1
    public void cosInvClicked(View v){if(numAfterPeriod || !periodDone){
        if (numberInput){
            periodDone = false;
            numAfterPeriod = false;
            stackScreen.push(screenText.toString());
            numberInput = false;
            screenText = new StringBuffer();
        }
        textView.setText(textView.getText() + "cos"+'\u207B'+'\u00B9');
        stackScreen.push("cosIn");
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
        textView.setText(textView.getText() + "tan"+'\u207B'+'\u00B9');
        stackScreen.push("tanIn");
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
            textView.setText(textView.getText() + "floor");
            stackScreen.push("floor");
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
            textView.setText(textView.getText() + "ceil");
            stackScreen.push("ceil");
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
            textView.setText(textView.getText() + "\u03c0");
            stackScreen.push("\u03c0");
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
            textView.setText(textView.getText() + "max");
            stackScreen.push("max");
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
            textView.setText(textView.getText() + "min");
            stackScreen.push("min");
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
            textView.setText(textView.getText() + ",");
            stackScreen.push(",");
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
            textView.setText(textView.getText() + "toDegrees");
            stackScreen.push("toDegrees");
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
            textView.setText(textView.getText() + "toRadians");
            stackScreen.push("toRadians");
        }
    }

    // equal to =
    public void equalToClicked(View v){
        Result.calculateResult(stackScreen);
    }
}
