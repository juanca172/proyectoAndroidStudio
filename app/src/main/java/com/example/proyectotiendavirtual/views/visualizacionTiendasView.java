package com.example.proyectotiendavirtual.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.proyectotiendavirtual.R;

public class visualizacionTiendasView extends AppCompatActivity {
    //encapsulamiento del spinner
    private Spinner spinner;
    //encapsulamiento del listView
    private ListView listado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizacion_tiendas_view);
        //Relacion entre la vista y la parte logica
        spinner = (Spinner)findViewById(R.id.PruebaSpinner);
        listado = (ListView)findViewById(R.id.list_view_1);
        //Creacion de un array el cual tiene las categorias
        String [] categorias = {"Tecnologia", "Belleza y cuidado personal", "Articulos del hogar","televisores", "moda", "juegos y juguetes", "animales y mascotas"};
        String [] tiendas = {"Samsung", "Xiaomi", "falabella", "X hobbies", "articulosHogar.SAS"};
        //creacion de un adaptador para enviar datos al spinner
        ArrayAdapter<String> arrayAdaptador = new ArrayAdapter<>(this, R.layout.spinner_item_visualizacion_categorias, categorias);
        spinner.setAdapter(arrayAdaptador);
        //creacion de un adaptador para enviar datos al listView
        ArrayAdapter<String> adapterListado = new ArrayAdapter<>(this, R.layout.list_view_visualizacion_tiendas_forma, tiendas);
        listado.setAdapter(adapterListado);
    }

    public void goToVistaIniciarSesionDesdeLasTiendas(View view) {
        Intent intent = new Intent(this, VistaIniciarSesion.class);
        startActivity(intent);
    }
}