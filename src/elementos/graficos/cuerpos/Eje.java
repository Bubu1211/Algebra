/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos.graficos.cuerpos;

import java.awt.Point;

/**
 *
 * @author Bubu
 */
public class Eje extends Linea{
    
    
    public Eje(float x1, float y1, float x2, float y2) {
        super( x1,  y1, x2, y2);
    }

    public Eje(float x1, float y1, float x2, float y2, int grosor) {

        super(x1, y1, x2, y2, grosor);
    }
}
