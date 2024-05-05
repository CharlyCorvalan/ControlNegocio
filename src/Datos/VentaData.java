/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import Entidades.Venta;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author yo
 */
public class VentaData {
    private Connection con=null;

    public VentaData() {
        this.con=Conexion.conectarse();
    }
    public void altaVenta(Venta venta){
        String sentencia="insert into venta (monto, fechaCompra)"
                + "values (?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1,venta.getMonto() );
            ps.setDate(2, Date.valueOf(venta.getFecha()));
            int resultado =ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Venta agregada con exito");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla venta");
        }
    }
    public void modificarVenta(Venta venta){
        String sentencia="update venta set monto=?, fechaVenta=? where codigoVenta =?";
        try {
            PreparedStatement ps=con.prepareStatement(sentencia);
            ps.setDouble(1, venta.getMonto());
            ps.setDate(2, Date.valueOf(venta.getFecha()));
            ps.setInt(3, venta.getCodigoVenta());
            int resultado =ps.executeUpdate();
            if(resultado==1){
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de venta");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla venta");
        }
        
    }
}
