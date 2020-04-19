package funcoes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class FuncoesGeracaoPonto {
	String biblioteca = InfoMySql.biblioteca;
	String url = InfoMySql.url;
	String login = InfoMySql.usuario;
	String senha = InfoMySql.senha;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void carregaComboBox(JComboBox jComboBox, String SQL){
		try{
	    	Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login,	senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			jComboBox.removeAllItems();
			jComboBox.addItem("%");
			while (r.next()) {
				jComboBox.addItem(r.getString(1));		
			}
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
			java.sql.Connection c = DriverManager.getConnection(url, login,
					senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			while (r.next()) {
				tm.addRow(new String[] { r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6), r.getString(7), r.getString(8)});
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
}
