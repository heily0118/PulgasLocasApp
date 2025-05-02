/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.util.ArrayList;

/**
 * @author Heily Yohana Rios Ayala <heilyy.riosa@gmail.com>
 * @since 20250430
 * @version 1.0.0
 */


public class Jugador {
    private Pistola pistola;
    private Misil misil;
    private GestorJuego gestor; 

    /**
     * @param campo Campo de batalla desde donde se obtiene la lista de pulgas.
     * @param puntaje Objeto que lleva el conteo del puntaje del jugador.
     * @param gestor El GestorJuego que controla la lógica del juego.
     */
    public Jugador(CampoDeBatalla campo, GestorJuego gestor) {
        this.gestor = gestor; 
        this.pistola = new Pistola(1, 0, 0, campo.getPulgas());
        this.misil = new Misil(1, 0);
    }

    public Pistola getPistola() {
        return pistola;
    }

    public void setPistola(Pistola pistola) {
        this.pistola = pistola;
    }

    /**
     * @param x Coordenada X del disparo
     * @param y Coordenada Y del disparo
     */
    public void disparar(int x, int y) {
        pistola.dispararPistola(x, y);
    }

    
}
