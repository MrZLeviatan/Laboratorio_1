package com.programacion3.laboratorio_1.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Miembros extends Persona implements Serializable {

    private static final long serialVersionUID= 1L;

    private String correo;
    private ArrayList<Deporte> listaDeportes;

    public Miembros(String nombre, String cedula, String correo, ArrayList<Deporte> listaDeportes) {
        super(nombre, cedula);
        this.correo = correo;
        this.listaDeportes = listaDeportes;
    }

    public Miembros(String correo, ArrayList<Deporte> listaDeportes) {
        this.correo = correo;
        this.listaDeportes = listaDeportes;
    }

    public Miembros(){}


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
