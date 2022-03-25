package elementos.graficos.cuerpos;

import elementos.matrices.Matriz;

/**
 * @author Bubu
 */
public class Linea extends Cuerpo {

    protected Point inicio;
    protected Point fin;

    public Linea(float x1, float y1, float x2, float y2) {
        this.grosor = 0;
        inicio = new Point(x1, y1);
        fin = new Point(x2, y2);
    }

    public Linea(float x1, float y1, float x2, float y2, int grosor) {

        this(x1, y1, x2, y2);
        this.grosor = grosor;
    }
    
    public Point getInicio(){
        return inicio;
    }
    
    public Point getFin(){
        return fin;
    }
    
    public void setLine(float x1, float y1, float x2, float y2){
        inicio = new Point(x1, y1);
        fin = new Point(x2, y2);
    }


    @Override
    public void rotar(float angulo) {
        
        

        matrizRotacion(angulo); 
        setPosicion(fin.x, fin.y);
        
        Matriz c = transformacion.mul(posicion);

        fin.x = (int) c.getValor(0, 0);
        fin.y = (int) c.getValor(1, 0);
        
        
        setPosicion(inicio.x, inicio.y);
        
        c = transformacion.mul(posicion);

        inicio.x = (int) c.getValor(0, 0);
        inicio.y = (int) c.getValor(1, 0);
    }

    @Override
    public void escalar(float dx, float dy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void trasladar(float dx, float dy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
