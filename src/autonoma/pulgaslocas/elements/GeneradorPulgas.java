/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

/**
 * Hilo encargado de generar pulgas (normales y mutantes) de forma automática en el campo de batalla.
 * 
 * Este generador alterna entre la creación de pulgas normales y mutantes en posiciones aleatorias del campo
 * a intervalos definidos. El hilo puede ser detenido cuando se desee detener la generación.
 * 
 * @author Mateo Quintero <mateo.quinterom@autonoma.edu.co>
<<<<<<< HEAD
=======
 * @since 20250501
 * @see autonoma.pulgaslocas.elements.GeneradorPulgas
>>>>>>> 0e0e2d7dd6a1bcebf767375bfd5914036c6653be
 * @version 1.0.0
 * @since 20250501
 * @see autonoma.pulgaslocas.elements.CampoDeBatalla
 */
public class GeneradorPulgas extends Thread {

    /**
     * Intervalo de tiempo (en milisegundos) para generar una pulga normal.
     */
    private int intervaloNormal;

    /**
     * Intervalo de tiempo (en milisegundos) para generar una pulga mutante.
     */
    private int intervaloMutante;

    /**
     * Referencia al campo de batalla donde se agregarán las pulgas.
     */
    private CampoDeBatalla campo;

    /**
     * Indica si el generador está activo.
     */
    private boolean activo;

    /**
     * Constructor del generador de pulgas.
     * 
     * @param campo            Campo de batalla donde se generarán las pulgas
     * @param intervaloNormal  Tiempo entre la generación de pulgas normales (ms)
     * @param intervaloMutante Tiempo entre la generación de pulgas mutantes (ms)
     */
    public GeneradorPulgas(CampoDeBatalla campo, int intervaloNormal, int intervaloMutante) {
        this.campo = campo;
        this.intervaloNormal = intervaloNormal;
        this.intervaloMutante = intervaloMutante;
        this.activo = true;
    }

    /**
<<<<<<< HEAD
     * Detiene la generación de nuevas pulgas.
=======
     * Detiene la generación de pulgas estableciendo la bandera 'activo' en falso.
>>>>>>> 0e0e2d7dd6a1bcebf767375bfd5914036c6653be
     */
    public void detenerGeneracion() {
        activo = false;
    }

    /**
<<<<<<< HEAD
     * Ejecuta el hilo que alterna entre generar pulgas normales y mutantes en posiciones aleatorias
     * hasta que se detenga el generador.
=======
     * Método principal que se ejecuta cuando el hilo inicia.
>>>>>>> 0e0e2d7dd6a1bcebf767375bfd5914036c6653be
     */
    @Override
    public void run() {
        while (activo) {
            try {
                // Genera una pulga normal
                campo.agregarPulga(false, generarPosicionX(), generarPosicionY()); 
                Thread.sleep(intervaloNormal);  

                // Genera una pulga mutante
                campo.agregarPulga(true, generarPosicionX(), generarPosicionY());  
                Thread.sleep(intervaloMutante);  

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

<<<<<<< HEAD
    /**
     * Genera una posición X aleatoria dentro del ancho del campo.
     * 
     * @return Coordenada X válida para una nueva pulga
=======
  
    /**
     * Genera una posición X aleatoria dentro del ancho del campo.
     * 
     * @return Retorna una coordenada X válida dentro del campo.
>>>>>>> 0e0e2d7dd6a1bcebf767375bfd5914036c6653be
     */
    private int generarPosicionX() {
        return (int) (Math.random() * campo.getAncho());
    }

<<<<<<< HEAD
    /**
     * Genera una posición Y aleatoria dentro del alto del campo.
     * 
     * @return Coordenada Y válida para una nueva pulga
=======
  
    /**
     * Genera una posición Y aleatoria dentro del alto del campo.
     * 
     * @return Retorna una coordenada Y válida dentro del campo.
>>>>>>> 0e0e2d7dd6a1bcebf767375bfd5914036c6653be
     */
    private int generarPosicionY() {
        return (int) (Math.random() * campo.getAlto());
    }
}



