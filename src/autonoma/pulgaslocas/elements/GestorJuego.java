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
     * Clase encargada de gestionar el flujo principal del juego, incluyendo el estado del juego,
     * interacción con el jugador, eventos del teclado y mouse, y control del puntaje.
     * 
     * @author Mateo Quintero <mateo.quinterom@autonoma.edu.co>
     * @version 1.0.0
     * @since 20250501
     * @see autonoma.pulgaslocas.elements.CampoDeBatalla
     */
    public class GestorJuego {

        /**
         * Indica si el juego está actualmente activo.
         */
        private boolean juegoActivo;

        /**
         * Campo de batalla donde ocurren los eventos del juego.
         */
        private CampoDeBatalla campo;

        /**
         * Sistema de puntuación del jugador.
         */
        private Puntaje puntaje;

        /**
         * Generador automático de pulgas.
         */
        private GeneradorPulgas generador;

        /**
         * Constructor de la clase GestorJuego.
         * 
         * @param juegoActivo Estado inicial del juego
         * @param campo       Campo de batalla
         * @param puntaje     Sistema de puntaje
         */
        public GestorJuego(boolean juegoActivo, CampoDeBatalla campo, Puntaje puntaje) {
            this.juegoActivo = juegoActivo;
            this.campo = campo;
            this.puntaje = puntaje;
            this.generador = new GeneradorPulgas(campo, 5000, 10000);
        }

        /**
         * Inicia el juego y comienza la generación automática de pulgas.
         */
        public void iniciarJuegos() {
            juegoActivo = true;
            generador.start();
        }

        /**
         * Finaliza el juego, deteniendo su actividad lógica.
         */
        public void terminarJuegos() {
            juegoActivo = false;
        }

        /**
         * Maneja eventos de teclado para generar pulgas, iniciar saltos o lanzar misiles.
         * 
         * @param e Evento de teclado
         * @throws IOException Si ocurre un error al lanzar el misil
         */
        public void manejareventoTeclado(KeyEvent e) throws IOException {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_P:
                    agregarPulga(false);
                    break;

                case KeyEvent.VK_M:
                    agregarPulga(true);
                    break;

                case KeyEvent.VK_S:
                    campo.getGenerador().start();
                    break;

                case KeyEvent.VK_SPACE:
                    campo.getJugador().LanzarMisil();
                    break;
            }
        }

        /**
         * Maneja el clic del mouse para realizar disparos hacia las coordenadas indicadas.
         * 
         * @param e Evento del mouse
         * @throws IOException Si ocurre un error durante el disparo
         */
        public void manejarClick(MouseEvent e) throws IOException {
            campo.getJugador().disparar(e.getX(), e.getY());
        }

        /**
         * Actualiza el estado de todos los elementos del campo.
         */
        public void actualizarEstado() {
            campo.actualizarEstado();
        }

        /**
         * Verifica si el juego está activo.
         * 
         * @return true si el juego está activo, false en caso contrario
         */
        public boolean isJuegoActivo() {
            return juegoActivo;
        }

        /**
         * Establece el estado del juego.
         * 
         * @param juegoActivo Nuevo estado del juego
         */
        public void setJuegoActivo(boolean juegoActivo) {
            this.juegoActivo = juegoActivo;
        }

        /**
         * Devuelve el campo de batalla actual.
         * 
         * @return Campo de batalla
         */
        public CampoDeBatalla getCampo() {
            return campo;
        }

        /**
         * Establece un nuevo campo de batalla.
         * 
         * @param campo Campo de batalla a establecer
         */
        public void setCampo(CampoDeBatalla campo) {
            this.campo = campo;
        }

        /**
         * Devuelve el sistema de puntaje actual.
         * 
         * @return Puntaje actual
         */
        public Puntaje getPuntaje() {
            return puntaje;
        }

        /**
         * Establece un nuevo sistema de puntaje.
         * 
         * @param puntaje Puntaje a establecer
         */
        public void setPuntaje(Puntaje puntaje) {
            this.puntaje = puntaje;
        }

        /**
         * Agrega una nueva pulga al campo de batalla en una posición aleatoria.
         * 
         * @param esMutante true si la pulga es mutante, false si es normal
         */
        public void agregarPulga(boolean esMutante) {
            int x = (int)(Math.random() * campo.getAncho());  
            int y = (int)(Math.random() * campo.getAlto());
            campo.agregarPulga(esMutante, x, y); 
        }

        /**
         * Elimina una pulga del campo de batalla y actualiza el puntaje.
         * 
         * @param pulga Pulga a eliminar
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
         * Muestra el puntaje actual como cadena de texto.
         * 
         * @return Puntaje formateado
         */
        public String mostrarPuntaje() {
            return puntaje.mostrarPuntaje();
        }

        /**
         * Reinicia el estado del juego, limpiando el campo y reiniciando el puntaje.
         */
        public void reiniciarJuego() {
            campo.reiniciarCampo();
            puntaje.reiniciarPuntaje();
        }

        /**
         * Dibuja todos los elementos del campo en pantalla.
         * 
         * @param g Objeto gráfico para dibujar
         */
        public void dibujarElementos(Graphics g) {
            campo.dibujar(g);
        }
    }

