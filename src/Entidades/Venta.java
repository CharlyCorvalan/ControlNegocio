/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author yo
 */
public class Venta {
    private int codigoVenta;
    private double monto;
    private LocalDate fecha;

    public Venta(int codigoVenta, double monto, LocalDate fecha) {
        this.codigoVenta = codigoVenta;
        this.monto = monto;
        this.fecha = fecha;
    }

    public Venta(double monto, LocalDate fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }

    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    
}
