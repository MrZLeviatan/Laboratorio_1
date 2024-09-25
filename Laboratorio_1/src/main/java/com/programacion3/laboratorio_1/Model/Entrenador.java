package com.programacion3.laboratorio_1.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Entrenador extends Persona implements Serializable {

    private static final long serialVersionUID= 1L;

    private Deporte deporte;
    private ArrayList<SesionEntrenamiento> listaSesiones;


    public Entrenador(String nombre, String cedula, Deporte deporte, ArrayList<SesionEntrenamiento> listaSesiones) {
        super(nombre, cedula);
        this.deporte = deporte;
        this.listaSesiones = listaSesiones;
    }

    public Entrenador(Deporte deporte, ArrayList<SesionEntrenamiento> listaSesiones) {
        this.deporte = deporte;
        this.listaSesiones = listaSesiones;
    }

    public Entrenador(){ }


    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public ArrayList<SesionEntrenamiento> getListaSesiones() {
        return listaSesiones;
    }

    public void setListaSesiones(ArrayList<SesionEntrenamiento> listaSesiones) {
        this.listaSesiones = listaSesiones;
    }
}
