/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.hotel.victoria.model.dao;

import code.hotel.victoria.model.beans.BEmpleado;
import code.hotel.victoria.model.dbconecction.ConnectionDB;
import code.hotel.victoria.model.interfaces.IEmpleado;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PSantana
 */
public class DAOEmpleado implements IEmpleado{
    private ConnectionDB cn;

    public DAOEmpleado() {
        cn=new ConnectionDB();
    }
    
    @Override
    public ArrayList<BEmpleado> listEmpleado() {
        ArrayList<BEmpleado> empleados=new ArrayList<>();
        try {           
            CallableStatement cs= cn.getConnection().prepareCall("{call [dbo].[SP_LIST_EMPLEADO](?,?)}");
            cs.setString(1, "L");//ESTE PARAMETRO LISTA LOS empleados         
            cs.setString(2, "");  
            ResultSet rs=cs.executeQuery();
            while (rs.next()) {                
                BEmpleado empleado=new BEmpleado();
                empleado.setId_empleado(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido_pat(rs.getString("apellido_pat"));
                empleado.setApellido_mat(rs.getString("apellido_mat"));
                empleado.setDni(rs.getString("dni"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setId_distrito(rs.getString("id_distrito"));
                empleado.setFecha_ingreso(rs.getString("fecha_ingreso"));
                empleado.setId_estado(rs.getString("id_estado"));
                empleado.setId_tipo(rs.getString("id_tipo"));
                empleado.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                empleado.setId_departamento(rs.getString("id_departamento"));
                empleado.setUsuario(rs.getString("usuario"));
                empleados.add(empleado);
            }
            cn.close(cs, rs, cn);
        } catch (SQLException ex) {
            System.out.println("Error en Listar empleado   "+ex.getMessage());
        }
        return empleados;
    }

    @Override
    public boolean insertEmpleado(BEmpleado empleado) {
        Boolean isOk=false;
        try {
            CallableStatement cs=cn.getConnection().prepareCall("{call SP_UPDINS_EMPLEADO (?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, "I");
            cs.setInt(2, 0);
            cs.setString(3, empleado.getNombre());
            cs.setString(4, empleado.getApellido_pat());
            cs.setString(5, empleado.getApellido_mat());
            cs.setString(6, empleado.getDni());
            cs.setString(7, empleado.getTelefono());
            cs.setString(8, empleado.getId_distrito());
            cs.setString(9, empleado.getFecha_ingreso());
            cs.setString(10, empleado.getId_estado());
            cs.setString(11, empleado.getId_tipo());
            cs.setString(12, (empleado.getFecha_nacimiento()));
            cs.setString(13, empleado.getId_departamento());
            int i=cs.executeUpdate();
            System.out.println("resultado de "+i);
            cn.close(cs, cn);
            isOk=true;
        } catch (SQLException ex) {
            System.out.println("Error al insertar empleado  "+ex.getMessage());
            return isOk=false;
        }
        return isOk;
    }

    @Override
    public boolean updateEmpleado(BEmpleado empleado,int id) {
        try {
            CallableStatement cs=cn.getConnection().prepareCall("{call SP_UPDINS_EMPLEADO (?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, "U");
            cs.setInt(2, id);
            cs.setString(3, empleado.getNombre());
            cs.setString(4, empleado.getApellido_pat());
            cs.setString(5, empleado.getApellido_mat());
            cs.setString(6, empleado.getDni());
            cs.setString(7, empleado.getTelefono());
            cs.setString(8, empleado.getId_distrito());
            cs.setString(9, empleado.getFecha_ingreso());
            cs.setString(10, empleado.getId_estado());
            cs.setString(11, empleado.getId_tipo());
            cs.setString(12, empleado.getFecha_nacimiento());
            cs.setString(13, empleado.getId_departamento());
            cs.executeUpdate();
            cn.close(cs, cn);
        } catch (SQLException ex) {
            System.out.println("Error al actualizar empleado  "+ex.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteEmpleado(int id_empleado) {
        return false;
    }

    @Override
    public ArrayList<BEmpleado> listEmpleado(int id_empleado) {
        ArrayList<BEmpleado> empleados=new ArrayList<>();
        try {           
            CallableStatement cs= cn.getConnection().prepareCall("{call [dbo].[SP_LIST_EMPLEADO](?,?)}");
            cs.setString(1, "I");//ESTE PARAMETRO LISTA LOS empleados         
            cs.setInt(2, id_empleado);  
            ResultSet rs=cs.executeQuery();
            while (rs.next()) {                
                BEmpleado empleado=new BEmpleado();
                empleado.setId_empleado(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido_pat(rs.getString("apellido_pat"));
                empleado.setApellido_mat(rs.getString("apellido_mat"));
                empleado.setDni(rs.getString("dni"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setId_distrito(rs.getString("id_distrito"));
                empleado.setFecha_ingreso(rs.getString("fecha_ingreso"));
                empleado.setId_estado(rs.getString("id_estado"));
                empleado.setId_tipo(rs.getString("id_tipo"));
                empleado.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                empleado.setId_departamento(rs.getString("id_departamento"));
                empleado.setUsuario(rs.getString("usuario"));
                empleados.add(empleado);
            }
            cn.close(cs, rs, cn);
        } catch (SQLException ex) {
            System.out.println("Error en Listar por id empleado   "+ex.getMessage());
        }
        return empleados;
    }
    
    @Override
    public void getEstado(JComboBox cmb){
        String sql="SELECT * FROM ESTADO WHERE LEFT (ID_ESTADO,1)='E'";       
        cmb.removeAllItems();
        cmb.addItem("(Estado)");
        try {
            ResultSet rs= cn.EjecutarRS(sql);
            while (rs.next()){
                cmb.addItem(rs.getString("estado")+" "+rs.getString("id_estado"));     
            }
        cn.close(rs, cn);
        } catch (SQLException e) {
            System.out.println("Error al obtener los estados   "+e.getMessage());
        } 
    }

    @Override
    public void getDepartamento(JComboBox cmb) {
        String sql="SELECT * FROM DEPARTAMENTO";       
        cmb.removeAllItems();
        cmb.addItem("(Departamento)");
        try {
            ResultSet rs= cn.EjecutarRS(sql);
            while (rs.next()){
                cmb.addItem(rs.getString("departamento")+" "+rs.getString("ID_DEPARTAMENTO"));     
            }
        cn.close(rs, cn);
        } catch (SQLException e) {
            System.out.println("Error al obtener los departamentos   "+e.getMessage());
        } 
    }

    @Override
    public void getDistrito(JComboBox cmb,JComboBox cmb2) {
        String textcmb2=cmb2.getSelectedItem().toString();
        String id_dep= textcmb2.substring(textcmb2.length()-4);
        String sql="SELECT * FROM DISTRITO WHERE ID_DEPARTAMENTO ='"+id_dep+"'";       
        cmb.removeAllItems();
        cmb.addItem("(Distrito)");
        try {
            ResultSet rs= cn.EjecutarRS(sql);
            while (rs.next()){
                cmb.addItem(rs.getString("distrito")+" "+rs.getString("ID_DISTRITO"));     
            }
        cn.close(rs, cn);
        } catch (SQLException e) {
            System.out.println("Error al obtener los departamentos   "+e.getMessage());
        } 
    }

    @Override
    public void getTipo(JComboBox cmb) {
        String sql="SELECT * FROM TIPO WHERE LEFT(ID_TIPO,1)='E'";       
        cmb.removeAllItems();
        cmb.addItem("(Tipo E.)");
        try {
            ResultSet rs= cn.EjecutarRS(sql);
            while (rs.next()){
                cmb.addItem(rs.getString("tipo")+" "+rs.getString("id_tipo"));     
            }
        cn.close(rs, cn);
        } catch (SQLException e) {
            System.out.println("Error al obtener los tipo de empleado   "+e.getMessage());
        } 
    }

    @Override
    public void setTable(DefaultTableModel tabla) {
        int f=0;
        String sql="SELECT E.*,D.distrito,d.id_distrito,ES.*,T.*,DE.* FROM EMPLEADO E INNER JOIN DISTRITO D ON E.id_distrito=D.ID_DISTRITO\n" +
"	INNER JOIN ESTADO ES ON E.id_estado=ES.ID_ESTADO INNER JOIN TIPO T ON E.id_tipo=T.ID_TIPO\n" +
"	INNER JOIN DEPARTAMENTO DE ON E.id_departamento= DE.ID_DEPARTAMENTO";       
        try {
            ResultSet rs= cn.EjecutarRS(sql);           
            tabla.setRowCount(0);
            while (rs.next()){
                f=tabla.getRowCount();
                tabla.setRowCount(f+1);
                tabla.setValueAt(rs.getInt("id_empleado"), f, 0);
                tabla.setValueAt(rs.getString("nombre"), f, 1);
                tabla.setValueAt(rs.getString("apellido_pat"), f, 2);
                tabla.setValueAt(rs.getString("apellido_mat"), f, 3);
                tabla.setValueAt(rs.getString("dni"), f, 4);
                tabla.setValueAt(rs.getString("telefono"), f, 5);
                tabla.setValueAt(rs.getString("distrito")+" "+rs.getString("ID_DISTRITO"), f, 6);//distrito
                tabla.setValueAt(rs.getDate("fecha_ingreso"), f, 7);
                tabla.setValueAt(rs.getString("estado")+" "+rs.getString("id_estado"), f, 8);//estado
                tabla.setValueAt(rs.getString("tipo")+" "+rs.getString("id_tipo"), f, 9);//tipo
                tabla.setValueAt(rs.getDate("fecha_nacimiento"), f, 10);
                tabla.setValueAt(rs.getString("departamento")+" "+rs.getString("id_departamento"), f, 11);//departamento
                tabla.setValueAt(rs.getString("usuario"), f, 12);
            }
        cn.close(rs, cn);
        } catch (SQLException e) {
            System.out.println("Error al listar empleados con ins select  "+e.getMessage());
        } 
    }
}
