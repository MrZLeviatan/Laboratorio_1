package com.programacion3.laboratorio_1.Controller;

import com.programacion3.laboratorio_1.Exceptions.DeportesException;
import com.programacion3.laboratorio_1.Exceptions.PersonaException;
import com.programacion3.laboratorio_1.Exceptions.SesionesException;
import com.programacion3.laboratorio_1.Model.*;
import com.programacion3.laboratorio_1.Utils.Persistencia;

import java.io.IOException;
import java.util.ArrayList;

public class ModelFactory {

    ClubXd clubXd;


    public static class SingletonHolder {
        private final static ModelFactory eINSTANCE;

        static {
            try {
                eINSTANCE = new ModelFactory();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }

    public static ModelFactory getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ClubXd getCineXd() { return clubXd; }


    private ModelFactory() {

        clubXd = new ClubXd();

        System.out.printf("YO TE INVOCO!! CLASE Singleton ");

        cargarDatos();

        registraAccionesSistema("Inicio De Sesion ", 1, "La Aplicacion Se Inicio");


    }


    public int addAdministrador(Administrador administrador) throws PersonaException {

        if (getCineXd().personaExiste(null,administrador.getCedula(),administrador.getUserName().getUsername())){
            getCineXd().addPersona(administrador);
            salvarDatos();
            // Record of actions in our Log.
            registraAccionesSistema("Se agrega el Administrador ID  "
                    + administrador.getCedula(), 1, " Registro de Publicador");
            return 1;
        } else {
            return 2;
        }
    }

    public boolean deleteAdministrador(Administrador administrador) throws PersonaException {
        if (administrador.equals(null)){
            registraAccionesSistema("Error al eliminar Administrador",2,"Error de Eliminacion");
            return false;
        }else{
            getCineXd().removerPersona(administrador);
            salvarDatos();
            registraAccionesSistema("Eliminacin de Administrador con ID " + administrador.getCedula(),
                    3,  "Eliminacion de Publicador");
            return true;
        }
    }

    public boolean actualizarAdministrador(Administrador administrador) throws PersonaException {

        getCineXd().actualizarPersona(administrador.getCedula(),administrador);
        salvarDatos();
        registraAccionesSistema("Actualizacion Datos de Administrador con ID " + administrador.getCedula(),
                4, " Actualizacion Datos de Publicador");
        return true;

    }


    public int addMiembro(Miembros miembro) throws PersonaException {

        if (getCineXd().personaExiste(miembro.getCorreo(),miembro.getCedula(),miembro.getUserName().getUsername())){
            getCineXd().addPersona(miembro);
            salvarDatos();
            // Record of actions in our Log.
            registraAccionesSistema("Se agrega el Miembro ID  "
                    + miembro.getCedula(), 1, " Registro de Publicador");
            return 1;
        } else {
            return 2;
        }
    }


    public boolean deleteMiembro(Miembros miembros) throws PersonaException {
        if (miembros.equals(null)){
            registraAccionesSistema("Error al eliminar Miembror",2,"Error de Eliminacion");
            return false;
        }else{
            getCineXd().removerPersona(miembros);
            salvarDatos();
            registraAccionesSistema("Eliminacin de Miembro con ID " + miembros.getCedula(),
                    3,  "Eliminacion de Publicador");
            return true;
        }
    }


    public boolean actualizarMiembro(Miembros miembros) throws PersonaException {

        getCineXd().actualizarPersona(miembros.getCedula(),miembros);
        salvarDatos();
        registraAccionesSistema("Actualizacion Datos de Miembro con ID " + miembros.getCedula(),
                4, " Actualizacion Datos de Publicador");
        return true;

    }


    public int addEntrenador(Entrenador entrenador) throws PersonaException {

        if (getCineXd().personaExiste(null,entrenador.getCedula(),entrenador.getUserName().getUsername())){
            getCineXd().addPersona(entrenador);
            salvarDatos();
            // Record of actions in our Log.
            registraAccionesSistema("Se agrega el Entrenador ID  "
                    + entrenador.getCedula(), 1, " Registro de Publicador");
            return 1;
        } else {
            return 2;
        }
    }

    public boolean deleteEntrenador(Entrenador entrenador) throws PersonaException {
        if (entrenador.equals(null)){
            registraAccionesSistema("Error al eliminar Entrenador",2,"Error de Eliminacion");
            return false;
        }else{
            getCineXd().removerPersona(entrenador);
            salvarDatos();
            registraAccionesSistema("Eliminacin de Entrenador con ID " + entrenador.getCedula(),
                    3,  "Eliminacion de Publicador");
            return true;
        }
    }

    public boolean actualizarEntrenador(Entrenador entrenador) throws PersonaException {

        getCineXd().actualizarPersona(entrenador.getCedula(),entrenador);
        salvarDatos();
        registraAccionesSistema("Actualizacion Datos de Miembro con ID " + entrenador.getCedula(),
                4, " Actualizacion Datos de Publicador");
        return true;

    }

    public int addDeporte(Deporte deporte) throws PersonaException, DeportesException {

        if (getCineXd().deporteExiste(deporte.getNombre())){
            getCineXd().addDeporte(deporte);
            salvarDatos();
            // Record of actions in our Log.
            registraAccionesSistema("Se agrega el Deporte "
                    + deporte.getNombre(), 1, " Registro de Publicador");
            return 1;
        } else {
            return 2;
        }
    }


    public boolean deleteDeporte(Deporte deporte) throws DeportesException {
        if (deporte.equals(null)){
            registraAccionesSistema("Error al eliminar Deporte",2,"Error de Eliminacion");
            return false;
        }else{
            getCineXd().removerDeporte(deporte);
            salvarDatos();
            registraAccionesSistema("Eliminacin de Deporte " + deporte.getNombre(),
                    3,  "Eliminacion de Deporte");
            return true;
        }
    }

    public boolean actualizarDeporte(Deporte deporte) throws PersonaException {

        getCineXd().actualizarDeporte(deporte.getNombre(),deporte);
        salvarDatos();
        registraAccionesSistema("Actualizacion Datos de Miembro con ID " + deporte.getNombre(),
                4, " Actualizacion Datos de Publicador");
        return true;

    }

    public int addSesion(SesionEntrenamiento sesionEntrenamiento) throws SesionesException {

        getCineXd().addSesion(sesionEntrenamiento);
        salvarDatos();
        registraAccionesSistema("Se agrega una Sesion De Entrenamiento", 1, " Registro de Publicador");
        return 1;

    }

    public boolean deleteSesion(SesionEntrenamiento sesionEntrenamiento) throws SesionesException {
        getCineXd().removerSesion(sesionEntrenamiento);
        salvarDatos();
        registraAccionesSistema("Eliminacin de Sesion de Entrenamiento ",
                3,  "Eliminacion de Deporte");
        return true;
    }


    public ArrayList<Administrador> obtenerAdministradores(){
        return getCineXd().getListaAdministradores();
    }

    public ArrayList<Deporte> obtenerDeportes(){
        return getCineXd().obtenerDeportes();
    }

    public ArrayList<Entrenador> obtenerEntrenadores(){
        return getCineXd().obtenerEntrenadores();
    }

    public ArrayList<Miembros> obtenerMiembros(){
        return getCineXd().obtenerMiembros();
    }

    public ArrayList<SesionEntrenamiento> obtenerSesiones() {
        return getCineXd().obtenerSesiones();
    }

    public int auntentificador(String username, String password) {

        if (getCineXd().autentificadorGeneral(username, password) == 1) {
            registraAccionesSistema("Ingreso el Admin", 3, " Ingreso Plataforma");
            return 1;

        } else if (getCineXd().autentificadorGeneral(username, password) == 2) {
            registraAccionesSistema("Ingreso el Entrenador", 3, " Ingreso Plataforma");
            return 2;
        }else if (getCineXd().autentificadorGeneral(username, password) == 3){
            registraAccionesSistema("Ingreso el Miembro",3," Ingreso Plataforma");
            return 3;

        }else{
            return 0;
        }
    }

    public Deporte hallarDeporte(String nombre){
        return getCineXd().hallarDeporte(nombre);
    }


    private void registraAccionesSistema(String mensaje, int nivel, String accion){
        Persistencia.guardaRegistroLog(mensaje,nivel,accion);

    }


    private void salvarDatos() {

        try {

            Persistencia.guardarAdmin(getCineXd().obtenerAdmins());
            Persistencia.guardarEntrenador(getCineXd().obtenerEntrenadores());
            Persistencia.guardarDeporte(getCineXd().getListaDeportes());
            Persistencia.guardarMiembros(getCineXd().getListaMiembros());
            Persistencia.guardarSesiones(getCineXd().getListaSesiones());
            //   guardarResourseXML();
            // guardarResourseBinario();


        } catch (IOException e) {

            throw new RuntimeException(e);

        }
    }


    public void cargarDatos(){
        try {

            Persistencia.cargarDatosArchivos(getCineXd());

        } catch (IOException e){
            throw new RuntimeException("Error cargando los datos: " + e.getMessage(), e);
        }
    }

}
