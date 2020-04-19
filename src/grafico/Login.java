package grafico;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import funcoes.TrataErros;

/**
 *
 * @author Matheus Moreira
 */
public class Login extends javax.swing.JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	/**
     * Carrega o JFrame Login
     */
    public Login() {
        initComponents();

        disparaRelogio(); //Inicia o rel�gio no canto inferior direito
        new funcoes.FuncoesInternas().verificaAvisos();
    }

	private void initComponents() {

        labelBemVindo = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        ftxtSenha = new javax.swing.JPasswordField();
        labelMatricula = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        lblEsqueceuSenha = new javax.swing.JLabel();
        lblInformarUmErro = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        labelRelogio = new javax.swing.JLabel();
        
        //coloca uma figura na barra de t�tulo da janela
     	URL url = this.getClass().getResource("/imagens/SysFrequenciaPNG.png");
     	Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
     	this.setIconImage(imagemTitulo);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(nomeSistema+" "+versao);
        setPreferredSize(new java.awt.Dimension(410, 255));
        setSize(new java.awt.Dimension(410, 255));
        setResizable(false);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        labelBemVindo.setFont(labelBemVindo.getFont().deriveFont((float)22));
        labelBemVindo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBemVindo.setText("Bem-vindo ao "+nomeSistema+"!");
        getContentPane().add(labelBemVindo);
        labelBemVindo.setBounds(0, 10, 400, 30);

        labelMatricula.setFont(labelMatricula.getFont().deriveFont((float)14));
        labelMatricula.setText("SIAPE");
        getContentPane().add(labelMatricula);
        labelMatricula.setBounds(20, 50, 200, 17);
        
        txtMatricula.setFont(txtMatricula.getFont().deriveFont((float)12));
        getContentPane().add(txtMatricula);
        txtMatricula.setBounds(20, 70, 90, 30);
		
        txtMatricula.addKeyListener(Tecla);

        txtNome.setFont(txtNome.getFont().deriveFont((float)14));
        txtNome.setEditable(false);
        txtNome.setFocusable(false);
        getContentPane().add(txtNome);
        txtNome.setBounds(120, 70, 270, 30);
        
        labelSenha.setFont(labelSenha.getFont().deriveFont((float)14));
        labelSenha.setText("Senha");
        getContentPane().add(labelSenha);
        labelSenha.setBounds(20, 110, 200, 17);

        getContentPane().add(ftxtSenha);
        ftxtSenha.setFont(ftxtSenha.getFont().deriveFont((float)14));
        ftxtSenha.setBounds(20, 130, 170, 30);
        ftxtSenha.setEnabled(false);
        ftxtSenha.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {//Se apertar ENTER no campo senha
					new funcoes.FuncoesLogin().validaLogin(txtMatricula, ftxtSenha, Login.this);	
				}

		}});

        btnEntrar.setFont(btnEntrar.getFont().deriveFont((float)14));
        btnEntrar.setText("Entrar");
        getContentPane().add(btnEntrar);
        btnEntrar.setBounds(200, 130, 90, 30);
        btnEntrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		new funcoes.FuncoesLogin().validaLogin(txtMatricula, ftxtSenha, Login.this);			
			}
		});

        btnSair.setFont(btnSair.getFont().deriveFont((float)14));
        btnSair.setText("Sair");
        getContentPane().add(btnSair);
        btnSair.setBounds(300, 130, 90, 30);
        btnSair.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
        
        lblEsqueceuSenha.setText("Esqueceu sua senha?");
        getContentPane().add(lblEsqueceuSenha);
        lblEsqueceuSenha.setBounds(20, 160, 140, 23);
        lblEsqueceuSenha.setForeground(Color.BLUE);
        lblEsqueceuSenha.addMouseListener(new MouseListener() {			 
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblEsqueceuSenha.setText("Esqueceu sua senha?");
				lblEsqueceuSenha.setForeground(Color.BLUE);				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblEsqueceuSenha.setText("Esqueceu sua senha?");
				lblEsqueceuSenha.setForeground(Color.RED);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblEsqueceuSenha.setForeground(Color.MAGENTA);
				lblEsqueceuSenha.setText("Processando...");
				String email = JOptionPane.showInputDialog(null, "Digite seu email para o sistema enviar sua senha");
				if(email.length()>3){
					new funcoes.FuncoesLogin().validaEmail(email);
				}else{
						JOptionPane.showMessageDialog(null, "Email Inválido!");
				}
				lblEsqueceuSenha.setText("Esqueceu sua senha?");
			}
		});
        
        lblInformarUmErro.setText("Informar um erro?");
        getContentPane().add(lblInformarUmErro);
        lblInformarUmErro.setBounds(20, 180, 140, 23);
        lblInformarUmErro.setForeground(Color.BLUE);
        lblInformarUmErro.addMouseListener(new MouseListener() {			
			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
			@Override
			public void mousePressed(MouseEvent arg0) {}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblInformarUmErro.setText("Informar um erro?");
				lblInformarUmErro.setForeground(Color.BLUE);				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblInformarUmErro.setText("Informar um erro?");
				lblInformarUmErro.setForeground(Color.RED);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblInformarUmErro.setForeground(Color.MAGENTA);
				lblInformarUmErro.setText("Processando...");
				Desktop desk = java.awt.Desktop.getDesktop();
				try {
					desk.browse(new java.net.URI("http://ocomon.maracanau.ifce.edu.br/"));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				lblInformarUmErro.setText("Informar um erro?");
			}
		});

        labelRelogio.setFont(labelRelogio.getFont().deriveFont((float)12));
        labelRelogio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        //labelRelogio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(labelRelogio);
        labelRelogio.setBounds(20, 190, 370, 23);

        pack();
    }// </editor-fold>
    
    public void disparaRelogio() {
		if (timer == null) {
			timer = new javax.swing.Timer(1000, this);
			timer.setInitialDelay(0);
			timer.start();
		} else if (!timer.isRunning()) {
			timer.restart();
		}
	}
    
    KeyListener Tecla = new KeyListener() {  
    	@Override  
    	public void keyTyped(KeyEvent e) {}

		@Override
		public void keyPressed(KeyEvent e) {}

		@Override
		public void keyReleased(KeyEvent e) {
			String verificador = "";
				try {
					java.sql.Connection c = funcoes.ConexaoMySQL.getConexaoMySQL();
					
					PreparedStatement pst = c.prepareStatement("SELECT nome FROM servidores where matricula = ? and ehusuario = 'SIM' LIMIT 1");
					pst.setString(1, txtMatricula.getText());
					
					ResultSet r = pst.executeQuery();
					
					if (r.first()) {
						do {
							if (!verificador.equals(r.getString(1)))
								verificador = r.getString(1);
							txtNome.setText(r.getString(1));
							ftxtSenha.setEnabled(true);
						} while (r.next());
					} else {
						txtNome.setText("");
						ftxtSenha.setEnabled(false);
						ftxtSenha.setText("");
					}

					if (verificador.equalsIgnoreCase("")) {
					} else {
						ftxtSenha.setEnabled(true);
						ftxtSenha.requestFocusInWindow();
					}
					pst.close();

				} catch (SQLException e1) {
					new TrataErros().erroSQL(e1);
				}
			
		}
	};
	
	public void actionPerformed(ActionEvent ae) {
		GregorianCalendar calendario = new GregorianCalendar();
		int h = calendario.get(GregorianCalendar.HOUR_OF_DAY);
		int m = calendario.get(GregorianCalendar.MINUTE);
		int s = calendario.get(GregorianCalendar.SECOND);

		String hora = ((h < 10) ? "0" : "") + h + ":" + ((m < 10) ? "0" : "")
				+ m + ":" + ((s < 10) ? "0" : "") + s;

		labelRelogio.setText(sdf.format(new Date())+" "+hora);
		
		//saudação Bom Dia, Boa Tarde Boa Noite de acordo com a hora
		if(h < 4)
			setTitle("Boa Madrugada - "+nomeSistema+" "+versao);
		else if (h > 4 && h < 12)
		    setTitle("Bom dia - "+nomeSistema+" "+versao);
		else if(h >= 12 && h < 18)
			setTitle("Boa Tarde - "+nomeSistema+" "+versao);
		else if(h >= 18 && h < 24)
			setTitle("Boa Noite - "+nomeSistema+" "+versao);
	}

    /**
     * @param args the command line arguments
     * @throws ParseException 
     */
    public static void main(String args[]) throws ParseException {
    	try {
			UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
			
		} catch (javax.swing.UnsupportedLookAndFeelException | ParseException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    private javax.swing.Timer timer;
	SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d' de 'MMMM' de 'yyyy"); // Apenas para criar uma vari�vel de data.
    
	String versao = funcoes.InfoMySql.versao;
	String nomeSistema = funcoes.InfoMySql.nomeSistema;

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSair;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNome;
    private javax.swing.JLabel labelBemVindo;
    private javax.swing.JLabel labelMatricula;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel lblEsqueceuSenha;
    private javax.swing.JLabel lblInformarUmErro;
    private javax.swing.JLabel labelRelogio;
    private javax.swing.JPasswordField ftxtSenha;
    // End of variables declaration                   
}
