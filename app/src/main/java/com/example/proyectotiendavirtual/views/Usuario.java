package com.example.proyectotiendavirtual.views;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Usuario {
    public String nombre;
    public String correo;
    public String direccion;
    public String ciudad;
    public String telefono;
    public String fechaNacimiento;

    public Usuario(String nombre, String correo, String direccion, String ciudad, String telefono, String fechaNacimiento) {
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }
    public Usuario(){
    }

}
