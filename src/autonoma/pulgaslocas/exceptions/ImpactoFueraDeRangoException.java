/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.exceptions;

/**
 *
 * @author mateo
 */
public class ImpactoFueraDeRangoException extends RuntimeException{
    
    public ImpactoFueraDeRangoException() {
        super("Error! el impacta fuera de los límites del área válida. ");
    }
    
}
