package elementos.graficos;

import elementos.numeros.Complejo;
import java.awt.Graphics;
import java.awt.Point;


public class PlanoCartesiano extends javax.swing.JPanel {

    private int anchoPlano;
    private int altoPlano;
    private int unidad;
    private int xp, xn, yp, yn;
    private Point puntoSI;
    private Point puntoSD;
    private Point puntoII;
    private Point puntoID;
    private Complejo z;
    
    public PlanoCartesiano() {
        initComponents();
        setBounds(0,0,500,400);
        this.anchoPlano = this.getWidth()-40;
        this.altoPlano = this.getHeight()-40;
        this.puntoSI = new Point(20, 20);
        this.puntoSD = new Point(this.getWidth()-20, 20);
        this.puntoII = new Point(20, this.getHeight()-20);
        this.puntoID = new Point(this.getWidth()-20, this.getHeight()-20);
        this.unidad = 0;
        xn = xp = yn = yp = 0;
        this.z = null;
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

    //Point inicio, Point fin
    @Override
    public void paint(Graphics g){
        super.paint(g);
        if(xp == 0 && xn == 0 && yn == 0 && yp == 0)  ///Enc aso de no haber iniciado un plano se crea uno 
            xp = xn=yp=yn = 5;
        Point origen = null; //Representa el origen del plano de argand
        
        //Obtenemos la representación en pixeles de una unidad en este plano
        try{//Puede presentar errors si no se han asignado valores a las distancias en x & y
            this.unidad = this.altoPlano/(Math.abs(yp)+Math.abs(yn));
        }catch(ArithmeticException e){
            this.unidad = 0;
        }
        
        ///En caso de que unidad sea diferente a 0, es decir, tengamos un plano por gráficar, se realizan las líneass
        if(unidad != 0){
            ///Se obtiene el punto de origen del plano usando la unidad obtenida
            origen = new Point(puntoSI.x + (unidad*Math.abs(xn)), puntoSI.y + (unidad*yp));
        }else{
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
        
        ///Se dibuja el vector representativo de z
        if(z != null){ ///si el número complejo tiene valor asignado se dibuja
            ///Se dibuja una línea desde el origen hacia el par ordenado de z
            var puntoZ = new Point(origen.x + (unidad*(int)z.getA()),origen.y- (unidad*(int)z.getB()));
            g.drawLine(origen.x, origen.y, puntoZ.x, puntoZ.y);
            g.drawString(z.getParOrdenado(), puntoZ.x, puntoZ.y);
        }
        g.setColor(java.awt.Color.DARK_GRAY);
        
        g.setColor(java.awt.Color.BLUE);
        /*Dibujamos las representaciones de las unidades en el plano
        *En esencia son líneas perpendiculares a los ejes, el punto x y y es igual al origen solo se van agregando 
        *]la cantidad de unidades que debe contener el plano
        */
        //línes de unidades del eje x positivo
        int sum = 0;
        for(int i = 1; i<= xp; i++){
            sum = unidad * i; //Obtiene la unidad desplazada que se va a recorrer
            g.drawLine(origen.x + sum, origen.y-10, origen.x + sum, origen.y+10); //dibuja la línea perpendicular
            g.drawString(i+"", origen.x + sum, origen.y+20); //dibuja el número en su correspondiente lugar
        }
        ///linea de unidades del eje x negativo 
        sum = 0;
        for(int i = 0; i<=Math.abs(xn); i++){
            sum = unidad*i;
            g.drawLine(origen.x - sum, origen.y-10, origen.x - sum, origen.y+10);
            g.drawString("-"+i, origen.x - sum, origen.y+20); //dibuja el número en su correspondiente lugar
        }
        ///Líneas de unidades del eje y positivo
        sum = 0;
        for(int i = 1; i<=yp; i++){
            sum = unidad*i;
            g.drawLine(origen.x -10, origen.y- sum, origen.x +10, origen.y- sum);
            g.drawString(i+"i", origen.x -30, origen.y- sum+10); //dibuja el número en su correspondiente lugar
        }
        ///Lineas de unidades del eje y negativo
        sum = 0;
        for(int i = 1; i<=Math.abs(yn); i++){
            sum = unidad*i;
            g.drawLine(origen.x +10 , origen.y+sum, origen.x - 10, origen.y+sum);
            g.drawString("-"+i+"i",origen.x - 20, origen.y+sum+10); //dibuja el número en su correspondiente lugar
        }
        
        g.setColor(java.awt.Color.GREEN);
        for(int i = 0; i<100; i++){
            g.drawLine(i, i, i, i);
            
        }
    }

    public void dibujarPlano(int xp, int xn, int yp, int yn) {
        this.xp = xp;
        this.xn = xn;
        this.yp = yp;
        this.yn = yn;
        repaint();
    }
    
    public void dibujarNComplejo(Complejo z, int xp, int xn, int yp, int yn) {
        this.xp = xp;
        this.xn = xn;
        this.yp = yp;
        this.yn = yn;
        this.z = z;
        repaint();
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
