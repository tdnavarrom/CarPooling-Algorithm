/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inte_datos;
import javax.swing.*;
/**
 *
 * @author Usuario
 */
public class Interface extends javax.swing.JFrame {
    /**
     * Creates new form Interface
     */
    public Interface() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CPA = new javax.swing.JLabel();
        img_usuar = new javax.swing.JLabel();
        img_car = new javax.swing.JLabel();
        name_Field = new javax.swing.JTextField();
        name = new javax.swing.JLabel();
        CPA_Mean = new javax.swing.JLabel();
        help_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CPA_HOME");
        setBackground(new java.awt.Color(204, 204, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 216, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CPA.setFont(new java.awt.Font("Bookman Old Style", 1, 100)); // NOI18N
        CPA.setText("CPA");
        jPanel1.add(CPA, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        img_usuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inte_datos/user_filled_50px.png"))); // NOI18N
        img_usuar.setText("jLabel2");
        jPanel1.add(img_usuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 51, -1));

        img_car.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inte_datos/carro.png"))); // NOI18N
        jPanel1.add(img_car, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        name_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_FieldActionPerformed(evt);
            }
        });
        jPanel1.add(name_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 194, 29));

        name.setFont(new java.awt.Font("Calisto MT", 1, 12)); // NOI18N
        name.setText("Write your name...");
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        CPA_Mean.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        CPA_Mean.setText("CAR POOLING ALGORITHM");
        jPanel1.add(CPA_Mean, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        help_Button.setBackground(new java.awt.Color(0, 0, 0));
        help_Button.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        help_Button.setForeground(new java.awt.Color(255, 255, 255));
        help_Button.setText("REDUCE CONTAMINATION");
        help_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                help_ButtonActionPerformed(evt);
            }
        });
        jPanel1.add(help_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void name_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_FieldActionPerformed
        // TODO add your handling code here: 
    }//GEN-LAST:event_name_FieldActionPerformed

    private void help_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_help_ButtonActionPerformed
        // TODO add your handling code here:
        String name = name_Field.getText();
        System.out.println(name);
        Reduce r = new Reduce();
        r.setVisible(true);
        JOptionPane.showMessageDialog(null, "Hello "+name+", let's save the world");

    }//GEN-LAST:event_help_ButtonActionPerformed
    
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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CPA;
    private javax.swing.JLabel CPA_Mean;
    private javax.swing.JButton help_Button;
    private javax.swing.JLabel img_car;
    private javax.swing.JLabel img_usuar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel name;
    private javax.swing.JTextField name_Field;
    // End of variables declaration//GEN-END:variables
}
