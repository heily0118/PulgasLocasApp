/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autonoma.pulgaslocas.main;

import autonoma.pulgaslocas.elements.CampoDeBatalla;
import autonoma.pulgaslocas.elements.GestorJuegos;
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
       
   

      CampoDeBatalla campo = new CampoDeBatalla(900, 700, null);  

        
        Puntaje puntaje = new Puntaje(0, 0);

       
        Jugador jugador = new Jugador(campo, puntaje);
        
       
        campo.setJugador(jugador);  

      
        GestorJuegos gestor = new GestorJuegos(true, campo);

       
        VentanaPrincipal ventana = new VentanaPrincipal(gestor);
        ventana.setVisible(true);
    }
    
}
