package com.example.proyectotiendavirtual.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.proyectotiendavirtual.R;

public class VistaIniciarSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_iniciar_sesion);
    }

    //Metodo para pasar a Crear Cuenta
    public void Crear_Cuenta (View view){
        Intent Crear_Cuenta = new Intent (this, VistaRegistroDeUsuarioView.class);
        startActivity(Crear_Cuenta);
    }
}