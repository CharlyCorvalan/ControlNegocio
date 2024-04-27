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
public class Compra {
    private int codigoCompra;
    private double monto;
    private LocalDate fecha;

    public Compra(int codigoCompra, double monto, LocalDate fecha) {
        this.codigoCompra = codigoCompra;
        this.monto = monto;
        this.fecha = fecha;
    }

    public Compra(double monto, LocalDate fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
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
