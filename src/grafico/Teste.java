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
//		File diretorio = new File(""+ano+"/"+mes+"/"+lotacao); //  é uma pasta!
//		if (!diretorio.exists()) {
//		   diretorio.mkdirs(); //mkdir() cria somente um diretório, mkdirs() cria diretórios e subdiretórios.
//		} else {
//		   System.out.println("Diretório já existente");
//		}
//		
//		ArquivoPDFEstagiario ar = new ArquivoPDFEstagiario();
//		ar.abreArquivo(diretorio, nome);
//		ar.cabeçalho("D:/IFCE/Outros/mar.jpg", ""+new funcoes.FuncoesDatas().meses(mes)+"/"+ano+"", nome, "Cargo", "Função", lotacao, "Setor", "80");
//		ar.corpoTabela(new funcoes.FuncoesDatas().getMaxDias(ano, mes), new funcoes.FuncoesDatas().carregaFeriados(mes), mes, ano);
//		ar.fechaArquivo();
		System.out.println(new funcoes.FuncoesDatas().getMaxDias(2017, 4));
	}
}
