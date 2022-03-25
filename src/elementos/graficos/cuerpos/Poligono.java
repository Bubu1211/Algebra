package elementos.graficos.cuerpos;

import elementos.matrices.Matriz;
import java.util.ArrayList;
import java.util.Arrays;
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
        int i = 1; ///Para mostrar el ínidce del vertice
        for (Point e : vertices) {
            setPosicion(e.x, e.y);
            nvaPosicion = transformacion.mul(posicion);
            e.x = nvaPosicion.getValor(0, 0);
            e.y = nvaPosicion.getValor(1, 0);
            i++;
        }
    }

    @Override
    public void escalar(float ex, float ey) {
        Matriz nvaPosicion = new Matriz(3, 1);
        matrizEscala(ex, ey);
        int i = 1; ///Para mostrar el ínidce del vertice
        for (Point e : vertices) {
            setPosicion3(e.x, e.y);
            nvaPosicion = transformacion.mul(posicion);
            e.x = nvaPosicion.getValor(0, 0);
            e.y = nvaPosicion.getValor(1, 0);
            i++;
        }
    }

    @Override
    public void trasladar(float dx, float dy) {
        Matriz nvaPosicion = new Matriz(3, 1);
        matrizTraslacion(dx, dy);
        int i = 1; ///Para mostrar el ínidce del vertice
        for (Point e : vertices) {
            setPosicion3(e.x, e.y);
            nvaPosicion = transformacion.mul(posicion);
            e.x = nvaPosicion.getValor(0, 0);
            e.y = nvaPosicion.getValor(1, 0);
            i++;
        }
    }
    
}
