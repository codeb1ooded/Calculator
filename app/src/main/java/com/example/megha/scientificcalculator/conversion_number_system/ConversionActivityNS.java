package com.example.megha.scientificcalculator.conversion_number_system;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.megha.scientificcalculator.R;

/**
 * Created by megha on 23/6/16.
 */
public class ConversionActivityNS extends AppCompatActivity {

    Button binary, octal, decimal, hexadecimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversion_activity_ns);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Convert From");
        initialise();
    }

    public void initialise(){
        binary = (Button) findViewById(R.id.buttonBinary1);
        octal = (Button) findViewById(R.id.buttonOctal1);
        decimal = (Button) findViewById(R.id.buttonDecimal1);
        hexadecimal = (Button) findViewById(R.id.buttonHexadecimal1);
    }

    public void fromBinary(View v){
        Intent i = new Intent();
        i.setClass(ConversionActivityNS.this, ConversionFromBinary.class);
        startActivity(i);
    }

    public void fromOctal(View v){
        Intent i = new Intent();
        i.setClass(ConversionActivityNS.this, ConversionFromOctal.class);
        startActivity(i);
    }

    public void fromDecimal(View v){
        Intent i = new Intent();
        i.setClass(ConversionActivityNS.this, ConversionFromDecimal.class);
        startActivity(i);
    }

    public void fromHexadecimal(View v){
        Intent i = new Intent();
        i.setClass(ConversionActivityNS.this, ConversionFromHexadecimal.class);
        startActivity(i);
    }
}
