package com.example.proyectotiendavirtual.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectotiendavirtual.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class VistaIniciarSesion extends AppCompatActivity {
    private EditText usuario;
    private EditText contraseña;
    private Button BtnIngresar;
    /*SharedPreferences preferences;
    SharedPreferences.Editor editor;*/
    private Boolean variableSharedPreference;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_iniciar_sesion);

        usuario = (EditText) findViewById(R.id.txe_correo_usuario);
        contraseña = (EditText) findViewById(R.id.txe_contraseña);

        BtnIngresar =findViewById(R.id.BtnIngresar);

        auth = FirebaseAuth.getInstance();

        BtnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validarCamposVacios()) {
                    String Usuario = usuario.getText().toString();
                    String Contraseña = contraseña.getText().toString();

                    auth.signInWithEmailAndPassword(Usuario, Contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(VistaIniciarSesion.this,"inicio sesion",Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(VistaIniciarSesion.this,"Error al iniciar sesion",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(VistaIniciarSesion.this,"Revisa Los Campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*//Se abre nuevo espacio en memoria
        preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        //Lo vuelve editable
        editor = preferences.edit();
        variableSharedPreference = false;*/

    }

    public Boolean validarCamposVacios() {
        String usuario1 = usuario.getText().toString();
        String contraseña1 = contraseña.getText().toString();
        boolean retorno = true;
        if (usuario1.isEmpty()) {
            usuario.setError("campo vacío");
            retorno = false;
            Toast.makeText(this, "Campo Vacio", Toast.LENGTH_SHORT).show();
        }
        if (contraseña1.isEmpty()) {
            contraseña.setError("campo vacío");
            retorno = false;
            Toast.makeText(this, "Campo Vacio", Toast.LENGTH_SHORT).show();
        }
        return retorno;
    }

    //Metodo para pasar a Crear Cuenta
    public void CrearCuenta(View view) {
        Intent Crear_Cuenta = new Intent(this, VistaRegistroDeUsuarioView.class);
        startActivity(Crear_Cuenta);
    }
    /*
    //metodo para saber si ya se logueo
    public Boolean YaSeLogueo(){
        return preferences.getBoolean("seInicioSesion", false);
    }*/

    /*//metodo que verifica los dos metodos creados
    public void IniciarSesion(View view) {
        ComparacionValores();
        ValidarCampoVacio();

        if (ComparacionValores()  && ValidarCampoVacio()) {
            Toast.makeText(this, "entro a iniciar sesion", Toast.LENGTH_SHORT).show();
            /*variableSharedPreference = true;
            editor.putBoolean("seInicioSesion",variableSharedPreference);
            editor.apply();
        }else{
            Toast.makeText(this, "usuario y contraseña no corressponde", Toast.LENGTH_SHORT).show();
        }
    }*/

    /*public boolean ComparacionValores() {

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
    }*/

}