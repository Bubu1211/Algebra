//integrantes: César Ricardo Lazcano Valdez, Jesus Cordova, Jesús Soto
//objetivo: Representar los números complejos, demostrando los conocimientos necesarios sobre el tema 
///aplicandolos en un programa en el lenguaje Java
package elementos.numeros;

import java.text.DecimalFormat;  ///librería para formatear números
import java.util.ArrayList;

//esta clase se encarga de representar objetos de números complejos
public class Complejo {

    private float a;  //representado por la letra a, la parte real del número complejo
    private float b; //representado por la letra b, es la parte imaginaria del número

    public Complejo(float a, float b) {
        this.a = a;
        this.b = b;
    }

    //se puede constuir un número complejo si se ingresa una cadena con su forma binomica
    public Complejo(String numero) {
        this.formarNumero(numero);
    }

    public Complejo() {
        this.a = 0.0f;
        this.b = 0.0f;
    }

    //Setters and getters
    
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

    /**@Return Retorna una cadena con la forma binómica de este número
     */
    public String getFormaBinomica() {

        ///Si a es 0 significa que no debe tener representación
        if (a == 0) {
            ///Si b es 1 y a 0 quiere decir que se tiene solo a i
            if (b == 1) {
                return "i";
            } else { ///EL caso contrario es que tenga valor b pero a no
                return formato(b) + "i";
            }
        } 
        ///Si a tiene valor diferente de 0 entonces b también podría valer 0
        else if (b == 0) {
            return formato(a); ///De ser así solo se debe representar la parte real
        } 
        ///En caso de que tyanto a como b tengan valor
        else {
            ///Si b es negativo se conserva el signo negativo 
            if (b < 0) {
                return formato(a) + "" + formato(b) + "i";
            } else {
                return formato(a) + "+" + formato(b) + "i";
            }
        }
    }

    /**
     * Representa las coordenadas en el plano de argand, unicamente en su representación
     * como cadena
     * @Return el par ordenado representante de este número complejo
     */
    public String getParOrdenado() {
        return "(" + formato(a) + "," + formato(b) + "i)";
    }

    /*Calcula el conjugado de este número complejo
    *El complemento de un N. complejo es el mismo con la parte imaginaria con signo contrario
    *la función solo aplica el complemento al número modificandolo
     */
    public String conjugado() {
        this.b = -this.b; //Se voltea obteniendo el reciproco
        return this.getFormaBinomica(); //Para voler a formarse 
    }

    /*Calcula el modulo de este número complejo 
    *el modulo es la magnitud del vector que representa el número complejo en 
    *el plano de Argand
     */
    public double modulo() {
        ///Por definición el modulo se obtiene del teorema de pitagoras  
        return Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2));
    }

    /*Función que dado otro número complejo retorna un número complejp 
    *cuyo valor es la suma de este y el dado
     */
    public Complejo suma(Complejo z2) {
        var z3 = new Complejo();

        z3.setA(this.getA() + z2.getA()); //una buena práctica es usar setter and getters
        z3.setB(this.getB() + z2.getB());

        return z3;
    }

    /*Función que dado otro número complejo retorna un número complejp 
    *cuyo valor es la resta de este y el dado
     */
    public Complejo resta(Complejo z2) {
        var z3 = new Complejo();

        z3.setA(this.getA() - z2.getA()); //una buena práctica es usar setter and getters
        z3.setB(this.getB() - z2.getB());

        return z3;
    }
    
    /**Función que calcula el producto de este número complejo y de 
     * otro que se pasa como argumento
     * @param z2
     */
    public Complejo producto(Complejo z2){
        Complejo z3 = new Complejo();
        
        z3.setA( this.getA() * z2.getA() + this.getB()*z2.getB()*-1);
        z3.setB(this.getA() * z2.getB() + this.getB()*z2.getA());
        
        return z3;
    }
    
    /**Función que calcula el valor del argumento de este número complejo
     * Determina en que cuadrante se encuenra, dependiendo del cuadrante en el que este
     * realiza la operación trigonométrica correspondiente
     * Se considera que el argumento solo se puede calcular cuando a y b son diferentes de 0
     * Dentro del cálculo se tiene que hacer la conversión de radianes a grados
     * @return el valor del ángulo que forma su vector
     */
    public double argumento(){
        double a = 0.0f;
        float ax = Math.abs(this.a);
        float bx = Math.abs(this.b);
        
        ///Primer cuadrante
        if(this.a > 0 && this.b > 0)
            a = Math.atan(bx/ax)* 180/Math.PI;
        
        ///Segundo cuadrante
        else if(this.a <0 && this.b > 0)
            a = 90 + (Math.atan(bx/ax) * 180/Math.PI);
        
        ///tercer cuadrante
        else if(this.a <0 && this.b < 0)
            a = 180 + (Math.atan(bx/ax) * 180/Math.PI);
        
        ///cuarto cuadrante
        else if(this.a > 0 && this.b < 0)
            a = 270 + (Math.atan(ax/bx)* 180/Math.PI);
        
        return a;
    }
    
    /**Se calcula la división entre dos Nímeros complejos donde este es el numerador 
     * y el parametro es el denominador
     * Primero se obtiene el conjugado de z2, luego se multiplican el numerador por el conjugadoZ2
     * al numero resultado su parte real es el número real del resultado del producto del numerador entre el numero real
     * del denominador
     */
    
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

    /**Función que obtiene el número complejo y sus partes a partir de una cadena 
     *          
     */
    public void formarNumero(String numero) throws NumberFormatException {
        Float a = null;
        Float b = null;
        String aux = "";
        if (numero.length() == 1) { //2
            if (numero.contains("i")) {
                b = 1f;
            } else {
                a = Float.parseFloat(numero);
            }
        } else if (numero.length() == 2) { //3
            if (numero.contains("i")) {
                if (Character.isDigit(numero.charAt(0))) {
                    b = Float.parseFloat(numero.substring(0, numero.indexOf("i")));
                } else {
                    b = -1f;
                }
            } else {
                a = Float.parseFloat(numero);
            }
        } else {
            var c = numero.toCharArray();
            for (int i = 0; i < c.length - 1; i++) {
                aux = aux + c[i];
                if (c[i + 1] == 'i') {
                    if (aux.equals("-") || aux.equals("+")) {
                        b = Float.parseFloat(aux+1);
                    } else {
                        b = Float.parseFloat(aux);
                    }
                    aux = "";
                } else if (c[i + 1] == '-' || c[i + 1] == '+') {
                    a = Float.parseFloat(aux);
                    aux = "";
                }
            }
        }

        this.a = a == null ? 0 : a;
        this.b = b == null ? 0 : b;
    }

}
