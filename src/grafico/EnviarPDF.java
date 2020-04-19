package grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus Moreira
 */
public class EnviarPDF extends javax.swing.JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form AlertarDevolucao
     */
    public EnviarPDF() {
        initComponents();
        new funcoes.FuncoesEnviarPDF().carregaTabela(tm1, "SELECT lotacao, nome, email FROM setor", cbMes, cbAno);
        txtAssunto.setText(new funcoes.FuncoesConfiguracoes().pegaDadosEmail(3));
        taTexto.setText(new funcoes.FuncoesConfiguracoes().pegaDadosEmail(4));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botaoEnviar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        taTexto = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtAssunto = new javax.swing.JTextField();
        spTabela1 = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        botaoLimpar = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        spTabela2 = new javax.swing.JScrollPane();
        tabela2 = new javax.swing.JTable();
        cbMes = new javax.swing.JComboBox();
        cbAno = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        setPreferredSize(new java.awt.Dimension(890, 740));
        setSize(new java.awt.Dimension(890, 740));
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
        setTitle("Enviar PDFs para os setores");

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, 16));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        //getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 880, 40);

        jLabel2.setFont(jLabel2.getFont().deriveFont((float)14));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Clique nos setores desejados. Selecione o mês e ano de referencia à direita.");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 680, 30);

        jLabel3.setFont(jLabel3.getFont().deriveFont((float)14));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Emails Selecionados - Duplo clique para excluir selecionado");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 240, 860, 30);

        taTexto.setColumns(20);
        taTexto.setLineWrap(true);
        taTexto.setRows(20);
        taTexto.setWrapStyleWord(true);
        jScrollPane3.setViewportView(taTexto);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 540, 860, 100);

        jLabel4.setFont(jLabel4.getFont().deriveFont((float)14));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Assunto e texto do email");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 485, 860, 20);

        txtAssunto.setFont(txtAssunto.getFont().deriveFont((float)14));
        getContentPane().add(txtAssunto);
        txtAssunto.setBounds(10, 510, 860, 25);
        
        tm1.addColumn("Lotação");
        tm1.addColumn("Setor");
        tm1.addColumn("Email");
        tm1.addColumn("Local dos arquivos");

        tabela1.setFont(tabela1.getFont().deriveFont((float)12));
        tabela1.setModel(tm1);
        tabela1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        spTabela1.setViewportView(tabela1);
        tabela1.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent a) {//Caso clique em uma linha
				String valor1 = "";
				String valor2 = "";
				String valor3 = "";
				String valor4 = "";

				int i = tabela1.getSelectedRow();
				valor1 += tm1.getValueAt(i, 0);
				valor2 += tm1.getValueAt(i, 1);
				valor3 += tm1.getValueAt(i, 2);
				valor4 += tm1.getValueAt(i, 3);
				
				if(valor3.length()>0){
				int perg = JOptionPane.showConfirmDialog(null,"Deseja adicionar o setor "+valor2+" ?", "Pergunta do Sistema",JOptionPane.YES_NO_OPTION);
					if (perg==JOptionPane.YES_OPTION){
						tm2.addRow(new String[] {valor1, valor2, valor3, valor4});
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
        
        
        tabela1.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabela1.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabela1.getColumnModel().getColumn(2).setPreferredWidth(220);
        tabela1.getColumnModel().getColumn(3).setPreferredWidth(300);

        getContentPane().add(spTabela1);
        spTabela1.setBounds(10, 40, 860, 200);
        
        botaoEnviar.setFont(botaoEnviar.getFont().deriveFont((float)14));
        botaoEnviar.setText("Enviar Emails");
        getContentPane().add(botaoEnviar);
        botaoEnviar.setBounds(460, 660, 130, 25);
        botaoEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resp = JOptionPane.showConfirmDialog(null, "Já posso enviar os arquivos?"
						+ "\nAtenção! Dependendo da velocidade da internet a operação pode demorar vários minutos."
						+ "\nVocê receberá um aviso se o processo terminar com sucesso.", "Pergunta do sistema", JOptionPane.YES_NO_OPTION);
				if(resp == JOptionPane.YES_OPTION){
					if((txtAssunto.getText().length() == 0 || taTexto.getText().length() == 0)){
						JOptionPane.showMessageDialog(null, "O assunto e/ou o texto do email estão em branco.\nPreencha-os e tente novamente.");
					}else if(tm2.getRowCount()<1){
						JOptionPane.showMessageDialog(null, "Nenhum setor foi selecionado!\nSelecione ao menos um e tente novamente.");
					}else{						
						try {
							new funcoes.FuncoesEnviarPDF().enviaEmails(tm2, txtAssunto, taTexto);
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
        botaoLimpar.setBounds(600, 660, 130, 25);
        botaoLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resp = JOptionPane.showConfirmDialog(null, "Realmente deseja limpar o formulário?", "Pergunta do sistema", JOptionPane.YES_NO_OPTION);
				if(resp == JOptionPane.YES_OPTION){
					txtAssunto.setText("");
					taTexto.setText("");
					try {//ESSE METODO LIMPA TODA A TABELA ANTES DE PREENCHER NOVAMENTE.
						int n = 0;
						n = tm2.getRowCount();
						for (int i = 0; i < n;) {
							tm2.removeRow(i);
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						System.err.println(e.getMessage());
					}
				}else{
					
				}
			}
		});

        botaoSair.setFont(botaoSair.getFont().deriveFont((float)14));
        botaoSair.setForeground(java.awt.Color.red);
        botaoSair.setText("Sair");
        getContentPane().add(botaoSair);
        botaoSair.setBounds(740, 660, 130, 25);
        botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resp = JOptionPane.showConfirmDialog(null, "Realmente deseja sair?", "Pergunta do sistema", JOptionPane.YES_NO_OPTION);
				if(resp == JOptionPane.YES_OPTION){
					dispose();
				}else{
					
				}
			}
		});
        
        tm2 = new DefaultTableModel(){   
 		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int mColIndex){   
 		         return false;   
 		    }   
 		};

 		tm2.addColumn("Lotação");
        tm2.addColumn("Setor");
        tm2.addColumn("Email");
        tm2.addColumn("Local dos arquivos");
        
        tabela2.setFont(tabela2.getFont().deriveFont((float)12));
        tabela2.setModel(tm2);
        tabela2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        spTabela2.setViewportView(tabela2);
        
        tabela2.addMouseListener(new MouseAdapter() {
	    	   public void mouseClicked(MouseEvent e) {
	    	      if (e.getClickCount() == 2) {
	    	         JTable target = (JTable)e.getSource();
	    	         int row = target.getSelectedRow();
	    	        // int column = target.getSelectedColumn();
	    	         int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir a lotação selecionada?", "Pergunta do sistema", JOptionPane.YES_NO_OPTION);
	    	         if(resp == JOptionPane.YES_OPTION){
	    	        	 tm2.removeRow(row);
	    	         }else{
	    	        	 
	    	         }
	    	      }
	    	   }
	    });        
        
        tabela2.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabela2.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabela2.getColumnModel().getColumn(2).setPreferredWidth(220);
        tabela2.getColumnModel().getColumn(3).setPreferredWidth(300);

        getContentPane().add(spTabela2);
        spTabela2.setBounds(10, 270, 860, 210);
        
        cbMes.setFont(cbMes.getFont().deriveFont((float)14));
        cbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        cbMes.setSelectedIndex(Integer.parseInt(String.valueOf(Calendar.getInstance().get(Calendar.MONTH))));//Mantem o m�s atual sempre selecionado
        getContentPane().add(cbMes);
        cbMes.setBounds(710, 10, 60, 25);
        cbMes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		new funcoes.FuncoesEnviarPDF().carregaTabela(tm1, "SELECT lotacao, nome, email FROM setor", cbMes, cbAno);
        		try {//ESSE METODO LIMPA TODA A TABELA ANTES DE PREENCHER NOVAMENTE.
					int n = 0;
					n = tm2.getRowCount();
					for (int i = 0; i < n;) {
						tm2.removeRow(i);
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					e.printStackTrace();
				}
			}
		});

        cbAno.setFont(cbAno.getFont().deriveFont((float)14));
        cbAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));
        cbAno.setSelectedItem(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));//Mantem o ano atual sempre selecionado
        getContentPane().add(cbAno);
        cbAno.setBounds(778, 10, 90, 25);
        cbAno.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		new funcoes.FuncoesEnviarPDF().carregaTabela(tm1, "SELECT lotacao, nome, email FROM setor", cbMes, cbAno);
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
                new EnviarPDF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton botaoEnviar;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoSair;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox cbMes;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox cbAno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane spTabela2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane spTabela1;
    private javax.swing.JTable tabela1;
    private javax.swing.JTable tabela2;
    private javax.swing.JTextArea taTexto;
    private javax.swing.JTextField txtAssunto;
    DefaultTableModel tm1 = new DefaultTableModel();
    DefaultTableModel tm2;
    // End of variables declaration                   
}
