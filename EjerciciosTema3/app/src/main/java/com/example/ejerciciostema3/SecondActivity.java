package com.example.ejerciciostema3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = new Intent();

        TextView EntradaTexto = (TextView) findViewById(R.id.EntradaTexto);

        Button botonAct2 = (Button) findViewById(R.id.botonAct2);
        botonAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String entrada = EntradaTexto.getText().toString();

                intent.putExtra("salidaTexto", entrada);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}