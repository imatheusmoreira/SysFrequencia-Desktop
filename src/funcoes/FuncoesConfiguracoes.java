package funcoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FuncoesConfiguracoes {
	String biblioteca = InfoMySql.biblioteca;
	String url = InfoMySql.url;
	String login = InfoMySql.usuario;
	String senha = InfoMySql.senha;
	String matricula = funcoes.InfoMySql.matricula;

	public String pegaURLSaida() {
		String retorno = "";
		String SQL = "SELECT urlsaida FROM configuracoes WHERE matricula = '"+matricula+"' LIMIT 1";
		try {
			Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login,
					senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			while (r.next()) {
				retorno = r.getString(1);
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
		return retorno;
	}

	public String pegaURLLogoRelatorios() {
		String retorno = "";
		String SQL = "SELECT urllogopdf FROM configuracoes WHERE matricula = '"+matricula+"' LIMIT 1";
		try {
			Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login,
					senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			while (r.next()) {
				retorno = r.getString(1);
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
		return retorno;
	}
	public String pegaURLLogoPrincipal() {
		String retorno = "";
		String SQL = "SELECT urllogotela FROM configuracoes WHERE matricula = '"+matricula+"' LIMIT 1";
		try {
			Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login,
					senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			while (r.next()) {
				retorno = r.getString(1);
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
		return retorno;
	}
	public String pegaDadosEmail(int forma) {
		String retorno = "";
		String SQL = "";
		if(forma == 1){
			SQL = "SELECT email FROM configuracoes_email WHERE matricula = '"+matricula+"' LIMIT 1";
		}
		if(forma == 2){
			SQL = "SELECT emailsenha FROM configuracoes_email WHERE matricula = '"+matricula+"' LIMIT 1";
		}
		if(forma == 3){
			SQL = "SELECT emailassuntopdf FROM configuracoes_email WHERE matricula = '"+matricula+"' LIMIT 1";
		}
		if(forma == 4){
			SQL = "SELECT emailtextopdf FROM configuracoes_email WHERE matricula = '"+matricula+"' LIMIT 1";
		}
		if(forma == 5){
			SQL = "SELECT emailassuntoalerta FROM configuracoes_email WHERE matricula = '"+matricula+"' LIMIT 1";
		}
		if(forma == 6){
			SQL = "SELECT emailtextoalerta FROM configuracoes_email WHERE matricula = '"+matricula+"' LIMIT 1";
		}
		try {
			Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login,
					senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			while (r.next()) {
				retorno = r.getString(1);
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
		return retorno;
	}
	public void gravaURL(int forma, JTextField jTextField){
		String SQL = "";
		String caminho = jTextField.getText();
		
		if(forma == 1){
			SQL = "INSERT INTO configuracoes (matricula, urlsaida, urllogopdf, urllogotela) VALUES ('"+matricula+"', '"+caminho+"', '', '')  ON DUPLICATE KEY UPDATE urlsaida = '"+caminho+"'";
		}
		if(forma == 2){
			SQL = "INSERT INTO configuracoes (matricula, urlsaida, urllogopdf, urllogotela) VALUES ('"+matricula+"', '', '"+caminho+"', '')  ON DUPLICATE KEY UPDATE urllogopdf = '"+caminho+"'";
		}
		if(forma == 3){
			SQL = "INSERT INTO configuracoes (matricula, urlsaida, urllogopdf, urllogotela) VALUES ('"+matricula+"', '', '', '"+caminho+"')  ON DUPLICATE KEY UPDATE urllogotela = '"+caminho+"'";
		}

		try {
			Class.forName(biblioteca);
			Connection c = DriverManager.getConnection(url, login, senha);
			Statement stat = null;
			stat = c.createStatement();
			stat.executeUpdate(SQL);
			if (stat != null) {
				stat.close();
				JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			}
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
	public void gravaEmail(JTextField jTextField4, JPasswordField jPasswordField, JTextField jTextField5, JTextArea jTa1, JTextField jTextField6, JTextArea jTa2){
		String SQL1 = "DELETE FROM configuracoes_email WHERE matricula = '"+matricula+"'";
		String SQL2 = "INSERT INTO `configuracoes_email` (`matricula`, `email`, `emailsenha`, `emailassuntopdf`, `emailtextopdf`, emailassuntoalerta, emailtextoalerta) VALUES "
				+ "('"+matricula+"', '"+jTextField4.getText()+"', '"+new String(jPasswordField.getPassword())+"', '"+jTextField5.getText()+"', '"+jTa1.getText()+"', '"+jTextField6.getText()+"', '"+jTa2.getText()+"');";
		try {
			Class.forName(biblioteca);
			Connection c = DriverManager.getConnection(url, login, senha);
			Statement stat = null;
			stat = c.createStatement();
			stat.executeUpdate(SQL1);
			stat.executeUpdate(SQL2);
			if (stat != null) {
				stat.close();
				JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			}
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
}
