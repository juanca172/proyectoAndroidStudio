package com.example.proyectotiendavirtual.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.proyectotiendavirtual.R;

public class VistaPaginaInicial extends AppCompatActivity {

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
                goToMainActivity();
            }
        }, 2000);

    }


    public void goToMainActivity() {
        Intent intent = new Intent(this, VistaIniciarSesion.class);
        startActivity(intent);

    }
}