//integrantes: César Ricardo Lazcano Valdez, Jesus Cordova, Jesús Soto
//objetivo: Representar los números complejos, demostrando los conocimientos necesarios sobre el tema 
///aplicandolos en un programa en el lenguaje Java
package elementos;

import java.text.DecimalFormat;  ///librería para formatear números

//esta clase se encarga de representar objetos de números complejos
public class Complejo {

    private float a;  //representado por la letra a, la parte real del número complejo
    private float b; //representado por la letra b, es la parte imaginaria del número
    
    public Complejo(float a, float b){
        this.a = a;
        this.b = b;
    }
    
    public Complejo(String numero){
        this.formarNumero(numero);
    }
    
    public Complejo(){}

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public String getFormaBinomica() {

        if (b < 0) {
            return formato(a) + "" + formato(b) + "i";
        } else {
            return formato(a) + "+" + formato(b) + "i";
        }
    }

    public String getParOrdenado() {
        return "(" + formato(a) + "," + formato(b) + "i)";
    }

    /*Calcula el conjugado de este número complejo
    *El complemento de un N. complejo es el mismo con la parte imaginaria con signo contrario
    *la función solo aplica el complemento al número modificandolo
     */
    public String complemento() {
        this.b = -this.b;
        return this.getFormaBinomica();
    }

    /*Calcula el modulo de este número complejo 
    *el modulo es la magnitud del vector que representa el número complejo en 
    *el plano de Argand
     */
    public double modulo() {
        ///Por definición el modulo se obtiene del teorema de pitagoras  
        return Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2));
    }

    //esta función tiene el objetivo de formatear las partes del número complejo dependiendo de si se trata de un número
    //entero o uno decimal
    private String formato(float x) {
        String patron = "";
        if (x % 1 == 0) {
            patron = "#";
        } else {
            patron = "#.###";
        }
        DecimalFormat formato = new DecimalFormat(patron);
        return formato.format(x);
    }

    /*Función que obtiene el número complejo y sus partes a partir de una cadena 
     */
    public void formarNumero(String numero) throws NumberFormatException {
        ///Se obtienen los índices de posición en la cadena donde aparece el signo 
        ///Primero se obtiene el último indice donde aparece el signo de más
        int indiceA = numero.lastIndexOf("+");

        if (indiceA == -1) { ///Si se tiene el valor de -1 es que no hay el signo más
            indiceA = numero.lastIndexOf("-"); ///Se obtiene entonces el índice del signo menos
        }

        ///Se convierte la subcadena que va desde el principio hasta donde aparece el signo
        this.a = Float.parseFloat(numero.substring(0, indiceA));
        ///Se convierte el número de la subcadena que va desde el índice del signo hasta justo antes de la letra i
        this.b = Float.parseFloat(numero.substring(indiceA, numero.indexOf("i")));
    }
}
