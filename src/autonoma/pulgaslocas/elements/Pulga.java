/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;


import autonoma.pulgaslocas.elements.SpriteMobile;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

import java.awt.Graphics;

/**
 * @author Heily Yohana Rios Ayala <heilyy.riosa@gmail.com>
 * @since 20250430
 * @version 1.0.0
 */
    public abstract class Pulga extends SpriteMobile{

        protected int vida;
        private boolean estaviva;
        protected Image pulgaImage; 

    public Pulga(int vida, boolean estaviva, Image pulgaImage, int x, int y, int height, int width) {
        super(x, y, height, width);
        this.vida = vida;
        this.estaviva = estaviva;
        this.pulgaImage = pulgaImage;
    }

 
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public boolean isEstaviva() {
        return estaviva;
    }

    public void setEstaviva(boolean estaviva) {
        this.estaviva = estaviva;
    }

    public Image getPulgaImage() {
        return pulgaImage;
    }

    public void setPulgaImage(Image pulgaImage) {
        this.pulgaImage = pulgaImage;
    }

 
    
    public void recibirImpacto(){
        this.vida--;
        if (this.vida <= 0) {
            this.estaviva = false;
        }

        
    }
    
    
    public void dibujar(Graphics g) {

        g.drawImage(pulgaImage, x, y, null);
    }

    public boolean estaViva() {
        return this.estaviva;
    }


}
