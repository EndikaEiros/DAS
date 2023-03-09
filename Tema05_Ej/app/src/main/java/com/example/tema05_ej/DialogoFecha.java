package com.example.tema05_ej;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DialogoFecha extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super .onCreateDialog(savedInstanceState);
        Calendar calendario=Calendar. getInstance ();
        int anyo=calendario.get(Calendar. YEAR );
        int mes=calendario.get(Calendar. MONTH );
        int dia=calendario.get(Calendar. DAY_OF_MONTH );
        DatePickerDialog eldialogo= new DatePickerDialog(getActivity(), this , anyo,mes,dia);

        return eldialogo;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

    }

}