package com.example.proyectotiendavirtual.views;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class ModeloUsuario {

    public String nombre;
    public String email;
    public String contrasena;
    public String direccion;
    public String ciudad;
    public String telefono;
    public String fecha;





    public ModeloUsuario() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public ModeloUsuario(String nombre, String email, String contrasena, String direccion, String ciudad, String telefono, String fecha) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.fecha = fecha;
    }
}
