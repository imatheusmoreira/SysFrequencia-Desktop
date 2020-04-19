package grafico;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus Moreira
 */
public class Lotacoes extends javax.swing.JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form Lotacoes
     */
    public Lotacoes() {
        initComponents();
        new funcoes.FuncoesLotacoes().carregaTabela(tm);
    }

   private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        botaoSalvar = new javax.swing.JButton();
        txtChefia = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtObservacoes = new javax.swing.JTextField();
        botaoSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        botaoExcluir = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 360));
        setSize(new java.awt.Dimension(700, 360));
        setTitle("Cadastro de Lotações");
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);

        jTabbedPane1.setFont(jTabbedPane1.getFont().deriveFont((float)14));
        
        jTabbedPane1.addTab("Cadastros", jPanel2);
        
        jPanel2.setLayout(null);
        
        tm.addColumn("Cód");
        tm.addColumn("Nome");
        tm.addColumn("Responsável");
        tm.addColumn("Email");
        tm.addColumn("Observações");

        tabela.setModel(tm);
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabela);
        
        tabela.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(140);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(200);
        
        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 680, 250);

        botaoExcluir.setFont(botaoExcluir.getFont().deriveFont((float)14));
        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int i = tabela.getSelectedRow();//Pega a linha selecionada da tabela
            	int resp = JOptionPane.showConfirmDialog(null, "Confirma a exclusão de uma lotação?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
                if(resp == JOptionPane.YES_OPTION){
                	new funcoes.FuncoesLotacoes().insereAtualizaExclui(3, (String) tm.getValueAt(i, 0), (String) tm.getValueAt(i, 1), "", "", "");
                	new funcoes.FuncoesLotacoes().carregaTabela(tm);
                }
            }
        });
        
        jPanel2.add(botaoExcluir);
        botaoExcluir.setBounds(420, 257, 120, 25);
        
        botaoEditar.setFont(botaoEditar.getFont().deriveFont((float)14));
        botaoEditar.setText("Editar");
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int i = tabela.getSelectedRow();//Pega a linha selecionada da tabela
            	int resp = JOptionPane.showConfirmDialog(null, "Deseja Editar a Lotação?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
                if(resp == JOptionPane.YES_OPTION){
                	txtCodigo.setText(String.valueOf(tm.getValueAt(i, 0)));
                	txtNome.setText(String.valueOf(tm.getValueAt(i, 1)));
                	txtChefia.setText(String.valueOf(tm.getValueAt(i, 2)));
                	txtEmail.setText(String.valueOf(tm.getValueAt(i, 3)));
                	txtObservacoes.setText(String.valueOf(tm.getValueAt(i, 4)));
                	jTabbedPane1.setSelectedIndex(1);
                	new funcoes.FuncoesLotacoes().carregaTabela(tm);
                }
            }
        });
        jPanel2.add(botaoEditar);
        botaoEditar.setBounds(290, 257, 120, 25);
        
        jTabbedPane1.addTab("Nova Lotção", jPanel1);

        jPanel1.setLayout(null);

        jLabel2.setFont(jLabel2.getFont().deriveFont((float)16));
        jLabel2.setText("Código");
        //jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 20, 100, 20);

        jLabel3.setFont(jLabel3.getFont().deriveFont((float)16));
        jLabel3.setText("Nome*");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 20, 110, 20);

        jLabel4.setFont(jLabel4.getFont().deriveFont((float)16));
        jLabel4.setText("Responsável (Chefia)*");
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
        botaoSalvar.setBounds(420, 257, 120, 25);
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(new funcoes.Consultas().verSeValorExiste("lotacao", "codigo", txtCodigo.getText()) == 0){
            		int resp = JOptionPane.showConfirmDialog(null, "Confirma o cadastro de uma nova lotação?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
                    if(resp == JOptionPane.YES_OPTION){
                    	new funcoes.FuncoesLotacoes().insereAtualizaExclui(1, txtCodigo.getText(), txtNome.getText(), txtChefia.getText(), txtEmail.getText(), txtObservacoes.getText());
                    	txtCodigo.setText("");
                    	txtNome.setText("");
                    	txtChefia.setText("");
                    	txtEmail.setText("");
                    	txtObservacoes.setText("");
                    }
                }else{
                	int resp = JOptionPane.showConfirmDialog(null, "Confirma o modificação da lotação "+txtNome.getText()+" ?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
                	if(resp == JOptionPane.YES_OPTION){
            		   new funcoes.FuncoesLotacoes().insereAtualizaExclui(2, txtCodigo.getText(), txtNome.getText(), txtChefia.getText(), txtEmail.getText(), txtObservacoes.getText());
            		   txtCodigo.setText("");
            		   txtNome.setText("");
            		   txtChefia.setText("");
            		   txtEmail.setText("");
            		   txtObservacoes.setText("");
                	}
            	}
            	new funcoes.FuncoesLotacoes().carregaTabela(tm);
            }
        });

        txtChefia.setFont(txtChefia.getFont().deriveFont((float)16));
        jPanel1.add(txtChefia);
        txtChefia.setBounds(10, 90, 270, 25);

        lblEmail.setFont(lblEmail.getFont().deriveFont((float)16));
        lblEmail.setText("Email*");
        jPanel1.add(lblEmail);
        lblEmail.setBounds(290, 70, 100, 20);

        txtEmail.setFont(txtEmail.getFont().deriveFont((float)16));
        jPanel1.add(txtEmail);
        txtEmail.setBounds(290, 90, 380, 25);

        jLabel6.setFont(jLabel6.getFont().deriveFont((float)16));
        jLabel6.setText("Observações");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 120, 110, 20);

        txtObservacoes.setFont(txtObservacoes.getFont().deriveFont((float)16));
        jPanel1.add(txtObservacoes);
        txtObservacoes.setBounds(10, 140, 660, 25);

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
        botaoSair.setBounds(550, 285, 120, 25);


        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 690, 320);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        //getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 720, 40);

        pack();
    }// </editor-fold>                        

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lotacoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtChefia;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtObservacoes;
    DefaultTableModel tm = new DefaultTableModel();
    // End of variables declaration                   
}
