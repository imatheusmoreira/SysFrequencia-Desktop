package grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus Moreira
 */
public class Servidores extends javax.swing.JDialog implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form Servidores
     */
	public Servidores() {
        initComponents();
        new funcoes.FuncoesServidores().carregaTabela(tm, "SELECT matricula, nome, cargo, funcao, lotacao, setor, telefone, celular, email, ch, tipo, ativo, observacoes FROM servidores ORDER BY nome");
        new funcoes.FuncoesServidores().carregaComboBox(cbCargo, "SELECT nome FROM cargo ORDER BY nome");
        new funcoes.FuncoesServidores().carregaComboBox(cbFuncao, "SELECT nome FROM funcao ORDER BY nome");
        new funcoes.FuncoesServidores().carregaComboBox(cbSetor, "SELECT nome FROM setor ORDER BY nome");
        new funcoes.FuncoesServidores().carregaComboBox(cbLotacao, "SELECT nome FROM lotacao ORDER BY nome");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        painelCadastro = new javax.swing.JPanel();
        lblSIAPE = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        painelDadosPessoais = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        painelDadosFuncionais = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox<String>();
        cbFuncao = new javax.swing.JComboBox<String>();
        cbSetor = new javax.swing.JComboBox<String>();
        cbLotacao = new javax.swing.JComboBox<String>();
        cbTipo = new javax.swing.JComboBox();
        cbAtivo = new javax.swing.JComboBox();
        txtSIAPE = new javax.swing.JTextField();
        tfObservacoes = new javax.swing.JTextField();
        painelPesquisar = new javax.swing.JPanel();
        txtPesquisa = new javax.swing.JTextField();
        textCH = new javax.swing.JTextField();
        cbPesquisa = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        lblPesquisa = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        labelTipo = new javax.swing.JLabel();
        labelAtivo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        botaoSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        botaoSair2 = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(760, 610));
        setSize(new java.awt.Dimension(760, 610));
        setResizable(false);
        setModal(true);
        setTitle("Cadastro de Servidores");
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.PLAIN, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Servidores");
        //getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 710, 40);

        jTabbedPane1.setFont(jTabbedPane1.getFont().deriveFont((float)14));

        painelCadastro.setLayout(null);

        lblSIAPE.setFont(lblSIAPE.getFont().deriveFont((float)14));
        lblSIAPE.setText("SIAPE*");
        painelCadastro.add(lblSIAPE);
        lblSIAPE.setBounds(10, 0, 110, 20);

        painelDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        painelDadosPessoais.setFont(painelDadosPessoais.getFont().deriveFont((float)14));
        painelDadosPessoais.setLayout(null);

        jLabel3.setFont(jLabel3.getFont().deriveFont((float)14));
        jLabel3.setText("Nome completo*");
        painelDadosPessoais.add(jLabel3);
        jLabel3.setBounds(10, 20, 160, 20);
        
        txtNome.setFont(txtNome.getFont().deriveFont((float)15));
        painelDadosPessoais.add(txtNome);
        txtNome.setBounds(10, 40, 720, 28);

        jLabel8.setFont(jLabel8.getFont().deriveFont((float)14));
        jLabel8.setText("Telefone");
        painelDadosPessoais.add(jLabel8);
        jLabel8.setBounds(10, 70, 160, 20);

        jLabel9.setFont(jLabel9.getFont().deriveFont((float)14));
        jLabel9.setText("Celular");
        painelDadosPessoais.add(jLabel9);
        jLabel9.setBounds(200, 70, 150, 20);

        jLabel10.setFont(jLabel10.getFont().deriveFont((float)14));
        jLabel10.setText("Email");
        painelDadosPessoais.add(jLabel10);
        jLabel10.setBounds(390, 70, 140, 20);
       

        jTextField2.setFont(jTextField2.getFont().deriveFont((float)14));
        painelDadosPessoais.add(jTextField2);
        jTextField2.setBounds(10, 90, 180, 28);

        jTextField3.setFont(jTextField3.getFont().deriveFont((float)14));
        painelDadosPessoais.add(jTextField3);
        jTextField3.setBounds(200, 90, 180, 28);

        tfEmail.setFont(tfEmail.getFont().deriveFont((float)14));
        painelDadosPessoais.add(tfEmail);
        tfEmail.setBounds(390, 90, 340, 28);

        painelCadastro.add(painelDadosPessoais);
        painelDadosPessoais.setBounds(0, 60, 740, 130);

        painelDadosFuncionais.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados funcionais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        painelDadosFuncionais.setFont(painelDadosFuncionais.getFont().deriveFont((float)14));
        painelDadosFuncionais.setLayout(null);

        jLabel4.setFont(jLabel4.getFont().deriveFont((float)14));
        jLabel4.setText("Cargo");
        painelDadosFuncionais.add(jLabel4);
        jLabel4.setBounds(10, 20, 110, 20);

        jLabel5.setFont(jLabel5.getFont().deriveFont((float)14));
        jLabel5.setText("Função");
        painelDadosFuncionais.add(jLabel5);
        jLabel5.setBounds(360, 20, 120, 20);

        jLabel7.setFont(jLabel7.getFont().deriveFont((float)14));
        jLabel7.setText("Lotação");
        painelDadosFuncionais.add(jLabel7);
        jLabel7.setBounds(10, 70, 110, 20);

        jLabel6.setFont(jLabel6.getFont().deriveFont((float)14));
        jLabel6.setText("Setor");
        painelDadosFuncionais.add(jLabel6);
        jLabel6.setBounds(360, 70, 130, 20);
        
        jLabel14.setFont(jLabel6.getFont().deriveFont((float)14));
        jLabel14.setText("CH/Jornada*");
        painelDadosFuncionais.add(jLabel14);
        jLabel14.setBounds(10, 120, 140, 20);
        
        labelTipo.setFont(labelTipo.getFont().deriveFont((float)14));
        labelTipo.setText("Tipo");
        painelDadosFuncionais.add(labelTipo);
        labelTipo.setBounds(160, 120, 140, 20);
        
        cbTipo.setFont(cbTipo.getFont().deriveFont((float)14));
        painelDadosFuncionais.add(cbTipo);
        cbTipo.setBounds(160, 140, 185, 25);
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Servidor", "Estagiario" }));
        
        labelAtivo.setFont(labelAtivo.getFont().deriveFont((float)14));
        labelAtivo.setText("Ativo?");
        painelDadosFuncionais.add(labelAtivo);
        labelAtivo.setBounds(360, 120, 140, 20);
        
        cbAtivo.setFont(cbAtivo.getFont().deriveFont((float)14));
        painelDadosFuncionais.add(cbAtivo);
        cbAtivo.setBounds(360, 140, 100, 25);
        cbAtivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SIM", "NAO" }));
        
        textCH.setFont(textCH.getFont().deriveFont((float)14));
        textCH.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        painelDadosFuncionais.add(textCH);
        textCH.setBounds(10, 140, 140, 28);

        cbCargo.setFont(cbCargo.getFont().deriveFont((float)14));
        painelDadosFuncionais.add(cbCargo);
        cbCargo.setBounds(10, 40, 335, 25);

        cbFuncao.setFont(cbFuncao.getFont().deriveFont((float)14));
        painelDadosFuncionais.add(cbFuncao);
        cbFuncao.setBounds(360, 40, 370, 25);

        cbSetor.setFont(cbSetor.getFont().deriveFont((float)14));
        painelDadosFuncionais.add(cbSetor);
        cbSetor.setBounds(360, 90, 370, 25);

        cbLotacao.setFont(cbLotacao.getFont().deriveFont((float)14));
        painelDadosFuncionais.add(cbLotacao);
        cbLotacao.setBounds(10, 90, 335, 25);
        cbLotacao.addActionListener(this);

        painelCadastro.add(painelDadosFuncionais);
        painelDadosFuncionais.setBounds(0, 190, 740, 180);

        txtSIAPE.setFont(txtSIAPE.getFont().deriveFont((float)16));
        txtSIAPE.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        painelCadastro.add(txtSIAPE);
        txtSIAPE.setBounds(10, 20, 180, 28);
        
        jLabel11.setFont(jLabel11.getFont().deriveFont((float)14));
        jLabel11.setText("Observações");
        painelCadastro.add(jLabel11);
        jLabel11.setBounds(10, 370, 110, 20);

        tfObservacoes.setFont(tfObservacoes.getFont().deriveFont((float)14));
        painelCadastro.add(tfObservacoes);
        tfObservacoes.setBounds(10, 390, 725, 28);
        
        lblInfo.setFont(lblInfo.getFont().deriveFont((float)12));
        lblInfo.setText("<html>* Campos obrigatórios!</html>");
        painelCadastro.add(lblInfo);
        lblInfo.setBounds(10, 420, 300, 20);

        jTabbedPane1.addTab("Novo Servidor", painelCadastro);

        painelPesquisar.setLayout(null);

        txtPesquisa.setFont(txtPesquisa.getFont().deriveFont((float)14));
        painelPesquisar.add(txtPesquisa);
        txtPesquisa.setBounds(352, 30, 385, 28);
        txtPesquisa.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					new funcoes.FuncoesServidores().pesquisar(txtPesquisa, cbPesquisa, tm);
				}
				if (key == KeyEvent.VK_ESCAPE) {
					txtPesquisa.setText("");
				}
		}});

        cbPesquisa.setFont(cbPesquisa.getFont().deriveFont((float)14));
        cbPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TUDO", "MATRICULA", "NOME", "CARGO", "LOTACAO" }));
        painelPesquisar.add(cbPesquisa);
        cbPesquisa.setBounds(10, 30, 330, 25);
        cbPesquisa.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cbPesquisa.getSelectedIndex() == 0){
					txtPesquisa.setVisible(false);
					lblPesquisa.setText("");
					new funcoes.FuncoesServidores().carregaTabela(tm, "SELECT matricula, nome, cargo, funcao, lotacao, setor, telefone, celular, email, ch, tipo, ativo, observacoes FROM servidores ORDER BY nome");
				}else{
					lblPesquisa.setText("Digite o(a) "+cbPesquisa.getSelectedItem().toString().toLowerCase());
					txtPesquisa.setVisible(true);
					new funcoes.FuncoesServidores().carregaTabela(tm, "SELECT matricula, nome, cargo, funcao, lotacao, setor, telefone, celular, email, ch, tipo, ativo, observacoes FROM servidores ORDER BY nome");
				}				
			}
		});

        jLabel12.setFont(jLabel12.getFont().deriveFont((float)14));
        jLabel12.setText("Pesquisar por");
        painelPesquisar.add(jLabel12);
        jLabel12.setBounds(10, 4, 200, 20);

        lblPesquisa.setFont(lblPesquisa.getFont().deriveFont((float)14));
        lblPesquisa.setText("");
        painelPesquisar.add(lblPesquisa);
        lblPesquisa.setBounds(350, 4, 280, 20);
        
        tm.addColumn("SIAPE");
        tm.addColumn("Nome");
        tm.addColumn("Cargo");
        tm.addColumn("Função");
        tm.addColumn("Lotação");
        tm.addColumn("Setor");
        tm.addColumn("Telefone");
        tm.addColumn("Celular");
        tm.addColumn("Email");
        tm.addColumn("CH");
        tm.addColumn("Tipo");
        tm.addColumn("Ativo");
        tm.addColumn("Observações");

        tabela.setModel(tm);
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(70);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(140);
        
        jScrollPane1.setViewportView(tabela);

        painelPesquisar.add(jScrollPane1);
        jScrollPane1.setBounds(10, 70, 730, 430);

        botaoSalvar.setFont(botaoSalvar.getFont().deriveFont((float)14));
        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int resp = JOptionPane.showConfirmDialog(null, "Está pronto para salvar?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
            	if(resp == JOptionPane.YES_OPTION && txtSIAPE.getText().length()>0){
	            	botaoSalvar.setEnabled(true);
	            	btnAtualizar.setEnabled(false);
	            	new funcoes.FuncoesServidores().insereExcluiAtualiza(1, txtSIAPE.getText(), txtNome.getText(), jTextField2.getText(), jTextField3.getText(), tfEmail.getText(), (String) cbCargo.getSelectedItem(), (String) cbFuncao.getSelectedItem(), (String) cbSetor.getSelectedItem(), (String) cbLotacao.getSelectedItem(), Integer.parseInt(textCH.getText()), (String) cbTipo.getSelectedItem(), (String) cbAtivo.getSelectedItem(), tfObservacoes.getText());
            	}else if(txtSIAPE.getText().length()<=0){
            		JOptionPane.showMessageDialog(null, "SIAPE não pode estar vazio!");
            	}else{
            		
            	}
            }
        });
        painelCadastro.add(botaoSalvar);
        botaoSalvar.setBounds(495, 20, 120, 25);
        
        btnAtualizar.setFont(btnAtualizar.getFont().deriveFont((float)14));
        btnAtualizar.setForeground(java.awt.Color.blue);
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setEnabled(false);
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int resp = JOptionPane.showConfirmDialog(null, "Está pronto para atualizar?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
            	if(resp == JOptionPane.YES_OPTION){
	            	botaoSalvar.setEnabled(true);
	            	btnAtualizar.setEnabled(false);
	            	txtSIAPE.setEnabled(true);
	            	new funcoes.FuncoesServidores().insereExcluiAtualiza(2, txtSIAPE.getText(), txtNome.getText(), jTextField2.getText(), jTextField3.getText(), tfEmail.getText(), (String) cbCargo.getSelectedItem(), (String) cbFuncao.getSelectedItem(), (String) cbSetor.getSelectedItem(), (String) cbLotacao.getSelectedItem(), Integer.parseInt(textCH.getText()), (String) cbTipo.getSelectedItem(), (String) cbAtivo.getSelectedItem(), tfObservacoes.getText());
            	}else{
            		
            	}
            }
        });        
        painelCadastro.add(btnAtualizar);
        btnAtualizar.setBounds(625, 20, 110, 25);
        
        btnSair.setFont(btnSair.getFont().deriveFont((float)14));
        btnSair.setText("Sair");
        painelCadastro.add(btnSair);
        btnSair.setForeground(java.awt.Color.red);
        btnSair.setBounds(640, 510, 100, 25);
        btnSair.addActionListener(this);

        btnEditar.setFont(btnEditar.getFont().deriveFont((float)14));
        btnEditar.setText("Editar");
        painelPesquisar.add(btnEditar);
        btnEditar.setBounds(420, 510, 100, 25);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int resp = JOptionPane.showConfirmDialog(null, "Deseja editar?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
            	if(resp == JOptionPane.YES_OPTION){
            	int i = tabela.getSelectedRow();//Pega a linha selecionada da tabela
	            	txtSIAPE.setText((String) tm.getValueAt(i, 0));
	            	txtNome.setText((String) tm.getValueAt(i, 1));
	            	jTextField2.setText((String) tm.getValueAt(i, 6));
	            	jTextField3.setText((String) tm.getValueAt(i, 7));
	            	tfEmail.setText((String) tm.getValueAt(i, 8));
	            	textCH.setText((String) tm.getValueAt(i, 9));
	            	cbCargo.setSelectedItem((String) tm.getValueAt(i, 2));
	            	cbFuncao.setSelectedItem((String) tm.getValueAt(i, 3));
	            	cbSetor.setSelectedItem((String) tm.getValueAt(i, 5));
	            	cbLotacao.setSelectedItem((String) tm.getValueAt(i, 4));
	            	cbTipo.setSelectedItem((String) tm.getValueAt(i, 10));
	            	cbAtivo.setSelectedItem((String) tm.getValueAt(i, 11));
	            	tfObservacoes.setText((String) tm.getValueAt(i, 12));
	            	jTabbedPane1.setSelectedIndex(0);
	            	botaoSalvar.setEnabled(false);
	            	btnAtualizar.setEnabled(true);
	            	txtSIAPE.setEnabled(false);
            	}else{
            		
            	}            
            }
        });

        botaoExcluir.setFont(botaoExcluir.getFont().deriveFont((float)14));
        botaoExcluir.setText("Excluir");
        painelPesquisar.add(botaoExcluir);
        botaoExcluir.setBounds(530, 510, 100, 25);
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int i = tabela.getSelectedRow();//Pega a linha selecionada da tabela
            	int resp = JOptionPane.showConfirmDialog(null, "Confirma a exclusão de um "+tm.getValueAt(i, 10).toString().toLowerCase()+"?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
                if(resp == JOptionPane.YES_OPTION){
                	new funcoes.FuncoesServidores().insereExcluiAtualiza(3, (String) tm.getValueAt(i, 0), "", "", "", "", "", "", "", "", 0, "", "", "");
                	new funcoes.FuncoesServidores().carregaTabela(tm, "SELECT * FROM servidores ORDER BY nome");
                }
            }
        });

        botaoSair2.setFont(botaoSair2.getFont().deriveFont((float)14));
        botaoSair2.setText("Sair");
        botaoSair2.setForeground(java.awt.Color.red);
        painelPesquisar.add(botaoSair2);
        botaoSair2.setBounds(640, 510, 100, 25);
        botaoSair2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int resp = JOptionPane.showConfirmDialog(null, "Realmente deseja sair?", "Pergunta do sistema", JOptionPane.YES_NO_OPTION);
				if(resp == JOptionPane.YES_OPTION){
					dispose();
				}else{
					
				}
            }
        });

        jTabbedPane1.addTab("Cadastros", painelPesquisar);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(1, 0, 749, 580);

        pack();
    }// </editor-fold>                        

                                         

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton botaoSair2;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JComboBox<String> cbCargo;
    private javax.swing.JComboBox<String> cbFuncao;
    private javax.swing.JComboBox<String> cbSetor;
    private javax.swing.JComboBox<String> cbLotacao;
    private javax.swing.JComboBox<String> cbPesquisa;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JComboBox<String> cbAtivo;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel lblSIAPE;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JLabel labelAtivo;
    private javax.swing.JPanel painelCadastro;
    private javax.swing.JPanel painelPesquisar;
    private javax.swing.JPanel painelDadosPessoais;
    private javax.swing.JPanel painelDadosFuncionais;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtSIAPE;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfObservacoes;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField textCH;
    DefaultTableModel tm = new DefaultTableModel();
    // End of variables declaration                   
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(cbLotacao)){
			new funcoes.Consultas().carregaComboBox(cbSetor, "SELECT nome FROM setor WHERE lotacao = '"+String.valueOf(cbLotacao.getSelectedItem())+"' ORDER BY nome");
		}
		if(e.getSource().equals(btnSair)){
			int tam = txtSIAPE.getText().length();
			if(tam > 0){
				int resp = JOptionPane.showConfirmDialog(null, "Alguns dados não foram salvos.\nSair mesmo assim?", "Pergunta do sistema", JOptionPane.YES_NO_OPTION);
				if(resp == JOptionPane.YES_OPTION){
					dispose();
				}
			}else{
				dispose();
			}
		}
		
	}
}
