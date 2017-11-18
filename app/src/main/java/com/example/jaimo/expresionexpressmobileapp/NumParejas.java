package com.example.jaimo.expresionexpressmobileapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NumParejas extends AppCompatActivity {
    private Button mayor, menor, continuar;
    private EditText numParejas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_parejas);
        getSupportActionBar().hide();

        mayor = findViewById(R.id.btMayor);
        menor = findViewById(R.id.btMenor);
        continuar = findViewById(R.id.continuar);
        numParejas = findViewById(R.id.numParejas);
        mayor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numParejas.getText().length() != 0) {
                    int num = Integer.parseInt(numParejas.getText().toString()) + 2;
                    numParejas.setText(String.valueOf(num));
                }
                else
                    numParejas.setText("6");
            }
        });
        menor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numParejas.getText().length() != 0) {
                    int num = Integer.parseInt(numParejas.getText().toString()) - 2;
                    numParejas.setText(String.valueOf(num));
                }
                else
                    numParejas.setText("4");
            }
        });
        numParejas.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            public void afterTextChanged(Editable editable) {
                if (editable.length() != 0) {
                    int num = Integer.parseInt(editable.toString());
                    if(num % 2 == 1) {
                        num++;
                        editable.replace(0, editable.length(), String.valueOf(num));
                    }
                    if(num < 4)
                        editable.replace(0, editable.length(), String.valueOf(4));
                }
            }
        });

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numParejas.getText().length() != 0){
                    int num = Integer.parseInt(numParejas.getText().toString());
                    Controlador.getInstance().setNumJugadores(num);
                    startActivity(Controlador.getInstance().dameVista(EVENTOS.NUMPAREJAS_A_NOMBRES, getApplicationContext()));
                }
            }
        });
    }
}
