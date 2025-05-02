package autonoma.pulgaslocas.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * @author Heily Yohana Rios Ayala <heilyy.riosa@gmail.com>
 * @since 20250430
 * @version 1.0.0
 */
public class PulgaMutante extends Pulga {
    

    /**
     * 
     * 
     * @param vida
     * @param estaviva
     * @param pulgaImage
     * @param x posición horizontal
     * @param y posición vertical
     * @param height alto del sprite
     * @param width ancho del sprite
     */
    public PulgaMutante(int vida, boolean estaviva, Image pulgaImage, int x, int y, int height, int width) {  
        super(vida, estaviva, pulgaImage, x, y, height, width);
        this.vida = 2;
        this.pulgaImage = new ImageIcon(getClass().getResource("/autonoma/pulgaslocas/images/pulgaMutante.png")).getImage();
    }
    /**
     * Reduce la vida del sprite en uno. Si llega a 0, dejará de estar visible.
     */
    @Override
    public void recibirImpacto() {
        vida--;
        if (vida <= 0) {
             this.estaviva = false;
            
        }
    }

    /**
     *
     * 
     * @param g el contexto gráfico donde se va a pintar
     */
    @Override
    public void paint(Graphics g) {
        if (estaviva) {
            
            g.drawImage(pulgaImage, x, y, width, height, null);
        } else {
          
             g.setColor(Color.GRAY);
             g.fillOval(x, y, width, height);  
        }
    }

    @Override
    public void mover() {
      
        if (estaviva) {
          
            double directionX = Math.random();
            double directionY = Math.random();

            if (directionX < 0.5) {
                x += 10;  
            } else {
                x -= 10;  
            }

            if (directionY < 0.5) {
                y += 10;
            } else {
                y -= 10; 
            }

           
            if (x < 0) {
                x = 0;
            } else if (x > 600) {
                x = 600;
            }

            if (y < 0) {
                y = 0;
            } else if (y > 400) {  
                y = 400;
            }
        }
    }
    
}
