/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author mateo
 */
public class GestorJuegos {
    
    
    private  boolean juegoActivo ;
    
    private CampoDeBatalla campo;
    
    //Metodos
    
    public void iniciarJuegos (){
    
        juegoActivo = true;
        
    }
    
    public void terminarJuegos (){
    
        juegoActivo = false;
        
    }
    
    public void renicarJuego() {
    
    }
    
    public void manejareventoTeclado( KeyEvent e){
    
    }
    
    public void manejarClick(MouseEvent e){
    
    }
    
    public void actualizarEstado(){
    
    }    
    
            
            
            
            
            
            
            
            
            
            
            
            
    
    
}
