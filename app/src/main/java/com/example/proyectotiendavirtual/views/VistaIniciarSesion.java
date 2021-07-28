package com.example.proyectotiendavirtual.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectotiendavirtual.R;

public class VistaIniciarSesion extends AppCompatActivity {
    private EditText usuario;
    private EditText contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_iniciar_sesion);

        usuario = (EditText) findViewById(R.id.txe_correo_usuario);
        contraseña = (EditText) findViewById(R.id.txe_contraseña);

    }

    //Metodo para pasar a Crear Cuenta
    public void Crear_Cuenta(View view) {
        Intent Crear_Cuenta = new Intent(this, VistaRegistroDeUsuarioView.class);
        startActivity(Crear_Cuenta);
    }

    //metodo que verifica los dos metodos creados
    public void IniciarSesion(View view) {


        ComparacionValores();
        ValidarCampoVacio();

        if (ComparacionValores()  && ValidarCampoVacio()) {
            Toast.makeText(this, "entro a iniciar sesion", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean ComparacionValores() {

        boolean retorno2;
        String ContraseñaIngreso = "123456".trim();
        String UsuarioIngreso = "ejemplo1".trim();

        String usIn = String.valueOf(usuario.getText()).trim();
        String conIn = String.valueOf(contraseña.getText()).trim();

        if (UsuarioIngreso.equals(usIn) && conIn.equals(ContraseñaIngreso)) {
            retorno2 = true;
        }
        else {
            retorno2 = false;
        }
        return retorno2;
    }

    public boolean ValidarCampoVacio() {
        boolean retorno = true;

        String usu = usuario.getText().toString();
        String con = contraseña.getText().toString();
        if (usu.isEmpty()) {
            usuario.setError("campo vacío");
            retorno = false;
            Toast.makeText(this, "Campo Vacio", Toast.LENGTH_SHORT).show();
        }
        if (con.isEmpty()) {
            contraseña.setError("campo vacío");
            retorno = false;
            Toast.makeText(this, "Campo Vacio", Toast.LENGTH_SHORT).show();
        }
        return retorno;
    }


}