/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.pulgaslocas.elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Heily Yohana Rios Ayala <heilyy.riosa@autonoma.edu.co>
 * @since 20250430
 * @version 1.0.0
 */

public interface Lector {
     /**
     * Lee el archivo
     * @param localizacionArchivo
     * @return Retorna un ArrayList de String que contiene cada línea del archivo como un elemento de la lista.
     * @throws IOException Si el archivo no existe
     */
    public abstract ArrayList<String> leer(String localizacionArchivo)
                                                    throws IOException;
    
}
