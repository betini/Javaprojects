import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class fondo {
        private static final int WITH = 400;
	private static final int HEIGHT = 600;
        int x=-60;
	int y = -230;
	int ya = 3;
        int cont=0;
	private Game game;
        double z;
        private Image image;
        private Object fondito;
       
	public fondo(Game game) 
{
this.game = game;
fondito = null;
try {
fondito = ImageIO.read(this.getClass().getResource("carretera.png"));
} catch (IOException ex) {
Logger.getLogger(Racquet.class.getName()).log(Level.SEVERE, null, ex);
}

	}
    
	void move() {
            ya = 3;
        
                     if(y<0){
                          y = y + ya;
                     }
                     else {
                         y=-230;
                     }
            if (y > game.getHeight())
                        {
                         y=0-HEIGHT;                     
                                             } 


	}
        

	public void paint(Graphics2D g) {
g.drawImage((Image) fondito, x, y, WITH, HEIGHT, null);
}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, WITH, HEIGHT);
	}
      
}
