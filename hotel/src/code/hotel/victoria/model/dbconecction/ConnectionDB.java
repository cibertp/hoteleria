
package code.hotel.victoria.model.dbconecction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author PSantana
 */
public class ConnectionDB {
    Connection cn=null;
    public Connection getConnection(){
        try {
            cn=DriverManager.getConnection("jdbc:sqlserver://mcinthehouse\\mcinthehouse;user=sa;password=123456;databaseName=HOTEL_VICTORIA");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cn;
    }
    
        public  ResultSet  EjecutarRS( String sql ) throws SQLException {
                ResultSet rs = null ;
                try {
                        getConnection();
                        Statement  st = cn.createStatement() ;
                        rs  = st.executeQuery ( sql ) ;
                } catch ( SQLException  e ) {
                       JOptionPane.showMessageDialog( null, 
                            "Error al ejecutarRS\n" +   e.getMessage() );
                } // try-catch
                  finally {
                    getConnection().close();
                }
                     
                return rs ;    
        } 
    
    public void close(CallableStatement cs,ResultSet rs, ConnectionDB cn) throws SQLException{
        cn.getConnection().close();
        rs.close();
        cs.close();
    }
    public void close(CallableStatement cs, ConnectionDB cn) throws SQLException{
        cn.getConnection().close();
        cs.close();
    }
    public void close(ResultSet rs, ConnectionDB cn) throws SQLException{
        cn.getConnection().close();
        rs.close();
    }
}
