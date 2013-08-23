package integrador;
import CONEXION.*;
import java.sql.*;
import java.util.ArrayList;

public class RolesDAO {
    
    public RolesDAO(){ }
    /*
     * En esta funcion se inserta un registro a la tabla Roles
     * recibe como parametro de entrada un tipo de dato Roles
     * retorna una variable de tipo booleana true en caso que la insercion fue exitosa
     * false en caso que no se pueda ingresar la informacion
     */
    
    public boolean create(Roles rt){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_insrol(?,?)}");
            cs.setString(1, rt.getNombre());
            cs.registerOutParameter(2, Types.VARCHAR);
            var = cs.execute();
           System.out.println(cs.getString(2));
        }catch(SQLException e){
            System.out.println("ERROR " + e);
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    
    /*
     * En esta funcion se Busca por id un registro de la tabla Roles
     * recibe como parametro de entrada una variable String
     * retorna un registro en caso tal que se encuentre o de lo contrario
     * muestra un mensaje de error
     */
    public Roles findByID(int id){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        Roles ct = new Roles();
        try{
        CallableStatement cs = c.prepareCall("{? = call f_busnomrol(?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setInt(2, id);
        cs.execute();
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
     * En esta funcion se elimina por id un registro de la tabla rol
     * recibe como parametro de entrada una variable int
     * retorna una variable de tipo boleana true en caso que se pudo eliminar el
     * registro correctamente False en el caso contrario
     */
    public boolean deleteByID(Roles rt){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_delrol(?,?)}");
            cs.setInt(1,rt.getId());
            cs.registerOutParameter(2, Types.VARCHAR);
            var = cs.execute();
            System.out.println(cs.getString(2));
        }catch(SQLException e){
            System.out.println("ERROR "+e);
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se elimina todos los registro de la tabla rol
     * no recibe parametros de entrada
     * retorna una variable de tipo string 
     */
    public String deleteAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        String var;
        try{
            CallableStatement cs = c.prepareCall("{call p_delallrol(?)}");
            cs.registerOutParameter(1, Types.VARCHAR);
             cs.execute();
            var = cs.getString(1);
          
        }catch(SQLException e){
            
            var = "error "+e;
        }
        con.CerrarCon();
        return var;
    }
    
    /*
     * En esta funcion se actualiza por medio del id un registro de la tabla rol
     * recibe como parametro de entrada un tipo de dato rol
     * retorna una variable de tipo boleana true en caso que se pudo actualizar el
     * registro correctamente False en el caso contrario
     */
    public boolean update(Roles rt){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_updrol(?,?,?)}");
            cs.setInt(1, rt.getId());
            cs.setString(2, rt.getNombre());
            cs.registerOutParameter(3, Types.VARCHAR);
            var =  cs.execute();
            System.out.println(cs.getString(3));
        }catch(SQLException e){
            System.out.println("ERROR" + e);
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
    public ArrayList<Roles> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        ArrayList<Roles> cta = new ArrayList();
        
        try{
            ResultSet rs = con.ejecutaCon("Select * from Roles");
            while(rs.next()){
                Roles ct = new Roles();
                ct.setId(rs.getInt(1));
                ct.setNombre(rs.getString(2));
                cta.add(ct);
            }
        }catch(SQLException e){
            System.out.println("ERROR "+e);
            return null;
        }
        return cta;
    }
}