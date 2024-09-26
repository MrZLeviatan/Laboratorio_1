package com.programacion3.laboratorio_1.Controller;

import com.programacion3.laboratorio_1.Exceptions.PersonaException;
import com.programacion3.laboratorio_1.Model.Administrador;
import com.programacion3.laboratorio_1.Model.Deporte;
import com.programacion3.laboratorio_1.Model.Entrenador;
import com.programacion3.laboratorio_1.Model.Miembros;

import java.util.ArrayList;

public class RegistroController {

    ModelFactory modelFactoryController;

    // ModelFactory Instance.
    public RegistroController(){ modelFactoryController = ModelFactory.getInstance();
    }


    public boolean registroAdministrador(Administrador administrador) throws PersonaException {
        if (modelFactoryController.addAdministrador(administrador) == 1){
            return true;
        }else{
            return false;
        }
    }

    public boolean registrarMiembro(Miembros miembros) throws PersonaException {
        if (modelFactoryController.addMiembro(miembros) == 1){
            return true;
        }else {
            return false;
        }
    }

    public boolean registroEntrenador(Entrenador entrenador) throws PersonaException {
        if (modelFactoryController.addEntrenador(entrenador) == 1){
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Deporte> obtenerDeportes(){
        return modelFactoryController.obtenerDeportes();
    }

    public Deporte hallarDeporte(String nombre){
        return modelFactoryController.hallarDeporte(nombre);
    }

}
