/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.hotel.victoria.model.interfaces;

import code.hotel.victoria.model.beans.BEmpleado;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PSantana........................................
 */
public interface IEmpleado {
    public ArrayList<BEmpleado> listEmpleado();
    public ArrayList<BEmpleado> listEmpleado(int id_empleado);
    public boolean insertEmpleado(BEmpleado empleado);
    public boolean updateEmpleado(BEmpleado empleado,int id);
    public boolean deleteEmpleado(int id_empleado);
    public void getEstado(JComboBox cmb);
    public void getDepartamento(JComboBox cmb);
    public void getDistrito(JComboBox cmb,JComboBox cmb2);
    public void getTipo(JComboBox cmb);
    public void setTable(DefaultTableModel tabla);
}
