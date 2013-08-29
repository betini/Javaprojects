package protocolos;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

  
    Connection miconexion;
   // Statement sentencias;
    //ResultSet Datos;
    PreparedStatement preparar;
    public Connection conec() throws SQLException {    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:Mysql://localhost/control_estudiantes";
            miconexion=DriverManager.getConnection(url, "root", "");
            JOptionPane.showMessageDialog(null, "Conectado");
         //  sentencias=miconexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);  
          
        } return null;
       // catch(ClassCastException ex){throw ex;}
       
      
        
    }
  /*  
    public ResultSet consulta(String sql) throws SQLException{
        try{
            Datos=sentencias.executeQuery(sql);    
        }
         catch(SQLException ex){throw ex;}
        return Datos;
    }
    */

   
}
