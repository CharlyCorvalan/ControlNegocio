/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;






/**
 *
 * @author yo
 */
public class Conexion {
    private final static String URL="jdbc:mysql://localhost:3306/";
    private final static String DB="control-negocio";
    private final static String Driver="org.mariadb.jdbc.Driver";
    private final static String Usuario="root";
    private final static String Password="";
    private static Connection connection;

    public Conexion() {
    }
    
    public static Connection conectarse(){
        if(connection==null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection=DriverManager.getConnection(URL+DB,Usuario,Password);  
                JOptionPane.showMessageDialog(null, "Conexion exitosa");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar los drivers");
            }catch(SQLException xe){
                JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos");
            }
        }
        return connection;
    }
    
}
    

