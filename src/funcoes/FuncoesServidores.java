package funcoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FuncoesServidores {
	
	String biblioteca = InfoMySql.biblioteca;
	String url = InfoMySql.url;
	String login = InfoMySql.usuario;
	String senha = InfoMySql.senha;
	
	public void insereExcluiAtualiza(int modo, String matricula, String nome, String telefone, String celular, String email, String cargo, String funcao, String setor, String lotacao, int ch, String tipo, String ativo, String obs){
		String SQL = "";
		if (modo == 1) {
			//insere
			SQL = "INSERT INTO `servidores` (`matricula`, `nome`, `cargo`, `funcao`, `lotacao`, `setor`, `telefone`, `celular`, `email`, `ch`, `tipo`, `ativo`, `observacoes`) VALUES "
					+ "('"+matricula+"', '"+nome+"', '"+cargo+"', '"+funcao+"', '"+lotacao+"', '"+setor+"', '"+telefone+"', '"+celular+"', '"+email+"', '"+ch+"', '"+tipo+"', '"+ativo+"', '"+obs+"');";
		}
		if (modo == 2) {
			SQL = "UPDATE `servidores` SET `nome`='"+nome+"', `cargo`='"+cargo+"', `funcao`='"+funcao+"', `lotacao`='"+lotacao+"', `setor`='"+setor+"', `telefone`='"+telefone+"', `celular`='"+celular+"', `email`='"+email+"', `ch`='"+ch+"', `tipo`='"+tipo+"', `ativo`='"+ativo+"', `observacoes`='"+obs+"' WHERE  `matricula`='"+matricula+"';";
			//atualiza
		}
		if (modo == 3) {
			SQL = "DELETE FROM `servidores` WHERE `matricula`='"+matricula+"' LIMIT 1;";
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
	@SuppressWarnings("rawtypes")
	public void pesquisar(JTextField jTextField, JComboBox jComboBox, DefaultTableModel tm){
		
		String SQL = "";
		String entrada = jTextField.getText();
				
		if(jComboBox.getSelectedItem().equals("TUDO")){
			SQL = "SELECT matricula, nome, cargo, funcao, lotacao, setor, telefone, celular, email, ch, tipo, ativo, observacoes FROM servidores ORDER BY nome";
		}
		if(jComboBox.getSelectedItem().equals("MATRICULA")){
			SQL = "SELECT matricula, nome, cargo, funcao, lotacao, setor, telefone, celular, email, ch, tipo, ativo, observacoes FROM servidores WHERE matricula = '"+entrada+"' ORDER BY matricula";
		}
		if(jComboBox.getSelectedItem().equals("NOME")){
			SQL = "SELECT matricula, nome, cargo, funcao, lotacao, setor, telefone, celular, email, ch, tipo, ativo, observacoes FROM servidores WHERE nome LIKE '%"+entrada+"%' ORDER BY nome";
		}
		if(jComboBox.getSelectedItem().equals("CARGO")){
			SQL = "SELECT matricula, nome, cargo, funcao, lotacao, setor, telefone, celular, email, ch, tipo, ativo, observacoes FROM servidores WHERE cargo = '"+entrada+"' ORDER BY nome";
		}
		if(jComboBox.getSelectedItem().equals("LOTACAO")){
			SQL = "SELECT matricula, nome, cargo, funcao, lotacao, setor, telefone, celular, email, ch, tipo, ativo, observacoes FROM servidores WHERE lotacao = '"+entrada+"' ORDER BY nome";
		}
		
		new FuncoesServidores().carregaTabela(tm, SQL);
	}
	
	public void carregaComboBox(JComboBox<String> cb, String SQL){
    	try{
	    	Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login,	senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			cb.addItem("");
			while (r.next()) {
				cb.addItem(r.getString(1));		
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
			//e.printStackTrace();
		}
		try {
			Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login,	senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			while (r.next()) {
				tm.addRow(new String[] { r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6), r.getString(7), r.getString(8), r.getString(9), r.getString(10), r.getString(11), r.getString(12), r.getString(13)});
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
}
