/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.exceptions;

/**
 *
 * @author María Paz Puerta Acevedo <mariap.puertaa@autonoma.edu.co>
 * @since 20250501
 * @see autonoma.pulgaslocas.exceptions.EventoSinPulgasException
 * @version 1.0.0
 */
public class EventoSinPulgasException extends Exception {

    public EventoSinPulgasException() {
        super("Todavía no hay pulgas en el campo de batalla");
    }
    
}
