package funcoes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FuncoesInternas {
	
	String biblioteca = InfoMySql.biblioteca;
	String url = InfoMySql.url;
	String login = InfoMySql.usuario;
	String senha = InfoMySql.senha;
	
	public void verificaAvisos(){
		String SQL = "SELECT codigo, descricao FROM avisos WHERE (SELECT CONCAT(CONCAT(CURDATE(), ' '), CURTIME())) >= inicioaviso AND (SELECT CONCAT(CONCAT(CURDATE(), ' '), CURTIME())) <= fimaviso";
		try {
			Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login, senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			if (r.next()) {
				javax.swing.JOptionPane.showMessageDialog(null, r.getString(2), "", javax.swing.JOptionPane.PLAIN_MESSAGE);
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
}
