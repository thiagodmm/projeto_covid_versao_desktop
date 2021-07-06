/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import javax.swing.JOptionPane;

/**
 *
 * @author Thiago Machado
 */

public class GUICadastroUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUICadastroUsuario
     */
    public GUICadastroUsuario() {
        initComponents();
    }
    
    
        public void cadastrarUsuario(){
        
        try{

	modelo.UsuarioVO u = new modelo.UsuarioVO();

	u.setNome(jtfNome.getText());
        u.setEmail(jtfEmail.getText());
        u.setDataNasc(Integer.parseInt(jtfDataNasc.getText()));
        u.setPeso(Double.parseDouble(jtfPeso.getText()));
        u.setAltura(Double.parseDouble(jtfAltura.getText()));
        u.setAlergias(jtfAlergias.getText());
        u.setDoencas(jtfDoencas.getText());
        
	// Chama o usuário serviços que fará a inserção dos dados da classe dentro do banco 
	servicos.UsuarioServicos us = servicos.ServicosFactory.getUsuarioServicos();
        
        us.cadastrarUsuario(u);

	JOptionPane.showMessageDialog(null,"Novo usuário cadastrado com sucesso! ", "Confirmação",JOptionPane.INFORMATION_MESSAGE);
	
}catch(Exception e){

	JOptionPane.showMessageDialog(null, "Ops, algo deu errado! "+e.getMessage(),"Erro!", JOptionPane.ERROR_MESSAGE);

}
	
}
        
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCadastroUsuario = new javax.swing.JPanel();
        jlTituloCadastro = new javax.swing.JLabel();
        jlNome = new javax.swing.JLabel();
        jlEmail = new javax.swing.JLabel();
        jlDataNasc = new javax.swing.JLabel();
        jlPeso = new javax.swing.JLabel();
        jlAltura = new javax.swing.JLabel();
        jlAlergias = new javax.swing.JLabel();
        jlDoencas = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jtfDataNasc = new javax.swing.JTextField();
        jtfPeso = new javax.swing.JTextField();
        jtfAltura = new javax.swing.JTextField();
        jtfAlergias = new javax.swing.JTextField();
        jtfDoencas = new javax.swing.JTextField();
        jbCadastrar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jpTop = new javax.swing.JPanel();
        jlTituloPrincipal = new javax.swing.JLabel();
        jlTituloAdmin = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(600, 500));

        jPanelCadastroUsuario.setBackground(new java.awt.Color(195, 213, 231));

        jlTituloCadastro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jlTituloCadastro.setForeground(new java.awt.Color(47, 85, 123));
        jlTituloCadastro.setText("Cadastro de Novo Usuário");

        jlNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlNome.setText("Nome Completo:");

        jlEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlEmail.setText("E-mail:");

        jlDataNasc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlDataNasc.setText("Data de Nascimento:");

        jlPeso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlPeso.setText("Peso:");

        jlAltura.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlAltura.setText("Altura:");

        jlAlergias.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlAlergias.setText("Alergias:");

        jlDoencas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlDoencas.setText("Doenças:");

        jtfNome.setPreferredSize(new java.awt.Dimension(250, 24));

        jtfEmail.setPreferredSize(new java.awt.Dimension(250, 24));

        jtfDataNasc.setPreferredSize(new java.awt.Dimension(100, 24));
        jtfDataNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDataNascActionPerformed(evt);
            }
        });

        jtfPeso.setPreferredSize(new java.awt.Dimension(60, 24));

        jtfAltura.setPreferredSize(new java.awt.Dimension(60, 24));

        jtfAlergias.setPreferredSize(new java.awt.Dimension(250, 24));

        jtfDoencas.setPreferredSize(new java.awt.Dimension(250, 24));

        jbCadastrar.setBackground(new java.awt.Color(47, 85, 123));
        jbCadastrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jbCadastrar.setText("Cadastrar");
        jbCadastrar.setPreferredSize(new java.awt.Dimension(100, 26));
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jbCancelar.setBackground(new java.awt.Color(47, 85, 123));
        jbCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jbCancelar.setText("Cancelar");
        jbCancelar.setPreferredSize(new java.awt.Dimension(100, 26));
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCadastroUsuarioLayout = new javax.swing.GroupLayout(jPanelCadastroUsuario);
        jPanelCadastroUsuario.setLayout(jPanelCadastroUsuarioLayout);
        jPanelCadastroUsuarioLayout.setHorizontalGroup(
            jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlDoencas)
                    .addComponent(jlAlergias)
                    .addComponent(jlAltura)
                    .addComponent(jlPeso)
                    .addComponent(jlDataNasc)
                    .addComponent(jlEmail)
                    .addComponent(jlNome)
                    .addComponent(jlTituloCadastro))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanelCadastroUsuarioLayout.createSequentialGroup()
                            .addComponent(jbCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jtfDoencas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanelCadastroUsuarioLayout.setVerticalGroup(
            jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCadastroUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTituloCadastro)
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNome)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEmail)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDataNasc)
                    .addComponent(jtfDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPeso)
                    .addComponent(jtfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlAltura)
                    .addComponent(jtfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlAlergias)
                    .addComponent(jtfAlergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDoencas)
                    .addComponent(jtfDoencas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCadastroUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jpTop.setBackground(new java.awt.Color(47, 85, 123));

        jlTituloPrincipal.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jlTituloPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        jlTituloPrincipal.setText("APP COVID 19");

        jlTituloAdmin.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jlTituloAdmin.setForeground(new java.awt.Color(255, 255, 255));
        jlTituloAdmin.setText("Sistema de Administração");

        javax.swing.GroupLayout jpTopLayout = new javax.swing.GroupLayout(jpTop);
        jpTop.setLayout(jpTopLayout);
        jpTopLayout.setHorizontalGroup(
            jpTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTituloPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlTituloAdmin)
                .addContainerGap())
        );
        jpTopLayout.setVerticalGroup(
            jpTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTituloPrincipal)
                    .addComponent(jlTituloAdmin))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCadastroUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCadastroUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void cancelar(){
        
    jtfNome.setText(null);
    jtfEmail.setText(null);
    jtfDataNasc.setText(null);
    jtfPeso.setText(null);
    jtfAltura.setText(null);
    jtfDataNasc.setText(null);
    jtfAlergias.setText(null);
    jtfDoencas.setText(null);
    
    }
    
    
    
    
    private void jtfDataNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDataNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDataNascActionPerformed

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        // TODO add your handling code here:
        cadastrarUsuario();
        cancelar();
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // TODO add your handling code here:
        cancelar();
    }//GEN-LAST:event_jbCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelCadastroUsuario;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JLabel jlAlergias;
    private javax.swing.JLabel jlAltura;
    private javax.swing.JLabel jlDataNasc;
    private javax.swing.JLabel jlDoencas;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlPeso;
    private javax.swing.JLabel jlTituloAdmin;
    private javax.swing.JLabel jlTituloCadastro;
    private javax.swing.JLabel jlTituloPrincipal;
    private javax.swing.JPanel jpTop;
    private javax.swing.JTextField jtfAlergias;
    private javax.swing.JTextField jtfAltura;
    private javax.swing.JTextField jtfDataNasc;
    private javax.swing.JTextField jtfDoencas;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfPeso;
    // End of variables declaration//GEN-END:variables
}
