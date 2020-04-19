package grafico;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import funcoes.FuncoesFeriados;

/**
 *
 * @author Matheus Moreira
 */
public class Feriados extends javax.swing.JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form Feriados
     */
    public Feriados() {
        initComponents();
        new FuncoesFeriados().controleDatasCristas();
        new FuncoesFeriados().carregaTabela(tm1);//Após iniciar os componentes preenche a tabela.
        new FuncoesFeriados().gerarCod(jTextField1);
    }
                          
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        botaoGravar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        botaoExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botaoSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(520, 350));
        setPreferredSize(new java.awt.Dimension(520, 350));
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setModal(true);

        jTabbedPane1.setFont(jTabbedPane1.getFont().deriveFont((float)14));

        jPanel1.setLayout(null);

        jLabel2.setFont(jLabel2.getFont().deriveFont((float)16));
        jLabel2.setText("C�digo");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 10, 110, 20);

        jLabel3.setFont(jLabel3.getFont().deriveFont((float)16));
        jLabel3.setText("Nome*");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 70, 110, 20);

        jLabel4.setFont(jLabel4.getFont().deriveFont((float)16));
        jLabel4.setText("Dia*");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 130, 110, 20);

        jTextField1.setEditable(false);
        jTextField1.setFont(jTextField1.getFont().deriveFont((float)16));
        jTextField1.setFocusable(false);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(20, 35, 120, 25);

        jTextField2.setFont(jTextField2.getFont().deriveFont((float)16));
        jPanel1.add(jTextField2);
        jTextField2.setBounds(20, 90, 485, 30);

        botaoGravar.setFont(botaoGravar.getFont().deriveFont((float)14));
        botaoGravar.setText("Gravar");
        jPanel1.add(botaoGravar);
        botaoGravar.setBounds(300, 210, 100, 25);
        botaoGravar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				int dia = Integer.parseInt(jFormattedTextField1.getText());
				int mes = Integer.parseInt(jFormattedTextField2.getText());
				
				if((dia>0&&dia<=31)||(mes>0&&mes<=12)){			
					FuncoesFeriados f=new FuncoesFeriados();
					f.funcoesFeriados(1, jTextField1.getText(), jTextField2.getText(), jFormattedTextField1.getText(), jFormattedTextField2.getText());
					f.carregaTabela(tm1);//Ap�s adicionar algo atualiza a tabela
					f.gerarCod(jTextField1);
				}else{
					JOptionPane.showMessageDialog(null, "Dia e mês inválidos!", "Entrada inválida", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

        jLabel5.setFont(jLabel5.getFont().deriveFont((float)16));
        jLabel5.setText("Mês*");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(110, 130, 40, 20);
        
        MaskFormatter formatter = null;
        try {
          formatter = new MaskFormatter("##");
          formatter.setPlaceholderCharacter('0');
        } catch (ParseException e) {
        }
        
        jFormattedTextField1 = new JFormattedTextField(formatter);
        jFormattedTextField1.setFont(jFormattedTextField1.getFont().deriveFont((float)16));
        jPanel1.add(jFormattedTextField1);
        jFormattedTextField1.setBounds(20, 150, 80, 25);
        jFormattedTextField1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        
        jFormattedTextField2 = new JFormattedTextField(formatter);
        jFormattedTextField2.setFont(jFormattedTextField2.getFont().deriveFont((float)16));
        jPanel1.add(jFormattedTextField2);
        jFormattedTextField2.setBounds(110, 150, 80, 25);
        jFormattedTextField2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jTabbedPane1.addTab("Novo Feriado", jPanel1);

        jPanel2.setLayout(null);
        
        tm1.addColumn("Código");
        tm1.addColumn("Nome");
        tm1.addColumn("Dia");
        tm1.addColumn("Mês");

        jTable1.setModel(tm1);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);
        
		jTable1.getColumnModel().getColumn(1).setPreferredWidth(260);


        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 510, 190);

        botaoExcluir.setFont(botaoExcluir.getFont().deriveFont((float)14));
        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               FuncoesFeriados f = new FuncoesFeriados();
               int i = jTable1.getSelectedRow();//Pega a linha selecionada da tabela
               f.funcoesFeriados(2, (String) tm1.getValueAt(i, 0), (String) tm1.getValueAt(i, 1), (String) tm1.getValueAt(i, 2), (String) tm1.getValueAt(i, 3));//Pega o valor da linha e da coluna para excluir
               f.carregaTabela(tm1);//Ap�s excluir algo atualiza a tabela
               f.gerarCod(jTextField1);
            }
        });
        jPanel2.add(botaoExcluir);
        botaoExcluir.setBounds(300, 210, 100, 25);

        jTabbedPane1.addTab("Cadastros", jPanel2);
        
        botaoSair.setFont(botaoSair.getFont().deriveFont((float)14));
        botaoSair.setForeground(java.awt.Color.red);
        botaoSair.setText("Sair");
        getContentPane().add(botaoSair);
        botaoSair.setBounds(410, 280, 100, 25);
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dispose();
			}
		});

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 40, 515, 270);

        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.PLAIN, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Feriados");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 0, 240, 40);


        pack();
    }// </editor-fold>                        
                                      

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Feriados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton botaoGravar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    DefaultTableModel tm1 = new DefaultTableModel();

    // End of variables declaration                   
}
