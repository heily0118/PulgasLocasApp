/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Mateo Quintero <mateo.quinterom@autonoma.edu.co>
 * @since 20250501
 * @see autonoma.pulgaslocas.elements
 * @version 1.0.0
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
       campo.getPulgas().clear(); 
       iniciarJuegos();
    
    }
    
    public void manejareventoTeclado( KeyEvent e){
        
        
        switch(e.getKeyCode())
        {
            
            //"p" - se crea pulga Nomal
            case KeyEvent.VK_P:
                campo.agregarPulga(false);
            break;
            
            //"m" - se crea pulga multante
            case KeyEvent.VK_M:
                campo.agregarPulga(true);
            break;
            
            //"s" - para poner pulgas salten
            case KeyEvent.VK_S:
                campo.getGenerador().run();
            break;

        }    
    
    }
    
    public void manejarClick(MouseEvent e){
        int x = e.getX();
        int y = e.getY();

        campo.getJugador().disparar(x, y);
    
    }
    
    public void actualizarEstado(){
         campo.actualizarEstado();
    
    }    
    

    
}
