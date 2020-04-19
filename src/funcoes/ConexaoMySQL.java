//Nome do nosso pacote //                
package funcoes;

//Classes necess�rias para uso de Banco de dados //

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//In�cio da classe de conex�o//
public class ConexaoMySQL {

	public static String status = "N�o conectou...";
	// M�todo Construtor da Classe//

	public ConexaoMySQL() {

	}

	// M�todo de Conex�o//

	public static java.sql.Connection getConexaoMySQL() {
		Connection connection = null; // atributo do tipo Connection

		try {
			// Carregando o JDBC Driver padr�o
		    String biblioteca = InfoMySql.biblioteca;
			Class.forName(biblioteca);

			// Configurando a nossa conex�o com um banco de dados//			
			String url = InfoMySql.url;
			String login = InfoMySql.usuario;
			String senha = InfoMySql.senha;
			
			connection = DriverManager.getConnection(url, login, senha);

			// Testa sua conex�o//
			if (connection != null) {
				status = ("STATUS--->Conectado com sucesso!");
			} else {
				status = ("STATUS--->N�o foi possivel realizar conex�o");
			}
			return connection;

		} catch (ClassNotFoundException e) { // Driver n�o encontrado
			new TrataErros().erroClassNotFound(e);
			return null;

		} catch (SQLException e) {
			// N�o conseguindo se conectar ao banco
			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
			return null;

		}

	}

	// M�todo que retorna o status da sua conex�o//

	public static String statusConection() {
		return status;
	}

	// M�todo que fecha sua conex�o//
	public static boolean FecharConexao() {
		try {
			ConexaoMySQL.getConexaoMySQL().close();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	// M�todo que reinicia sua conex�o//

	public static java.sql.Connection ReiniciarConexao() {
		FecharConexao();
		return ConexaoMySQL.getConexaoMySQL();

	}

}