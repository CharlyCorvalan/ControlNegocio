/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.*;
import Entidades.Compra;
import Entidades.OperacionCompra;
import Entidades.Producto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yo
 */
public class CompraData {

    private Connection con = null;

    public CompraData() {
        this.con = Conexion.conectarse();
    }
    public void altaCompra(Compra compra){
        String sentencia="insert into compra (monto, fechaCompra)"
                + "values (?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, compra.getMonto());
            ps.setDate(2, Date.valueOf(compra.getFecha()));
            int resultado =ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Compra cargada exitosamente");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla compra");
        }
    }
    public void modificarCompra(Compra compra){
        String sentencia="update compra set monto=?, fechaCompra=?";
        try {
            PreparedStatement ps=con.prepareStatement(sentencia);
            ps.setDouble(1, compra.getMonto());
            ps.setDate(2, Date.valueOf(compra.getFecha()));
            int resultado=ps.executeUpdate();
            if(resultado ==1){
                JOptionPane.showMessageDialog(null, "Compra modificada exitosamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla compra");
        }
        
    }
    public void altaOpCompra(TreeMap pr, Compra compra) {
        TreeMap<Producto, Integer> prod = new TreeMap<>();
        prod = pr;
        for (Map.Entry<Producto, Integer> aux : prod.entrySet()) {
            Producto key = aux.getKey();
            Integer val = aux.getValue();
            String sentencia = "insert into operacion-compra (codigoCompra, codigoProducto, precioUnitario, cantidad, fechaCompra)"
                    + "values (?,?,?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, compra.getCodigoCompra());
                ps.setInt(2, key.getCodigoProducto());
                ps.setDouble(3, key.getPrecio());
                ps.setInt(4, val);
                ps.setDate(5, Date.valueOf(compra.getFecha()));
                int resultado = ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Ingresado producto " + key.getCodigoProducto());
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla operacion compra");
            }
        }
    }
    public void modificarOpCompra(OperacionCompra opcompra){
        String sentencia="update operacion-compra set codigoCompra=?, codigoProducto=?"
                + "cantidad=?, precioUnitario=?, fechaCompra=? where codigoOpCompra=?";
        try {
            PreparedStatement ps=con.prepareStatement(sentencia);
            ps.setInt(1, opcompra.getCodigoCompra());
            ps.setInt(2, opcompra.getCodigoProducto());
            ps.setInt(3, opcompra.getCantidad());
            ps.setDouble(4, opcompra.getPrecioUnitario());
            ps.setDate(5, Date.valueOf(opcompra.getFechaCompra()));
            ps.setInt(6, opcompra.getCodigoOpCompra());
            int resultado =ps.executeUpdate();
            if(resultado==1){
                JOptionPane.showMessageDialog(null, "Operacion de compra modificado con exito");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla operacion de compra");
            
        }
    }
}
