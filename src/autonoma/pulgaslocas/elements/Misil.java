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
    public void lanzarMisil(GestorJuego gestor) {
         if (pulgas == null || pulgas.isEmpty()) {
            System.out.println("No hay pulgas para destruir.");
            return;
        }

        sonidoMisil();
        Collections.shuffle(pulgas);  

        int cantidadAEliminar = pulgas.size() / 2; 

        ArrayList<Pulga> pulgasAEliminar = new ArrayList<>();

        for (int i = 0; i < cantidadAEliminar; i++) {
            if (i >= pulgas.size()) {
                break;
            }

            Pulga p = pulgas.get(i);

            if (p instanceof PulgaMutante) {
                
                PulgaNormal nueva = new PulgaNormal(1, true, null, p.getX(), p.getY(), p.getHeight(), p.getWidth(), p.getCampo());
                pulgasAEliminar.add(p); 
                pulgas.add(nueva); 

             
                gestor.getPuntaje().incrementarPuntajeMutante();

               
                Thread hilo = new Thread(nueva);
                hilo.start();
            } else if (p instanceof PulgaNormal) {
                pulgasAEliminar.add(p);

               
                gestor.getPuntaje().incrementarPuntajeNormal();
            }
        }

       
        pulgas.removeAll(pulgasAEliminar);
      
    }
   
   
    /**
     * Método para agregar el sonido del Misil.
     */
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
