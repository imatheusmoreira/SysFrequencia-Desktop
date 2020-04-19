package funcoes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class FuncoesDatas {
	String biblioteca = InfoMySql.biblioteca;
	String url = InfoMySql.url;
	String login = InfoMySql.usuario;
	String senha = InfoMySql.senha;	
	
	public boolean ehFeriado(int[] dias, int dia){
		for(int i = 0 ; i < dias.length ; i++){
			if(dias[i] == dia){
				return true;
			}
		}
		return false;		
	}
	
	public int diaDaSemana(int dia, int mes, int ano){
		Calendar cal = Calendar.getInstance();
        cal.set (ano, mes - 1, dia); // note que você precisa subtrair 1 do mês !!!!
        // Note que para os dias da semana, 1 = domingo, 2 = segunda, ... 7 = sábado
        // O correto é usar: Calendar.SATURDAY em vez de bitolar que 7 = sábado.
		return cal.get(Calendar.DAY_OF_WEEK);
	}
	
	public String nomeFeriado(int dia, int mes){
		String nome = "";
		String SQL = "SELECT nome FROM feriados WHERE dia = '"+dia+"' AND mes = '"+mes+"'";
		try {
			Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login,	senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			while (r.next()) {
				nome =  r.getString(1);
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
		return nome;
	}
	
	public int[] carregaFeriados(int mes){
		
		int n = 10; // tamanho do vetor
		int dias[] = new int[n]; // declaração e alocação de espaço para o vetor "dias"
		int i = 0; // índice ou posiçao
		
		String SQL = "SELECT dia FROM feriados WHERE mes = '"+mes+"'";
		try {
			Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login,	senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			while (r.next()) {
				dias[i] = r.getInt(1);
				i++;
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
		return dias;
	}
	
	public String meses(int mes){
		String nome = "";
		if(mes == 1){
			nome = "JANEIRO";
		}
		if(mes == 2){
			nome = "FEVEREIRO";
		}
		if(mes == 3){
			nome = "MAR�O";
		}
		if(mes == 4){
			nome = "ABRIL";
		}
		if(mes == 5){
			nome = "MAIO";
		}
		if(mes == 6){
			nome = "JUNHO";
		}
		if(mes == 7){
			nome = "JULHO";
		}
		if(mes == 8){
			nome = "AGOSTO";
		}
		if(mes == 9){
			nome = "SETEMBRO";
		}
		if(mes == 10){
			nome = "OUTUBRO";
		}
		if(mes == 11){
			nome = "NOVEMBRO";
		}
		if(mes == 12){
			nome = "DEZEMBRO";
		}
		return nome;
	}
	
	public int getMaxDias(int year, int mes) {
		 // First get an instance of calendar object.
        Calendar calendar = Calendar.getInstance();
        int month = 0;
        
		if (mes == 1) {
			month = Calendar.JANUARY;
		}
		if (mes == 2) {
			month = Calendar.FEBRUARY;
		}
		if (mes == 3) {
			month = Calendar.MARCH;
		}
		if (mes == 4) {
			month = Calendar.APRIL;
		}
		if (mes == 5) {
			month = Calendar.MAY;
		}
		if (mes == 6) {
			month = Calendar.JUNE;
		}
		if (mes == 7) {
			month = Calendar.JULY;
		}
		if (mes == 8) {
			month = Calendar.AUGUST;
		}
		if (mes == 9) {
			month = Calendar.SEPTEMBER;
		}
		if (mes == 10) {
			month = Calendar.OCTOBER;
		}
		if (mes == 11) {
			month = Calendar.NOVEMBER;
		}
		if (mes == 12) {
			month = Calendar.DECEMBER;
		}
        
        int date = 1;
        calendar.set(year, month, date);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

       
        return maxDay;
    }  
}
