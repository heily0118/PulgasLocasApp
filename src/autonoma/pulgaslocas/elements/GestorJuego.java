/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

<<<<<<< HEAD
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
=======
/**
 *
 * @author Mateo Quintero <mateo.quinterom@autonoma.edu.co>
 * @since 20250501
 * @see autonoma.pulgaslocas.elements.GestorJuego
 * @version 1.0.0
 */
public class GestorJuego {
>>>>>>> 0e0e2d7dd6a1bcebf767375bfd5914036c6653be

        /**
         * Indica si el juego está actualmente activo.
         */
        private boolean juegoActivo;

<<<<<<< HEAD
        /**
         * Campo de batalla donde ocurren los eventos del juego.
         */
        private CampoDeBatalla campo;
=======
    public GestorJuego(boolean juegoActivo, CampoDeBatalla campo, Puntaje puntaje) {
        this.juegoActivo = juegoActivo;
        this.campo = campo;
        this.puntaje = puntaje;
        campo.getGenerador().start();
    }
>>>>>>> 0e0e2d7dd6a1bcebf767375bfd5914036c6653be

        /**
         * Sistema de puntuación del jugador.
         */
        private Puntaje puntaje;

<<<<<<< HEAD
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
=======
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
>>>>>>> 0e0e2d7dd6a1bcebf767375bfd5914036c6653be

        /**
         * Finaliza el juego, deteniendo su actividad lógica.
         */
        public void terminarJuegos() {
            juegoActivo = false;
        }

<<<<<<< HEAD
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
=======
            // "s" - para poner pulgas salten
            case KeyEvent.VK_S:
                 campo.saltarPulgas(); 
>>>>>>> 0e0e2d7dd6a1bcebf767375bfd5914036c6653be

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

<<<<<<< HEAD
=======
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
>>>>>>> 0e0e2d7dd6a1bcebf767375bfd5914036c6653be
