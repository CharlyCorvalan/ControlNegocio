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
            String sentencia="insert into producto (descripcion,categoria,precio,marca,estado)"
                    + "values (?,?,?,?,?)";
            PreparedStatement ps=conectar.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, x.getDescripcion());
            ps.setString(2, x.getCategoria());
            ps.setDouble(3, x.getPrecio());
            ps.setString(4, x.getMarca());
            ps.setBoolean(5, true);
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
        String sentencia="update producto set descripcion=?, categoria=?,precio=?, marca=? "
                + "where codigoProducto=?";
        try {
            PreparedStatement ps=conectar.prepareStatement(sentencia);
            ps.setString(1, x.getDescripcion());
            ps.setString(2, x.getCategoria());
            ps.setDouble(3, x.getPrecio());
            ps.setString(4, x.getMarca());
            ps.setInt(5, x.getCodigoProducto());
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
    public ArrayList<Producto> listarProductos(){
        ArrayList<Producto> pro=new ArrayList<>();
        String sentencia="select * from Producto where estado=1";
        try {
            PreparedStatement ps= conectar.prepareStatement(sentencia);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Producto pro1=new Producto();
                pro1.setCodigoProducto(rs.getInt("codigoProducto"));
                pro1.setDescripcion(rs.getString("descripcion"));
                pro1.setPrecio(rs.getDouble("precio"));
                pro1.setCategoria(rs.getString("categoria"));
                pro1.setMarca(rs.getString("marca"));
                
                pro.add(pro1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto");
        }
        return pro;
    }
    public ArrayList<Producto> buscarCategoria(String categoria){
        ArrayList<Producto>proArray=new ArrayList<>();
        String sentencia="select * from Producto where categoria=?";
        try {
            PreparedStatement ps=conectar.prepareStatement(sentencia);
            ps.setString(1, categoria);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Producto producto=new Producto();
                producto.setCodigoProducto(rs.getInt("codigoProducto"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setMarca(rs.getString("marca"));
                producto.setPrecio(rs.getDouble("precio"));
                proArray.add(producto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto");
        }
        return proArray;
    }
    public ArrayList<Producto> buscarMarca(String marca){
        ArrayList<Producto>proArray=new ArrayList<>();
        String sentencia="select * from Producto where marca=?";
        try {
            PreparedStatement ps=conectar.prepareStatement(sentencia);
            ps.setString(1, marca);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Producto producto=new Producto();
                producto.setCodigoProducto(rs.getInt("codigoProducto"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setMarca(rs.getString("marca"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto");
        }
        
        return proArray;
    }
}
