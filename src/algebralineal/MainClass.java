
package algebralineal;

import vista.Ventana;
import javax.swing.JFrame;

public class MainClass {
    public static void main(String[] args) {
        
//        //conteo de números
//        Matriz a = new Matriz(8,8);
//
//        a.llenadoAleatorio(20);
//        a.printConsole();
//        System.out.println("Conteo de cumulos de: 1 ");
//        System.out.println(a.conteoCumulos(1));
        
//        Graficacion de la simulación del brazo
        Ventana j = new Ventana();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);
        j.setBounds(0,0,800,600);
        j.setTitle("Lazcano César 4°1 ");
        j.setVisible(true);
//
//        obtener el tipo de la matriz
//        Matriz a = new Matriz(3,3);
//        a.ingresar();
//        a.printConsole();
//        System.out.println("Tipo de a: "+a.tiparMatriz());
//        
//          crear una matriz del tipo triangular superior e inferior
//        System.out.println("Ingrese el número de filas: ");
//        int filas = new java.util.Scanner(System.in).nextInt();
//        System.out.println("Ingrese el número de columnas: ");
//        int columnas = new java.util.Scanner(System.in).nextInt();
//        Matriz b = new Matriz(filas, columnas);
//        System.out.println("Matriz Triangular superior");
//        b.createMatrizTS();
//        b.printConsole();
//        System.out.println("Matriz Triangular Inferior");
//        b.createMatrizTI();
//        b.printConsole();
//        
//
//        Matriz a = new Matriz(2,1);
//        /coordenadas originales
//        a.setValor(0, 0, 3);
//        a.setValor(1, 0, 6);
//
//        Matriz de transformacion
//        float angulo = 100; ///ángulo de rotación
//        Matriz b = new Matriz(2,2);
//        b.setValor(0, 0, (float) (Math.cos(angulo * Math.PI / 180)));
//        b.setValor(1, 0, (float) (Math.sin(angulo * Math.PI / 180)));
//        b.setValor(0, 1, (float) (-1*(Math.sin(angulo * Math.PI / 180))));
//        b.setValor(1, 1, (float) (Math.cos(angulo * Math.PI / 180)));
//        
//
//        Matriz c = b.mul(a); ///Se realiza la multiplicación
//        
//        /Muestra la matriz que contiene las coordenadas 
//        System.out.println("Coordenada: ");
//        a.printConsole();
//        
//        /Muestra la matriz con los valores de transformación
//        System.out.println("Transformación: ");
//        b.printConsole();
//        
//        /Muestra las nuevas coordenadas
//        System.out.println("Nuevas coordenadas= ");
//        c.printConsole();
    }
}
