package javaoracle;

public class Deporte {
 
 private String nombre;    
 private int codigo;
 
 public String getNombre(){
     return this.nombre;
 }
 
 public int getCodigo(){
     return this.codigo;
 }
 
 public void setNombre(String nom){
     this.nombre = nom;
 }
 
 public void setCodigo(int cod){
     this.codigo = cod;
 }
 public String toString()
 {
     return this.codigo+" "+this.getNombre();
 }
 
}