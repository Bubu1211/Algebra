package elementos.graficos.cuerpos;

import elementos.matrices.Matriz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author Bubu
 */
public class Poligono extends Cuerpo {

    private final ArrayList<Point> vertices;

    public Poligono() {
        grosor = 0;
        vertices = new ArrayList<>();
    }

    public Poligono(int verts) {
        vertices = new ArrayList<>(verts);
    }

    public void add(Point... points) {
        vertices.addAll(Arrays.asList(points));
    }

    public void add(int x, int y) {
        vertices.add(new Point(x, y));
    }
    
    public ArrayList<Point> getVertices(){
        return this.vertices;
    }

    @Override
    public void rotar(float angulo) {

        Matriz nvaPosicion = new Matriz(2, 1);
        matrizRotacion(angulo);

        for (Point e : vertices) {
            System.out.println("V= "+e.x + ", "+e.y);
            setPosicion(e.x, e.y);
            nvaPosicion = transformacion.mul(posicion);
            e.x = nvaPosicion.getValor(0, 0);
            e.y = nvaPosicion.getValor(1, 0);
            System.out.println("V= "+e.x + ", "+e.y);
        }
    }
}
