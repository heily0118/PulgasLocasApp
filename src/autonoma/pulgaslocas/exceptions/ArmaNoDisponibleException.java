/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.exceptions;

/**
 *
 * @author mateo
 */
public class ArmaNoDisponibleException extends RuntimeException{

    public ArmaNoDisponibleException() {
        super("Error! usted intento usar una arma, las armas no está disponibles ");
    }
}
