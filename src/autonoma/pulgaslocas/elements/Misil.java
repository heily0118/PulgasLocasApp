/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author María Paz Puerta Acevedo <mariap.puertaa@autonoma.edu.co>
 * @since 20250501
 * @see autonoma.pulgaslocas.elements.Misil
 * @version 1.0.0
 */
public class Misil {
    /**
     * Posición en X del misil.
     */
    private int posicionX;

    /**
     * Posición en Y del misil.
     */
    private int posicionY;

    /**
     * Lista de pulgas activas en el campo de batalla.
     */
    private ArrayList<Pulga> pulgas;

  

    /**
     * Constructor de la clase Misil.
     *
     * @param posicionX Posición inicial en X del misil.
     * @param posicionY Posición inicial en Y del misil.
     */
    public Misil(int posicionX, int posicionY,ArrayList<Pulga> pulgas) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.pulgas = pulgas;
    }

    /**
     * Obtiene la posición X del misil.
     *
     * @return Es la posición en el eje X.
     */
    public int getPosicionX() {
        return posicionX;
    }

    /**
     * Establece la posición X del misil.
     *
     * @param posicionX Es la nueva posición en el eje X.
     */
    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    /**
     * Obtiene la posición Y del misil.
     *
     * @return Retorna la posición en el eje Y.
     */
    public int getPosicionY() {
        return posicionY;
    }

    /**
     * Establece la posición Y del misil.
     *
     * @param posicionY Es la nueva posición en el eje Y.
     */
    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    /**
     * Establece la lista de pulgas en el campo de batalla.
     *
     * @param pulgas Es la lista de objetos de tipo Pulga.
     */
    public void setPulgas(ArrayList<Pulga> pulgas) {
        this.pulgas = pulgas;
    }

   

    /**
    * Lanza el misil Pulgosón.
    * Destruye el 50% de las pulgas aleatoriamente seleccionadas.
    */
   public void lanzarMisil() {
       // Verificar si hay pulgas en el campo de batalla
       if (pulgas == null || pulgas.isEmpty()) {
           System.out.println("No hay pulgas para destruir.");
           return;
       }
       
       sonidoMisil();
       // Mezclar aleatoriamente la lista de pulgas
       Collections.shuffle(pulgas);

       // Calcular la cantidad de pulgas a eliminar
       int cantidadAEliminar = pulgas.size() / 2;

       // Iterar sobre la lista de pulgas y eliminar/convertir
       for (int i = 0; i < cantidadAEliminar; i++) {
           Pulga p = pulgas.get(i);

           if (p instanceof PulgaMutante) {
               // Convertir la pulga mutante en normal
               PulgaNormal nueva = new PulgaNormal(1, true, null, p.getX(), p.getY(), p.getHeight(), p.getWidth());
               pulgas.add(nueva);
               System.out.println("Pulga mutante convertida en normal en (" + p.getX() + ", " + p.getY() + ")");
           } else if (p instanceof PulgaNormal) {
               // Eliminar la pulga normal
               System.out.println("Pulga normal destruida en (" + p.getX() + ", " + p.getY() + ")");
               pulgas.remove(i);
               i--; // Decrementar el índice para compensar la eliminación
           }
       }
   }

    public void sonidoMisil() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    getClass().getResource("/autonoma/PulgasLocas/sounds/misil.wav"));
            
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();                                                                                                                                                                                   
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    
}
