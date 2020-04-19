package funcoes;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class TrataErros {
	public void erroClassNotFound(ClassNotFoundException exp){
		javax.swing.JOptionPane.showMessageDialog(null, "Biblioteca não localizada: " + exp,
				"Erro ClassNotFoundException", JOptionPane.ERROR_MESSAGE);
	}
	public void erroSQL(SQLException exp){
		javax.swing.JOptionPane.showMessageDialog(null,
				"Erro na conexão!\n\nRastreamento de pilha:\n" + exp,
				"Código de erro: " + exp.getErrorCode(), JOptionPane.ERROR_MESSAGE);
	}
	public void erroSQL(SQLException exp, String comentario){
		javax.swing.JOptionPane.showMessageDialog(null,
				comentario+"\n\nRastreamento de pilha:\n" + exp,
				"Código de erro: " + exp.getErrorCode(), JOptionPane.ERROR_MESSAGE);
	}

}
