package com.example.proyectotiendavirtual.views;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardViewAtributos  {
    //nombre del producto
    public String nombre;
    //descripcion del producto
    public String descripcion;
    //como tenemos nuestras imagenes en la carpeta drawable por eso es entero
    private int ImagenDeTienda;

    public CardViewAtributos(String nombre,String descripcion,int ImagenDeTienda) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ImagenDeTienda = ImagenDeTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagenDeTienda() {
        return ImagenDeTienda;
    }

    public void setImagenDeTienda(int imageResource) {
        this.ImagenDeTienda = imageResource;
    }
}
