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
    private int puntajeActual;
    private int puntajeMaximo;
    private LectorArchivoTextoPlano lector;
    private EscritorArchivoTextoPlano escritor;
    private String archivoPuntajeMaximo;

    public Puntaje(String archivoPuntajeMaximo) {
        this.archivoPuntajeMaximo = archivoPuntajeMaximo;
        lector = new LectorArchivoTextoPlano();
        escritor = new EscritorArchivoTextoPlano("PuntajeMaximo.txt");
        cargarPuntajeMaximo();
    }

    public void incrementarPuntaje() {
        puntajeActual++;
    }

    public void guardarPuntajeMaximo() throws IOException {
        if (puntajeActual > puntajeMaximo) {
            puntajeMaximo = puntajeActual;
            ArrayList<String> datos = new ArrayList<>();
           datos.add("PUNTAJE_MAXIMO," + puntajeMaximo);
            escritor.escribir(datos);
        }
    }

    public void cargarPuntajeMaximo() {
            try {
            ArrayList<String> lineas = lector.leer(archivoPuntajeMaximo);
            if (!lineas.isEmpty()) {
                String[] partes = lineas.get(0).split(",");
                if (partes.length == 2) {
                    puntajeMaximo = Integer.parseInt(partes[1].trim());
                }
            }
        } catch (Exception e) {
            puntajeMaximo = 0; 
        }
    }
    public String mostrarPuntaje() {
            return "Puntaje actual: " + puntajeActual + ", Puntaje máximo: " + puntajeMaximo;
        }

        public int getPuntajeActual() {
            return puntajeActual;
        }

        public int getPuntajeMaximo() {
            return puntajeMaximo;
        }

        public void reiniciarPuntaje() {
            puntajeActual = 0;
        }
}
