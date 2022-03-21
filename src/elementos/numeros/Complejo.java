//integrantes: César Ricardo Lazcano Valdez, Jonathan
//objetivo: Representar los números complejos, demostrando los conocimientos necesarios sobre el tema 
///aplicandolos en un programa en el lenguaje Java
package elementos.numeros;

import java.text.DecimalFormat;  ///librería para formatear números

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

    /**
     * @return Retorna una cadena con la forma binómica de este número
     */
    public String getFormaBinomica() {

        ///Si a es 0 significa que no debe tener representación
        if (a == 0) {
            ///Si b es 1 y a 0 quiere decir que se tiene solo a i
            if (b == 1) {
                return "i";
            } else { ///EL caso contrario es que tenga valor b pero a no
                return Util.formato(b) + "i";
            }
        } ///Si a tiene valor diferente de 0 entonces b también podría valer 0
        else if (b == 0) {
            return Util.formato(a); ///De ser así solo se debe representar la parte real
        } ///En caso de que tyanto a como b tengan valor
        else {
            ///Si b es negativo se conserva el signo negativo 
            if (b < 0) {
                return Util.formato(a) + "" + Util.formato(b) + "i";
            } 
            else {
                return Util.formato(a) + "+" + Util.formato(b) + "i";
            }
        }
    }

    /**
     * Representa las coordenadas en el plano de argand, unicamente en su
     * representación como cadena
     *
     * @return el par ordenado representante de este número complejo
     */
    public String getParOrdenado() {
        return "(" + Util.formato(a) + "," + Util.formato(b) + "i)";
    }

    /*12/02/22
    *Calcula el conjugado de este número complejo
    *El complemento de un N. complejo es el mismo con la parte imaginaria con signo contrario
    *la función solo aplica el complemento al número modificandolo
    *25/02/22
    *Se cambia la implementacion del método, ahora regresa un número complejo
    *que representa el conujugado de este númer SIN AFECTAR a este número
    */
    public Complejo conjugado() {
        return new Complejo(this.getA(), -this.getB());
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
    public Complejo add(Complejo z2) {
        Complejo z3 = new Complejo();

        z3.setA(this.getA() + z2.getA()); //una buena práctica es usar setter and getters
        z3.setB(this.getB() + z2.getB());

        return z3;
    }

    /*Función que dado otro número complejo retorna un número complejp 
    *cuyo valor es la resta de este y el dado
     */
    public Complejo sub(Complejo z2) {
        Complejo z3 = new Complejo();

        z3.setA(this.getA() - z2.getA()); //una buena práctica es usar setter and getters
        z3.setB(this.getB() - z2.getB());

        return z3;
    }

    /**
     * Función que calcula el producto de este número complejo y de otro que se
     * pasa como argumento
     *
     * @param z2 otro objeto número complejo que representa el segundo factor
     * del producto
     * @return Un número complejo z3 que es el resultado del producto
     */
    public Complejo mul(Complejo z2) {
        Complejo z3 = new Complejo();

        z3.setA(this.getA() * z2.getA() - this.getB() * z2.getB());
        z3.setB(this.getA() * z2.getB() + this.getB() * z2.getA());

        return z3;
    }

    /**
     * Retorna un número complejo cuyo resultado es la división de este NC entre
     * el segundo NC que se manda como parámetro
     *
     * @param z2 otro número complejo que representa el denominador
     * @return un número complejo con el z resultado
     */
    public Complejo div(Complejo z2) {
        Complejo o = new Complejo(z2.a, z2.b);
        z2.conjugado();
        Complejo x = this.mul(z2);
        Complejo y = o.mul(z2);
        z2.conjugado();
        return new Complejo(x.a / y.a, x.b / y.a);
    }

//    public float sqrt(int m){
//        
//    }
    public float im() {
        return this.getB();
    }

    public void pow(int n) {
        Complejo aux;
        Complejo aux1 = new Complejo(this.getA(), this.getB());
        for (int i = 1; i < n; i++) {
            aux = this.mul(aux1);
            this.setA(aux.getA());
            this.setB(aux.getB());
        }
    }
    
    public void raices(int n){
        
    }

    /**
     * Función que calcula el valor del argumento de este número complejo
     * Determina en que cuadrante se encuenra, dependiendo del cuadrante en el
     * que este realiza la operación trigonométrica correspondiente Se considera
     * que el argumento solo se puede calcular cuando a y b son Sdiferentes de 0
     * Dentro del cálculo se tiene que hacer la conversión de radianes a grados
     *
     * @return el valor del ángulo que forma su vector
     */
    public double argumento() {
        double x = 0.0f;
        float ax = Math.abs(this.a);
        float bx = Math.abs(this.b);

        ///Primer cuadrante
        if (this.a > 0 && this.b > 0) {
            x = Math.atan(bx / ax) * 180 / Math.PI;
        } ///Segundo cuadrante
        else if (this.a < 0 && this.b > 0) {
            x = 90 + (Math.atan(ax / bx) * 180 / Math.PI);
        } ///tercer cuadrante
        else if (this.a < 0 && this.b < 0) {
            x = 180 + (Math.atan(bx / ax) * 180 / Math.PI);
        } ///cuarto cuadrante
        else if (this.a > 0 && this.b < 0) {
            x = 270 + (Math.atan(ax / bx) * 180 / Math.PI);
        }
        return x;
    }


    /**
     * Función que obtiene el número complejo y sus partes a partir de una
     * cadena Formar un número complejo desde una cadena 1.	Definir una cadena
     * auxiliar aux y dos flotantes a y b 2.	Si el tamaño de la cadena es 1 a.
     * Si la cadena contiene “i” i.	b = 1.0 b.	sino i.	a = convertir toda la
     * cadena a flotante 3.	Sino si el tamaño de la cadena es 2 a.	Si el numero
     * contiene a “i” i.	Is el el primer carácter de la cadena es un número 1.	B
     * = convertir la subcadena que va desde el inicio de la cadena hasta donde
     * se encuentre i ii.	Sino 1.	B = -1f 4.	Sino a.	Guardar la cadena en un
     * arreglo de caracteres c b.	Por cada carácter en c i.	Aux = aux + c en
     * posición i ii.	Si en la siguiente posición de c (i+1) hay un “i” 1.	Si
     * aux es igual a “-“ o es igual a “+” a.	B = convertir aux +1 2.	Sino a.	B
     * = convertir solo aux iii.	Si no, si en el siguiente carácter se tiene a
     * “-“ o a “+” 1.	A =convertir aux 2.	Aux se reinicia como cadena vacía 5.
     * Si a es nulo entonces a del NC = 0 Sino entonces a del NC = a 6.	Si b es
     * nulo entonces b del NC = 0 Sino entonces b del NC = b
     *
     */
    private void formarNumero(String numero) throws NumberFormatException {
        Float ax = null;
        Float bx = null;
        String aux = "";
        if (numero.length() == 1) {
            //2
            if (numero.contains("i")) {
                bx = 1f;
            } else {
                ax = Float.parseFloat(numero);
            }
        }
        if (numero.length() == 1) {
            //3
            if (numero.contains("i")) {
                if (Character.isDigit(numero.charAt(0))) {
                    bx = Float.parseFloat(numero.substring(0, numero.indexOf("i")));
                } else {
                    bx = -1f;
                }
            } else {
                ax = Float.parseFloat(numero);
            }
        } else {
            char[] c = numero.toCharArray();
            for (int i = 0; i < c.length - 1; i++) {
                aux = aux + c[i];
                if (c[i + 1] == 'i') {
                    if (aux.equals("-") || aux.equals("+")) {
                        bx = Float.parseFloat(aux + 1);
                    } else {
                        bx = Float.parseFloat(aux);
                    }
                    aux = "";
                } else if (c[i + 1] == '-' || c[i + 1] == '+') {
                    ax = Float.parseFloat(aux);
                    aux = "";
                }
            }
        }
        this.a = ax == null ? 0 : ax;
        this.b = bx == null ? 0 : bx;
    }


}
