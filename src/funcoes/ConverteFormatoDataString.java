package funcoes;

/**
 * Converte datas do padrão Brasileiro para o Inglês, e do Inglês para o Brasileiro
 * @author Matheus Moreira {@link https://www.facebook.com/imatheusmoreira}
 * @version 1.0
 */
public class ConverteFormatoDataString {
	
	public String dePTparaENDateTime(String entrada){
		String novaData = "";
		
		if(!String.valueOf(entrada).equals("null")){
		
			String divide[] = entrada.split(" ");
			String data[] = divide[0].split("-");
			
			String dia = data[0];
			String mes = data[1];
			String ano = data[2];
			novaData = ano+"-"+mes+"-"+dia+" "+divide[1];
		}
		return novaData;
	}

	public String deENparaPTDateTime(String entrada){
		String novaData = "";
		
		if(!String.valueOf(entrada).equals("null")){
		
			String divide[] = entrada.split(" ");
			String data[] = divide[0].split("-");
			
			String dia = data[2];
			String mes = data[1];
			String ano = data[0];
			novaData = dia+"-"+mes+"-"+ano+" "+divide[1];
		}
		return novaData;
	}
	
	public String dePTparaENDate(String entrada){
		String novaData = "";
		
		if(!String.valueOf(entrada).equals("null")){
		
			String data[] = entrada.split("-");
			
			String dia = data[0];
			String mes = data[1];
			String ano = data[2];
			novaData = ano+"-"+mes+"-"+dia;
		}
		
		return novaData;
	}

	public String deENparaPTDate(String entrada){
		String novaData = "";

		if(String.valueOf(entrada).equals("null")){
			novaData = "__-__-____";
		}else{
			String data[] = entrada.split("-");
			
			String dia = data[2];
			String mes = data[1];
			String ano = data[0];
			novaData = dia+"-"+mes+"-"+ano;
		}
		return novaData;
	}
	
	public String deHoraParaDecimalArredondado(String entrada){
		System.out.println(entrada);
		String horaCompleta[] = entrada.split(":");
		
		int hora = Integer.parseInt(String.valueOf(horaCompleta[0]));
		int minuto = Integer.parseInt(String.valueOf(horaCompleta[1]));
//		int segundo = Integer.parseInt(String.valueOf(horaCompleta[2]));
		
		if(minuto == 0){
			minuto = 0;
		}
		if(minuto > 0 && minuto <= 30){
			minuto = 5;
		}
		if(minuto > 30 && minuto <= 60){
			hora = hora + 1;
			minuto = 0;
		}
		
		return hora+","+minuto;
		
	}
}
