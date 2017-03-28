/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.hotel.victoria.model.dao;

import code.hotel.victoria.model.dbconecction.ConnectionDB;
import code.hotel.victoria.model.interfaces.ILoginRegister;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class DAOLogeo implements ILoginRegister{
    ConnectionDB cn;
    public DAOLogeo (){
        cn=new ConnectionDB();
    }
    @Override
    public boolean isInsert(String user) { //INSERTA DATOS DEL USUARIO QUE INGRESO AL SISTEMA
        try {
            CallableStatement cs= cn.getConnection().prepareCall("{call SP_INS_ENTRADA_SYS(?)}");
            cs.setString(1, user);
            cs.executeUpdate();
            cs.close();
            cn.getConnection().close();
        } catch (SQLException ex) {
            System.out.println("Insert sesion  "+ ex.getMessage());
            return false;
        }
        return true;
    }
    
}
