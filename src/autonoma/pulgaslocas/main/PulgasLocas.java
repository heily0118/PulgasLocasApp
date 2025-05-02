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
       
   

      CampoDeBatalla campo = new CampoDeBatalla(900, 700, null);  

        
        Puntaje puntaje = new Puntaje("puntajes.txt");

       
        Jugador jugador = new Jugador(campo,null);
       
       
        campo.setJugador(jugador);  

      
        GestorJuego gestor = new GestorJuego(true, campo, "puntajes.txt");
       
       
        VentanaPrincipal ventana = new VentanaPrincipal(gestor);
        ventana.setVisible(true);
    }
    
}
