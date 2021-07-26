/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clases.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Koke
 */
public class HospitalDAO implements CRUD{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List lista() {
        List<Paciente> lista = new ArrayList<Paciente>();
        String sql = "SELECT * FROM pacientes ";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Paciente p = new Paciente();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setTel(rs.getString(3));
                p.setCorreo(rs.getString(4));
                p.setEdad(rs.getInt(5));
                p.setPeso(rs.getFloat(6));
                p.setAltura(rs.getFloat(7));
                p.setPresion(rs.getFloat(8));
                p.setSangre(rs.getString(9));
                p.setAlergias(rs.getString(10));
                p.setPadecimiento(rs.getString(11));
         
                lista.add(p);
                
            }
            
        } catch (Exception e) {
            System.out.println("Error al mostrar los pacientes: " + e);
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO pacientes(nombre, telefono, correo, edad, peso, altura, presion, sangre, alergias, padecimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.setObject(7, o[6]);
            ps.setObject(8, o[7]);
            ps.setObject(9, o[8]);
            ps.setObject(10, o[9]);


            r = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al insertar paciente: " + e);
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE pacientes SET nombre = ?, telefono = ?, correo = ?, edad = ?, peso = ?, altura = ?, presion = ?, sangre = ?, alergias = ?, padecimiento = ? WHERE id = ?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.setObject(7, o[6]);
            ps.setObject(8, o[7]);
            ps.setObject(9, o[8]);
            ps.setObject(10, o[9]);
            ps.setObject(11, o[10]);

            r = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al modificar un alumno: " + e);
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM pacientes WHERE id = ?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error al eliminar paciente" + e);
        }
        
    }
    
    
}
