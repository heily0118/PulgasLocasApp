/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.util.ArrayList;

/**
 *
 * @author Heily Yohana Rios Ayala <heilyy.riosa@gmail.com>
 */
public abstract class SpriteContainer extends Sprite implements GraphicContainer{
    
     protected ArrayList<Sprite> sprites;   
    
    public SpriteContainer(int x, int y, int height, int width) {
        super(x, y, height, width);
        
        sprites = new ArrayList<Sprite>();
    }   
    
    public boolean add(Sprite sprite)
    {
        return sprites.add(sprite);
    }
    
    public void remove(int index)
    {
        sprites.remove(index);
    }

    public void remove(Sprite sprite)
    {
        sprites.remove(sprite);
    }
    
    public int size()
    {
        return sprites.size();
    }
    
}
