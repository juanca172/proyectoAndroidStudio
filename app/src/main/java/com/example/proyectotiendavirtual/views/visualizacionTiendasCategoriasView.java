package com.example.proyectotiendavirtual.views;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyectotiendavirtual.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class visualizacionTiendasCategoriasView extends AppCompatActivity {
    //encapsulamiento del spinner
    private Spinner spinner;
    private AutoCompleteTextView aCText;
    //encapsulamiento del listView
    private RecyclerView rvtiendas;
    private AdaptadorTiendasProductos adapter;
    private List<CardViewAtributos> items;
    FirebaseDatabase database;
    FirebaseAuth auth;
    private DatabaseReference mDatabase;
    FirebaseFirestore mFireStore;
    private String nombre;
    private  String image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFireStore = FirebaseFirestore.getInstance();
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference().child("users");
        setContentView(R.layout.activity_visualizacion_tiendas_categorias_view);
        //Relacion entre la vista y la parte logica
        spinner = (Spinner)findViewById(R.id.PruebaSpinner);
        //Creacion de un array el cual tiene las categorias
        String [] categorias = {"Tecnologia", "Belleza y cuidado personal", "Articulos del hogar","televisores", "moda", "juegos y juguetes", "animales y mascotas"};
        //creacion de un adaptador para enviar datos al spinner
        ArrayAdapter<String> arrayAdaptador = new ArrayAdapter<String>(this, R.layout.item_menu, categorias);
        spinner.setAdapter(arrayAdaptador);

        //creacion de un adaptador para enviar datos al listView
        initViews();
        initValues();

        GetValuesFromFirestore();
    }
    //metodo para unir el widget del recycler con la parte logica
    public void initViews() {
        rvtiendas = findViewById(R.id.rvLista);
    }
    //metodo para ingresar los datos al recycler view
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
        itemsList.add(new CardViewAtributos("ponds", "desodorante", R.drawable.ponds));
        itemsList.add(new CardViewAtributos("axe", "desodorante",R.drawable.axe));
        itemsList.add(new CardViewAtributos("ego", "salsa de tomate", R.drawable.ego));


        return itemsList;
    }
    public void goToVistaIniciarSesionDesdeLasTiendas(View view) {
        Toast.makeText(this, "Sesion cerrada", Toast.LENGTH_LONG).show();
        auth = FirebaseAuth.getInstance();
        auth.signOut();
        Intent intent = new Intent(this, VistaIniciarSesion.class);
        startActivity(intent);
    }


    public void goToPerfil(View view){


        Intent intent = new Intent(this, EditarPerfil.class);

        startActivity(intent);
    }

    public void GetValuesFromFirestore() {
        mFireStore = FirebaseFirestore.getInstance();
        mFireStore.collection("ImagenesProductos").document("1").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    nombre = documentSnapshot.getString("Nombre");
                    image = documentSnapshot.getString("Imagen");
                    Toast.makeText(visualizacionTiendasCategoriasView.this, nombre, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}