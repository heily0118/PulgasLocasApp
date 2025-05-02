package autonoma.pulgaslocas.elements;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 
 * @author Heily Yohana Rios Ayala <heilyy.riosa@gmail.com>
 * @since 20250430
 * @version 1.0.0
 */
public interface GraphicContainer {
    
    /**
     * Refresca/redibuja el contenedor gráfico.
     */
    public void refresh(Graphics g);
    
    /**
     * Devuelve los límites (dimensiones) del contenedor gráfico.
     * 
     * @return un objeto Rectangle que representa los bordes del contenedor
     */
    public Rectangle getBoundaries();
}
