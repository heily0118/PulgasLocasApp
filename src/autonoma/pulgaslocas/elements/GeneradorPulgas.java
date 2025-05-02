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

    private int intervaloNormal;  // Intervalo para pulgas normales (5 segundos)
    private int intervaloMutante;  // Intervalo para pulgas mutantes (10 segundos)
    private CampoDeBatalla campo;
    private boolean activo;

    public GeneradorPulgas(CampoDeBatalla campo, int intervaloNormal, int intervaloMutante) {
        this.campo = campo;
        this.intervaloNormal = intervaloNormal;
        this.intervaloMutante = intervaloMutante;
        this.activo = true;
    }

    public void detenerGeneracion() {
        activo = false;
    }

    @Override
    public void run() {
        while (activo) {
            try {
              
                campo.agregarPulga(false, generarPosicionX(), generarPosicionY()); 
                Thread.sleep(intervaloNormal);  

               
                campo.agregarPulga(true, generarPosicionX(), generarPosicionY());  
                Thread.sleep(intervaloMutante);  

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

  
    private int generarPosicionX() {
        return (int) (Math.random() * campo.getAncho());
    }

  
    private int generarPosicionY() {
        return (int) (Math.random() * campo.getAlto());
    }
}


