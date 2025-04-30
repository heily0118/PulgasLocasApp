package autonoma.pulgaslocas.elements;

import java.util.ArrayList;

/**
 * 
 * @author Heily Yohana Rios Ayala <heilyy.riosa@gmail.com>
 * @since 20250430
 * @version 1.0.0
 */
public abstract class SpriteContainer extends Sprite implements GraphicContainer {
    
    /**
     * Lista de sprites contenidos en este contenedor.
     */
    protected ArrayList<Sprite> sprites;

    /**
     * Constructor que inicializa el contenedor con su posición y tamaño.
     *
     * @param x coordenada horizontal del contenedor
     * @param y coordenada vertical del contenedor
     * @param height alto del contenedor
     * @param width ancho del contenedor
     */
    public SpriteContainer(int x, int y, int height, int width) {
        super(x, y, height, width);
        sprites = new ArrayList<>();
    }

    /**
     * Agrega un sprite al contenedor.
     *
     * @param sprite sprite a agregar
     * @return true si fue agregado correctamente
     */
    public boolean add(Sprite sprite) {
        return sprites.add(sprite);
    }

    /**
     * Elimina el sprite que se encuentra en la posición dada.
     *
     * @param index índice del sprite a eliminar
     */
    public void remove(int index) {
        sprites.remove(index);
    }

    /**
     * Elimina un sprite específico del contenedor.
     *
     * @param sprite sprite a eliminar
     */
    public void remove(Sprite sprite) {
        sprites.remove(sprite);
    }

    /**
     * Retorna la cantidad de sprites actualmente en el contenedor.
     *
     * @return número de sprites
     */
    public int size() {
        return sprites.size();
    }
}
