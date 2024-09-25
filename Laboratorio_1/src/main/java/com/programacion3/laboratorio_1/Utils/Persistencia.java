package com.programacion3.laboratorio_1.Utils;

import com.programacion3.laboratorio_1.Model.Administrador;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Persistencia {


    public static final String RUTA_ARCHIVO_LOG = "src/main/resources/DataBase/Log/Log.txt";




    // ------------------------ Log ---------------------------
    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion){

        ArchivoUtil.guardarRegistroLog(mensajeLog,nivel,accion,RUTA_ARCHIVO_LOG);
    }


    public static void guardarAdmin(ArrayList<Administrador> listaAdministrador){

    }
}
