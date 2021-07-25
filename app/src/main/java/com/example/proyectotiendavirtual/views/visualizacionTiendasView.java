package com.example.proyectotiendavirtual.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.proyectotiendavirtual.R;

public class visualizacionTiendasView extends AppCompatActivity {
    //encapsulamiento del spinner
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizacion_tiendas_view);
        //Relacion entre la vista y la parte logica
        spinner = (Spinner)findViewById(R.id.PruebaSpinner);
        //Creacion de un array
        String [] things = {"Tecnologia", "Belleza y cuidado personal", "Articulos del hogar","televisores", "moda", "juegos y juguetes", "animales y mascotas"};
        //creacion de un adaptador para enviar datos al spinner
        ArrayAdapter<String> arrayAdaptador = new ArrayAdapter<>(this, R.layout.spinner_item_visualizacion_tiendas, things);
        spinner.setAdapter(arrayAdaptador);
    }
}