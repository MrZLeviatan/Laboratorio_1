package com.programacion3.laboratorio_1.Model;

import com.programacion3.laboratorio_1.Model.Enum.TipoCategoria;

public class Producto {


    /**
     * -Se crean las variables del Producto
     * -Son private las variables pues para ingresar a ellas toca mediante Producto
     */
    private String codigo;
    private String nombre;
    private double precio;
    private String descripcion;
    // Se llama el TipoCategoria de la carpeta enum
    private TipoCategoria tipoCategoria;

    // Se crea el constructor con sus variables
    public Producto(String codigo, String nombre, double precio, String descripcion, TipoCategoria tipoCategoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tipoCategoria = tipoCategoria;
    }
    // Se crea el constructor vacio.
    public Producto() {
    }

    // Getters y Setters.
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoCategoria getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(TipoCategoria tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }
}
