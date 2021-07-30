/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author koke
 */
public class Doctor {
    String nombreD, telD, direccion, correoD, ced, especialidad, horario;
    int edad;

    public Doctor() {
    }

    public Doctor(String nombreD, String telD, String direccion, String correoD, String ced, String especialidad, String horario, int edad) {
        this.nombreD = nombreD;
        this.telD = telD;
        this.direccion = direccion;
        this.correoD = correoD;
        this.ced = ced;
        this.especialidad = especialidad;
        this.horario = horario;
        this.edad = edad;
    }

    public String getNombreD() {
        return nombreD;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    public String getTelD() {
        return telD;
    }

    public void setTelD(String telD) {
        this.telD = telD;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoD() {
        return correoD;
    }

    public void setCorreoD(String correoD) {
        this.correoD = correoD;
    }

    public String getCed() {
        return ced;
    }

    public void setCed(String ced) {
        this.ced = ced;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
