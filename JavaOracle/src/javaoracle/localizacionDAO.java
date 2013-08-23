/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaoracle;

import java.sql.*;
import java.util.ArrayList;


public class localizacionDAO {
    
    
    
    public boolean create(localizacion l){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_insloc(?,?,?)}");
            cs.setString(1,l.getCodalf());
            cs.setString(2,l.getNombre());
            cs.registerOutParameter(3, Types.VARCHAR);
            var = cs.execute();
           
        }catch(SQLException e){
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    
    public localizacion findByID(String cod){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        localizacion l = new localizacion();
        try{
        CallableStatement cs = c.prepareCall("{? = call f_busNomloc(?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setString(2, cod);
        cs.execute();
        l.setCodalf(cod);
        l.setNombre(cs.getString(1));
        con.CerrarCon();
        return l;
        }catch(SQLException e){
            System.out.println("erorrrr findbyid "+e);
            con.CerrarCon();
            return null;
        }
        
    }
    
    public boolean deleteByID(localizacion l){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_delloc(?,?)}");
            cs.setString(1,l.getCodalf());
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
            CallableStatement cs = c.prepareCall("{call p_delalloc(?)}");
            cs.registerOutParameter(1, Types.VARCHAR);
             cs.execute();
            var = cs.getString(1);
          
        }catch(SQLException e){
            var = "error "+e;
        }
        con.CerrarCon();
        return var;
    }
    
    public boolean update(localizacion l){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_updloc(?,?,?)}");
            cs.setString(1, l.getCodalf());
            cs.setString(2, l.getNombre());
            cs.registerOutParameter(3, Types.VARCHAR);
            var =  cs.execute();
            
          
        }catch(SQLException e){
            return false;
        }
        con.CerrarCon();
        return var;
    }
 
    public ArrayList<localizacion> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        ArrayList<localizacion> loc = new ArrayList<localizacion>();
        
        try{
            ResultSet rs = con.ejecutaCon("Select * from localizacion");
            while(rs.next()){
                localizacion l = new localizacion();
                l.setCodalf(rs.getString(1));
                l.setNombre(rs.getString(2));
                loc.add(l);
            }
        }catch(SQLException e){
            return null;
        }
        return loc;
    }
}
