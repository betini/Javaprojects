/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taller10;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TALLER10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         String opc2;
         do
        {
         Scanner sc=new Scanner(System.in);
         System.out.println("Digite su opcion: \n1 Dependencia \n2 Rubros \n3 Categoria \n4 Rubro_Dependencia");
         System.out.print("Ingrese su Opcion: ");
         int opc=sc.nextInt();
         
        switch(opc)
        {
        case 1:
        	{
        		Dependencia();
        		break;
        	}
        case 2:
        	{
                        Rubros();
        		break;
        	}
        case 3:
        	{
                        Categoria();
                        break;
        	}
        case 4:
        	{
                        Rubro_Dependencia(); 
                        break;
        	}
       
        default:
        {
            System.out.println("no es valida la opcion");    
            break;
        }
    
        }
        
        System.out.println("¿Desea Continuar? seleccione S/N");
        opc2=sc.next();
        }
        while(opc2.equals("S")||opc2.equals("s"));
        

    }
    
    public static void Dependencia()
    {
    	Scanner sc = new Scanner(System.in);
    	int opc;
    	String nombre;
        int id;
        
      
    	DependenciaDAO dd = new DependenciaDAO();
        Dependencia d = new Dependencia();

    	System.out.println("Opciones referentes a la tabla Dependencia ");
    	System.out.println("1. Crear");
    	System.out.println("2. Encontrar por ID");
    	System.out.println("3. Borrar por ID");
    	System.out.println("4. Borrar todo ");
    	System.out.println("5. Actualizar");
        System.out.println("6. Encontrar todo");
    	System.out.println("Digite su opcion :");
    	
    	opc=sc.nextInt();
    
    	switch(opc)
    	{
    
    	case 1:
    		{
              
    	        System.out.println("Digite el nombre");
    	        nombre = sc.next();
    	       
    	        d.setNombre(nombre);
               
    	        dd.create(d);
    		 
    		break;
    		}
    	
   
    	case 2:
    		{
    	        System.out.println("Digite el id de dependencia");
    		id=sc.nextInt();
    		//c.setUser(user);
    		dd.findByID(id).getNombre();
    		break;
    		}
            
    
    	case 3:
    		{
        	        System.out.println("Digite el id de la Dependencia");
        		id=sc.nextInt();
        		
        		d.setId(id);
        		dd.deleteByID(d);
    			
    		break;
    		}
            
    	
    	case 4:
    		{
        	    dd.deleteAll();
                   
    			
    		break;
    		}
    	
           
    	case 5:
    		{
                
        	System.out.println("Digite el id de la Dependencia");
        	id = sc.nextInt();
               
                System.out.println("Digite el nombre de la Dependencia");
    	        nombre = sc.next();
              
                d.setId(id);
                d.setNombre(nombre);
        	dd.update(d);
    			
    		break;
    		}
        
    	case 6:
    		{
            	ArrayList<Dependencia> da = dd.findAll();
        
            	for (int x=0;x<da.size();x++){
                
                System.out.println(da.get(x).getId()+ " "+da.get(x).getNombre());
            }
            	
    		break;
    		}
    	default :
    		{
    		System.out.print("No existe la opccion deseada");
    		}
    	}  
    }
    public static void Rubros()
    {
    	Scanner sc = new Scanner(System.in);
    	int opc;
    	String nombre;
        int id, cat;
        

    	RubrosDAO rd = new RubrosDAO();
        Rubros r = new Rubros();
        Categoria c=new Categoria();

    	System.out.println("Opciones referentes a la tabla Rubros ");
    	System.out.println("1. Crear");
    	System.out.println("2. Encontrar por ID");
    	System.out.println("3. Borrar por ID");
    	System.out.println("4. Borrar todo ");
    	System.out.println("5. Actualizar");
        System.out.println("6. Encontrar todo");
    	System.out.println("Digite su opcion :");
    	
    	opc=sc.nextInt();
    
    	switch(opc)
    	{
  
    	case 1:
    		{
              
    	        System.out.println("Digite el nombre");
    	        nombre = sc.next();
                System.out.println("Digite el id de la categoria");
    	        cat = sc.nextInt();
    	       
    	        r.setNombre(nombre);
                c.setId(cat);
                r.setId_cate(c);
    	        rd.create(r);
    		 
    		break;
    		}
    
    	case 2:
    		{
    	        System.out.println("Digite el id del rubro");
    		id=sc.nextInt();
    		//c.setUser(user);
    		rd.findByID(id).getNombre();
    		break;
    		}
            
 
    	case 3:
    		{
        	        System.out.println("Digite el id del Rubro");
        		id=sc.nextInt();
        		
        		r.setId(id);
        		rd.deleteByID(r);
    			
    		break;
    		}

    	case 4:
    		{
        	    rd.deleteAll();
                   
    			
    		break;
    		}
    	
    
    	case 5:
    		{
                
        	System.out.println("Digite el id del Rubro");
        	id = sc.nextInt();
               
                System.out.println("Digite el nombre del Rubro");
    	        nombre = sc.next();
              
                r.setId(id);
                r.setNombre(nombre);
                c.setId(id);
                r.setId_cate(c);
        	rd.update(r);
    			
    		break;
    		}
            

    	case 6:
    		{
            	ArrayList<Rubros> rbda = rd.findAll();
        
            	for (int x=0;x<rbda.size();x++){
                
                System.out.println(rbda.get(x).getId()+ " "+rbda.get(x).getNombre()+" "+rbda.get(x).getId_cate().getId());
            }
            	
    		break;
    		}
    	default :
    		{
    		System.out.print("No existe la opccion deseada");
    		}
    	}  
    }
    
     public static void Categoria()
    {
    	Scanner sc = new Scanner(System.in);
    	int opc;
    	String nombre;
        int id, cat;
        

    	RubrosDAO rd = new RubrosDAO();
        Rubros r = new Rubros();
        Categoria c=new Categoria();
        CategoriaDAO cd=new CategoriaDAO();

    	System.out.println("Opciones referentes a la tabla Categoria ");
    	System.out.println("1. Crear");
    	System.out.println("2. Encontrar por ID");
    	System.out.println("3. Borrar por ID");
    	System.out.println("4. Borrar todo ");
    	System.out.println("5. Actualizar");
        System.out.println("6. Encontrar todo");
    	System.out.println("Digite su opcion :");
    	
    	opc=sc.nextInt();
    
    	switch(opc)
    	{
  
            
    	case 1:
    		{
              
    	        System.out.println("Digite el nombre");
    	        nombre = sc.next();
                
    	       
    	        c.setNombre(nombre);
                
    	        cd.create(c);
    		 
    		break;
    		}
    	

    	case 2:
    		{
    	        System.out.println("Digite el id de la Categoria");
    		id=sc.nextInt();
    		//c.setUser(user);
    		cd.findByID(id).getNombre();
    		break;
    		}
            

    	case 3:
    		{
        	        System.out.println("Digite el id de la Categoria");
        		id=sc.nextInt();
        		
        		c.setId(id);
        		cd.deleteByID(c);
    			
    		break;
    		}
            

    	case 4:
    		{
        	    cd.deleteAll();
                   
    			
    		break;
    		}
    	

    	case 5:
    		{
                
        	System.out.println("Digite el id de la Categoria");
        	id = sc.nextInt();
               
                System.out.println("Digite el nombre de la Categoria");
    	        nombre = sc.next();
              
                c.setId(id);
                c.setNombre(nombre);
                
        	cd.update(c);
    			
    		break;
    		}
            
    	
    	case 6:
    		{
            	ArrayList<Categoria> rda = cd.findAll();
        
            	for (int x=0;x<rda.size();x++){
                
                System.out.println(rda.get(x).getId()+ " "+rda.get(x).getNombre());
            }
            	
    		break;
    		}
    	default :
    		{
    		System.out.print("No existe la opccion deseada");
    		}
    	}  
    }
     
        public static void Rubro_Dependencia()
    {
    	Scanner sc = new Scanner(System.in);
    	int opc;
    	String nombre;
        int rub, dep, annio;
        Long pres;
       
    	RubrosDAO rd = new RubrosDAO();
        Rubros r = new Rubros();
        Dependencia d=new Dependencia();
        DependenciaDAO dd=new DependenciaDAO();
        Rubro_DependenciaDAO rbdd=new Rubro_DependenciaDAO();
        Rubro_Dependencia rbd=new Rubro_Dependencia();
    	System.out.println("Opciones referentes a la tabla Rubro_Dependencia ");
    	System.out.println("1. Crear");
    	System.out.println("2. Encontrar por ID");
    	System.out.println("3. Borrar por ID");
    	System.out.println("4. Borrar todo ");
    	System.out.println("5. Actualizar");
        System.out.println("6. Encontrar todo");
    	System.out.println("Digite su opcion :");
    	
    	opc=sc.nextInt();
    
    	switch(opc)
    	{
 
            
    	case 1:
    		{
              
    	        System.out.println("Digite el id de la dependencia");
    	        dep = sc.nextInt();
                System.out.println("Digite el id del rubro");
    	        rub = sc.nextInt();
                System.out.println("Digite el annio");
    	        annio = sc.nextInt();
                System.out.println("Digite el presupuesto");
    	        pres = sc.nextLong();
                
    	        d.setId(dep);
                rbd.setId_Dependencia(d);
                r.setId(rub);
                rbd.setId_Rubro(r);
                rbd.setAnnio(annio);
                rbd.setPresupuesto(pres);
    	        rbdd.create(rbd);
                
    	        
    		 
    		break;
    		}
    	

    	case 2:
    		{
    	        System.out.println("Digite el id de la dependencia");
    		dep=sc.nextInt();
                System.out.println("Digite el id del rubro");
    		rub=sc.nextInt();
                System.out.println("Digite el anio");
    		annio=sc.nextInt();
    		//c.setUser(user);
    		rbdd.findByID(dep, rub, annio);
    		break;
    		}
            

    	case 3:
    		{
        	         System.out.println("Digite el id de la dependencia");
    		dep=sc.nextInt();
                System.out.println("Digite el id del rubro");
    		rub=sc.nextInt();
                System.out.println("Digite el año");
    		annio=sc.nextInt();
                
                d.setId(dep);
                rbd.setId_Dependencia(d);
                r.setId(rub);
                rbd.setId_Rubro(r);
                rbd.setAnnio(annio);
                rbdd.deleteByPK(rbd);
    			
    		break;
    		}

    	case 4:
    		{
        	    rbdd.deleteAll();
                   
    			
    		break;
    		}
    	
      
    	case 5:
    		{
                
        	
    	        System.out.println("Digite el id de la dependencia");
    	        dep = sc.nextInt();
                System.out.println("Digite el id del rubro");
    	        rub = sc.nextInt();
                System.out.println("Digite el año");
    	        annio = sc.nextInt();
                System.out.println("Digite el presupuesto");
    	        pres = sc.nextLong();
                
    	        d.setId(dep);
                rbd.setId_Dependencia(d);
                r.setId(rub);
                rbd.setId_Rubro(r);
                rbd.setAnnio(annio);
                rbd.setPresupuesto(pres);
    	        rbdd.update(rbd);
    			
    		break;
    		}
            

    	case 6:
    		{
            	ArrayList<Rubro_Dependencia> rda = rbdd.findAll();
        
            	for (int x=0;x<rda.size();x++){
                
                System.out.println(rda.get(x).getId_Dependencia().getId()+ " "+rda.get(x).getId_Rubro().getId() +" "+ rda.get(x).getAnnio()+" "+rda.get(x).getPresupuesto());
            }
            	
    		break;
    		}
    	default :
    		{
    		System.out.print("No existe la opccion deseada");
    		}
    	}  
    }
}

