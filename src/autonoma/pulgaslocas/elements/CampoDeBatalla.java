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
    
    //Atributos
    private int ancho;
    private int alto;

    private ArrayList<Pulga>pulgas;

    public CampoDeBatalla(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    ///Metodos accesos (get)
    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
    
    //metodos de campo
    
    public void agrgarPluga(){
        
        Pulga p = new Pulga(1, true, null, 0, 0, 10, 10) {
            @Override
            public void paint(Graphics g) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        
        pulgas.add(p);
    }
    
    public void removerPluga(){

        Pulga p = new Pulga(11, true, null, 0, 0, 10, 10) {
            @Override
            public void paint(Graphics g) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        pulgas.remove(p);

    }
    
    public void actualizarEstado(){
    }
    
    
    
    
}
