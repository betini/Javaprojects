 


import java.io.File;
import javazoom.jl.player.*;

/**
 *
 * @author Sergio
 */
public class Reproductor extends Thread{
    
    private jlp mReproductor = null;
    
    public Reproductor(String pFileName)
        {
         try
        {
           
            String [] args = new String[1];
            args[0] = pFileName;
            mReproductor = jlp.createInstance(args);   
        }
        catch(Exception e)
                {
                  e.printStackTrace();
                }
        }   
    
    
    public void run()
    {        
        try
        {
           while(true)
            {
            mReproductor.play();
            Thread.sleep(15000);
            
            }
        }
        catch(Exception e)
                {
                  e.printStackTrace();
                }
      
        
    }
 /*   public void pause(){
        try
        {
           while(true)
            {
            Thread.sleep(15000);
            
            }
        }
        catch(Exception e)
                {
                  e.printStackTrace();
                }
      
        
    }
    
   */ 
    
}
