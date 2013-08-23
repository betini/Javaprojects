/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hebraenjava;

import org.jfugue.Player;

/**
 *
 * @author Admin
 */
public class HebraMusica implements Runnable {

    public void run() {
        while(true){
            Player sonido = new Player();
            sonido.play("C D E F G A B C6 D6 E6 F6 G6 A6 B6");
        }
    }

}
