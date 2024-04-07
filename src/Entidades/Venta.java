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
    private int codigo;
    private double monto;
    private LocalDate fecha;
    private ArrayList<Producto>lista;

    public Venta(int codigo, double monto, LocalDate fecha, ArrayList<Producto> lista) {
        this.codigo = codigo;
        this.monto = monto;
        this.fecha = fecha;
        this.lista = lista;
    }

    public Venta(double monto, LocalDate fecha, ArrayList<Producto> lista) {
        this.monto = monto;
        this.fecha = fecha;
        this.lista = lista;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public ArrayList<Producto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Producto> lista) {
        this.lista = lista;
    }
    
    
}
