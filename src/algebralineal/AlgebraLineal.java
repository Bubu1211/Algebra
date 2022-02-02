//integrantes: César Ricardo Lazcano Valdez, Jesus Cordova, Jesús Soto
//objetivo: Representar los números complejos, demostrando los conocimientos necesarios sobre el tema 
///aplicandolos en un programa en el lenguaje Java

package algebralineal;

import javax.swing.JOptionPane;
import numeros.Complejo;

public class AlgebraLineal {

    public static void main(String[] args) {
        
        ///Pedimos al usuario la entrada de los números y lo guardamos en un string
        String nReal = JOptionPane.showInputDialog(null, "Ingrese la parte real", "Número complejo",
                JOptionPane.QUESTION_MESSAGE);
                
        String nImaginario = JOptionPane.showInputDialog(null, "Ingrese la parte imaginaria", "Número complejo",
                JOptionPane.QUESTION_MESSAGE);
        
        try{
            Complejo z = new Complejo(); ///Se crea un número complejo
            ///Se asignan los valores del número real y de la parte imaginaria
            z.setA(Float.parseFloat(nReal));
            z.setB(Float.parseFloat(nImaginario));
            //Se muestra en un cuadro de diálogo con la representación binómica y el par ordenado
            JOptionPane.showMessageDialog(null, "Forma Binómica: "+z.getFormaBinomica() + "\nPar Ordenado: "+z.getParOrdenado(),
                    "Número Complejo", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error, tal vez ingreso letras en lugar de números", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
