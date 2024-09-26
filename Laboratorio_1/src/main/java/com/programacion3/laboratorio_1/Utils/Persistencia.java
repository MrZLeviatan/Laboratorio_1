package com.programacion3.laboratorio_1.Utils;

import com.programacion3.laboratorio_1.Model.*;
import com.programacion3.laboratorio_1.Model.Enum.EstadoSesion;
import com.programacion3.laboratorio_1.Model.Enum.TipoDificultad;
import com.programacion3.laboratorio_1.Model.Enum.TipoMiembro;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Persistencia {


    public static final String RUTA_ARCHIVO_LOG = "src/main/resources/DataBase/Log/Log.txt";
    public static final String RUTA_ARCHIVO_MIEMBROS = "src/main/resources/DataBase/Docs/Miembros/Miembros.txt";
    public static final String RUTA_ARCHIVO_ADMINS = "src/main/resources/DataBase/Docs/Admins/Admins.txt";
    public static final String RUTA_ARCHIVO_Deportes = "src/main/resources/DataBase/Docs/Deportes/Deportes.txt";
    public static final String RUTA_ARCHIVO_Entrenadores = "src/main/resources/DataBase/Docs/Entrenadores/Entrenadores.txt";
    public static final String RUTA_ARCHIVO_Sesiones = "src/main/resources/DataBase/Docs/Sesiones/Sesiones.txt";


    // ------------------------ Log ---------------------------
    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion) {

        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }


    public static void guardarAdmin(ArrayList<Administrador> listaAdministrador) throws IOException {

        String contenido = "";

        for (Administrador administrador : listaAdministrador) {
            contenido += administrador.getNombre() +
                    " @@ " + administrador.getCedula() +
                    " @@ " + administrador.getUserName().getUsername() +
                    " @@ " + administrador.getUserName().getPassword() + "\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ADMINS, contenido, false);

    }


    public static void guardarEntrenador(ArrayList<Entrenador> listaEntrenadores) throws IOException {

        String contenido = "";

        for (Entrenador entrenador : listaEntrenadores) {
            contenido += entrenador.getNombre() +
                    " @@ " + entrenador.getCedula() +
                    " @@ " + entrenador.getUserName().getUsername() +
                    " @@ " + entrenador.getUserName().getPassword() +
                    " @@ " + entrenador.getDeporte().getNombre() + "\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_Entrenadores, contenido, false);

    }


    public static void guardarDeporte(ArrayList<Deporte> listaDeportes) throws IOException {

        String contenido = "";

        for (Deporte deporte : listaDeportes) {
            contenido += deporte.getNombre() +
                    " @@ " + deporte.getTipoDificultad() +
                    " @@ " + deporte.getDescripcion() + "\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_Deportes, contenido, false);

    }

    public static void guardarSesiones(ArrayList<SesionEntrenamiento> listaSesiones) throws IOException {

        String contenido = "";

        for (SesionEntrenamiento sesiones : listaSesiones) {
            contenido += sesiones.getDeporte().getNombre() +
                    " @@ " + sesiones.getEstadoSesion() +
                    " @@ " + sesiones.getEntrenador().getNombre() +
                    " @@ " + sesiones.getEntrenador().getCedula() +
                    " @@ " + sesiones.getDuracion() +
                    " @@ " + sesiones.getFecha() + "\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_Sesiones, contenido, false);

    }


    public static void guardarMiembros(ArrayList<Miembros> miembros) throws IOException {

        String contenido = "";

        for (Miembros miembro : miembros) {
            contenido += miembro.getNombre() +
                    " @@ " + miembro.getCedula() +
                    " @@ " + miembro.getCorreo() +
                    " @@ " + miembro.getTipoMiembro() +
                    " @@ " + miembro.getUserName().getUsername() +
                    " @@ " + miembro.getUserName().getPassword() + "\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_MIEMBROS, contenido, false);

    }


    public static ArrayList<Administrador> cargarAdministrador() throws FileNotFoundException, IOException {

        ArrayList<Administrador> administradores = new ArrayList<Administrador>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivos(RUTA_ARCHIVO_ADMINS);
        String linea = "";

        for (int i = 0; i < contenido.size(); i++) {

            Administrador administrador = new Administrador();
            administrador.setNombre(linea.split(" @@ ")[0]);
            administrador.setCedula(linea.split(" @@ ")[1]);

            UserName userName = new UserName();
            userName.setUsername(linea.split(" @@ ")[2]);
            userName.setPassword(linea.split(" @@ ")[3]);
            administrador.setUserName(userName);

            administradores.add(administrador);
        }

        return administradores;
    }


    public static ArrayList<Entrenador> cargarEntrenadores() throws FileNotFoundException, IOException {
        ArrayList<Entrenador> entrenadores = new ArrayList<Entrenador>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivos(RUTA_ARCHIVO_Entrenadores);
        String linea = "";

        for (int i = 0; i < contenido.size(); i++) {

            Entrenador entrenador = new Entrenador();
            entrenador.setNombre(linea.split(" @@ ")[0]);
            entrenador.setCedula(linea.split(" @@ ")[1]);

            UserName userName = new UserName();
            userName.setUsername(linea.split(" @@ ")[2]);
            userName.setPassword(linea.split(" @@ ")[3]);
            entrenador.setUserName(userName);

            Deporte deporte = new Deporte();
            deporte.setNombre(linea.split(" @@ ")[4]);

            entrenador.setDeporte(deporte);

            entrenadores.add(entrenador);

        }

        return entrenadores;
    }


    public static ArrayList<Deporte> cargarDeportes() throws FileNotFoundException, IOException {
        ArrayList<Deporte> deportes = new ArrayList<Deporte>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivos(RUTA_ARCHIVO_Deportes);
        String linea = "";

        for (int i = 0; i < contenido.size(); i++) {

            Deporte deporte = new Deporte();
            deporte.setNombre(linea.split(" @@ ")[0]);
            deporte.setTipoDificultad(TipoDificultad.valueOf(linea.split(" @@ ")[1]));
            deporte.setDescripcion(linea.split(" @@ ")[2]);

            deportes.add(deporte);
        }

        return deportes;
    }


    public static ArrayList<Miembros> cargarMiembros() throws FileNotFoundException, IOException {
        ArrayList<Miembros> miembross = new ArrayList<Miembros>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivos(RUTA_ARCHIVO_MIEMBROS);
        String linea ="";

        for (int i = 0; i < contenido.size(); i++) {

            linea = contenido.get(i);

            Miembros miembros = new Miembros();
            miembros.setNombre(linea.split(" @@ ")[0]);
            miembros.setCedula(linea.split(" @@ ")[1]);
            miembros.setCorreo(linea.split(" @@ ")[2]);
            miembros.setTipoMiembro(TipoMiembro.valueOf(linea.split(" @@ ")[3]));

            UserName userName = new UserName();

            userName.setUsername(linea.split(" @@ ")[4]);
            userName.setPassword(linea.split(" @@ ")[5]);

            miembros.setUserName(userName);

            miembross.add(miembros);
        }


        return miembross;
    }


    public static void cargarDatosArchivos(ClubXd clubXd) throws IOException {
        ArrayList<Miembros> miembros = cargarMiembros();
        if (miembros.size() > 0)
            clubXd.getListaMiembros().addAll(miembros);
    }

    public static ArrayList<SesionEntrenamiento> cargarSeleccion() throws FileNotFoundException, IOException {
        ArrayList<SesionEntrenamiento> selecciones = new ArrayList<SesionEntrenamiento>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivos(RUTA_ARCHIVO_Sesiones);
        String linea = "";

        for (int i = 0; i < contenido.size(); i++) {

            SesionEntrenamiento sesion = new SesionEntrenamiento();
            Deporte deporte = new Deporte();
            deporte.setNombre(linea.split(" @@ ")[0]);

            sesion.setDeporte(deporte);
            sesion.setEstadoSesion(EstadoSesion.valueOf(linea.split(" @@ ")[1]));

            Entrenador entrenador = new Entrenador();
            entrenador.setNombre(linea.split(" @@ ")[2]);
            entrenador.setNombre(linea.split(" @@ ")[3]);

            sesion.setEntrenador(entrenador);

            sesion.setDuracion(LocalTime.parse(linea.split(" @@ ")[4]));
            sesion.setFecha(LocalDate.parse(linea.split(" @@ ")[5]));

            selecciones.add(sesion);
        }


        return selecciones;
}
}




