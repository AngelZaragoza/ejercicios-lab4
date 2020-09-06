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
public class DTOVenta {
    private String cliente;
    private int cantidad;
    private String producto;
    private double precioProducto;

    public DTOVenta(String cliente, int cantidad, String producto, double precioProducto) {
        this.cliente = cliente;
        this.cantidad = cantidad;
        this.producto = producto;
        this.precioProducto = precioProducto;
    }

    public String getCliente() {
        return cliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }
    
    
    
    
}
