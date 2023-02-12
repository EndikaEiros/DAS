package com.example.lab_02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int contador;
    String estados;

    @Override
    protected void onPause() {
        super.onPause();
        estados = estados + " onPause";

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        estados = estados + " onDestroy";
    }

    @Override
    protected void onStart() {
        super.onStart();
        estados = estados + " onStart";
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        contador = savedInstanceState.getInt("contador");
        estados = savedInstanceState.getString("estados");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        contador++;
        savedInstanceState.putInt("contador", contador);
        savedInstanceState.putString("estados", estados);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if ( savedInstanceState != null) { contador = savedInstanceState.getInt("contador");}

        TextView labelContador = (TextView) findViewById(R.id.LabelContador);
        labelContador.setText("Veces Rotado:");
        TextView labelEstado = findViewById(R.id.LabelEstados);
        labelEstado.setText("Estados:");

        TextView salidaRotacion = (TextView) findViewById(R.id.SalidaRotacion);
        salidaRotacion.setText(Integer.toString(contador));

        TextView salidaEstados = (TextView) findViewById(R.id.SalidaEstados);
        salidaEstados.setText(estados);

    }
}