package grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Matheus Moreira
 */
public class Sobre extends javax.swing.JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form Sobre
     */
    public Sobre() {
        initComponents();
    }

    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        labelDescricao = new javax.swing.JLabel();
        labelCriacao = new javax.swing.JLabel();
        labelImagem = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        labelNomeSoftware = new javax.swing.JLabel();
        botaoSair = new javax.swing.JButton();
        
        String versao = funcoes.InfoMySql.versao;
    	String nomeSistema = funcoes.InfoMySql.nomeSistema;

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 480));
        setSize(new java.awt.Dimension(500, 480));
        setResizable(false);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setModal(true);

        jTabbedPane1.setFont(jTabbedPane1.getFont().deriveFont((float)14));

        jPanel1.setLayout(null);

        labelDescricao.setFont(labelDescricao.getFont().deriveFont((float)14));
        labelDescricao.setText("<html><h3>Bem vindo ao "+nomeSistema+"</h3> <p>Agora é muito fácil gerar folhas de frequência sem ficar mexendo em dezenas de arquivos do word ou excel. Com alguns cliques você gera as folhas e ainda tem a opção de enviar por email.</p>");
        jPanel1.add(labelDescricao);
        labelDescricao.setBounds(0, 0, 350, 160);

        labelCriacao.setFont(labelCriacao.getFont().deriveFont((float)14));
        labelCriacao.setText("<html><h3>Desenvolvimento</h3> <p>Núcleo de Desenvolvimento de Software - IFCE Campus Maracanaú</p> <p>Matheus Moreira <i>imatheusmoreira@gmail.com</i></p> <p>Versão "+versao+" - Java 8 - MySql 5+");
        jPanel1.add(labelCriacao);
        labelCriacao.setBounds(0, 160, 490, 130);

        labelImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logoifce.png")));
        jPanel1.add(labelImagem);
        labelImagem.setBounds(330, 0, 170, 310);

        jTabbedPane1.addTab("Sobre", jPanel1);

        jPanel2.setLayout(null);

        jTextArea1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEditable(false);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setLineWrap(true);
        jTextArea1.setText("itextpdf-5.5.5.jar\nmysql-connector-java-5.1.34-bin.jar\njava-mail1.4.5.jar\nsynthetica_2.20.0.jar - Não licenciada\nsyntheticaAluOxide.jar\nsyntheticaPlain.jar\n\nUso restrito ao IFCE Campus Maracanaú. Para uso em outras instituições, consultar desenvolvedor");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(-4, -4, 500, 310);

        jTabbedPane1.addTab("Bibliotecas de terceiros", jPanel2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 60, 500, 340);

        labelNomeSoftware.setFont(labelNomeSoftware.getFont().deriveFont((float)30));
        labelNomeSoftware.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNomeSoftware.setText(nomeSistema);
        getContentPane().add(labelNomeSoftware);
        labelNomeSoftware.setBounds(0, 0, 500, 60);

        botaoSair.setFont(botaoSair.getFont().deriveFont((float)14));
        botaoSair.setText("Sair");
        getContentPane().add(botaoSair);
        botaoSair.setBounds(390, 410, 100, 25);
        botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sobre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton botaoSair;
    private javax.swing.JLabel labelNomeSoftware;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelCriacao;
    private javax.swing.JLabel labelImagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration                   
}
