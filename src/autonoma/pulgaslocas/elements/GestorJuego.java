/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 *
 * @author Mateo Quintero <mateo.quinterom@autonoma.edu.co>
 * @since 20250501
 * @see autonoma.pulgaslocas.elements
 * @version 1.0.0
 */
public class GestorJuego {

    private boolean juegoActivo;
    private CampoDeBatalla campo;
    private Puntaje puntaje;

    public GestorJuego(boolean juegoActivo, CampoDeBatalla campo, String archivoPuntajeMaximo) {
        this.juegoActivo = false;
        this.campo = campo;
        this.puntaje = new Puntaje(archivoPuntajeMaximo);
    }

    // Métodos

    public void iniciarJuegos() {
        juegoActivo = true;
    }

    public void terminarJuegos() {
        juegoActivo = false;
    }

    public void manejareventoTeclado(KeyEvent e) {
        switch (e.getKeyCode()) {
            // "p" - se crea pulga Normal
            case KeyEvent.VK_P:
                agregarPulga(false);  // Pulga normal
                break;

            // "m" - se crea pulga mutante
            case KeyEvent.VK_M:
                agregarPulga(true);   // Pulga mutante
                break;

            // "s" - para poner pulgas salten
            case KeyEvent.VK_S:
                campo.getGenerador().start();

                break;
        }
    }

    public void manejarClick(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        campo.getJugador().disparar(x, y);
    }

    public void actualizarEstado() {
        campo.actualizarEstado();
    }

   

    public boolean isJuegoActivo() {
        return juegoActivo;
    }

    public void setJuegoActivo(boolean juegoActivo) {
        this.juegoActivo = juegoActivo;
    }

    public CampoDeBatalla getCampo() {
        return campo;
    }

    public void setCampo(CampoDeBatalla campo) {
        this.campo = campo;
    }

    public Puntaje getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Puntaje puntaje) {
        this.puntaje = puntaje;
    }

   
    public void agregarPulga(boolean esMutante) {
        int x = (int)(Math.random() * campo.getAncho());  
        int y = (int)(Math.random() * campo.getAlto());
        campo.agregarPulga(esMutante,x,y); 
    }

  
    public void eliminarPulga(Pulga pulga) {
        campo.eliminarPulga(pulga);
        puntaje.incrementarPuntaje();
        try {
            puntaje.guardarPuntajeMaximo();
        } catch (IOException e) {
            System.err.println("Error al guardar el puntaje máximo: " + e.getMessage());
        }
    }

    public String mostrarPuntaje() {
        return puntaje.mostrarPuntaje();
    }

    public void reiniciarJuego() {
        campo.reiniciarCampo();
        puntaje.reiniciarPuntaje();
    }
    public void dibujarElementos(Graphics g){
        campo.dibujar(g);
    }
}
