package vista;

import elementos.Complejo;
import elementos.visuales.PlanoArgand;
import javax.swing.JOptionPane;

public class Ventana extends javax.swing.JFrame {

    private PlanoArgand planoArgand;
    private Complejo z1;    ///Para manejar los numeros complejos
    private Complejo z2;    ///Se usará una lista de Complejos
    
    public Ventana() {
        z1 = new Complejo();
        z2 = new Complejo();
        initComponents();
        addPlano();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        numerosComplejos = new javax.swing.JPanel();
        z1_txt = new javax.swing.JTextField();
        btn_graficar = new javax.swing.JButton();
        z2_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_modulo = new javax.swing.JButton();
        btn_complemento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 700, 500));

        btn_graficar.setText("Gráficar");
        btn_graficar.setToolTipText("Se realiza la gráfica de z1");
        btn_graficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_graficarActionPerformed(evt);
            }
        });

        jLabel2.setText("z1=");

        jLabel3.setText("z2=");

        btn_modulo.setText("Módulo");
        btn_modulo.setToolTipText("Se calcula el módulo de z1");
        btn_modulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moduloActionPerformed(evt);
            }
        });

        btn_complemento.setText("Complemento");
        btn_complemento.setToolTipText("Se calcula el Conjugado de z1");
        btn_complemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_complementoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout numerosComplejosLayout = new javax.swing.GroupLayout(numerosComplejos);
        numerosComplejos.setLayout(numerosComplejosLayout);
        numerosComplejosLayout.setHorizontalGroup(
            numerosComplejosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numerosComplejosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(numerosComplejosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(numerosComplejosLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(z1_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(z2_txt))
                    .addGroup(numerosComplejosLayout.createSequentialGroup()
                        .addComponent(btn_graficar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_modulo)
                        .addGap(18, 18, 18)
                        .addComponent(btn_complemento)))
                .addContainerGap(247, Short.MAX_VALUE))
        );
        numerosComplejosLayout.setVerticalGroup(
            numerosComplejosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numerosComplejosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(numerosComplejosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(z1_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(z2_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(numerosComplejosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_graficar)
                    .addComponent(btn_modulo)
                    .addComponent(btn_complemento))
                .addContainerGap(418, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Números complejos", numerosComplejos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_graficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_graficarActionPerformed
        // TODO add your handling code here:
        int xp, xn, yp, yn;
        xp = xn = yp = yn = 0;
        this.z1 = new Complejo(this.z1_txt.getText());
        
        if(z1.getA()>=0){
            xp = (int)z1.getA() + 1;
            xn = -2;
        }else{
            xn = (int)z1.getA() - 1;
            xp = 2;
        }
        
        if(z1.getB()>=0){
            yp = (int) z1.getB() +1;
            yn = -2;
        }else{
            yn = (int) z1.getB() -1 ;
            yp = 2;
        }
        
        this.planoArgand.dibujarNComplejo(z1, xp, xn, yp, yn);
    }//GEN-LAST:event_btn_graficarActionPerformed

    private void btn_complementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_complementoActionPerformed
        // TODO add your handling code here:
        this.z1 = new Complejo(z1_txt.getText());
        var formaBinomica = this.z1.getFormaBinomica();
        var complemento = this.z1.complemento();
        JOptionPane.showMessageDialog(this, "Complemento de "+formaBinomica+ "= "+complemento ,
                "Complemento de Z1", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_complementoActionPerformed

    private void btn_moduloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moduloActionPerformed
        // TODO add your handling code here:
        this.z1 = new Complejo(z1_txt.getText());
        var moduloZ1 = this.z1.modulo();
        JOptionPane.showMessageDialog(this, "Módulo de "+this.z1.getFormaBinomica()+ "= "+moduloZ1 ,
                "Módulo de Z1", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_moduloActionPerformed
    
    public void addPlano(){
        this.planoArgand = new PlanoArgand();
        var bounds = this.btn_graficar.getBounds();
        this.planoArgand.setBounds(0,bounds.y+20+bounds.height, 500,400);
        this.numerosComplejos.add(this.planoArgand);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_complemento;
    private javax.swing.JButton btn_graficar;
    private javax.swing.JButton btn_modulo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel numerosComplejos;
    private javax.swing.JTextField z1_txt;
    private javax.swing.JTextField z2_txt;
    // End of variables declaration//GEN-END:variables
}
