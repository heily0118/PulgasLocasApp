/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Mateo Quintero <mateo.quinterom@autonoma.edu.co>
 * @since 20250501
 * @see autonoma.pulgaslocas.elements
 * @version 1.0.0
 */
public class CampoDeBatalla {
    private int ancho;
    private int alto;
    private ArrayList<Pulga> pulgas;
    private GeneradorPulgas generador;
    private Jugador jugador;

   

    public CampoDeBatalla(int ancho, int alto, Jugador jugador) {
        this.ancho = ancho;
        this.alto = alto;
        this.pulgas = new ArrayList<>();
        this.jugador = jugador;
        this.generador = new GeneradorPulgas(this, 5000, 10000); 
        this.generador.start();
    }

    // Getters y Setters
    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setPulgas(ArrayList<Pulga> pulgas) {
        this.pulgas = pulgas;
    }

    public void setGenerador(GeneradorPulgas generador) {
        this.generador = generador;
    }
    

    public ArrayList<Pulga> getPulgas() {
        return pulgas;
    }

    public GeneradorPulgas getGenerador() {
        return generador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    /**
     * Método para agregar una pulga (normal o mutante) en el campo en una posición específica.
     */
    public void agregarPulga(boolean esMutante, int x, int y) {
        Pulga p;
        if (esMutante) {
            p = new PulgaMutante(2, true, null, x, y, 10, 10); 
        } else {
            p = new PulgaNormal(1, true, null, x, y, 10, 10); 
        }

        
        boolean colisiona = false;
        for (Pulga pulga : pulgas) {
            if (x < pulga.getX() + pulga.getWidth() && x + 10 > pulga.getX() && y < pulga.getY() + pulga.getHeight() && y + 10 > pulga.getY()) {
                colisiona = true; 
                break;
            }
        }

       
        if (!colisiona) {
            pulgas.add(p);
        }
    }

    /**
     * Método para eliminar una pulga del campo de batalla.
     */
    public void eliminarPulga(Pulga p) {
        pulgas.remove(p);
    }

    /**
     * Método para reiniciar el campo de batalla (limpiar todas las pulgas).
     */
    public void reiniciarCampo() {
        pulgas.clear();
    }

    /**
     * .
     */
    public void actualizarEstado() {
        for (Pulga p : pulgas) {
            p.actualizarEstado(); 
        }
    }

    /**
     * Método para dibujar todas las pulgas en el campo de batalla.
     * @param g el objeto Graphics utilizado para dibujar
     */
    public void dibujar(Graphics g) {
        for (Pulga p : pulgas) {
            p.dibujar(g); 
        }
    }
}