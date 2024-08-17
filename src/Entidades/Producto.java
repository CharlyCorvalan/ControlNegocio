/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author yo
 */
public class Producto {
    private int codigoProducto;
    private String descripcion;
    private double precio;
    private String categoria;
    private String marca;

    public Producto() {
    }
    

    public Producto(int codigoProducto, String descripcion, double precio, String categoria,String marca) {
        this.codigoProducto = codigoProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.marca=marca;
    }

    public Producto(String descripcion, double precio, String categoria,String marca) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.marca=marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

   
}
