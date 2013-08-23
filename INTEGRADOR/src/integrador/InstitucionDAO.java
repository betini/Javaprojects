/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package integrador;
import CONEXION.*;
import java.sql.*;
import java.util.ArrayList;
public class InstitucionDAO {
    
   
    
    public InstitucionDAO(){ }
    /*
     * En esta funcion se inserta un registro a la tabla institucion
     * recibe como parametro de entrada un tipo de dato institucion
     * retorna una variable de tipo booleana true en caso que la insercion fue exitosa
     * false en caso que no se pueda ingresar la informacion
     */
    public boolean create(Institucion I){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_insinst(?,?,?)}");
            cs.setInt(1,I.getId());
            cs.setString(2, I.getNombre());
            cs.registerOutParameter(3, Types.VARCHAR);
            var = cs.execute();
           System.out.println(cs.getString(3));	
        }catch(SQLException e){
            System.out.println("eror" +e);	
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se Busca por id un registro de la tabla institucion
     * recibe como parametro de entrada una variable int
     * retorna un registro en caso tal que se encuentre o de lo contrario
     * muestra un mensaje de error
     */
    public Institucion findByID(int cod){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        Institucion I = new Institucion();
        try{
        CallableStatement cs = c.prepareCall("{? = call f_busNominst(?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setInt(2, cod);
        cs.execute();
        System.out.println(cs.getString(1));
        con.CerrarCon();
        return I;
        }catch(SQLException e){
            System.out.println("erorrrr findbyid "+e);
            con.CerrarCon();
            return null;
        }
        
    }
    /*
     * En esta funcion se elimina por id un registro de la tabla institucion
     * recibe como parametro de entrada una variable int
     * retorna una variable de tipo boleana true en caso que se pudo eliminar el
     * registro correctamente False en el caso contrario
     */
    public boolean deleteByID(Institucion I){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_delinst(?,?)}");
            cs.setInt(1,I.getId());
            cs.registerOutParameter(2, Types.VARCHAR);
            var = cs.execute();
            System.out.println(cs.getString(2));	
        }catch(SQLException e){
            System.out.println("error" +e);	
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se elimina todos los registro de la tabla institucion
     * no recibe parametros de entrada
     * retorna una variable de tipo string 
     */
    public String deleteAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        String var;
        try{
            CallableStatement cs = c.prepareCall("{call p_delallinst(?)}");
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
     * En esta funcion se actualiza por medio del id un registro de la tabla institucion
     * recibe como parametro de entrada un tipo de dato institucion
     * retorna una variable de tipo boleana true en caso que se pudo actualizar el
     * registro correctamente False en el caso contrario
     */
    public boolean update(Institucion I){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_updinst(?,?,?)}");
            cs.setInt(1, I.getId());
            cs.setString(2, I.getNombre());
            cs.registerOutParameter(3, Types.VARCHAR);
            var =  cs.execute();
            System.out.println(cs.getString(3));
        }catch(SQLException e){
            System.out.print("ERRROR "+ e);
            return false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se muestra todos los registros de la tabla institucion
     * no recibe parametros de entrada
     * retorna un arraylist en el cual estaran todos los registros.
     */
    public ArrayList<Institucion> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        ArrayList<Institucion> inst = new ArrayList();
        
        try{
            ResultSet rs = con.ejecutaCon("Select * from Institucion");
            while(rs.next()){
                Institucion I = new Institucion();
                I.setId(rs.getInt(1));
                I.setNombre(rs.getString(2));
                inst.add(I);
            }
        }catch(SQLException e){
            System.out.println("error " +e);	
            return null;
        }
        return inst;
    }
}