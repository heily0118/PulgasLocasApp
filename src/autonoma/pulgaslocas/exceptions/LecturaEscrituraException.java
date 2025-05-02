/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.exceptions;

/**
 *
 * @author María Paz Puerta Acevedo <mariap.puertaa@autonoma.edu.co>
 * @since 20250501
 * @see autonoma.pulgaslocas.exceptions.LecturaEscrituraException
 * @version 1.0.0
 */
public class LecturaEscrituraException extends Exception {

    public LecturaEscrituraException() {
        super("Error al escribir o leer datos en el archivo");
    }
    
}
