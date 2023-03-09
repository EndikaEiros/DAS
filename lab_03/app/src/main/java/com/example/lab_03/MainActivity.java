package com.example.lab_03;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listaTareas;
    Button newTask;

    ArrayList<String> tareas;
    ArrayAdapter<String> eladaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listaTareas = findViewById(R.id.listaTareas);
        newTask = findViewById( R.id.btnNewTask);
        tareas = new ArrayList<>();
        ArrayAdapter eladaptador = new ArrayAdapter( this , android.R.layout. simple_list_item_1 ,tareas);
        listaTareas.setAdapter(eladaptador);
        listaTareas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.i( "etiqueta" , ((TextView)view). getText (). toString ()+ ", " +position+ ", " +id);
                Toast.makeText(getApplicationContext(),"Se ha completado la tarea", Toast.LENGTH_LONG).show();
                Context context = getApplicationContext();

                tareas.remove(position);
                listaTareas.setAdapter(eladaptador);
                eladaptador.notifyDataSetChanged();
                return true;
            }
        });


    }

    public void añadirTarea(View view) {
        Intent intent = new Intent(MainActivity.this, addTask.class);
        startActivityIntent.launch(intent);
    }


    ActivityResultLauncher<Intent> startActivityIntent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK){
                String tarea = result.getData().getStringExtra("tarea");
                tareas.add(tarea);
                Context context = getApplicationContext();
                ArrayAdapter eladaptador = new ArrayAdapter( context , android.R.layout. simple_list_item_1 ,tareas);
                listaTareas.setAdapter(eladaptador);
                eladaptador.notifyDataSetChanged();

            }
        }
    });

}