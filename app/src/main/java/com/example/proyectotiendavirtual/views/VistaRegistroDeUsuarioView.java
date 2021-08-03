package com.example.proyectotiendavirtual.views;

import androidx.annotation.NonNull;
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
import android.widget.Toast;

import com.example.proyectotiendavirtual.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class VistaRegistroDeUsuarioView extends AppCompatActivity {
    private EditText campoFecha;
    private Button botonRegister;
    private EditText campoCorreo;
    private EditText campoContraseña;
    private boolean yaRegistro;
    /*SharedPreferences preferences;
    SharedPreferences.Editor editor;*/
    FirebaseAuth auth;
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
                        campoFecha.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }
                        , dia, mes, año);
                datePickerDialog.show();
            }
        });
        botonRegister = findViewById(R.id.btnRegistrarse);
        campoCorreo = findViewById(R.id.editTextCorreoElectronico);
        campoContraseña = findViewById(R.id.editTextContraseña);

        /*botonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //capturar el valor del check primero colocamos el id
                //editor.putBoolean("Sesion", checkSesion.isChecked());
                yaRegistro = true;
                /*editor.putBoolean("Registrado",yaRegistro);
                editor.apply();*/

        // });
        //registrar los datos en el realm time database

        botonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validarCamposVacios()) {
                    auth = FirebaseAuth.getInstance();
                    String usuario2 = campoCorreo.getText().toString();
                    String contraseña2 = campoContraseña.getText().toString();

                    auth.createUserWithEmailAndPassword(usuario2,contraseña2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(VistaRegistroDeUsuarioView.this,"Usuario Registrado",Toast.LENGTH_SHORT).show();
                                finish();
                            }else {
                                Toast.makeText(VistaRegistroDeUsuarioView.this,"Error al registrar",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }else{
                    Toast.makeText(VistaRegistroDeUsuarioView.this,"Revisa Los Campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public Boolean validarCamposVacios() {
        String usuario1 = campoCorreo.getText().toString();
        String contraseña1 = campoContraseña.getText().toString();
        boolean retorno = true;
        if (usuario1.isEmpty()) {
            campoCorreo.setError("campo vacío");
            retorno = false;
            Toast.makeText(this, "Campo Vacio", Toast.LENGTH_SHORT).show();
        }
        if (contraseña1.isEmpty()) {
            campoContraseña.setError("campo vacío");
            retorno = false;
            Toast.makeText(this, "Campo Vacio", Toast.LENGTH_SHORT).show();
        }
        return retorno;
    }

}
