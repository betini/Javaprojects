package CONEXION;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {
   private String url;
   private String driver;
   private String pass;
   private String user;
   
   private Connection con;
   private Statement st;
   private ResultSet rs;
   private String error;
   
   //Método constructor
   public ConexionBD(){
   //Crear instancia de la clase que provee los datos de conexión
       DatosDB dat = new DatosDB();
       dat.captura();
       
       this.url = "jdbc:oracle:thin:@"+dat.getHost()+":"+dat.getPort()+":"+dat.getSid();
       this.driver ="oracle.jdbc.driver.OracleDriver";
       this.user = dat.getUser();
       this.pass = dat.getPass();
             
       try{
           Class.forName(this.driver);
       }catch(ClassNotFoundException e){
           System.out.println("error "+e);
       }
   }
   
   //Realiza la conexión
   public Connection conOracle(){
     try{
         this.con = DriverManager.getConnection(this.url, this.user,this.pass);
         
     }catch(SQLException e){
         System.out.println("error "+ e);
     }
     
     return this.con;
   }
   
   public boolean CerrarCon(){
       try{
           this.con.close();
           return true;
       }catch(SQLException e){
           System.out.println("Error "+e);
           return false;
       }
   }
   //Empleado para modificación de datos (insert, delete, update)
   public int ejecutaSen(String sql) throws SQLException{
   try{
       this.st = this.con.createStatement();
       return this.st.executeUpdate(sql);
   }catch (SQLException e){
    return -999;
   }
   }
   //Empleado para ejecutar consultas
   public ResultSet ejecutaCon(String sql) throws SQLException{
   try{
       this.st = this.con.createStatement();
       this.rs = this.st.executeQuery(sql);
   }catch(SQLException e){
       System.out.println("error "+ e);
   }
   
   return this.rs;
   }
   
}