
package javaoracle;


public class complejodeportivo {
    
 private int codigo;
 private String nombre;  
 private String tipo;
 private int area;
 private int sede_codnum;
 
 public String getNombre(){
     return this.nombre;
 }
 
 public int getCodigo(){
     return this.codigo;
 }
 
 public String getTipo(){
     return this.tipo;
 }
 
 public int getArea(){
     return this.area;
 }
 
  public int getSede(){
     return this.sede_codnum;
 }
  
 public void setNombre(String nom){
     this.nombre = nom;
 }
 
 public void setCodigo(int cod){
     this.codigo = cod;
 }
 
 public void setTipo(String tip){
     this.tipo=tip;
 }
 
 public void setArea(int area){
     this.area=area;
 }
 
  public void setSede(int sed){
     this.sede_codnum=sed;
 }
 public String toString()
 {
     return this.codigo+" "+this.getNombre();
 }
 
}
