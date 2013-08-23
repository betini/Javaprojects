
package hebraenjava;

import java.awt.Image;
import javax.swing.ImageIcon; 
import java.awt.Rectangle;

public class Cangrejo {
    
    private Image image;

    	private static final int DIAMETER = 30;
	int x = 310;
	int y = 180;
	int xa = 1;
	int ya = 1;
        private Vista vista;
    
 public Cangrejo()
 {
     ImageIcon ii = new ImageIcon(this.getClass().getResource("carrito2.png"));
     image = ii.getImage();

 }

 public int getX()
 {
    return x; 
 }
 
 public int getY()
 {
    return y; 
 }
 
 public Image getImage()
 {
 return image;    
 }
  public Rectangle getBounds(){

return new Rectangle(x, y, 70, 75);
 }
 
	void move() {
            ya = 5;
            y = y + ya;
                     
            if (y > image.getHeight(null))
                        {
                         y=0-image.getHeight(null);
                        
                         x= (int)Math.floor(Math.random()*180+30);
                      
                                                     
                         //System.out.println(x);
                                             } 

            if (collision()) {                         
                 vista.gameOver();
            
	}
        }
 
  public boolean collision() {
		return vista.bob.getBounds().intersects(vista.cangrejo.getBounds());
               
}
 
}



