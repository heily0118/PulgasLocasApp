package autonoma.pulgaslocas.elements;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 
 * @author Heily Yohana Rios Ayala <heilyy.riosa@gmail.com>
 * @since 20250430
 * @version 1.0.0
 */
public abstract class SpriteMobile extends Sprite {

    /**
     * Cantidad de vida del sprite. Determina cuántos impactos puede recibir antes de desaparecer.
     */
    protected int vida;

    /**
     * Cantidad de píxeles que puede moverse al saltar.
     */
    protected int step = 10;

    /**
     * Crea un nuevo sprite móvil con la posición y tamaño especificados.
     *
     * @param x coordenada horizontal inicial
     * @param y coordenada vertical inicial
     * @param height alto del sprite
     * @param width ancho del sprite
     */
    public SpriteMobile(int x, int y, int height, int width) {
        super(x, y, height, width);
        this.visible = true; 
    }

    /**
     * Devuelve la cantidad de vida actual del sprite.
     *
     * @return número de vidas restantes
     */
    public int getVida() {
        return vida;
    }

    /**
     * Establece la cantidad de vida del sprite.
     *
     * @param vida valor a asignar
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     * Devuelve el valor actual del paso de movimiento (step).
     *
     * @return cantidad de píxeles de movimiento
     */
    public int getStep() {
        return step;
    }

    /**
     * Establece el valor del paso de movimiento.
     *
     * @param step cantidad de píxeles de salto
     */
    public void setStep(int step) {
        this.step = step;
    }

    /**
     * Reubica el sprite en una posición aleatoria dentro del campo de batalla.
     *
     * @param maxWidth ancho máximo permitido (límite derecho del campo)
     * @param maxHeight alto máximo permitido (límite inferior del campo)
     */
    public void moverAleatoriamente(int maxWidth, int maxHeight) {
        this.x = (int)(Math.random() * (maxWidth - this.width));
        this.y = (int)(Math.random() * (maxHeight - this.height));
    }

    /**
     * Método abstracto que define la lógica al recibir un impacto.
     * Cada subclase debe implementar su propia reacción (por ejemplo,
     * morir o transformarse).
     */
    public abstract void recibirImpacto();

    /**
     * Indica si el sprite sigue vivo (vida mayor que cero).
     *
     * @return true si tiene vida, false si debe eliminarse
     */
    public boolean estaViva() {
        return vida > 0;
    }
}
