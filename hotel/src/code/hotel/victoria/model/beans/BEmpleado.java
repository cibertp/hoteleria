/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.hotel.victoria.model.beans;

import java.sql.Date;

/**
 *
 * @author RolaQ
 */
public class BEmpleado {
    private int id_empleado;
    private String nombre;
    private String apellido_pat;
    private String apellido_mat;
    private String dni;
    private String telefono;
    private String id_distrito;
    private String fecha_ingreso;
    private String id_estado;
    private String id_tipo;
    private String fecha_nacimiento;
    private String id_departamento;
    private String usuario;

    public BEmpleado() {}
    public BEmpleado(int id_empleado, String nombre, String apellido_pat, String apellido_mat, String dni, String telefono, String id_distrito, String fecha_ingreso, String id_estado, String id_tipo, String fecha_nacimiento, String id_departamento, String usuario) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido_pat = apellido_pat;
        this.apellido_mat = apellido_mat;
        this.dni = dni;
        this.telefono = telefono;
        this.id_distrito = id_distrito;
        this.fecha_ingreso = fecha_ingreso;
        this.id_estado = id_estado;
        this.id_tipo = id_tipo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.id_departamento = id_departamento;
        this.usuario = usuario;
    }

    public BEmpleado(String nombre, String apellido_pat, String apellido_mat, String dni, String telefono, String id_distrito, String fecha_ingreso, String id_estado, String id_tipo, String fecha_nacimiento, String id_departamento) {
        this.nombre = nombre;
        this.apellido_pat = apellido_pat;
        this.apellido_mat = apellido_mat;
        this.dni = dni;
        this.telefono = telefono;
        this.id_distrito = id_distrito;
        this.fecha_ingreso = fecha_ingreso;
        this.id_estado = id_estado;
        this.id_tipo = id_tipo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.id_departamento = id_departamento;
    }
    
    public BEmpleado(int id_empleado, String nombre, String apellido_pat, String apellido_mat, String dni, String telefono, String id_distrito, String fecha_ingreso, String id_estado, String id_tipo, String fecha_nacimiento, String id_departamento) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido_pat = apellido_pat;
        this.apellido_mat = apellido_mat;
        this.dni = dni;
        this.telefono = telefono;
        this.id_distrito = id_distrito;
        this.fecha_ingreso = fecha_ingreso;
        this.id_estado = id_estado;
        this.id_tipo = id_tipo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.id_departamento = id_departamento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_pat() {
        return apellido_pat;
    }

    public void setApellido_pat(String apellido_pat) {
        this.apellido_pat = apellido_pat;
    }

    public String getApellido_mat() {
        return apellido_mat;
    }

    public void setApellido_mat(String apellido_mat) {
        this.apellido_mat = apellido_mat;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getId_distrito() {
        return id_distrito;
    }

    public void setId_distrito(String id_distrito) {
        this.id_distrito = id_distrito;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getId_estado() {
        return id_estado;
    }

    public void setId_estado(String id_estado) {
        this.id_estado = id_estado;
    }

    public String getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(String id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(String id_departamento) {
        this.id_departamento = id_departamento;
    }
 
    
    
}
