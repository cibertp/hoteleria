/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.hotel.victoria.model.interfaces;

import code.hotel.victoria.model.beans.BUsuario;
import java.util.ArrayList;

/**
 *
 * @author PSantana
 */
public interface IUsuario {
    public ArrayList<BUsuario> listUser();
    public boolean isUserExist(String user,String pass);
    public String existUser(String user, String pass);
//    public BUsuario listCargoUser(String user,String pass);
    public boolean insertUser(BUsuario user);
    public boolean updateUser(BUsuario user);
    public boolean deleteUser(int id_empleado);
}
