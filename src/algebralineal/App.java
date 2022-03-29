package algebralineal;

import elementos.matrices.Matriz;

/**
 *
 * @author Bubu
 */
public class App {
    public static void main(String[] args) {
         
////        Graficacion de la simulación del brazo
//        vista.Ventana j;
//        j = new vista.Ventana();
//        j.setLocationRelativeTo(null);
//        j.setBounds(0,0,800,600);
//        j.setTitle("Lazcano César 4°1 ");
//        j.setVisible(true);
        

          Matriz sistema = new Matriz(3,4);
          sistema.ingresar();
          sistema.printConsole();
          float[] soluciones = sistema.gauss();
          
          for(int i = 0; i<soluciones.length;i++){
              System.out.println("soluciones[i] = " + soluciones[i]);
          }
          
          sistema.printConsole();
    }    
}
