/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Koke
 */
public class Conexion {
    Connection con;
    String url = "jdbc:mysql://localhost/hospital";
    String user = "root";
    String pass = "";
    
    public Connection Conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion exitosa con la Base de Datos ");
            
        } catch (ClassNotFoundException e) {
            System.out.println("Error al conectarse con la Base de Datos: " + e);
        } catch(SQLException r){
            System.out.println("Error con la BD: " + r);
        }
        return con;
    }
    
}
