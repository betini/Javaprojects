package integrador;

import java.sql.Date;
public class Estudios_Egresado{

 Estudios Id_estudios;
 Egresado Id_Egresado;
 private String Titulo;
 private Date Fecha_Grado;

    public Date getFecha_Grado() {
        return Fecha_Grado;
    }

    public void setFecha_Grado(Date Fecha_Grado) {
        this.Fecha_Grado = Fecha_Grado;
    }

    public Estudios getId_estudios() {
        return Id_estudios;
    }

    public void setId_estudios(Estudios Id_estudios) {
        this.Id_estudios = Id_estudios;
    }

    public Egresado getId_Egresado() {
        return Id_Egresado;
    }

    public void setId_Egresado(Egresado Id_Egresado) {
        this.Id_Egresado = Id_Egresado;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

   

 



}