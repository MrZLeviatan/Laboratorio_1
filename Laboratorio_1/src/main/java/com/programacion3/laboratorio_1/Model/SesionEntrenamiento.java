package com.programacion3.laboratorio_1.Model;

import com.programacion3.laboratorio_1.Model.Enum.EstadoSesion;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class SesionEntrenamiento implements Serializable {

    private static final long serialVersionUID= 1L;

    private LocalDate fecha;
    private LocalTime duracion;
    private EstadoSesion estadoSesion;
    private Deporte deporte;
    private Entrenador entrenador;

    public SesionEntrenamiento(LocalDate fecha, LocalTime duracion, EstadoSesion estadoSesion, Deporte deporte, Entrenador entrenador) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.estadoSesion = estadoSesion;
        this.deporte = deporte;
        this.entrenador = entrenador;
    }

    public SesionEntrenamiento(){}


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    public EstadoSesion getEstadoSesion() {
        return estadoSesion;
    }

    public void setEstadoSesion(EstadoSesion estadoSesion) {
        this.estadoSesion = estadoSesion;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
}
