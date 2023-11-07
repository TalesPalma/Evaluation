package com.example.evaluation.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evaluation.R;

public class academicFragment extends Fragment {
private float cont,mediaSoma;


    public academicFragment() {
        // Required empty public constructor
    }


    public static academicFragment newInstance(String param1, String param2) {
        academicFragment fragment = new academicFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_academic, container, false) ;

        EditText mediaInput = view.findViewById(R.id.mediaInput);
        EditText notaInput  = view.findViewById(R.id.notaInput);
        TextView resultView = view.findViewById(R.id.result);




        view.findViewById(R.id.buttonAdicionar).setOnClickListener(v->{
            try {
                this.cont++;
                this.mediaSoma += Float.parseFloat(notaInput.getText().toString());
                notaInput.setText("");
            }catch (Exception ex){
              Toast  toast = Toast.makeText(getContext(),"Os campos estão nullos",Toast.LENGTH_SHORT);
              toast.show();
            }
        });

        view.findViewById(R.id.buttonFinalizar).setOnClickListener(v->{

            try {
                float media = Float.parseFloat(mediaInput.getText().toString());
                mediaInput.setText("");
                float mediaResultado = this.mediaSoma / this.cont;

                if (mediaResultado >= media) {
                    resultView.setTextColor(Color.parseColor("#00ff00"));
                    resultView.setText("Aluno foi aprovado com a média " + mediaResultado);
                } else {
                    resultView.setTextColor(Color.parseColor("#f44336"));
                    resultView.setText("Aluno foi reprovado com a média " + mediaResultado);
                }
            }catch (Exception ex){
                Toast toast = Toast.makeText(getContext(),"Os campos estão nullos",Toast.LENGTH_SHORT);
                toast.show();
            }

            this.mediaSoma=0;
            this.cont=0;

        });

        return view;
    }
}