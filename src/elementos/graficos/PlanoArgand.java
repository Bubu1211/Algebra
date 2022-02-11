//integrantes: César Ricardo Lazcano Valdez, Jonathan
//objetivo: Representar los números complejos, demostrando los conocimientos necesarios sobre el tema 
///aplicandolos en un programa en el lenguaje Java

package elementos.graficos;

import elementos.numeros.Complejo;
import java.awt.Graphics;
import java.awt.Point;

/**Esta clase tiene el objetivo de representar el plano de Argand a través d la librería Grpahics
 * Dibujar se refiere al acto de realizar la graficacion por computadora con la lib java.awt.Graphics
 */
public class PlanoArgand extends javax.swing.JPanel {

    private int anchoPlano;
    private int altoPlano;
    private int unidad;
    ///Representan el valor de sus ejes en esas posiciones
    ///Es decir, xp es la cantidad de unidades hacia el eje x positivo
    private int xp, xn, yp, yn;
    private Point puntoSI;
    private Point puntoSD;
    private Point puntoII;
    private Point puntoID;
    private Complejo z; ///Es el número complejo que se va a gráficar 
    private boolean graficarArgumento; //Indica si se dibuja o no el argumento
    private double argumento;D
    
    public PlanoArgand() {
        initComponents();
        setBounds(0,0,500,400);
        ///Se obtiene el ancho y el alto del plano usando el ancho y alto del JPanel
        this.anchoPlano = this.getWidth()-40;
        this.altoPlano = this.getHeight()-40;
        //se crean cuatro puntos que son las esquinas del plano cartesiano o de Argand
        this.puntoSI = new Point(20, 20);
        this.puntoSD = new Point(this.getWidth()-20, 20);
        this.puntoII = new Point(20, this.getHeight()-20);
        this.puntoID = new Point(this.getWidth()-20, this.getHeight()-20);
        this.unidad = 0;
        xn = xp = yn = yp = 0;
        this.z = null;
        this.graficarArgumento = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Plano Argand");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(218, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(210, 210, 210))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 384, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**Este método sobreescrito realiza los dibujos, con el método repaint se vuelve a llamar
     * Con ayuda de la clase Point quye básicamente es una clase que representa un par ordenado, se 
     * representan los puntos necesarios
     * Algoritmo seguido para graficar
     * 1 Se obtienen las coordenadas de las esquinas
     * 2 se obtiene el valor de la unidad representativa 
     * 3 se obtiene el punto de origen en base a xp, xn, yp, yn
     * 4 se dibujan las líneas que representan a los ejes en sus valores + y -
     * 5 Se Obtiene el punto que representa el par ordenado de z
     * 6 se dibuja una línea desde el oprigen hasta el punto z 
     */
    //Point inicio, Point fin
    @Override
    public void paint(Graphics g){
        super.paint(g);
        if(xp == 0 && xn == 0 && yn == 0 && yp == 0)  ///Enc aso de no haber iniciado un plano se crea uno 
            xp = xn=yp=yn = 5;
        Point origen = null; //Representa el origen del plano de argand
        
        //Obtenemos la representación en pixeles de una unidad en este plano
        try{//Puede presentar errors si no se han asignado valores a las distancias en x & y
            if(yp == 0 && yn == 0){
                this.unidad = this.anchoPlano/(Math.abs(xp)+Math.abs(xn));
            }else{
                this.unidad = this.altoPlano/(Math.abs(yp)+Math.abs(yn));
            }
        }catch(ArithmeticException e){
            this.unidad = 0;
        }
        
        ///En caso de que unidad sea diferente a 0, es decir, tengamos un plano por gráficar, se realizan las líneass
        if(unidad != 0){
            ///Se obtiene el punto de origen del plano usando la unidad obtenida
            origen = new Point(puntoSI.x + (unidad*Math.abs(xn)), puntoSI.y + (unidad*yp));
        }
        g.setColor(java.awt.Color.BLACK);
        ///Se dibuja el eje de las abscisas negativo -x
        g.drawLine(origen.x, origen.y, puntoSI.x, origen.y);
        ///Se dibuja el eje de las abscisas positivo +x
        g.drawLine(origen.x, origen.y, puntoSD.x, origen.y);
        ///Se dibuja el eje de las ordenadas negativo -y
        g.drawLine(origen.x, origen.y, origen.x, puntoII.y);
        ///Se dibuja el eje de las ordenadas positivo +y
        g.drawLine(origen.x, origen.y, origen.x, puntoSD.y);
        
        g.setColor(java.awt.Color.DARK_GRAY);
        ///Se dibuja el vector representativo de z
        if(z != null){ ///si el número complejo tiene valor asignado se dibuja
            ///Se dibuja una línea desde el origen hacia el par ordenado de z
            var puntoZ = new Point(origen.x + (unidad*(int)z.getA()),origen.y- (unidad*(int)z.getB()));
            g.drawLine(origen.x, origen.y, puntoZ.x, puntoZ.y);
            g.drawString(z.getParOrdenado(), puntoZ.x, puntoZ.y);
        }
        
        g.setColor(java.awt.Color.BLUE);
        /*Dibujamos las representaciones de las unidades en el plano
        *En esencia son líneas perpendiculares a los ejes, el punto x y y es igual al origen solo se van agregando 
        *]la cantidad de unidades que debe contener el plano
        */
        //línes de unidades del eje x positivo
        int sum = 0;
        for(int i = 1; i<= xp; i++){
            sum = unidad * i; //Obtiene la unidad desplazada que se va a recorrer
            g.drawLine(origen.x + sum, puntoSD.y, origen.x + sum, puntoID.y); //dibuja la línea perpendicular
            g.drawString(i+"", origen.x + sum, origen.y+20); //dibuja el número en su correspondiente lugar
        }
        ///linea de unidades del eje x negativo 
        sum = 0;
        for(int i = 1; i<=Math.abs(xn); i++){
            sum = unidad*i;
            g.drawLine(origen.x - sum, puntoID.y, origen.x - sum, puntoSD.y);
            g.drawString("-"+i, origen.x - sum, origen.y+20); //dibuja el número en su correspondiente lugar
        }
        ///Líneas de unidades del eje y positivo
        sum = 0;
        for(int i = 1; i<=yp; i++){
            sum = unidad*i;
            g.drawLine(puntoSI.x, origen.y- sum, puntoSD.x, origen.y- sum);
            g.drawString(i+"i", origen.x -30, origen.y- sum+10); //dibuja el número en su correspondiente lugar
        }
        ///Lineas de unidades del eje y negativo
        sum = 0;
        for(int i = 1; i<=Math.abs(yn); i++){
            sum = unidad*i;
            g.drawLine(puntoII.x , origen.y+sum, puntoID.x, origen.y+sum);
            g.drawString("-"+i+"i",origen.x - 20, origen.y+sum+10); //dibuja el número en su correspondiente lugar
        }
        
        g.setColor(java.awt.Color.BLACK);
        if(graficarArgumento){
            g.drawArc(origen.x-75, origen.y-75, 150, 150, 0, (int)this.argumento);
        }
    }

    public void dibujarPlano(int xp, int xn, int yp, int yn) {
        this.xp = xp;
        this.xn = xn;
        this.yp = yp;
        this.yn = yn;
        repaint();
    }
    
    /**Se llama desde la clase ventana, asignando nuevos valores a los ejes y a z 
     * Y se llama el método repaint para repintar el plano de argand 
     */
    
    public void dibujarNComplejo(Complejo z, int xp, int xn, int yp, int yn) {
        this.xp = xp;
        this.xn = xn;
        this.yp = yp;
        this.yn = yn;
        this.z = z;
        repaint();
    }
    
    /**Se llama desde ventana cambia la bandera de graficarArgumento
     */
    public void dibujarArgumento(double argumento){
        this.argumento = argumento;
        this.graficarArgumento = !this.graficarArgumento;
        repaint();
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
