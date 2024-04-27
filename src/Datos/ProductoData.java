/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Entidades.Producto;
import java.sql.*;
import java.sql.Connection.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yo
 */
public class ProductoData {
    private Connection conectar=null;
    public ProductoData() {
        this.conectar=Conexion.conectarse();
    }
    public void cargarProducto(Producto x ){
        try {
            String sentencia="insert into producto (descripcion,categoria,precio)"
                    + "values (?,?,?)";
            PreparedStatement ps=conectar.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, x.getDescripcion());
            ps.setString(2, x.getCategoria());
            ps.setDouble(3, x.getPrecio());
            int resultado = ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                x.setCodigoProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Producto agregado exitosamente");
            }
            ps.close();        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la tabla Productos");
        }   
    }
    public void modificarProducto(Producto x){
        String sentencia="update producto set descripcion=?, categoria=?,precio=? "
                + "where codigoProducto=?";
        try {
            PreparedStatement ps=conectar.prepareStatement(sentencia);
            ps.setString(1, x.getDescripcion());
            ps.setString(2, x.getCategoria());
            ps.setDouble(3, x.getPrecio());
            ps.setInt(4, x.getCodigoProducto());
            int resultado=ps.executeUpdate();
            if(resultado==1){
                JOptionPane.showMessageDialog(null, "Producto modificado exitosamente");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el producto codigo: "+x.getCodigoProducto());
        }
    }
    public void eliminarProducto(Producto x){
        String sentencia="update producto set estado=0 where codigoProducto=?";
        try {
            PreparedStatement ps=conectar.prepareStatement(sentencia);
            ps.setInt(1, x.getCodigoProducto());
            int resultado=ps.executeUpdate();
            if(resultado==1){
                JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al elimimar producto");
        }
    }
}
