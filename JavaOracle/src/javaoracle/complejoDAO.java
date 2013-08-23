
package javaoracle;

import java.sql.*;
import java.util.ArrayList;
public class complejoDAO {
    
       public boolean create(complejodeportivo cp){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_inscomp(?,?,?,?,?)}");
            cs.setString(1,cp.getNombre());
            cs.setString(2,cp.getTipo());
            cs.setInt(3,cp.getArea());
            cs.setInt(4,cp.getSede());
            cs.registerOutParameter(5, Types.VARCHAR);
            var = cs.execute();
           
        }catch(SQLException e){
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    
    public complejodeportivo findByID(int cod){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        complejodeportivo cd = new complejodeportivo();
        try{
        CallableStatement cs = c.prepareCall("{? = call f_busNomcomp(?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setInt(2, cod);
        cs.execute();
        cd.setCodigo(cod);
        cd.setNombre(cs.getString(1));
        con.CerrarCon();
        return cd;
        }catch(SQLException e){
            System.out.println("erorrrr findbyid "+e);
            con.CerrarCon();
            return null;
        }
        
    }
    
    public boolean deleteByID(complejodeportivo cd){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_delcomp(?,?)}");
            cs.setInt(1,cd.getCodigo());
            cs.registerOutParameter(2, Types.VARCHAR);
            var = cs.execute();
          
        }catch(SQLException e){
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    
    public String deleteAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        String var;
        try{
            CallableStatement cs = c.prepareCall("{call p_delallcomp(?)}");
            cs.registerOutParameter(1, Types.VARCHAR);
             cs.execute();
            var = cs.getString(1);
          
        }catch(SQLException e){
            var = "error "+e;
        }
        con.CerrarCon();
        return var;
    }
    
    public boolean update(complejodeportivo cp){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_updCOMP(?,?,?,?,?,?)}");
            cs.setInt(1,cp.getCodigo());
            cs.setString(2, cp.getNombre());
            cs.setString(3,cp.getTipo());
            cs.setInt(4,cp.getArea());
            cs.setInt(5,cp.getSede());
            cs.registerOutParameter(6, Types.VARCHAR);
            var =  cs.execute();
            
          
        }catch(SQLException e){
            return false;
        }
        con.CerrarCon();
        return var;
    }
 
    public ArrayList<complejodeportivo> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        ArrayList<complejodeportivo> cd = new ArrayList<complejodeportivo>();
        
        try{
            ResultSet rs = con.ejecutaCon("Select * from complejodeportivo");
            while(rs.next()){
                complejodeportivo cp = new complejodeportivo();
                cp.setCodigo(rs.getInt(1));
                cp.setNombre(rs.getString(2));
                cp.setTipo(rs.getString(3));
                cp.setArea(rs.getInt(4));
                cp.setSede(rs.getInt(5));
                
                
                cd.add(cp);
            }
        }catch(SQLException e){
            return null;
        }
        return cd;
    }
}
