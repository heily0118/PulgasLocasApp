/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.exceptions;

/**
 *
 * @author mateo
 */
public class EventoInvalidoException extends RuntimeException{
    
    public EventoInvalidoException() {
        super("Error! la entrada de teclado o clic del mouse que no es válida o no está implementada. ");
    }
    
}
