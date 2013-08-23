package integrador;
import CONEXION.*;
import java.sql.*;
import java.util.ArrayList;
public class EgresadoDAO {
    
   
    
    public EgresadoDAO(){ }
    /*
     * En esta funcion se inserta un registro a la tabla egresado
     * recibe como parametro de entrada un tipo de dato egresado
     * retorna una variable de tipo booleana true en caso que la insercion fue exitosa
     * false en caso que no se pueda ingresar la informacion
     */
    public Boolean create(Egresado ed){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        Boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_INSEGRE(?,?,?,?,?,?,?,?)}");
            cs.setLong(1, ed.getId());
            cs.setString(2, ed.getNombre());
            cs.setString(3, ed.getApellido());
            cs.setString(4, ed.getCorreo());
            cs.setLong(5, ed.getCelular());
            cs.setString(6, ed.getUser_Cuenta().getUser());
            cs.setInt(7, ed.getTelefono());
            cs.registerOutParameter(8, Types.VARCHAR);
            var = cs.execute();
            System.out.println(cs.getString(8));	
           
        }catch(SQLException e){
            System.out.println("error"+e);	
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se Busca por id un registro de la tabla egresado
     * recibe como parametro de entrada una variable int
     * retorna un registro en caso tal que se encuentre o de lo contrario
     * muestra un mensaje de error
     */
    public Egresado findByID(Long cod){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        Egresado es = new Egresado();
        try{
        CallableStatement cs = c.prepareCall("{? = call F_BUSNOMEGRE(?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setLong(2, cod);
        cs.execute();
        System.out.println(cs.getString(1));
        con.CerrarCon();
       	
        return es;
        }catch(SQLException e){
            System.out.println("erorrrr findbyid "+e);
            con.CerrarCon();
            return null;
        }
        
    }
    /*
     * En esta funcion se elimina por id un registro de la tabla egresado
     * recibe como parametro de entrada una variable int
     * retorna una variable de tipo boleana true en caso que se pudo eliminar el
     * registro correctamente False en el caso contrario
     */
    public boolean deleteByID(Egresado I){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_DELEGRE(?,?)}");
            cs.setLong(1,I.getId());
            cs.registerOutParameter(2, Types.VARCHAR);
            var = cs.execute();
          System.out.println(cs.getString(2));	
        }catch(SQLException e){
            System.out.println("error "+e );	
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se elimina todos los registro de la tabla egresado
     * no recibe parametros de entrada
     * retorna una variable de tipo string 
     */
    public String deleteAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        String var;
        try{
            CallableStatement cs = c.prepareCall("{call P_DELALLEGRE(?)}");
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
     * En esta funcion se actualiza por medio del id un registro de la tabla egresado
     * recibe como parametro de entrada un tipo de dato egresado
     * retorna una variable de tipo boleana true en caso que se pudo actualizar el
     * registro correctamente False en el caso contrario
     */
    public boolean update(Egresado es){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_UPDEGRE(?,?,?,?,?,?,?,?)}");
            cs.setLong(1, es.getId());
            cs.setString(2, es.getNombre());
            cs.setString(3, es.getApellido());
            cs.setString(4, es.getCorreo());
            cs.setLong(5, es.getCelular());
            cs.setString(6, es.getUser_Cuenta().getUser());
            cs.setInt(7, es.getTelefono());
            cs.registerOutParameter(8, Types.VARCHAR);
            var =  cs.execute();
            System.out.println(cs.getString(8));	
          
        }catch(SQLException e){
            System.out.println("error " +e);	
            return false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se muestra todos los registros de la tabla egresado
     * no recibe parametros de entrada
     * retorna un arraylist en el cual estaran todos los registros.
     */
    public ArrayList<Egresado> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        ArrayList<Egresado> inst = new ArrayList();
        try{
            ResultSet rs = con.ejecutaCon("Select * from Egresado");
            while(rs.next()){
                Egresado es = new Egresado();
                Cuenta cue = new Cuenta();                
                
                es.setId(rs.getLong(1));
                es.setNombre(rs.getString(2));
                es.setApellido(rs.getString(3));
                es.setCorreo(rs.getString(4));
                es.setCelular(rs.getLong(5));
                cue.setUser(rs.getString(6));
                es.setUser_Cuenta(cue);
                es.setTelefono(rs.getInt(7));
                
                inst.add(es);
            }
        }catch(SQLException e){
            System.out.println("error " +e);	
            return null;
        }
        return inst;
    }
}