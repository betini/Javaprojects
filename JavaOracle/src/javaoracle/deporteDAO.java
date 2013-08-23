package javaoracle;

import java.sql.*;
import java.util.ArrayList;

public class deporteDAO {
    
    public deporteDAO(){ }
    
    public boolean create(Deporte d){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_insdep(?,?)}");
            cs.setString(1,d.getNombre());
            cs.registerOutParameter(2, Types.VARCHAR);
            var = cs.execute();
           
        }catch(SQLException e){
            var = false;
        }
        con.CerrarCon();
        return var;
    }
    
    public Deporte findByID(int cod){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        Deporte d = new Deporte();
        try{
        CallableStatement cs = c.prepareCall("{? = call f_busNomdep(?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setInt(2, cod);
        cs.execute();
        d.setCodigo(cod);
        d.setNombre(cs.getString(1));
        con.CerrarCon();
        return d;
        }catch(SQLException e){
            System.out.println("erorrrr findbyid "+e);
            con.CerrarCon();
            return null;
        }
        
    }
    
    public boolean deleteByID(Deporte d){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_deldep(?,?)}");
            cs.setInt(1,d.getCodigo());
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
            CallableStatement cs = c.prepareCall("{call p_delalldep(?)}");
            cs.registerOutParameter(1, Types.VARCHAR);
             cs.execute();
            var = cs.getString(1);
          
        }catch(SQLException e){
            var = "error "+e;
        }
        con.CerrarCon();
        return var;
    }
    
    public boolean update(Deporte d){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_upddep(?,?,?)}");
            cs.setInt(1, d.getCodigo());
            cs.setString(2, d.getNombre());
            cs.registerOutParameter(3, Types.VARCHAR);
            var =  cs.execute();
            
          
        }catch(SQLException e){
            return false;
        }
        con.CerrarCon();
        return var;
    }
 
    public ArrayList<Deporte> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        ArrayList<Deporte> dep = new ArrayList<Deporte>();
        
        try{
            ResultSet rs = con.ejecutaCon("Select * from deporte");
            while(rs.next()){
                Deporte d = new Deporte();
                d.setCodigo(rs.getInt(1));
                d.setNombre(rs.getString(2));
                dep.add(d);
            }
        }catch(SQLException e){
            return null;
        }
        return dep;
    }
}