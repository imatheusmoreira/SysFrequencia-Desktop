package grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Matheus Moreira
 */
public class CaixaDePesquisa extends javax.swing.JDialog implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form CaixaDeAjuda
     */

    @SuppressWarnings("static-access")
	public CaixaDePesquisa(String SQL, JTextComponent txt) {
    	this.txtA = txt;
        initComponents();
        new funcoes.Consultas().carregaTabela(tm, SQL);
    }

    @SuppressWarnings("serial")
	private void initComponents() {

        lblPesquisa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Caixa de Pesquisa");
        setModal(true);

        lblPesquisa.setFont(lblPesquisa.getFont().deriveFont((float)18));
        lblPesquisa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPesquisa.setText("Clique duplo para usar");
        getContentPane().add(lblPesquisa, java.awt.BorderLayout.PAGE_START);
        
        tm = new DefaultTableModel(){   
		    public boolean isCellEditable(int rowIndex, int mColIndex){   
		         return false;   
		    }   
		};
        
        tm.addColumn("");
        tm.addColumn("");
        
		tabela.addMouseListener(new MouseAdapter() {
	    	   public void mouseClicked(MouseEvent e) {
	    	      if (e.getClickCount() == 2) {
	    	         JTable target = (JTable)e.getSource();
	    	         int row = target.getSelectedRow();
	    	        // int column = target.getSelectedColumn();
	    	         valor = (String)tm.getValueAt(row, 0);
	    	         System.out.println(valor);
	    	         txtA.setText(valor);
	    	         dispose();
	    	       }
	    	   }
	    });
        
        tabela.setModel(tm);
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(350);
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btnSair.setFont(btnSair.getFont().deriveFont((float)12));
        btnSair.setForeground(java.awt.Color.red);
        btnSair.setText("Sair");
        btnSair.addActionListener(this);
        getContentPane().add(btnSair, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaixaDePesquisa(SQL, txtA).setVisible(true);
            }
        });
    }
    private static JTextComponent txtA;

    static String SQL = "";
    // Variables declaration - do not modify                     
    private javax.swing.JButton btnSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JTable tabela;
    DefaultTableModel tm;
    String valor = "";
    // End of variables declaration                   
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnSair)){
			dispose();
		}
		
	}
}
