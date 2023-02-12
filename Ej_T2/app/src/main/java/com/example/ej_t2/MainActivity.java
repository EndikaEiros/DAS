package com.example.ej_t2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button miBoton = (Button) findViewById(R.id.boton);
        miBoton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   TextView entrada = (EditText) findViewById(R.id.Entradatexto);
                   TextView salida = (TextView) findViewById(R.id.SalidaTexto);
                   salida.setText(entrada.getText());
                   salida.setRotation(-45);

               }
           }

        );

    }
}