//Nome do nosso pacote //                
package funcoes;

//Classes necessárias para uso de Banco de dados //

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Início da classe de conexão//
public class ConexaoMySQL {

	public static String status = "Não conectou...";
	// Método Construtor da Classe//

	public ConexaoMySQL() {

	}

	// Método de Conexão//

	public static java.sql.Connection getConexaoMySQL() {
		Connection connection = null; // atributo do tipo Connection

		try {
			// Carregando o JDBC Driver padrão
		    String biblioteca = InfoMySql.biblioteca;
			Class.forName(biblioteca);

			// Configurando a nossa conexão com um banco de dados//			
			String url = InfoMySql.url;
			String login = InfoMySql.usuario;
			String senha = InfoMySql.senha;
			
			connection = DriverManager.getConnection(url, login, senha);

			// Testa sua conexão//
			if (connection != null) {
				status = ("STATUS--->Conectado com sucesso!");
			} else {
				status = ("STATUS--->Não foi possivel realizar conexão");
			}
			return connection;

		} catch (ClassNotFoundException e) { // Driver não encontrado
			new TrataErros().erroClassNotFound(e);
			return null;

		} catch (SQLException e) {
			// Não conseguindo se conectar ao banco
			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
			return null;

		}

	}

	// Método que retorna o status da sua conexão//

	public static String statusConection() {
		return status;
	}

	// Método que fecha sua conexão//
	public static boolean FecharConexao() {
		try {
			ConexaoMySQL.getConexaoMySQL().close();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	// Método que reinicia sua conexão//

	public static java.sql.Connection ReiniciarConexao() {
		FecharConexao();
		return ConexaoMySQL.getConexaoMySQL();

	}

}