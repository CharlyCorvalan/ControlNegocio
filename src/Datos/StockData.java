/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Entidades.Producto;
import Entidades.Stock;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yo
 */
public class StockData {
    private Connection con=null;

    public StockData() {
        this.con=Conexion.conectarse();
    }
    public void agregarStock(int x,int y){
        String sentencia="insert into stock (codigoProducto, cantidad)"
                + "values (?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(0, x);
            ps.setInt(1, y);
            int resultado=ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Stock agregador exitosamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla Stock");
        }
    }
    public void modificarStock(Stock x){
        String sentencia="upgadre stock set codigoProducto=?, cantidad=?"
                + "where codigoStock=?";
        try {
            PreparedStatement ps=con.prepareStatement(sentencia);
            ps.setInt(0, x.getCodigoProducto());
            ps.setInt(1, x.getCantidad());
            ps.setInt(2, x.getCodigoStock());
            int resultado=ps.executeUpdate();
            if(resultado==1){
                JOptionPane.showMessageDialog(null, "Stock modificado con exito");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el Stock "+x.getCodigoStock());
        }
    }
}
