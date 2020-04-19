package grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.UnsupportedEncodingException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus Moreira
 */
public class EnviarAlerta extends javax.swing.JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form EnviarAlerta
     */
    public EnviarAlerta() {
        initComponents();
        new funcoes.FuncoesAlertaDevolucao().carregaTabela(tm1, "SELECT lotacao, nome, email FROM setor");
        jTextField1.setText(new funcoes.FuncoesConfiguracoes().pegaDadosEmail(5));
        jTextArea1.setText(new funcoes.FuncoesConfiguracoes().pegaDadosEmail(6));
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botaoEnviar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        botaoLimpar = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(780, 600));
        setSize(new java.awt.Dimension(780, 600));
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
        
        tm2 = new DefaultTableModel(){   
 		   	private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int mColIndex){   
 		         return false;   
 		    }   
 		};
        
        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, 16));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lembrar devolução de folhas ao RH");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 780, 40);

        jLabel2.setFont(jLabel2.getFont().deriveFont((float)14));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Email dos Setores. Clique nos desejados");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 30, 760, 30);

        jLabel3.setFont(jLabel3.getFont().deriveFont((float)14));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Emails Selecionados - Duplo clique para excluir selecionado");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 200, 760, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(20);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane3.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 426, 760, 80);

        jLabel4.setFont(jLabel4.getFont().deriveFont((float)14));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Assunto e texto do email");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 380, 760, 20);

        jTextField1.setFont(jTextField1.getFont().deriveFont((float)14));
        getContentPane().add(jTextField1);
        jTextField1.setBounds(10, 400, 760, 25);
        
        tm1.addColumn("Lotação");
        tm1.addColumn("Setor");
        tm1.addColumn("Email");

        tabela1.setFont(tabela1.getFont().deriveFont((float)12));
        tabela1.setModel(tm1);
        tabela1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane4.setViewportView(tabela1);
        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(10, 60, 760, 140);
        tabela1.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent a) {
				String valor1 = "";
				String valor2 = "";
				String valor3 = "";

				int i = tabela1.getSelectedRow();
				valor1 += tm1.getValueAt(i, 0);
				valor2 += tm1.getValueAt(i, 1);
				valor3 += tm1.getValueAt(i, 2);
				if(valor3.length()>0){
					int perg = JOptionPane.showConfirmDialog(null,"Deseja adicionar o setor "+valor2+" que pertence a(ao) "+valor1+"?", "Pergunta do Sistema",JOptionPane.YES_NO_OPTION);
					if (perg==JOptionPane.YES_OPTION){
						tm2.addRow(new String[] {valor1, valor2, valor3});
					}
				}else{
					JOptionPane.showMessageDialog(null, "Impossível adicionar "+valor2+" pois o email está vazio!", "Aviso do Sistema", JOptionPane.WARNING_MESSAGE);
				}
			}

			@Override
			public void mouseEntered(MouseEvent a) {}

			@Override
			public void mouseExited(MouseEvent a) {}

			@Override
			public void mousePressed(MouseEvent a) {}

			@Override
			public void mouseReleased(MouseEvent a) {}

		});
        
        tabela1.getColumnModel().getColumn(0).setPreferredWidth(140);
        tabela1.getColumnModel().getColumn(1).setPreferredWidth(220);
        tabela1.getColumnModel().getColumn(2).setPreferredWidth(200);
        
        botaoEnviar.setFont(botaoEnviar.getFont().deriveFont((float)14));
        botaoEnviar.setText("Enviar Emails");
        getContentPane().add(botaoEnviar);
        botaoEnviar.setBounds(360, 520, 130, 25);
        botaoEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resp = JOptionPane.showConfirmDialog(null, "Já posso enviar os alertas?\n"
						+ "Atenção! Dependendo da velocidade da internet a operação pode demorar alguns minutos.", "Pergunta do sistema", JOptionPane.YES_NO_OPTION);
				if(resp == JOptionPane.YES_OPTION){
					if((jTextField1.getText().length() == 0 || jTextArea1.getText().length() == 0)){
						JOptionPane.showMessageDialog(null, "O assunto e/ou o texto do email estão em branco.\nPreencha-os e tente novamente.");
					}else if(tm2.getRowCount()<1){
						JOptionPane.showMessageDialog(null, "Nenhuma lotação foi selecionada!\nSelecione ao menos uma e tente novamente.");
					}else{						
						try {
							new funcoes.FuncoesAlertaDevolucao().enviaEmails(tm2, jTextField1, jTextArea1);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else{
					
				}
			}
		});


        botaoLimpar.setFont(botaoLimpar.getFont().deriveFont((float)14));
        botaoLimpar.setText("Limpar dados");
        getContentPane().add(botaoLimpar);
        botaoLimpar.setBounds(500, 520, 130, 25);
        botaoLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resp = JOptionPane.showConfirmDialog(null, "Realmente deseja limpar o formulário?", "Pergunta do sistema", JOptionPane.YES_NO_OPTION);
				if(resp == JOptionPane.YES_OPTION){
					jTextField1.setText("");
					jTextArea1.setText("");
					try {//ESSE METODO LIMPA TODA A TABELA ANTES DE PREENCHER NOVAMENTE.
						int n = 0;
						n = tm2.getRowCount();
						for (int i = 0; i < n;) {
							tm2.removeRow(i);
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						e.printStackTrace();
					}
				}else{
					
				}
			}
		});

        botaoSair.setFont(botaoSair.getFont().deriveFont((float)14));
        botaoSair.setForeground(java.awt.Color.red);
        botaoSair.setText("Sair");
        getContentPane().add(botaoSair);
        botaoSair.setBounds(640, 520, 130, 25);
        botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resp = JOptionPane.showConfirmDialog(null, "Realmente deseja sair?", "Pergunta do sistema", JOptionPane.YES_NO_OPTION);
				if(resp == JOptionPane.YES_OPTION){
					dispose();
				}else{
					
				}
			}
		});

        tm2.addColumn("Lotação");
        tm2.addColumn("Setor");
        tm2.addColumn("Email");
        
        tabela2.setFont(tabela2.getFont().deriveFont((float)12));
        tabela2.setModel(tm2);
        tabela2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabela2);
        
        tabela2.getColumnModel().getColumn(0).setPreferredWidth(140);
        tabela2.getColumnModel().getColumn(1).setPreferredWidth(220);
        tabela2.getColumnModel().getColumn(2).setPreferredWidth(200);
        
        tabela2.addMouseListener(new MouseAdapter() {
	    	   public void mouseClicked(MouseEvent e) {
	    	      if (e.getClickCount() == 2) {
	    	         JTable target = (JTable)e.getSource();
	    	         int row = target.getSelectedRow();
	    	        // int column = target.getSelectedColumn();
	    	         int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir o setor selecionado?", "Pergunta do sistema", JOptionPane.YES_NO_OPTION);
	    	         if(resp == JOptionPane.YES_OPTION){
	    	        	 tm2.removeRow(row);
	    	         }else{
	    	        	 
	    	         }
	    	      }
	    	   }
	    });     

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 230, 760, 130);

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnviarAlerta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton botaoEnviar;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tabela1;
    private javax.swing.JTable tabela2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    DefaultTableModel tm1 = new DefaultTableModel();
    DefaultTableModel tm2;
    // End of variables declaration                   
}
