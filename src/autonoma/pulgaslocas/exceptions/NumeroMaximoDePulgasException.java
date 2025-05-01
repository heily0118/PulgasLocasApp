/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.exceptions;

/**
 *
 * @author Mateo Quintero <mateo.quinterom@autonoma.edu.co>
 * @since 20250501
 * @see autonoma.pulgaslocas.exceptions
 * @version 1.0.0
 */
public class NumeroMaximoDePulgasException extends RuntimeException{

    public NumeroMaximoDePulgasException() {
        super("Error! se intento poner más pulgas de las permitidas en el campo de batalla .");
    }
}


