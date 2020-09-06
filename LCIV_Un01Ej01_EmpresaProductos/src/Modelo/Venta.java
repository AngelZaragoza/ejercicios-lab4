/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Angel
 */
public class Venta {
    private int id;
    private String cliente;
    private int cantidad;
    private Producto producto;

    //CONSTRUCTOR
    public Venta(int id, String cliente, int cantidad, Producto producto) {
        this.id = id;
        this.cliente = cliente;
        this.cantidad = cantidad;
        this.producto = producto;
    }
    
    //GETTERS Y SETTERS    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Vta. " + id + " - " + cliente + " - Pr:" + producto.getNombre() + ", Cant: " + cantidad;
    }
    
    
    
}
