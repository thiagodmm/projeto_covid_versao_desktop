/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.UsuarioVO;
import servicos.UsuarioServicos;

/**
 *
 * @author thiag
 */
public class GUIBuscaUsuario extends javax.swing.JInternalFrame {
    
    DefaultTableModel dtm = new DefaultTableModel(

	new Object[][]{},
	new Object[]{"ID", "Nome", "E-mail", "Data Nascimento", "Peso", "Altura", "Alergias", "Doenças"}
    );


    public void preencherTabela(){
	
	try{
		UsuarioServicos us = servicos.ServicosFactory.getUsuarioServicos();
		ArrayList<UsuarioVO> user = new ArrayList<>();
		user = us.buscar();
                
                // Laço que percorre o Array List auxiliar e busca em cada linha preencher com dados de suas respectivas colunas.
                // Ou seja, retorna 1 produto por linha, dividido em colunas como "código, nome, valor custo, quantidade".
                for(int i=0; i<user.size(); i++){
                    dtm.addRow(new String[]{
	
                    String.valueOf(user.get(i).getIdUsuario()),
                    String.valueOf(user.get(i).getNome()),
                    String.valueOf(user.get(i).getEmail()),
                    String.valueOf(user.get(i).getDataNasc()),
                    String.valueOf(user.get(i).getPeso()),
                    String.valueOf(user.get(i).getAltura()),
                    String.valueOf(user.get(i).getAlergias()),
                    String.valueOf(user.get(i).getDoencas()),

                    });

                } // Fecha For
                jTableResultado.setModel(dtm);
                
	}catch(Exception e){
	
              JOptionPane.showMessageDialog(null, "Ops, algo deu errado! "+e.getMessage(),"Erro!", JOptionPane.ERROR_MESSAGE);  
            
	}
	
	}
    
    
    public void limparTabela(){
    dtm.setNumRows(0);
    }
   

    public void deletar(){
	try{
	int linha = jTableResultado.getSelectedRow();
	if(linha == -1){
		JOptionPane.showMessageDialog(null, "Você não selecionou uma linha para exclusão! ","Erro!", JOptionPane.ERROR_MESSAGE);
	}else{
		UsuarioServicos us = servicos.ServicosFactory.getUsuarioServicos();
		String idUsuario = (String) jTableResultado.getValueAt(linha, 0);
                
                int r = JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir este produto?","Confirmação", JOptionPane.WARNING_MESSAGE);
                
                if(r==JOptionPane.YES_OPTION){
		us.deletarUsuario(Long.parseLong(idUsuario));
                
                
                }else {
                  JOptionPane.showMessageDialog(null, "Sua exclusão não foi realizada! ","Erro!", JOptionPane.ERROR_MESSAGE);  
                }
                
            }

	}catch(Exception e){
	JOptionPane.showMessageDialog(null, "Ops, algo deu errado! "+e.getMessage(),"Erro!", JOptionPane.ERROR_MESSAGE);
	}
}

   
    public void filtrar(){
try{

if(jtfPesquisar.getText().isEmpty()){
preencherTabela();
}else{
UsuarioServicos us = servicos.ServicosFactory.getUsuarioServicos();
/* Buscando o valor da JComboBox. O método getSelectedItem
devolve um Object selecionado na JCombo */
String pesquisa = (String) jcbTipoDePesquisa.getSelectedItem();
// Variável que armazenará a pesquisa
String query = null;


// Testar o que o usuário selecionou para realizar a pesquisa no jComboBox

if(pesquisa.equals("Id do Usuário")){
query = "where userid = "+jtfPesquisar.getText();
}else if (pesquisa.equals("Nome Completo")){
    query = "where nome like '%"+jtfPesquisar.getText()+"%'";
}else if(pesquisa.equals("E-mail")){
    query = "where email like '%"+jtfPesquisar.getText()+"%'";
}else if(pesquisa.equals("Data de Nascimento")){
    query = "where datanasc like '%"+jtfPesquisar.getText()+"%'";
}else if(pesquisa.equals("Peso")){
    query = "where peso like '%"+jtfPesquisar.getText()+"%'";
}else if(pesquisa.equals("Altura")){
query = "where altura like '%"+jtfPesquisar.getText()+"%'";
}else if(pesquisa.equals("Alergias")){
query = "where alergias like '%"+jtfPesquisar.getText()+"%'";
}
else {
    query ="where doencas like '%"+jtfPesquisar.getText()+"%'";
}


ArrayList<UsuarioVO> user = new ArrayList<>();
		user = us.filtrar(query);
                
                // Laço que percorre o Array List auxiliar e busca em cada linha preencher com dados de suas respectivas colunas.
                // Ou seja, retorna 1 produto por linha, dividido em colunas como "código, nome, valor custo, quantidade".
                for(int i=0; i<user.size(); i++){
                    dtm.addRow(new String[]{
	
                    String.valueOf(user.get(i).getIdUsuario()),
                    String.valueOf(user.get(i).getNome()),
                    String.valueOf(user.get(i).getEmail()),
                    String.valueOf(user.get(i).getDataNasc()),
                    String.valueOf(user.get(i).getPeso()),
                    String.valueOf(user.get(i).getAltura()),
                    String.valueOf(user.get(i).getAlergias()),
                    String.valueOf(user.get(i).getDoencas()),

                    });

                } // Fecha For
                jTableResultado.setModel(dtm);
}
}catch(Exception e){
JOptionPane.showMessageDialog(null, "Erro ao filtrar os dados! "+e.getMessage(),"Erro!", JOptionPane.ERROR_MESSAGE);
}


}// Fecha Filtrar    
    
 
 public void alterarDados(){
	int linha = jTableResultado.getSelectedRow();
	if(linha != -1){
	// Busca os dados da linha selecionada e envia para cada JTextField da tela Cadastrar
	jtfIdUsuarioAltera.setText((String)jTableResultado.getValueAt(linha, 0));
	jtfNomeCompletoAltera.setText((String)jTableResultado.getValueAt(linha, 1));
	jtfEmailAltera.setText((String)jTableResultado.getValueAt(linha, 2));
	jtfDataNascAltera.setText((String)jTableResultado.getValueAt(linha, 3));
        jtfPesoAltera.setText((String)jTableResultado.getValueAt(linha, 4));
        jtfAlturaAltera.setText((String)jTableResultado.getValueAt(linha, 5));
        jtfAlergiasAltera.setText((String)jTableResultado.getValueAt(linha, 6));
        jtfDoencasAltera.setText((String)jTableResultado.getValueAt(linha, 7));
	}else{
		JOptionPane.showMessageDialog(null, "Você não selecionou nenhuma linha!");
	}
}

 
 
 public void confirmarAlteracao(){
	try{
	UsuarioVO uVo = new UsuarioVO();
        
	uVo.setIdUsuario(Long.parseLong(jtfIdUsuarioAltera.getText()));
	uVo.setNome(jtfNomeCompletoAltera.getText());
        uVo.setEmail(jtfEmailAltera.getText());
        uVo.setDataNasc(Integer.parseInt(jtfDataNascAltera.getText()));
        uVo.setPeso(Double.parseDouble(jtfPesoAltera.getText()));
        uVo.setAltura(Double.parseDouble(jtfAlturaAltera.getText()));
	uVo.setAlergias(jtfAlergiasAltera.getText());
	uVo.setDoencas(jtfDoencasAltera.getText());

	UsuarioServicos us = servicos.ServicosFactory.getUsuarioServicos();
        
	us.alterarUsuario(uVo);
        
        JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso!");
	}catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Ops! Ocorreu um erro na alteração"+e.getMessage());
        }
	
} 
 
    
    public void cancelar(){
        
    jtfNomeCompletoAltera.setText(null);
    jtfDataNascAltera.setText(null);
    jtfPesoAltera.setText(null);
    jtfAlturaAltera.setText(null);
    jtfEmailAltera.setText(null);
    jtfAlergiasAltera.setText(null);
    jtfDoencasAltera.setText(null);
    
    }
    

    /**
     * Creates new form GUIBuscaUsuario
     */
    public GUIBuscaUsuario() {
        initComponents();
        preencherTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpTop = new javax.swing.JPanel();
        jlTituloPrincipal = new javax.swing.JLabel();
        jlTituloAdmin = new javax.swing.JLabel();
        jPanelPesquisarUsuario = new javax.swing.JPanel();
        jlTituloPesquisar = new javax.swing.JLabel();
        jlPesquisar = new javax.swing.JLabel();
        jtfAlturaAltera = new javax.swing.JTextField();
        jcbTipoDePesquisa = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResultado = new javax.swing.JTable();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbConfirmarAlteracao = new javax.swing.JButton();
        jlIdUsuario = new javax.swing.JLabel();
        jlNomeCompleto = new javax.swing.JLabel();
        jlDataNasc = new javax.swing.JLabel();
        jlPeso = new javax.swing.JLabel();
        jlAltura = new javax.swing.JLabel();
        jlAlergias = new javax.swing.JLabel();
        jlDoencas = new javax.swing.JLabel();
        jtfPesquisar = new javax.swing.JTextField();
        jtfAlergiasAltera = new javax.swing.JTextField();
        jtfIdUsuarioAltera = new javax.swing.JTextField();
        jtfDataNascAltera = new javax.swing.JTextField();
        jtfPesoAltera = new javax.swing.JTextField();
        jtfNomeCompletoAltera = new javax.swing.JTextField();
        jtfDoencasAltera = new javax.swing.JTextField();
        jlEmail = new javax.swing.JLabel();
        jtfEmailAltera = new javax.swing.JTextField();

        setClosable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(600, 500));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
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

        jPanelPesquisarUsuario.setBackground(new java.awt.Color(195, 213, 231));

        jlTituloPesquisar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jlTituloPesquisar.setForeground(new java.awt.Color(47, 85, 123));
        jlTituloPesquisar.setText("Pesquisar Usuários");

        jlPesquisar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlPesquisar.setText("Pesquisar por:");

        jtfAlturaAltera.setPreferredSize(new java.awt.Dimension(80, 24));

        jcbTipoDePesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id do Usuário", "Nome Completo", "E-mail", "Data de Nascimento", "Peso", "Altura", "Alergias", "Doenças" }));
        jcbTipoDePesquisa.setPreferredSize(new java.awt.Dimension(200, 24));
        jcbTipoDePesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoDePesquisaActionPerformed(evt);
            }
        });

        jTableResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane1.setViewportView(jTableResultado);

        jbAlterar.setBackground(new java.awt.Color(47, 85, 123));
        jbAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbAlterar.setForeground(new java.awt.Color(255, 255, 255));
        jbAlterar.setText("Alterar");
        jbAlterar.setPreferredSize(new java.awt.Dimension(100, 26));
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbExcluir.setBackground(new java.awt.Color(47, 85, 123));
        jbExcluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jbExcluir.setText("Excluir");
        jbExcluir.setPreferredSize(new java.awt.Dimension(100, 26));
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbConfirmarAlteracao.setBackground(new java.awt.Color(47, 85, 123));
        jbConfirmarAlteracao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbConfirmarAlteracao.setForeground(new java.awt.Color(255, 255, 255));
        jbConfirmarAlteracao.setText("Confirmar Alteração");
        jbConfirmarAlteracao.setPreferredSize(new java.awt.Dimension(160, 26));
        jbConfirmarAlteracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarAlteracaoActionPerformed(evt);
            }
        });

        jlIdUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlIdUsuario.setText("Id do usuário:");

        jlNomeCompleto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlNomeCompleto.setText("Nome Completo:");

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

        jtfPesquisar.setPreferredSize(new java.awt.Dimension(250, 24));
        jtfPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPesquisarKeyReleased(evt);
            }
        });

        jtfAlergiasAltera.setPreferredSize(new java.awt.Dimension(250, 24));

        jtfIdUsuarioAltera.setEnabled(false);
        jtfIdUsuarioAltera.setPreferredSize(new java.awt.Dimension(80, 24));

        jtfDataNascAltera.setPreferredSize(new java.awt.Dimension(80, 24));

        jtfPesoAltera.setPreferredSize(new java.awt.Dimension(80, 24));

        jtfNomeCompletoAltera.setPreferredSize(new java.awt.Dimension(250, 24));

        jtfDoencasAltera.setPreferredSize(new java.awt.Dimension(250, 24));

        jlEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlEmail.setText("E-mail:");

        jtfEmailAltera.setPreferredSize(new java.awt.Dimension(250, 24));

        javax.swing.GroupLayout jPanelPesquisarUsuarioLayout = new javax.swing.GroupLayout(jPanelPesquisarUsuario);
        jPanelPesquisarUsuario.setLayout(jPanelPesquisarUsuarioLayout);
        jPanelPesquisarUsuarioLayout.setHorizontalGroup(
            jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                        .addComponent(jlIdUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfIdUsuarioAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                .addComponent(jlNomeCompleto)
                                .addGap(18, 18, 18)
                                .addComponent(jtfNomeCompletoAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                .addComponent(jbAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jlPeso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfPesoAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jlTituloPesquisar, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelPesquisarUsuarioLayout.createSequentialGroup()
                            .addComponent(jlPesquisar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jtfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jcbTipoDePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                            .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                    .addComponent(jlDoencas)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtfDoencasAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                    .addComponent(jlDataNasc)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtfDataNascAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                                    .addComponent(jlAltura)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtfAlturaAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jbConfirmarAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelPesquisarUsuarioLayout.createSequentialGroup()
                            .addComponent(jlEmail)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jtfEmailAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jlAlergias)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jtfAlergiasAltera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelPesquisarUsuarioLayout.setVerticalGroup(
            jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPesquisarUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTituloPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPesquisar)
                    .addComponent(jcbTipoDePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdUsuario)
                    .addComponent(jlNomeCompleto)
                    .addComponent(jtfIdUsuarioAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNomeCompletoAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDataNasc)
                    .addComponent(jlPeso)
                    .addComponent(jlAltura)
                    .addComponent(jtfAlturaAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDataNascAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPesoAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEmail)
                    .addComponent(jtfEmailAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlAlergias)
                    .addComponent(jtfAlergiasAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanelPesquisarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbConfirmarAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlDoencas)
                    .addComponent(jtfDoencasAltera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPesquisarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPesquisarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbTipoDePesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoDePesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoDePesquisaActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        // TODO add your handling code here:
        deletar();
        limparTabela();
        preencherTabela();
        JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso! ","Confirmação", JOptionPane.INFORMATION_MESSAGE);        
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbConfirmarAlteracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarAlteracaoActionPerformed
        // TODO add your handling code here:
        confirmarAlteracao();
        cancelar();
        limparTabela();
        preencherTabela();
        jbConfirmarAlteracao.setEnabled(false);
        
    }//GEN-LAST:event_jbConfirmarAlteracaoActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        // TODO add your handling code here:
        jbConfirmarAlteracao.setEnabled(true);
        alterarDados();
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jtfPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisarKeyReleased
        // TODO add your handling code here:
        limparTabela();
        filtrar();
    }//GEN-LAST:event_jtfPesquisarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelPesquisarUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResultado;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbConfirmarAlteracao;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JComboBox<String> jcbTipoDePesquisa;
    private javax.swing.JLabel jlAlergias;
    private javax.swing.JLabel jlAltura;
    private javax.swing.JLabel jlDataNasc;
    private javax.swing.JLabel jlDoencas;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlIdUsuario;
    private javax.swing.JLabel jlNomeCompleto;
    private javax.swing.JLabel jlPeso;
    private javax.swing.JLabel jlPesquisar;
    private javax.swing.JLabel jlTituloAdmin;
    private javax.swing.JLabel jlTituloPesquisar;
    private javax.swing.JLabel jlTituloPrincipal;
    private javax.swing.JPanel jpTop;
    private javax.swing.JTextField jtfAlergiasAltera;
    private javax.swing.JTextField jtfAlturaAltera;
    private javax.swing.JTextField jtfDataNascAltera;
    private javax.swing.JTextField jtfDoencasAltera;
    private javax.swing.JTextField jtfEmailAltera;
    private javax.swing.JTextField jtfIdUsuarioAltera;
    private javax.swing.JTextField jtfNomeCompletoAltera;
    private javax.swing.JTextField jtfPesoAltera;
    private javax.swing.JTextField jtfPesquisar;
    // End of variables declaration//GEN-END:variables
}
