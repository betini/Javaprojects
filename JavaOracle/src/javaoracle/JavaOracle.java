package javaoracle;

import java.util.ArrayList;
import java.util.Scanner;
public class JavaOracle {

    public static void main(String[] args) {
    
        
        seccion s = new seccion();
        seccionDAO sd = new seccionDAO();
        localizacionDAO l = new localizacionDAO();
        localizacion l1 = new localizacion();
        
        

        Scanner sc=new Scanner(System.in);
      
                   
        
         System.out.println("Digite su opcion: \n1 deporte \n2 localizacion \n3 complejodeportivo \n4 seccion");
         int opc=sc.nextInt();
         switch(opc)
        {
        case 1:
        	{
        		deporte();
        		break;
        	}
        case 2:
        	{
                        localizacion();
        		break;
        	}
        case 3:
        	{
                    
                        complejo();
                        break;
        	}
        case 4:
        	{
                        seccion(); 
                        break;
        	}
        case 5:
        	{
                         
                        break;
        	}    
        default:
        {
            System.out.println("no es valida la opcion");    
            break;
        }
    
        	
        
        }
        
        
           
       
        

    }
      public static void deporte()
    {
    	Scanner sc = new Scanner(System.in);
    	int opc;
    	String nom;
    	int id;
    	deporteDAO d = new deporteDAO();
        Deporte de = new Deporte();
    	System.out.println("Opciones referentes a la tabla deporte ");
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
    	//crear
    	case 1:
    		{
    			
    	        System.out.println("Digite el nombre del deporte");
    	        nom = sc.next();
    	        
    	        de.setNombre(nom);
    	        d.create(de);
    			
    		break;
    		}
    	//encontrar por ID
    	case 2:
    		{
    		
    	         System.out.println("Digite el id del deporte");
    		id=sc.nextInt();
    		
    		de.setCodigo(id);
    		System.out.println(d.findByID(id));
                
    		break;
    		}
    	//Borrar por ID
    	case 3:
    		{
    			
        	         System.out.println("Digite el id del deporte");
        		id=sc.nextInt();
        		
        		de.setCodigo(id);
        		d.deleteByID(de);
    			
    		break;
    		}
    	//borrar todo
    	case 4:
    		{
    			
    		
        	    d.deleteAll();
                    System.out.println("Se ha eliminado todos los datos de la tabla deporte");
    			
    		break;
    		}
    	//actualizar
    	case 5:
    		{
    		System.out.println("Digite el id del deporte");
        	id = sc.nextInt();
        	System.out.println("Digite el nombre del deporte");
        	nom = sc.next();
                de.setCodigo(id);
        	de.setNombre(nom);       	
        	d.update(de);
    			
    		break;
    		}
    	//encontrar todo
    	case 6:
    		{
    			
            	
            	ArrayList<Deporte> da = d.findAll();
          
            	
            	for (int x=0;x<da.size();x++){
                
                System.out.println(da.get(x).getCodigo()+ " "+da.get(x).getNombre());
            }
            	
    		break;
    		}
    	default :
    		{
    		System.out.print("No existe la opccion deseada");
    		}
    	}  
    }
      
        public static void complejo()
    {
    	Scanner sc = new Scanner(System.in);
    	int opc;
    	String nom;
    	String tipo;
        int area;
        int sede;
        int id;
    	complejoDAO cd = new complejoDAO();
        complejodeportivo cd1 = new complejodeportivo();
    	System.out.println("Opciones referentes a la tabla complejodeportivo");
    	System.out.println("1. Crear");
    	System.out.println("2. Encontrar por ID");
    	System.out.println("3. Borrar por ID");
    	System.out.println("4. Borrar todo");
        System.out.println("5. Actializar informacion");
    	System.out.println("6. Encontrar todo");
    	System.out.println("Digite su opcion :");
    	
    	opc=sc.nextInt();
    
    	switch(opc)
    	{
    	//crear
    	case 1:
    		{
    		
    	        
                System.out.println("Digite el nombre:");
    	        nom = sc.next();
                System.out.println("Digite el tipo:");
                tipo = sc.next();
                System.out.println("Digite el valor del area:");
                area = sc.nextInt();
                System.out.println("Digite el codigo de la sede:");
                sede = sc.nextInt();
    	        
    	        cd1.setNombre(nom);
                cd1.setArea(area);
                cd1.setTipo(tipo);
                cd1.setSede(sede);
    	        cd.create(cd1);
    			
    		break;
    		}
    	//encontrar por ID
    	case 2:
    		{
    		
    	        System.out.println("Digite el codigo del complejo:");
    		id=sc.nextInt();
    		
    		cd1.setCodigo(id);
    		System.out.print(cd.findByID(id));	
    		break;
    		}
    	//Borrar por ID
    	case 3:
    		{
         
    	        System.out.println("Digite el codigo del complejo:");
    		id=sc.nextInt();
    		
    		cd1.setCodigo(id);
        	cd.deleteByID(cd1);
    			
    		break;
    		}
    	//borrar todo
    	case 4:
    		{
    		
        	cd.deleteAll();
    			System.out.println("se ha eliminado los registros");
    		break;
    		}
    	//actualizar
    	case 5:
    		{
    		
        	System.out.println("Digite el codigo: ");
        	id=sc.nextInt();
                 System.out.println("Digite el nombre:");
    	        nom = sc.next();
                System.out.println("Digite el tipo:");
                tipo = sc.next();
                System.out.println("Digite el valor del area:");
                area = sc.nextInt();
                System.out.println("Digite el codigo de la sede:");
                sede = sc.nextInt();
                
                
        	cd1.setCodigo(id);     
                cd1.setNombre(nom);   
                cd1.setTipo(tipo);   
                cd1.setArea(area);   
                cd1.setSede(sede);   
        	cd.update(cd1);
    			
    		break;
    		}
    	//encontrar todo
    	case 6:
    		{
    		
            	ArrayList<complejodeportivo> cd2 = cd.findAll();
            	
            	
            	for (int x=0;x<cd2.size();x++){
                
                System.out.println(cd2.get(x).getCodigo()+ " "+cd2.get(x).getNombre()+ " "+cd2.get(x).getTipo() + " "+  cd2.get(x).getArea() + " "+ cd2.get(x).getSede());
            }
            	
    		break;
    		}
    	default :
    		{
    		System.out.print("No existe la opccion deseada");
    		}
    	}   	
    }
        
         public static void localizacion()
    {
    	Scanner sc = new Scanner(System.in);
    	int opc;
    	String nom;
    	int id;
        String codalf;
    	localizacionDAO l = new localizacionDAO();
        localizacion l1 = new localizacion();
    	System.out.println("Opciones referentes a la tabla localizacion ");
    	System.out.println("1. Crear");
    	System.out.println("2. Encontrar por ID");
    	System.out.println("3. Borrar por ID");
    	System.out.println("4. Borrar todo ");
        System.out.println("5. Actializar informacion");
    	System.out.println("6. Encontrar todo");
    	System.out.println("Digite su opcion :");
    	
    	opc=sc.nextInt();
    
    	switch(opc)
    	{
    	//crear
    	case 1:
    		{
                    
    		System.out.println("Digite el codigo:");
    	        codalf = sc.next();
    	        System.out.println("Digite el nombre:");
    	        nom = sc.next();
         
    	        l1.setNombre(nom);
                l1.setCodalf(codalf);
    	        l.create(l1);
    			
    		break;
    		}
    	//encontrar por ID
    	case 2:
    		{
    		
    	        System.out.println("Digite el codigo:");
    		codalf=sc.next();
    		
    		l1.setCodalf(codalf);
    		System.out.println(l.findByID(codalf));
    			
    		break;
    		}
    	//Borrar por ID
    	case 3:
    		{
  
    	        System.out.println("Digite el codigo:");
    		codalf=sc.next();
    		
    		l1.setCodalf(codalf);
        	l.deleteByID(l1);
    			
    		break;
    		}
    	//borrar todo
    	case 4:
    		{
    
    		
        	l.deleteAll();
    			
    		break;
    		}
    	//actualizar
    	case 5:
    		{

    	        System.out.println("Digite el codigo:");
    	        codalf = sc.next();  
                System.out.println("Digite el nombre:");
                nom = sc.next();
                
                l1.setCodalf(codalf);
                l1.setNombre(nom);
        	l.update(l1);
    			
    		break;
    		}
    	//encontrar todo
    	case 6:
    		{
    
            	
            	ArrayList<localizacion> la = l.findAll();
            	
            	for (int x=0;x<la.size();x++){
                
                System.out.println(la.get(x).getCodalf()  + " "+la.get(x).getNombre());
            }
            	
    		break;
    		}
    	default :
    		{
    		System.out.print("No existe la opccion deseada");
    		}
    	}   	
    }
    
       
    public static void seccion()
    {
    	Scanner sc = new Scanner(System.in);
    	int opc;
    	
        int coddep, codcomp;
        String codalf;

    	seccion s = new seccion();
        seccionDAO sd = new seccionDAO();
        complejoDAO cd = new complejoDAO();
        complejodeportivo cdl = new complejodeportivo();
        localizacionDAO l = new localizacionDAO();
        localizacion l1 = new localizacion();
        deporteDAO d = new deporteDAO();
        Deporte de = new Deporte();
    	System.out.println("Opciones referentes a la tabla seccion ");
    	System.out.println("1. Crear");
    	System.out.println("2. Encontrar por ID");
    	System.out.println("3. Borrar por ID");
    	System.out.println("4. Borrar todo ");
        System.out.println("5. Actializar informacion");
    	System.out.println("6. Encontrar todo");
    	System.out.println("Digite su opcion :");
    	
    	opc=sc.nextInt();
    
    	switch(opc)
    	{
    	//crear
    	case 1:
    		{
                    
                     System.out.println("digite el codigo del complejo deportivo");
                     codcomp=sc.nextInt();
                     
                     System.out.println("digite el codigo del deporte");
                     coddep=sc.nextInt();
                     
                     System.out.println("digite el codigo de la localizacion");
                     codalf=sc.next();
                     
                     cdl.setCodigo(codcomp);
                     s.setIdComplejo(cdl);
                     l1.setCodalf(codalf);
                     s.setIdLocalizacion(l1);
                     de.setCodigo(coddep);
                     s.setIdDeporte(de);
                     sd.create(s);
    	        
    	        
    			
    		break;
    		}
    	//encontrar por ID
    	case 2:
    		{
                    
                  System.out.println("digite el codigo del complejo deportivo");
                  codcomp=sc.nextInt();
                  
    		  System.out.println("digite el codigo del deporte");
                  coddep=sc.nextInt();
                     
                  
                System.out.println(sd.findByID(coddep, codcomp));
    			
    		break;
    		}
    	//Borrar por ID
    	case 3:
    		{
    			System.out.println("digite el codigo del complejo deportivo");
                  codcomp=sc.nextInt();
        	        
        		System.out.println("digite el codigo del deporte");
                  coddep=sc.nextInt();
                     
        		
                        de.setCodigo(coddep);
                        cdl.setCodigo(codcomp);
        		s.setIdComplejo(cdl);
                        s.setIdDeporte(de);
        		sd.deleteByID(s);
    			
    		break;
    		}
    	//borrar todo
    	case 4:
    		{
        	    sd.deleteAll();
    			
    		break;
    		}
    	//actualizar
    	case 5:
    		{
                     System.out.println("digite el codigo del complejo deportivo");
                     codcomp=sc.nextInt();
                     
        	     System.out.println("digite el codigo del deporte");
                     coddep=sc.nextInt();
                     
                     System.out.println("digite el codigo de la localizacion");
                     codalf=sc.next();
                     
                     
                     de.setCodigo(coddep);
                     s.setIdDeporte(de); 
                     l1.setCodalf(codalf);
                     s.setIdLocalizacion(l1); 
        	     cdl.setCodigo(codcomp);
                     s.setIdComplejo(cdl);
                     
                                             	
                     sd.update(s);
    			
    		break;
    		}
    	//encontrar todo
    	case 6:
    		{
    		
              
            	
             ArrayList<seccion> secc= sd.findAll();
        

        for(int x=0;x<secc.size();x++){
            System.out.println(secc.get(x).getDeporte().getCodigo()+" "+secc.get(x).getIdComplejo().getCodigo() +" "+secc.get(x).getIdLocalizacion().getCodalf());
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