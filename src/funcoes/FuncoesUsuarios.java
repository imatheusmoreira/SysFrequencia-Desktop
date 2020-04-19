package funcoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FuncoesUsuarios {
	
	String biblioteca = InfoMySql.biblioteca;
	String url = InfoMySql.url;
	String login = InfoMySql.usuario;
	String senha = InfoMySql.senha;
	
	public void isUser(JTextField txtCodServidor, JComboBox<String> jc2){		
		try {
			Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login,	senha);
			
			PreparedStatement pst = c.prepareStatement("SELECT ehusuario FROM servidores WHERE matricula = ?");
			pst.setString(1, txtCodServidor.getText());
			
			ResultSet r = pst.executeQuery();
			
			while (r.next()) {
				jc2.setSelectedItem(r.getString(1));
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
	public void isAdm(JTextField txt, JComboBox<String> cb){		
		try {
			Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login, senha);
			
			PreparedStatement pst = c.prepareStatement("SELECT niveldeacesso FROM servidores WHERE matricula = ?");
			pst.setString(1, txt.getText());
			
			ResultSet r = pst.executeQuery();
			
			while (r.next()) {
				cb.setSelectedItem(r.getString(1));
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
	
	public String nivelAcesso(String matricula){
		String nivel = "";
				
		try {
			Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login, senha);
			
			PreparedStatement pst = c.prepareStatement("SELECT tipo FROM servidores WHERE matricula = ?");
			pst.setString(1, matricula);
						
			ResultSet r = pst.executeQuery();

			while (r.next()) {
				nivel = r.getString(1);
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
		return nivel;
	}
	
	public void atualiza(String matricula, String entrada){
		
		try {
			Class.forName(biblioteca);
			Connection c = DriverManager.getConnection(url, login, senha);
			
			PreparedStatement pst = c.prepareStatement("UPDATE `servidores` SET `ehusuario`= ? WHERE  `matricula`= ?");
			pst.setString(1, entrada);
			pst.setString(2, matricula);
			
			pst.executeUpdate();
			
			if (pst != null) {
				JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso!",
								"Mensagem do sistema", JOptionPane.INFORMATION_MESSAGE);
				pst.close();
			}
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
	
	public void atualizaSenha(String matricula, String valor){
		try {
			Class.forName(biblioteca);
			Connection c = DriverManager.getConnection(url, login, senha);
			PreparedStatement pst = c.prepareStatement("UPDATE `servidores` SET `senha`= ? WHERE  `matricula`= ?");
			pst.setString(1, valor);
			pst.setString(2, matricula);
			
			pst.executeUpdate();
			if (pst != null) {
				JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso!");
				pst.close();
			}
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
	
	public int senhaCorreta(String password, String matricula){
		int correta= 0;
		String passwordbd = "";
		
		try {
			Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login,	senha);
			PreparedStatement pst = c.prepareStatement("SELECT senha FROM servidores WHERE matricula = ?");
			pst.setString(1, matricula);
			
			ResultSet r = pst.executeQuery();
			
			while (r.next()) {
				if(r.getString(1)==null){
					passwordbd = "";
				}else{					
					passwordbd = r.getString(1);
				}
				if(passwordbd.equals(password)){					
					correta = 1;
				}
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
		return correta;
	}

}
