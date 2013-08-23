
package integrador;

import java.sql.Date;


public class Info_laboral {
    
    private int Id;
    private String Jefe;
    private String Cargo;
    private String Funcion;
    private Date Fecha_ini;
    private Date Fecha_fin;
    private String Motivo_retiro;
    Egresado id_egresado;
    private String Perfil;

    public Egresado getId_egresado() {
        return this.id_egresado;
    }

    public void setId_egresado(Egresado id_egresado) {
        this.id_egresado = id_egresado;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getJefe() {
        return Jefe;
    }

    public void setJefe(String Jefe) {
        this.Jefe = Jefe;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getFuncion() {
        return Funcion;
    }

    public void setFuncion(String Funcion) {
        this.Funcion = Funcion;
    }

    public Date getFecha_ini() {
        return Fecha_ini;
    }

    public void setFecha_ini(Date Fecha_ini) {
        this.Fecha_ini = Fecha_ini;
    }

    public Date getFecha_fin() {
        return Fecha_fin;
    }

    public void setFecha_fin(Date Fecha_fin) {
        this.Fecha_fin = Fecha_fin;
    }

    public String getMotivo_retiro() {
        return Motivo_retiro;
    }

    public void setMotivo_retiro(String Motivo_retiro) {
        this.Motivo_retiro = Motivo_retiro;
    }

 

    public String getPerfil() {
        return Perfil;
    }

    public void setPerfil(String Perfil) {
        this.Perfil = Perfil;
    }
    
    
    
}
