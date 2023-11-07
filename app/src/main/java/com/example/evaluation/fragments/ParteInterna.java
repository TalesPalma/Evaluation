package com.example.evaluation.fragments;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.evaluation.R;



public class ParteInterna extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

View view =  inflater.inflate(R.layout.fragment_parte_interna, container, false);

        view.findViewById(R.id.buttonEsport).setOnClickListener(v ->
                findNavController(view).navigate(R.id.action_menuFragments_to_esportFragment
        ));

        view.findViewById(R.id.buttonAcademico).setOnClickListener(v ->
                findNavController(view).navigate(R.id.action_menuFragments_to_academicFragment));


return view;
    }
}