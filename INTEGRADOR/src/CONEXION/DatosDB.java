
package CONEXION;

import java.util.Properties;

public class DatosDB {
    //Atributos
    private String host;
    private String port;
    private String SID;
    private String user;
    private String pass;
    
    //Métodos
    //Este método ubica el archvo .properties
    private Properties getDatos(){
    try{
        Properties p = new Properties();
        
        p.load(getClass().getResourceAsStream("DatosDB.properties"));
        if(!p.isEmpty()){
            return p;
        }else{
        return null;
        }
    }catch(Exception e){
        System.out.println("Error "+e);
        return null;
    }
    
    }
    
    //este método captura las claves del archivo .properties
    public void captura(){
        Properties pr = new DatosDB().getDatos();
        this.host = pr.getProperty("host");
        this.SID = pr.getProperty("SID");
        this.port = pr.getProperty("port");
        this.pass = pr.getProperty("password");
        this.user = pr.getProperty("user");
    }
    
    //Métodos para obtener los datos de conexión desde otras clases
    
    public String getHost(){
    return this.host;
    }
    
    public String getPort(){
    return this.port;
    }
    
    public String getSid(){
    return this.SID;
    }
    
    public String getUser(){
    return this.user;
    }
    
    public String getPass(){
    return this.pass;
    }
}