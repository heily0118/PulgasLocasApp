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
 * @see autonoma.pulgaslocas.elements.GestorJuego
 * @version 1.0.0
 */
public class GestorJuego {

    private boolean juegoActivo;
    private CampoDeBatalla campo;
    private Puntaje puntaje;
    private GeneradorPulgas generador;

    public GestorJuego(boolean juegoActivo, CampoDeBatalla campo, Puntaje puntaje) {
        this.juegoActivo = juegoActivo;
        this.campo = campo;
        this.puntaje = puntaje;
        campo.getGenerador().start();
    }

    // Métodos

    /**
     * Inicia el juego estableciendo la bandera 'juegoActivo' en verdadero
     * y comenzando la ejecución del generador de pulgas.
     */
    public void iniciarJuegos() {
        juegoActivo = true;
        generador.start();
    }

    /**
     * Termina el juego estableciendo la bandera 'juegoActivo' en falso.
     */
    public void terminarJuegos() {
        juegoActivo = false;
    }

    /**
     * Maneja los eventos de teclado para controlar la interacción del usuario con el juego.
     * 
     * @param e Es el evento de teclado.
     * @throws IOException Si ocurre un error al lanzar un misil o guardar puntaje.
     */
    public void manejareventoTeclado(KeyEvent e) throws IOException {
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
                 campo.saltarPulgas(); 

            break;
            
            // " SPACE " - Para activar el misl 
            case KeyEvent.VK_SPACE:
                campo.getJugador().LanzarMisil();

                break;
        }
    }

    /**
     * Maneja el evento de clic del mouse, permitiendo que el jugador dispare a la posición clickeada.
     * 
     * @param e Es el evento del mouse con las coordenadas del clic.
     * @throws IOException Si ocurre un error al ejecutar la acción de disparo.
     */
    public void manejarClick(MouseEvent e) throws IOException {
 
       
        campo.getJugador().disparar(e.getX(), e.getY());
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

   
    /**
     * Agrega una nueva pulga en una posición aleatoria dentro del campo.
     * 
     * @param esMutante Indica si la pulga es mutante (true) o normal (false).
     */
    public void agregarPulga(boolean esMutante) {
        int x = (int)(Math.random() * campo.getAncho());  
        int y = (int)(Math.random() * campo.getAlto());
        campo.agregarPulga(esMutante,x,y); 
    }

  
    /**
     * Elimina una pulga del campo, incrementa el puntaje y guarda el puntaje máximo.
     * 
     * @param pulga Es la pulga a eliminar.
     */
    public void eliminarPulga(Pulga pulga) {
        campo.eliminarPulga(pulga);
        puntaje.incrementarPuntajeNormal();
        try {
            puntaje.guardarPuntajeMaximo();
        } catch (IOException e) {
            System.err.println("Error al guardar el puntaje máximo: " + e.getMessage());
        }
    }

    /**
     * Muestra el puntaje actual del jugador.
     * 
     * @return Retorna una cadena que representa el puntaje actual.
     */
    public String mostrarPuntaje() {
        return puntaje.mostrarPuntaje();
    }

    /**
     * Reinicia el juego, limpiando el campo y restableciendo el puntaje.
     */
    public void reiniciarJuego() {
        campo.reiniciarCampo();
        puntaje.reiniciarPuntaje();
    }
    
    /**
     * Dibuja todos los elementos del campo de batalla en la interfaz gráfica.
      * 
     * @param g Es un objeto de tipo Graphics para pintar los elementos visuales.
     */
    public void dibujarElementos(Graphics g){
        campo.dibujar(g);
    }
}
