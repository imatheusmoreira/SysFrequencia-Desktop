package grafico;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus Moreira
 */
public class Principal extends javax.swing.JFrame implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        disparaRelogio(); //Inicia o rel�gio no canto inferior direito
    }

    private void initComponents() {

    	jPanel1 = new javax.swing.JPanel();
        labelImagem = new javax.swing.JLabel();
        labelRelogio = new javax.swing.JLabel();
        barraDeMenu = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        miServidores = new javax.swing.JMenuItem();
        miInstituicoes = new javax.swing.JMenuItem();
        miSair = new javax.swing.JMenuItem();
        miDigitacao = new javax.swing.JMenuItem();
        miLotacoes = new javax.swing.JMenuItem();
        miSetores = new javax.swing.JMenuItem();
        miCargosEFuncoes = new javax.swing.JMenuItem();
        miFeriados = new javax.swing.JMenuItem();
        miUsuarios = new javax.swing.JMenuItem();
        miConfiguracoes = new javax.swing.JMenuItem();
        miAlertar = new javax.swing.JMenuItem();
        menuGeracaoEnvio = new javax.swing.JMenu();
        miGerarFolhas = new javax.swing.JMenuItem();
        miEnviar = new javax.swing.JMenuItem();
        menuSuporte = new javax.swing.JMenu();
        miAbirPaginaDeChamados = new javax.swing.JMenuItem();
        menuUtilitarios = new javax.swing.JMenu();
        miCalculadora = new javax.swing.JMenuItem();
        miBlocoDeNotas = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        miAjuda = new javax.swing.JMenuItem();
        miSobre = new javax.swing.JMenuItem();
        menuUsuario = new javax.swing.JMenu();
		miAlterarSenha = new javax.swing.JMenuItem();
        
		String versao = funcoes.InfoMySql.versao;
	    String nomeSistema = funcoes.InfoMySql.nomeSistema;
	    
        String matricula = funcoes.InfoMySql.matricula;
		String nivelAcesso = funcoes.InfoMySql.nvAcesso;
	    
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle(nomeSistema + " " + versao + " | " + nivelAcesso.toUpperCase());
        Toolkit tk = Toolkit.getDefaultToolkit();  
        Dimension d = tk.getScreenSize(); 
		setPreferredSize(new java.awt.Dimension(d.width, d.height));
		setSize(new java.awt.Dimension(d.width, d.height));
        setLocationRelativeTo(null);
        
      //coloca uma figura na barra de t�tulo da janela
     	URL url = this.getClass().getResource("/imagens/SysFrequenciaPNG.png");
     	Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
     	this.setIconImage(imagemTitulo);

		jPanel1.setBackground(java.awt.Color.white);
		jPanel1.setLayout(new java.awt.BorderLayout());
		
        labelImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImagem.setIcon(new javax.swing.ImageIcon(new funcoes.FuncoesConfiguracoes().pegaURLLogoPrincipal())); // NOI18N
		jPanel1.add(labelImagem, java.awt.BorderLayout.CENTER);
		
        labelRelogio.setFont(labelRelogio.getFont().deriveFont((float)12));
        labelRelogio.setText("Parece que o relógio não quis carregar :(");
        labelRelogio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelRelogio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(labelRelogio, java.awt.BorderLayout.SOUTH);

		getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        menuCadastros.setText("Cadastros");

        miServidores.setText("Servidores");
        menuCadastros.add(miServidores);
        miServidores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Servidores().setVisible(true);
			}
        });
        
        miInstituicoes.setText("Instituições");
        menuCadastros.add(miInstituicoes);
        miInstituicoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Instituicoes().setVisible(true);
			}
        });

        miLotacoes.setText("Lotações");
        menuCadastros.add(miLotacoes);
        miLotacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Lotacoes().setVisible(true);
			}
		});

        miSetores.setText("Setores");
        menuCadastros.add(miSetores);
        miSetores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Setores().setVisible(true);
			}
		});

        miCargosEFuncoes.setText("Cargos e Funções");
        menuCadastros.add(miCargosEFuncoes);
        miCargosEFuncoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new CargosFuncoes().setVisible(true);	
			}
		});

        miFeriados.setText("Feriados");
        menuCadastros.add(miFeriados);
        miFeriados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Feriados().setVisible(true);		
			}
		});

        miUsuarios.setText("Usuários");
        menuCadastros.add(miUsuarios);
        miUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Usuarios().setVisible(true);
			}
		});

        miConfiguracoes.setText("Configurações");
        menuCadastros.add(miConfiguracoes);
        miConfiguracoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Configuracoes().setVisible(true);		
			}
		});
        
        //menuCadastros.add(new JSeparator());

       //-------------------------------------------------------
        menuGeracaoEnvio.setText("Geração e Envio");
        
        miAlertar.setText("Alertar sobre devolução");
        menuGeracaoEnvio.add(miAlertar);
        miAlertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EnviarAlerta().setVisible(true);		
			}
		});

        miGerarFolhas.setText("Gerar Folhas de Frequência");
        menuGeracaoEnvio.add(miGerarFolhas);
        miGerarFolhas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GeracaoFrequencia().setVisible(true);
			}
		});

        miEnviar.setText("Enviar Folhas de Frequência");
        menuGeracaoEnvio.add(miEnviar);
        miEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EnviarPDF().setVisible(true);		
			}
		});
        
        //-----------------------------------------------------------
        menuSuporte.setText("Suporte de Sistemas");
        //menuBackup.setEnabled(false);

        miAbirPaginaDeChamados.setText("Abrir página de chamados");
        menuSuporte.add(miAbirPaginaDeChamados);
        miAbirPaginaDeChamados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desktop desk = java.awt.Desktop.getDesktop();
				try {
					desk.browse(new java.net.URI("http://ocomon.maracanau.ifce.edu.br/"));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

        //-----------------------------------------------------------
        menuUtilitarios.setText("Utilitários");

        miCalculadora.setText("Calculadora");
        menuUtilitarios.add(miCalculadora);
        miCalculadora.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Runtime rt = Runtime.getRuntime();
				try {
					@SuppressWarnings("unused")
					Process p = rt.exec("calc.exe");
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(getContentPane(),
							"Desculpe mas foi impossivel abrir a calculadora.\nMotivo: "+ ex);
				}
			}
		});

        miBlocoDeNotas.setText("Bloco de Notas");
        menuUtilitarios.add(miBlocoDeNotas);
        miBlocoDeNotas.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Runtime rt = Runtime.getRuntime();
				try {
					@SuppressWarnings("unused")
					Process p = rt.exec("notepad.exe");
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(getContentPane(),
							"Desculpe mas foi impossivel abrir o Bloco de Notas.\nMotivo: "+ ex);
				}
			}
		});
        
        miDigitacao.setText("Digitação de Relatórios");
        //menuUtilitarios.add(miDigitacao);
        miDigitacao.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
			
			}
		});

        //------------------------------------------------------------
        menuAjuda.setText("Ajuda");

        miAjuda.setText("Conteúdo da Ajuda");
        menuAjuda.add(miAjuda);
        miAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File arquivo = new File("Manual_usuario.docx");
				try {
					Desktop.getDesktop().open(arquivo);
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "O arquivo foi excluido ou est� aberto em outro local!\n" + ex,
									""+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});

        miSobre.setText("Sobre");
        menuAjuda.add(miSobre);
        miSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Sobre().setVisible(true);
			}
		});

        //-----------------------------------------------------
        
	    //Definindo n�veis de acesso serv. e estagi�rio
	    //Servidor
//	    if(nivelAcesso.equals("Servidor")){
	    barraDeMenu.add(menuCadastros);
	    barraDeMenu.add(menuSuporte);
//	    }
//	    //Estagi�rio
//	    if(nivelAcesso.equals("Estagiario")){
//    		
//	    }
	        
        barraDeMenu.add(menuGeracaoEnvio);
        barraDeMenu.add(menuUtilitarios);
        barraDeMenu.add(menuAjuda);
        
        barraDeMenu.add(Box.createHorizontalGlue());		
        menuUsuario.setText("Usuário: " + new funcoes.Consultas().retornaNomeServidor(matricula));
		
		miAlterarSenha.setText("Alterar senha");
		miAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new grafico.AlterarSenha().setVisible(true);
			}
		});
		menuUsuario.add(miAlterarSenha);
		
		miSair.setText("Sair");
		menuUsuario.add(miSair);
        miSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Login().setVisible(true);
			}
		});
		
		barraDeMenu.add(menuUsuario);

        setJMenuBar(barraDeMenu);

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    	/* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
	
	private javax.swing.Timer timer;
	SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d' de 'MMMM' de 'yyyy"); // Apenas para criar uma vari�vel de data.
	
    public void disparaRelogio() {
		if (timer == null) {
			timer = new javax.swing.Timer(1000, this);
			timer.setInitialDelay(0);
			timer.start();
		} else if (!timer.isRunning()) {
			timer.restart();
		}
	}

    // Variables declaration - do not modify                     
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelRelogio;
    private javax.swing.JLabel labelImagem;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenu menuGeracaoEnvio;
    private javax.swing.JMenu menuSuporte;
    private javax.swing.JMenu menuUtilitarios;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenuBar barraDeMenu;
    private javax.swing.JMenuItem miServidores;
    private javax.swing.JMenuItem miEnviar;
    private javax.swing.JMenuItem miAbirPaginaDeChamados;
    private javax.swing.JMenuItem miCalculadora;
    private javax.swing.JMenuItem miBlocoDeNotas;
    private javax.swing.JMenuItem miAjuda;
    private javax.swing.JMenuItem miSobre;
    private javax.swing.JMenuItem miInstituicoes;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenuItem miDigitacao;
    private javax.swing.JMenuItem miLotacoes;
    private javax.swing.JMenuItem miSetores;
    private javax.swing.JMenuItem miCargosEFuncoes;
    private javax.swing.JMenuItem miFeriados;
    private javax.swing.JMenuItem miUsuarios;
    private javax.swing.JMenuItem miConfiguracoes;
    private javax.swing.JMenuItem miAlertar;
    private javax.swing.JMenuItem miGerarFolhas;
	private javax.swing.JMenuItem miAlterarSenha;
	private javax.swing.JMenu menuUsuario;
	@Override
	public void actionPerformed(ActionEvent e) {
		GregorianCalendar calendario = new GregorianCalendar();
		int h = calendario.get(GregorianCalendar.HOUR_OF_DAY);
		int m = calendario.get(GregorianCalendar.MINUTE);
		int s = calendario.get(GregorianCalendar.SECOND);

		String hora = ((h < 10) ? "0" : "") + h + ":" + ((m < 10) ? "0" : "")
				+ m + ":" + ((s < 10) ? "0" : "") + s;

		labelRelogio.setText(sdf.format(new Date())+" "+hora);
		
	}

    // End of variables declaration                   
}
