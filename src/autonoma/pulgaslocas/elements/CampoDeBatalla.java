/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.awt.Color;
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
        ///se pone 80 el atlo y el largo de las pulgas para que se puedan eleminar mas facil
            p = new PulgaMutante(2, true, null, x, y, 80, 80); 
        } else {
            p = new PulgaNormal(1, true, null, x, y, 80, 80); 
        }

       
       limiteDeMapa(p);
        if (!colisionaConOtrasPulgas(p)) {
            pulgas.add(p);
        }
    }
    
    /**
    * Método auxiliar para verificar colisiones con otras pulgas.
    */
   private boolean colisionaConOtrasPulgas(Pulga nuevaPulga) {
       for (Pulga pulga : pulgas) {
           if (nuevaPulga.getX() < pulga.getX() + pulga.getWidth() &&
               nuevaPulga.getX() + 80 > pulga.getX() &&
               nuevaPulga.getY() < pulga.getY() + pulga.getHeight() &&
               nuevaPulga.getY() + 80 > pulga.getY()) {
               return true; // Colisión detectada
           }
       }
       return false; // No hay colisión
   }
   
    /**
     * Método para limitar la posición de una pulga dentro de los límites del mapa.
     */
    public void limiteDeMapa(Sprite pulga) {
        // Obtener la posición actual de la pulga
        int posicionX = pulga.getX();
        int posicionY = pulga.getY();

        // Limitar la posición en el eje X
        if (posicionX < 0) {
            pulga.setX(0); // Ajustar a la posición mínima
        } else if (posicionX > 800 - pulga.getWidth()) {
            pulga.setX(800 - pulga.getWidth()); // Ajustar a la posición máxima
        }

        // Limitar la posición en el eje Y
        if (posicionY < 0) {
            pulga.setY(0); // Ajustar a la posición mínima
        } else if (posicionY > 800 - pulga.getHeight()) {
            pulga.setY(800 - pulga.getHeight()); // Ajustar a la posición máxima
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
        
        g.setColor(new Color(34, 139, 34));  
        g.fillRect(0, 0, ancho, alto); 
        for (Pulga p : pulgas) {
            p.dibujar(g); 
        }
    }
}