
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {

	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
        ball2 ball2 = new ball2(this);
        fondo fond = new fondo(this);
        private Reproductor rep1= null;
        private Reproductor rep= null;
        private String fondo="carretera.png";
        ImageIcon imagen;
        Image image;
         int cont=0;
          
	public Game() { 
            
          musica2();
         setFocusable(true);
         setDoubleBuffered(true);
         imagen=new ImageIcon(this.getClass().getResource(fondo));
           image=imagen.getImage();
           
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);
                

	}
	
	private void move() {
            
                
            
                if(getScore()>10000&&getScore()<=20000){
		ball.ya=5;
                }
                  if(getScore()>20000&&getScore()<=40000){
		ball.ya=6;
                }
                   if(getScore()>40000){
		ball.ya=7;
                }
                ball.move();
              
                      if(racquet.m<4){
                ball2.move();
                      }
                
		racquet.move();
                fond.move();
                
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.drawImage(this.image, 0, 0, null);
                fond.paint(g2d);
		ball.paint(g2d);
                ball2.paint(g2d);
		racquet.paint(g2d);
                g2d.setColor(Color.WHITE);
                g2d.setFont(new Font("Verdana", Font.BOLD,20));
                g2d.drawString(String.valueOf("VEL "+racquet.m),220,30);
                g2d.drawString("SCORE", 30, 30);
                g2d.drawString(String.valueOf(getScore()),40,50);
                
	}
	
	public void gameOver() {
            musica();    
            JOptionPane.showMessageDialog(this, "No sea noob gay "+ getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
          
	}
        private int getScore(){
            while (true){
                cont=cont+racquet.m; 
                return cont;
            }
           
       }
          private void musica()
        {
           // rep1.pause();
            rep1 = new Reproductor("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Hebras\\src\\IS2.mp3");
            rep1.start();   
      
        }
         public void musica2(){
                rep1 = new Reproductor("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Hebras\\src\\ac dc - thunderstruck.mp3");
            rep1.start();  
         }

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Carritos");
		Game game = new Game();
                frame.setResizable(false);
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.move();
			game.repaint();
                       
			Thread.sleep(10);
		}
	}
        
}