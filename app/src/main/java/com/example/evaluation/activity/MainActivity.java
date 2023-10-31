package com.example.evaluation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.evaluation.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText email = findViewById(R.id.Email);
        EditText senha = findViewById(R.id.Senha);
        Button botao = findViewById(R.id.Botao);
        Intent intent = new Intent(this, Internoapp.class);

        String user="tales";
        String password="123";

        botao.setOnClickListener((v)->{

            try {
                if (email.getText().toString().equals(user) && senha.getText().toString().equals(password)) {
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(this, "Senha ou email INVALIDO", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }catch (Exception e){
                Toast toast = Toast.makeText(this,"ERROR" + e.getMessage(),Toast.LENGTH_LONG);
                toast.show();
            }

        });



    }
}