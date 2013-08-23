/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taller10;

import CONEXION.*;
import java.sql.*;
import java.util.ArrayList;

public class DependenciaDAO {
    public DependenciaDAO(){ }

    public boolean create(Dependencia d){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_insdep(?,?)}");
            cs.setString(1,d.getNombre());
            cs.registerOutParameter(2, Types.VARCHAR);
            var = cs.execute();
            System.out.println(cs.getString(2));	
        }catch(SQLException e){
            System.out.println("erorrrr findbyid "+e);
            var = false;
        }
        con.CerrarCon();
        return var;
    }

    public Dependencia findByID(int id){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        Dependencia d = new Dependencia();
        try{
        CallableStatement cs = c.prepareCall("{? = call f_busdep(?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setInt(2, id);
        cs.execute();
        System.out.println(cs.getString(1));
        con.CerrarCon();
        
        return d;
        }catch(SQLException e){
            System.out.println("erorrrr findbyid "+e);
            con.CerrarCon();
            return null;
        }

    }

    public boolean deleteByID(Dependencia d){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_deldep(?,?)}");
            cs.setInt(1,d.getId());
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

    public String deleteAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        String var;
        try{
            CallableStatement cs = c.prepareCall("{call p_delalldep(?)}");
            cs.registerOutParameter(1, Types.VARCHAR);
             cs.execute();
            var = cs.getString(1);
             System.out.println(cs.getString(1));	

        }catch(SQLException e){
            System.out.println("erorrrr findbyid "+e);
            var = "error "+e;
        }
        con.CerrarCon();
        return var;
    }

    public boolean update(Dependencia d){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_upddep(?,?,?)}");
            cs.setInt(1, d.getId());
            cs.setString(2, d.getNombre());
            cs.registerOutParameter(3, Types.VARCHAR);
            var =  cs.execute();
            System.out.println(cs.getString(3));	

        }catch(SQLException e){
            System.out.println("error " +e);	
            return false;
        }
        con.CerrarCon();
        return var;
    }

    public ArrayList<Dependencia> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        ArrayList<Dependencia> dep = new ArrayList<Dependencia>();

        try{
            ResultSet rs = con.ejecutaCon("Select * from dependencia");
            while(rs.next()){
                Dependencia d = new Dependencia();
                                
                
                d.setId(rs.getInt(1));
                d.setNombre(rs.getString(2));
                
                
                dep.add(d);
            }
        }catch(SQLException e){
            return null;
        }
        return dep;
    }
}
