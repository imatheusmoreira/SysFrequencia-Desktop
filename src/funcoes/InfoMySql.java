package funcoes;

import arquivos.Manipulador;

public class InfoMySql{
	public static String biblioteca="com.mysql.jdbc.Driver";
	public static String usuario = new Manipulador().infoUser(); //Usuário do banco de dados
	public static String senha = new Manipulador().infoPass(); //Senha do banco de dados
	public static String url = new Manipulador().infoDatabase();
	
	public static String matricula = "0";
	public static String nvAcesso = "Estagiario";
	
	//Informações do sistema - Mudar ao atualizar!
	public static String versao = "2.9";
	public static String nomeSistema = "SysFrequência";
}
