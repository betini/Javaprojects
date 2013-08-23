/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Enrique
 */
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Racquet {
       
	private static final int WITH = 30;
	private static final int HEIGHT = 40;
	int x = 150;
	int xa = 0;
        int ya = 0;
        int Y = 300;
        int m=3;
	private Game game;
        private Object carImage;

	public Racquet(Game game) {
		this.game = game;
                carImage = null;
try {
carImage = ImageIO.read(this.getClass().getResource("carro1mod.png"));
} catch (IOException ex) {
Logger.getLogger(Racquet.class.getName()).log(Level.SEVERE, null, ex);
}
	}

	public void move() {
		if (x + xa > 45 && x + xa < game.getWidth() - 60){
			x = x + xa;
                }
                else{
                    if(m>1){
                    m=m-1;
                x=150; 
                xa=0;}
                    else
                        game.gameOver();
                }
               
                if (Y + ya > 0 && Y + ya < game.getHeight()- HEIGHT)
			Y = Y + ya;
	}

	public void paint(Graphics2D g) {
		g.drawImage((Image) carImage, x, Y, WITH, HEIGHT, null);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
                ya = 0;
	}

	public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP)
			ya = -m;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			ya = m;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -m;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = m;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, Y, WITH, HEIGHT);
	}

	public int getTopY() {
		return Y - HEIGHT;
	}
}
