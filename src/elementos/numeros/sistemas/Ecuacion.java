/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos.numeros.sistemas;

import java.util.ArrayList;

/**
 *
 * @author Bubu
 */
public class Ecuacion {
    
    private ArrayList<Termino> terminos;
    private float derecho;

    public Ecuacion() {
    }

    Ecuacion(String e) {
        formarEcuacion(e);
    }
    
    public int getNTerminos(){
        return terminos.size();
    }
    
    public void addTermino(Termino t){
        terminos.add(t);
    }
    
    public void addTermino(float coeficiente, String variable, float exponente){
        terminos.add(new Termino(coeficiente, variable, exponente));
    }
    
    public Termino getTermino(int i){
        return terminos.get(i);
    }
    
    @Override
    public String toString(){
        String ecuacion = "";
        for(Termino t : terminos){
            ecuacion += t.toString();
        }
        return ecuacion;
    }

    private void formarEcuacion(String e) {
        
    }
}
