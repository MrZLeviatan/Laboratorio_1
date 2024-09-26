package com.programacion3.laboratorio_1.Model;

import com.programacion3.laboratorio_1.Exceptions.DeportesException;
import com.programacion3.laboratorio_1.Exceptions.MiembroException;
import com.programacion3.laboratorio_1.Exceptions.PersonaException;
import com.programacion3.laboratorio_1.Exceptions.SesionesException;
import com.programacion3.laboratorio_1.Model.Enum.TipoDificultad;
import com.programacion3.laboratorio_1.Model.Enum.TipoMiembro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

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


    public void addPersona(Persona persona) throws PersonaException {
        if (persona == null){
            throw new PersonaException("Persona Null");
        }else if(persona instanceof  Administrador administrador){
            listaAdministradores.add(administrador);
        }else if (persona instanceof Entrenador entrenador){
            listaEntrenador.add(entrenador);
        } else if (persona instanceof Miembros miembros) {
            listaMiembros.add(miembros);
        }
    }

    public void addDeporte(Deporte deporte) throws DeportesException {
        if (deporte == null){
            throw new DeportesException("Deporte Nulo");
        }else {
            listaDeportes.add(deporte);
        }
    }

    public void addSesion(SesionEntrenamiento sesionEntrenamiento) throws SesionesException {
        if (sesionEntrenamiento==null){
            throw new SesionesException("Sesion Entrenamiento nulo");
        } else{
            listaSesiones.add(sesionEntrenamiento);
        }
    }


    public void removerPersona(Persona persona) throws PersonaException {
        if (persona == null){
            throw new PersonaException("Persona Null");
        }else if (persona instanceof Administrador administrador){
            listaAdministradores.remove(administrador);
        }else if (persona instanceof Entrenador entrenador){
            listaEntrenador.remove(entrenador);
        } else if (persona instanceof Miembros miembros) {
            listaMiembros.remove(miembros);
        }
    }


    public void removerDeporte(Deporte deporte) throws DeportesException {
        if (deporte == null){
            throw new DeportesException("Deporte nulo");
        }else {
            listaDeportes.remove(deporte);
        }
    }

    public void removerSesion(SesionEntrenamiento sesionEntrenamiento) throws SesionesException {
        if (sesionEntrenamiento==null){
            throw new SesionesException("Sesion Deporte nulo");
        }else{
            listaSesiones.remove(sesionEntrenamiento);
        }
    }


    public void actualizarPersona(String id,Persona persona) throws PersonaException {

        if (persona==null){
            throw new PersonaException("Persona nula");
        } else if (persona instanceof Administrador administrador) {
            actualizarAdmi(id,administrador);
        } else if (persona instanceof Miembros miembro) {
            actualizarMiembro(id,miembro);
        } else if (persona instanceof Entrenador entrenador) {
            actualizarEntrenador(id,entrenador);
        }
    }


    public void actualizarAdmi(String id, Administrador administradorActualizado){
        for (Administrador administrador: listaAdministradores){
            if (administrador.getCedula().equals(id)){
                listaAdministradores.set(listaAdministradores.indexOf(administrador),administradorActualizado);
                break;
            }
        }
    }

    public void actualizarMiembro(String id, Miembros miembroActualizado){
        for (Miembros miembro: listaMiembros){
            if (miembro.getCedula().equals(id)){
                listaMiembros.set(listaMiembros.indexOf(miembro),miembroActualizado);
                break;
            }
        }
    }

    public void actualizarEntrenador(String id, Entrenador entrenadorActualizado){
        for (Entrenador entrenador: listaEntrenador){
            if (entrenador.getCedula().equals(id)){
                listaEntrenador.set(listaEntrenador.indexOf(entrenador),entrenadorActualizado);
                break;
            }
        }
    }

    public void actualizarDeporte(String nombre, Deporte deporteActualizado){
        for (Deporte deporte: listaDeportes){
            if (deporte.getNombre().equals(nombre)){
                listaDeportes.set(listaDeportes.indexOf(deporte),deporteActualizado);
                break;
            }
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

    public boolean deporteExiste(String nombre){
        return listaDeportes.stream().anyMatch(deporte -> deporte.getNombre().equals(nombre));
    }


    public int logger(Integer id){
        if (administradorExiste(id)) return 1;
        if (entrenadorExiste(id)) return 2;
        if (miembroExiste(id)) return 3;
        return 0;
    }


    public boolean personaExiste(String correo,String id, String username){

        if (correo == null){
            if (!idExiste(id)){
                if (!usernameExiste(username)){
                    return true;
                }
            }
        }else if (!correoMiembro(correo)){
            if (!idExiste(id)){
                if (!usernameExiste(username)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean correoMiembro(String correo){
        return listaMiembros.stream().anyMatch(miembros -> miembros.getCorreo().equals(correo));
    }

    public boolean idExiste(String id){
        return Stream.of(listaAdministradores,listaMiembros,listaEntrenador)
                .flatMap(Collection::stream).anyMatch(persona -> persona.getCedula().equalsIgnoreCase(id));
    }

    public boolean usernameExiste(String username){
        return Stream.of(listaAdministradores,listaMiembros,listaEntrenador)
                .flatMap(Collection::stream).anyMatch(persona -> persona.getUserName().equals(username));
    }


    public int autentificadorGeneral(String username, String password){

        if (autentificadorAdmi(username,password)){
            return 1;
        
        } else if (autentificadorEntrenador(username,password)) {
            return 2;

        } else if (autentificadorMiembro(username,password)) {
            return 3;
        }else{
            return 0;
        }

    }


    public boolean autentificadorAdmi(String username, String password){
        for (Administrador administrador: listaAdministradores){
            if (administrador.getUserName().getUsername().equals(username)) {
                return administrador.getUserName().getPassword().equals(password)? true : false;
            }
        }
        return false;
    }

    public boolean autentificadorEntrenador(String username, String password){
        for (Entrenador entrenador: listaEntrenador){
            if (entrenador.getUserName().getUsername().equals(username)) {
                return entrenador.getUserName().getPassword().equals(password)? true : false;
            }
        }
        return false;
    }


    public boolean autentificadorMiembro(String username, String password){
        for (Miembros miembros: listaMiembros){
            if (miembros.getUserName().getUsername().equals(username)) {
                return miembros.getUserName().getPassword().equals(password)? true : false;
            }
        }
        return false;
    }


    public ArrayList<Administrador> obtenerAdmins(){
        return listaAdministradores;
    }

    public ArrayList<Entrenador> obtenerEntrenadores(){
        return listaEntrenador;
    }

    public ArrayList<Miembros> obtenerMiembros(){
        return listaMiembros;
    }

    public ArrayList<Deporte> obtenerDeportes(){
        return listaDeportes;
    }

    public ArrayList<SesionEntrenamiento> obtenerSesiones(){
        return listaSesiones;
    }


    public Entrenador hallarEntrenador(String id){
        return listaEntrenador.stream().filter(entrenador -> entrenador.getCedula().equalsIgnoreCase(id)).findFirst().get();
    }

    public Deporte hallarDeporte(String nombre){
        return listaDeportes.stream().filter(deporte -> deporte.getNombre().equalsIgnoreCase(nombre)).findFirst().get();
    }

    public Miembros hallarMiembro(String id){
        return listaMiembros.stream().filter(miembros -> miembros.getCedula().equalsIgnoreCase(id)).findFirst().get();
    }

    public void agregarEntrenadorDeporte(String id,String nombreDe){
        Entrenador entrenador = hallarEntrenador(id);
        Deporte deporte = hallarDeporte(nombreDe);
        deporte.getListaEntrenadores().add(entrenador);
    }

    public void agregarSesionEntrenador(String id, SesionEntrenamiento sesionEntrenamiento){
        Entrenador entrenador = hallarEntrenador(id);
        entrenador.getListaSesiones().add(sesionEntrenamiento);
    }

    public void agregarDeporteMiembros(String id,String nombre) throws MiembroException {
        Miembros miembros = hallarMiembro(id);
        Deporte deporte = hallarDeporte(nombre);

        if (miembros.getTipoMiembro().equals(TipoMiembro.Juvenil)){
            if (!deporte.getTipoDificultad().equals(TipoDificultad.ALTO)){
                miembros.getListaDeportes().add(deporte);
            }else{
                throw new MiembroException("Error agregad deporte");
            }
        }else if (miembros.getTipoMiembro().equals(TipoMiembro.Adulto)){
            miembros.getListaDeportes().add(deporte);
        }
    }
}
