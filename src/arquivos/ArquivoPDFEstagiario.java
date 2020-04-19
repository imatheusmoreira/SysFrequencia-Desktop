package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ArquivoPDFEstagiario {
	
	File fileDir;
	Document document = new Document();
	Font[] fonts = { new Font(),
			new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD),
			new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD),
			new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD),
			new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.RED)};
	
	public void abreArquivo(File diretorio, String nome){
		fileDir = diretorio;		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(diretorio +"/"+ nome + ".pdf"));

		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um erro na hora de salvar o arquivo!\nRastreamento de pilha:\n" + e1, e1.getMessage(),	JOptionPane.ERROR_MESSAGE);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		Rectangle retangulo = new Rectangle(PageSize.A4);
		document.setPageSize(retangulo);
		document.open();
		// Adicionando meta dados ao nosso arquivo
		document.addTitle(nome);
		//document.addSubject("Agora temos um assunto no arquivo!");
		//document.addKeywords("Java, PDF, iText");
		document.addAuthor("imatheusmoreira@gmail.com");
		document.addCreator("SysFrequência IFCE");
		
	}

	public void cabecalho(String urlLogo, String mesAno, String identificação, String estagiario, String cargo, String funcao, String lotacao,
			String setor, String jornada) throws DocumentException {
		try {

			Image logo;
			logo = Image.getInstance(urlLogo);
			logo.setAbsolutePosition(37, 750); // posiciona img
			logo.scaleToFit(50, 67);
			document.add(logo);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Paragraph pBlank = new Paragraph("\n");
		document.add(pBlank);
		// Linha 00
		Paragraph pMesAno = new Paragraph("CONTROLE DE FREQUÊNCIA - " + mesAno, fonts[1]);
		pMesAno.setAlignment(Element.ALIGN_CENTER);
		document.add(pMesAno);
		document.add(pBlank);
		// Linha 01
		Paragraph pEstagiario = new Paragraph("ESTAGIÁRIO: " + estagiario, fonts[2]);
		PdfPCell cServidor = new PdfPCell(new Paragraph(pEstagiario));
		cServidor.setVerticalAlignment(Element.ALIGN_CENTER);

		Paragraph pMatricula = new Paragraph("CPF: " + identificação, fonts[2]);
		PdfPCell cMatricula = new PdfPCell(new Paragraph(pMatricula));
		cMatricula.setVerticalAlignment(Element.ALIGN_CENTER);

		PdfPTable cabecalhoL1 = new PdfPTable(new float[] { 0.70f, 0.30f });
		cabecalhoL1.getDefaultCell().setBorder(PdfPCell.NO_BORDER); // Aqui eu tiro a borda.
		cabecalhoL1.setWidthPercentage(100.0f);
		cabecalhoL1.addCell(pEstagiario);
		cabecalhoL1.addCell(pMatricula);
		cabecalhoL1.setSpacingBefore(2);
		document.add(cabecalhoL1);
		
		// Linha 02
		Paragraph pCargo = new Paragraph("CARGO: " + cargo, fonts[2]);
		PdfPCell cCargo = new PdfPCell(new Paragraph(pCargo));
		cCargo.setVerticalAlignment(Element.ALIGN_CENTER);

		Paragraph pFuncao = new Paragraph("FUNÇÃO: " + funcao, fonts[2]);
		PdfPCell cFuncao = new PdfPCell(new Paragraph(pFuncao));
		cFuncao.setVerticalAlignment(Element.ALIGN_CENTER);

		PdfPTable cabecalhoL2 = new PdfPTable(new float[] { 0.50f, 0.50f });
		cabecalhoL2.getDefaultCell().setBorder(PdfPCell.NO_BORDER); // Aqui eu tiro a borda
		cabecalhoL2.setWidthPercentage(100.0f);
		cabecalhoL2.addCell(pCargo);
		cabecalhoL2.addCell(pFuncao);
		cabecalhoL2.setSpacingBefore(2);
		document.add(cabecalhoL2);
		
		// Linha 03
		Paragraph pLotacao = new Paragraph("LOTAÇÃO: " + lotacao, fonts[2]);
		PdfPCell cLotacao = new PdfPCell(new Paragraph(pLotacao));
		cLotacao.setVerticalAlignment(Element.ALIGN_CENTER);

		Paragraph pSetor = new Paragraph("SETOR: " + setor, fonts[2]);
		PdfPCell cSetor = new PdfPCell(new Paragraph(pSetor));
		cSetor.setVerticalAlignment(Element.ALIGN_CENTER);

		PdfPTable cabecalhoL3 = new PdfPTable(new float[] { 0.50f, 0.50f });
		cabecalhoL3.getDefaultCell().setBorder(PdfPCell.NO_BORDER); // Aqui eu tiro a borda
		cabecalhoL3.setWidthPercentage(100.0f);
		cabecalhoL3.addCell(pLotacao);
		cabecalhoL3.addCell(pSetor);
		cabecalhoL3.setSpacingBefore(2);
		document.add(cabecalhoL3);
		
		// Linha 04
		Paragraph pJornada = new Paragraph("JORNADA: " + jornada + "h", fonts[2]);
		pJornada.setAlignment(Element.ALIGN_LEFT);
		document.add(pJornada);

		document.add(pBlank);
	}
	
	public void corpoTabela(int qtdDias, int[] dias, int mes, int ano) throws DocumentException{
		
		int linhas = qtdDias;
		
		PdfPTable tabela = new PdfPTable(new float [] { 0.05f, 0.83f, 0.12f});
		tabela.setWidthPercentage(100.0f);
		
		Paragraph pEntrada = new Paragraph("ENTRADA", fonts[2]);	    
		PdfPCell cEntrada = new PdfPCell(new Paragraph(pEntrada));
		cEntrada.setHorizontalAlignment(Element.ALIGN_CENTER);
		cEntrada.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cEntrada.setBorderWidthTop(0f);
		cEntrada.setBorderWidthBottom(0f);
		
		Paragraph pSaida = new Paragraph("SAÍDA", fonts[2]);	    
		PdfPCell cSaida = new PdfPCell(new Paragraph(pSaida));
		cSaida.setHorizontalAlignment(Element.ALIGN_CENTER);	
		cSaida.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cSaida.setBorderWidthTop(0f);
		cSaida.setBorderWidthBottom(0f);
		
		Paragraph pRubrica = new Paragraph("RÚBRICA", fonts[2]);	    
		PdfPCell cRubrica = new PdfPCell(new Paragraph(pRubrica));
		cRubrica.setHorizontalAlignment(Element.ALIGN_CENTER);	
		cRubrica.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cRubrica.setBorderWidthTop(0f);
		cRubrica.setBorderWidthBottom(0f);
		
		Paragraph pDias = new Paragraph("DIA", fonts[2]);	    
		PdfPCell cDias = new PdfPCell(new Paragraph(pDias));
		cDias.setHorizontalAlignment(Element.ALIGN_CENTER);
		cDias.setVerticalAlignment(Element.ALIGN_MIDDLE);
		   
		Paragraph pBancoDeHoras = new Paragraph("BANCO DE HORAS", fonts[4]);	    
		PdfPCell cBancoDeHoras = new PdfPCell(new Paragraph(pBancoDeHoras));
		cBancoDeHoras.setHorizontalAlignment(Element.ALIGN_CENTER);
		cBancoDeHoras.setVerticalAlignment(Element.ALIGN_MIDDLE);
		
		Paragraph pSabado = new Paragraph("SÁBADO", fonts[2]);
		PdfPCell cSabado = new PdfPCell(new Paragraph(pSabado));
		cSabado.setHorizontalAlignment(Element.ALIGN_CENTER);
		cSabado.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cSabado.setBackgroundColor(BaseColor.LIGHT_GRAY);
		
		Paragraph pDomingo = new Paragraph("DOMINGO", fonts[2]);
		PdfPCell cDomingo = new PdfPCell(new Paragraph(pDomingo));
		cDomingo.setHorizontalAlignment(Element.ALIGN_CENTER);
		cDomingo.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cDomingo.setBackgroundColor(BaseColor.LIGHT_GRAY);
		
				
		PdfPTable subTabela2 = new PdfPTable(4);
	    subTabela2.addCell(cEntrada);
	    subTabela2.addCell(cRubrica);
	    subTabela2.addCell(cSaida);
	    subTabela2.addCell(cRubrica);

	    PdfPCell cVaziaBranca = new PdfPCell();
	    cVaziaBranca.setHorizontalAlignment(Element.ALIGN_CENTER);	
	    cVaziaBranca.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    cVaziaBranca.setBorderWidthTop(0f);
	    cVaziaBranca.setBorderWidthBottom(0f);
	    
	    PdfPCell cVaziaCinza = new PdfPCell();
	    cVaziaCinza.setHorizontalAlignment(Element.ALIGN_CENTER);	
	    cVaziaCinza.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    cVaziaCinza.setBorderWidthTop(0f);
	    cVaziaCinza.setBorderWidthBottom(0f);
	    cVaziaCinza.setBackgroundColor(BaseColor.LIGHT_GRAY);

	    PdfPTable subTabela4 = new PdfPTable(4);
	    subTabela4.addCell(cVaziaBranca);
	    subTabela4.addCell(cVaziaBranca);
	    subTabela4.addCell(cVaziaBranca);
	    subTabela4.addCell(cVaziaBranca);	    
	     
	    for(int i=0; i <= linhas; i++){
	    	if(i == 0){
	    		tabela.addCell(cDias);
				tabela.addCell(new PdfPCell(subTabela2));
				tabela.addCell(cBancoDeHoras);
	    	}if(i > 0){
	    		
	    		//Dia (Coluna 1)
	    		Paragraph pDia = new Paragraph(new DecimalFormat("00").format(i), fonts[2]);
		    	PdfPCell cDia = new PdfPCell(pDia);
		    	cDia.setHorizontalAlignment(Element.ALIGN_CENTER);
				cDia.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    		
	    		if((new funcoes.FuncoesDatas().diaDaSemana(i, mes, ano) == 1) && (new funcoes.FuncoesDatas().ehFeriado(dias, i) == false)){//Domingo
	    			tabela.addCell(cDia);
	    			tabela.addCell(cDomingo);
	    			tabela.addCell("");
	    		}else
	    		if((new funcoes.FuncoesDatas().diaDaSemana(i, mes, ano) == 7) && (new funcoes.FuncoesDatas().ehFeriado(dias, i) == false)){//Sabado
	    			tabela.addCell(cDia);
	    			tabela.addCell(cSabado);
	    			tabela.addCell("");
	    		}else
	    		if(((new funcoes.FuncoesDatas().diaDaSemana(i, mes, ano) != 7) || (new funcoes.FuncoesDatas().diaDaSemana(i, mes, ano) != 1)) && (new funcoes.FuncoesDatas().ehFeriado(dias, i) == true)){//Feriados
	    			tabela.addCell(cDia);
	    			
	    			Paragraph pFeriado = new Paragraph(new funcoes.FuncoesDatas().nomeFeriado(i, mes).toUpperCase(), fonts[2]);
	    			PdfPCell cFeriado = new PdfPCell(new Paragraph(pFeriado));
	    			cFeriado.setHorizontalAlignment(Element.ALIGN_CENTER);
	    			cFeriado.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    			cFeriado.setBackgroundColor(BaseColor.LIGHT_GRAY);	    			
	    			tabela.addCell(cFeriado);
	    			
	    			tabela.addCell("");
	    			
	    		}else{//Dias normais
	    			tabela.addCell(cDia);
					tabela.addCell(subTabela4);
					tabela.addCell("    ");
	    		}				
	    	}
		}
	     
	    document.add(tabela);
	    
	    //document.add(pBlank);
	    
	    PdfPTable tabela2 = new PdfPTable(new float [] { 0.30f, 0.70f});
		tabela2.setWidthPercentage(100.0f);
		tabela2.addCell("Assinatura do estagiário");
		tabela2.addCell(" ");		
		document.add(tabela2);
				
		PdfPTable tabela3 = new PdfPTable(new float [] { 0.30f, 0.30f, 0.15f, 0.25f});
		tabela3.setWidthPercentage(100.0f);
		tabela3.addCell("Faltas Justificadas\nA descontar");
		tabela3.addCell(" ");
		tabela3.addCell("Data");
		tabela3.addCell("____/____/________");
		document.add(tabela3);
		
		PdfPTable tabela4 = new PdfPTable(new float [] { 0.30f, 0.70f});
		tabela4.setWidthPercentage(100.0f);
		tabela4.addCell("	Visto da Chefia imediata");
		tabela4.addCell(" ");		
		document.add(tabela4);
		
	}
	
	//Tabela de ocorrências
	public void ocorrencias(String urlLogo, int qtdLinhas) throws DocumentException{
		document.add(Chunk.NEXTPAGE);
		
		try {
			
			Image logo;
			logo = Image.getInstance(urlLogo);
			logo.setAbsolutePosition(37, 750); // posiciona img
			logo.scaleToFit(50, 67);
	        document.add(logo);
	        
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Paragraph pOcorrencias = new Paragraph("OCORRÊNCIAS", fonts[1]);
		pOcorrencias.setAlignment(Element.ALIGN_CENTER);
		document.add(pOcorrencias);
		
        Paragraph pBlank = new Paragraph("\n");
        document.add(pBlank);
        document.add(pBlank);
        
        Paragraph pDias = new Paragraph("DIA", fonts[3]);	    
		PdfPCell cDias = new PdfPCell(new Paragraph(pDias));
		cDias.setHorizontalAlignment(Element.ALIGN_CENTER);
		cDias.setVerticalAlignment(Element.ALIGN_MIDDLE);
		
		Paragraph pDescricao = new Paragraph("DESCRIÇÃO", fonts[3]);	    
		PdfPCell cDescricao = new PdfPCell(new Paragraph(pDescricao));
		cDescricao.setHorizontalAlignment(Element.ALIGN_CENTER);
		cDescricao.setVerticalAlignment(Element.ALIGN_MIDDLE);
        
        PdfPTable cabecalhoOcorrencias = new PdfPTable(new float [] { 0.07f, 0.93f});
		cabecalhoOcorrencias.setWidthPercentage(100.0f);
		cabecalhoOcorrencias.addCell(cDias);
		cabecalhoOcorrencias.addCell(cDescricao);		
		document.add(cabecalhoOcorrencias);
        
     	PdfPTable tabelaOcorrencias = new PdfPTable(new float [] { 0.07f, 0.93f});
     	for(int i=1; i <= qtdLinhas; i++){
     		tabelaOcorrencias.addCell("    ");
     		tabelaOcorrencias.addCell("\n");
     	}
     	tabelaOcorrencias.setWidthPercentage(100.0f);
     	document.add(tabelaOcorrencias);
     	
     	//Espaço
     	document.add(pBlank);
     	
     	//Visto da Chefa
     	Paragraph pVistoDaChefia = new Paragraph("VISTO DA CHEFIA IMEDIATA:", fonts[3]);	    
		PdfPCell cVistoDaChefia = new PdfPCell(new Paragraph(pVistoDaChefia));
		cVistoDaChefia.setHorizontalAlignment(Element.ALIGN_CENTER);
		cVistoDaChefia.setVerticalAlignment(Element.ALIGN_CENTER);
		cVistoDaChefia.setBorderWidthTop(0f);
		cVistoDaChefia.setBorderWidthBottom(0f);
		cVistoDaChefia.setBorderWidthLeft(0f);
		cVistoDaChefia.setBorderWidthRight(0f);
     	
     	PdfPTable vistoDaChefia = new PdfPTable(1);
		vistoDaChefia.setWidthPercentage(100.0f);
		vistoDaChefia.addCell(cVistoDaChefia);
		vistoDaChefia.getDefaultCell().setBorder(PdfPCell.NO_BORDER); // Aqui eu tiro a borda
		document.add(vistoDaChefia);
     		
	}
	
	public void fechaArquivo(){
		document.close();
	}
}
