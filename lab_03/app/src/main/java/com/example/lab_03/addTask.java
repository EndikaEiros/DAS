package com.example.lab_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class addTask extends AppCompatActivity {

    Button btnDone;
    TextView Wdescription;
    EditText taskText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        btnDone = findViewById(R.id.btnDone);
        taskText = findViewById(R.id.TaskText);
        Wdescription = findViewById(R.id.Description);
        Intent intent = new Intent();
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nuevaTarea = taskText.getText().toString();

                intent.putExtra("tarea", nuevaTarea);
                Log.i("Variable",nuevaTarea);

                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}