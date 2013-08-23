
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ball2 {
        private static final int WITH = 30;
	private static final int HEIGHT = 40;
        int x=(int)Math.floor(Math.random()*130+90);
	int y = 0;
	int ya = 2;
        int cont=0;
        private Game game;
        double z;
        private Image image;
        private Object carImage;
       
	public ball2(Game game) 
{
this.game = game;
carImage = null;
try {
carImage = ImageIO.read(this.getClass().getResource("carro3mod.png"));
} catch (IOException ex) {
Logger.getLogger(Racquet.class.getName()).log(Level.SEVERE, null, ex);
}

	}
    
	void move() {
           
            y = y + ya;
                     
            if (y > game.getHeight())
                        {
                         y=0-HEIGHT;
                        
                         x= (int)Math.floor(Math.random()*130+90);
                     
                        
                        }

            if (collision()) {
                
                        if(game.racquet.m>=1){
                            y=0-HEIGHT;
                            x= (int)Math.floor(Math.random()*180+30);
                               game.racquet.m=game.racquet.m+1;
                             //  game.Estrellado2();
                                                }
         
	}
        }
	private boolean collision() {
		return game.racquet.getBounds().intersects(game.ball2.getBounds());
	}

	public void paint(Graphics2D g) {
g.drawImage((Image) carImage, x, y, WITH, HEIGHT, null);
}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, WITH, HEIGHT);
	}
}