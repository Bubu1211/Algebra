package elementos.numeros.sistemas;

import elementos.numeros.Util;

/**
 * @author Bubu
 */
public class Termino {

    private float coeficiente;
    private String variable;
    private float exponente;

    public Termino() {
    }

    public Termino(float coeficiente, String variable, float exponente) {
        this.coeficiente = coeficiente;
        this.variable = variable;
        this.exponente = exponente;
    }

    public float c() {
        return coeficiente;
    }

    public void setC(float coeficiente) {
        this.coeficiente = coeficiente;
    }

    public String v() {
        return variable;
    }

    public void setV(String variable) {
        this.variable = variable;
    }

    public float e() {
        return exponente;
    }

    public void setE(float exponente) {
        this.exponente = exponente;
    }

    @Override
    public String toString() {
        if (exponente == 1) {
            return Util.formato(coeficiente) + variable;
        } else {
            return Util.formato(coeficiente) + variable + "^" + Util.formato(exponente);
        }
    }

}
