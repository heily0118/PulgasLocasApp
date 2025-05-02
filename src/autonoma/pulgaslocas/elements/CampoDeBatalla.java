/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

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
    
    //metodos
    
    public void agrgarPluga(){
    }
    
    public void removerPluga(){
    }
    
    
    
}
