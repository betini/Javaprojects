/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taller10;

import CONEXION.*;
import java.sql.*;
import java.util.ArrayList;

public class Rubro_DependenciaDAO {
    
    public Rubro_DependenciaDAO(){}
    
    public boolean create(Rubro_Dependencia rd){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_INS_RUB_DEP(?,?,?,?,?)}");
            cs.setInt(1, rd.getId_Dependencia().getId());
            cs.setInt(2,rd.getId_Rubro().getId());
            cs.setInt(3, rd.getAnnio());
            cs.setLong(4, rd.getPresupuesto());
            cs.registerOutParameter(5, Types.VARCHAR);
            var = cs.execute();
            System.out.println(cs.getString(5));



        }catch(SQLException e){
            var = false;
        }
        con.CerrarCon();
        return var;
    }
 
    public Rubro_Dependencia findByID(int Idd,int Idr, int annio){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        Rubro_Dependencia rd= new Rubro_Dependencia();
        try{
        CallableStatement cs = c.prepareCall("{? = call F_BUS_RUB_DEP(?,?,?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setInt(2, Idd);
        cs.setInt(3, Idr);
        cs.setInt(4, annio);
        cs.execute();
            System.out.println(cs.getString(1));
        con.CerrarCon();
        return rd;
        }catch(SQLException e){
            System.out.println("erorrrr findbyid "+e);
            con.CerrarCon();
            return null;
        }

    }
  
    public boolean deleteByPK(Rubro_Dependencia rd){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_DEL_RUB_DEP(?,?,?,?)}");
            cs.setInt(1,rd.getId_Dependencia().getId());
            cs.setInt(2,rd.getId_Rubro().getId());
            cs.setInt(3, rd.getAnnio());
            cs.registerOutParameter(4, Types.VARCHAR);
            var = cs.execute();
              System.out.println(cs.getString(4));
        }catch(SQLException e){
              System.out.println("error "+ e);
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
            CallableStatement cs = c.prepareCall("{call P_DELALL_RUB_DEP(?)}");
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
  
    public boolean update(Rubro_Dependencia rd){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call P_UPD_RUB_DEP(?,?,?,?,?)}");
            cs.setInt(1,rd.getId_Dependencia().getId());
            cs.setInt(2,rd.getId_Rubro().getId());
            cs.setInt(3,rd.getAnnio());
             cs.setLong(4,rd.getPresupuesto());
            cs.registerOutParameter(5, Types.VARCHAR);
            var =  cs.execute();    
              System.out.println(cs.getString(5));


        }catch(SQLException e){
              System.out.println("error" + e);
            return false;
        }
        con.CerrarCon();
        return var;
    }
   
    public ArrayList<Rubro_Dependencia> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        ArrayList<Rubro_Dependencia> rdg = new ArrayList();

        try{
            ResultSet rs = con.ejecutaCon("Select * from Rubro_Dependencia");
            while(rs.next()){
                Rubro_Dependencia rd=new Rubro_Dependencia();
                Dependencia d =new Dependencia();
                Rubros r=new Rubros();
                
                d.setId(rs.getInt(1));
                rd.setId_Dependencia(d);
                
                r.setId(rs.getInt(2));
                rd.setId_Rubro(r);
                rd.setAnnio(rs.getInt(3));
                rd.setPresupuesto(rs.getLong(4));
                
                
                rdg.add(rd);
            }
        }catch(SQLException e){
              System.out.println("error"+ e);
            return null;
        }
        return rdg;
    }
    
}
