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

    public CampoDeBatalla(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.pulgas = new ArrayList<>(); 
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public ArrayList<Pulga> getPulgas() {
        return pulgas;
    }

    public GeneradorPulgas getGenerador() {
        return generador;
    }

    public void agregarPulga(boolean esMutante) {
        Pulga p;
        if (esMutante) {
            p = new PulgaMutante(2, true, null, 0, 0, 10, 10);
        } else {
            p = new PulgaNormal(1, true, null, 0, 0, 10, 10);
        }
        pulgas.add(p);
    }

    public void removerPulga(Pulga p) {
        pulgas.remove(p);
    }

    public void actualizarEstado() {
        
    }

    public void dibujar(Graphics g) {
        for (Pulga p : pulgas) {
            p.dibujar(g);
        }
    }
}