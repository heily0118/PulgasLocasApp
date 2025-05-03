/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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
     * Constructor para crear una pistola con un daño y posición específica.
     *
     * @param danio El daño que causa la pistola.
     * @param x     Coordenada X de la pistola.
     * @param y     Coordenada Y de la pistola.
     */
    public Pistola(int danio, int x, int y,ArrayList<Pulga> pulgas) {
        this.danio = danio;
        this.x = x;
        this.y = y;
        this.pulgas = pulgas;
        
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

    public ArrayList<Pulga> getPulgas() {
        return pulgas;
    }

    public void setPulgas(ArrayList<Pulga> pulgas) {
        this.pulgas = pulgas;
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
        public void dispararPistola(int x, int y, GestorJuego gestor) {
           
          sonidoPistola();
          System.out.println("metodo de disparar Pistola");
          
          for (int i = pulgas.size() - 1; i >= 0; i--) { // Iterar de atrás hacia adelante
              
              System.out.println("---------------------------------------------------");
              System.out.println("Mouse ");
              System.out.println("x" + x + "y" +  y);

              
              Pulga pulga = pulgas.get(i);
             
              
              System.out.println("posiciones de la pulga # "+ i);
              System.out.println("inicio x " + pulga.getX() + "  inicio y  " + pulga.getY());
              
              System.out.println("Ancho  " + (pulga.getX() + pulga.getWidth()) + " Alto  " + (pulga.getY() + pulga.getHeight()));
              
              // Comprobación de si el mouse está encima de la pulga
              if (x < pulga.getX() + pulga.getWidth() && x > pulga.getX() &&
                  y < pulga.getY() + pulga.getHeight() && y > pulga.getY()) {

                  System.out.println("El mouse esta encima de la pulga");
                  System.out.println("Vida: " + pulga.getVida());
                  
                  
                  // Convertir la pulga mutante en normal
                  if (pulga instanceof PulgaMutante) {
                    
                    pulgas.remove(i);
                    PulgaNormal nueva = new PulgaNormal(1, true, null, pulga.getX(), pulga.getY(), pulga.getHeight(), pulga.getWidth());
                    pulgas.add(nueva);
                    /// se aumenta 100
                    gestor.getPuntaje().incrementarPuntajeMultante();
                    }
                  else{
                      /// se aumenta 50
                    gestor.getPuntaje().incrementarPuntajeNormal();
                  }

                  // Si el mouse está encima, se avisa que fue herida
                  pulga.recibirImpacto();
                  System.out.println("Vida despues del impacto: " + pulga.getVida());

                  if (!pulga.estaViva()) {
                      
                      pulgas.remove(i); // Eliminar la pulga
                      System.out.println("Pulga destruida!");
                      pulga.sonidoPulga();
                  }
                  
                  System.out.println("puntaje actual");
                  System.out.println(gestor.getPuntaje().getPuntajeActual());
                  break; // Salir del bucle después de procesar la pulga
              }
          }
}

        
    //metodo de sonido
    public void sonidoPistola() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    getClass().getResource("/autonoma/pulgaslocas/sounds/pistola.wav"));
            
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();                                                                                                                                                                                   
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
