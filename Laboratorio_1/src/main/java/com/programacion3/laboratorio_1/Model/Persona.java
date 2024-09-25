package com.programacion3.laboratorio_1.Model;

import java.io.Serializable;

public abstract class Persona implements Serializable {

    private static final long serialVersionUID= 1L;

    private String nombre;
    private String cedula;


    public Persona(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public Persona(){

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
