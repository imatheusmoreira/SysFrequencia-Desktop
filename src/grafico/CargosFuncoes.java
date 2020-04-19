/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafico;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus Moreira
 */
public class CargosFuncoes extends javax.swing.JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form CargosFuncoes
     */
    public CargosFuncoes() {
        initComponents();
        new funcoes.FuncoesCargosFuncoes().carregaTabela(cbPesquisa, tm);
    }

   @SuppressWarnings({ "rawtypes", "unchecked" })
   private void initComponents() {

        painelTabulado = new javax.swing.JTabbedPane();
        painelCargo = new javax.swing.JPanel();
        lblCargoNome = new javax.swing.JLabel();
        lblCargoDescricao = new javax.swing.JLabel();
        txtCargoNome = new javax.swing.JTextField();
        botaoSalvarCargo = new javax.swing.JButton();
        txtDescricaoCargo = new javax.swing.JTextField();
        painelFuncao = new javax.swing.JPanel();
        lblFuncaoNome = new javax.swing.JLabel();
        txtFuncaoNome = new javax.swing.JTextField();
        btnSalvarFuncao = new javax.swing.JButton();
        painelPesquisa = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        cbPesquisa = new javax.swing.JComboBox();
        botaoExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 320));
        setSize(new java.awt.Dimension(600, 320));
        setResizable(false);
        setTitle("Cargos e Funções");
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setModal(true);
        
        painelTabulado.setFont(painelTabulado.getFont().deriveFont((float)14));
        
        //Painel Cadastros (Pesquisa)
        painelPesquisa.setLayout(null);
        
        tm.addColumn("Nome");

        tabela.setModel(tm);
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabela);
        
        tabela.getColumnModel().getColumn(0).setPreferredWidth(280);

        painelPesquisa.add(jScrollPane1);
        jScrollPane1.setBounds(0, 40, 580, 190);

        cbPesquisa.setFont(cbPesquisa.getFont().deriveFont((float)14));
        cbPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "cargo", "funcao" }));
        painelPesquisa.add(cbPesquisa);
        cbPesquisa.setBounds(0, 10, 200, 25);
        cbPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new funcoes.FuncoesCargosFuncoes().carregaTabela(cbPesquisa, tm);
            }
        });

        botaoExcluir.setFont(botaoExcluir.getFont().deriveFont((float)14));
        botaoExcluir.setText("Excluir");
        painelPesquisa.add(botaoExcluir);
        botaoExcluir.setBounds(478, 10, 100, 25);
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int i = tabela.getSelectedRow();//Pega a linha selecionada da tabela
            	int resp = JOptionPane.showConfirmDialog(null, "Confirma a exclusão?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
                if(resp == JOptionPane.YES_OPTION){
	            	new funcoes.FuncoesCargosFuncoes().insereExclui(2, (String) tm.getValueAt(i, 0), "", (String)cbPesquisa.getSelectedItem());
	            	new funcoes.FuncoesCargosFuncoes().carregaTabela(cbPesquisa, tm);
                }
            }
        });
        
        painelTabulado.addTab("Cadastros", painelPesquisa);

        //Painel Cargo
        painelCargo.setLayout(null);

        lblCargoNome.setFont(lblCargoNome.getFont().deriveFont((float)16));
        lblCargoNome.setText("Nome*");
        painelCargo.add(lblCargoNome);
        lblCargoNome.setBounds(10, 20, 110, 20);
        
        txtCargoNome.setFont(txtCargoNome.getFont().deriveFont((float)16));
        painelCargo.add(txtCargoNome);
        txtCargoNome.setBounds(10, 40, 560, 25);

        lblCargoDescricao.setFont(lblCargoDescricao.getFont().deriveFont((float)16));
        lblCargoDescricao.setText("Descrição");
        painelCargo.add(lblCargoDescricao);
        lblCargoDescricao.setBounds(10, 70, 190, 20);
        
        txtDescricaoCargo.setFont(txtDescricaoCargo.getFont().deriveFont((float)16));
        painelCargo.add(txtDescricaoCargo);
        txtDescricaoCargo.setBounds(10, 90, 560, 25);

        botaoSalvarCargo.setFont(botaoSalvarCargo.getFont().deriveFont((float)14));
        botaoSalvarCargo.setText("Salvar");
        painelCargo.add(botaoSalvarCargo);
        botaoSalvarCargo.setBounds(465, 130, 100, 25);
        botaoSalvarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	new funcoes.FuncoesCargosFuncoes().insereExclui(1, txtCargoNome.getText(), txtDescricaoCargo.getText(), "cargo");
            	new funcoes.FuncoesCargosFuncoes().carregaTabela(cbPesquisa, tm);
            }
        });
      
        painelTabulado.addTab("Novo Cargo", painelCargo);

        //Painel Função
        painelFuncao.setLayout(null);

        lblFuncaoNome.setFont(lblFuncaoNome.getFont().deriveFont((float)16));
        lblFuncaoNome.setText("Nome*");
        painelFuncao.add(lblFuncaoNome);
        lblFuncaoNome.setBounds(10, 20, 110, 20);

        txtFuncaoNome.setFont(txtFuncaoNome.getFont().deriveFont((float)16));
        painelFuncao.add(txtFuncaoNome);
        txtFuncaoNome.setBounds(10, 40, 560, 25);

        btnSalvarFuncao.setFont(btnSalvarFuncao.getFont().deriveFont((float)14));
        btnSalvarFuncao.setText("Salvar");
        btnSalvarFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	new funcoes.FuncoesCargosFuncoes().insereExclui(1, txtFuncaoNome.getText(), "", "funcao");
	            new funcoes.FuncoesCargosFuncoes().carregaTabela(cbPesquisa, tm);
            }
        });
        painelFuncao.add(btnSalvarFuncao);
        btnSalvarFuncao.setBounds(465, 100, 100, 25);

        painelTabulado.addTab("Nova Função", painelFuncao);
        getContentPane().add(painelTabulado);
        painelTabulado.setBounds(0, 5, 590, 270);

        pack();
    }// </editor-fold>                        
                                    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargosFuncoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton botaoSalvarCargo;
    private javax.swing.JButton btnSalvarFuncao;
    private javax.swing.JButton botaoExcluir;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox cbPesquisa;
    private javax.swing.JLabel lblCargoNome;
    private javax.swing.JLabel lblCargoDescricao;
    private javax.swing.JLabel lblFuncaoNome;
    private javax.swing.JPanel painelCargo;
    private javax.swing.JPanel painelPesquisa;
    private javax.swing.JPanel painelFuncao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane painelTabulado;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtCargoNome;
    private javax.swing.JTextField txtDescricaoCargo;
    private javax.swing.JTextField txtFuncaoNome;
    DefaultTableModel tm = new DefaultTableModel();
    // End of variables declaration                   
}
