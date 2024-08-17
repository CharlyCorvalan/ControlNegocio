/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalDate;

/**
 *
 * @author yo
 */
public class OperacionCompra {
    private int codigoOpCompra, codigoCompra, codigoProducto, cantidad;
    private double precioUnitario;
    private LocalDate fechaCompra;

    public OperacionCompra(int codigoOpCompra, int codigoCompra, int codigoProducto, int cantidad, double precioUnitario, LocalDate fechaCompra) {
        this.codigoOpCompra = codigoOpCompra;
        this.codigoCompra = codigoCompra;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fechaCompra = fechaCompra;
    }

    public OperacionCompra(int codigoCompra, int codigoProducto, int cantidad, double precioUnitario, LocalDate fechaCompra) {
        this.codigoCompra = codigoCompra;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fechaCompra = fechaCompra;
    }

    public OperacionCompra() {
    }
    

    public int getCodigoOpCompra() {
        return codigoOpCompra;
    }

    public void setCodigoOpCompra(int codigoOpCompra) {
        this.codigoOpCompra = codigoOpCompra;
    }

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
}
