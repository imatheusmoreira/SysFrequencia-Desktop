package funcoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Consultas {
	
	String biblioteca = InfoMySql.biblioteca;
	String url = InfoMySql.url;
	String login = InfoMySql.usuario;
	String senha = InfoMySql.senha;
	
	public int verCodMax(String tabela, String coluna){
		String SQL = "SELECT MAX("+coluna+") FROM "+tabela+"";
		int retorno = 0;
		int codant = 0;
		try {
			Class.forName(biblioteca);

			Connection c = DriverManager.getConnection(url, login, senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);

			while (r.next()){
				codant = Integer.parseInt((r.getString(1)));
			}
			retorno = codant;
			c.close();
		} catch (NumberFormatException e){
			retorno = 0;
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1){
			new TrataErros().erroSQL(e1);
		}
		return retorno;
	}
	
	public int verSeValorExiste(String tabela, String coluna, String valor){
		String SQL = "SELECT "+coluna+" FROM "+tabela+" WHERE "+coluna+" = '"+valor+"'";
		
		int retorno = 0;
		try {
			Class.forName(biblioteca);

			Connection c = DriverManager.getConnection(url, login, senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);

			while (r.next()){
				retorno = 1;
			}
			
			c.close();
			
		} catch (NumberFormatException e){
			retorno = 0;
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1){
			new TrataErros().erroSQL(e1);
		}
		return retorno;
	}
	
	public void retornaNomeServidor(JTextField txt1, JTextField txt2, JTextField txt3){
		if(txt1.getText().length() == 0){
			txt2.setText("");
		}else{
			String SQL = "SELECT nome FROM servidores WHERE matricula = '"+txt1.getText()+"' LIMIT 1";
			try {
				Class.forName(biblioteca);
				java.sql.Connection c = DriverManager.getConnection(url, login,	senha);
				Statement s = c.createStatement();
				ResultSet r = s.executeQuery(SQL);
				if (r.next()) {
					txt2.setText(r.getString(1));
					txt3.requestFocusInWindow();
				}else{
					//JOptionPane.showMessageDialog(null, "Funcionário não cadastrado!", "Aviso do sistema", JOptionPane.WARNING_MESSAGE);
				}
				c.close();
			} catch (ClassNotFoundException e1) {
				new TrataErros().erroClassNotFound(e1);
			} catch (SQLException e1) {
				new TrataErros().erroSQL(e1);
			}
		}
	}
	
	public String retornaNomeServidor(String matricula){
		String nome = "";
		try {
			java.sql.Connection c = funcoes.ConexaoMySQL.getConexaoMySQL();
			
			PreparedStatement pst = c.prepareStatement("SELECT nome FROM servidores WHERE matricula = ? LIMIT 1");
			pst.setString(1, matricula);
			
			ResultSet r = pst.executeQuery();
			
			if (r.next()) {
				nome = r.getString(1);
			}else{
				javax.swing.JOptionPane.showMessageDialog(null, "Servidor não cadastrado!", "Aviso do sistema", javax.swing.JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
		return nome;
	}
	
	public String retornaFuncaoServidor(String matricula){
		String nome = "";
		try {
			Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login,	senha);
			
			PreparedStatement pst = c.prepareStatement("SELECT funcao FROM servidores WHERE matricula = ? LIMIT 1");
			pst.setString(1, matricula);

			ResultSet r = pst.executeQuery();
			
			if (r.next()) {
				nome = r.getString(1);
			}else{
				javax.swing.JOptionPane.showMessageDialog(null, "Servidor não cadastrado!", "Aviso do sistema", javax.swing.JOptionPane.WARNING_MESSAGE);
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
		return nome;
	}
	
	public void retornaNomeVeiculo(JTextField txt1, JTextField txt2){
		if(txt1.getText().equals("_______")){
			txt2.setText("");
		}else{
			String SQL = "SELECT descricao FROM veiculo WHERE placa = '"+txt1.getText()+"' LIMIT 1";
			try {
				Class.forName(biblioteca);
				java.sql.Connection c = DriverManager.getConnection(url, login,	senha);
				Statement s = c.createStatement();
				ResultSet r = s.executeQuery(SQL);
				if (r.next()) {
					txt2.setText(r.getString(1));
				}else{
					//JOptionPane.showMessageDialog(null, "Veículo não cadastrado!", "Aviso do sistema", JOptionPane.WARNING_MESSAGE);
				}
				c.close();
			} catch (ClassNotFoundException e1) {
				new TrataErros().erroClassNotFound(e1);
			} catch (SQLException e1) {
				new TrataErros().erroSQL(e1);
			}
		}
	}
	
	public String retornaNomeVeiculo(String placa){
		String retorno = "";
		if(placa.equals("")){
			retorno = "";
		}else{
			String SQL = "SELECT descricao FROM veiculo WHERE placa = '"+placa+"' LIMIT 1";
			try {
				Class.forName(biblioteca);
				java.sql.Connection c = DriverManager.getConnection(url, login,	senha);
				Statement s = c.createStatement();
				ResultSet r = s.executeQuery(SQL);
				if (r.next()) {
					retorno = r.getString(1);
				}else{
					//JOptionPane.showMessageDialog(null, "Veículo não cadastrado!", "Aviso do sistema", JOptionPane.WARNING_MESSAGE);
				}
				c.close();
			} catch (ClassNotFoundException e1) {
				new TrataErros().erroClassNotFound(e1);
			} catch (SQLException e1) {
				new TrataErros().erroSQL(e1);
			}
		}
		return retorno;
	}
	
	public String retornaHorasExtras(int codMotorista, String dataIni, String dataFim, String filtro){
		String SQL = "";
		String retorno = "";

		if(filtro.equals("UTEIS")){
			SQL = "SELECT SEC_TO_TIME(SUM(TIME_TO_SEC(horaextra))) AS timeSum FROM frequenciamotoristas WHERE (nomedia = 'SEGUNDA' OR nomedia = 'TERCA' OR nomedia = 'QUARTA' OR nomedia = 'QUINTA' OR nomedia = 'SEXTA') AND dia >='"+dataIni+"' AND dia<='"+dataFim+"' AND feriado = 'NAO' AND codMotorista = '"+codMotorista+"'";
		}
		if(filtro.equals("SABDOMFER")){
			SQL = "SELECT SEC_TO_TIME(SUM(TIME_TO_SEC(horaextra))) AS timeSum FROM frequenciamotoristas WHERE (nomedia = 'SABADO' OR nomedia = 'DOMINGO' OR feriado = 'SIM') AND dia >='"+dataIni+"' AND dia<='"+dataFim+"' AND codMotorista = '"+codMotorista+"'";
		}
		if(filtro.equals("TOTAL")){
			SQL = "SELECT SEC_TO_TIME(SUM(TIME_TO_SEC(horaextra))) AS timeSum FROM frequenciamotoristas WHERE dia >='"+dataIni+"' AND dia<='"+dataFim+"' AND codMotorista = '"+codMotorista+"'";
		}
				
		try {
			Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login, senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			if (r.next()) {
				if(String.valueOf(r.getString(1)).equals("null")){
					retorno = "00:00:00";
				}else{
					retorno = (r.getString(1));
				}
			}
				
		c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
		return retorno;
	}
	
	public void verificaSeHaParametrosFaltantes(){
		String SQL1 = "SELECT codigo FROM parametrizacao_combustiveis WHERE datafinal >= CURDATE();";
		String SQL2 = "SELECT codigo FROM parametrizacao_diarias WHERE datafinal >= CURDATE();";
		String SQL3 = "SELECT codigo FROM parametrizacao_he WHERE datafinal >= CURDATE();";
		String SQL4 = "SELECT codigo_he FROM parametrizacao_vl;";
		
		String saida = "<b>ATENÇÃO</b>\nOs seguintes parametros não estão cadastrados, ou estão vencidos:";
		int contador = 0;
		
		try {
			java.sql.Connection c = funcoes.ConexaoMySQL.getConexaoMySQL();
			
			Statement s = c.createStatement();
			
			ResultSet r = s.executeQuery(SQL1);
			if (!r.next()) {
				saida += "\n*Combustíveis;";
				contador++;
			}
			r = s.executeQuery(SQL2);
			if (!r.next()) {
				saida += "\n*Diárias;";
				contador++;
			}
			r = s.executeQuery(SQL3);
			if (!r.next()) {
				saida += "\n*Horas extras;";
				contador++;
			}
			r = s.executeQuery(SQL4);
			if (!r.next()) {
				saida += "\n*Vale lanche;";
				contador++;
			}
			
			saida += "\na não observância deste fator causará erros no sistema!"
					+ "\nContate o administrador para cadastra-los imediatamente!";
			
			if(contador > 0){
				javax.swing.JOptionPane.showMessageDialog(null, "<html> <h1>"+saida, "IMPORTANTE", javax.swing.JOptionPane.WARNING_MESSAGE);
			}
			
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
	
	public void carregaComboBox(JComboBox<String> jComboBox, String SQL){
		jComboBox.removeAllItems();
    	try{
	    	Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login,	senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			while (r.next()) {
				jComboBox.addItem(r.getString(1));		
			}
		c.close();
    	} catch (ClassNotFoundException e1) {
    		new TrataErros().erroClassNotFound(e1);
    	} catch (SQLException e1) {
    		new TrataErros().erroSQL(e1);
    	}
    }
	public void carregaComboBoxDuasInformacoes(JComboBox<String> jComboBox, String SQL){
		jComboBox.removeAllItems();
    	try{
	    	Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login,	senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			while (r.next()) {
				
				jComboBox.addItem(r.getString(1)+"-"+(String.valueOf(r.getString(2)).equals("null")?"EXCLUIDO OU NAO CADASTRADO":r.getString(2).toUpperCase()));		
			}
		c.close();
    	} catch (ClassNotFoundException e1) {
    		new TrataErros().erroClassNotFound(e1);
    	} catch (SQLException e1) {
    		new TrataErros().erroSQL(e1);
    	}
    }
	public void carregaTabela(DefaultTableModel tm, String SQL){
		try {//ESSE METODO LIMPA TODA A TABELA ANTES DE PREENCHER NOVAMENTE.
			int n = 0;
			n = tm.getRowCount();
			for (int i = 0; i < n;) {
				tm.removeRow(i);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
		try {
			Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login,	senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			while (r.next()) {
				tm.addRow(new String[] { r.getString(1), r.getString(2)});
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
}
