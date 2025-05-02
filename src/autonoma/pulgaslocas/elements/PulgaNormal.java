package autonoma.pulgaslocas.elements;

import autonoma.pulgaslocas.elements.Pulga;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * 
 * @author Heily Yohana Rios Ayala <heilyy.riosa@gmail.com>
 * @since 20250430
 * @version 1.0.0
 */
public class PulgaNormal extends Pulga {

    /**
     * 
     * 
     * @param x posición horizontal
     * @param y posición vertical
     * @param height alto del sprite
     * @param width ancho del sprite
     */
    public PulgaNormal(int vida, boolean estaviva, Image pulgaImage, int x, int y, int height, int width) {    
        super(vida, estaviva, pulgaImage, x, y, height, width);
        this.vida = 2;
        this.pulgaImage = new ImageIcon(getClass().getResource("/autonoma/pulgaslocas/images/pulgaNormal.png")).getImage();
    
    }

    /**
     * Reduce la vida del sprite en uno. Si llega a 0, dejará de estar visible.
     */
    @Override
    public void recibirImpacto() {
        vida--;
        if (vida <= 0) {
          
        }
    }

    /**
     * 
     * 
     * @param g el contexto gráfico donde se va a pintar
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(color != null ? color : Color.GREEN);
        g.fillOval(x, y, width, height);
    }
}
