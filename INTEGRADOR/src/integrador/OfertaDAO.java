package integrador;
import CONEXION.*;
import java.sql.*;
import java.util.ArrayList;

public class OfertaDAO {

    public OfertaDAO(){ }
    /*
     * En esta funcion se inserta un registro a la tabla Oferta
     * recibe como parametro de entrada un tipo de dato Oferta
     * retorna una variable de tipo booleana true en caso que la insercion fue exitosa
     * false en caso que no se pueda ingresar la informacion
     */
    public boolean create(Oferta of){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_INSOFER(?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, of.getCargo());
            cs.setString(2, of.getFunciones());
            cs.setString(3, of.getRequisitos());
            cs.setLong(4, of.getSueldo());
            cs.setString(5, of.getEstado());
            cs.setDate(6, of.getFecha_apertura());
            cs.setDate(7, of.getFecha_caducidad());
            cs.setInt(8, of.getEmpresa().getCodnum());
            cs.registerOutParameter(9, Types.VARCHAR);
            var = cs.execute();
            System.out.println(cs.getString(9));


        }catch(SQLException e){
            System.out.println("error "+e);
            var = false;
        }
        con.CerrarCon();
        return var;
    }
   /*
     * En esta funcion se Busca por id un registro de la tabla Oferta
     * recibe como parametro de entrada una variable int
     * retorna un registro en caso tal que se encuentre o de lo contrario
     * muestra un mensaje de error
     */
    public Oferta findByID(int id){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        Oferta of = new Oferta();
        try{
        CallableStatement cs = c.prepareCall("{? = call F_BUSOFE(?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setInt(2, id);
        cs.execute();
        System.out.println(cs.getString(1));
        //of.setId(id);
        //of.setCargo(cs.getString(1));
        //of.setId(cs.getInt(2));
        
        con.CerrarCon();
        return of;
        }catch(SQLException e){
            System.out.println("erorrrr findbyid "+e);
            con.CerrarCon();
            return null;
        }

    }
    /*
     * En esta funcion se elimina por id un registro de la tabla Oferta
     * recibe como parametro de entrada una variable int
     * retorna una variable de tipo boleana true en caso que se pudo eliminar el
     * registro correctamente False en el caso contrario
     */
    public boolean deleteByID(Oferta of){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_DELOFE(?,?)}");
            cs.setInt(1,of.getId());
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
     * En esta funcion se elimina todos los registro de la tabla Oferta
     * no recibe parametros de entrada
     * retorna una variable de tipo string 
     */
    public String deleteAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        String var;
        try{
            CallableStatement cs = c.prepareCall("{call P_DELALLOFE(?)}");
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
     * En esta funcion se actualiza por medio del id un registro de la tabla Oferta
     * recibe como parametro de entrada un tipo de dato Oferta
     * retorna una variable de tipo boleana true en caso que se pudo actualizar el
     * registro correctamente False en el caso contrario
     */
    public boolean update(Oferta of){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_UPDOFE(?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, of.getId());
            cs.setString(2, of.getCargo());
            cs.setString(3, of.getFunciones());
            cs.setString(4, of.getRequisitos());
            cs.setLong(5, of.getSueldo());
            cs.setString(6, of.getEstado());
            cs.setDate(7, of.getFecha_apertura());
            cs.setDate(8, of.getFecha_caducidad());
            cs.setInt(9, of.getEmpresa().getCodnum());
                        
            cs.registerOutParameter(10, Types.VARCHAR);
            var =  cs.execute();
            System.out.println(cs.getString(10));

        }catch(SQLException e){
            System.out.println("error "+e);
            return false;
        }
        con.CerrarCon();
        return var;
    }
    /*
     * En esta funcion se muestra todos los registros de la tabla Oferta
     * no recibe parametros de entrada
     * retorna un arraylist en el cual estaran todos los registros.
     */
    public ArrayList<Oferta> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        ArrayList<Oferta> ofe = new ArrayList();

        try{
            ResultSet rs = con.ejecutaCon("Select * from Oferta");
            while(rs.next()){
                Oferta of = new Oferta();
                Empresa emp=new Empresa();
                of.setId(rs.getInt(1));
                of.setCargo(rs.getString(2));
                of.setFunciones(rs.getString(3));
                of.setRequisitos(rs.getString(4));
                of.setSueldo(rs.getLong(5));
                of.setEstado(rs.getString(6));
                of.setFecha_apertura(rs.getDate(7));
                of.setFecha_caducidad(rs.getDate(8));
                emp.setCodnum(rs.getInt(9));
                of.setEmpresa(emp);
                ofe.add(of);
            }
        }catch(SQLException e){
            System.out.println("error "+e);
            return null;
        }
        return ofe;
    }
}