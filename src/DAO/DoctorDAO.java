/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clases.Doctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author koke
 */
public class DoctorDAO implements CRUD{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List lista() {
        List<Doctor> listar = new ArrayList<Doctor>();
        String sql = "SELECT * FROM doctor";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Doctor doc = new Doctor();
                doc.setId(rs.getInt(1));
                doc.setNombreD(rs.getString(2));
                doc.setTelD(rs.getString(3));
                doc.setDireccion(rs.getString(4));
                doc.setCorreoD(rs.getString(5));
                doc.setCed(rs.getString(6));
                doc.setEspecialidad(rs.getString(7));
                doc.setHorario(rs.getString(8));
                doc.setEdad(rs.getInt(9));
                
                listar.add(doc);
            }
            
        } catch (Exception e) {
            System.out.println("Error al listar doctores" + e);
        }
        return listar;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO doctor(nombre, telefono, direccion, correo, cedula, especialidad, horario, edad) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            
            for (int i = 0; i < 8; i++) {
                ps.setObject(i+1, o[i]);
            }
            
            r = ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error al añadir doctor" + e);
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE doctor SET nombre = ?, telefono = ?, direccion = ?, correo = ?, cedula = ?, especialidad = ?, horario = ?, edad = ? WHERE idDoc = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            
            for (int i = 0; i < 8; i++) {
                ps.setObject(i+1, o[i]);
            }
            r = ps.executeUpdate();
        } catch (Exception e) {
            
            System.out.println("Error al modificar doctor" + e);
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM doctor WHERE idDoc = ?";
        
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar doctor" + e);
        }
    }
    
}
