/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import javax.swing.JOptionPane;

/**
 *
 * @author jdsma
 */
public class CheckinDiario extends javax.swing.JFrame {

    /**
     * Creates new form CheckinDiario
     */
    public CheckinDiario() {
        initComponents();
    }
    
    modelo.ChekinDiario ck = new modelo.ChekinDiario();
    public void verificarCheckBox(){
        
        if(jcbSemSintomas.isSelected()){
            ck.adicionar(jcbSemSintomas.getText());
            JOptionPane.showMessageDialog(null,"Que ótimo que está bem, continue se cuidando", "" , JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(jcbFebreAlta.isSelected()){
            ck.adicionar(jcbFebreAlta.getText());
        }
        if(jcbTosseSeca.isSelected()){
            ck.adicionar(jcbTosseSeca.getText());
        }
        if(jcbDifRespiratoria.isSelected()){
            ck.adicionar(jcbDifRespiratoria.getText());
          
            JOptionPane.showMessageDialog(null,"CUIDADO, você está com grande probabilidade de estar infectado", "" , JOptionPane.WARNING_MESSAGE);

        }
        
        //JOptionPane.showMessageDialog(null, "Ítens selecionados: "+h,"Seleção",JOptionPane.PLAIN_MESSAGE);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBoasVindasUser = new javax.swing.JLabel();
        jLabelMensagInformacao = new javax.swing.JLabel();
        jcbSemSintomas = new javax.swing.JCheckBox();
        jcbFebreAlta = new javax.swing.JCheckBox();
        jcbTosseSeca = new javax.swing.JCheckBox();
        jcbDifRespiratoria = new javax.swing.JCheckBox();
        jButtonEnviarInfo = new javax.swing.JButton();
        jLabelCabecalho = new javax.swing.JLabel();
        jButtonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabelBoasVindasUser.setText("Olá, seja bem vindo: ");
        getContentPane().add(jLabelBoasVindasUser);
        jLabelBoasVindasUser.setBounds(80, 87, 102, 14);

        jLabelMensagInformacao.setText("Como você está se sentindo hoje  ?");
        getContentPane().add(jLabelMensagInformacao);
        jLabelMensagInformacao.setBounds(175, 140, 222, 14);

        jcbSemSintomas.setText("Me sinto bem, nenhum sintoma.");
        getContentPane().add(jcbSemSintomas);
        jcbSemSintomas.setBounds(119, 191, 177, 23);

        jcbFebreAlta.setText("Febre alta ( acima de 39º graus)");
        getContentPane().add(jcbFebreAlta);
        jcbFebreAlta.setBounds(119, 232, 181, 23);

        jcbTosseSeca.setText("Tosse seca constante");
        getContentPane().add(jcbTosseSeca);
        jcbTosseSeca.setBounds(119, 273, 129, 23);

        jcbDifRespiratoria.setText("Dificuldade Respiratória");
        getContentPane().add(jcbDifRespiratoria);
        jcbDifRespiratoria.setBounds(119, 314, 139, 23);

        jButtonEnviarInfo.setText("Enviar informação");
        jButtonEnviarInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarInfoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEnviarInfo);
        jButtonEnviarInfo.setBounds(100, 380, 119, 23);

        jLabelCabecalho.setText("SISTEMA DE AUXILIO E COMBATE AO COVIR-19");
        getContentPane().add(jLabelCabecalho);
        jLabelCabecalho.setBounds(179, 29, 262, 29);

        jButtonSair.setText("SAIR");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair);
        jButtonSair.setBounds(260, 380, 130, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEnviarInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarInfoActionPerformed
        // TODO add your handling code here:
        verificarCheckBox();
    }//GEN-LAST:event_jButtonEnviarInfoActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonSairActionPerformed

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
            java.util.logging.Logger.getLogger(CheckinDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckinDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckinDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckinDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckinDiario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEnviarInfo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelBoasVindasUser;
    private javax.swing.JLabel jLabelCabecalho;
    private javax.swing.JLabel jLabelMensagInformacao;
    private javax.swing.JCheckBox jcbDifRespiratoria;
    private javax.swing.JCheckBox jcbFebreAlta;
    private javax.swing.JCheckBox jcbSemSintomas;
    private javax.swing.JCheckBox jcbTosseSeca;
    // End of variables declaration//GEN-END:variables
}
