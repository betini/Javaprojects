
package jframeconfondo;
import java.awt.*;
import javax.swing.*;

public class Panel extends javax.swing.JPanel {


    public Panel() {
        int x=400;
        int y=300;
        initComponents();
        this.setSize(x,y);
    }
    public void paintComponent(Graphics g){
        Dimension tam = getSize();
        ImageIcon ImagenFondo=new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/Fondo.png")).getImage());
        for (int i=0;i<=10;i++){
        g.drawImage(ImagenFondo.getImage(), 1, 0,tam.width, tam.height, null);
        }
        setOpaque(false);
        super.paintComponent(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
