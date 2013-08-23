package integrador;
import CONEXION.*;
import java.sql.*;
import java.util.ArrayList;

public class EmpresaDAO {

    public EmpresaDAO(){ }
    /*
     * En esta funcion se inserta un registro a la tabla empresa
     * recibe como parametro de entrada un tipo de dato empresa
     * retorna una variable de tipo booleana true en caso que la insercion fue exitosa
     * false en caso que no se pueda ingresar la informacion
     */
    public boolean create(Empresa em){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_INSEMP(?,?,?,?,?,?,?)}");
            cs.setString(1, em.getNombre());
            cs.setString(2, em.getDireccion());
            cs.setLong(3, em.getCelular());
            cs.setInt(4, em.getTelefono());
            cs.setString(5,em.getUser_Cuenta().getUser());
            cs.setString(6, em.getContacto());
           
            cs.registerOutParameter(7, Types.VARCHAR);
            var = cs.execute();
            System.out.println(cs.getString(7));	


        }catch(SQLException e){
            var = false;
            System.out.println("ERRORRRR" + e);	
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se Busca por id un registro de la tabla empresa
     * recibe como parametro de entrada una variable int
     * retorna un registro en caso tal que se encuentre o de lo contrario
     * muestra un mensaje de error
     */
    public Empresa findByID(int codnum){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        Empresa em=new Empresa();
        try{
        CallableStatement cs = c.prepareCall("{? = call F_BUSNOMEMP(?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setInt(2, codnum);
        cs.execute();
        System.out.println(cs.getString(1));
        con.CerrarCon();
        return em;
        }catch(SQLException e){
            System.out.println("erorrrr findbyid "+e);
            con.CerrarCon();
            return null;
        }

    }
    /*
     * En esta funcion se elimina por id un registro de la tabla empresa
     * recibe como parametro de entrada una variable int
     * retorna una variable de tipo boleana true en caso que se pudo eliminar el
     * registro correctamente False en el caso contrario
     */
    public boolean deleteByID(Empresa em){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_DELEMP(?,?)}");
            cs.setInt(1,em.getCodnum());
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
     * En esta funcion se elimina todos los registro de la tabla empresa
     * no recibe parametros de entrada
     * retorna una variable de tipo string 
     */
    public String deleteAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        String var;
        try{
            CallableStatement cs = c.prepareCall("{call P_DELALLEMP(?)}");
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
     * En esta funcion se actualiza por medio del id un registro de la tabla empresa
     * recibe como parametro de entrada un tipo de dato empresa
     * retorna una variable de tipo boleana true en caso que se pudo actualizar el
     * registro correctamente False en el caso contrario
     */
    public boolean update(Empresa em){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_UPDEMP(?,?,?,?,?,?,?,?)}");
            cs.setString(1, em.getUser_Cuenta().getUser());
            cs.setInt(2, em.getCodnum());
             cs.setString(3, em.getNombre());
            cs.setString(4, em.getDireccion());
            cs.setLong(5, em.getCelular());
            cs.setInt(6, em.getTelefono());
            cs.setString(7, em.getContacto());
            cs.registerOutParameter(8, Types.VARCHAR);
             
            
            var =  cs.execute();
            System.out.println(cs.getString(8));	

        }catch(SQLException e){
            System.out.println("error "+e);	
            return false;
            
           
        }
       
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se muestra todos los registros de la tabla empresa
     * no recibe parametros de entrada
     * retorna un arraylist en el cual estaran todos los registros.
     */
    public ArrayList<Empresa> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        ArrayList<Empresa> emp = new ArrayList();

        try{
            ResultSet rs = con.ejecutaCon("Select * from Empresa");
            while(rs.next()){
                Empresa em=new Empresa();
                Cuenta cue=new Cuenta();
                
                em.setCodnum(rs.getInt(1));
                em.setNombre(rs.getString(2));
                em.setDireccion(rs.getString(3));
                em.setCelular(rs.getLong(4));
                em.setTelefono(rs.getInt(5));
                cue.setUser(rs.getString(6));
                em.setUser_Cuenta(cue);
                em.setContacto(rs.getString(7));
                
                emp.add(em);
            }
        }catch(SQLException e){
            System.out.println("error " +e);	
            return null;
        }
        return emp;
    }
}