/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taller10;


public class Dependencia {
    
    private int id;
	private String nombre;
	

	public Dependencia (){}

	public void setId (int id){
		this.id = id;
	}

	public int getId(){
		return this.id;
	}
	
	public void setNombre (String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return this.nombre;
	}
}
