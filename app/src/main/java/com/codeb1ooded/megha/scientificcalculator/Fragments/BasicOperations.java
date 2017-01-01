package com.codeb1ooded.megha.scientificcalculator.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codeb1ooded.megha.scientificcalculator.R;

/**
 * Created by megha on 23/6/16.
 */
public class BasicOperations extends android.support.v4.app.Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }
}
