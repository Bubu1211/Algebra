package vista;

import elementos.numeros.Complejo;
import elementos.graficos.PlanoArgand;
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
        addMatrizPanel();
    }
    
    public void addMatrizPanel(){
        elementos.graficos.MatrizPanel p = new elementos.graficos.MatrizPanel();
        p.setBounds(0,0,100,100);
        matricesPanel.add(p);
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
        btn_conjugado = new javax.swing.JButton();
        btn_sumar = new javax.swing.JButton();
        btn_restar = new javax.swing.JButton();
        btn_producto = new javax.swing.JButton();
        btn_argumento = new javax.swing.JButton();
        btn_dividir = new javax.swing.JButton();
        btn_pow = new javax.swing.JButton();
        matricesPanel = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_rotacion = new javax.swing.JButton();
        panel_cambio = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 700, 500));

        numerosComplejos.setBackground(new java.awt.Color(255, 255, 255));

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

        btn_conjugado.setText("Conjugado");
        btn_conjugado.setToolTipText("Se calcula el Conjugado de z1");
        btn_conjugado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_conjugadoActionPerformed(evt);
            }
        });

        btn_sumar.setText("Sumar");
        btn_sumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sumarActionPerformed(evt);
            }
        });

        btn_restar.setText("Restar");
        btn_restar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restarActionPerformed(evt);
            }
        });

        btn_producto.setText("Producto");
        btn_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_productoActionPerformed(evt);
            }
        });

        btn_argumento.setText("Argumento");
        btn_argumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_argumentoActionPerformed(evt);
            }
        });

        btn_dividir.setText("Dividir");
        btn_dividir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dividirActionPerformed(evt);
            }
        });

        btn_pow.setText("Potencia");
        btn_pow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_powActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout numerosComplejosLayout = new javax.swing.GroupLayout(numerosComplejos);
        numerosComplejos.setLayout(numerosComplejosLayout);
        numerosComplejosLayout.setHorizontalGroup(
            numerosComplejosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numerosComplejosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(numerosComplejosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(numerosComplejosLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(z1_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(z2_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(numerosComplejosLayout.createSequentialGroup()
                        .addComponent(btn_graficar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_dividir)
                        .addGap(18, 18, 18)
                        .addComponent(btn_pow))
                    .addGroup(numerosComplejosLayout.createSequentialGroup()
                        .addComponent(btn_modulo)
                        .addGap(18, 18, 18)
                        .addComponent(btn_conjugado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_sumar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_restar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_producto)
                        .addGap(18, 18, 18)
                        .addComponent(btn_argumento)))
                .addContainerGap(46, Short.MAX_VALUE))
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
                    .addComponent(btn_modulo)
                    .addComponent(btn_conjugado)
                    .addComponent(btn_sumar)
                    .addComponent(btn_restar)
                    .addComponent(btn_producto)
                    .addComponent(btn_argumento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(numerosComplejosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_graficar)
                    .addComponent(btn_dividir)
                    .addComponent(btn_pow))
                .addContainerGap(430, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Calculadora gráfica", numerosComplejos);

        matricesPanel.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setText("0");
        matricesPanel.add(jTextField1);

        jLabel1.setText("°");
        matricesPanel.add(jLabel1);

        btn_rotacion.setText("Rotar");
        btn_rotacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rotacionActionPerformed(evt);
            }
        });
        matricesPanel.add(btn_rotacion);

        panel_cambio.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_cambioLayout = new javax.swing.GroupLayout(panel_cambio);
        panel_cambio.setLayout(panel_cambioLayout);
        panel_cambioLayout.setHorizontalGroup(
            panel_cambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );
        panel_cambioLayout.setVerticalGroup(
            panel_cambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );

        matricesPanel.add(panel_cambio);

        jTabbedPane1.addTab("Transformaciones", matricesPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
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

        if (z1.getA() >= 0) {
            xp = (int) z1.getA() + 1;
            xn = -2;
        } else {
            xn = (int) z1.getA() - 1;
            xp = 2;
        }

        if (z1.getB() > 0) {
            yp = (int) z1.getB() + 1;
            yn = -2;
        } else if (z1.getB() == 0) {
            yn = yp = 0;
        } else {
            yn = (int) z1.getB() - 1;
            yp = 2;
        }

        this.planoArgand.dibujarNComplejo(z1, xp, xn, yp, yn);
    }//GEN-LAST:event_btn_graficarActionPerformed

    private void btn_conjugadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_conjugadoActionPerformed
        // TODO add your handling code here:
        this.z1 = new Complejo(z1_txt.getText());
        String formaBinomica = this.z1.getFormaBinomica();
        Complejo complemento = this.z1.conjugado();
        JOptionPane.showMessageDialog(this, formatoMensaje(formaBinomica + "= " + complemento.getFormaBinomica()),
                "Complemento de Z1", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_conjugadoActionPerformed

    private void btn_moduloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moduloActionPerformed
        // TODO add your handling code here:
        this.z1 = new Complejo(z1_txt.getText());
        double moduloZ1 = this.z1.modulo();
        JOptionPane.showMessageDialog(this, formatoMensaje("Módulo de " + this.z1.getFormaBinomica() + "= "
                + moduloZ1),
                "Módulo de Z1", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_moduloActionPerformed

    private void btn_sumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sumarActionPerformed
        // TODO add your handling code here:
        this.z1 = new Complejo(z1_txt.getText());
        this.z2 = new Complejo(z2_txt.getText());
        Complejo z3 = z1.add(z2);

        JOptionPane.showMessageDialog(this, formatoMensaje(z1.getFormaBinomica() + " + "
                + z2.getFormaBinomica() + " = " + z3.getFormaBinomica()), "Suma", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_sumarActionPerformed

    private void btn_restarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restarActionPerformed
        // TODO add your handling code here:
        this.z1 = new Complejo(z1_txt.getText());
        this.z2 = new Complejo(z2_txt.getText());
        Complejo z3 = z1.sub(z2);

        JOptionPane.showMessageDialog(this, formatoMensaje(z1.getFormaBinomica() + " - "
                + z2.getFormaBinomica() + " = " + z3.getFormaBinomica()), "Resta", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btn_restarActionPerformed

    private void btn_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_productoActionPerformed
        // TODO add your handling code here:
        this.z1 = new Complejo(z1_txt.getText());
        this.z2 = new Complejo(z2_txt.getText());
        Complejo z3 = z1.mul(z2);

        JOptionPane.showMessageDialog(this, formatoMensaje(formatoMensaje(z1.getFormaBinomica() + " X "
                + z2.getFormaBinomica() + " = " + z3.getFormaBinomica())), "Producto", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btn_productoActionPerformed

    private void btn_argumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_argumentoActionPerformed
        // TODO add your handling code here:
        this.planoArgand.dibujarArgumento(z1.argumento());

        JOptionPane.showMessageDialog(this, formatoMensaje(z1.argumento() + ""),
                "Argumento de Z1", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btn_argumentoActionPerformed

    private void btn_dividirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dividirActionPerformed
        // TODO add your handling code here:
        this.z1 = new Complejo(z1_txt.getText());
        this.z2 = new Complejo(z2_txt.getText());
        Complejo z3 = z1.div(z2);

        JOptionPane.showMessageDialog(this, formatoMensaje(formatoMensaje(z1.getFormaBinomica() + " / "
                + z2.getFormaBinomica() + " = " + z3.getFormaBinomica())), "División", JOptionPane.INFORMATION_MESSAGE);


    }//GEN-LAST:event_btn_dividirActionPerformed

    private void btn_powActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_powActionPerformed
        // TODO add your handling code here:
        int n = Integer.parseInt(JOptionPane.showInputDialog(this, formatoMensaje("Ingrese la potencia deseada"), "Potencia",
                JOptionPane.QUESTION_MESSAGE));
        this.z1 = new Complejo(z1_txt.getText());
        z1.pow(n);
        JOptionPane.showMessageDialog(this, formatoMensaje(formatoMensaje(z1.getFormaBinomica())), "División", JOptionPane.INFORMATION_MESSAGE);


    }//GEN-LAST:event_btn_powActionPerformed

    private void btn_rotacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rotacionActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_rotacionActionPerformed

    private String formatoMensaje(String cad) {
        return "<HTML><h2>" + cad + "</h2><HTML>";
    }

    public void addPlano() {
        this.planoArgand = new PlanoArgand();
        java.awt.Rectangle bounds = this.btn_graficar.getBounds();
        this.planoArgand.setBounds(0, bounds.y + 20 + bounds.height, 500, 400);
        this.numerosComplejos.add(this.planoArgand);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_argumento;
    private javax.swing.JButton btn_conjugado;
    private javax.swing.JButton btn_dividir;
    private javax.swing.JButton btn_graficar;
    private javax.swing.JButton btn_modulo;
    private javax.swing.JButton btn_pow;
    private javax.swing.JButton btn_producto;
    private javax.swing.JButton btn_restar;
    private javax.swing.JButton btn_rotacion;
    private javax.swing.JButton btn_sumar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel matricesPanel;
    private javax.swing.JPanel numerosComplejos;
    private javax.swing.JPanel panel_cambio;
    private javax.swing.JTextField z1_txt;
    private javax.swing.JTextField z2_txt;
    // End of variables declaration//GEN-END:variables
}
