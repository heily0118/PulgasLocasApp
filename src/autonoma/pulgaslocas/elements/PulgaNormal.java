package autonoma.pulgaslocas.elements;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Heily Yohana Rios Ayala <heilyy.riosa@gmail.com>
 * @since 20250430
 * @version 1.0.0
 */
public class PulgaNormal extends SpriteMobile {

    /**
     * 
     * 
     * @param x posición horizontal
     * @param y posición vertical
     * @param height alto del sprite
     * @param width ancho del sprite
     */
    public PulgaNormal(int x, int y, int height, int width) {
        super(x, y, height, width);
        this.vida = 1; 
        this.color = Color.GREEN; 
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
