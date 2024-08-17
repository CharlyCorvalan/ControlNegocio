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
import java.util.ArrayList;
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
        String sentencia="update compra set monto=?, fechaCompra=? where codigoCompra=?";
        try {
            PreparedStatement ps=con.prepareStatement(sentencia);
            ps.setDouble(1, compra.getMonto());
            ps.setDate(2, Date.valueOf(compra.getFecha()));
            ps.setInt(3, compra.getCodigoCompra());
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
        int contador=0;
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
                    contador++;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla operacion compra");
            }
        }
        if(pr.size()+1==contador){
            JOptionPane.showMessageDialog(null, "Compra agregada satisfactoriamente");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo cargar la operacion de compra");
        }
    }
    public void modificarOpCompra(ArrayList<OperacionCompra> listaOp){
        ArrayList<OperacionCompra> opCom=new ArrayList<>();
        opCom=listaOp;
        int contador=0;
        for (OperacionCompra aux : opCom) {
            String sentencia="update operacion-compra set  codigoProducto=?"
                + "cantidad=?, precioUnitario=? where codigoOpCompra=?";
        try {
            PreparedStatement ps=con.prepareStatement(sentencia);            
            ps.setInt(1, aux.getCodigoProducto());
            ps.setInt(2, aux.getCantidad());
            ps.setDouble(3, aux.getPrecioUnitario());            
            ps.setInt(4, aux.getCodigoOpCompra());
            int resultado =ps.executeUpdate();
            if(resultado==1){
                contador++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla operacion de compra");            
        }        
        }
        if(contador==opCom.size()+1){
        JOptionPane.showMessageDialog(null, "Operacion de compra modificada exitosamente");
    }else{
            JOptionPane.showMessageDialog(null,"Error al modificar la operacion de compra" );
        }
    }
}
