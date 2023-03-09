package com.example.tema4_listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] arraydedatos ={ "alumno1" , "alumno2" , "alumno3" };
        final Integer [] arrayedades ={ 22 , 23 , 24 };
        ArrayAdapter eladaptador =
                new ArrayAdapter <String>( this , android.R.layout. simple_list_item_2 ,android.R.id. text1 ,arraydedatos){
                    @ Override
                    public View getView (int position, View convertView , ViewGroup parent ) {
                        View vista= super .getView (position, convertView , parent );
                        TextView lineaprincipal =(TextView) vista.findViewById (android.R.id. text1 );
                        TextView lineasecundaria =(TextView) vista.findViewById (android.R.id. text2 );
                        lineaprincipal.setText ( arraydedatos [position]); lineasecundaria.setText ( arrayedades [position]. toString ());
                        return vista;
                    } };

        ListView lalista = findViewById ( R.id.list ); lalista.setAdapter ( eladaptador );
        lalista.setOnItemClickListener ( new AdapterView.OnItemClickListener (){
            @ Override
            public void onItemClick (AdapterView<?> parent , View view , int position, long id){
                Log.d( "etiqueta" , ((TextView) view.findViewById (android.R.id. text1 )). getText (). toString ());
            }
        });
    }
}