package elementos.numeros;

import java.text.DecimalFormat;

/**
 * @author Bubu
 */
public class Util {
    
    
    /**
     * Se calcula la división entre dos Nímeros complejos donde este es el
     * numerador y el parametro es el denominador Primero se obtiene el
     * conjugado de z2, luego se multiplican el numerador por el conjugadoZ2 al
     * numero resultado su parte real es el número real del resultado del
     * producto del numerador entre el numero real del denominador
     */
    //esta función tiene el objetivo de formatear las partes del número complejo dependiendo de si se trata de un número
    //entero o uno decimal
    public static String formato(float x) {
        String patron = "#.###";
        if (x % 1 == 0) {
            patron = "#";
        }
        DecimalFormat formato = new DecimalFormat(patron);
        return formato.format(x);
    }
    
    
}
