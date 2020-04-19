package grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;

/**
 *
 * @author Matheus Moreira
 */
public class Instituicoes extends javax.swing.JDialog implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form Institui��es
     */
    public Instituicoes() {
        initComponents();
        new funcoes.FuncoesInstituicoes().carregaTabela(tm, "SELECT cnpj, nomefantasia, cep, email, telefone, municipio FROM instituicoes ORDER BY nomefantasia");
    }

                       
    private void initComponents() {
    	
    	MaskFormatter mascaraData = null;
        try {
        	mascaraData = new MaskFormatter("##-##-####");
        	mascaraData.setPlaceholderCharacter('_');
        } catch (ParseException e) {}

        btnSair = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        painelCadastros = new javax.swing.JPanel();
        lblPesquisarPor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        lblPesquisa = new javax.swing.JLabel();
        cbPesquisa = new javax.swing.JComboBox<>();
        txtPesquisa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        painelNovoCadastro = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        lblNomeEmpresarial = new javax.swing.JLabel();
        lblContrato = new javax.swing.JLabel();
        txtCNPJ = new javax.swing.JTextField();
        txtNomeEmpresarial = new javax.swing.JTextField();
        txtContrato = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        ftxtDataAbertura = new javax.swing.JFormattedTextField(mascaraData);
        txtNomeFantasia = new javax.swing.JTextField();
        txtCodDescAtividadeEcoPrin = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        taCodDescAtividadeEcoSecun = new javax.swing.JTextArea();
        txtCodDescNatuJuridica = new javax.swing.JTextField();
        txtRua = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
        txtMunicipio = new javax.swing.JTextField();
        ftxtCEP = new javax.swing.JFormattedTextField();
        txtEmail = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtEFR = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        ftxtUF = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Instituições");
        setPreferredSize(new java.awt.Dimension(695, 560));
        setSize(new java.awt.Dimension(695, 560));
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
        getContentPane().setLayout(null);

        btnSair.setFont(btnSair.getFont().deriveFont((float)12));
        btnSair.setForeground(java.awt.Color.red);
        btnSair.setText("Sair");
        btnSair.addActionListener(this);
        getContentPane().add(btnSair);
        btnSair.setBounds(600, 488, 80, 25);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        painelCadastros.setLayout(null);

        lblPesquisarPor.setFont(lblPesquisarPor.getFont().deriveFont((float)14));
        lblPesquisarPor.setText("Pesquisar por");
        painelCadastros.add(lblPesquisarPor);
        lblPesquisarPor.setBounds(10, 5, 200, 20);
        
        tm.addColumn("CNPJ");
        tm.addColumn("Nome fantasia");
        tm.addColumn("CEP");
        tm.addColumn("E-mail");
        tm.addColumn("Telefone");
        tm.addColumn("Município");

        tabela.setModel(tm);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(90);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(120);
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabela);

        painelCadastros.add(jScrollPane1);
        jScrollPane1.setBounds(10, 60, 670, 390);

        btnEditar.setFont(btnEditar.getFont().deriveFont((float)12));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(this);
        painelCadastros.add(btnEditar);
        btnEditar.setBounds(420, 460, 80, 25);

        btnExcluir.setFont(btnExcluir.getFont().deriveFont((float)12));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(this);
        painelCadastros.add(btnExcluir);
        btnExcluir.setBounds(510, 460, 80, 25);

        cbPesquisa.setFont(cbPesquisa.getFont().deriveFont((float)14));
        cbPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SEM FILTROS", "CNPJ", "NOME FANTASIA", "MUNICIPIO" }));
        cbPesquisa.addActionListener(this);
        painelCadastros.add(cbPesquisa);
        cbPesquisa.setBounds(10, 25, 200, 25);        

        lblPesquisa.setFont(lblPesquisa.getFont().deriveFont((float)12));
        lblPesquisa.setText("");
        painelCadastros.add(lblPesquisa);
        lblPesquisa.setBounds(220, 4, 290, 20);

        txtPesquisa.setFont(txtPesquisa.getFont().deriveFont((float)14));
        painelCadastros.add(txtPesquisa);
        txtPesquisa.setBounds(220, 25, 300, 25);
        txtPesquisa.setVisible(false);

        btnPesquisar.setFont(btnPesquisar.getFont().deriveFont((float)14));
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(this);
        painelCadastros.add(btnPesquisar);
        btnPesquisar.setBounds(530, 25, 150, 25);

        jTabbedPane1.addTab("Cadastros", painelCadastros);

        painelNovoCadastro.setLayout(null);

        lblCodigo.setFont(lblCodigo.getFont().deriveFont((float)12));
        lblCodigo.setText("CNPJ*");
        painelNovoCadastro.add(lblCodigo);
        lblCodigo.setBounds(10, 0, 100, 25);

        lblNomeEmpresarial.setFont(lblNomeEmpresarial.getFont().deriveFont((float)12));
        lblNomeEmpresarial.setText("Nome empresarial*");
        painelNovoCadastro.add(lblNomeEmpresarial);
        lblNomeEmpresarial.setBounds(170, 0, 140, 25);

        lblContrato.setFont(lblContrato.getFont().deriveFont((float)12));
        lblContrato.setText("Contrato (Numero/Ano)");
        //painelNovoCadastro.add(lblContrato);
        lblContrato.setBounds(10, 430, 150, 25);

        txtCNPJ.setFont(txtCNPJ.getFont().deriveFont((float)12));
        painelNovoCadastro.add(txtCNPJ);
        txtCNPJ.setBounds(10, 20, 150, 25);

        txtNomeEmpresarial.setFont(txtNomeEmpresarial.getFont().deriveFont((float)12));
        painelNovoCadastro.add(txtNomeEmpresarial);
        txtNomeEmpresarial.setBounds(170, 20, 400, 25);

        txtContrato.setFont(txtContrato.getFont().deriveFont((float)12));
        //painelNovoCadastro.add(txtContrato);
        txtContrato.setBounds(10, 450, 150, 25);

        jLabel1.setFont(jLabel1.getFont().deriveFont((float)12));
        jLabel1.setText("Nome Fantasia*");
        painelNovoCadastro.add(jLabel1);
        jLabel1.setBounds(10, 50, 140, 25);

        jLabel2.setFont(jLabel2.getFont().deriveFont((float)12));
        jLabel2.setText("Código e descrição da atividade econônica principal");
        painelNovoCadastro.add(jLabel2);
        jLabel2.setBounds(10, 100, 310, 25);

        jLabel3.setFont(jLabel3.getFont().deriveFont((float)12));
        jLabel3.setText("Código e descrição das atividades economicas secundárias");
        painelNovoCadastro.add(jLabel3);
        jLabel3.setBounds(10, 150, 350, 25);

        jLabel4.setFont(jLabel4.getFont().deriveFont((float)12));
        jLabel4.setText("Rua");
        painelNovoCadastro.add(jLabel4);
        jLabel4.setBounds(10, 280, 60, 25);

        jLabel5.setFont(jLabel5.getFont().deriveFont((float)12));
        jLabel5.setText("Número");
        painelNovoCadastro.add(jLabel5);
        jLabel5.setBounds(420, 280, 70, 25);

        jLabel6.setFont(jLabel6.getFont().deriveFont((float)12));
        jLabel6.setText("Código e descrição de natureza juridica");
        painelNovoCadastro.add(jLabel6);
        jLabel6.setBounds(10, 230, 250, 25);

        jLabel7.setFont(jLabel7.getFont().deriveFont((float)12));
        jLabel7.setText("Complemento");
        painelNovoCadastro.add(jLabel7);
        jLabel7.setBounds(500, 280, 130, 25);

        jLabel8.setFont(jLabel8.getFont().deriveFont((float)12));
        jLabel8.setText("CEP");
        painelNovoCadastro.add(jLabel8);
        jLabel8.setBounds(560, 330, 50, 25);

        jLabel9.setFont(jLabel9.getFont().deriveFont((float)12));
        jLabel9.setText("Bairro/Distrito");
        painelNovoCadastro.add(jLabel9);
        jLabel9.setBounds(10, 330, 100, 25);

        jLabel10.setFont(jLabel10.getFont().deriveFont((float)12));
        jLabel10.setText("Município");
        painelNovoCadastro.add(jLabel10);
        jLabel10.setBounds(220, 330, 100, 25);

        jLabel11.setFont(jLabel11.getFont().deriveFont((float)12));
        jLabel11.setText("UF");
        painelNovoCadastro.add(jLabel11);
        jLabel11.setBounds(500, 330, 30, 25);

        jLabel12.setFont(jLabel12.getFont().deriveFont((float)12));
        jLabel12.setText("E-mail");
        painelNovoCadastro.add(jLabel12);
        jLabel12.setBounds(10, 380, 70, 25);

        jLabel13.setFont(jLabel13.getFont().deriveFont((float)12));
        jLabel13.setText("Telefone");
        painelNovoCadastro.add(jLabel13);
        jLabel13.setBounds(220, 380, 49, 25);

        jLabel14.setFont(jLabel14.getFont().deriveFont((float)12));
        jLabel14.setText("Ente Federativo Responsável");
        painelNovoCadastro.add(jLabel14);
        jLabel14.setBounds(500, 380, 180, 25);

        jLabel16.setFont(jLabel16.getFont().deriveFont((float)12));
        jLabel16.setText("Data de abertura");
        painelNovoCadastro.add(jLabel16);
        jLabel16.setBounds(580, 0, 110, 25);

        ftxtDataAbertura.setFont(ftxtDataAbertura.getFont().deriveFont((float)12));
        painelNovoCadastro.add(ftxtDataAbertura);
        ftxtDataAbertura.setBounds(580, 20, 100, 25);

        txtNomeFantasia.setFont(txtNomeFantasia.getFont().deriveFont((float)12));
        painelNovoCadastro.add(txtNomeFantasia);
        txtNomeFantasia.setBounds(10, 70, 670, 25);

        txtCodDescAtividadeEcoPrin.setFont(txtCodDescAtividadeEcoPrin.getFont().deriveFont((float)12));
        painelNovoCadastro.add(txtCodDescAtividadeEcoPrin);
        txtCodDescAtividadeEcoPrin.setBounds(10, 120, 670, 25);

        taCodDescAtividadeEcoSecun.setColumns(20);
        taCodDescAtividadeEcoSecun.setFont(taCodDescAtividadeEcoSecun.getFont().deriveFont((float)12));
        taCodDescAtividadeEcoSecun.setRows(5);
        jScrollPane2.setViewportView(taCodDescAtividadeEcoSecun);

        painelNovoCadastro.add(jScrollPane2);
        jScrollPane2.setBounds(10, 170, 670, 60);

        txtCodDescNatuJuridica.setFont(txtCodDescNatuJuridica.getFont().deriveFont((float)12));
        painelNovoCadastro.add(txtCodDescNatuJuridica);
        txtCodDescNatuJuridica.setBounds(10, 250, 670, 25);

        txtRua.setFont(txtRua.getFont().deriveFont((float)12));
        painelNovoCadastro.add(txtRua);
        txtRua.setBounds(10, 300, 400, 25);

        txtNumero.setFont(txtNumero.getFont().deriveFont((float)12));
        painelNovoCadastro.add(txtNumero);
        txtNumero.setBounds(420, 300, 70, 25);

        txtComplemento.setFont(txtComplemento.getFont().deriveFont((float)12));
        painelNovoCadastro.add(txtComplemento);
        txtComplemento.setBounds(500, 300, 180, 25);

        txtMunicipio.setFont(txtMunicipio.getFont().deriveFont((float)12));
        painelNovoCadastro.add(txtMunicipio);
        txtMunicipio.setBounds(220, 350, 270, 25);

        ftxtCEP.setFont(ftxtCEP.getFont().deriveFont((float)12));
        painelNovoCadastro.add(ftxtCEP);
        ftxtCEP.setBounds(560, 350, 120, 25);

        txtEmail.setFont(txtEmail.getFont().deriveFont((float)12));
        painelNovoCadastro.add(txtEmail);
        txtEmail.setBounds(10, 400, 200, 25);

        txtTelefone.setFont(txtTelefone.getFont().deriveFont((float)12));
        painelNovoCadastro.add(txtTelefone);
        txtTelefone.setBounds(220, 400, 270, 25);

        txtEFR.setFont(txtEFR.getFont().deriveFont((float)12));
        painelNovoCadastro.add(txtEFR);
        txtEFR.setBounds(500, 400, 180, 25);

        txtBairro.setFont(txtBairro.getFont().deriveFont((float)12));
        painelNovoCadastro.add(txtBairro);
        txtBairro.setBounds(10, 350, 200, 25);

        ftxtUF.setFont(ftxtUF.getFont().deriveFont((float)12));
        painelNovoCadastro.add(ftxtUF);
        ftxtUF.setBounds(500, 350, 50, 25);
        
        lblInfo.setFont(lblInfo.getFont().deriveFont((float)12));
        lblInfo.setText("<html>* Campos obrigatórios!</html>");
        painelNovoCadastro.add(lblInfo);
        lblInfo.setBounds(10, 460, 300, 20);

        btnSalvar.setFont(btnSalvar.getFont().deriveFont((float)12));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(this);
        painelNovoCadastro.add(btnSalvar);
        btnSalvar.setBounds(500, 460, 90, 25);

        jTabbedPane1.addTab("Nova Instituição", painelNovoCadastro);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 700, 530);

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
    	try {
			UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
			
		} catch (javax.swing.UnsupportedLookAndFeelException | ParseException ex) {
			java.util.logging.Logger.getLogger(Instituicoes.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Instituicoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbPesquisa;
    private javax.swing.JFormattedTextField ftxtCEP;
    private javax.swing.JFormattedTextField ftxtDataAbertura;
    private javax.swing.JFormattedTextField ftxtUF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblContrato;
    private javax.swing.JLabel lblNomeEmpresarial;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JLabel lblPesquisarPor;
    private javax.swing.JPanel painelCadastros;
    private javax.swing.JPanel painelNovoCadastro;
    private javax.swing.JTextArea taCodDescAtividadeEcoSecun;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCNPJ;
    private javax.swing.JTextField txtCodDescAtividadeEcoPrin;
    private javax.swing.JTextField txtCodDescNatuJuridica;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtContrato;
    private javax.swing.JTextField txtEFR;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNomeEmpresarial;
    private javax.swing.JTextField txtNomeFantasia;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtTelefone;
    DefaultTableModel tm = new DefaultTableModel();
    // End of variables declaration                   
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnExcluir)){
			int i = tabela.getSelectedRow();//Pega a linha selecionada da tabela
        	int resp = JOptionPane.showConfirmDialog(null, "Confirma a exclusão da instituição "+tm.getValueAt(i, 1)+"?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
        	if(resp == JOptionPane.YES_OPTION){
    			
        		new funcoes.FuncoesInstituicoes().deleta(Integer.parseInt((String)tm.getValueAt(i, 0)));
        		new funcoes.FuncoesInstituicoes().carregaTabela(tm, "SELECT cnpj, nomefantasia, cep, email, telefone, municipio FROM instituicoes ORDER BY nomefantasia");
        	}
		}
		
		if(e.getSource().equals(btnEditar)){
			int resp = JOptionPane.showConfirmDialog(null, "Deseja editar?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
        	if(resp == JOptionPane.YES_OPTION){
        		int i = tabela.getSelectedRow();//Pega a linha selecionada da tabela
        		
        		String CNPJ = String.valueOf(tm.getValueAt(i, 0));
        		String[] dadosEmpresa = new funcoes.FuncoesInstituicoes().retornaDadosInstituicao(CNPJ);
        		
        		txtCNPJ.setText(dadosEmpresa[0]);
        		txtNomeEmpresarial.setText(dadosEmpresa[1].toUpperCase());
        		txtNomeFantasia.setText(dadosEmpresa[2].toUpperCase());
        		ftxtDataAbertura.setText(dadosEmpresa[3]);
        		txtCodDescAtividadeEcoPrin.setText(dadosEmpresa[4]);
        		taCodDescAtividadeEcoSecun.setText(dadosEmpresa[5]);
        		txtCodDescNatuJuridica.setText(dadosEmpresa[6]);
        		txtRua.setText(dadosEmpresa[7]);
        		txtNumero.setText(dadosEmpresa[8]);
        		txtComplemento.setText(dadosEmpresa[9]);
        		txtBairro.setText(dadosEmpresa[10]);
        		txtMunicipio.setText(dadosEmpresa[11]);
        		ftxtUF.setText(dadosEmpresa[12]);
        		ftxtCEP.setText(dadosEmpresa[13]);
        		txtEmail.setText(dadosEmpresa[14]);
        		txtTelefone.setText(dadosEmpresa[15]);
        		txtEFR.setText(dadosEmpresa[16]);
        		txtContrato.setText(dadosEmpresa[17]);
        		
        		jTabbedPane1.setSelectedIndex(1);
        	}
		}
		if(e.getSource().equals(btnSalvar)){
			
        	if(new funcoes.Consultas().verSeValorExiste("instituicoes", "cnpj", txtCNPJ.getText()) == 0){//Se não existe esse código cadastrado, irá salvar
        		int resp = JOptionPane.showConfirmDialog(null, "Está pronto para salvar?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
            	if(resp == JOptionPane.YES_OPTION && txtCNPJ.getText().length() > 0){
            		
            		String dados[] = new String[20];
            		dados[0] = txtCNPJ.getText();
            		dados[1] = txtNomeEmpresarial.getText().toUpperCase();
            		dados[2] = txtNomeFantasia.getText().toUpperCase();
            		dados[3] = ftxtDataAbertura.getText();
            		dados[4] = txtCodDescAtividadeEcoPrin.getText();
            		dados[5] = taCodDescAtividadeEcoSecun.getText();
            		dados[6] = txtCodDescNatuJuridica.getText();
            		dados[7] = txtRua.getText();
            		dados[8] = txtNumero.getText();
            		dados[9] = txtComplemento.getText();
            		dados[10] = txtBairro.getText();
            		dados[11] = txtMunicipio.getText();
            		dados[12] = ftxtUF.getText();         		
            		dados[13] = ftxtCEP.getText();
            		dados[14] = txtEmail.getText();
            		dados[15] = txtTelefone.getText();
            		dados[16] = txtEFR.getText();
            		dados[17] = txtContrato.getText();
            		
            		new funcoes.FuncoesInstituicoes().insereAtualiza(1, dados);
            		new funcoes.FuncoesInstituicoes().carregaTabela(tm, "SELECT cnpj, nomefantasia, cep, email, telefone, municipio FROM instituicoes ORDER BY nomefantasia");
            		
            	}else if(txtCNPJ.getText().length() <= 0){
            		JOptionPane.showMessageDialog(null, "CNPJ não pode estar vazio!");
            }
        		
        	}else{//Se existe esse c�digo, ir� atualizar.
        		int resp = JOptionPane.showConfirmDialog(null, "Está pronto para atualizar?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
            	if(resp == JOptionPane.YES_OPTION && txtCNPJ.getText().length() > 0){
            		
            		String dados[] = new String[20];
            		dados[0] = txtCNPJ.getText();
            		dados[1] = txtNomeEmpresarial.getText().toUpperCase();
            		dados[2] = txtNomeFantasia.getText().toUpperCase();
            		dados[3] = ftxtDataAbertura.getText();
            		dados[4] = txtCodDescAtividadeEcoPrin.getText();
            		dados[5] = taCodDescAtividadeEcoSecun.getText();
            		dados[6] = txtCodDescNatuJuridica.getText();
            		dados[7] = txtRua.getText();
            		dados[8] = txtNumero.getText();
            		dados[9] = txtComplemento.getText();
            		dados[10] = txtBairro.getText();
            		dados[11] = txtMunicipio.getText();
            		dados[12] = ftxtUF.getText();         		
            		dados[13] = ftxtCEP.getText();
            		dados[14] = txtEmail.getText();
            		dados[15] = txtTelefone.getText();
            		dados[16] = txtEFR.getText();
            		dados[17] = txtContrato.getText();
            		
            		new funcoes.FuncoesInstituicoes().insereAtualiza(2, dados);
            		new funcoes.FuncoesInstituicoes().carregaTabela(tm, "SELECT cnpj, nomefantasia, cep, email, telefone, municipio FROM instituicoes ORDER BY nomefantasia");
            	
            	}            		
        	}
        	
		}
		if(e.getSource().equals(cbPesquisa)){
			if(cbPesquisa.getSelectedIndex() == 0){
				txtPesquisa.setVisible(false);
				lblPesquisa.setText("");
			}else{
				lblPesquisa.setText("Digite o(a) "+cbPesquisa.getSelectedItem().toString().toLowerCase());
				txtPesquisa.setVisible(true);
				new funcoes.FuncoesInstituicoes().carregaTabela(tm, "SELECT cnpj, nomefantasia, cep, email, telefone, municipio FROM instituicoes ORDER BY nomefantasia");
			}
		}
		if(e.getSource().equals(btnPesquisar)){
			new funcoes.FuncoesInstituicoes().pesquisar(txtPesquisa, cbPesquisa, tm);
		}
		if(e.getSource().equals(btnSair)){
			int tam = txtCNPJ.getText().length();
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
