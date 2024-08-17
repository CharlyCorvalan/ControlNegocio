/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import Entidades.OperacionVenta;
import Entidades.Producto;
import Entidades.Venta;
import java.sql.*;
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
public class VentaData {
    private Connection con=null;

    public VentaData() {
        this.con=Conexion.conectarse();
    }
    public void altaVenta(Venta venta){
        String sentencia="insert into venta (monto, fechaVenta)"
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
                JOptionPane.showMessageDialog(null, "Venta modificada satisfactoriamente");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla venta");
        }        
    }
    public void altaOpVenta(TreeMap vt, Venta venta){
        TreeMap<Producto,Integer>proven=new TreeMap<>();
        proven=vt;
        int contador=0;
        for (Map.Entry<Producto, Integer> entry : proven.entrySet()) {
            Producto key = entry.getKey();
            Integer val = entry.getValue();
            String sentencia="insert into operacion-venta (codigoVenta, codigoProducto"
                + "cantidad, precioUnitario, fechaVenta) values (?,?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sentencia,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, venta.getCodigoVenta());
            ps.setInt(2, key.getCodigoProducto());
            ps.setInt(3, val);
            ps.setDouble(4, key.getPrecio());
            ps.setDate(5, Date.valueOf(venta.getFecha()));
            int resultado=ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                contador++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error alacceder a la tabla venta");
        }
            
        }
        if(proven.size()+1==contador){
               JOptionPane.showMessageDialog(null, "Operacion de venta cargada satisfactoriamente");
           }else{
               JOptionPane.showMessageDialog(null, "No se pudo cargar la Operacion de venta");
           } 
    }
    public void modificarOpVenta(ArrayList<OperacionVenta> opVenta){
        ArrayList<OperacionVenta>opVen=new ArrayList<>(opVenta);
        int contador=0;
        for (OperacionVenta aux : opVen) {
            String sentencia="update operacion-venta set codigoProducto=?, cantidad=?"
                    + "precioUnitario=? where codigoVenta=? ";
            try {
                PreparedStatement ps=con.prepareStatement(sentencia);
                ps.setInt(1, aux.getCodigoProducto());
                ps.setInt(2, aux.getCantidad());
                ps.setDouble(3, aux.getPrecioUnitario());
                ps.setInt(4, aux.getCodigoVenta());
                int resultado=ps.executeUpdate();
                if(resultado==1){
                    contador++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(VentaData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(contador==opVen.size()+1){
            JOptionPane.showMessageDialog(null, "Operacion de venta modificada exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "Error al modificar operacion de venta");
        }
    }
}
