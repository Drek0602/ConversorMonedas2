package com.pmdm.cip.conversormonedas2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class Activity2 extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity2);
            setTitle(R.string.title2); //Ponemos el titulo en la pantalla

            //Atributos
            Button buttonConvert = findViewById(R.id.buttonConvert);
            Button buttonReset = findViewById(R.id.buttonReset);
            Button buttonEuroDollar = findViewById(R.id.buttoneurodollar);
            final EditText textoDolares = findViewById(R.id.editTextDolares);
            final TextView textoEuro = findViewById(R.id.textEuros);

            //Recuperamos el valor del dollar que teniamos en la primera activity
            Bundle bundle = getIntent().getExtras();
            String tmp = bundle.getString("valor");
            textoDolares.setText(String.valueOf(tmp));



            final DecimalFormat df2 = new DecimalFormat(".##");


            buttonConvert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String tmp = textoDolares.getText().toString();

                    if (tmp.equalsIgnoreCase("")) {
                        Toast.makeText(getApplicationContext(), "Introduzca una Cantidad", Toast.LENGTH_SHORT).show();
                    } else {

                        double d = Double.parseDouble(String.valueOf(textoDolares.getText()));
                        double resultado = d / 1.1454;
                        textoEuro.setText(String.valueOf(df2.format(resultado)));
                    }
                }
            });


            buttonReset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textoEuro.setText("");
                    textoDolares.setText("");
                }
            });


            buttonEuroDollar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
