/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taller10;

import CONEXION.*;
import java.sql.*;
import java.util.ArrayList;
public class CategoriaDAO {
    public CategoriaDAO(){ }

    public boolean create(Categoria cat){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_inscat(?,?)}");
            cs.setString(1,cat.getNombre());
            cs.registerOutParameter(2, Types.VARCHAR);
            var = cs.execute();
            System.out.println(cs.getString(2));

        }catch(SQLException e){
              System.out.println("error: "+e);
            var = false;
        }
        con.CerrarCon();
        return var;
    }

    public Categoria findByID(int id){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();
        Categoria cat = new Categoria();
        try{
        CallableStatement cs = c.prepareCall("{? = call f_buscat(?)}");
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.setInt(2, id);
        cs.execute();
        System.out.println(cs.getString(1));
        con.CerrarCon();
        return cat;
        }catch(SQLException e){
            System.out.println("erorrrr findbyid "+e);
            con.CerrarCon();
            return null;
        }

    }

    public boolean deleteByID(Categoria cat){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_delcat(?,?)}");
            cs.setInt(1,cat.getId());
            cs.registerOutParameter(2, Types.VARCHAR);
            var = cs.execute();
              System.out.println(cs.getString(2));

        }catch(SQLException e){
              System.out.println("error: "+ e);
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
            CallableStatement cs = c.prepareCall("{call p_delallcat(?)}");
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

    public boolean update(Categoria cat){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        boolean var;
        try{
            CallableStatement cs = c.prepareCall("{call p_updcat(?,?,?)}");
            cs.setInt(1, cat.getId());
            cs.setString(2, cat.getNombre());
            cs.registerOutParameter(3, Types.VARCHAR);
            var =  cs.execute();
              System.out.println(cs.getString(3));


        }catch(SQLException e){
            System.out.println("error: "+e);
            return false;
        }
        con.CerrarCon();
        return var;
    }

    public ArrayList<Categoria> findAll(){
        ConexionBD con = new ConexionBD();
        Connection c = con.conOracle();

        ArrayList<Categoria> ca = new ArrayList<Categoria>();

        try{
            ResultSet rs = con.ejecutaCon("Select * from categoria");
            while(rs.next()){
                Categoria cat = new Categoria ();
                                
                
                cat.setId(rs.getInt(1));
                cat.setNombre(rs.getString(2));
                
                
                ca.add(cat);
            }
        }catch(SQLException e){
            return null;
        }
        return ca;
    }
}
