package integrador;

import integrador.CuentaDAO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class INTEGRADOR {

    public static void main(String[] args) {
        
        /**Creamos los menus por medio de un switch case para escoger la tabla que vamos a utilizar y para escogerle
           *
           *la opcion con la cual vamos a trabajar sobre essa tabla
        */
        
        String opc2;
         do
        {
         Scanner sc=new Scanner(System.in);
         System.out.println("Digite su opcion: \n1 Cuenta \n2 Empresa \n3 Egresado \n4 Info_laboral \n5 Oferta \n6 Institucion \n7 Estudios \n8 Estudios_Egresado \n9 Oferta_Egresado \n10 Roles \n11 Cuenta_Roles");
         System.out.print("Ingrese su Opcion: ");
         int opc=sc.nextInt();
         
        switch(opc)
        {
        case 1:
        	{
        		Cuenta();
        		break;
        	}
        case 2:
        	{
                        Empresa();
        		break;
        	}
        case 3:
        	{
                        Egresado();
                        break;
        	}
        case 4:
        	{
                        Info_laboral(); 
                        break;
        	}
        case 5:
        	{
                        Oferta(); 
                        break;
        	}
        case 6:
        	{
                        Institucion(); 
                        break;
        	}
        case 7:
        	{
                        Estudios(); 
                        break;
        	}
        case 8:
        	{
                        Estudios_Egresado(); 
                        break;
        	}    
        case 9:
        	{
                        Oferta_Egresado(); 
                        break;
        	}
        case 10:
                {
                        Roles();
                        break;
                }
        case 11:
                {
                        Cuenta_Roles();
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
    
    /** aqui escogemos la opcion que vamos a utilizar para la tabla cuenta*/
    
    public static void Cuenta()
    {
    	Scanner sc = new Scanner(System.in);
    	int opc;
    	String user, pass;
        int tipo;
        
        /**hacemos la instancia de las tablas cuenta y  cuentaDAO*/
    	CuentaDAO cd = new CuentaDAO();
        Cuenta c = new Cuenta();

    	System.out.println("Opciones referentes a la tabla Cuenta ");
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
    	/**Este case se encarga de insertar los datos en la tabla cuenta 
             *  Digitamos el tipo de usuario 1 para egresado, 2 para empresa
             *  digitamos el nombre del Usuario
             *  digitamos su clave
             *  por medio de la instancia de cuenta hacemos uso de sus metodos
             */
            
    	case 1:
    		{
              
    	        System.out.println("Digite el nombre del usuario");
    	        user = sc.next();
               
                System.out.println("Digite el password del usuario");
    	        pass = sc.next();
    	       
    	        c.setUser(user);
                c.setPassword(pass);
    	        cd.create(c);
    		 
    		break;
    		}
    	
        /** Este case se emcarga de encontrar al Usuario por su ID
             * digitamos el id de la cuenta
             * por medio de la instancia de cuenta hacemos uso de sus metodos
             */
    	case 2:
    		{
    	        System.out.println("Digite el User de la Cuenta");
    		user=sc.next();
    		//c.setUser(user);
    		cd.findByID(user).getUser();
    		break;
    		}
            
    	/**Este case se encarga Borrar por ID de Usuario
             * digitamos el id de la cuenta
             * por medio de la instancia de cuenta hacemos uso de sus metodos
             */
    	case 3:
    		{
        	        System.out.println("Digite el usuario de la Cuenta");
        		user=sc.next();
        		
        		c.setUser(user);
        		cd.deleteByID(c);
    			
    		break;
    		}
            
    	/**Este case se encarga de borrar todos los datos de la tabla
             * por medio de la instancia de cuentaDAO podemos utilizar sus metodos 
             */
    	case 4:
    		{
        	    cd.deleteAll();
                    System.out.println("Se ha eliminado todos los datos de la tabla Cuenta");
    			
    		break;
    		}
    	
             /** Este case se encarga de actualizar un dato de la tabla cuya ID sea igual a la 
                * ingresada por el usuario
                * digitamos el id de la cuenta
                * digitamos el nombre de la cuenta
                * digitamos la clave del usuario
                * por medio de la instancia de cuenta y cuentaDAO utilizamos sus metodos
                */        
    	case 5:
    		{
                
        	System.out.println("Digite el nombre de la Cuenta");
        	user = sc.next();
               
                System.out.println("Digite el password del usuario");
    	        pass = sc.next();
              
                c.setUser(user);
                c.setPassword(pass);
        	cd.update(c);
    			
    		break;
    		}
            
    	/**Este case se encarga de traer todos los datos que existen en la tabla Cuenta
             * por medio del arraylist de cuenta guardamos todas las funciones y procedimientos
             */
    	case 6:
    		{
            	ArrayList<Cuenta> ca = cd.findAll();
        
            	for (int x=0;x<ca.size();x++){
                
                System.out.println(ca.get(x).getUser()+ " "+ca.get(x).getPassword());
            }
            	
    		break;
    		}
    	default :
    		{
    		System.out.print("No existe la opccion deseada");
    		}
    	}  
    }
       /** aqui escogemos la opcion que vamos a utilizar para la tabla empresa
         * hacemos la instancia de la tabla empresaDAO
       */
    
        public static void Empresa()
    {
    	Scanner sc = new Scanner(System.in);
    	int opc, tel, id;
       Long cel;
    	String nom, dir, con, user;
        
    	EmpresaDAO ed = new EmpresaDAO();
        Empresa e = new Empresa();
    	System.out.println("Opciones referentes a la tabla Empresa");
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
    	/**Este case permite crear una empresa
             * digitamos el nombre de la empresa
             * digitamos la direccion de la empresa
             * digitamos el numero de celular de la empresa
             * digitamos el numero fijo de la empresa
             * digitamos el id de la cuenta
             * digitamos el nombre del contacto de la empresa
             * por medio de las instancias de las tablas empresa y empresaDAO accedemos a sus metodos
        */
    	
            case 1:
    		{
    		Cuenta c = new Cuenta();
                System.out.println("Digite el nombre de la empresa:");
    	        nom = sc.next();
                System.out.println("Digite la direccion de la empresa:");
    	        dir = sc.next();
               
                System.out.println("Digite el numero celular de la empresa:");
    	        cel = sc.nextLong();
                
                System.out.println("Digite el numero telefono de la empresa:");
    	        tel = sc.nextInt();
                
                System.out.println("Digite la id de la cuenta:");
    	        user = sc.next();
                
                System.out.println("Digite el nombre de contacto de la empresa:");
    	        con = sc.next();
                
                e.setNombre(nom);
                e.setDireccion(dir);
                e.setCelular(cel);
                e.setTelefono(tel);
                c.setUser(user);
                e.setUser_Cuenta(c);
                e.setContacto(con);
                ed.create(e);
    			
    		break;
    		}
    	/**encontrar por ID
            * 
            *  digitamos el codigo de la empresa
            *  por medio de la instancia de empresaDAO utilizamos esta funcion
        */
                
    	case 2:
    		{
                       
                    
    	        System.out.println("Digite el codigo de la empresa:");
    		id=sc.nextInt();
    		ed.findByID(id).getCodnum();
    		
                
    		break;
    		}
            
    	/**Borrar por ID
             * digitamos el codigo de la empresa
             * por medio de las instancias de las tablas empresa y empresaDAO utilizamos los metodos y este procedimiento
             */
            
    	case 3:
    		{
                
    	        System.out.println("Digite el codigo de la empresa:");
    		id=sc.nextInt();
    		
    		e.setCodnum(id);
        	ed.deleteByID(e);
    			
    		break;
    		}
    	
        /**borrar todo
             * 
             * por medio de la instancia de la tabla empresaDAO utilizamos 
             * este procedimiento nos permite borrar todo
             */
           
    	case 4:
    		{
        	ed.deleteAll();
    		System.out.println("se ha eliminado todos los registros");
    		break;
    		}
    	/**actualizar
             * digitamos el nomnbre de la empresa
             * digitamos la direccion de la empresa
             * digitamos el numero de celular de la empresa
             * digitamos el numero fijo de la empresa
             * digitamos el id de la cuenta
             * digitamos el nombre de contacto de la empresa
             * por medio de la instancia de la tabla empresa accedemos a sus metodos
             */
            
    	case 5:
    		{
    		Cuenta c = new Cuenta();
              System.out.println("Digite la user de la cuenta:");
    	        user = sc.next();
                
                System.out.println("Digite el id de la cuenta:");
    	        id = sc.nextInt();
                
        	System.out.println("Digite el nombre de la empresa:");
    	        nom = sc.next();
                
                System.out.println("Digite la direccion de la empresa:");
    	        dir = sc.next();
               
                System.out.println("Digite el numero celular de la empresa:");
    	        cel = sc.nextLong();
               
                System.out.println("Digite el numero telefono de la empresa:");
    	        tel = sc.nextInt();
                
                
                
                System.out.println("Digite el nombre de contacto de la empresa:");
    	        con = sc.next();
               
                c.setUser(user);
                e.setUser_Cuenta(c);
                e.setCodnum(id);
                e.setNombre(nom);
                e.setDireccion(dir);
                e.setCelular(cel);
                e.setTelefono(tel);
                e.setContacto(con);
                ed.update(e);
    			
    		break;
    		}
    	/**encontrar todo
          *por medio del arraylist de empresa guardamos todas las funciones y procedimientos 
        */
            
    	case 6:
    		{
    		
            	ArrayList<Empresa> cd2 = ed.findAll();
            	for (int x=0;x<cd2.size();x++){
                System.out.println(cd2.get(x).getCodnum()+ " "+cd2.get(x).getNombre()+ " "+cd2.get(x).getDireccion() + " "+  cd2.get(x).getCelular() + " "+ cd2.get(x).getTelefono() + " "+cd2.get(x).getUser_Cuenta().getUser()+ " "+cd2.get(x).getContacto());
                }
            	
    		break;
    		}
    	default :
    		{
    		System.out.print("No existe la opccion deseada");
    		}
    	}   	
    }
        
         /**aqui escogemos la opcion que vamos a utilizar para la tabla egresado
         * creamos la instancia de las tabla egresadoDAO
         */
         public static void Egresado()
        {
    	Scanner sc = new Scanner(System.in);
    	int opc;
    	String nom, ape, cor, user;
    	int  tel, id;
        Long cel,cod;
        
       
    	EgresadoDAO ed = new EgresadoDAO();
        Egresado e = new Egresado();
    	System.out.println("Opciones referentes a la tabla Egresado ");
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
    	/**crear
             * digitamos el codigo
             * digitamos el nombre
             * digitamos el apellido
             * digitamos el correo electronico
             * digitamos el numero de celular
             * digitamos el id de la cuenta
             * digitamos el numero de telefono
             * por medio de la instancia de las tablas cuenta, egresado y egresadoDAO
             * accedemos a sus metodos a a este procedimiento
             */
            
    	case 1:
    		{
                Cuenta cu= new Cuenta();
            
    		System.out.println("Digite el codigo:");
    	        cod = sc.nextLong();
              
    	        System.out.println("Digite el nombre:");
    	        nom = sc.next();
                
                System.out.println("Digite el Apellido:");
    	        ape = sc.next();
              
                System.out.println("Digite el Correo:");
    	        cor = sc.next();
                System.out.println("Digite el Celular:");
    	        cel = sc.nextLong();
              
                System.out.println("Digite el id de cuenta:");
    	        user = sc.next();
              
                System.out.println("Digite el telefono:");
    	        tel = sc.nextInt();
                e.setId(cod);
    	        e.setNombre(nom);
                e.setApellido(ape);
                e.setCorreo(cor);
                e.setCelular(cel);
                cu.setUser(user);
                e.setUser_Cuenta(cu);
                e.setTelefono(tel);
    	        ed.create(e);	
    		break;
    		}
            
    	/**encontrar por ID
          *digitamos el codigo
          *por medio de k¡la instancia de las tablas egresado y egresadoDAO accedemos
          *a esta funcion y a sus metodos
        */
    	case 2:
    		{
                   
    	        System.out.println("Digite el codigo:");
    		cod=sc.nextLong();
                ed.findByID(cod).getId();
                
                    			
    		break;
    		}
            
    	/**Borrar por ID
          *digitamos el codigo
          *Por medio de k¡la instancia de las tablas egresado y egresadoDAO accedemos
          *a a sus metodos y a  este procedimiento  
        */
    	case 3:
    		{
                  
    	        System.out.println("Digite el codigo:");
    		cod=sc.nextLong();
    		
    		e.setId(cod);
        	ed.deleteByID(e);
    			
    		break;
    		}
    	
        /**borrar todo*/
    	
        case 4:
    		{
        	ed.deleteAll();	
    		break;
    		}
            
    	/**actualizar
             * hacemos instnacia de cuenta
             * digitamos el codigo
             * digitamos el nombre
             * digitamos el apellido
             * digitamos el correo electronico
             * digitamos el numero de celular
             * digitamos el id de la cuenta
             * digitamos el numer telefonico
             * por medio de la instancia de egresado y cuenta podemos acceder
             * a sus metodos, y por medio de la instancia de egresadoDAO accedemos a este metodo
             */
            
    	case 5:
    		{
               
    	        Cuenta cu= new Cuenta();
                System.out.println("Digite el user de la cuenta:");
    	        user = sc.next();
                
    		System.out.println("Digite el codigo:");
    	        cod = sc.nextLong();
                
    	        System.out.println("Digite el nombre:");
    	        nom = sc.next();
                
                System.out.println("Digite el Apellido:");
    	        ape = sc.next();
                
                System.out.println("Digite el Correo:");
    	        cor = sc.next();
                
                System.out.println("Digite el Celular:");
    	        cel = sc.nextLong();
              
                System.out.println("Digite el telefono:");
    	        tel = sc.nextInt();
               
                cu.setUser(user);
                e.setUser_Cuenta(cu);
                e.setId(cod);
    	        e.setNombre(nom);
                e.setApellido(ape);
                e.setCorreo(cor);
                e.setCelular(cel);
                e.setTelefono(tel);
    	        ed.create(e);
    			
    		break;
    		}
            
    	/**encontrar todo
          *por medio del arraylist de egresado guardamos todas las funciones y procedimientos 
        */
    	case 6:
    		{
    
            	
            	ArrayList<Egresado> la = ed.findAll();
            	for (int x=0;x<la.size();x++){
                System.out.println(la.get(x).getId()+ " "+la.get(x).getNombre() + " "+la.get(x).getApellido() + " "+la.get(x).getCorreo() + " "+la.get(x).getCelular() + " "+la.get(x).getUser_Cuenta().getUser() + " "+la.get(x).getTelefono());
            }
            	
    		break;
    		}
    	default :
    		{
    		System.out.print("No existe la opccion deseada");
    		}
    	}   	
    }
    
      /**aqui escogemos la opcion que vamos a utilizar para la tabla info_laboral
        *
        * hacemos las respectivas instancias de las tablas egresado,info_laboral e info_laboralDAO
        * 
      */
         
    public static void Info_laboral()
    {
    	Scanner sc = new Scanner(System.in);
    	int opc;
    	Long ide;
        int id;
        Date feci = null, fecf = null;
        String jef, car, fun, mot, per, fi, ff;
       
        Egresado eg = new Egresado();
        Info_laboral il = new Info_laboral();
        Info_laboralDAO ild = new Info_laboralDAO();
        
    	System.out.println("Opciones referentes a la tabla Info_laboral ");
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
            
    	/*crear
             * 
             * digitamos el nombre del jefe
             * digitamos el cargo
             * digitamos la funcion a desempeñar
             * digitamos la fecha de inicio
             * digitamos la fecha de finalizacion
             * digitamos el motivo de retiro
             * digite el id del egresado
             * digite el perfil
             * por medio de las instancias de las tablas informacion 
             * laboral y egresado accedemos a sus metodos y por
             * medio de informacionlaboralDAO  accedemos a este procedimiento
             */
            
    	case 1:
    		{
               
                System.out.println("Digite el Jefe:");
    	        jef = sc.next();
                
                System.out.println("Digite el Cargo:");
    	        car = sc.next();
              
                System.out.println("Digite el Funcion:");
    	        fun = sc.next();
              
                System.out.println("Digite el Fecha inicio:");
                fi=sc.next();
                  DateFormat df = DateFormat.getDateInstance();
            try {
                
                java.util.Date d = df.parse(fi);
                java.sql.Date da = new java.sql.Date(d.getTime());
                   feci = da;
            } catch (ParseException ex) {
                Logger.getLogger(INTEGRADOR.class.getName()).log(Level.SEVERE, null, ex);
            }
    	     
               
                System.out.println("Digite el Fecha fin:");
                       ff=sc.next();
            try {
                java.util.Date d = df.parse(ff);
                java.sql.Date da = new java.sql.Date(d.getTime());
                   fecf = da;
            } catch (ParseException ex) {
                Logger.getLogger(INTEGRADOR.class.getName()).log(Level.SEVERE, null, ex);
            }
    	        
                
                System.out.println("Digite el motivo de retiro:");
    	        mot = sc.next();
               
                System.out.println("Digite el id de egresado:");
    	        ide = sc.nextLong();
                System.out.println("Digite el perfil:");
    	        per = sc.next();
    	       
    	        il.setJefe(jef);
                il.setCargo(car);
                il.setFuncion(fun);
                il.setFecha_ini(feci);
                il.setFecha_fin(fecf);
                il.setMotivo_retiro(mot);
                eg.setId(ide);
                il.setId_egresado(eg);
                il.setPerfil(per);
    	        ild.create(il);
    	        
    		break;
    		}
    	/**encontrar por ID
          * digitamos el id de info_laboral
          * utilizamos la instancia de info_laboralDAO para utilizar esta funcion
        */
            
    	case 2:
    		{
                   
    		  System.out.println("digite el id de la Info_laboral");
                  id=sc.nextInt();
                  ild.findByID(id).getId();
    			
    		break;
    		}
    	
        /**Borrar por ID
          * digitamos el id de info_laboral
          * de ifo_laboralDAO utilizamos este procedimiento para borrar
          * por medio de la instancia de info_laboral accedemos a sus metodos y por medio
        */
            
    	case 3:
    		{
        	System.out.println("digite el codigo de la Info_laboral");
                id=sc.nextInt();

                il.setId(id);
                ild.deleteByID(il);
    			
    		break;
    		}
            
    	/**borrar todo
          *utilizamos la instancia de info_laboralDAO para utilizar este procedimiento y borrar todo
        */
            
    	case 4:
        {
        	    ild.deleteAll();
    			
    		break;
    		}
    	
        /**actualizar
             * digite el nombre del jefe
             * digite el cargo a desempeñar
             * digite la funcion a realizar
             * digite la fecha de inicio
             * digite la fecha a finalizar
             * digite el motivo de retiro
             * digite el id del egresado
             * digite el perfil
             * por medio de la instancia de info_laboral y egresado accedemnos a
             * los metodos y por medio de la instancia de info_laboralDAO accedemos a este
             * procedimeinto
             */
            
    	case 5:
    		{
                 System.out.println("Digite el ID:");
    	        id = sc.nextInt();
                    
                    
        	System.out.println("Digite el Jefe:");
    	        jef = sc.next();
                
                System.out.println("Digite el Cargo:");
    	        car = sc.next();
                
                System.out.println("Digite el Funcion:");
    	        fun = sc.next();
                
                System.out.println("Digite el Fecha inicio:");
                  DateFormat df = DateFormat.getDateInstance();
                  fi=sc.next();
            try {
                java.util.Date d = df.parse(fi);
                java.sql.Date da = new java.sql.Date(d.getTime());
                   feci = da;
            } catch (ParseException ex) {
                Logger.getLogger(INTEGRADOR.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                System.out.println("Digite el Fecha fin:");
                  ff=sc.next();
            try {
                java.util.Date d = df.parse(ff);
                java.sql.Date da = new java.sql.Date(d.getTime());
                   fecf = da;
            } catch (ParseException ex) {
                Logger.getLogger(INTEGRADOR.class.getName()).log(Level.SEVERE, null, ex);
            }
               
                System.out.println("Digite el motivo de retiro:");
    	        mot = sc.next();
                
                System.out.println("Digite el id de egresado:");
    	        ide = sc.nextLong();
                
                System.out.println("Digite el perfil:");
    	        per = sc.next();
    	               
    	        il.setId(id);
                il.setJefe(jef);
                il.setCargo(car);
                il.setFuncion(fun);
                il.setFecha_ini(feci);
                il.setFecha_fin(fecf);
                il.setMotivo_retiro(mot);
                eg.setId(ide);
                il.setId_egresado(eg);
                il.setPerfil(per);
    	        ild.update(il);
    			
    		break;
    		}
    	/**encontrar todo  
          * 
          * por medio del arraylist de info_laboral guardamos todas las funciones y procedimientos
        */
            
    	case 6:
    		{
                ArrayList<Info_laboral> sec= ild.findAll();
                
                for(int x=0;x<sec.size();x++){
                    
                System.out.println(sec.get(x).getId() + " "+sec.get(x).getJefe() + " "+sec.get(x).getCargo() + " "+sec.get(x).getFuncion() + " "+sec.get(x).getFecha_ini() + " "+sec.get(x).getFecha_fin() + " "+sec.get(x).getMotivo_retiro() + " "+sec.get(x).getId_egresado().getId() + " "+sec.get(x).getPerfil()); 
                       
                }
    		break;
    		}
            
                default :
    		{
    		System.out.print("No existe la opccion deseada");
    		}
    	}   	
    }
    
    
    /*aqui escogemos la opcion que vamos a utilizar para la tabla oferta
     * 
     * hacemos las respectivas instancias de empresa, oferta y ofertaDAO
     * 
     */
     public static void Oferta()
    {
    	Scanner sc = new Scanner(System.in);
    	int opc;
    	Long sue;
        
        int id, cod;
        Date feca = null, fecc = null;
        String car, fun, req, est, fi, ff;
 
        Empresa em = new Empresa();
        Oferta il = new Oferta();
        OfertaDAO old = new OfertaDAO();
        
    	System.out.println("Opciones referentes a la tabla Oferta ");
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
            
    	/**crear
             * 
             * digitamos el id de la oferta
             * digitamos el cargo a desempeñar
             * digitamos las funciones
             * digitamos los requisitos
             * digitamos nel sueldo a ganar
             * digitamos el estado
             * digitamos la fecha de apertura
             * digitamos la fecha de caducidad
             * digitamos el id de la empresa
             * Por medio de la instancia de oferta y empresa
             * accedemos a sus respectivos metodos y por medio de ofertaDAO
             * accedemos a este procedimeinto
             */
            
    	case 1:
    		{
                  
                
                System.out.println("Digite el  Cargo:");
    	        car = sc.next();
                
                System.out.println("Digite la Funciones:");
    	        fun = sc.next();
                
                System.out.println("Digite los requisitos:");
    	        req = sc.next();
              
                System.out.println("Digite el Sueldo:");
    	        sue = sc.nextLong();
               
                System.out.println("Digite el Estado:");
    	        est = sc.next();
                
                System.out.println("Digite la Fecha Apertura:");
                fi=sc.next();
                  DateFormat df = DateFormat.getDateInstance();
            try {
                java.util.Date d = df.parse(fi);
                java.sql.Date da = new java.sql.Date(d.getTime());
                   feca = da;
            } catch (ParseException ex) {
                Logger.getLogger(INTEGRADOR.class.getName()).log(Level.SEVERE, null, ex);
            }
               
                System.out.println("Digite la Fecha caducidad:");
    	        ff=sc.next();       
            try {
                java.util.Date d = df.parse(ff);
                java.sql.Date da = new java.sql.Date(d.getTime());
                   fecc = da;
            } catch (ParseException ex) {
                Logger.getLogger(INTEGRADOR.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                
                System.out.println("Digite el id de la empresa:");
    	        cod = sc.nextInt();
                
                il.setCargo(car);
                il.setFunciones(fun);
                il.setRequisitos(req);
                il.setSueldo(sue);
                il.setEstado(est);
                il.setFecha_apertura(feca);
                il.setFecha_caducidad(fecc);
                em.setCodnum(cod);
                il.setEmpresa(em);
    	        old.create(il);
    	        
    		break;
    		}
    	/**encontrar por ID
             * 
             * digitamos el id de la oferta
             * utilizamos la instancia de ofertaDAO para utilizar esta funcion
             * 
             */
            
    	case 2:
    		{
                   
    		System.out.println("digite el id de la Oferta");
                cod=sc.nextInt();

                old.findByID(cod);
    		break;
    		}
            
    	/**Borrar por ID
          * digitamos el codigo de la oferta
          * utilizamos la instancia de oferta para acceder a sus metodos y
          * usamos la instancia de ofertaDAO para acceder a este procedimiento
        */
            
    	case 3:
    		{    
                  System.out.println("digite el codigo de la Oferta");
                  cod=sc.nextInt();

                  il.setId(cod);
                  old.deleteByID(il);
                  break;
    		}
    	
            /**borrar todo*/
    	case 4:
    		{
        	old.deleteAll();	
    		break;
    		}
            
    	/*actualizar
                 * digitamos el id de la oferta
                 * digitamos el cargo
                 * digitamos las funciones
                 * digitamos los requisitos
                 * digitamos el sueldo a ganar
                 * digitamos el estado  
                 * digitamos la fecha de apertura
                 * digite la fecha de caducidad
                 * digite el id de la empresa
                 * utilizamos las instancias de oferta y empresa para acceder a
                 * sus metodos  y por medio de la instancia de ofertaDAO 
                 * accedemos a este procedimiento
                 * 
                 */
    	case 5:
    		{
                System.out.println("Digite el id de Oferta:");
    	        id = sc.nextInt();
                    
        	System.out.println("Digite el  Cargo:");
    	        car = sc.next();
                
                System.out.println("Digite la Funciones:");
    	        fun = sc.next();
                
                System.out.println("Digite los requisitos:");
    	        req = sc.next();
              
                System.out.println("Digite el Sueldo:");
    	        sue = sc.nextLong();
               
                System.out.println("Digite el Estado ac (activo) o in (inactivo): ");
    	        est = sc.next();
                
                System.out.println("Digite la Fecha Apertura:");
                fi=sc.next();
                  DateFormat df = DateFormat.getDateInstance();
            try {
                java.util.Date d = df.parse(fi);
                java.sql.Date da = new java.sql.Date(d.getTime());
                   feca = da;
            } catch (ParseException ex) {
                Logger.getLogger(INTEGRADOR.class.getName()).log(Level.SEVERE, null, ex);
            }
               
                System.out.println("Digite la Fecha caducidad:");
    	        ff=sc.next();       
            try {
                java.util.Date d = df.parse(ff);
                java.sql.Date da = new java.sql.Date(d.getTime());
                   fecc = da;
            } catch (ParseException ex) {
                Logger.getLogger(INTEGRADOR.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                
                System.out.println("Digite el id de la empresa:");
    	        cod = sc.nextInt();
                il.setId(id);
                il.setCargo(car);
                il.setFunciones(fun);
                il.setRequisitos(req);
                il.setSueldo(sue);
                il.setEstado(est);
                il.setFecha_apertura(feca);
                il.setFecha_caducidad(fecc);
                em.setCodnum(cod);
                il.setEmpresa(em);
    	        old.update(il);
    		break;
    		}
        
    	/*encontrar todo
          * 
          * por medio del arraylist de oferta guardamos todas las funciones y procedimientos
          * 
        */
            
    	case 6:
            {
            ArrayList<Oferta> sec= old.findAll();
            for(int x=0;x<sec.size();x++){
            System.out.println(sec.get(x).getId() + " "+sec.get(x).getCargo() + " "+sec.get(x).getFunciones() + " "+sec.get(x).getRequisitos() + " "+sec.get(x).getSueldo() + " "+sec.get(x).getEstado() + " "+sec.get(x).getFecha_apertura() + " "+sec.get(x).getFecha_caducidad() + " "+sec.get(x).getEmpresa().getCodnum());
             }
                
    		break;
    		}
            
        default :
    		{
    		System.out.print("No existe la opccion deseada");
    		}
    	}   	
    }
    /*aqui escogemos la opcion que vamos a utilizar para la tabla institucion
      * 
      * hacemos las respectivas instancias de las tablas egresado, institucion e institucionDAO
      */
    public static void Institucion()
    {
    	Scanner sc = new Scanner(System.in);
    	int opc;
    	
        int id, cod;
        String nom;
        
        Egresado eg = new Egresado();
        Institucion il = new Institucion();
        InstitucionDAO ild = new InstitucionDAO();
        
    	System.out.println("Opciones referentes a la tabla Institucion ");
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
    	/**crear
             * 
             * digitamos id de la institucion
             * digitamos nombre de la institucion
             * por medio de la instancia de la tabla institucion
             * hacemos el llamado a sus metodos y por medio de la instancia
             * de la clase institucionDAO usamos este procedimiento
             */
    	case 1:
    		{
                 
                System.out.println("Digite el id de la Institucion:");
    	        cod = sc.nextInt();
             
                System.out.println("Digite el nombre Institucion:");
    	        nom = sc.next();
    	            
    	        il.setId(cod);
                il.setNombre(nom);
    	        ild.create(il);
    	        
    		break;
    		}
    	/**encontrar por ID
             * digitamos el id de la institucion
             * por medio de la instancia de institucionDAO podemos acceder a esta funcion
             */
    	
        case 2:
    		{
    		System.out.println("digite el id de la Institucion");
                cod=sc.nextInt(); 
                ild.findByID(cod).getId();
    		break;
    		}
    	
        /**Borrar por ID
             * digite el id de la institucion
             * por medio de la instancia de institucionDAO podemos acceder a este procedimiento para borrar
             * y por medio de la instancia de institucion accedemos a sus metodos
             */
            
    	case 3:
    		{
                  System.out.println("digite el codigo de la Institucion");
                  cod=sc.nextInt();

                  il.setId(cod);
                  ild.deleteByID(il);	
    		break;
    		}
            
    	/**borrar todo
             * por medio de la instancia de institucionDAO podemos acceder a este procedimiento para
             * borrar todo
             */
    	case 4:
    		{
        	ild.deleteAll();
    		break;
    		}
            
    	/**actualizar
             * digite el id de la institucion
             * digite el nombre de la institucion
             * por medio de la instancia de institucionDAO podemos acceder a este procedimiento para 
             * actualizar y por medio de la instancia de institucion podemos acceder a sus metodos
             * 
             */
            
    	case 5:
    		{
        	System.out.println("Digite el id de la Institucion:");
    	        cod = sc.nextInt();
               
                System.out.println("Digite el nombre Institucion:");
    	        nom = sc.next();
    	       
    	        il.setId(cod);
                il.setNombre(nom);
    	        ild.update(il);
    			
    		break;
    		}
    	
        /**encontrar todo
          * por medio del arraylist de institucion guardamos todas las funciones y procedimientos
          * 
        */
    	case 6:
    	     {
             ArrayList<Institucion> sec= ild.findAll();
             for(int x=0;x<sec.size();x++){
             System.out.println(sec.get(x).getId() + " "+sec.get(x).getNombre());
             }
    		break;
    		}
            
        default :
    		{
    		System.out.print("No existe la opccion deseada");
    		}
    	}   	
    } 
      /*aqui escogemos la opcion que vamos a utilizar para la tabla estudios
     * 
     * hacemos las respectivas instancias de las tablas institucion, estudio y estudiosDAO
     * 
     */
      public static void Estudios()
    {
    	Scanner sc = new Scanner(System.in);
    	int opc;
    	
        int id, cod;
        String niv;
      
        Institucion I = new Institucion();
        Estudios il = new Estudios();
        EstudiosDAO ild = new EstudiosDAO();
        
    	System.out.println("Opciones referentes a la tabla Oferta_Egresado ");
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
    	/**crear
             * 
             * digite el id de estudios
             * digite el id de institucion
             * digite el nivel
             * por medio de la instancia de estudios podemos acceder a sus metodos, y por
             * medio de la instancia de estudiosDAO accedemos a este procedimiento
             */
    	case 1:
    		{
                System.out.println("Digite el id de la institucion:");
    	        cod = sc.nextInt();

                System.out.println("Digite el Nivel:");
    	        niv = sc.next();
 
    	    
                I.setId(cod);
                il.setId_Institucion(I);
                il.setNivel(niv);
    	        ild.create(il);
    	        
    		break;
    		}
    	/**encontrar por ID
             * digite el id de estudios
             * por medio de la instancia de estudiosDAO hacemos el llamado de esta funcion
             */
    	case 2:
    		{
    		 System.out.println("digite el id de la Estudios");
                cod=sc.nextInt();

                ild.findByID(cod);
    			
    		break;
    		}
    	/**Borrar por ID
             * digite el id de estudios
             * por medio de la instancia de estudiosDAO hacemos el llamado de este
             * procedimiento para borrar por id , y utilizando la instancia de estudios
             * accedemos a sus metodos
             */
    	case 3:
    		{
                  System.out.println("digite el codigo de la Estudios");
                  cod=sc.nextInt();

                  il.setId(cod);
                  ild.deleteByID(il);
    			
    		break;
    		}
    	/**borrar todo
             * por medio de la instancia de estudiosDAO hacemos el llamado de este
             * procedimiento para borrar todo
        */
    	case 4:
    		{
        	ild.deleteAll();
    			
    		break;
    		}
    	/*actualizar
                 * digite el id de estudios
                 * digite el id de institucion
                 * digite el nivel
                 * por medio de la instancia de estudios podemos acceder a sus metodos, y por
                 * medio de la instancia de estudiosDAO accedemos a este procedimiento para actualizar
                 */
    	case 5:
    		{
                 
        	System.out.println("Digite el id del Estudios:");
    	        id = sc.nextInt();

                System.out.println("Digite el Nivel:");
    	        niv = sc.next();
    	               
    	        il.setId(id);
                il.setNivel(niv);
    	        ild.update(il);
    			
    		break;
    		}
    	/**encontrar todo
             * por medio del arraylist de estudios guardamos todas las funciones y procedimientos
        */
    	case 6:
    		{
         ArrayList<Estudios> sec= ild.findAll();
         for(int x=0;x<sec.size();x++){
            System.out.println(sec.get(x).getId() + " "+sec.get(x).getId_Institucion().getId() + " "+sec.get(x).getNivel());
             }
    		break;
    		}
        default :
    		{
    		System.out.print("No existe la opccion deseada");
    		}
    	}   	
    } 
     
  /**aqui escogemos la opcion que vamos a utilizar para la tabla estudios_egresado
       * 
       * hacemos las respectivas instancias de las tablas egresado, estudios_egresado y estudios_egresadoDAO
       * 
       */
     public static void Estudios_Egresado()
    {
    	Scanner sc = new Scanner(System.in);
    	int opc;
    	
        int id;
        Date fecp = null;
        String fe, titu;
        Long cod;
       
        Egresado eg = new Egresado();
        Estudios es = new Estudios();
        Estudios_Egresado il = new Estudios_Egresado();
        Estudios_EgresadoDAO ild = new Estudios_EgresadoDAO();
        
    	System.out.println("Opciones referentes a la tabla Oferta_Egresado ");
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
    	/**crear
          * digite id estudios
          * por medio de la instancia de estudios_egresadoDAO hacemos el llamado a este procedimiento
          * y por medio de la instancia de estudios_egresado accedemos a esos metodos
       */
    	case 1:
    		{

                System.out.println("Digite el id del Estudios:");
    	        id= sc.nextInt();
                System.out.println("Digite el id del egresado:");
    	        cod = sc.nextLong();
                System.out.println("Digite el titulo:");
    	        titu = sc.next();
                System.out.println("Digite la fecha de grado:");
    	        fe=sc.next();
                  DateFormat df = DateFormat.getDateInstance();
            try {
                java.util.Date d = df.parse(fe);
                java.sql.Date da = new java.sql.Date(d.getTime());
                   fecp = da;
            } catch (ParseException ex) {
                Logger.getLogger(INTEGRADOR.class.getName()).log(Level.SEVERE, null, ex);
            }
    	        es.setId(id);
                il.setId_estudios(es);
                eg.setId(cod);
                il.setId_Egresado(eg);
                il.setTitulo(titu);
                il.setFecha_Grado(fecp);
    	        ild.create(il);
    		break;
    		}
    	
        /**encontrar por ID
             * digite el id de estudios
             * digite el id de egresado
             * por medio de la instancia de estudios_egresadoDAO hacemops el llamado a esta
             * funcion
             * 
             */
            
    	case 2:
    		{
                Long ide;
                int idest;
 
    		System.out.println("digite el id de  Estudios");
                idest=sc.nextInt();

                System.out.println("digite el id del egresado");
                ide=sc.nextLong();

                ild.findByID(ide , idest);	
    		break;
    		}
            
    	/**Borrar por ID
             * digite el id de estudios
             * por medio de la instancia de estudios_egresadoDAO hacemops el llamado a este
             * procedimiento para borrar por id y por medio de la instancia de estudios_egresado
             * accedemos a sus metodos
             */
    	case 3:
    		{
                System.out.println("digite el codigo de la Estudios");
                id=sc.nextInt();
                System.out.println("digite el codigo del Egresado");
                cod=sc.nextLong();
                es.setId(id);
                il.setId_estudios(es);
                eg.setId(cod);
                il.setId_Egresado(eg);
                
                ild.deleteByID(il);
    		break;
    		}
            
    	/**borrar todo
          * por medio de la instancia de estudios_egresadoDAO hacemops el llamado a este
          * procedimiento para borrar todo
        */
    	case 4:
    		{
        	ild.deleteAll();	
    		break;
    		}
            
    	/**actualizar
             * digite el id de estudios
             * por medio de la instancia de estudios_egresadoDAO hacemos el llamado a este procedimiento
             * y por medio de la instancia de estudios_egresado accedemos a esos metodos
             * 
             */
    	
        case 5:
    		{
        	     System.out.println("Digite el id del Estudios:");
    	        id= sc.nextInt();
                System.out.println("Digite el id del egresado:");
    	        cod = sc.nextLong();
                System.out.println("Digite el titulo:");
    	        titu = sc.next();
                System.out.println("Digite la fecha de grado:");
    	        fe=sc.next();
                  DateFormat df = DateFormat.getDateInstance();
            try {
                java.util.Date d = df.parse(fe);
                java.sql.Date da = new java.sql.Date(d.getTime());
                   fecp = da;
            } catch (ParseException ex) {
                Logger.getLogger(INTEGRADOR.class.getName()).log(Level.SEVERE, null, ex);
            }
    	        es.setId(id);
                il.setId_estudios(es);
                eg.setId(cod);
                il.setId_Egresado(eg);
                il.setTitulo(titu);
                il.setFecha_Grado(fecp);
    	        ild.update(il);
    		break;
    		}
    	/**encontrar todo
             * por medio del arraylist de estudios_egresado guardamos todas las funciones y procedimientos
       */
    	
        case 6:
    		{
                ArrayList<Estudios_Egresado> sec= ild.findAll();
                for(int x=0;x<sec.size();x++){
                System.out.println(sec.get(x).getTitulo() + " "+ sec.get(x).getFecha_Grado() + " "+sec.get(x).getId_Egresado().getId() + " "+sec.get(x).getId_estudios().getId());
             }
    		break;
    		}
            
        default :
    		{
    		System.out.print("No existe la opccion deseada");
    		}
    	}   	
    } 
     
     /**aqui escogemos la opcion que vamos a utilizar para la tabla oferta_egresado
      * 
      * hacemos las respectivas instancias de las tablas egresado, oferta_egresado y oferta_egresadoDAO
      */
     public static void Oferta_Egresado()          
    {
    	Scanner sc = new Scanner(System.in);
    	int opc;
    	
        int id, cod;
        String fi, ff;
        Date feci = null, fecf=null;
  
        Egresado eg = new Egresado();
        Oferta of = new Oferta();
        Oferta_Egresado il = new Oferta_Egresado();
        Oferta_EgresadoDAO ild = new Oferta_EgresadoDAO();
        
    	System.out.println("Opciones referentes a la tabla Oferta_Egresado ");
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
    	/**crear
             * digite id egresado
             * por medio de la instancia de oferta_egresadoDAO hacemos el llamado
             * a este procedimiento y por medio de la instancia de oferta_egresado accedemos a los metodos
             */
            
    	case 1:
    		{
                long ido;
                System.out.println("Digite el id de la oferta:");
    	        cod = sc.nextInt();
                System.out.println("Digite el id del Egresado:");
    	        ido = sc.nextLong();
                System.out.println("Digite la fecha de la oferta_egresado:");
                fi=sc.next();
                DateFormat df = DateFormat.getDateInstance();
            try {
                java.util.Date d = df.parse(fi);
                java.sql.Date da = new java.sql.Date(d.getTime());
                feci = da;
            } catch (ParseException ex) {
                Logger.getLogger(INTEGRADOR.class.getName()).log(Level.SEVERE, null, ex);
            }
                of.setId(cod);
                il.setId_Oferta(of);
                eg.setId(ido);
    	        il.setId_Egresado(eg);
                il.setFecha_Postulacion(feci);
    	        ild.create(il);
    		break;
    		}
            
    	/**encontrar por ID
             * 
             * digite el id de estudios
             * digite el id de oferta
             * por medio de la instancia de oferta_egresadoDAO hacemos el llamado a esta funcion
             */
    	case 2:
    		{
                  Long ido;      
    		  System.out.println("digite el id de la oferta");
                  cod=sc.nextInt();
              
                  System.out.println("digite el id del egresado");
                  ido=sc.nextLong();
           
                  ild.findByID(cod,ido);	
    		break;
    		}
            
    	/**Borrar por ID
             * 
             * digite el id de estudios
             * por medio de la instancia de oferta_egresadoDAO hacemos el llamado
             * a este procedimiento para borrar por id y por medio de la instancia de oferta_egresado accedemos a los metodos
             */
            
    	case 3:
    		{  
        	  Long ido;      
    		  System.out.println("digite el id de la oferta");
                  cod=sc.nextInt();
              
                  System.out.println("digite el id del egresado");
                  ido=sc.nextLong();
                 
                  
                  ild.deleteByID(cod,ido);
    		break;
    		}
    	
        /**borrar todo
             * 
             * por medio de la instancia de oferta_egresadoDAO hacemos el llamado
             * a este procedimiento para borrar todo
             */
    	case 4:
    		{
        	ild.deleteAll();
    		break;
    		}
    	
        /**actualizar
             * digite el id de estudios
             * por medio de la instancia de oferta_egresadoDAO hacemos el llamado
             * a este procedimiento para actualizar y por medio de la instancia de oferta_egresado accedemos a los metodos
             */
            
    	case 5:
    		{
        	     long ido;
                System.out.println("Digite el id de la oferta:");
    	        cod = sc.nextInt();
                System.out.println("Digite el id del Egresado:");
    	        ido = sc.nextLong();
                System.out.println("Digite la fecha de la oferta_egresado:");
                fi=sc.next();
                DateFormat df = DateFormat.getDateInstance();
            try {
                java.util.Date d = df.parse(fi);
                java.sql.Date da = new java.sql.Date(d.getTime());
                feci = da;
            } catch (ParseException ex) {
                Logger.getLogger(INTEGRADOR.class.getName()).log(Level.SEVERE, null, ex);
            }
                of.setId(cod);
                il.setId_Oferta(of);
                eg.setId(ido);
    	        il.setId_Egresado(eg);
                il.setFecha_Postulacion(feci);
    	        ild.update(il);
    		break;
    		}
            
    	/**encontrar todo
             * 
             * por medio del arraylist de estudios guardamos todas las funciones y procedimientos
             */
    	case 6:
            {
             ArrayList<Oferta_Egresado> sec= ild.findAll();
            for(int x=0;x<sec.size();x++){
            System.out.println(sec.get(x).getId_Egresado().getId() + " "+sec.get(x).getId_Oferta().getId()+ " "+sec.get(x).getFecha_Postulacion());
           }
    	   break;
    		}
        default :
    		{
    		System.out.print("No existe la opccion deseada");
    		}
    	}   	
    }  
      

     public static void Roles()
    {
     Scanner sc = new Scanner(System.in);
    	int opc, id;
    	String nombre;
        
        /**hacemos la instancia de las tablas Roles y  RolesDAO*/
    	RolesDAO rd = new RolesDAO();
        Roles r = new Roles();

    	System.out.println("Opciones referentes a la tabla Roles ");
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
    	/**Este case se encarga de insertar los datos en la tabla Roles 
             *  digitamos el nombre de la cuenta  Usuario
             *  por medio de la instancia de cuenta hacemos uso de sus metodos
             */
            
    	case 1:
    		{
              
    	        System.out.println("Digite el nombre del nuevo Rol");
    	        nombre = sc.next();
              
                r.setNombre(nombre);
    	        rd.create(r);
    			
    		break;
    		}
    	
        /** Este case se emcarga de encontrar al Usuario por su nombre de usuario
             * digitamos el nombre de usuario
             * por medio de la instancia de cuenta hacemos uso de sus metodos
             */
    	case 2:
    		{
    	        System.out.println("Digite el id de usuario de la Cuenta");
    		id=sc.nextInt();
    		r.setId(id);
    		rd.findByID(id).getNombre();
                
    		break;
    		}
            
    	/**Este case se encarga Borrar por ID de Usuario
             * digitamos el id de la cuenta
             * por medio de la instancia de cuenta hacemos uso de sus metodos
             */
    	case 3:
    		{
        	        System.out.println("Digite el id del Rol");
        		id=sc.nextInt();
        		
        		r.setId(id);
        		rd.deleteByID(r);
    			
    		break;
    		}
            
    	/**Este case se encarga de borrar todos los datos de la tabla
             * por medio de la instancia de cuentaDAO podemos utilizar sus metodos 
             */
    	case 4:
    		{
        	    rd.deleteAll();
                    System.out.println("Se ha eliminado todos los datos de la tabla Cuenta");
    			
    		break;
    		}
    	
             /** Este case se encarga de actualizar un dato de la tabla cuya nombre de usuario sea igual a la 
                * ingresada por el usuario
                * digitamos el nombre de la cuenta
                * por medio de la instancia de cuenta y cuentaDAO utilizamos sus metodos
                */        
    	case 5:
    		{
               System.out.println("Digite la id del rol");
        	id = sc.nextInt(); 
        	System.out.println("Digite el nombre de usuario");
        	nombre = sc.next();
               
                r.setId(id);
                r.setNombre(nombre);
        	rd.update(r);
    			
    		break;
    		}
            
    	/**Este case se encarga de traer todos los datos que existen en la tabla Cuenta
             * por medio del arraylist de cuenta guardamos todas las funciones y procedimientos
             */
    	case 6:
    		{
            	ArrayList<Roles> r1 = rd.findAll();
        
            	for (int x=0;x<r1.size();x++){
                
                System.out.println(r1.get(x).getId()  + " "+r1.get(x).getNombre());
            }
            	
    		break;
    		}
    	default :
    		{
    		System.out.print("No existe la opccion deseada");
    		}
    	}  
        
        
    }
 
    public static void Cuenta_Roles()
    {
     Scanner sc = new Scanner(System.in);
    	int opc;
    	String nombre;
        int id;
  
        Cuenta c = new Cuenta();
        Roles r= new Roles();
        Cuenta_Roles cr = new Cuenta_Roles();
        Cuenta_RolesDAO crd = new Cuenta_RolesDAO();
        
    	System.out.println("Opciones referentes a la tabla Cuenta_Roles ");
    	System.out.println("1. Crear");
    	System.out.println("2. Encontrar por ID");
    	System.out.println("3. Borrar por ID");
    	System.out.println("4. Borrar todo ");
        System.out.println("5. Actualizar informacion");
    	System.out.println("6. Encontrar todo");
    	System.out.println("Digite su opcion :");
    	
    	opc=sc.nextInt();
        
    	switch(opc)
    	{
    	/**crear
             * digite id egresado
             * por medio de la instancia de Cuenta_Roles y Cuenta_RolesDAO hacemos el llamado
             * a este procedimiento y por medio de la instancia de oferta_egresado accedemos a los metodos
             */
            
    	case 1:
    		{
                
               System.out.println("Digite la id del Rol que desea asignar");
                id=sc.nextInt();
                    
                System.out.println("Digite el Nombre de Usuario:");
                nombre = sc.next();
    	        

                c.setUser(nombre); 
                r.setId(id);
    	        cr.setUser_Cuenta(c);
         
                cr.setId_Rol(r);
                
                crd.create(cr);
    		break;
    		}
            
    	/**encontrar por ID
             * 
             * digite el id de estudios
             * digite el id de oferta
             * por medio de la instancia de oferta_egresadoDAO hacemos el llamado a esta funcion
             */
    	case 2:
    		{
                  int ido;      
    		  System.out.println("digite el nombre de usuario");
                  nombre=sc.next();
                  System.out.println("digite el id del Rol");
                  id=sc.nextInt();
                  crd.findByID(id, nombre);	
    		break;
    		}
            
    	/**Borrar por ID
             * 
             * digite el id de estudios
             * por medio de la instancia de oferta_egresadoDAO hacemos el llamado
             * a este procedimiento para borrar por id y por medio de la instancia de oferta_egresado accedemos a los metodos
             */
            
    	case 3:
    		{  
        	  System.out.println("digite el nombre de usuario");
                  nombre=sc.next();
                 
                  c.setUser(nombre); 
    	          cr.setUser_Cuenta(c);
                  crd.deleteByID(cr);
                  
    		break;
    		}
    	
        /**borrar todo
             * 
             * por medio de la instancia de oferta_egresadoDAO hacemos el llamado
             * a este procedimiento para borrar todo
             */
    	case 4:
    		{
        	crd.deleteAll();
    		break;
    		}
    	
        /**actualizar
             * digite el id de estudios
             * por medio de la instancia de oferta_egresadoDAO hacemos el llamado
             * a este procedimiento para actualizar y por medio de la instancia de oferta_egresado accedemos a los metodos
             */
            
    	case 5:
    		{
        	     System.out.println("digite el nombre de usuario");
                     nombre=sc.next();
                     
                     System.out.println("digite el id de Rol");
                     id=sc.nextInt();
                     
                     c.setUser(nombre);
                     cr.setUser_Cuenta(c);
                     crd.update(cr);
    		break;
    		}
            
    	/**encontrar todo
             * 
             * por medio del arraylist de estudios guardamos todas las funciones y procedimientos
             */
    	case 6:
            {
             ArrayList<Cuenta_Roles> ctr= crd.findAll();
            for(int x=0;x<ctr.size();x++){
            System.out.println(ctr.get(x).getId_Rol().getId() + " "+ctr.get(x).getUser_Cuenta().getUser());
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
