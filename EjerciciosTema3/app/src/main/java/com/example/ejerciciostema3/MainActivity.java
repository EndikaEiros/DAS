package com.example.ejerciciostema3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView salidaTexto;

    Button BotonCas;
    Button BotonEus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salidaTexto = (TextView) findViewById(R.id.SalidaTexto);
        salidaTexto.setText("....");

        Button botonAct1 = (Button) findViewById(R.id.botonAct1);
        botonAct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityIntent.launch(intent);
            }
        });

        BotonCas = findViewById(R.id.BotonCas);
        BotonCas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale nuevaloc = new Locale("en");
                Locale.setDefault(nuevaloc);
                Configuration config = new Configuration();
                config.locale = nuevaloc;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                finish();
                startActivity(getIntent());
            }
        });
        BotonEus = findViewById(R.id.botonEus);
        BotonEus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale nuevaloc = new Locale("eu");
                Locale.setDefault(nuevaloc);
                Configuration config = new Configuration();
                config.locale = nuevaloc;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                finish();
                startActivity(getIntent());
            }
        });

    }
    ActivityResultLauncher<Intent> startActivityIntent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK){
                String salida = result.getData().getStringExtra("salidaTexto");
                salidaTexto.setText(salida.toString());
            }
        }
    });


}