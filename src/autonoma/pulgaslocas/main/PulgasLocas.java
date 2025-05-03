/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autonoma.pulgaslocas.main;

import autonoma.pulgaslocas.elements.CampoDeBatalla;
import autonoma.pulgaslocas.elements.GestorJuego;
import autonoma.pulgaslocas.elements.Jugador;
import autonoma.pulgaslocas.elements.Puntaje;
import autonoma.pulgaslocas.gui.VentanaPrincipal;

/**
 *
 * @author Heily Yohana Rios Ayala<heilyy.riosa@autonoma.edu.co>
 */
public class PulgasLocas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
   
        ////primero se crea el objeto de sistema de puntos 
        
        Puntaje puntaje = new Puntaje("puntajes.txt", "");
        
        /// segundo un campo de battalla
        CampoDeBatalla campo = new CampoDeBatalla(900, 900, null);  
        
        // todo eso se almacena en gestor de juego
        GestorJuego gestor = new GestorJuego(true, campo, puntaje);
       
        //// se cre el jugador que interectua con jugador
        Jugador jugador = new Jugador(campo,gestor);
       
        gestor.getCampo().setJugador(jugador);  

      
        
       
       
        VentanaPrincipal ventana = new VentanaPrincipal(gestor);
        ventana.setVisible(true);
    }
    
}
