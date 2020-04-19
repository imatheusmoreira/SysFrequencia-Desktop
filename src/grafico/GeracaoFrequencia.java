package grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import arquivos.ArquivoPDFEstagiario;
import arquivos.ArquivoPDFServidores;

import com.itextpdf.text.DocumentException;

import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import funcoes.FuncoesFeriados;

/**
 *
 * @author Matheus Moreira
 */
public class GeracaoFrequencia extends javax.swing.JDialog implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form GeracaoPonto
     */
    public GeracaoFrequencia() {
        initComponents();
        new funcoes.FuncoesGeracaoPonto().carregaComboBox(cbLotacao, "SELECT nome FROM lotacao");
        new funcoes.FuncoesGeracaoPonto().carregaComboBox(cbSetor, "SELECT nome FROM setor");
        new funcoes.FuncoesGeracaoPonto().carregaComboBox(cbServidor, "SELECT nome FROM servidores WHERE ativo = 'SIM' ORDER BY nome");
        new funcoes.FuncoesGeracaoPonto().carregaTabela(tm1, "SELECT matricula, nome, cargo, funcao, lotacao, setor, ch, tipo FROM servidores WHERE ativo = 'SIM' ORDER BY nome");
        new FuncoesFeriados().controleDatasCristas();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblAno = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        cbAno = new javax.swing.JComboBox();
        cbMes = new javax.swing.JComboBox();
        painelParametros = new javax.swing.JPanel();
        lblLotacao = new javax.swing.JLabel();
        cbLotacao = new javax.swing.JComboBox();
        cbSetor = new javax.swing.JComboBox();
        cbServidor = new javax.swing.JComboBox();
        lblSetor = new javax.swing.JLabel();
        lblServidor = new javax.swing.JLabel();
        lblModeloDaFolha = new javax.swing.JLabel();
        lblAdicionarOcorrencias = new javax.swing.JLabel();
        cbModeloDaFolha = new javax.swing.JComboBox();
        cbAdicionarOcorrencias = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        lblLegenda = new javax.swing.JLabel();
        btnGerar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        
        progresso = new JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 650));
        setSize(new java.awt.Dimension(900, 650));
        setResizable(false);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setModal(true);

        lblTitulo.setFont(lblTitulo.getFont().deriveFont((float)20));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Geração de Folhas de Frequência");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(14, 10, 860, 40);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data"));
        jPanel1.setLayout(null);

        lblAno.setFont(lblAno.getFont().deriveFont((float)14));
        lblAno.setText("Ano");
        jPanel1.add(lblAno);
        lblAno.setBounds(10, 10, 100, 23);
       
        cbAno.setFont(cbAno.getFont().deriveFont((float)14));
        cbAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));
        cbAno.setSelectedItem(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));//Mantem o ano atual sempre selecionado
        jPanel1.add(cbAno);
        cbAno.setBounds(10, 30, 90, 25);
        
        lblMes.setFont(lblMes.getFont().deriveFont((float)14));
        lblMes.setText("Mês");
        jPanel1.add(lblMes);
        lblMes.setBounds(110, 10, 90, 23);
       
        cbMes.setFont(cbMes.getFont().deriveFont((float)14));
        cbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        cbMes.setSelectedIndex(Integer.parseInt(String.valueOf(Calendar.getInstance().get(Calendar.MONTH))));//Mantem o mês atual sempre selecionado
        jPanel1.add(cbMes);
        cbMes.setBounds(110, 30, 70, 25);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 50, 870, 70);

        painelParametros.setBorder(javax.swing.BorderFactory.createTitledBorder("Parâmetros da Folha"));
        painelParametros.setLayout(null);

        lblLotacao.setFont(lblLotacao.getFont().deriveFont((float)14));
        lblLotacao.setText("Lotação");
        painelParametros.add(lblLotacao);
        lblLotacao.setBounds(10, 20, 90, 23);

        cbLotacao.setFont(cbLotacao.getFont().deriveFont((float)14));
        cbLotacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "%" }));
        painelParametros.add(cbLotacao);
        cbLotacao.setBounds(10, 40, 220, 25);
        cbLotacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new funcoes.FuncoesGeracaoPonto().carregaComboBox(cbSetor, "SELECT nome FROM setor WHERE lotacao LIKE '%"+cbLotacao.getSelectedItem()+"%' ORDER BY nome");				
				 new funcoes.FuncoesGeracaoPonto().carregaTabela(tm1, "SELECT matricula, nome, cargo, funcao, lotacao, setor, ch, tipo FROM servidores WHERE lotacao LIKE '%"+cbLotacao.getSelectedItem()+"%' AND ativo = 'SIM' ORDER BY nome");
			}
		});

        lblSetor.setFont(lblSetor.getFont().deriveFont((float)14));
        lblSetor.setText("Setor");
        painelParametros.add(lblSetor);
        lblSetor.setBounds(240, 20, 110, 23);
        
        cbSetor.setFont(cbSetor.getFont().deriveFont((float)14));
        cbSetor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "%" }));
        painelParametros.add(cbSetor);
        cbSetor.setBounds(240, 40, 250, 25);
        cbSetor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new funcoes.FuncoesGeracaoPonto().carregaComboBox(cbServidor, "SELECT nome FROM servidores WHERE setor LIKE '%"+cbSetor.getSelectedItem()+"%' ORDER BY nome");				
				 new funcoes.FuncoesGeracaoPonto().carregaTabela(tm1, "SELECT matricula, nome, cargo, funcao, lotacao, setor, ch, tipo FROM servidores WHERE setor LIKE '%"+cbSetor.getSelectedItem()+"%' AND ativo = 'SIM' ORDER BY nome");
			}
		});        

        lblServidor.setFont(lblServidor.getFont().deriveFont((float)14));
        lblServidor.setText("Servidor");
        painelParametros.add(lblServidor);
        lblServidor.setBounds(500, 20, 100, 23);
        
        cbServidor.setFont(cbServidor.getFont().deriveFont((float)14));
        cbServidor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "%" }));
        painelParametros.add(cbServidor);
        cbServidor.setBounds(500, 40, 350, 25);
        cbServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new funcoes.FuncoesGeracaoPonto().carregaTabela(tm1, "SELECT matricula, nome, cargo, funcao, lotacao, setor, ch, tipo FROM servidores WHERE nome LIKE '%"+cbServidor.getSelectedItem()+"%' AND ativo = 'SIM' ORDER BY nome");				
				
			}
		});
        
        lblModeloDaFolha.setFont(lblModeloDaFolha.getFont().deriveFont((float)14));
        lblModeloDaFolha.setText("Modelo da folha");
        //jPanel2.add(lblModeloDaFolha); //Desativado desde a versão 2.2
        lblModeloDaFolha.setBounds(10, 74, 220, 20);
        lblModeloDaFolha.setEnabled(false);

        cbModeloDaFolha.setFont(cbModeloDaFolha.getFont().deriveFont((float)14));
        cbModeloDaFolha.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Servidores", "Estagiarios" }));
        //jPanel2.add(cbModeloDaFolha); //Desativado desde a versão 2.2
        cbModeloDaFolha.setBounds(10, 95, 220, 25);
        cbModeloDaFolha.setEnabled(false);
        
        lblAdicionarOcorrencias.setFont(lblAdicionarOcorrencias.getFont().deriveFont((float)14));
        lblAdicionarOcorrencias.setText("Adicionar ocorrências?");
        painelParametros.add(lblAdicionarOcorrencias);
        lblAdicionarOcorrencias.setBounds(10, 74, 220, 20);
        
        cbAdicionarOcorrencias.setFont(cbAdicionarOcorrencias.getFont().deriveFont((float)14));
        cbAdicionarOcorrencias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não" }));
        painelParametros.add(cbAdicionarOcorrencias);
        cbAdicionarOcorrencias.setBounds(10, 95, 220, 25);
        
        progresso.setBounds(240, 95, 610, 25);
        progresso.setValue(0);
        progresso.setStringPainted(true);        
        painelParametros.add(progresso);

        getContentPane().add(painelParametros);
        painelParametros.setBounds(10, 130, 870, 140);
        
        tm1.addColumn("Matricula");
        tm1.addColumn("Servidor");
        tm1.addColumn("Cargo");
        tm1.addColumn("Função");
        tm1.addColumn("Lotação");
        tm1.addColumn("Setor");
        tm1.addColumn("CH");
        tm1.addColumn("Tipo");
        
        tabela.setModel(tm1);
        tabela.setFont(new java.awt.Font(null, 0, 12));
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 300, 870, 300);
        
        tabela.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(130);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(120);
        tabela.getColumnModel().getColumn(5).setPreferredWidth(110);
        tabela.getColumnModel().getColumn(6).setPreferredWidth(40);

        lblLegenda.setText(" Na tabela abaixo são mostrados os funcionários ativos baseado nos parâmetros acima.");
        getContentPane().add(lblLegenda);
        lblLegenda.setBounds(10, 270, 510, 30);

        btnGerar.setFont(btnGerar.getFont().deriveFont((float)14));
        btnGerar.setText("Gerar");
        getContentPane().add(btnGerar);
        btnGerar.setBounds(650, 270, 110, 25);        
        btnGerar.addActionListener(this);
        
        btnSair.setFont(btnSair.getFont().deriveFont((float)14));
        btnSair.setForeground(java.awt.Color.RED);
        btnSair.setText("Sair");
        getContentPane().add(btnSair);
        btnSair.setBounds(770, 270, 110, 25);        
        btnSair.addActionListener(this);

        pack();
    }// </editor-fold> 
    
	private static Runnable processaFolhas = new Runnable() {
		@Override
		public void run() {
			// Quantidade de servidores/estágiarios
			int quantidade = tm1.getRowCount();
			// Mês e ano da operação
			int mes = Integer.parseInt(String.valueOf(cbMes.getSelectedItem()));
			int ano = Integer.parseInt(String.valueOf(cbAno.getSelectedItem()));
			// Diretório raiz onde são salvos os arquivos
			String diretorioDeSaida = String.valueOf(new funcoes.FuncoesConfiguracoes().pegaURLSaida());			
			//Caminho da logo dos arquivos
			String caminhoLogoArquivos = String.valueOf(new funcoes.FuncoesConfiguracoes().pegaURLLogoRelatorios());


			for (int i = 0; i < quantidade; i++) {
				
				carregaBarra(i, quantidade);
				
				String matricula = String.valueOf(tm1.getValueAt(i, 0));
				String nome = String.valueOf(tm1.getValueAt(i, 1));
				String cargo = String.valueOf(tm1.getValueAt(i, 2));
				String funcao = String.valueOf(tm1.getValueAt(i, 3));
				String lotacao = String.valueOf(tm1.getValueAt(i, 4));
				String setor = String.valueOf(tm1.getValueAt(i, 5));
				String jornada = String.valueOf(tm1.getValueAt(i, 6));
				String tipo = String.valueOf(tm1.getValueAt(i, 7));

				File diretorio = new File(diretorioDeSaida + "/" + ano + "/" + new DecimalFormat("00").format(mes) + "/" + lotacao + "/" + setor); // é uma pasta!
				if (!diretorio.exists()) {
					diretorio.mkdirs(); // mkdir() cria somente um diretório,
										// mkdirs() cria diretórios e subdiretórios.
				} else {
					// System.out.println("Diretório já existente");
				}

				if (tipo.toUpperCase().equals("SERVIDOR")) {
					ArquivoPDFServidores arqSe = new ArquivoPDFServidores();
					arqSe.abreArquivo(diretorio, nome);
					try {
						arqSe.cabecalho(caminhoLogoArquivos, new funcoes.FuncoesDatas().meses(mes) + "/" + ano + "", matricula, nome, cargo, funcao,
								lotacao, setor, jornada);
					} catch (DocumentException ex) {
						ex.printStackTrace();
					}
					try {
						arqSe.corpoTabela(new funcoes.FuncoesDatas().getMaxDias(ano, mes), new funcoes.FuncoesDatas().carregaFeriados(mes), mes, ano);
					} catch (DocumentException ex) {
						ex.printStackTrace();
					}

					if (cbAdicionarOcorrencias.getSelectedIndex() == 0) {
						try {
							arqSe.ocorrencias(caminhoLogoArquivos, 38);
						} catch (DocumentException ex) {
							ex.printStackTrace();
						}
					}

					arqSe.fechaArquivo();

					System.out.println("Frequencia de " + nome + " gerada - Tipo Servidor");

				} else

				if (tipo.toUpperCase().equals("ESTAGIARIO")) {
					ArquivoPDFEstagiario arqEs = new ArquivoPDFEstagiario();
					arqEs.abreArquivo(diretorio, nome);
					try {
						arqEs.cabecalho(caminhoLogoArquivos, new funcoes.FuncoesDatas().meses(mes) + "/" + ano + "", matricula, nome, cargo, funcao, lotacao,
								setor, jornada);
					} catch (DocumentException ex) {
						ex.printStackTrace();
					}
					try {
						arqEs.corpoTabela(new funcoes.FuncoesDatas().getMaxDias(ano, mes), new funcoes.FuncoesDatas().carregaFeriados(mes), mes, ano);
					} catch (DocumentException ex) {
						ex.printStackTrace();
					}

					if (cbAdicionarOcorrencias.getSelectedIndex() == 0) {
						try {
							arqEs.ocorrencias(caminhoLogoArquivos, 38);
						} catch (DocumentException ex) {
							ex.printStackTrace();
						}
					}

					arqEs.fechaArquivo();
					System.out.println("Frequencia de " + nome + " gerada - Tipo Estagiário");

				}

			}

			JOptionPane.showMessageDialog(null,
					"<html><b>Geração de PDFs finalizada!</b></html>\nAgora você já pode usar o assistente de envio por email."
							+ "\nObs.: Caso algum arquivo seja deletado, não será possível enviar por email");

		}
	};
    
	public static void carregaBarra(int atual, int total) {
		progresso.setMaximum(total - 1);
		progresso.setValue(atual);

		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}

	};
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    	try {
			UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
		} catch (javax.swing.UnsupportedLookAndFeelException | ParseException ex) {
			java.util.logging.Logger.getLogger(GeracaoFrequencia.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeracaoFrequencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnGerar;
    private javax.swing.JButton btnSair;
    @SuppressWarnings("rawtypes")
	private static javax.swing.JComboBox cbAno;
    @SuppressWarnings("rawtypes")
	private static javax.swing.JComboBox cbMes;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox cbLotacao;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox cbSetor;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox cbServidor;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox cbModeloDaFolha;
    @SuppressWarnings("rawtypes")
	private static javax.swing.JComboBox cbAdicionarOcorrencias;
    private static javax.swing.JProgressBar progresso;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblLotacao;
    private javax.swing.JLabel lblSetor;
    private javax.swing.JLabel lblServidor;
    private javax.swing.JLabel lblLegenda;
    private javax.swing.JLabel lblModeloDaFolha;
    private javax.swing.JLabel lblAdicionarOcorrencias;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painelParametros;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    static DefaultTableModel tm1 = new DefaultTableModel();
    // End of variables declaration                   
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnGerar)){
			int resp = JOptionPane.showConfirmDialog(null, "Está pronto para gerar as frequências?", "Pergunta do sistema", JOptionPane.YES_NO_OPTION);
			if(resp == JOptionPane.YES_OPTION){
				new Thread(processaFolhas).start();
			}
			
		}
		if(e.getSource().equals(btnSair)){
			int resp = JOptionPane.showConfirmDialog(null, "Realmente deseja sair?", "Pergunta do sistema", JOptionPane.YES_NO_OPTION);
			if(resp == JOptionPane.YES_OPTION){
				dispose();
			}
		}		
	}
}
