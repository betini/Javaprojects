

package hebraenjava;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JFrame;


public class Vista extends javax.swing.JFrame {

    Bob bob=new Bob(this);
    Cangrejo cangrejo=new Cangrejo();
    HebraMusica Hebra;
    Thread Threads;
    int x=540,y=330;
    public Vista() {
        initComponents();
        Hebra = new HebraMusica();
        Threads = new Thread(Hebra);
        Threads.start();
    }
   
 public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cangrejito = new javax.swing.JLabel();
        Bob = new javax.swing.JLabel();
        cangrejito = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fantasma");
        setMinimumSize(new java.awt.Dimension(550, 366));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        Cangrejito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hebraenjava/canjo3.png"))); // NOI18N
        getContentPane().add(Cangrejito);
        Cangrejito.setBounds(110, 10, 0, 70);

        Bob.setIcon(new javax.swing.ImageIcon("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\Hebras\\src\\carrito1.png")); // NOI18N
        getContentPane().add(Bob);
        Bob.setBounds(170, 260, 24, 40);

        cangrejito.setIcon(new javax.swing.ImageIcon("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\hebrasenjava\\src\\hebraenjava\\carrito2.png")); // NOI18N
        getContentPane().add(cangrejito);
        cangrejito.setBounds(120, 130, 30, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Enrique\\Documents\\NetBeansProjects\\hebrasenjava\\src\\hebraenjava\\carretera.png")); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setMaximumSize(new java.awt.Dimension(540, 330));
        jLabel1.setMinimumSize(new java.awt.Dimension(540, 330));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 330, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

           
        switch(evt.getKeyCode()){
           
            case KeyEvent.VK_UP:   
                Bob.setLocation(Bob.getX(),Bob.getY()-1);
                    break;
            case KeyEvent.VK_DOWN:
                    Bob.setLocation(Bob.getX(),Bob.getY()+1);
                    break;
            case KeyEvent.VK_RIGHT:
                    Bob.setLocation(Bob.getX()+1,Bob.getY());
                    break;
            case KeyEvent.VK_LEFT:
                    Bob.setLocation(Bob.getX()-1,Bob.getY());
          
                    break;
            default:
                if(cangrejo.collision()){
                  gameOver();  
                }
                
                    System.out.println("Tecla no reconocida");
                    break;     
        }

    }//GEN-LAST:event_formKeyPressed

    /**
    * @param args the command line arguments
    */   
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
          
                new Vista().setVisible(true);
                
              
                 
            }   
    
        });
       
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bob;
    private javax.swing.JLabel Cangrejito;
    private javax.swing.JLabel cangrejito;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables


}
