/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Mateo Quintero <mateo.quinterom@autonoma.edu.co>
 * @since 20250501
 * @see autonoma.pulgaslocas.elements
 * @version 1.0.0
 */
public class Pulga extends SpriteMobile{

     /**
     * 
     * 
     * @param x posición horizontal
     * @param y posición vertical
     * @param height alto del sprite
     * @param width ancho del sprite
     */
    public Pulga(int x, int y, int height, int width) {
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
