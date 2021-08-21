package com.example.agendacontactosandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nombre,datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText) findViewById(R.id.txt_nombre);
        datos = (EditText) findViewById(R.id.txt_datos_multiline);
    }
    //Metodo btn buscar
    public void buscar(View view){
        String nombre_string = nombre.getText().toString();
        SharedPreferences recuperar = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datosString = recuperar.getString(nombre_string,"");

        if(datos.length() == 0 ){
            Toast.makeText(this,"No se encontro ningun registro",Toast.LENGTH_SHORT).show();

        }else{
            datos.setText(datosString);
        }
    }
    //metodo btn guardar
    public void guardar(View view) {
        //Recuperar datos
        String nombreString = nombre.getText().toString();
        String datosAguardar = datos.getText().toString();
        //crear archivo donde guardar
        SharedPreferences lista = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = lista.edit();
        //enviar parametros de los datos a recuperar
        obj_editor.putString(nombreString,datosAguardar);
        //confirmar
        obj_editor.commit();

        Toast.makeText(this,"Contacto Guardo Exitosamente",Toast.LENGTH_SHORT).show();
    }
}