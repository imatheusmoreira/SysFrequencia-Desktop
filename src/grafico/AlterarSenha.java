package grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

/**
 *
 * @author Matheus Moreira
 */
public class AlterarSenha extends javax.swing.JDialog implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form AlterarSenha
     */
    public AlterarSenha() {
        initComponents();
    }
                         
    private void initComponents() {

        lblSenhaAtual = new javax.swing.JLabel();
        lblNovaSenha = new javax.swing.JLabel();
        lblConfirmarSenha = new javax.swing.JLabel();
        ftxtSenhaAtual = new javax.swing.JPasswordField();
        ftxtNovaSenha = new javax.swing.JPasswordField();
        ftxtConfirmarSenha = new javax.swing.JPasswordField();
        btnOK = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar senha");
        setPreferredSize(new java.awt.Dimension(225, 220));
        setSize(new java.awt.Dimension(225, 220));
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);

        lblSenhaAtual.setFont(lblSenhaAtual.getFont().deriveFont((float)14));
        lblSenhaAtual.setText("Senha atual");
        getContentPane().add(lblSenhaAtual);
        lblSenhaAtual.setBounds(10, 0, 140, 25);

        lblNovaSenha.setFont(lblNovaSenha.getFont().deriveFont((float)14));
        lblNovaSenha.setText("Nova senha");
        getContentPane().add(lblNovaSenha);
        lblNovaSenha.setBounds(10, 50, 140, 25);

        lblConfirmarSenha.setFont(lblConfirmarSenha.getFont().deriveFont((float)14));
        lblConfirmarSenha.setText("Confirmar senha");
        getContentPane().add(lblConfirmarSenha);
        lblConfirmarSenha.setBounds(10, 100, 140, 25);

        ftxtSenhaAtual.setFont(ftxtSenhaAtual.getFont().deriveFont((float)14));
        getContentPane().add(ftxtSenhaAtual);
        ftxtSenhaAtual.setBounds(10, 20, 200, 25);
        ftxtSenhaAtual.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
//					if (new funcoes.FuncoesUsuarios().senhaCorreta(new String(ftxtSenhaAtual.getPassword()), matricula) == 1){
//						ftxtNovaSenha.setEnabled(true);
//						ftxtConfirmarSenha.setEnabled(true);
//						ftxtNovaSenha.requestFocusInWindow();
//					}else{
//						JOptionPane.showMessageDialog(null, "Senha Inválida!");
//						ftxtNovaSenha.setEnabled(false);
//						ftxtConfirmarSenha.setEnabled(false);
//					}
					ftxtNovaSenha.requestFocusInWindow();
				}
			}
		});

        ftxtNovaSenha.setFont(ftxtNovaSenha.getFont().deriveFont((float)14));
        getContentPane().add(ftxtNovaSenha);
        ftxtNovaSenha.setBounds(10, 70, 200, 25);
        ftxtNovaSenha.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					ftxtConfirmarSenha.requestFocusInWindow();
				}
			}
		});

        ftxtConfirmarSenha.setFont(ftxtConfirmarSenha.getFont().deriveFont((float)14));
        getContentPane().add(ftxtConfirmarSenha);
        ftxtConfirmarSenha.setBounds(10, 120, 200, 25);
        ftxtConfirmarSenha.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					salvaSenha();
				}
			}
		});

        btnOK.setFont(btnOK.getFont().deriveFont((float)14));
        btnOK.setText("OK");
        btnOK.addActionListener(this);
        getContentPane().add(btnOK);
        btnOK.setBounds(10, 150, 90, 25);

        btnCancelar.setFont(btnCancelar.getFont().deriveFont((float)14));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this);
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(110, 150, 100, 25);

        pack();
    }// </editor-fold>                                                               

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarSenha().setVisible(true);
            }
        });
    }
    
    public void salvaSenha(){
    	//Verifica se a senha está correta
		if (new funcoes.FuncoesUsuarios().senhaCorreta(new String(ftxtSenhaAtual.getPassword()), matricula) == 1){
			//Verifica se os campos de nova senha e conformação contém o mesmo valor
			if((new String(ftxtNovaSenha.getPassword()).equals(new String(ftxtConfirmarSenha.getPassword())))){
				new funcoes.FuncoesUsuarios().atualizaSenha(matricula, new String(ftxtConfirmarSenha.getPassword()));				
				dispose();
			}else{
				JOptionPane.showMessageDialog(null, "Confirmação da nova senha não confere. Tente novamente", "Falha", JOptionPane.ERROR_MESSAGE);
				ftxtNovaSenha.setText("");
				ftxtConfirmarSenha.setText("");
				ftxtNovaSenha.requestFocusInWindow();
			}
		}else{
			JOptionPane.showMessageDialog(null, "Senhas atual inválida. Tente novamente", "Falha", JOptionPane.ERROR_MESSAGE);
		}
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOK;
    private javax.swing.JPasswordField ftxtConfirmarSenha;
    private javax.swing.JPasswordField ftxtNovaSenha;
    private javax.swing.JPasswordField ftxtSenhaAtual;
    private javax.swing.JLabel lblConfirmarSenha;
    private javax.swing.JLabel lblNovaSenha;
    private javax.swing.JLabel lblSenhaAtual;
	private String matricula = funcoes.InfoMySql.matricula;

    // End of variables declaration                   
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnOK) && new String(ftxtNovaSenha.getPassword()).length()>0){
			salvaSenha();
		}
		if(e.getSource().equals(btnCancelar)){
			int tam = new String(ftxtNovaSenha.getPassword()).length();
			if(tam > 1){
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
