
package javaoracle;

public class localizacion {   
   
 private String codalf;
  private String nombre; 
 
 public String getNombre(){
     return this.nombre;
 }
 
 public String getCodalf(){
     return this.codalf;
 }
 
 public void setNombre(String nom){
     this.nombre = nom;
 }
 
 public void setCodalf(String cod){
     this.codalf = cod;
 }
 public String toString()
 {
     return this.codalf+" "+this.getNombre();
 }
}
