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
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    

    public int getGrosor() {
        return grosor;
    }

    public void setGrosor(int grosor) {
        this.grosor = grosor;
    }

    protected void matrizRotacion(float angulo) {
        transformacion = new Matriz(2, 2);
        transformacion.setValor(0, 0, (float) (Math.cos(angulo * Math.PI / 180)));
        transformacion.setValor(1, 0, (float) (Math.sin(angulo * Math.PI / 180)));
        transformacion.setValor(0, 1, -1 * (float) ((Math.sin(angulo * Math.PI / 180))));
        transformacion.setValor(1, 1, (float) (Math.cos(angulo * Math.PI / 180)));
    }

    protected void matrizEscala(float ex, float ey) {
        transformacion = new Matriz(3, 3);
        transformacion.setValor(0, 0, ex);
        transformacion.setValor(1, 1, ey);
        transformacion.setValor(2, 2, 1);
    }
    
    protected void matrizTraslacion(float dx, float dy) {
        transformacion = new Matriz(3, 3);
        transformacion.createMatrizIdentidad();
        transformacion.setValor(0, 2, dx);
        transformacion.setValor(1, 2, dy);
    }

    protected void setPosicion(float x, float y) {
        posicion = new Matriz(2, 1);
        posicion.setValor(0, 0, x);
        posicion.setValor(1, 0, y);
    }

    protected void setPosicion3(float x, float y) {
        posicion = new Matriz(3, 1);
        posicion.setValor(0, 0, x);
        posicion.setValor(1, 0, y);
        posicion.setValor(2, 0, 1);
    }

    public abstract void rotar(float angulo);
    public abstract void escalar(float ex, float ey);
    public abstract void trasladar(float dx, float dy);
}
