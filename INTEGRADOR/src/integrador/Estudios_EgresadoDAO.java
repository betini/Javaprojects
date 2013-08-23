package integrador;
import CONEXION.*;
import java.sql.*;
import java.util.ArrayList;

public class Estudios_EgresadoDAO {

    public Estudios_EgresadoDAO (){ }
    /*
     * En esta funcion se inserta un registro a la tabla estudios_egresado
     * recibe como parametro de entrada un tipo de dato estudios_egresado
     * retorna una variable de tipo booleana true en caso que la insercion fue exitosa
     * false en caso que no se pueda ingresar la informacion
     */
    public boolean create(Estudios_Egresado ee){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_INSES_EG(?,?,?,?,?)}");
            cs.setInt(1, ee.getId_estudios().getId());
            cs.setLong(2, ee.getId_Egresado().getId());
            cs.setString(3, ee.getTitulo());
            cs.setDate(4, ee.getFecha_Grado());
            
           
            cs.registerOutParameter(5, Types.VARCHAR);
            var = cs.execute();
            System.out.println(cs.getString(5));


        }catch(SQLException e){
            System.out.println("error "+e);
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se Busca por id un registro de la tabla estudios_egresado
     * recibe como parametro de entrada una variable int
     * retorna un registro en caso tal que se encuentre o de lo contrario
     * muestra un mensaje de error
     */
    public Estudios_Egresado findByID(Long ide, int idd){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        Estudios_Egresado ee=new Estudios_Egresado();
        try{
        CallableStatement cs = c.prepareCall("{? =call F_BUSNOMES_EG(?,?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setLong(2, ide);
        cs.setInt(3, idd);
        cs.execute();
        //ee.getId_estudios().setId(1);
        //ee.getId_Egresado().setId(ide);
        //ee.setTitulo(cs.getString(3));
        //ee.setFecha_Grado(cs.getDate(4));
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
     * En esta funcion se elimina por id un registro de la tabla estudios_egresado
     * recibe como parametro de entrada una variable int
     * retorna una variable de tipo boleana true en caso que se pudo eliminar el
     * registro correctamente False en el caso contrario
     */
    public boolean deleteByID(Estudios_Egresado ee){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_DELES_EG(?,?,?)}");
            cs.setLong(1,ee.getId_Egresado().getId());
            cs.setInt(2,ee.getId_estudios().getId());
            cs.registerOutParameter(3, Types.VARCHAR);
            var = cs.execute();
            System.out.println(cs.getString(3));
        }catch(SQLException e){
            System.out.println("error "+e);
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se elimina todos los registro de la tabla estudios_egresado
     * no recibe parametros de entrada
     * retorna una variable de tipo string 
     */
    public String deleteAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        String var;
        try{
            CallableStatement cs = c.prepareCall("{call P_DELALLES_EG(?)}");
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
     * En esta funcion se actualiza por medio del id un registro de la tabla estudios_egresado
     * recibe como parametro de entrada un tipo de dato estudios_egresado
     * retorna una variable de tipo boleana true en caso que se pudo actualizar el
     * registro correctamente False en el caso contrario
     */
    public boolean update(Estudios_Egresado ee){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_UPDES_EG(?,?,?,?,?)}");
            cs.setInt(1, ee.getId_estudios().getId());
            cs.setLong(2,ee.getId_Egresado().getId());
            cs.setString(3, ee.getTitulo());
            cs.setDate(4, ee.getFecha_Grado());
            cs.registerOutParameter(5, Types.VARCHAR);
            var =  cs.execute();
            System.out.println(cs.getString(5));

        }catch(SQLException e){
            System.out.println("error "+e);
            return false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se muestra todos los registros de la tabla estudios_egresado
     * no recibe parametros de entrada
     * retorna un arraylist en el cual estaran todos los registros.
     */
    public ArrayList<Estudios_Egresado> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        ArrayList<Estudios_Egresado> eeg = new ArrayList();

        try{
            ResultSet rs = con.ejecutaCon("Select * from Estudios_Egresado");
            while(rs.next()){
                Estudios_Egresado ee=new Estudios_Egresado();
                Egresado eg = new Egresado();
                Estudios es = new Estudios();
                
                es.setId(rs.getInt(1));
                ee.setId_estudios(es);
                
                eg.setId(rs.getLong(2));
                ee.setId_Egresado(eg);
                
                ee.setTitulo(rs.getString(3));
                ee.setFecha_Grado(rs.getDate(4));
               
                
                eeg.add(ee);
            }
        }catch(SQLException e){
            System.out.println("error "+e);
            return null;
        }
        return eeg;
    }
}