package integrador;
import java.sql.Date;
public class Oferta_Egresado {

    Oferta Id_Oferta;
    Egresado Id_Egresado;
    private Date Fecha_Postulacion;

    public Oferta getId_Oferta() {
        return Id_Oferta;
    }

    public void setId_Oferta(Oferta Id_Oferta) {
        this.Id_Oferta = Id_Oferta;
    }

    public Egresado getId_Egresado() {
        return Id_Egresado;
    }

    public void setId_Egresado(Egresado Id_Egresado) {
        this.Id_Egresado = Id_Egresado;
    }

    public Date getFecha_Postulacion() {
        return Fecha_Postulacion;
    }

    public void setFecha_Postulacion(Date Fecha_Postulacion) {
        this.Fecha_Postulacion = Fecha_Postulacion;
    }
   

    
}