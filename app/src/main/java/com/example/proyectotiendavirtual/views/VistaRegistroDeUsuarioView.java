package com.example.proyectotiendavirtual.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
<<<<<<< HEAD
import android.content.Intent;
import android.content.SharedPreferences;
=======
>>>>>>> 8e2003de923e8573d3cc1a6fd7d0a4a5aff7fb82
import android.os.Bundle;
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
<<<<<<< HEAD
    private Button botonRegister;
    private EditText campoCorreo;
    private EditText campoContraseña;
    private boolean yaRegistro;
    /*SharedPreferences preferences;
    SharedPreferences.Editor editor;*/
    FirebaseAuth auth;
=======
    private EditText Nusuario;
    private EditText Iconraseña;
    private EditText Ccontraseña;
    private EditText direccion;
    private EditText ciudad;
    private EditText Ntelefono;
    private EditText Fnacimiento;
>>>>>>> 8e2003de923e8573d3cc1a6fd7d0a4a5aff7fb82
    private int dia;
    private int mes;
    private int año;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_registro_de_usuario_view);

<<<<<<< HEAD

        campoFecha = findViewById(R.id.et_fecha_nacimiento);
        campoFecha.setOnClickListener(new View.OnClickListener() {
=======
        Nusuario = (EditText) findViewById(R.id.edittext_nombre_usuario);
        Iconraseña = (EditText) findViewById(R.id.edittext_contraseña);
        Ccontraseña = (EditText) findViewById(R.id.editext_contraseña);
        direccion = (EditText) findViewById(R.id.edittext_direccion);
        ciudad = (EditText) findViewById(R.id.editext_ciudad);
        Ntelefono = (EditText) findViewById(R.id.editetxt_numero_telefono);
        Fnacimiento = (EditText) findViewById(R.id.editext_fecha_nacimiento);

        Fnacimiento.setOnClickListener(new View.OnClickListener() {
>>>>>>> 8e2003de923e8573d3cc1a6fd7d0a4a5aff7fb82
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
<<<<<<< HEAD
                        campoFecha.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
=======
                        Fnacimiento.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
>>>>>>> 8e2003de923e8573d3cc1a6fd7d0a4a5aff7fb82
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

<<<<<<< HEAD
}
=======
    //metodo para guardar datos en formulario y registrarsse
    public void Registrar(View view){
        Campo_vacio();
        Comparar_Valores();

        if (Campo_vacio() && Comparar_Valores()) {
            Toast.makeText(this, "Nuevo usuario", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "llenar todos los datos", Toast.LENGTH_SHORT).show();

        }
    }

    //metodo que compara los valores ingresados
    private boolean Comparar_Valores() {
        boolean retorno2;
        String NombreUsuario = "david".trim();

        String NomUsu = String.valueOf(Nusuario.getText()).trim();

        if(NombreUsuario.equals(NomUsu)){
            retorno2 = false;
            Toast.makeText(this, "nombre de usuario ya esta en uso", Toast.LENGTH_SHORT).show();
        }else{
            retorno2 = true;
        }

        return retorno2;
    }

    //metoodo que verifica los campos vacios en el formulario del registro de usuario
    public boolean Campo_vacio () {
        boolean retorno = true;

        String usu = Nusuario.getText().toString();
        String Icon = Iconraseña.getText().toString();
        String Ccon = Ccontraseña.getText().toString();
        String dir = direccion.getText().toString();
        String ciu = ciudad.getText().toString();
        String Ntel = Ntelefono.getText().toString();
        String Fnac = Fnacimiento.getText().toString();

        if (usu.isEmpty()) {
            Nusuario.setError("campo vacío");
            retorno = false;
            Toast.makeText(this, "Campo Vacio", Toast.LENGTH_SHORT).show();
        }
        if (Icon.isEmpty()) {
            Iconraseña.setError("campo vacío");
            retorno = false;
            Toast.makeText(this, "Campo Vacio", Toast.LENGTH_SHORT).show();
        }
        if (Ccon.isEmpty()) {
            Ccontraseña.setError("campo vacío");
            retorno = false;
            Toast.makeText(this, "Campo Vacio", Toast.LENGTH_SHORT).show();
        }
        if (dir.isEmpty()) {
            direccion.setError("campo vacío");
            retorno = false;
            Toast.makeText(this, "Campo Vacio", Toast.LENGTH_SHORT).show();
        }
        if (ciu.isEmpty()) {
            ciudad.setError("campo vacío");
            retorno = false;
            Toast.makeText(this, "Campo Vacio", Toast.LENGTH_SHORT).show();
        }
        if (Ntel.isEmpty()) {
            Ntelefono.setError("campo vacío");
            retorno = false;
            Toast.makeText(this, "Campo Vacio", Toast.LENGTH_SHORT).show();
        }
        if (Fnac.isEmpty()) {
            Fnacimiento.setError("campo vacío");
            retorno = false;
            Toast.makeText(this, "Campo Vacio", Toast.LENGTH_SHORT).show();
        }
        return retorno;

    }

}
>>>>>>> 8e2003de923e8573d3cc1a6fd7d0a4a5aff7fb82
