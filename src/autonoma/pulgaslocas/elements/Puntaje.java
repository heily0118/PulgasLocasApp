/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author María Paz Puerta Acevedo <mariap.puertaa@autonoma.edu.co>
 * @since 20250501
 * @see autonoma.pulgaslocas.elements.Puntaje
 * @version 1.0.0
 */
public class Puntaje {
    // Atributos
    
    /**
     * Es el puntaje actual.
     */
    private int puntajeActual = 0;
    
    /**
     * Es el puntaje máximo.
     */
    private int puntajeMaximo = 0;

    /**
     * Constructor de la clase Puntaje.
     * @param puntajeActual Es el puntaje actual.
     * @param puntajeMaximo Es el puntaje maximo.
     */
    public Puntaje(int puntajeActual, int puntajeMaximo) {    
        this.puntajeActual = puntajeActual;
        this.puntajeMaximo = puntajeMaximo;
    }

    /**
     * Retorna el puntaje actual del jugador.
     *
     * @return Retorna el puntaje actual.
     */
    public int getPuntajeActual() {
        return puntajeActual;
    }

    /**
     * Establece el puntaje actual del jugador.
     *
     * @param puntajeActual Es el nuevo puntaje actual.
     */
    public void setPuntajeActual(int puntajeActual) {
        this.puntajeActual = puntajeActual;
    }

    /**
     * Retorna el puntaje máximo alcanzado por el jugador.
     *
     * @return Retorna el puntaje máximo.
     */
    public int getPuntajeMaximo() {
        return puntajeMaximo;
    }

    /**
     * Establece el puntaje máximo alcanzado por el jugador.
     *
     * @param puntajeMaximo Es el nuevo puntaje máximo.
     */
    public void setPuntajeMaximo(int puntajeMaximo) {
        this.puntajeMaximo = puntajeMaximo;
    } 

    // Métodos

    /**
     * Es un método para ncrementa el puntaje actual en 1.
     * Si el nuevo puntaje actual es mayor que el máximo, se actualiza también el máximo.
     */
    public void incrementarPuntaje() {
        puntajeActual++;
        if (puntajeActual > puntajeMaximo) {
            puntajeMaximo = puntajeActual;
        }
    }

    /**
     * Es un método para reiniciar el puntaje actual a cero.
     * El puntaje máximo no se modifica.
     */
    public void reiniciarPuntaje() {
        puntajeActual = 0;
    }

    /**
     * Obtiene el puntaje actual del jugador.
     *
     * @return Retotna el puntaje actual.
     */
    public int obtenerPuntajeActual() {
        return puntajeActual;
    }

    /**
     * Obtiene el puntaje máximo alcanzado por el jugador.
     *
     * @return Retorna el puntaje máximo.
     */
    public int obtenerPuntajeMaximo() {
        return puntajeMaximo;
    }

    /**
     * Es un método que muestra el puntaje actual y el máximo en consola.
     */
    public void mostrarPuntaje() {
        System.out.println("Puntaje Actual: " + puntajeActual);
        System.out.println("Puntaje Máximo: " + puntajeMaximo);
    }
    
    /**
     * Es un método para cargar el puntaje máximo desde un archivo de texto.
     * Si el archivo no existe o contiene datos inválidos,
     * se establece el puntaje máximo en 0.
     *
     * @param rutaArchivo Es la ruta del archivo donde se guarda el puntaje máximo.
     */
    public void cargarPuntajeMaximo(String rutaArchivo) throws IOException {
        FileReader fileReader = new FileReader(rutaArchivo);
        BufferedReader br = new BufferedReader(fileReader);
        String linea = br.readLine();
        
        if (linea != null && !linea.isEmpty()) {
            puntajeMaximo = Integer.parseInt(linea.trim());
        } else {
            puntajeMaximo = 0;
        }
        
        br.close();
    }

    /**
     * Es un método para guardar el puntaje máximo actual en un archivo de texto.
     *
     * @param rutaArchivo Es la ruta del archivo donde se guardará el puntaje máximo.
     */
    public void guardarPuntajeMaximo(String rutaArchivo) throws IOException {
        FileWriter fileWriter = new FileWriter(rutaArchivo);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        bw.write(String.valueOf(puntajeMaximo));
        bw.close();  
    }
}
