
package javaoracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.*;
import java.util.ArrayList;

public class seccionDAO {
    public seccionDAO(){}
    
    public String create(seccion s){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        String var;
        try{
            CallableStatement cs = c.prepareCall("{call p_inseccion(?,?,?,?)}");
            cs.setInt(1,s.getDeporte().getCodigo());
            cs.setString(2,s.getIdLocalizacion().getCodalf());
            cs.setInt(3,s.getIdComplejo().getCodigo());
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.execute();
           var = cs.getString(4);
        }catch(SQLException e){
            var = "error "+ e;
        }
        con.CerrarCon();
        return var;
    }
    
    public boolean findByID(int cod,  int id){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        seccion s = new seccion();
        try{
        CallableStatement cs = c.prepareCall("{? = call f_bussec(?,?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setInt(2, cod);
        cs.setInt(3, id);
        cs.execute();
        con.CerrarCon();
        return true;
        }catch(SQLException e){
            System.out.println("erorrrr findbyid "+e);
            con.CerrarCon();
            return false;
        }
        
    }
    
    public boolean deleteByID(seccion s){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_delsec(?,?,?)}");
            cs.setInt(1,s.getDeporte().getCodigo());
            cs.setInt(2,s.getIdComplejo().getCodigo());
            cs.registerOutParameter(3, Types.VARCHAR);
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
            CallableStatement cs = c.prepareCall("{call p_delallsec(?)}");
            cs.registerOutParameter(1, Types.VARCHAR);
             cs.execute();
            var = cs.getString(1);
          
        }catch(SQLException e){
            var = "error "+e;
        }
        con.CerrarCon();
        return var;
    }
    
    public boolean update(seccion s){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_updsec(?,?,?,?)}");
            cs.setInt(1, s.getDeporte().getCodigo());
            cs.setString(2, s.getIdLocalizacion().getCodalf());
            cs.setInt(3, s.getIdComplejo().getCodigo());
            cs.registerOutParameter(4, Types.VARCHAR);
            var =  cs.execute();
            
          
        }catch(SQLException e){
            return false;
        }
        con.CerrarCon();
        return var;
    }
 
    
    
    
    public ArrayList<seccion> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        
        ArrayList<seccion> sec = new ArrayList<seccion>();
        
        try{
            ResultSet rs = con.ejecutaCon("Select * from seccion");
            while(rs.next()){
                seccion s = new seccion();
                Deporte d = new Deporte();
                complejodeportivo cd = new complejodeportivo();
                localizacion lo= new localizacion();
                
                d.setCodigo(rs.getInt(1));
                s.setIdDeporte(d);
                cd.setCodigo(rs.getInt(2));
                s.setIdComplejo(cd);
                lo.setCodalf(rs.getString(3));
                s.setIdLocalizacion(lo);
                       
             
                sec.add(s);
            }
        }catch(SQLException e){
            return null;
        }
        return sec;
    }
    
}