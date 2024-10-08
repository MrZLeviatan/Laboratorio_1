package com.programacion3.laboratorio_1.Model;

import java.util.ArrayList;

public class Punto3 {


    private ArrayList<Producto> listaProducto = new ArrayList<>();


    public ArrayList<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(ArrayList<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }


    public int addProducto(Producto producto){
        if (producto != null){
            listaProducto.add(producto);
            return 1;
        }else{
            return 0;
        }
    }

    public int removeProducto(Producto producto){
        if (producto != null){
            listaProducto.remove(producto);
            return 1;
        }else {
            return 0;
        }
    }


    public Producto hallarProducto(String codigo){
        return listaProducto.stream().filter(producto -> producto.getCodigo()
                .equalsIgnoreCase(codigo)).findFirst().get();
    }


    public void actualizarProducto(String codigo,Producto productoActualizado){
        for (Producto producto :listaProducto){
            if (producto.getCodigo().equalsIgnoreCase(codigo)){
                listaProducto.set(listaProducto.indexOf(producto), productoActualizado);
                break;
            }
        }
    }


    public ArrayList<Producto> obtenerProducto(){
        return listaProducto;
    }

    // Metodo recursivo para calcular el total
    public static double calcularTotal(ArrayList<Producto> productosSeleccionados,int indice){
        // Caso base: si no quedan mas productos, retornar 0
        if (indice == productosSeleccionados.size()){
            return 0;
        }
        // Obtener el valor del producto actual
        double valorProducto = productosSeleccionados.get(indice).getPrecio();
        // Llamada recursiva al siguiente producto
        double totalParcial = calcularTotal(productosSeleccionados,indice+1);

        // Retornar el valor del producto actual sumando al total parcial
        return valorProducto + totalParcial;
    }

    // Metodo para aplicar el descuento si el total supera los $500
    public static double calcularTotalConDescuento(ArrayList<Producto> productosSeleccionados){
        // Calcular el total usando la funcion recursiva
        double total = calcularTotal(productosSeleccionados,0);

        // Aplicar el descuento si el total es mayor a $500
        if (total > 500){
            total = total *0.90; // Descuento 10%
        }
        return total;
    }

}
