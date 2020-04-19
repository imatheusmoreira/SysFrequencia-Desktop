package funcoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FuncoesCargosFuncoes {
	
	String biblioteca = InfoMySql.biblioteca;
	String url = InfoMySql.url;
	String login = InfoMySql.usuario;
	String senha = InfoMySql.senha;
	
	public void insereExclui(int modo, String nome, String descricao, String tabela){
		String SQL = "";
		if (modo == 1) {
			//insere
			SQL = "INSERT INTO `"+tabela+"` (`nome`, `descricao`) VALUES ('"+nome+"', '"+descricao+"')";
		}
		if (modo == 2) {
			SQL = "DELETE FROM "+tabela+" WHERE `nome`='"+nome+"';";
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
	
	public void carregaTabela(JComboBox<?> jcb1, DefaultTableModel tm1){
		String SQL="SELECT nome FROM "+jcb1.getSelectedItem()+" ORDER BY nome";
		
		try {//ESSE METODO LIMPA TODA A TABELA ANTES DE PREENCHER NOVAMENTE.
			int n = 0;
			n = tm1.getRowCount();
			for (int i = 0; i < n;) {
				tm1.removeRow(i);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {
			Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login,
					senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			while (r.next()) {
				tm1.addRow(new String[] { r.getString(1) });
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
}
