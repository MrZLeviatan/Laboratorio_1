package com.programacion3.laboratorio_1.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class ClubXd implements Serializable {

    private static final long serialVersionUID= 1L;

    public ClubXd(){}

    private ArrayList<Administrador> listaAdministradores = new ArrayList<>();
    private ArrayList<Deporte> listaDeportes = new ArrayList<>();
    private ArrayList<Entrenador> listaEntrenador = new ArrayList<>();
    private ArrayList<Miembros> listaMiembros = new ArrayList<>();
    private ArrayList<SesionEntrenamiento> listaSesiones = new ArrayList<>();



    public ArrayList<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(ArrayList<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public ArrayList<Deporte> getListaDeportes() {
        return listaDeportes;
    }

    public void setListaDeportes(ArrayList<Deporte> listaDeportes) {
        this.listaDeportes = listaDeportes;
    }

    public ArrayList<Entrenador> getListaEntrenador() {
        return listaEntrenador;
    }

    public void setListaEntrenador(ArrayList<Entrenador> listaEntrenador) {
        this.listaEntrenador = listaEntrenador;
    }

    public ArrayList<Miembros> getListaMiembros() {
        return listaMiembros;
    }

    public void setListaMiembros(ArrayList<Miembros> listaMiembros) {
        this.listaMiembros = listaMiembros;
    }

    public ArrayList<SesionEntrenamiento> getListaSesiones() {
        return listaSesiones;
    }

    public void setListaSesiones(ArrayList<SesionEntrenamiento> listaSesiones) {
        this.listaSesiones = listaSesiones;
    }


    public void addPersona(Persona persona){
        if (persona == null){

        }else if(persona instanceof  Administrador administrador){
            listaAdministradores.add(administrador);
        }else if (persona instanceof Entrenador entrenador){
            listaEntrenador.add(entrenador);
        } else if (persona instanceof Miembros miembros) {
            listaMiembros.add(miembros);
        }
    }

    public void addDeporte(Deporte deporte){
        if (deporte == null){

        }else {
            listaDeportes.add(deporte);
        }
    }


    public void removerPersona(Persona persona){
        if (persona == null){

        }else if (persona instanceof Administrador administrador){
            listaAdministradores.remove(administrador);
        }else if (persona instanceof Entrenador entrenador){
            listaEntrenador.remove(entrenador);
        } else if (persona instanceof Miembros miembros) {
            listaMiembros.remove(miembros);
        }
    }


    public void removerDeporte(Deporte deporte){
        if (deporte == null){

        }else {
            listaDeportes.remove(deporte);
        }
    }

    public boolean administradorExiste(Integer id){
        return listaAdministradores.stream().anyMatch(administrador -> administrador.getCedula().equals(id));
    }

    public boolean entrenadorExiste(Integer id){
        return listaEntrenador.stream().anyMatch(entrenador -> entrenador.getCedula().equals(id));
    }

    public boolean miembroExiste(Integer id){
        return listaMiembros.stream().anyMatch(miembros -> miembros.getCedula().equals(id));
    }


    public int personaExiste(Integer id){
        if (administradorExiste(id)) return 1;
        if (entrenadorExiste(id)) return 2;
        if (miembroExiste(id)) return 3;
        return 0;
    }


    public boolean correoMiembro(String correo){
        return listaMiembros.stream().anyMatch(miembros -> miembros.getCorreo().equals(correo));
    }


    

}
