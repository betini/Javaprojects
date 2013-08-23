package integrador;
import CONEXION.*;
import java.sql.*;
import java.util.ArrayList;
public class EstudiosDAO {
    
   
    
    public EstudiosDAO(){ }
    /*
     * En esta funcion se inserta un registro a la tabla estudios
     * recibe como parametro de entrada un tipo de dato estudios
     * retorna una variable de tipo booleana true en caso que la insercion fue exitosa
     * false en caso que no se pueda ingresar la informacion
     */
    public boolean create(Estudios es){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_INSEST(?,?,?)}");
            cs.setInt(1, es.getId_Institucion().getId());
            cs.setString(2, es.getNivel());
            cs.registerOutParameter(3, Types.VARCHAR);
            var = cs.execute();
           System.out.println(cs.getString(3));	
        }catch(SQLException e){
            System.out.println("ERROR " + e);
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se Busca por id un registro de la tabla estudios
     * recibe como parametro de entrada una variable int
     * retorna un registro en caso tal que se encuentre o de lo contrario
     * muestra un mensaje de error
     */
    public Estudios findByID(int cod){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        Estudios es = new Estudios();
        try{
        CallableStatement cs = c.prepareCall("{? = call F_BUSEST(?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setInt(2, cod);
        cs.execute();
        es.setId(cs.getInt(1));
        es.setNivel(cs.getString(3));
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
     * En esta funcion se elimina por id un registro de la tabla estudios
     * recibe como parametro de entrada una variable int
     * retorna una variable de tipo boleana true en caso que se pudo eliminar el
     * registro correctamente False en el caso contrario
     */
    public boolean deleteByID(Estudios I){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_DELEST(?,?)}");
            cs.setInt(1,I.getId());
            cs.registerOutParameter(2, Types.VARCHAR);
            var = cs.execute();
            System.out.println(cs.getString(2));	
        }catch(SQLException e){
            System.out.println("error " +e);	
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se elimina todos los registro de la tabla estudios
     * no recibe parametros de entrada
     * retorna una variable de tipo string 
     */
    public String deleteAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        String var;
        try{
            CallableStatement cs = c.prepareCall("{call P_DELALLEST(?)}");
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
     * En esta funcion se actualiza por medio del id un registro de la tabla estudios
     * recibe como parametro de entrada un tipo de dato estudios
     * retorna una variable de tipo boleana true en caso que se pudo actualizar el
     * registro correctamente False en el caso contrario
     */
    public boolean update(Estudios es){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_UPDEST(?,?,?)}");
            cs.setInt(1, es.getId());
            cs.setString(2, es.getNivel());
            cs.registerOutParameter(3, Types.VARCHAR);
            var =  cs.execute();
            System.out.println(cs.getString(3));
        }catch(SQLException e){
            System.out.println("ERROR " + e);
            return false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se muestra todos los registros de la tabla estudios
     * no recibe parametros de entrada
     * retorna un arraylist en el cual estaran todos los registros.
     */
    public ArrayList<Estudios> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        ArrayList<Estudios> inst = new ArrayList();
        
        try{
            ResultSet rs = con.ejecutaCon("Select * from Estudios");
            while(rs.next()){
                Estudios es = new Estudios();
                Institucion ins =new Institucion();
                
                es.setId(rs.getInt(1));
                ins.setId(rs.getInt(2));
                es.setId_Institucion(ins);
                es.setNivel(rs.getString(3));
                
                inst.add(es);
            }
        }catch(SQLException e){
            System.out.println("error " +e);	
            return null;
        }
        return inst;
    }
}