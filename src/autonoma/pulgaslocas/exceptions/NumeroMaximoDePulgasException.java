/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.exceptions;

/**
 *
 * @author mateo
 */
public class NumeroMaximoDePulgasException extends RuntimeException{

    public NumeroMaximoDePulgasException() {
        super("Error! se intento poner más pulgas de las permitidas en el campo de batalla");
    }
}


