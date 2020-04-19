package grafico;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

/**
 *
 * @author Matheus Moreira
 */
public class Usuarios extends javax.swing.JDialog implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form Usuarios
     */
    public Usuarios() {
        initComponents();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        painelUsuarios = new javax.swing.JPanel();
        lblInsiraOSiape = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbEhUsuario = new javax.swing.JComboBox();
        btnPesquisarSIAPE = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        txtCodServidor = new javax.swing.JTextField();
        txtNomeServidor = new javax.swing.JTextField();
        lblSenhaInicial = new javax.swing.JLabel();
        ftxtSenhaInicial = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 250));
        setSize(new java.awt.Dimension(500, 250));
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Cadastro de Usuários");
        setResizable(false);
        setModal(true);

        lblTitulo.setFont(lblTitulo.getFont().deriveFont((float)16));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastro de Usuários");
        //getContentPane().add(lblTitulo);
        lblTitulo.setBounds(0, 0, 490, 40);

        jTabbedPane1.setFont(jTabbedPane1.getFont().deriveFont((float)14));

        painelUsuarios.setLayout(null);        

        lblInsiraOSiape.setFont(lblInsiraOSiape.getFont().deriveFont((float)14));
        lblInsiraOSiape.setText("SIAPE");
        painelUsuarios.add(lblInsiraOSiape);
        lblInsiraOSiape.setBounds(10, 10, 370, 20);
        
        txtCodServidor.setFont(txtCodServidor.getFont().deriveFont((float)14));
        painelUsuarios.add(txtCodServidor);
        txtCodServidor.setBounds(10, 30, 120, 25);
        txtCodServidor.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					new funcoes.Consultas().retornaNomeServidor(txtCodServidor, txtNomeServidor, txtCodServidor);
					new funcoes.FuncoesUsuarios().isUser(txtCodServidor, cbEhUsuario);
					
					if(cbEhUsuario.getSelectedItem().equals("SIM")){
						ftxtSenhaInicial.setEnabled(false);
						lblSenhaInicial.setEnabled(false);
					}else{
						ftxtSenhaInicial.setEnabled(true);
						lblSenhaInicial.setEnabled(true);
					}
					cbEhUsuario.requestFocusInWindow();
				}
		}});

        txtNomeServidor.setFocusable(false);
        txtNomeServidor.setFont(txtNomeServidor.getFont().deriveFont((float)14));
        painelUsuarios.add(txtNomeServidor);
        txtNomeServidor.setBounds(140, 30, 330, 25);
        
        btnPesquisarSIAPE.setFont(btnPesquisarSIAPE.getFont().deriveFont((float)14));
        btnPesquisarSIAPE.setText("Pesquisar SIAPE");
        btnPesquisarSIAPE.addActionListener(this);
        painelUsuarios.add(btnPesquisarSIAPE);
        btnPesquisarSIAPE.setBounds(10, 60, 160, 25);
//-------------------------------------------------------------
        jLabel3.setFont(jLabel3.getFont().deriveFont((float)14));
        jLabel3.setText("É usuário do programa?");
        painelUsuarios.add(jLabel3);
        jLabel3.setBounds(10, 100, 380, 20);

        cbEhUsuario.setFont(cbEhUsuario.getFont().deriveFont((float)14));
        cbEhUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NAO", "SIM" }));
        cbEhUsuario.addActionListener(this);
        painelUsuarios.add(cbEhUsuario);
        cbEhUsuario.setBounds(10, 120, 80, 25);

        lblSenhaInicial.setFont(lblSenhaInicial.getFont().deriveFont((float)14));
        lblSenhaInicial.setText("Senha inicial");
        painelUsuarios.add(lblSenhaInicial);
        lblSenhaInicial.setBounds(10, 160, 400, 20); 

        painelUsuarios.add(ftxtSenhaInicial);
        ftxtSenhaInicial.setBounds(10, 180, 160, 25);
        
        btnSalvar.setFont(btnSalvar.getFont().deriveFont((float)14));
        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(this);
        painelUsuarios.add(btnSalvar);
        btnSalvar.setBounds(260, 180, 100, 25);
        
        btnSair.setFont(btnSair.getFont().deriveFont((float)14));
        btnSair.setForeground(Color.RED);
        btnSair.setText("Sair");
        btnSair.addActionListener(this);
        painelUsuarios.add(btnSair);
        btnSair.setBounds(370, 180, 100, 25);

        jTabbedPane1.addTab("Usuários", painelUsuarios);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(4, -30, 490, 250);

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    	/* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnPesquisarSIAPE;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSair;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox cbEhUsuario;
    private javax.swing.JPasswordField ftxtSenhaInicial;
    private javax.swing.JLabel lblInsiraOSiape;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblSenhaInicial;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painelUsuarios;
    private javax.swing.JTextField txtCodServidor;
    private javax.swing.JTextField txtNomeServidor;
    // End of variables declaration    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if((e.getSource().equals(cbEhUsuario) && txtCodServidor.getText().length() > 0)){
			btnSalvar.setEnabled(true);
		}
		if(e.getSource().equals(btnPesquisarSIAPE)){
			new grafico.CaixaDePesquisa("SELECT matricula, nome FROM servidores ORDER BY nome", txtCodServidor).setVisible(true);
			txtCodServidor.requestFocus();
		}
		if(e.getSource().equals(btnSalvar)){
			new funcoes.FuncoesUsuarios().atualiza(txtCodServidor.getText(), String.valueOf(cbEhUsuario.getSelectedItem()));
			if (new String(ftxtSenhaInicial.getPassword()).length() > 0){
				new funcoes.FuncoesUsuarios().atualizaSenha(txtCodServidor.getText(), new String(ftxtSenhaInicial.getPassword()));	
			}
			ftxtSenhaInicial.setText("");
		}
		if(e.getSource().equals(btnSair)){
			if (new String(ftxtSenhaInicial.getPassword()).length() > 0){
				int resp = JOptionPane.showConfirmDialog(null, "Realmente deseja sair?", "Pergunta do sistema", JOptionPane.YES_NO_OPTION);
				if(resp == JOptionPane.YES_OPTION){
					dispose();
				}
			}else{
				dispose();
			}
		}		
	}
}
