package hebraenjava;

import java.awt.Image;
import javax.swing.ImageIcon; 
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Bob {
    
    private Image image;
    private int x,y;
    private static final int Y = 330;
	private static final int WITH = 65;
	private static final int HEIGHT = 51;
        private Vista vista;
      
    Cangrejo cangrejo=new Cangrejo();
 public Bob(Vista vista)
 {
     ImageIcon ii = new ImageIcon(this.getClass().getResource("fantasma.png"));
     image = ii.getImage();
     x=10;
     y=40;
     
 }

 public int getX()
 {
    return x; 
 }
 
 public int getY()
 {
    return y; 
 }
	public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP)
			y = -1;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			y = 1;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			x = -1;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			x = 1;
	}
 public Image getImage()
 {
 return image;    
 }
 
 public Rectangle getBounds(){
    return new Rectangle(x, Y, WITH, HEIGHT);
 }
 
}

