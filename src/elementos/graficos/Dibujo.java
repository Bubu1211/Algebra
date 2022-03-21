package elementos.graficos;

import elementos.graficos.cuerpos.*;
import java.awt.BasicStroke;
import java.util.ArrayList;

/**
 * @author Bubu
 */
public class Dibujo {

    private java.awt.Graphics2D g;
    private Point origen;
    private int pixeles; //Cantidad de pixeles que representan a la escala
    private float escala; ///número que representa  cada división del plano 

    public Dibujo(java.awt.Graphics2D g) {
        this.g = g;
    }

    public Dibujo(java.awt.Graphics2D g, Point origen) {
        this.g = g;
        this.origen = origen;
    }

    public Dibujo(java.awt.Graphics2D g, Point origen, float escala, int pixeles) {
        this.g = g;
        this.origen = origen;
        this.escala = escala;
        this.pixeles = pixeles;
    }

    public int getCoordenadaDigital(float coordenadaReal) {
        int c = 0;

        c = (int) ((coordenadaReal * (pixeles/escala)));

        return c;
    }

    public void paint(Cuerpo c) {
        if (c instanceof Linea) {
            Linea li = (Linea) c;
            if (li instanceof Eje) {
                Eje e = (Eje) c;
                paintEje(e);
            } else {
                paintLine(li);
            }
        } else if (c instanceof Poligono) {
            Poligono p = (Poligono) c;
            paintPolygon(p);
        }
    }

    private void paintLine(Linea linea) {
        
        g.setStroke(new BasicStroke(linea.getGrosor()));
        
        g.drawLine((int) origen.x + (getCoordenadaDigital(linea.getInicio().x)),
                (int) origen.y - (getCoordenadaDigital(linea.getInicio().y)),
                (int) origen.x + (getCoordenadaDigital(linea.getFin().x)),
                (int) origen.y - (getCoordenadaDigital(linea.getFin().y)));

    }

    private void paintEje(Eje eje) {
        g.setStroke(new BasicStroke(eje.getGrosor()));
        
        g.drawLine((int) eje.getInicio().x, (int) eje.getInicio().y,
                (int) eje.getFin().x, (int) eje.getFin().y);

    }

    private void paintPolygon(Poligono p) {
        ArrayList<Point> vertices = p.getVertices();
        Linea linea;
        Point a, b;
        for (int i = 0; i < vertices.size(); i++) {

            if (i == vertices.size() - 1) {
                a = vertices.get(i);
                b = vertices.get(0);
                linea = new Linea(a.x, a.y, b.x, b.y, p.getGrosor());
                paintLine(linea);
            } else {
                a = vertices.get(i);
                b = vertices.get(i + 1);
                linea = new Linea(a.x, a.y, b.x, b.y, p.getGrosor());
                paintLine(linea);
            }
        }
    }
}
