package com.example.proyectotiendavirtual.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectotiendavirtual.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;


public class EditarPerfil extends AppCompatActivity {

    Button btnCircle;
    private Button campoFecha;
    private EditText nombre;
    private EditText ciudad;
    private EditText direccion;
    private EditText correoE;
    private EditText telefono;



    private DatePickerDialog datePickerDialog;
    FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private ArrayList<ModeloUsuario> usuarioList;
    private ModeloUsuario usuarioR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference().child("users");

        campoFecha = findViewById(R.id.eFecha);
        nombre = findViewById(R.id.eNombre);
        ciudad = findViewById(R.id.eCiudad);
        direccion = findViewById(R.id.eDireccion);
        correoE = findViewById(R.id.eCorreo);
        telefono = findViewById(R.id.eTelefono);

        SharedPreferences mPrefs = getSharedPreferences("usuario",0);
        String correo = mPrefs.getString("correo", "");

        if(!correo.isEmpty()){

            Query query = mDatabase.orderByChild("email").equalTo(correo);
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull  DataSnapshot snapshot) {
                    usuarioList  = new ArrayList<ModeloUsuario>();
                    if(snapshot.exists()){

                        for(DataSnapshot usuario: snapshot.getChildren()){
                            ModeloUsuario data = usuario.getValue(ModeloUsuario.class);
                            usuarioList.add(data);

                            usuarioR = usuarioList.get(0);

                            campoFecha.setText(usuarioR.fecha);
                            nombre.setText(usuarioR.nombre);
                            ciudad.setText(usuarioR.ciudad);
                            direccion.setText(usuarioR.direccion);
                            correoE.setText(usuarioR.email);
                            telefono.setText(usuarioR.telefono);


                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull  DatabaseError error) {

                }
            });


        }

        Toast.makeText(this, correo, Toast.LENGTH_LONG).show();




        initDatePicker();
        campoFecha.setText(getTodayDate());


    }

    private String getTodayDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        month = month +1;
        return makeDateString(day, month, year);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month +1 ;
                String date = makeDateString(day, month, year);
                campoFecha.setText(date);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);


    }


    private String makeDateString(int day, int month, int year) {
        return day + " / " + month +" / "+ year;

    }

    public void openDatePicker(View view) {
        datePickerDialog.show();

    }
}