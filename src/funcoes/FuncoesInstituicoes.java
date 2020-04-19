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

public class FuncoesInstituicoes {
	String biblioteca = InfoMySql.biblioteca;
	String url = InfoMySql.url;
	String login = InfoMySql.usuario;
	String senha = InfoMySql.senha;
	
	public void insereAtualiza(int forma, String[] dados){
		String SQL = "";
		
		String CNPJ = dados[0];
		String nomeempresarial = dados[1];
		String nomefantasia = dados[2];
		String dataAbertura = new funcoes.ConverteFormatoDataString().dePTparaENDateTime(dados[3]);
		String codAtivPrin = dados[4];
		String codAtivSecun = dados[5];
		String naturezaJuridica = dados[6];
		String rua = dados[7];
		String numero = dados[8];
		String complemento = dados[9];
		String bairro = dados[10];
		String municipio = dados[11];
		String uf = dados[12];
		String cep = dados[13];
		String email = dados[14];
		String telefone = dados[15];
		String efr = dados[16];
		String contrato = dados[17];				
		
		if(forma == 1){
			SQL = "INSERT INTO `instituicoes` (`cnpj`, `nomeempresarial`, `nomefantasia`, `dataabertura`, `ativecoprincipal`, `ativecosecundaria`, `naturezajuridica`, `rua`, `numero`, `complemento`, `bairro`, `municipio`, `uf`, `cep`, `email`, `telefone`, `efr`, `contrato`) VALUES "
					+ "('"+CNPJ+"', '"+nomeempresarial+"', '"+nomefantasia+"', '"+dataAbertura+"', '"+codAtivPrin+"', '"+codAtivSecun+"', '"+naturezaJuridica+"', '"+rua+"', '"+numero+"', '"+complemento+"', '"+bairro+"', '"+municipio+"', '"+uf+"', '"+cep+"', '"+email+"', '"+telefone+"', '"+efr+"', '"+contrato+"');";
		}
		if(forma == 2){
			SQL = "UPDATE `instituicoes` SET `nomeempresarial`='"+nomeempresarial+"', `nomefantasia`='"+nomefantasia+"', `dataabertura`='"+dataAbertura+"', `ativecoprincipal`='"+codAtivPrin+"', `ativecosecundaria`='"+codAtivSecun+"', `naturezajuridica`='"+naturezaJuridica+"', `rua`='"+rua+"', `numero`='"+numero+"', `complemento`='"+complemento+"', `bairro`='"+bairro+"', `municipio`='"+municipio+"', `uf`='"+uf+"', `cep`='"+cep+"', `email`='"+email+"', `telefone`='"+telefone+"', `efr`='"+efr+"', `contrato`='"+contrato+"' WHERE  `cnpj`='"+CNPJ+"';";
		}
		try {
			Class.forName(biblioteca);
			Connection c = DriverManager.getConnection(url, login, senha);
			Statement stat = null;
			stat = c.createStatement();
			stat.executeUpdate(SQL);
			if (stat != null) {
				stat.close();
				c.close();
				JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso!");
			}
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
	
	public void deleta(int CNPJ){
		String SQL = "DELETE FROM instituicoes WHERE cnpj = '"+CNPJ+"'";
		try {
			Class.forName(biblioteca);
			Connection c = DriverManager.getConnection(url, login, senha);
			Statement stat = null;
			stat = c.createStatement();
			stat.executeUpdate(SQL);
			if (stat != null) {
				stat.close();
				c.close();
				JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso!");
			}
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
	
	public String[] retornaDadosInstituicao(String cnpj){
		String dados[] = new String[20];
		String SQL = "SELECT * FROM instituicoes WHERE cnpj = '"+cnpj+"'";
		try {
			Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login, senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			
			while (r.next()) {
				dados[0] = r.getString(1);//CNPJ
				dados[1] = r.getString(2);//Nome empresarial
				dados[2] = r.getString(3);//Nome fantasia
				dados[3] = new funcoes.ConverteFormatoDataString().deENparaPTDateTime(r.getString(4)+" 00:00:00");//data de abertura
				dados[4] = r.getString(5);//ativ. econômica principal
				dados[5] = r.getString(6);//ativ. econômica secundária
				dados[6] = r.getString(7);//natureza jurídica
				dados[7] = r.getString(8);//rua
				dados[8] = r.getString(9);//numero
				dados[9] = r.getString(10);//complemento
				dados[10] = r.getString(11);//bairro
				dados[11] = r.getString(12);//Município
				dados[12] = r.getString(13);//uf
				dados[13] = r.getString(14);//cep
				dados[14] = r.getString(15);//email
				dados[15] = r.getString(16);//telefone
				dados[16] = r.getString(17);//efr
				dados[17] = r.getString(18);//contrato

				System.out.println("Leu dados da instituição "+dados[2]);
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}

		return dados;
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
			java.sql.Connection c = DriverManager.getConnection(url, login, senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			while (r.next()) {
				tm.addRow(new String[] { r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6)});
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}

	public void pesquisar(JTextField txtPesquisa, JComboBox<String> cbPesquisa, DefaultTableModel tm) {
		String SQL = "";
		String entrada = txtPesquisa.getText();
				
		if(cbPesquisa.getSelectedItem().equals("CNPJ")){
			SQL = "SELECT cnpj, nomefantasia, cep, email, telefone, contrato FROM empresa WHERE cnpj = '"+entrada+"' ORDER BY nomefantasia";
		}
		if(cbPesquisa.getSelectedItem().equals("NOME FANTASIA")){
			SQL = "SELECT cnpj, nomefantasia, cep, email, telefone, contrato FROM empresa WHERE nomeempresarial LIKE '"+entrada+"%' ORDER BY nomefantasia";
		}
		if(cbPesquisa.getSelectedItem().equals("MUNICIPIO")){
			SQL = "SELECT cnpj, nomefantasia, cep, email, telefone, contrato FROM empresa WHERE municipio = '"+entrada+"' ORDER BY nomefantasia";
		}
		
		new FuncoesInstituicoes().carregaTabela(tm, SQL);
	}
}
