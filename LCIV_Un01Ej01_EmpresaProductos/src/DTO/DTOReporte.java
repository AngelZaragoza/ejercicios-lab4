/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Angel
 */
public class DTOReporte {
    private String producto;
    private int cantidad;

    //CONSTRUCTOR
    public DTOReporte(String producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    //GETTERS
    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
    
        
}
