/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

/**
 *
 * @author María Paz Puerta Acevedo <mariap.puertaa@autonoma.edu.co>
 * @since 20250501
 * @see autonoma.pulgaslocas.elements.Pistola
 * @version 1.0.0
 */
public class Pistola {
    /** 
     * Daño que causa la pistola al enemigo por disparo. 
     */
    private int danio = 1;

    /** 
     * Posición X de la pistola en el plano. 
     */
    private int x;

    /** 
     * Posición Y de la pistola en el plano. 
     */
    private int y;

    /**
     * Constructor para crear una pistola con un daño y posición específica.
     *
     * @param danio El daño que causa la pistola.
     * @param x     Coordenada X de la pistola.
     * @param y     Coordenada Y de la pistola.
     */
    public Pistola(int danio, int x, int y) {
        this.danio = danio;
        this.x = x;
        this.y = y;
    }

    /**
     * Obtiene el daño actual que causa la pistola.
     *
     * @return Retorna el valor del daño.
     */
    public int getDanio() {
        return danio;
    }

    /**
     * Establece el daño que causa la pistola.
     *
     * @param danio Es el nuevo valor del daño.
     */
    public void setDanio(int danio) {
        this.danio = danio;
    }

    /**
     * Obtiene la coordenada X actual de la pistola.
     *
     * @return Retorna la coordenada X.
     */
    public int getX() {
        return x;
    }

    /**
     * Establece una nueva coordenada X para la pistola.
     *
     * @param x Es la nueva coordenada X.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Obtiene la coordenada Y actual de la pistola.
     *
     * @return Retorna la coordenada Y.
     */
    public int getY() {
        return y;
    }

    /**
     * Establece una nueva coordenada Y para la pistola.
     *
     * @param y Es la nueva coordenada Y.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Simula el disparo de la pistola a un enemigo que se encuentra en una posición específica.
     * Si el enemigo está a una distancia menor o igual a 1 unidad, se le aplica daño.
     * Se muestra en consola si el enemigo fue eliminado o herido.
     *
     * @param enemigoX     Coordenada X del enemigo.
     * @param enemigoY     Coordenada Y del enemigo.
     * @param vidaEnemigo  Vida actual del enemigo antes del disparo.
     */
    public void eliminoEnemigo(int enemigoX, int enemigoY, int vidaEnemigo) {
        double distancia = Math.sqrt(Math.pow(enemigoX - this.x, 2) + Math.pow(enemigoY - this.y, 2));

        if (distancia <= 1) {
            vidaEnemigo -= danio;
            if (vidaEnemigo <= 0) {
                vidaEnemigo = 0;
                System.out.println("Enemigo eliminado!");
            } else {
                System.out.println("Enemigo herido, vida restante: " + vidaEnemigo);
            }
        } else {
            System.out.println("El enemigo está fuera de alcance.");
        }
    }
}
