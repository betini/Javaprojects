/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taller10;


public class Rubro_Dependencia {
    
    private Rubros Id_Rub;
    private Dependencia Id_Dep ;
    private int annio;
    private long presupuesto;

    public  Rubro_Dependencia() {}
     public Rubros getId_Rubro() {
        return Id_Rub;
    }

    public void setId_Rubro(Rubros Id_Rub) {
        this.Id_Rub = Id_Rub;
    }

    public Dependencia getId_Dependencia() {
        return Id_Dep;
    }

    public void setId_Dependencia(Dependencia Id_Dep) {
        this.Id_Dep = Id_Dep;
    }

    public int getAnnio() {
        return annio;
    }

    public void setAnnio(int annio) {
        this.annio = annio;
    }
    
     public Long getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Long presupuesto) {
        this.presupuesto = presupuesto;
    }
   
}
