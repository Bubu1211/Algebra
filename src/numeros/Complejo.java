//integrantes: César Ricardo Lazcano Valdez, Jesus Cordova, Jesús Soto
//objetivo: Representar los números complejos, demostrando los conocimientos necesarios sobre el tema 
///aplicandolos en un programa en el lenguaje Java

package numeros;

//esta clase se encarga de representar objetos de números complejos

import java.text.DecimalFormat;

public class Complejo {
    
    private float a;  //representado por la letra a, la parte real del número complejo
    private float b; //representado por la letra b, es la parte imaginaria del número

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
    
    public String getFormaBinomica(){
        
        if(b<0)
            return formato(a)+""+formato(b)+"i";
        else
            return formato(a)+"+"+formato(b)+"i";
    }
    
    public String getParOrdenado(){
        return "("+formato(a)+","+formato(b)+"i)";
    }
    
    //esta función tiene el objetivo de formatear las partes del número complejo dependiendo de si se trata de un número
    //entero o uno decimal
    private String formato(float x){
        String patron = "";
        if(x%1 == 0){
            patron = "#";
        }else{
            patron = "#.###";
        }
        DecimalFormat formato = new DecimalFormat(patron);
        return formato.format(x);
    }
}
