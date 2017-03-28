
package code.hotel.victoria.model.dao;

import code.hotel.victoria.model.beans.BUsuario;
import code.hotel.victoria.model.dbconecction.ConnectionDB;
import code.hotel.victoria.model.interfaces.IUsuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PSantana
 */
public class DAOUsuario implements IUsuario{
    private ConnectionDB cn;
    public DAOUsuario(){
        cn=new ConnectionDB();
    }
    @Override
    public ArrayList<BUsuario> listUser() {
        ArrayList<BUsuario> users=new ArrayList<>();
        try {
            CallableStatement cs= cn.getConnection().prepareCall("{call [dbo].[SP_LISTUSUARIO](?,?,?,?)}");
            cs.setString(1, "L");//ESTE PARAMETRO LISTA LOS USUARIOS         
            cs.setString(2, "");         
            cs.setString(3, "");         
            cs.setString(4, "");         
            ResultSet rs=cs.executeQuery();
            while (rs.next()) {                
                BUsuario user=new BUsuario();
                user.setUsuario(rs.getString("usuario"));
                user.setId_empleado(rs.getInt("ID_EMPLEADO"));
                user.setClave(rs.getString("clave"));
                user.setCargo(rs.getString("CARGO"));
                user.setPregunta(rs.getString("pregunta"));
                user.setRespuesta(rs.getString("respuesta"));
                users.add(user);
            }
            cn.close(cs, rs, cn);
        } catch (SQLException ex) {
            System.out.println("Listar usuarios  "+ex.getMessage());
        }
        return users;
    }
    
     @Override
    public boolean isUserExist(String user, String pass) {
        BUsuario usuario=new BUsuario();
        boolean isExist=false;
        try {                      
            CallableStatement cs=cn.getConnection().prepareCall("{call [dbo].[SP_LISTUSUARIO](?,?,?,?)}");  
            cs.setString(1, "V");//ESTE PARAMETRO ENVIA EL USUARIO Y CONTRASEÑA PARA OBTENER EL CARGO
            cs.setInt(2, 0);
            cs.setString(3, user);
            cs.setString(4, pass);
            ResultSet rs=cs.executeQuery();           
            if(rs.next()){   
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));                 
            }
            if(user.equalsIgnoreCase(usuario.getUsuario())
                    && pass.equals(usuario.getClave())){
                isExist=true;
            }
            cn.close(cs, rs, cn);
        } catch (SQLException ex) {
            System.out.println("Verificar si existe  "+ex.getMessage());
        }
        return isExist;
    }
    
    @Override
    public String existUser(String user, String pass) {
        BUsuario usuario=new BUsuario();
        String cargo="";
        try {                      
            CallableStatement cs=cn.getConnection().prepareCall("{call [dbo].[SP_LISTUSUARIO](?,?,?)}");  
            cs.setString(1, "C");//ESTE PARAMETRO ENVIA EL USUARIO Y CONTRASEÑA PARA OBTENER EL CARGO
            cs.setInt(2, 0);
            cs.setString(3, user);
            cs.setString(4, pass);
            ResultSet rs=cs.executeQuery();           
            if(rs.next()){   
                usuario.setCargo(rs.getString("cargo"));                  
            }
            cargo=usuario.getCargo();
            cn.close(cs, rs, cn);
        } catch (SQLException ex) {
            System.out.println("Listar cargos  "+ex.getMessage());
        }
        return cargo;//envia el cargo sí existe el usuario
    }    

    @Override
    public boolean insertUser(BUsuario user) {
        Boolean isOk;
        try {
            CallableStatement cs=cn.getConnection().prepareCall("{call SP_MNT_USUARIO (?,?,?,?,?,?,?)}");
            cs.setString(1, "I");   
            cs.setString(2, user.getUsuario());
            cs.setInt(3, user.getId_empleado());
            cs.setString(4, user.getClave());
            cs.setString(5, user.getCargo());
            cs.setString(6, user.getPregunta());
            cs.setString(7, user.getRespuesta());
            cs.executeUpdate();
            cn.close(cs, cn);
            isOk=true;
        }catch(SQLException e){
            System.out.println("Error al registrar usuario");
            isOk=false;
        }
        return isOk;
    }

    @Override
    public boolean updateUser(BUsuario user) {
        Boolean isOk;
        try {
            CallableStatement cs=cn.getConnection().prepareCall("{call SP_MNT_USUARIO (?,?,?,?,?,?,?)}");
            cs.setString(1, "U");   
            cs.setString(2, user.getUsuario());
            cs.setInt(3, user.getId_empleado());
            cs.setString(4, user.getClave());
            cs.setString(5, user.getCargo());
            cs.setString(6, user.getPregunta());
            cs.setString(7, user.getRespuesta());
            cs.executeUpdate();
            cn.close(cs, cn);
            isOk=true;
        }catch(SQLException e){
            System.out.println("Error al actualizar usuario");
            isOk=false;
        }
        return isOk;
    }

    @Override
    public boolean deleteUser(int id_empleado) {
        boolean isOk;
        try {                      
            CallableStatement cs=cn.getConnection().prepareCall("{call [dbo].[SP_LISTUSUARIO](?,?,?)}");  
            cs.setString(1, "D");//ESTE PARAMETRO ENVIA EL USUARIO Y CONTRASEÑA PARA OBTENER EL CARGO
            cs.setInt(2, id_empleado);
            cs.setString(2, "");
            cs.setString(3, "");
            cn.close(cs,cn);
            isOk=true;
        } catch (SQLException ex) {
            System.out.println("Listar cargos  "+ex.getMessage());
            isOk=false;
        }
        return isOk;
    }   
    
    
    public static void main(String[] args) {
        BUsuario usuario=new BUsuario();
        DAOUsuario dao= new DAOUsuario();
        
        System.out.println(dao.existUser("rcarl", "robertocarlos"));
    }

   
}
