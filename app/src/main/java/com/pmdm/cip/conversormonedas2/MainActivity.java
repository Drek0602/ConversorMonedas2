package com.pmdm.cip.conversormonedas2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pmdm.cip.conversormonedas2.Activity2;
import com.pmdm.cip.conversormonedas2.R;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.title1); //Ponemos el titulo en la pantalla


        Button buttonConvert = findViewById(R.id.buttonConvert);
        Button buttonReset = findViewById(R.id.buttonReset);
        Button buttonDollarEuro = findViewById(R.id.buttoneurodollar);
        final EditText textoEuros = findViewById(R.id.editTextDolares);
        final TextView textoDollar = findViewById(R.id.textEuros);


        final DecimalFormat df2 = new DecimalFormat(".##");


        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tmp = textoEuros.getText().toString();

                if (tmp.equalsIgnoreCase("")) {
                    Toast.makeText(getApplicationContext(), "Introduzca una Cantidad", Toast.LENGTH_SHORT).show();
                } else {

                    double d = Double.parseDouble(String.valueOf(textoEuros.getText()));
                    double resultado = d * 1.22600;
                    textoDollar.setText(String.valueOf(df2.format(resultado)));
                }
            }
        });



        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoDollar.setText("");
                textoEuros.setText("");
            }
        });



        buttonDollarEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Activity2.class);
                i.putExtra("valor", textoDollar.getText());
                startActivity(i);
            }
        });
    }
}
