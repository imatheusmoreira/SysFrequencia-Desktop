package grafico;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus Moreira
 */
public class Setores extends javax.swing.JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form Setores
     */
    @SuppressWarnings("unchecked")
	public Setores() {
        initComponents();
        new funcoes.FuncoesSetores().carregaTabela(tm);
        new funcoes.FuncoesSetores().carregaComboBox(cbLotacao);
    }

    @SuppressWarnings("rawtypes")
	private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        botaoSalvar = new javax.swing.JButton();
        txtChefia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtObs = new javax.swing.JTextField();
        cbLotacao = new javax.swing.JComboBox();
        botaoSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        botaoExcluir = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 510));
        setSize(new java.awt.Dimension(700, 510));
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Cadastro de Setores");
        setModal(true);

        jTabbedPane1.setFont(jTabbedPane1.getFont().deriveFont((float)14));
        
        jPanel2.setLayout(null);
        
        tm.addColumn("Cód");
        tm.addColumn("Nome");
        tm.addColumn("Responsável");
        tm.addColumn("Lotação");
        tm.addColumn("Email");
        tm.addColumn("Observações");

        tabela.setModel(tm);
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabela);

        jPanel2.add(jScrollPane1);
        
        tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(230);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(190);

        jScrollPane1.setBounds(0, 0, 680, 400);

        botaoExcluir.setFont(botaoExcluir.getFont().deriveFont((float)14));
        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int i = tabela.getSelectedRow();//Pega a linha selecionada da tabela
            	int resp = JOptionPane.showConfirmDialog(null, "Confirma a exclusão de um setor?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
                if(resp == JOptionPane.YES_OPTION){
                	new funcoes.FuncoesSetores().insereAtualizaExclui(3, (String) tm.getValueAt(i, 0), "", "", "", "","");
                	new funcoes.FuncoesSetores().carregaTabela(tm);
                }
            }
        });
        jPanel2.add(botaoExcluir);
        botaoExcluir.setBounds(430, 410, 120, 25);
        
        botaoEditar.setFont(botaoEditar.getFont().deriveFont((float)14));
        botaoEditar.setText("Editar");
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int i = tabela.getSelectedRow();//Pega a linha selecionada da tabela
            	int resp = JOptionPane.showConfirmDialog(null, "Confirma a edição de um setor?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
                if(resp == JOptionPane.YES_OPTION){
                	txtCodigo.setText(String.valueOf(tm.getValueAt(i, 0)));
                	txtNome.setText(String.valueOf(tm.getValueAt(i, 1)));
                	txtChefia.setText(String.valueOf(tm.getValueAt(i, 2)));
                	cbLotacao.setSelectedItem(tm.getValueAt(i, 3));
                	txtEmail.setText(String.valueOf(tm.getValueAt(i, 4)));
                	txtObs.setText(String.valueOf(tm.getValueAt(i, 5)));
                	jTabbedPane1.setSelectedIndex(1);
                	new funcoes.FuncoesSetores().carregaTabela(tm);
                }
            }
        });
        jPanel2.add(botaoEditar);
        botaoEditar.setBounds(300, 410, 120, 25);

        jTabbedPane1.addTab("Cadastro", jPanel2);

        jPanel1.setLayout(null);

        lblCodigo.setFont(lblCodigo.getFont().deriveFont((float)16));
        lblCodigo.setText("Código(*)");
        //jPanel1.add(lblCodigo);
        lblCodigo.setBounds(10, 20, 100, 20);

        lblNome.setFont(lblNome.getFont().deriveFont((float)16));
        lblNome.setText("Nome(*)");
        jPanel1.add(lblNome);
        lblNome.setBounds(10, 20, 110, 20);

        jLabel4.setFont(jLabel4.getFont().deriveFont((float)16));
        jLabel4.setText("Responsável (Chefia)");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 70, 190, 20);

        txtCodigo.setFont(txtCodigo.getFont().deriveFont((float)16));
        //jPanel1.add(txtCodigo);
        txtCodigo.setBounds(10, 40, 100, 25);

        txtNome.setFont(txtNome.getFont().deriveFont((float)16));
        jPanel1.add(txtNome);
        txtNome.setBounds(10, 40, 660, 25);

        botaoSalvar.setFont(botaoSalvar.getFont().deriveFont((float)14));
        botaoSalvar.setText("Salvar");
        jPanel1.add(botaoSalvar);
        botaoSalvar.setBounds(430, 410, 120, 25);
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            if(new funcoes.Consultas().verSeValorExiste("setor", "codigo", txtCodigo.getText()) == 0){
            	
            	int resp = JOptionPane.showConfirmDialog(null, "Confirma o cadastro de um novo setor?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
            	if(resp == JOptionPane.YES_OPTION){
            		new funcoes.FuncoesSetores().insereAtualizaExclui(1, txtCodigo.getText(), txtNome.getText(), txtChefia.getText(), (String)cbLotacao.getSelectedItem(), txtEmail.getText(), txtObs.getText());
            		txtCodigo.setText("");
            		txtNome.setText("");
            		txtChefia.setText("");
            		txtEmail.setText("");
            		txtObs.setText("");
            	}
            	
            }else{
            	
            	int resp = JOptionPane.showConfirmDialog(null, "Confirma a modificação do setor "+txtNome.getText()+" ?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
            	if(resp == JOptionPane.YES_OPTION){
            		new funcoes.FuncoesSetores().insereAtualizaExclui(2, txtCodigo.getText(), txtNome.getText(), txtChefia.getText(), (String)cbLotacao.getSelectedItem(), txtEmail.getText(), txtObs.getText());
            		txtCodigo.setText("");
            		txtNome.setText("");
            		txtChefia.setText("");
            		txtEmail.setText("");
            		txtObs.setText("");
            	}
            	
            }
    		new funcoes.FuncoesSetores().carregaTabela(tm);
         }});

        txtChefia.setFont(txtChefia.getFont().deriveFont((float)16));
        jPanel1.add(txtChefia);
        txtChefia.setBounds(10, 90, 270, 25);

        jLabel5.setFont(jLabel5.getFont().deriveFont((float)16));
        jLabel5.setText("Email");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(290, 70, 90, 20);

        txtEmail.setFont(txtEmail.getFont().deriveFont((float)16));
        jPanel1.add(txtEmail);
        txtEmail.setBounds(290, 90, 380, 25);

        jLabel6.setFont(jLabel6.getFont().deriveFont((float)16));
        jLabel6.setText("Lotação (Selecione a lotação que este setor está vinculado)");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 120, 660, 20);

        jLabel7.setFont(jLabel7.getFont().deriveFont((float)16));
        jLabel7.setText("Observações");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 170, 180, 20);

        txtObs.setFont(txtObs.getFont().deriveFont((float)16));
        jPanel1.add(txtObs);
        txtObs.setBounds(10, 190, 660, 25);

        cbLotacao.setFont(cbLotacao.getFont().deriveFont((float)14));
        jPanel1.add(cbLotacao);
        cbLotacao.setBounds(10, 140, 660, 25);

        botaoSair.setFont(botaoSair.getFont().deriveFont((float)14));
        botaoSair.setForeground(java.awt.Color.red);
        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int resp = JOptionPane.showConfirmDialog(null, "Realmente deseja sair?", "Pergunta do sistema", JOptionPane.YES_NO_OPTION);
				if(resp == JOptionPane.YES_OPTION){
					dispose();
				}else{
					
				}
            }
        });
        getContentPane().add(botaoSair);
        botaoSair.setBounds(560, 438, 120, 25);

        jTabbedPane1.addTab("Novo Setor", jPanel1);
        

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 690, 470);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Setores");
        //getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 40);

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Setores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoEditar;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox cbLotacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtChefia;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtObs;
    DefaultTableModel tm = new DefaultTableModel();
    // End of variables declaration                   
}
