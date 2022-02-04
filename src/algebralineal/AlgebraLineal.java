//integrantes: César Ricardo Lazcano Valdez, Jesus Cordova, Jesús Soto
//objetivo: Representar los números complejos, demostrando los conocimientos necesarios sobre el tema 
///aplicandolos en un programa en el lenguaje Java

package algebralineal;

import vista.Ventana;

public class AlgebraLineal {

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
}
