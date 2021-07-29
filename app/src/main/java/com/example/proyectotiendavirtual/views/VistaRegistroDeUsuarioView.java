package com.example.proyectotiendavirtual.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectotiendavirtual.R;

public class VistaRegistroDeUsuarioView extends AppCompatActivity {
    private EditText campoFecha;
    private EditText Nusuario;
    private EditText Iconraseña;
    private EditText Ccontraseña;
    private EditText direccion;
    private EditText ciudad;
    private EditText Ntelefono;
    private EditText Fnacimiento;
    private int dia;
    private int mes;
    private int año;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_registro_de_usuario_view);

        Nusuario = (EditText) findViewById(R.id.edittext_nombre_usuario);
        Iconraseña = (EditText) findViewById(R.id.edittext_contraseña);
        Ccontraseña = (EditText) findViewById(R.id.editext_contraseña);
        direccion = (EditText) findViewById(R.id.edittext_direccion);
        ciudad = (EditText) findViewById(R.id.editext_ciudad);
        Ntelefono = (EditText) findViewById(R.id.editetxt_numero_telefono);
        Fnacimiento = (EditText) findViewById(R.id.editext_fecha_nacimiento);

        Fnacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Fnacimiento.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    }
                }
                        ,dia, mes, año);
                datePickerDialog.show();
            }
        });

    }

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