package com.example.proyectotiendavirtual.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.proyectotiendavirtual.R;

public class VistaPaginaInicial extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_pagina_inicial);
    }
    @Override
    protected void onStart() {
        super.onStart();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (preferences.getInt("seInicioSesion",0) == 0 || preferences.getBoolean("Registrado",false) == false){
                    goToMainActivity();
                }
                else {
                    Toast.makeText(VistaPaginaInicial.this, "entro a iniciar sesion", Toast.LENGTH_SHORT).show();
                }

            }
        }, 2000);

    }


    public void goToMainActivity() {
        Intent intent = new Intent(this, VistaIniciarSesion.class);
        startActivity(intent);

    }

}