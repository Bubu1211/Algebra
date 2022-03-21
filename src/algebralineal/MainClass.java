
package algebralineal;

import elementos.graficos.PlanoCartesiano;
import elementos.matrices.Matriz;
import java.util.Scanner;
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
        PlanoCartesiano g = new PlanoCartesiano();
        JFrame j = new JFrame();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setBounds(0,0,500,500);
        j.getContentPane().add(g);
        j.setVisible(true);

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
//        Matriz a = new Matriz(2,1);
//        a.setValor(0, 0, 3);
//        a.setValor(1, 0, 6);
//
//        Matriz b = new Matriz(2,2);
//        b.setValor(0, 0, (float) (Math.cos(120 * Math.PI / 180)));
//        b.setValor(1, 0, (float) (Math.sin(120 * Math.PI / 180)));
//        b.setValor(0, 1, (float) (-1*(Math.sin(120 * Math.PI / 180))));
//        b.setValor(1, 1, (float) (Math.cos(120 * Math.PI / 180)));
//        
//
//        Matriz c = b.mul(a);
//        
//        System.out.println("A: ");
//        a.printConsole();
//        
//        System.out.println("B: ");
//        b.printConsole();
//        
//        System.out.println("C= ");
//        c.printConsole();
    }
}
