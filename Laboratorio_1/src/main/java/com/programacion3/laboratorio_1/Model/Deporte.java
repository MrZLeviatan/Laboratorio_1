package com.programacion3.laboratorio_1.Model;

import com.programacion3.laboratorio_1.Model.Enum.TipoDificultad;

import java.io.Serializable;
import java.util.ArrayList;

public class Deporte implements Serializable {


    private static final long serialVersionUID= 1L;
    private String nombre;
    private String descripcion;
    private TipoDificultad tipoDificultad;
    private ArrayList<Entrenador> listaEntrenadores;


    public Deporte(String nombre, String descripcion, TipoDificultad tipoDificultad, ArrayList<Entrenador> listaEntrenadores) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoDificultad = tipoDificultad;
        this.listaEntrenadores = listaEntrenadores;
    }

    public Deporte(){}


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

    public TipoDificultad getTipoDificultad() {
        return tipoDificultad;
    }

    public void setTipoDificultad(TipoDificultad tipoDificultad) {
        this.tipoDificultad = tipoDificultad;
    }

    public ArrayList<Entrenador> getListaEntrenadores() {
        return listaEntrenadores;
    }

    public void setListaEntrenadores(ArrayList<Entrenador> listaEntrenadores) {
        this.listaEntrenadores = listaEntrenadores;
    }
}
