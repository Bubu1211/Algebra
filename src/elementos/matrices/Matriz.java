///César Ricardo Lazcano Valdez, Jonathan Rangel Gómez
package elementos.matrices;

import elementos.numeros.Util;
import elementos.tipos.TipoMatriz;
import java.util.ArrayList;

/**
 * @author César Ricardo Lazcano Valdez Clase que representa objetos de una
 * matriz y las operaciones que se pueden efectuar sobre ella
 */
public class Matriz {

    private float a[][];
    private int filas;
    private int columnas;
    private String size;
    private TipoMatriz tipo;

    public Matriz() {
        this.a = new float[0][0];
        this.filas = 0;
        this.columnas = 0;
        this.tipo = TipoMatriz.MatrizNula;
    }

    /**
     * Inicializa c
     */
    public Matriz(int filas, int columnas) {
        this();
        this.filas = filas;
        this.columnas = columnas;
        this.a = new float[filas][columnas];
        this.inicializar();
    }

    public Matriz add(Matriz b) {
        Float v = 0.0f;
        Matriz c = null;
        if (this.columnas == b.columnas && this.filas == b.filas) {
            c = new Matriz(filas, columnas);
            for (int f = 0; f < filas; f++) {
                for (int col = 0; col < columnas; col++) {
                    v = this.getValor(f, col) + b.getValor(f, col);
                    c.setValor(f, col, v);
                }
            }
        }
        return c;
    }

    public Matriz sub(Matriz b) {
        float v = 0.0f;
        Matriz c = null;
        if (this.columnas == b.columnas && this.filas == b.filas) {
            c = new Matriz(filas, columnas);
            for (int f = 0; f < filas; f++) {
                for (int col = 0; col < columnas; col++) {
                    v = this.getValor(f, col) - b.getValor(f, col);
                    c.setValor(f, col, v);
                }
            }
        }
        return c;
    }

    public Matriz mul(Matriz b) {

        if (this.columnas != b.filas) {
            return null;
        }

        Matriz c = new Matriz(b.filas, b.columnas);
        float sum = 0f;

        for (int fil = 0; fil < c.filas; fil++) {
            for (int col = 0; col < c.columnas; col++) {
                for (int i = 0; i < c.filas; i++) {
                    sum = sum + (this.getValor(fil, i) * b.getValor(i, col));
                }
                c.setValor(fil, col, sum);
                sum = 0f;
            }
        }

        return c;
    }

    public void setMatriz(float[][] x) {
        filas = x.length;
        columnas = x[0].length;

        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                setValor(f, c, x[f][c]);
            }
        }

    }

    public void setValor(int f, int c, float valor) {
        this.a[f][c] = valor;
    }

    public float getValor(int f, int c) {
        return this.a[f][c];
    }

    /**
     * Inicializa la matriz con valores 0
     */
    public void inicializar() {
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                this.a[f][c] = 0.0f;
            }
        }
    }

    public void llenadoAleatorio(int n) {
        int fila = 0, columna = 0;
        if (n < this.getNElementos()) {
            for (int i = 0; i < n; i++) {
                fila = (int) (Math.random() * filas);
                columna = (int) (Math.random() * columnas);
                if (this.a[fila][columna] == 1f) {
                    i--;
                } else {
                    this.a[fila][columna] = 1f;
                }
            }
        }
    }

    public Float[] valores() {
        ArrayList<Float> valores = new ArrayList<>();

        float valor = 0.0f;
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                valor = this.a[f][c];
                if (!valores.contains(valor)) {
                    valores.add(valor);
                }
            }
        }

        return (Float[]) valores.toArray();
    }

    private void vecino(int fila, int col, int filaProviene, int colProviene, float valor) {
        System.out.println("Vecino");

        ///Posición Superior 1
        if (fila != 0) {
            if (a[fila - 1][col] == valor) {
                a[fila - 1][col] = 0f;
                vecino(fila - 1, col, fila, col, valor);
            }
        }
        ///Posición izquierda
        if (col != 0) {
            if (a[fila][col - 1] == valor) {
                a[fila][col - 1] = 0f;
                vecino(fila, col - 1, fila, col, valor);
            }
        }

        ///Posición derecha 2
        if (col != columnas - 1) {
            if (a[fila][col + 1] == valor) {
                a[fila][col + 1] = 0f;
                vecino(fila, col + 1, fila, col, valor);
            }
        }

        ///Posición inferior 3
        if (fila != filas - 1) {
            if (a[fila + 1][col] == valor) {
                a[fila + 1][col] = 0f;
                vecino(fila + 1, col, fila, col, valor);
            }
        }

    }

    public int conteoCumulos(float valor) {

        int cumulos = 0; //va contando los cumulos

        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                if (a[f][c] == valor) {
                    a[f][c] = 0f;
                    vecino(f, c, f, c, valor);
                    cumulos++;
                }
            }
        }
        return cumulos;
    }

    public void ingresar() {
        float valor = 0.0f;
        java.util.Scanner sc = new java.util.Scanner(System.in);

        for (int f = 0; f < this.filas; f++) {
            for (int c = 0; c < this.columnas; c++) {
                System.out.println("Ingrese el valor de c[" + f + "][" + c + "] : ");
                valor = sc.nextFloat();
                this.a[f][c] = valor;
            }
        }
    }

    public void printConsole() {
        for (int f = 0; f < this.filas; f++) {
            for (int c = 0; c < this.columnas; c++) {
                System.out.print(Util.formato(a[f][c]) + " ");
            }
            System.out.println("");
        }
    }

    public String getSize() {
        this.size = this.filas + "x" + this.columnas;
        return this.size;
    }

    public int getNElementos() {
        return filas * columnas;
    }

    public boolean ingreso(javax.swing.JTextField[][] textos) {
        int filasTextos = textos.length;
        int columnasTextos = textos[0].length;
        boolean completado = false;
        float valor = 0.0f;

        for (int f = 0; f < filasTextos; f++) {
            for (int c = 0; c < columnasTextos; c++) {
                try {
                    valor = Float.parseFloat(textos[f][c].getText());
                    this.a[f][c] = valor;
                    completado = true;
                } catch (NumberFormatException e) {
                    completado = false;
                }
            }
        }
        return completado;
    }

    public TipoMatriz tiparMatriz() {

        if (filas == columnas) {
            this.tipo = TipoMatriz.MatrizCuadrada;
        } else if (filas == 1) {
            this.tipo = TipoMatriz.MatrizFila;
        } else if (columnas == 1) {
            this.tipo = TipoMatriz.MatrizColumna;
        }

        ///Matrices triangulares
        if (tipo == TipoMatriz.MatrizCuadrada) {
            boolean soloCero = true;

            ///Matriz Triangular superior
            for (int c = 0; c < columnas; c++) {
                for (int f = c + 1; f < filas; f++) {
                    if (getValor(f, c) != 0) {
                        soloCero = false;
                        break;
                    }
                }
            }

            ///Matriz Triangular Inferior y deterinar si si era superior
            if (soloCero) {
                tipo = TipoMatriz.MatrizTriangularSuperior;
                return tipo;
            } else {
                soloCero = true;
                for (int c = columnas - 1; c > 0; c--) {
                    for (int f = 0; f < c; f++) {
                        if (getValor(f, c) != 0) {
                            soloCero = false;
                            break;
                        }
                    }
                }
                if (soloCero) {
                    tipo = TipoMatriz.MatrizTriangularInferior;
                    return tipo;
                }
            }
        }

        return this.tipo;
    }

    public void createMatrizTI() {
        ///Matriz Triangular superior
        float aleatorio = 0.0f;
        clear();
        for (int c = 0; c < columnas; c++) {
            for (int f = c; f < filas; f++) {
                aleatorio = (int) (Math.random() * filas) + 1;
                setValor(f, c, aleatorio);
            }
        }
    }

    public void createMatrizTS() {
        int aleatorio = 0;
        clear();
        for (int c = columnas - 1; c >= 0; c--) {
            for (int f = 0; f <= c; f++) {
                aleatorio = (int) (Math.random() * filas) + 1;
                setValor(f, c, aleatorio);
            }
        }
    }

    public void clear() {
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                setValor(f, c, 0);
            }
        }
    }
}
