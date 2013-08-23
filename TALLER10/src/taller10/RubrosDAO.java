/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taller10;
import CONEXION.*;
import java.sql.*;
import java.util.ArrayList;

public class RubrosDAO {
   
     public RubrosDAO(){ }
    
    public boolean create(Rubros r){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_insrub(?,?,?)}");
            cs.setString(1,r.getNombre());
            cs.setInt(2,r.getId_cate().getId());
            cs.registerOutParameter(3, Types.VARCHAR);
            var = cs.execute();
            System.out.println(cs.getString(3));	
        }catch(SQLException e){
             System.out.println("errorrr: "+e);	
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    
    public Rubros findByID(int id){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        Rubros r = new Rubros();
        try{
        CallableStatement cs = c.prepareCall("{? = call f_busrub(?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setInt(2, id);
        cs.execute();
        System.out.println(cs.getString(1));	
        con.CerrarCon();
        return r;
        }catch(SQLException e){
            System.out.println("erorrrr findbyid "+e);
            con.CerrarCon();
            return null;
        }
        
    }
    
    public boolean deleteByID(Rubros r){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_delrub(?,?)}");
            cs.setInt(1,r.getId());
            cs.registerOutParameter(2, Types.VARCHAR);
            var = cs.execute();
           System.out.println(cs.getString(2));	
        }catch(SQLException e){
             System.out.println("errorr: " +e);	
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
            CallableStatement cs = c.prepareCall("{call p_delallrub(?)}");
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.execute();
            var = cs.getString(1);
           System.out.println(cs.getString(1));	
        }catch(SQLException e){
             	
            var = "error "+e;
             System.out.println(var);	
        }
        con.CerrarCon();
        return var;
    }
    
    public boolean update(Rubros r){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_updrub(?,?,?,?)}");
            cs.setInt(1, r.getId());
            cs.setString(2, r.getNombre());
            cs.setInt(3, r.getId_cate().getId());
            cs.registerOutParameter(4, Types.VARCHAR);
            var =  cs.execute();
             System.out.println(cs.getString(4));	
          
        }catch(SQLException e){
             System.out.println("error: " +e);	
            return false;
        }
        con.CerrarCon();
        return var;
    }
 
    public ArrayList<Rubros> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        ArrayList<Rubros> r = new ArrayList<Rubros>();
        
        try{
            ResultSet rs = con.ejecutaCon("Select * from rubros");
            while(rs.next()){
                Rubros rb = new Rubros();
                Categoria cat=new Categoria();
                rb.setId(rs.getInt(1));
                rb.setNombre(rs.getString(2));
                cat.setId(rs.getInt(3));
                rb.setId_cate(cat);
                r.add(rb);
            }
        }catch(SQLException e){
            return null;
        }
        return r;
    }
}
