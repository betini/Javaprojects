package integrador;
import CONEXION.*;
import java.sql.*;
import java.util.ArrayList;

public class Cuenta_RolesDAO {

    public Cuenta_RolesDAO (){ }
    /*
     * En esta funcion se inserta un registro a la tabla cuenta_roles
     * recibe como parametro de entrada un tipo de dato cuenta_roles
     * retorna una variable de tipo booleana true en caso que la insercion fue exitosa
     * false en caso que no se pueda ingresar la informacion
     */
    public boolean create(Cuenta_Roles cr){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_INSCUENTAROL(?,?,?)}");
            cs.setInt(1, cr.getId_Rol().getId());
            cs.setString(2, cr.getUser_Cuenta().getUser());
            cs.registerOutParameter(3, Types.VARCHAR);
            var = cs.execute();
            System.out.println(cs.getString(3));
            

        }catch(SQLException e){
            System.out.println("error " +e);	
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se Busca por id un registro de la tabla cuenta_rol
     * recibe como parametro de entrada una variable int
     * retorna un registro en caso tal que se encuentre o de lo contrario
     * muestra un mensaje de error
     */
    public Cuenta_Roles findByID(int id, String user){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        Cuenta_Roles ee=new Cuenta_Roles();
        try{
        CallableStatement cs = c.prepareCall("{? = call F_busnomcuentarol(?,?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setInt(2, id);
        cs.setString(3, user);
        cs.execute();
        //ee.getId_Rol().setId(idr);
        //ee.getUser_Cuenta().setUser(user);
        System.out.println(cs.getString(1));
        con.CerrarCon();
        return ee;
        }catch(SQLException e){
            System.out.println("erorrrr findbyid "+e);
            con.CerrarCon();
            return null;
        }

    }
    /*
     * En esta funcion se elimina por id un registro de la tabla cuenta_rol
     * recibe como parametro de entrada una variable int
     * retorna una variable de tipo boleana true en caso que se pudo eliminar el
     * registro correctamente False en el caso contrario
     */
    public boolean deleteByID(Cuenta_Roles ee){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_DELCUENTAROL(?,?)}");
            cs.setString(1,ee.getUser_Cuenta().getUser());
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
     * En esta funcion se elimina todos los registro de la tabla cuenta_rol
     * no recibe parametros de entrada
     * retorna una variable de tipo string 
     */
    public String deleteAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        String var;
        try{
            CallableStatement cs = c.prepareCall("{call P_DELALLCUENTAROL(?)}");
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
     * En esta funcion se actualiza por medio del id un registro de la tabla cuenta_rol
     * recibe como parametro de entrada un tipo de dato cuenta_rol
     * retorna una variable de tipo boleana true en caso que se pudo actualizar el
     * registro correctamente False en el caso contrario
     */
    public boolean update(Cuenta_Roles ee){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_UPDCUENTAROL(?,?,?)}");
            cs.setInt(1, ee.getId_Rol().getId());
            cs.setString(2,ee.getUser_Cuenta().getUser());
            cs.registerOutParameter(3, Types.VARCHAR);
            var = true;
            System.out.println("ERROR DE VIOLACION DE LLAVES PRIMARIAS");

        }catch(SQLException e){
            return false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se muestra todos los registros de la tabla cuenta_rol
     * no recibe parametros de entrada
     * retorna un arraylist en el cual estaran todos los registros.
     */
    public ArrayList<Cuenta_Roles> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        ArrayList<Cuenta_Roles> eeg = new ArrayList();

        try{
            ResultSet rs = con.ejecutaCon("Select * from Cuenta_Roles");
            while(rs.next()){
                Cuenta_Roles ee=new Cuenta_Roles();
                Cuenta eg = new Cuenta();
                Roles es = new Roles();
                
                es.setId(rs.getInt(1));
                ee.setId_Rol(es);
                
                eg.setUser(rs.getString(2));
                ee.setUser_Cuenta(eg);
                
               
                
                eeg.add(ee);
            }
        }catch(SQLException e){
            System.out.println("error "+e);	
            return null;
        }
        return eeg;
    }
}