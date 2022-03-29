/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos.numeros.sistemas;

import  elementos.matrices.Matriz;
import java.util.ArrayList;

/**
 *
 * @author Bubu
 */
public class SistemaEcuaciones {
    
    private ArrayList<Ecuacion> ecuaciones;
    
    public void addEcuacion(Ecuacion e){
        ecuaciones.add(e);
    }
    
    public void addEcuacion(String e){
        Ecuacion ec = new Ecuacion(e);
        ecuaciones.add(ec);
    }
    
    /** 
     * Función que crea un sistema de ecuaciones LINEALES a partir de una matriz 
     */
    public void addMatriz(){
        
    }
    
    private int getNMaxVariables(){
        int max = ecuaciones.get(0).getNTerminos();
        
        for(Ecuacion e : ecuaciones){
            
        }
        
        return max;
    }
    
    /** 
     * Regresa la representación matricial ampliada de este sistema de ecuaciones 
     * solo si es de ecuaciones lineales
     */
    private Matriz setSistemaToMatriz(){
        for(Ecuacion e : ecuaciones){
            
        }
        return null;
    }
    
    public void gauss(){
        setSistemaToMatriz();
    }
}