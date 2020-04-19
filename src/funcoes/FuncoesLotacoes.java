package funcoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FuncoesLotacoes {
	
	String biblioteca = InfoMySql.biblioteca;
	String url = InfoMySql.url;
	String login = InfoMySql.usuario;
	String senha = InfoMySql.senha;
	
	public void insereAtualizaExclui(int modo, String codigo, String nome, String chefia, String email, String obs){
		String SQL = "";
		if (modo == 1) {
			//insere
			SQL = "INSERT INTO `lotacao` (`codigo`, `nome`, `responsável`, `email`, `observacoes`) VALUES ('"+codigo+"', '"+nome+"', '"+chefia+"', '"+email+"', '"+obs+"');";
		}
		if (modo == 2) {
			SQL = "UPDATE `lotacao` SET `nome`='"+nome+"', `responsável`='"+chefia+"', `email`='"+email+"', `observacoes`='"+obs+"' WHERE  `codigo`='"+codigo+"' LIMIT 1;";
			//atualiza
		}
		if (modo == 3) {
			SQL = "DELETE FROM `lotacao` WHERE  `codigo`='"+codigo+"' AND `nome`='"+nome+"' LIMIT 1;";
			//exclui
		}

		try {

			Class.forName(biblioteca);
			Connection c = DriverManager.getConnection(url, login, senha);
			Statement stat = null;
			stat = c.createStatement();
			stat.executeUpdate(SQL);
			if (stat != null) {
				JOptionPane.showMessageDialog(null,
						"Pedido realizado com sucesso!",
						"Mensagem do sistema", JOptionPane.INFORMATION_MESSAGE);
				stat.close();
			}
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
	
	public void carregaTabela(DefaultTableModel tm){
		String SQL="SELECT * FROM lotacao ORDER BY nome";
		
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
			java.sql.Connection c = DriverManager.getConnection(url, login,
					senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			while (r.next()) {
				tm.addRow(new String[] { r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5)});
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
}
