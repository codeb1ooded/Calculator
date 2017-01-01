package com.codeb1ooded.megha.scientificcalculator.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codeb1ooded.megha.scientificcalculator.R;

/**
 * Created by megha on 23/6/16.
 */
public class ScientificOperations extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scientific_operations, container, false);
        return view;
    }
}
