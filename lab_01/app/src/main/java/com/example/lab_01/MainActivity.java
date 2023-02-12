package com.example.lab_01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    TextView etiqueta;
    TextView contador;
    LinearLayout ellayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        etiqueta = new TextView(this);
        etiqueta.setText("texto de ejemplo");

        contador = new TextView(this);
        contador.setText("0");

        ellayout = new LinearLayout(this);
        ellayout.setOrientation(LinearLayout.VERTICAL);
        ellayout.addView(etiqueta);
        ellayout.addView(contador);

        Button btn_suma=new Button(this);
        btn_suma.setText("Suma");
        btn_suma.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String cont= (String) contador.getText();
                Integer num= Integer.parseInt(cont);
                num++;
                contador.setText(num.toString());
            }
        });

        ellayout.addView(btn_suma);
        setContentView(ellayout);

        Button btn_resta = new Button(this);
        btn_resta.setText("Resta");
        ellayout.addView(btn_resta);
        btn_resta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String cont= (String) contador.getText();
                Integer num= Integer.parseInt(cont);
                num--;
                contador.setText(num.toString());
            }
        });

        Button btn_fondomorado = new Button(this);
        btn_fondomorado.setText("Cambiar el fondo a MORADO");
        ellayout.addView(btn_fondomorado);

        Button btn_fondoazul = new Button(this);
        btn_fondoazul.setText("Fondo en AZUL");


        btn_fondomorado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().getDecorView().setBackgroundColor(Color.MAGENTA);
                ellayout.removeView(btn_fondomorado);
                ellayout.addView(btn_fondoazul);
            }
        });


        btn_fondoazul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                ellayout.removeView(btn_fondoazul);
                ellayout.addView(btn_fondomorado);

            }
        });


    }

}