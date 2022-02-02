package numeros;

/*
*integrantes: César Ricardo Lazcano Valdez, Jesus Cordova, Jesús Soto
*objetivo: Representar los números complejos, demostrando los conocimientos necesarios sobre el tema 
*aplicandolos en un programa en el lenguaje Java

*esta clase tiene el objetivo de representar a todos los números reales, enteros, negativos, punto flotante, etc.
*/

public class Real{
    
    /*
    
    */
    private class Valor<T>{
        
        private T valor;
        
        public Valor(){}
        
        public Valor(T valor){
            this.valor = valor;
        }
        
        public void setValor(T valor){
            this.valor = valor;
        }
        
        private T getValor(){
            //if this.valor instanceof Fraccion return this.valor.getValor() else
            return this.valor;
        }
    }
    
    private Valor valor;
    
    public Real(){
        this.valor = new Valor<>();
    }
    
    public Real(String real){
        
    }
    
    public Real(int numeroE){
        this.valor = new Valor<Integer>(numeroE);
    }
    
    public Real(float numeroF){
        this.valor= new Valor<Float>(numeroF);
    }
    
    public void setValor(int v){
        
    }
    
    public void setValor(float v){
        
    }
    
    public void setValor(String v){
        
    }
    
    public Object getValor(){
        return this.valor.getValor();
    }
    
}
