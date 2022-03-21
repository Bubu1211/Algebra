/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos.graficos.cuerpos;

import elementos.matrices.Matriz;

/**
 *
 * @author Bubu
 */
public abstract class Cuerpo {
    
    protected Matriz transformacion;
    protected Matriz posicion;
    protected int grosor;
    
    
    public int getGrosor(){
        return grosor;
    }
    
    public void setGrosor(int grosor){
        this.grosor = grosor;
    }
    
    protected void matrizRotacion(float angulo){ 
        transformacion = new Matriz(2, 2);
        transformacion.setValor(0, 0, (float) (Math.cos(angulo * Math.PI / 180))); 
        transformacion.setValor(1, 0, (float) (Math.sin(angulo * Math.PI / 180)));
        transformacion.setValor(0, 1, -1*(float) ((Math.sin(angulo * Math.PI / 180))));
        transformacion.setValor(1, 1, (float) (Math.cos(angulo * Math.PI / 180)));
    }
    
    protected void setPosicion(float x, float y){
        posicion = new Matriz(2, 1);
        posicion.setValor(0, 0, x);
        posicion.setValor(1, 0, y);
    }
    
    public abstract void rotar(float angulo);
}
