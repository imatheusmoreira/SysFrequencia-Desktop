package grafico;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.DocumentException;

public class Teste {
	public static void main (String[] a) throws DocumentException, MalformedURLException, IOException{

//		int mes = 3;
//		int ano = 2016;
//		String lotacao = "DIREN";
//		String nome = "Matheus Moreira da Silva";
//		
//		File diretorio = new File(""+ano+"/"+mes+"/"+lotacao); //  � uma pasta!
//		if (!diretorio.exists()) {
//		   diretorio.mkdirs(); //mkdir() cria somente um diret�rio, mkdirs() cria diret�rios e subdiret�rios.
//		} else {
//		   System.out.println("Diret�rio j� existente");
//		}
//		
//		ArquivoPDFEstagiario ar = new ArquivoPDFEstagiario();
//		ar.abreArquivo(diretorio, nome);
//		ar.cabe�alho("D:/IFCE/Outros/mar.jpg", ""+new funcoes.FuncoesDatas().meses(mes)+"/"+ano+"", nome, "Cargo", "Fun��o", lotacao, "Setor", "80");
//		ar.corpoTabela(new funcoes.FuncoesDatas().getMaxDias(ano, mes), new funcoes.FuncoesDatas().carregaFeriados(mes), mes, ano);
//		ar.fechaArquivo();
		System.out.println(new funcoes.FuncoesDatas().getMaxDias(2017, 4));
	}
}
