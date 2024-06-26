/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author yo
 */
public class Stock {
    private int codigoStock;
    private int codigoProducto;
    private int cantidad;   

    public Stock(int codigoStock, int codigoProducto, int cantidad) {
        this.codigoStock = codigoStock;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
    }

    public Stock(int codigoProducto, int cantidad) {
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
    }

    public int getCodigoStock() {
        return codigoStock;
    }

    public void setCodigoStock(int codigoStock) {
        this.codigoStock = codigoStock;
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
    
    
}
