/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.util.ArrayList;

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
     * Lista de pulgas
     */
    private ArrayList<Pulga> pulgas; 
    
    /**
     * Objeto de puntaje.
     */
    private Puntaje puntaje;

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
     * Este método simula el disparo de una pistola en un campo de batalla.
     * 
     * Verifica si existe una pulga en la posición especificada por las coordenadas 
     * (x, y) y, en caso afirmativo, la elimina de la lista de pulgas y aumenta el puntaje.
     * El disparo puede afectar tanto a pulgas normales como mutantes.
     * 
     * @param x Es la coordenada X donde se realiza el disparo.
     * @param y Es la coordenada Y donde se realiza el disparo. 
     */
    public void dispararPistola(int x, int y) {
        boolean disparoExitoso = false; // Bandera para saber si el disparo fue exitoso

        for (int i = 0; i < pulgas.size(); i++) {
            Pulga pulga = pulgas.get(i);

            // Verificar si la pulga está en la posición (x, y)
            if (pulga.getX() == x && pulga.getY() == y) {
                // Si la pulga es normal, eliminarla y aumentar el puntaje
                if (pulga instanceof PulgaNormal) {
                    pulgas.remove(i); // Eliminar la pulga normal
                    puntaje.incrementarPuntaje(); // Incrementar el puntaje
                    System.out.println("¡Pulga normal destruida!");
                }
                // Si la pulga es mutante, eliminarla
                else if (pulga instanceof PulgaMutante) {
                    pulgas.remove(i); 
                    puntaje.incrementarPuntaje(); 
                    System.out.println("¡Pulga mutante destruida!");
                }
                disparoExitoso = true;
                break; 
            }
        }
    }
    
}
