package com.programacion3.laboratorio_1.Model;

import java.io.Serializable;

public class Administrador extends Persona implements Serializable {

    private static final long serialVersionUID= 1L;

    public Administrador(String nombre, String cedula, UserName userName) {
        super(nombre, cedula, userName);
    }

    public Administrador() {
    }


}
