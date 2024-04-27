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
public class OperacionVenta {
    private int codigoOpVenta, codigoVenta, codigoProducto, cantidad;
    private double precioUnitario;
    private LocalDate fechaVenta;

    public OperacionVenta(int codigoOpVenta, int codigoVenta, int codigoProducto, int cantidad, double precioUnitario, LocalDate fechaVenta) {
        this.codigoOpVenta = codigoOpVenta;
        this.codigoVenta = codigoVenta;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fechaVenta = fechaVenta;
    }

    public OperacionVenta(int codigoVenta, int codigoProducto, int cantidad, double precioUnitario, LocalDate fechaVenta) {
        this.codigoVenta = codigoVenta;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fechaVenta = fechaVenta;
    }

    public int getCodigoOpVenta() {
        return codigoOpVenta;
    }

    public void setCodigoOpVenta(int codigoOpVenta) {
        this.codigoOpVenta = codigoOpVenta;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
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

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    
}
