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
     * Puntaje actual que tiene el jugador en la sesión actual del juego.
     */
    private int puntajeActual;

    /**
     * Puntaje máximo alcanzado históricamente por el jugador, guardado en archivo.
     */
    private int puntajeMaximo;

    /**
     * Ruta del archivo donde se guarda el puntaje máximo.
     */
    private String archivoPuntajeMaximo;

    /**
     * Nombre del jugador.
     */
    private String nombreJugador;

    
    /**
     * Nombre del jugador  de Puntaje Maximo.
     */
    private String MaximoNombre;
    /**
     * Objeto encargado de leer archivos de texto plano.
     */
    private LectorArchivoTextoPlano lector;

    /**
     * Objeto encargado de escribir archivos de texto plano.
     */
    private EscritorArchivoTextoPlano escritor;

    
    /**
     * Constructor de la clase Puntaje.
     * 
     * @param archivoPuntajeMaximo Ruta del archivo de texto que contiene el puntaje máximo.
     * @param nombreJugador Nombre del jugador actual.
     */
    public Puntaje(String archivoPuntajeMaximo, String nombreJugador) {
        this.archivoPuntajeMaximo = archivoPuntajeMaximo;
        this.nombreJugador = nombreJugador;
        lector = new LectorArchivoTextoPlano();
        escritor = new EscritorArchivoTextoPlano(archivoPuntajeMaximo);
        cargarPuntajeMaximo(); // Carga el puntaje máximo guardado
    }

    /**
     * Incrementa en uno el puntaje actual del jugador.
     */
    public void incrementarPuntajeNormal() {
        puntajeActual  += 50;
    }
    
    /**
     * Incrementa en uno el puntaje actual del jugador.
     */
    public void incrementarPuntajeMultante() {
        puntajeActual += 100;
    }
    /**
     * Guarda el puntaje máximo en el archivo si el puntaje actual lo supera.
     * El formato en el archivo es: nombreJugador,puntajeMaximo
     * 
     * @throws IOException si ocurre un error al escribir en el archivo.
     */
    public void guardarPuntajeMaximo() throws IOException {
        if (puntajeActual > puntajeMaximo) {
            MaximoNombre = nombreJugador;
            puntajeMaximo = puntajeActual;
            ArrayList<String> datos = new ArrayList<>();
            datos.add(nombreJugador + "," + puntajeMaximo);
            escritor.escribir(datos); // Guarda en archivo
        }
    }

    /**
     * Carga el puntaje máximo desde el archivo. Si no existe o hay un error, 
     * se inicializa el puntaje máximo en 0.
     */
    public void cargarPuntajeMaximo() {
        try {
            System.out.println("ubicacion de archivo txt");
            System.out.println(archivoPuntajeMaximo);
            ArrayList<String> lineas = lector.leer(archivoPuntajeMaximo);
            if (!lineas.isEmpty()) {
                String[] partes = lineas.get(0).split(",");
                if (partes.length == 2) {
                    MaximoNombre = partes[0].trim();
                    puntajeMaximo = Integer.parseInt(partes[1].trim());
                    System.out.println("puntaje maximo");
                    System.out.println(puntajeMaximo);
                } else {
                    puntajeMaximo = 0;
                }
            } else {
                puntajeMaximo = 0;
            }
        } catch (Exception e) {
            puntajeMaximo = 0;
        }
        System.out.println("puntaje maximo");
        System.out.println(puntajeMaximo);
        
        System.out.println("duenio");
        System.out.println(MaximoNombre );
    }

    /**
     * Devuelve una cadena con el nombre del jugador, su puntaje actual 
     * y su puntaje máximo.
     * 
     * @return Cadena con la información del puntaje.
     */
    public String mostrarPuntaje() {
        return "Jugador: " + nombreJugador +
               "\nPuntaje actual: " + puntajeActual +
               "\nPuntaje máximo: " + puntajeMaximo;
    }

    /**
     * Obtiene el puntaje actual del jugador.
     * 
     * @return Puntaje actual.
     */
    public int getPuntajeActual() {
        return puntajeActual;
    }

    /**
     * Obtiene el puntaje máximo del jugador.
     * 
     * @return Puntaje máximo.
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

    public String getNombreJugador() {
        return nombreJugador;
    }
    
    public String getMaximoNombre() {
        return MaximoNombre;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
    
    
    
    
}