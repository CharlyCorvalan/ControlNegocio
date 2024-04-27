/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author yo
 */
public class BajaDeProducto {
    private int codigoBaja;
    private int codigoProducto;
    private int cantidad;
    private String motivo;

    public BajaDeProducto(int codigoBaja, int codigoProducto, int cantidad, String motivo) {
        this.codigoBaja = codigoBaja;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.motivo = motivo;
    }

    public BajaDeProducto(int codigoProducto, int cantidad, String motivo) {
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.motivo = motivo;
    }

    public int getCodigoBaja() {
        return codigoBaja;
    }

    public void setCodigoBaja(int codigoBaja) {
        this.codigoBaja = codigoBaja;
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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    
}
