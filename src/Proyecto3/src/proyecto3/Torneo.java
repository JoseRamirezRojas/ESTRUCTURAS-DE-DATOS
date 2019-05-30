/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import java.awt.Image;
import java.io.Serializable;

/**
 *
 * @author pepew
 */
public class Torneo extends javax.swing.JFrame implements Serializable {
    private Simulacion sim=new Simulacion();
    private Image imagen;
    Equipos[] eq;
    /**
     * Creates new form Torneo
     */
    public Torneo() {
        initComponents();
        eq=sim.asignaEquipos();
        Equipo1.setText(eq[0].getNombre());
        Equipo2.setText(eq[1].getNombre());
        Equipo3.setText(eq[2].getNombre());
        Equipo4.setText(eq[3].getNombre());
        Equipo5.setText(eq[4].getNombre());
        Equipo6.setText(eq[5].getNombre());
        Equipo7.setText(eq[6].getNombre());
        Equipo8.setText(eq[7].getNombre());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jSeparator3 = new javax.swing.JSeparator();
        botonApostar2 = new javax.swing.JButton();
        botonApostar1 = new javax.swing.JButton();
        Equipo15 = new javax.swing.JLabel();
        Equipo14 = new javax.swing.JLabel();
        Equipo13 = new javax.swing.JLabel();
        Equipo12 = new javax.swing.JLabel();
        Equipo11 = new javax.swing.JLabel();
        Equipo10 = new javax.swing.JLabel();
        Equipo9 = new javax.swing.JLabel();
        Equipo8 = new javax.swing.JLabel();
        Equipo7 = new javax.swing.JLabel();
        Equipo6 = new javax.swing.JLabel();
        Equipo5 = new javax.swing.JLabel();
        Equipo4 = new javax.swing.JLabel();
        Equipo3 = new javax.swing.JLabel();
        Equipo2 = new javax.swing.JLabel();
        Equipo1 = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();
        Bracket = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Torneo");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonApostar2.setText("jButton1");
        getContentPane().add(botonApostar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        botonApostar1.setText("Apostar");
        botonApostar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonApostar1ActionPerformed(evt);
            }
        });
        getContentPane().add(botonApostar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        Equipo15.setText("jLabel15");
        getContentPane().add(Equipo15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));

        Equipo14.setText("jLabel13");
        getContentPane().add(Equipo14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, -1, -1));

        Equipo13.setText("jLabel12");
        getContentPane().add(Equipo13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));

        Equipo12.setText("jLabel14");
        getContentPane().add(Equipo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, -1, -1));

        Equipo11.setText("jLabel11");
        getContentPane().add(Equipo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        Equipo10.setText("jLabel9");
        getContentPane().add(Equipo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));

        Equipo9.setText("jLabel16");
        getContentPane().add(Equipo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        Equipo8.setText("jLabel7");
        getContentPane().add(Equipo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        Equipo7.setText("jLabel6");
        getContentPane().add(Equipo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        Equipo6.setText("jLabel17");
        getContentPane().add(Equipo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 20));

        Equipo5.setText("jLabel8");
        getContentPane().add(Equipo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        Equipo4.setText("jLabel10");
        getContentPane().add(Equipo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, -1, -1));

        Equipo3.setText("jLabel5");
        getContentPane().add(Equipo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, -1, -1));

        Equipo2.setText("jLabel4");
        getContentPane().add(Equipo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, -1, -1));

        Equipo1.setBackground(new java.awt.Color(102, 0, 102));
        Equipo1.setText(" EQUIPO 1");
        Equipo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(Equipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, -1));

        botonRegresar.setText("Regresar");
        getContentPane().add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, 80, -1));

        Bracket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/bracket.png"))); // NOI18N
        getContentPane().add(Bracket, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, 360));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(729, 11, -1, -1));

        jLabel3.setBackground(new java.awt.Color(102, 0, 102));
        jLabel3.setText(" EQUIPO 1");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, -1, 360));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 12, -1, 340));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonApostar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonApostar1ActionPerformed
        // TODO add your handling code here:
        dispose();
        Apuesta a=new Apuesta();
        a.setVisible(true);
    }//GEN-LAST:event_botonApostar1ActionPerformed

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Torneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Torneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Torneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Torneo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Torneo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bracket;
    private javax.swing.JLabel Equipo1;
    private javax.swing.JLabel Equipo10;
    private javax.swing.JLabel Equipo11;
    private javax.swing.JLabel Equipo12;
    private javax.swing.JLabel Equipo13;
    private javax.swing.JLabel Equipo14;
    private javax.swing.JLabel Equipo15;
    private javax.swing.JLabel Equipo2;
    private javax.swing.JLabel Equipo3;
    private javax.swing.JLabel Equipo4;
    private javax.swing.JLabel Equipo5;
    private javax.swing.JLabel Equipo6;
    private javax.swing.JLabel Equipo7;
    private javax.swing.JLabel Equipo8;
    private javax.swing.JLabel Equipo9;
    private javax.swing.JButton botonApostar1;
    private javax.swing.JButton botonApostar2;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}