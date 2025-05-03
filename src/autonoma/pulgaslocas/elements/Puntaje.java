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
import java.util.ArrayList;

/**
 *
 * @author María Paz Puerta Acevedo <mariap.puertaa@autonoma.edu.co>
 * @since 20250501
 * @see autonoma.pulgaslocas.elements.Puntaje
 * @version 1.0.0
 */
public class Puntaje {
    /**
     * Puntaje actual que tiene el jugador.
     */
    private int puntajeActual;
    
    /**
     * Puntaje máximo que tiene el jugador.
     */
    private int puntajeMaximo;

    /**
     * Objeto de la clase LectorArchivoTextoPlano.
     */
    private LectorArchivoTextoPlano lector;
    
    /**
     * Objeto de la clase EscritorArchivoTextoPlano.
     */
    private EscritorArchivoTextoPlano escritor;

    /**
     * Nombre del archivo donde se guarda el puntaje máximo.
     */
    private String archivoPuntajeMaximo;

    /**
     * Constructor que recibe el nombre del archivo donde se encuentra
     * el puntaje máximo y carga su valor al iniciar.
     * 
     * @param archivoPuntajeMaximo nombre del archivo que contiene el puntaje máximo
     */
    public Puntaje(String archivoPuntajeMaximo) {
        this.archivoPuntajeMaximo = archivoPuntajeMaximo;
        lector = new LectorArchivoTextoPlano();
        escritor = new EscritorArchivoTextoPlano("PuntajeMaximo.txt");
        cargarPuntajeMaximo(); // Carga el puntaje máximo desde el archivo
    }

    /**
     * Incrementa el puntaje actual en uno.
     */
    public void incrementarPuntaje() {
        puntajeActual++;
    }

    /**
     * Guarda el puntaje máximo en el archivo si el puntaje actual lo supera.
     * 
     * @throws IOException si ocurre un error al escribir en el archivo
     */
    public void guardarPuntajeMaximo() throws IOException {
        if (puntajeActual > puntajeMaximo) {
            puntajeMaximo = puntajeActual;
            ArrayList<String> datos = new ArrayList<>();
            datos.add("PUNTAJE_MAXIMO," + puntajeMaximo); // Formato: clave,valor
            escritor.escribir(datos); // Escribe en el archivo
        }
    }

    /**
     * Carga el puntaje máximo desde el archivo especificado.
     * Si ocurre algún error, el puntaje máximo se establece en cero.
     */
    public void cargarPuntajeMaximo() {
        try {
            ArrayList<String> lineas = lector.leer(archivoPuntajeMaximo);
            if (!lineas.isEmpty()) {
                String[] partes = lineas.get(0).split(","); // Espera formato: PUNTAJE_MAXIMO,valor
                if (partes.length == 2) {
                    puntajeMaximo = Integer.parseInt(partes[1].trim());
                }
            }
        } catch (Exception e) {
            // Si hay error al leer o parsear, se asume puntaje máximo cero
            puntajeMaximo = 0; 
        }
    }

    /**
     * Devuelve una cadena con el puntaje actual y el puntaje máximo.
     * 
     * @return Retorna la representación en texto del puntaje actual y el máximo
     */
    public String mostrarPuntaje() {
        return "Puntaje actual: " + puntajeActual + ", Puntaje máximo: " + puntajeMaximo;
    }

    /**
     * Retorna el puntaje actual.
     * 
     * @return Retorna el puntaje actual
     */
    public int getPuntajeActual() {
        return puntajeActual;
    }

    /**
     * Retorna el puntaje máximo.
     * 
     * @return Retorna el puntaje máximo
     */
    public int getPuntajeMaximo() {
        return puntajeMaximo;
    }

    /**
     * Reinicia el puntaje actual a cero.
     */
    public void reiniciarPuntaje() {
        puntajeActual = 0;
    }
}