package funcoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import funcoes.InfoMySql;
import funcoes.TrataErros;

public class FuncoesFeriados {
	String biblioteca = InfoMySql.biblioteca;
	String url = InfoMySql.url;
	String login = InfoMySql.usuario;
	String senha = InfoMySql.senha;
	
	public void funcoesFeriados(int modo, String codigo, String nome, String dia, String mes){
		String SQL = "";
		String comentario = "";
		if (modo == 1) {
			SQL = "INSERT INTO `feriados` (`codigo`, `nome`, `dia`, `mes`) VALUES ("+codigo+", '"+nome+"', "+dia+", "+mes+")";
		}
		if ((modo == 2)&&(Integer.parseInt(codigo)>4)) {
			SQL = "DELETE FROM feriados WHERE `codigo`=" + codigo+ " LIMIT 1";
		}
		if(Integer.parseInt(codigo)<=4){
			comentario = "Impossivel deletar datas crist�s pois elas s�o essenciais ao sistema.";
		}
		if(nome.contains("'")){
			comentario = "Não use aspas!";
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
						"Mensagem do SysPonto", JOptionPane.INFORMATION_MESSAGE);
				stat.close();
			}
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1, comentario);
		}		
	}
	
	public void carregaTabela(DefaultTableModel tm1){
		String SQL="SELECT * FROM `feriados` LIMIT 1000;";
		try {//ESSE METODO LIMPA TODA A TABELA ANTES DE PREENCHER NOVAMENTE.
			int n = 0;
			n = tm1.getRowCount();
			for (int i = 0; i < n;) {
				tm1.removeRow(i);
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
				tm1.addRow(new String[] { r.getString(1), r.getString(2), r.getString(3), r.getString(4) });
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
	public void gerarCod(JTextField tf1) {
		int codigo = 0;
		int codant = 0;
		try {
			Class.forName(biblioteca);

			Connection c = DriverManager.getConnection(url, login, senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery("select MAX(codigo) from feriados");

			while (r.next()) {
				
				codant = Integer.parseInt((r.getString(1)));
				codigo = codant + 1;
				
			}
			tf1.setText("" + codigo);
			c.close();
		}catch (NumberFormatException e) {
			tf1.setText("1");
		
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
	
	public void controleDatasCristas(){
    	System.out.println("\nInicialização de datas cristãos");
		for (int i=1; i<=4; i++){
			HolidayUtils hu = new HolidayUtils();
			String SQL = hu.retornaData(i);
			inserirDatasCristas(SQL);
		}
	}
	
	public void inserirDatasCristas(String SQL){
		String[] dados=SQL.split("-");
		
		String SQLa = "UPDATE `feriados` SET `codigo`="+dados[0]+", `nome`='"+dados[1]+"', `dia`="+dados[2]+", `mes`="+dados[3]+" WHERE  `codigo`="+dados[0]+"";		
		
		try {

			Class.forName(biblioteca);
			Connection c = DriverManager.getConnection(url, login, senha);
			Statement stat = null;
			stat = c.createStatement();
			stat.executeUpdate(SQLa);
			if (stat != null) {
				stat.close();
			}
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
}
