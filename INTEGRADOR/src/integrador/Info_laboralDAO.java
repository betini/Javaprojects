package integrador;
import CONEXION.*;
import java.sql.*;
import java.util.ArrayList;
public class Info_laboralDAO {
    
   
    
    public Info_laboralDAO(){ }
    /*
     * En esta funcion se inserta un registro a la tabla info_laboral
     * recibe como parametro de entrada un tipo de dato info_laboral
     * retorna una variable de tipo booleana true en caso que la insercion fue exitosa
     * false en caso que no se pueda ingresar la informacion
     */
    public boolean create(Info_laboral il){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_INSINFO(?,?,?,?,?,?,?,?,?)}");
            
            cs.setString(1, il.getJefe());
            cs.setString(2, il.getCargo());
            cs.setString(3, il.getFuncion());
            cs.setDate(4, il.getFecha_ini());
            cs.setDate(5, il.getFecha_fin());
            cs.setString(6, il.getMotivo_retiro());
            cs.setLong(7, il.getId_egresado().getId());
            cs.setString(8, il.getPerfil());
            cs.registerOutParameter(9, Types.VARCHAR);
            var = cs.execute();
            System.out.println(cs.getString(9));
           
        }catch(SQLException e){
            System.out.println("Error"+ e);
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se Busca por id un registro de la tabla info_laboral
     * recibe como parametro de entrada una variable int
     * retorna un registro en caso tal que se encuentre o de lo contrario
     * muestra un mensaje de error
     */
    public Info_laboral findByID(int cod){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        Info_laboral IL = new Info_laboral();
        try{
        CallableStatement cs = c.prepareCall("{? = call F_BUSNOMINFO(?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setInt(2, cod);
        cs.execute();
        //IL.setId(cod);
        //IL.setJefe(cs.getString(1));
        System.out.println(cs.getString(1));
        con.CerrarCon();
        return IL;
        }catch(SQLException e){
            System.out.println("erorrrr findbyid "+e);
            con.CerrarCon();
            return null;
        }
        
    }
    /*
     * En esta funcion se elimina por id un registro de la tabla info_laboral
     * recibe como parametro de entrada una variable int
     * retorna una variable de tipo boleana true en caso que se pudo eliminar el
     * registro correctamente False en el caso contrario
     */
    public boolean deleteByID(Info_laboral I){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_DELINF(?,?)}");
            cs.setInt(1,I.getId());
            cs.registerOutParameter(2, Types.VARCHAR);
            var = cs.execute();
          System.out.println(cs.getString(2));
        }catch(SQLException e){
            System.out.println("ERROR : " +e);
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se elimina todos los registro de la tabla info_laboral
     * no recibe parametros de entrada
     * retorna una variable de tipo string 
     */
    public String deleteAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        String var;
        try{
            CallableStatement cs = c.prepareCall("{call P_DELALLINF(?)}");
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
     * En esta funcion se actualiza por medio del id un registro de la tabla info_laboral
     * recibe como parametro de entrada un tipo de dato info_laboral
     * retorna una variable de tipo boleana true en caso que se pudo actualizar el
     * registro correctamente False en el caso contrario
     */
    public boolean update(Info_laboral il){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_UPDINF(?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, il.getId());
            cs.setString(2, il.getJefe());
            cs.setString(3, il.getCargo());
            cs.setString(4, il.getFuncion());
            cs.setDate(5, il.getFecha_ini());
            cs.setDate(6, il.getFecha_fin());
            cs.setString(7, il.getMotivo_retiro());
            cs.setLong(8, il.getId_egresado().getId());
            cs.setString(9, il.getPerfil());
            cs.registerOutParameter(10, Types.VARCHAR);
            var = cs.execute();
            System.out.println(cs.getString(10));	
        }catch(SQLException e){
            System.out.println("error " +e);	
            return false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se muestra todos los registros de la tabla info_laboral
     * no recibe parametros de entrada
     * retorna un arraylist en el cual estaran todos los registros.
     */
   public ArrayList<Info_laboral> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        ArrayList<Info_laboral> eeg = new ArrayList();

        try{
            ResultSet gs = con.ejecutaCon(" Select * from Info_laboral");     
            while(gs.next()){
          
                Estudios_Egresado ee=new Estudios_Egresado();
                Info_laboral i =new Info_laboral();
                Egresado eg = new Egresado();
                Estudios es = new Estudios();
                
                i.setId(gs.getInt(1));
                i.setJefe(gs.getString(2));
                i.setCargo(gs.getString(3));
                i.setFuncion(gs.getString(4));
                i.setFecha_ini(gs.getDate(5));
                i.setFecha_fin(gs.getDate(6));
                i.setMotivo_retiro(gs.getString(7));
                eg.setId(gs.getLong(8));
                i.setId_egresado(eg);
                i.setPerfil(gs.getString(9));
                
                eeg.add(i);
            }
        }catch(SQLException e){
            System.out.println("error "+e);
            return null;
        }
        return eeg;
    }
}