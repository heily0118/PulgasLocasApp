/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;


import autonoma.pulgaslocas.elements.SpriteMobile;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author Heily Yohana Rios Ayala <heilyy.riosa@gmail.com>
 * @since 20250430
 * @version 1.0.0
 */
   public abstract class Pulga extends SpriteMobile {

  
    protected int vida;            
    protected boolean estaviva;    
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

    /**
     * Método para que la pulga reciba impacto. Disminuye su vida y verifica si está muerta.
     */
    public void recibirImpacto() {
        sonidoPulga();
        this.vida--;
        if (this.vida <= 0) {
            this.estaviva = false;  
        }
    }

    /**
     * Método abstracto para mover la pulga.
     * Cada tipo de pulga (normal o mutante) implementará su propio comportamiento.
     */
    public abstract void mover();

   

    /**
     * @param g el objeto Graphics utilizado para dibujar la imagen de la pulga
     */
    public void dibujar(Graphics g) {
        if (estaviva) {
            g.drawImage(pulgaImage, x, y, null);  
        }
    }

    /**
     * Método para verificar si la pulga sigue viva.
     * 
     * @return true si la pulga está viva, false si está muerta
     */
    public boolean estaViva() {
        return this.estaviva;
    }
    
 
    public void sonidoPulga() {
        
        
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    getClass().getResource("/autonoma/PulgasLocas/sounds/dar-a-una-pulga.wav"));
            
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();                                                                                                                                                                                   
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    public void saltar(int anchoCampo, int altoCampo) {
        Random random = new Random();

       
        this.x = random.nextInt(anchoCampo - this.width);
        this.y = random.nextInt(altoCampo - this.height);
    }

    void actualizarEstado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}