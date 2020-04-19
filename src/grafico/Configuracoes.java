package grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

import funcoes.FuncoesConfiguracoes;

/**
 *
 * @author Matheus Moreira
 */
public class Configuracoes extends javax.swing.JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form Configura��es
     */
    public Configuracoes() {
        initComponents();
        FuncoesConfiguracoes fc = new FuncoesConfiguracoes();
        jTextField1.setText(fc.pegaURLSaida());
        jTextField2.setText(fc.pegaURLLogoRelatorios());
        jTextField3.setText(fc.pegaURLLogoPrincipal());
        jTextField4.setText(fc.pegaDadosEmail(1));
        jPasswordField1.setText(fc.pegaDadosEmail(2));
        jTextField5.setText(fc.pegaDadosEmail(3));
        jTextArea1.setText(fc.pegaDadosEmail(4));
        jTextField6.setText(fc.pegaDadosEmail(5));
        jTextArea2.setText(fc.pegaDadosEmail(6));
        
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        btnProcurar1 = new javax.swing.JButton();
        btnProcurar2 = new javax.swing.JButton();
        btnProcurar3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        btnSalvarEmail = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(705, 600));
        setSize(new java.awt.Dimension(705, 600));
        getContentPane().setLayout(null);
        setTitle("Configurações");
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, 16));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Configurações");
        //getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 690, 30);

        jLabel2.setFont(jLabel2.getFont().deriveFont((jLabel2.getFont().getStyle() | java.awt.Font.ITALIC)));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Antes de usar estas configurações é necessário que você tenha lido o manual de instruções!");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 10, 690, 20);

        jTabbedPane1.setFont(jTabbedPane1.getFont().deriveFont((float)14));

        jPanel1.setLayout(null);

        jLabel3.setFont(jLabel3.getFont().deriveFont((float)14));
        jLabel3.setText("Localize a pasta onde o sistema vai salvar e/ou buscar os arquivos PDF");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 10, 570, 20);

        jLabel4.setFont(jLabel4.getFont().deriveFont((float)14));
        jLabel4.setText("Localize a imagem usada nos PDFs (preferencialmente png ou jpeg)");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 60, 570, 20);

        jLabel5.setFont(jLabel5.getFont().deriveFont((float)14));
        jLabel5.setText("Localize a logo da tela inicial (preferencialmente png ou jpeg)");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 110, 570, 20);

        jTextField1.setFont(jTextField1.getFont().deriveFont((float)14));
        jPanel1.add(jTextField1);
        jTextField1.setBounds(10, 30, 540, 28);

        jTextField2.setFont(jTextField2.getFont().deriveFont((float)14));
        jPanel1.add(jTextField2);
        jTextField2.setBounds(10, 80, 540, 28);

        jTextField3.setFont(jTextField3.getFont().deriveFont((float)14));
        jPanel1.add(jTextField3);
        jTextField3.setBounds(10, 130, 540, 28);

        btnProcurar1.setFont(btnProcurar1.getFont().deriveFont((float)14));
        btnProcurar1.setText("Procurar");
        jPanel1.add(btnProcurar1);
        btnProcurar1.setBounds(560, 30, 100, 25);
        btnProcurar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fc = new JFileChooser();                
                // restringe a amostra a diretorios apenas
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                
                int res = fc.showOpenDialog(null);
                
                if(res == JFileChooser.APPROVE_OPTION){
                    File diretorio = fc.getSelectedFile();
                    int resp = JOptionPane.showConfirmDialog(null, "Voce escolheu o diretório: " + diretorio+ "\nDeseja usar como saida de arquivos?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
                    if(resp == JOptionPane.YES_OPTION){
                    	jTextField1.setText((""+diretorio).replace("\\", "/"));
                    	new funcoes.FuncoesConfiguracoes().gravaURL(1, jTextField1);
                    }else{
                    	
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Voce não selecionou nenhum diretorio."); 
            
			}
		});

        btnProcurar2.setFont(btnProcurar2.getFont().deriveFont((float)14));
        btnProcurar2.setText("Procurar");
        jPanel1.add(btnProcurar2);
        btnProcurar2.setBounds(560, 80, 100, 25);
        btnProcurar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();                
                // restringe a amostra a diretorios apenas
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                
                int res = fc.showOpenDialog(null);
                
                if(res == JFileChooser.APPROVE_OPTION){
                    File diretorio = fc.getSelectedFile();
                    int resp = JOptionPane.showConfirmDialog(null, "Voce escolheu o arquivo: " + diretorio+ "\nDeseja usar?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
                    if(resp == JOptionPane.YES_OPTION){
                    	jTextField2.setText((""+diretorio).replace("\\", "/"));
                    	new funcoes.FuncoesConfiguracoes().gravaURL(2, jTextField2);
                    }else{
                    	
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Você não selecionou nenhum arquivo."); 
				
			}
		});

        btnProcurar3.setFont(btnProcurar3.getFont().deriveFont((float)14));
        btnProcurar3.setText("Procurar");
        jPanel1.add(btnProcurar3);
        btnProcurar3.setBounds(560, 130, 100, 25);
        btnProcurar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();                
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                
                int res = fc.showOpenDialog(null);
                
                if(res == JFileChooser.APPROVE_OPTION){
                    File diretorio = fc.getSelectedFile();
                    int resp = JOptionPane.showConfirmDialog(null, "Voce escolheu o arquivo: " + diretorio+ "\nDeseja usar?", "Pergunta do Sistema", JOptionPane.YES_NO_OPTION);
                    if(resp == JOptionPane.YES_OPTION){
                    	jTextField3.setText((""+diretorio).replace("\\", "/"));
                    	new funcoes.FuncoesConfiguracoes().gravaURL(3, jTextField3);
                    }else{
                    	
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Voce não selecionou nenhum arquivo."); 
				
			}
		});

        jTabbedPane1.addTab("URLs dos arquivos", jPanel1);

        jPanel2.setLayout(null);

        jLabel6.setFont(jLabel6.getFont().deriveFont((float)14));
        jLabel6.setText("Meu endereço de email (Usar Gmail)");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 10, 390, 20);

        lblSenha.setFont(lblSenha.getFont().deriveFont((float)14));
        lblSenha.setText("Senha");
        jPanel2.add(lblSenha);
        lblSenha.setBounds(10, 60, 300, 20);

        jLabel8.setFont(jLabel8.getFont().deriveFont((float)14));
        jLabel8.setText("Assunto padrão no envio dos PDFs");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 130, 400, 20);

        jTextField4.setFont(jTextField4.getFont().deriveFont((float)14));
        jPanel2.add(jTextField4);
        jTextField4.setBounds(10, 30, 500, 28);

        jPanel2.add(jPasswordField1);
        jPasswordField1.setBounds(10, 80, 210, 28);

        jLabel9.setFont(jLabel9.getFont().deriveFont((float)14));
        jLabel9.setText("Texto padrão no envio dos PDFs");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 180, 260, 20);

        jTextField5.setFont(jTextField5.getFont().deriveFont((float)14));
        jPanel2.add(jTextField5);
        jTextField5.setBounds(10, 150, 660, 28);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(jTextArea1.getFont().deriveFont((float)13));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 200, 660, 96);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(10, 120, 660, 5);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(10, 310, 660, 5);

        jLabel10.setFont(jLabel10.getFont().deriveFont((float)14));
        jLabel10.setText("Assunto padrão no envio dos alertas ao RH");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 320, 370, 17);

        jLabel11.setFont(jLabel11.getFont().deriveFont((float)14));
        jLabel11.setText("Texto padrão no envio dos alertas ao RH");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(10, 370, 390, 17);

        jTextField6.setFont(jTextField6.getFont().deriveFont((float)14));
        jPanel2.add(jTextField6);
        jTextField6.setBounds(10, 340, 660, 28);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(10, 390, 660, 96);

        btnSalvarEmail.setFont(btnSalvarEmail.getFont().deriveFont((float)14));
        btnSalvarEmail.setText("Salvar");
        jPanel2.add(btnSalvarEmail);
        btnSalvarEmail.setBounds(560, 30, 110, 25);
        btnSalvarEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int perg = JOptionPane.showConfirmDialog(null, "Realmente deseja alterar os dados de email?", "Pergunta do sistema", JOptionPane.YES_NO_OPTION);
				if(perg == JOptionPane.YES_OPTION){
					new funcoes.FuncoesConfiguracoes().gravaEmail(jTextField4, jPasswordField1, jTextField5, jTextArea1, jTextField6, jTextArea2);
				}
			}
		});

        btnSair.setFont(btnSair.getFont().deriveFont((float)14));
        btnSair.setText("Sair");
        jPanel2.add(btnSair);
        btnSair.setBounds(560, 60, 110, 25);
        btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int perg = JOptionPane.showConfirmDialog(null, "Realmente deseja sair?", "Pergunta do sistema", JOptionPane.YES_NO_OPTION);
				if(perg == JOptionPane.YES_OPTION){
					dispose();
				}else{
					
				}
			}
		});


        jTabbedPane1.addTab("Informações de email", jPanel2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(3, 30, 690, 530);

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnProcurar1;
    private javax.swing.JButton btnProcurar2;
    private javax.swing.JButton btnProcurar3;
    private javax.swing.JButton btnSalvarEmail;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration                   
}
