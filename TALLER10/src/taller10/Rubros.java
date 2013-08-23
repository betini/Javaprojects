/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taller10;


public class Rubros {
    
    private int id;
	private String nombre;
	private Categoria id_cate;
	

	public Rubros (){}

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
	
	public void setId_cate (Categoria id_cate){
		this.id_cate= id_cate;
	}

	public Categoria getId_cate(){
		return this.id_cate;
	}

}
