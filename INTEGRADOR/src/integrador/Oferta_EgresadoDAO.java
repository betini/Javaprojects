package integrador;
import CONEXION.*;
import java.sql.*;
import java.util.ArrayList;

public class Oferta_EgresadoDAO {

    public Oferta_EgresadoDAO (){ }
    /*
     * En esta funcion se inserta un registro a la tabla Oferta_Egresado
     * recibe como parametro de entrada un tipo de dato Oferta_Egresado
     * retorna una variable de tipo booleana true en caso que la insercion fue exitosa
     * false en caso que no se pueda ingresar la informacion
     */
    public boolean create(Oferta_Egresado oe){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_INSOF_EG(?,?,?,?)}");
            cs.setInt(1,oe.getId_Oferta().getId());
            cs.setLong(2,oe.getId_Egresado().getId());
            cs.setDate(3,oe.getFecha_Postulacion());
            cs.registerOutParameter(4, Types.VARCHAR);
            var = cs.execute();
            System.out.println(cs.getString(4));

        }catch(SQLException e){
            System.out.println("error "+e);
            var = false;
        }
        con.CerrarCon();
        return var;
    }
   /*
     * En esta funcion se Busca por id un registro de la tabla Oferta_Egresado
     * recibe como parametro de entrada una variable int
     * retorna un registro en caso tal que se encuentre o de lo contrario
     * muestra un mensaje de error
     */
    public Oferta_Egresado findByID(int Ido,Long Ide){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        Oferta_Egresado oe= new Oferta_Egresado();
        try{
        CallableStatement cs = c.prepareCall("{? = call F_BUSNOMOF_EG(?,?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setInt(2, Ido);
        cs.setLong(3, Ide);
        cs.execute();
        System.out.println(cs.getString(1));
        //oe.setFecha_Postulacion(cs.getDate(1));
        //oe.getId_Oferta().setId(2);
        //oe.getId_Egresado().setId(Ide);
        con.CerrarCon();
        return oe;
        }catch(SQLException e){
            System.out.println("erorrrr findbyid "+e);
            con.CerrarCon();
            return null;
        }

    }
    /*
     * En esta funcion se elimina por id un registro de la tabla Oferta_Egresado
     * recibe como parametro de entrada una variable int
     * retorna una variable de tipo boleana true en caso que se pudo eliminar el
     * registro correctamente False en el caso contrario
     */
    public boolean deleteByID(int Ido,Long Ide){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_DELOF_EG(?,?,?)}");
            cs.setInt(1, Ido);
            cs.setLong(2, Ide);
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
     * En esta funcion se elimina todos los registro de la tabla Oferta_Egresado
     * no recibe parametros de entrada
     * retorna una variable de tipo string 
     */
    public String deleteAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        String var;
        try{
            CallableStatement cs = c.prepareCall("{call P_DELALLOF_EG(?)}");
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
     * En esta funcion se actualiza por medio del id un registro de la tabla Oferta_Egresado
     *  recibe como parametro de entrada un tipo de dato Oferta_Egresado
     * retorna una variable de tipo boleana true en caso que se pudo actualizar el
     * registro correctamente False en el caso contrario
     */
    public boolean update(Oferta_Egresado oe){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_UPDOF_EG(?,?,?,?)}");
            cs.setInt(1,oe.getId_Oferta().getId());
            cs.setLong(2,oe.getId_Egresado().getId());
            cs.setDate(3,oe.getFecha_Postulacion());
            
            cs.registerOutParameter(4, Types.VARCHAR);
            var =  cs.execute();
            System.out.println(cs.getString(4));

        }catch(SQLException e){
            System.out.println("error "+e);
            return false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se muestra todos los registros de la tabla Oferta_Egresado
     * * no recibe parametros de entrada
     * retorna un arraylist en el cual estaran todos los registros.
     */
    public ArrayList<Oferta_Egresado> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        ArrayList<Oferta_Egresado> oeg = new ArrayList();

        try{
            ResultSet rs = con.ejecutaCon("Select * from Oferta_Egresado");
            while(rs.next()){
                Oferta_Egresado oe=new Oferta_Egresado();
                Egresado eg =new Egresado();
                Oferta of=new Oferta();
                
                of.setId(rs.getInt(1));
                oe.setId_Oferta(of);
                
                eg.setId(rs.getLong(2));
                oe.setId_Egresado(eg);
                
                oe.setFecha_Postulacion(rs.getDate(3));
                
                oeg.add(oe);
            }
        }catch(SQLException e){
            System.out.println("error "+e);
            return null;
        }
        return oeg;
    }
}