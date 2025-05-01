/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.exceptions;

/**
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 20250430
 * @version 1.0.0
 */
public class PulgaInactivaException extends RuntimeException {

    public PulgaInactivaException() {
        super("Error! no se puede interactuar con esta pulga");
    }
    
    
}
