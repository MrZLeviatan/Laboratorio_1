package com.programacion3.laboratorio_1.Model;

import com.programacion3.laboratorio_1.Model.Enum.TipoMiembro;

import java.io.Serializable;
import java.util.ArrayList;

public class Miembros extends Persona implements Serializable {

    private static final long serialVersionUID= 1L;

    private String correo;
    private TipoMiembro tipoMiembro;
    private ArrayList<Deporte> listaDeportes;

    public Miembros(String nombre, String cedula, UserName userName, String correo, TipoMiembro tipoMiembro, ArrayList<Deporte> listaDeportes) {
        super(nombre, cedula, userName);
        this.correo = correo;
        this.tipoMiembro = tipoMiembro;
        this.listaDeportes = listaDeportes;
    }

    public Miembros(String correo, TipoMiembro tipoMiembro, ArrayList<Deporte> listaDeportes) {
        this.correo = correo;
        this.tipoMiembro = tipoMiembro;
        this.listaDeportes = listaDeportes;
    }

    public Miembros(){}


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public TipoMiembro getTipoMiembro() {
        return tipoMiembro;
    }

    public void setTipoMiembro(TipoMiembro tipoMiembro) {
        this.tipoMiembro = tipoMiembro;
    }

    public ArrayList<Deporte> getListaDeportes() {
        return listaDeportes;
    }

    public void setListaDeportes(ArrayList<Deporte> listaDeportes) {
        this.listaDeportes = listaDeportes;
    }
}
