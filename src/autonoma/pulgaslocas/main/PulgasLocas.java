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
       
   

        CampoDeBatalla campo = new CampoDeBatalla(900, 900, null);  

        
        
        Puntaje puntaje = new Puntaje("puntajes.txt", "");

        
        GestorJuego gestor = new GestorJuego(true, campo, "puntajes.txt", "");
       
        Jugador jugador = new Jugador(campo,gestor);
       
        campo.setJugador(jugador);  

      
        
       
       
        VentanaPrincipal ventana = new VentanaPrincipal(gestor);
        ventana.setVisible(true);
    }
    
}
