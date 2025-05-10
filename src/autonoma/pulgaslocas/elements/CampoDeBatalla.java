/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import autonoma.pulgaslocas.exceptions.PosicionFueraDeLimitesException;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Representa el campo de batalla donde se desarrolla el juego con las pulgas.
 * 
 * En este campo se gestionan las pulgas (normales y mutantes), su posición,
 * su aparición a través del generador, y su representación gráfica.
 * 
 * @author Mateo Quintero <mateo.quinterom@autonoma.edu.co>
 * @version 1.0.0
 * @since 20250501
 * @see autonoma.pulgaslocas.elements
 */
public class CampoDeBatalla {

    /**
     * Ancho del campo de batalla.
     */
    private int ancho;

    /**
     * Alto del campo de batalla.
     */
    private int alto;

    /**
     * Lista de pulgas activas en el campo.
     */
    private ArrayList<Pulga> pulgas;

    /**
     * Generador automático de pulgas.
     */
    private GeneradorPulgas generador;

    /**
     * Jugador que participa en el campo de batalla.
     */
    private Jugador jugador;

    /**
     * Constructor de la clase CampoDeBatalla.
     * 
     * @param ancho    Ancho del campo
     * @param alto     Alto del campo
     * @param jugador  Jugador que interactúa en el campo
     */
    public CampoDeBatalla(int ancho, int alto, Jugador jugador) {
        this.ancho = ancho;
        this.alto = alto;
        this.pulgas = new ArrayList<>();
        this.jugador = jugador;
        this.generador = new GeneradorPulgas(this, 5000, 10000); 
        this.generador.start();
    }

    // Getters y Setters documentados de forma sencilla por su claridad

    /**
     * @return Ancho del campo.
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @return Alto del campo.
     */
    public int getAlto() {
        return alto;
    }

    /**
     * Establece el ancho del campo.
     * @param ancho Nuevo ancho.
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    /**
     * Establece el alto del campo.
     * @param alto Nuevo alto.
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }

    /**
     * Establece la lista de pulgas del campo.
     * @param pulgas Nueva lista de pulgas.
     */
    public void setPulgas(ArrayList<Pulga> pulgas) {
        this.pulgas = pulgas;
    }

    /**
     * Establece el generador de pulgas.
     * @param generador Nueva instancia del generador.
     */
    public void setGenerador(GeneradorPulgas generador) {
        this.generador = generador;
    }

    /**
     * @return Lista actual de pulgas.
     */
    public ArrayList<Pulga> getPulgas() {
        return pulgas;
    }

    /**
     * @return Generador de pulgas.
     */
    public GeneradorPulgas getGenerador() {
        return generador;
    }

    /**
     * @return Jugador asociado al campo.
     */
    public Jugador getJugador() {
        return jugador;
    }

    /**
     * Establece el jugador que participa en el campo.
     * @param jugador Nuevo jugador.
     */
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    /**
     * Agrega una nueva pulga al campo en la posición especificada si no colisiona.
     * 
     * @param esMutante Indica si la pulga es mutante
     * @param x         Posición X inicial
     * @param y         Posición Y inicial
     */
    public void agregarPulga(boolean esMutante, int x, int y) {
          if (x < 0 || x >= ancho || y < 0 || y >= alto) {
                throw new PosicionFueraDeLimitesException(); 
            }

            Pulga p;
            if (esMutante) {
                p = new PulgaMutante(2, true, null, x, y, 80, 80); 
            } else {
                p = new PulgaNormal(1, true, null, x, y, 80, 80); 
            }

            limiteDeMapa(p); 

            synchronized (pulgas) {
                if (!colisionaConOtrasPulgas(p)) {
                    pulgas.add(p);
                   Thread hilo = new Thread(p);
                   hilo.start(); 
                }
            }
    }

    /**
     * Verifica si una nueva pulga colisiona con alguna ya existente en el campo.
     * 
     * @param nuevaPulga Pulga a verificar
     * @return true si hay colisión, false si no
     */
    private boolean colisionaConOtrasPulgas(Pulga nuevaPulga) {
        for (Pulga pulga : pulgas) {
            // Evita comparar la pulga consigo misma
            if (pulga != nuevaPulga) {
                if (nuevaPulga.getX() < pulga.getX() + pulga.getWidth() &&
                nuevaPulga.getX() + nuevaPulga.getWidth() > pulga.getX() &&
                nuevaPulga.getY() < pulga.getY() + pulga.getHeight() &&
                nuevaPulga.getY() + nuevaPulga.getHeight() > pulga.getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Limita la posición de una pulga para que no se salga de los bordes del campo.
     * 
     * @param pulga Pulga a limitar
     */
    public void limiteDeMapa(Sprite pulga) {
        int posicionX = pulga.getX();
        int posicionY = pulga.getY();

        if (posicionX < 0) {
            pulga.setX(0);
        } else if (posicionX > 800 - pulga.getWidth()) {
            pulga.setX(800 - pulga.getWidth());
        }

        if (posicionY < 0) {
            pulga.setY(0);
        } else if (posicionY > 800 - pulga.getHeight()) {
            pulga.setY(800 - pulga.getHeight());
        }
    }

    /**
     * Elimina una pulga del campo de batalla.
     * 
     * @param p Pulga a eliminar
     */
    public void eliminarPulga(Pulga p) {
        pulgas.remove(p);
    }

    /**
     * Reinicia el campo eliminando todas las pulgas activas.
     */
    public void reiniciarCampo() {
        pulgas.clear();
    }

 
    

    /**
     * Dibuja el fondo del campo de batalla y todas las pulgas sobre él.
     * 
     * @param g Objeto Graphics utilizado para el dibujo
     */
    public void dibujar(Graphics g) {
        g.setColor(new Color(34, 139, 34));  
        g.fillRect(0, 0, ancho, alto); 
        
        ///cuando se dibuje las pulgas ellas se comienan a vomer
        synchronized (pulgas) {
            for (Pulga p : pulgas) {
                p.dibujar(g);
                
//              p.run();
            }
        }
    }
    
    /**
     * Método para hacer que las pulgas se reubiquen en cualquier posición, sin colisionarse unas pulgas con otras.
     */
    public void saltarPulgas() {
        synchronized (pulgas) {
            for (Pulga pulga : pulgas) {
                if (pulga.estaViva()) {
                    int intentos = 0;
                    final int MAX_INTENTOS = 10;
                    boolean saltoExitoso = false;

                    int posXOriginal = pulga.getX();
                    int posYOriginal = pulga.getY();

                    while (intentos < MAX_INTENTOS && !saltoExitoso) {
                        pulga.saltar(ancho, alto);

                        if (!colisionaConOtrasPulgas(pulga)) {
                            saltoExitoso = true;
                        } else {
                            intentos++;
                        }
                    }
                    
                    if (!saltoExitoso) {
                        pulga.setX(posXOriginal);
                        pulga.setY(posYOriginal);
                    }
                }
            }
        }
    }  
}
