
package integrador;
import CONEXION.*;
import java.sql.*;
import java.util.ArrayList;

public class CuentaDAO {
    
    public CuentaDAO(){ }
    /*
     * En esta funcion se inserta un registro a la tabla cuenta
     * recibe como parametro de entrada un tipo de dato cuenta
     * retorna una variable de tipo booleana true en caso que la insercion fue exitosa
     * false en caso que no se pueda ingresar la informacion
     */
    
    public boolean create(Cuenta ct){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        Boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_inscuen(?,?,?)}");
            cs.setString(1, ct.getUser());
            cs.setString(2, ct.getPassword());
            cs.registerOutParameter(3, Types.VARCHAR);
            var = cs.execute();
            System.out.println(cs.getString(3));	
           
        }catch(SQLException e){
            System.out.println("ERROR "+e);	
            var = false;
            
        }
        con.CerrarCon();
        return var;
    }
    
    /*
     * En esta funcion se Busca por id un registro de la tabla cuenta
     * recibe como parametro de entrada una variable int
     * retorna un registro en caso tal que se encuentre o de lo contrario
     * muestra un mensaje de error
     */
    public Cuenta findByID(String User){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        Cuenta ct = new Cuenta();
        try{
        CallableStatement cs = c.prepareCall("{? = call f_buscuen(?)}");
        cs.setString(2, User);
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.execute();
        //ct.setUser(cs.getString(1));
        System.out.println(cs.getString(1));	
        con.CerrarCon();
        return ct;
        }catch(SQLException e){
            System.out.println("erorrrr findbyid "+e);
            con.CerrarCon();
            return null;
        }
    }
    
    /*
     * En esta funcion se elimina por id un registro de la tabla cuenta
     * recibe como parametro de entrada una variable int
     * retorna una variable de tipo boleana true en caso que se pudo eliminar el
     * registro correctamente False en el caso contrario
     */
    public boolean deleteByID(Cuenta ct){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_delcuen(?,?)}");
            cs.setString(1,ct.getUser());
            cs.registerOutParameter(2, Types.VARCHAR);
            var = cs.execute();
            System.out.println(cs.getString(2));	
        }catch(SQLException e){
            System.out.println("error "+e);	
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se elimina todos los registro de la tabla cuenta
     * no recibe parametros de entrada
     * retorna una variable de tipo string 
     */
    public String deleteAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        String var;
        try{
            CallableStatement cs = c.prepareCall("{call p_delallcuen(?)}");
            cs.registerOutParameter(1, Types.VARCHAR);
             cs.execute();
            var = cs.getString(1);
          System.out.println(cs.getString(1));	
        }catch(SQLException e){
            var = "error "+e;
        }
        con.CerrarCon();
        return var;
    }
    
    /*
     * En esta funcion se actualiza por medio del id un registro de la tabla cuenta
     * recibe como parametro de entrada un tipo de dato cuenta
     * retorna una variable de tipo boleana true en caso que se pudo actualizar el
     * registro correctamente False en el caso contrario
     */
    public boolean update(Cuenta ct){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_UPDCONT(?,?,?)}");
            cs.setString(1, ct.getUser());
            cs.setString(2, ct.getPassword());
            cs.registerOutParameter(3, Types.VARCHAR);
            var =  cs.execute();
            System.out.println(cs.getString(3));	
        }catch(SQLException e){
            System.out.println("error " +e);	
            return false;
        }
        con.CerrarCon();
        return var;
    }
     /*
     * En esta funcion se muestra todos los registros de la tabla cuenta
     * no recibe parametros de entrada
     * retorna un arraylist en el cual estaran todos los registros.
     */
    public ArrayList<Cuenta> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        ArrayList<Cuenta> cta = new ArrayList();
        
        try{
            ResultSet rs = con.ejecutaCon("Select * from Cuenta");
            while(rs.next()){
                Cuenta ct = new Cuenta();
                ct.setUser(rs.getString(1));
                ct.setPassword(rs.getString(2));                               
                cta.add(ct);
            }
        }catch(SQLException e){
            System.out.println("error" +e);	
            return null;
        }
        return cta;
    }
}