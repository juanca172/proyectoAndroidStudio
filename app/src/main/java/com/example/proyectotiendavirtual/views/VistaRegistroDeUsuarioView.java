package com.example.proyectotiendavirtual.views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.proyectotiendavirtual.R;

public class VistaRegistroDeUsuarioView extends AppCompatActivity {
    private EditText campoFecha;
    private Button botonRegister;
    private boolean yaRegistro;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private int dia;
    private int mes;
    private int año;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_registro_de_usuario_view);

        campoFecha = findViewById(R.id.et_fecha_nacimiento);
        campoFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        campoFecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    }
                }
                        ,dia, mes, año);
                datePickerDialog.show();
            }
        });
        botonRegister = findViewById(R.id.btnRegistrarse);

        botonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //capturar el valor del check primero colocamos el id
                //editor.putBoolean("Sesion", checkSesion.isChecked());
                yaRegistro = true;
                editor.putBoolean("Registrado",yaRegistro);
                editor.apply();
            }
        });

    }
}