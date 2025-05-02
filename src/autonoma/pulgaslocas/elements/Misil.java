/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.util.ArrayList;
import java.util.Collections;

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
     * Objeto encargado de gestionar el puntaje.
     */
    private Puntaje puntaje;

    /**
     * Constructor de la clase Misil.
     *
     * @param posicionX Posición inicial en X del misil.
     * @param posicionY Posición inicial en Y del misil.
     */
    public Misil(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
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
     * Establece el objeto de puntaje asociado al misil.
     *
     * @param puntaje Es la instancia de Puntaje.
     */
    public void setPuntaje(Puntaje puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * Lanza el misil Pulgosón.
     * Destruye el 50% de las pulgas aleatoriamente seleccionadas.
     */
    public void lanzarMisil() {
        if (pulgas == null || pulgas.isEmpty()) {
            System.out.println("No hay pulgas para destruir.");
            return;
        }

        // Mezclar aleatoriamente la lista de pulgas
        Collections.shuffle(pulgas);

        int cantidadAEliminar = pulgas.size() / 2;
        ArrayList<Pulga> nuevasPulgas = new ArrayList<>();

        for (int i = 0; i < cantidadAEliminar; i++) {
            Pulga p = pulgas.get(i);

            if (p instanceof PulgaMutante) {
                // Convertir pulga mutante en normal
                PulgaNormal nueva = new PulgaNormal(1, true, null, p.getX(), p.getY(), p.getHeight(), p.getWidth());
                nuevasPulgas.add(nueva);
                System.out.println("Pulga mutante convertida en normal en (" + p.getX() + ", " + p.getY() + ")");
            } else if (p instanceof PulgaNormal) {
                // Eliminar y aumentar puntaje
                puntaje.incrementarPuntaje();
                System.out.println("Pulga normal destruida en (" + p.getX() + ", " + p.getY() + ")");
            }

            pulgas.remove(i);
            i--; 
            cantidadAEliminar--; 
        }

        pulgas.addAll(nuevasPulgas);
    }
}
