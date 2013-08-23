package javaoracle;

public class seccion {
    complejodeportivo id_complejo;
    Deporte deporte;
    localizacion localizacion;
    
    public seccion(){}
    
    public void setIdComplejo(complejodeportivo idCom){
        this.id_complejo = idCom;
    }
    
    public complejodeportivo getIdComplejo(){
        return this.id_complejo;
    }
    
    public void setIdDeporte(Deporte idDep){
        this.deporte = idDep;
    }
    
    public Deporte getDeporte(){
        return this.deporte;
    }
    
    public void setIdLocalizacion(localizacion idLoc){
        this.localizacion = idLoc;
    }
    
    public localizacion getIdLocalizacion(){
        return this.localizacion;
    }
}