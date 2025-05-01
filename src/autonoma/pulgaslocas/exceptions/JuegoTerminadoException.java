/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.exceptions;

/**
 *
 * @author María Paz Puerta Acevedo <mariap.puertaa@autonoma.edu.co>
 * @since 20250501
 * @see autonoma.pulgaslocas.exceptions.JuegoTerminadoException
 * @version 1.0.0
 */
public class JuegoTerminadoException extends Exception{

    public JuegoTerminadoException() {
        super("El juego ya fue terminado");
    }
    
}
