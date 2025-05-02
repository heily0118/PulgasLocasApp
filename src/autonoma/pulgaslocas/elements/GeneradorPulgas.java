/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

/**
 *
 * @author Mateo Quintero <mateo.quinterom@autonoma.edu.co>
 * @since 20250501
 * @see autonoma.pulgaslocas.elements
 * @version 1.0.0
 */


public class GeneradorPulgas extends Thread {
    
    // Atributos
    private int intervaloGeneracion;  
    private CampoDeBatalla campo;
    private boolean activo;  

    // Constructor con el campo de batalla y el intervalo de generación
    public GeneradorPulgas(CampoDeBatalla campo, int intervaloGeneracion) {
        this.campo = campo;
        this.intervaloGeneracion = intervaloGeneracion;
        this.activo = true;
    }

    // Método para detener la generación
    public void detenerGeneracion() {
        activo = false;
    }
    
    // Método que inicia la generación de pulgas
    @Override
    public void run() {
        while (activo) {
            try {
                
                boolean esMutante = Math.random() > 0.5;  
                campo.agregarPulga(esMutante);  
                
               
                Thread.sleep(intervaloGeneracion);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


