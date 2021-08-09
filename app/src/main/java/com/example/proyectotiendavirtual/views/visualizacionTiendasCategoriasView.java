package com.example.proyectotiendavirtual.views;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.proyectotiendavirtual.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class visualizacionTiendasCategoriasView extends AppCompatActivity {
    //encapsulamiento del spinner
    private Spinner spinner;
    private AutoCompleteTextView aCText;
    //encapsulamiento del listView
    private ListView listado;
    FirebaseDatabase database;
    private DatabaseReference mDatabase;

    //Creacion de un array el cual tiene las categorias
    private String [] categorias = {"Tecnologia", "Belleza y cuidado personal", "Articulos del hogar","televisores", "moda", "juegos y juguetes", "animales y mascotas"};
    private String [] tiendas = {"Samsung", "Xiaomi", "falabella", "X hobbies", "articulosHogar.SAS"};

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference().child("users");
        setContentView(R.layout.activity_visualizacion_tiendas_categorias_view);
        //Relacion entre la vista y la parte logica
        spinner = (Spinner)findViewById(R.id.PruebaSpinner);
        listado = (ListView)findViewById(R.id.list_view_1);



        aCText = findViewById(R.id.autoComplete);

        //creacion de un adaptador para enviar datos al spinner
        ArrayAdapter<String> arrayAdaptador = new ArrayAdapter<String>(this, R.layout.item_menu, categorias);
        spinner.setAdapter(arrayAdaptador);
        aCText.setText(arrayAdaptador.getItem(0).toString(), false);
        aCText.setAdapter(arrayAdaptador);
        //creacion de un adaptador para enviar datos al listView
        ArrayAdapter<String> adapterListado = new ArrayAdapter<>(this, R.layout.list_view_visualizacion_tiendas_forma, tiendas);
        listado.setAdapter(adapterListado);
    }

    public void goToVistaIniciarSesionDesdeLasTiendas(View view) {
        Intent intent = new Intent(this, VistaIniciarSesion.class);
        startActivity(intent);
    }


    public void goToPerfil(View view){
        Intent intent = new Intent(this, EditarPerfil.class);
        mDatabase.orderByChild("id").equalTo("Neck pain");
        intent.putExtra("resultado" , "1");
        startActivity(intent);
    }
}