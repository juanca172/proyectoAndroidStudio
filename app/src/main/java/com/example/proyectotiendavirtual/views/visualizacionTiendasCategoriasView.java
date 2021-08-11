package com.example.proyectotiendavirtual.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.proyectotiendavirtual.R;

import java.util.ArrayList;
import java.util.List;

public class visualizacionTiendasCategoriasView extends AppCompatActivity {
    //encapsulamiento del spinner
    private Spinner spinner;
    //encapsulamiento del listView
    private RecyclerView rvtiendas;
    private AdaptadorTiendasProductos adapter;
    private List<CardViewAtributos> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizacion_tiendas_categorias_view);
        //Relacion entre la vista y la parte logica
        spinner = (Spinner)findViewById(R.id.PruebaSpinner);
        //Creacion de un array el cual tiene las categorias
        String [] categorias = {"Tecnologia", "Belleza y cuidado personal", "Articulos del hogar","televisores", "moda", "juegos y juguetes", "animales y mascotas"};
        //creacion de un adaptador para enviar datos al spinner
        ArrayAdapter<String> arrayAdaptador = new ArrayAdapter<>(this, R.layout.spinner_item_visualizacion_categorias, categorias);
        spinner.setAdapter(arrayAdaptador);
        //creacion de un adaptador para enviar datos al listView
        initViews();
        initValues();


    }

    public void initViews() {
        rvtiendas = findViewById(R.id.rvLista);
    }
    public void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvtiendas.setLayoutManager(manager);

        items = getItems();
        adapter = new AdaptadorTiendasProductos(items);
        rvtiendas.setAdapter(adapter);
    }

    public List<CardViewAtributos> getItems() {
        List<CardViewAtributos> itemsList = new ArrayList<>();
        itemsList.add(new CardViewAtributos("Tomate", "salsa de tomate", R.drawable.tomate));
        itemsList.add(new CardViewAtributos("axe", "desodorante",R.drawable.axe));
        itemsList.add(new CardViewAtributos("ponds", "panhhahajajka", R.drawable.ponds));
        return itemsList;
    }
    public void goToVistaIniciarSesionDesdeLasTiendas(View view) {
        Intent intent = new Intent(this, VistaIniciarSesion.class);
        startActivity(intent);
    }
}