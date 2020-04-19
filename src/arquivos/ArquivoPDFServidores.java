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

public class ArquivoPDFServidores {
	
	File fileDir;
	Document document = new Document();
	Font[] fonts = { new Font(),
			new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD),
			new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD),
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
	public void cabecalho(String urlLogo, String mesAno, String matricula, String servidor, String cargo, String funcao, String lotacao, String setor, String jornada) throws DocumentException{
		
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
//Linha 00       
        Paragraph pMesAno = new Paragraph("CONTROLE DE FREQUÊNCIA - "+mesAno, fonts[1]);	
		pMesAno.setAlignment(Element.ALIGN_CENTER);
		document.add(pMesAno);
		document.add(pBlank);	
//Linha 01		
		Paragraph pServidor = new Paragraph("SERVIDOR: "+servidor, fonts[2]);
		PdfPCell cServidor = new PdfPCell(new Paragraph(pServidor));
		cServidor.setVerticalAlignment(Element.ALIGN_CENTER);
		
		Paragraph pMatricula = new Paragraph("MATRÍCULA: "+matricula, fonts[2]);
		PdfPCell cMatricula = new PdfPCell(new Paragraph(pMatricula));
		cMatricula.setVerticalAlignment(Element.ALIGN_CENTER);
		
		PdfPTable cabecalhoL1 = new PdfPTable(new float [] { 0.70f, 0.30f});
		cabecalhoL1.getDefaultCell().setBorder(PdfPCell.NO_BORDER); // Aqui eu tiro a borda
		cabecalhoL1.setWidthPercentage(100.0f);
		cabecalhoL1.addCell(pServidor);
		cabecalhoL1.addCell(pMatricula);
		cabecalhoL1.setSpacingBefore(2); 
		document.add(cabecalhoL1);	
//Linha 02		
		Paragraph pCargo = new Paragraph("CARGO: "+cargo, fonts[2]);
		PdfPCell cCargo = new PdfPCell(new Paragraph(pCargo));
		cCargo.setVerticalAlignment(Element.ALIGN_CENTER);
		
		Paragraph pFuncao = new Paragraph("FUNÇÃO: "+funcao, fonts[2]);
		PdfPCell cFuncao = new PdfPCell(new Paragraph(pFuncao));
		cFuncao.setVerticalAlignment(Element.ALIGN_CENTER);
		
		PdfPTable cabecalhoL2 = new PdfPTable(new float [] { 0.50f, 0.50f});
		cabecalhoL2.getDefaultCell().setBorder(PdfPCell.NO_BORDER); // Aqui eu tiro a borda
		cabecalhoL2.setWidthPercentage(100.0f);
		cabecalhoL2.addCell(pCargo);
		cabecalhoL2.addCell(pFuncao);
		cabecalhoL2.setSpacingBefore(2); 
		document.add(cabecalhoL2);	
//Linha 03		
		Paragraph pLotacao = new Paragraph("LOTAÇÃO: "+lotacao, fonts[2]);
		PdfPCell cLotacao = new PdfPCell(new Paragraph(pLotacao));
		cLotacao.setVerticalAlignment(Element.ALIGN_CENTER);
		
		Paragraph pSetor = new Paragraph("SETOR: "+setor, fonts[2]);
		PdfPCell cSetor = new PdfPCell(new Paragraph(pSetor));
		cSetor.setVerticalAlignment(Element.ALIGN_CENTER);
		
		PdfPTable cabecalhoL3 = new PdfPTable(new float [] { 0.50f, 0.50f});
		cabecalhoL3.getDefaultCell().setBorder(PdfPCell.NO_BORDER); // Aqui eu tiro a borda
		cabecalhoL3.setWidthPercentage(100.0f);
		cabecalhoL3.addCell(pLotacao);
		cabecalhoL3.addCell(pSetor);
	    cabecalhoL3.setSpacingBefore(2); 
		document.add(cabecalhoL3);	
//Linha 04
		Paragraph pJornada = new Paragraph("JORNADA: "+jornada+"h", fonts[2]);
		pJornada.setAlignment(Element.ALIGN_LEFT);
		document.add(pJornada);
		
		document.add(pBlank);
		
	}
	public void corpoTabela(int qtdDias, int[] dias, int mes, int ano) throws DocumentException{
		
		Paragraph pBlank = new Paragraph("\n");
		
		int linhas = qtdDias;
		
		PdfPTable tabela = new PdfPTable(new float [] { 0.04f, 0.43f, 0.43f, 0.10f});
		tabela.setWidthPercentage(100.0f);
		
		Paragraph pFirstTurno = new Paragraph("1º TURNO", fonts[2]);	    
		PdfPCell cFirstTurno = new PdfPCell(new Paragraph(pFirstTurno));
		cFirstTurno.setHorizontalAlignment(Element.ALIGN_CENTER);
		cFirstTurno.setVerticalAlignment(Element.ALIGN_CENTER);
		cFirstTurno.setBorderWidthTop(0f);
		cFirstTurno.setBorderWidthBottom(0f);
		cFirstTurno.setBorderWidthLeft(0f);
		cFirstTurno.setBorderWidthRight(0f);
		   
		Paragraph pSecondTurno = new Paragraph("2º TURNO", fonts[2]);	    
		PdfPCell cSecondTurno = new PdfPCell(new Paragraph(pSecondTurno));
		cSecondTurno.setHorizontalAlignment(Element.ALIGN_CENTER);
		cSecondTurno.setVerticalAlignment(Element.ALIGN_CENTER);
		cSecondTurno.setBorderWidthTop(0f);
		cSecondTurno.setBorderWidthBottom(0f);
		cSecondTurno.setBorderWidthLeft(0f);
		cSecondTurno.setBorderWidthRight(0f);
		
		Paragraph pEntrada = new Paragraph("ENTRADA", fonts[3]);	    
		PdfPCell cEntrada = new PdfPCell(new Paragraph(pEntrada));
		cEntrada.setHorizontalAlignment(Element.ALIGN_CENTER);
		cEntrada.setVerticalAlignment(Element.ALIGN_CENTER);
		cEntrada.setBorderWidthTop(0f);
		cEntrada.setBorderWidthBottom(0f);
		
		Paragraph pSaida = new Paragraph("SAÍDA", fonts[3]);	    
		PdfPCell cSaida = new PdfPCell(new Paragraph(pSaida));
		cSaida.setHorizontalAlignment(Element.ALIGN_CENTER);	
		cSaida.setVerticalAlignment(Element.ALIGN_CENTER);
		cSaida.setBorderWidthTop(0f);
		cSaida.setBorderWidthBottom(0f);
		
		Paragraph pRubrica = new Paragraph("RÚBRICA", fonts[3]);	    
		PdfPCell cRubrica = new PdfPCell(new Paragraph(pRubrica));
		cRubrica.setHorizontalAlignment(Element.ALIGN_CENTER);	
		cRubrica.setVerticalAlignment(Element.ALIGN_CENTER);
		cRubrica.setBorderWidthTop(0f);
		cRubrica.setBorderWidthBottom(0f);
		
		Paragraph pDias = new Paragraph("DIA", fonts[3]);	    
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
		cSabado.setVerticalAlignment(Element.ALIGN_CENTER);
		cSabado.setBackgroundColor(BaseColor.LIGHT_GRAY);
		
		Paragraph pDomingo = new Paragraph("DOMINGO", fonts[2]);
		PdfPCell cDomingo = new PdfPCell(new Paragraph(pDomingo));
		cDomingo.setHorizontalAlignment(Element.ALIGN_CENTER);
		cDomingo.setVerticalAlignment(Element.ALIGN_CENTER);
		cDomingo.setBackgroundColor(BaseColor.LIGHT_GRAY);
		
		PdfPTable subTabelaFirstT = new PdfPTable(1);
		subTabelaFirstT.addCell(cFirstTurno);
	    
	    PdfPTable subTabelaSecondT = new PdfPTable(1);
	    subTabelaSecondT.addCell(cSecondTurno);
	    		
		PdfPTable subTabelaAssinaturas = new PdfPTable(4);
	    subTabelaAssinaturas.addCell(cEntrada);
	    subTabelaAssinaturas.addCell(cRubrica);
	    subTabelaAssinaturas.addCell(cSaida);
	    subTabelaAssinaturas.addCell(cRubrica);
	    
	    PdfPTable subTabelaT1 = new PdfPTable(1);
	    subTabelaT1.addCell(subTabelaFirstT);
	    subTabelaT1.addCell(subTabelaAssinaturas);
	    
	    PdfPTable subTabelaT2 = new PdfPTable(1);
	    subTabelaT2.addCell(subTabelaSecondT);
	    subTabelaT2.addCell(subTabelaAssinaturas);
	    
	    Paragraph pVazio = new Paragraph("", fonts[3]);
	    
	    PdfPCell cVaziaBranca = new PdfPCell(new Paragraph(pVazio));
	    cVaziaBranca.setHorizontalAlignment(Element.ALIGN_CENTER);	
	    cVaziaBranca.setVerticalAlignment(Element.ALIGN_CENTER);
	    cVaziaBranca.setBorderWidthTop(0f);
	    cVaziaBranca.setBorderWidthBottom(0f);
	    
	    PdfPCell cVaziaCinza = new PdfPCell();
	    cVaziaCinza.setHorizontalAlignment(Element.ALIGN_CENTER);	
	    cVaziaCinza.setVerticalAlignment(Element.ALIGN_CENTER);
	    cVaziaCinza.setBorderWidthTop(0f);
	    cVaziaCinza.setBorderWidthBottom(0f);
	    cVaziaCinza.setBackgroundColor(BaseColor.LIGHT_GRAY);

	    PdfPTable subTabela3 = new PdfPTable(4);
	    subTabela3.addCell(cVaziaBranca);
	    subTabela3.addCell(cVaziaBranca);
	    subTabela3.addCell(cVaziaBranca);
	    subTabela3.addCell(cVaziaBranca);
	    
	    //Criação da tabela	     
	    for(int i=0; i <= linhas; i++){
	    	
	    	if(i == 0){
	    		//Título da Tabela
	    		tabela.addCell(cDias);
				tabela.addCell(new PdfPCell(subTabelaT1));
				tabela.addCell(new PdfPCell(subTabelaT2));
				tabela.addCell(cBancoDeHoras);
				
	    	}if(i > 0){	    		
	    		//Dia (Coluna 1)
	    		Paragraph pDia = new Paragraph(new DecimalFormat("00").format(i), fonts[2]);
		    	PdfPCell cDia = new PdfPCell(pDia);
		    	cDia.setHorizontalAlignment(Element.ALIGN_CENTER);
				cDia.setVerticalAlignment(Element.ALIGN_MIDDLE);
		    		    		
				//Domingos
	    		if((new funcoes.FuncoesDatas().diaDaSemana(i, mes, ano) == 1) && (new funcoes.FuncoesDatas().ehFeriado(dias, i) == false)){
	    			tabela.addCell(cDia);
	    			tabela.addCell(cDomingo);
	    			tabela.addCell(cDomingo);
	    			tabela.addCell("");
	    		}else//Sabado
	    		if((new funcoes.FuncoesDatas().diaDaSemana(i, mes, ano) == 7) && (new funcoes.FuncoesDatas().ehFeriado(dias, i) == false)){
	    			tabela.addCell(cDia);
	    			tabela.addCell(cSabado);
	    			tabela.addCell(cSabado);
	    			tabela.addCell("");
	    		}else//Feriados
	    		if(((new funcoes.FuncoesDatas().diaDaSemana(i, mes, ano) != 7) || (new funcoes.FuncoesDatas().diaDaSemana(i, mes, ano) != 1)) && (new funcoes.FuncoesDatas().ehFeriado(dias, i) == true)){
	    			
	    			Paragraph pFeriado = new Paragraph(new funcoes.FuncoesDatas().nomeFeriado(i, mes).toUpperCase(), fonts[2]);
	    			PdfPCell cFeriado = new PdfPCell(new Paragraph(pFeriado));
	    			cFeriado.setHorizontalAlignment(Element.ALIGN_CENTER);
	    			cFeriado.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    			cFeriado.setBackgroundColor(BaseColor.LIGHT_GRAY);
	    			
	    			tabela.addCell(cDia);
	    			tabela.addCell(cFeriado);
	    			tabela.addCell(cFeriado);
	    			tabela.addCell("");
	    			
	    		}else{//Dias normais
	    			tabela.addCell(cDia);
	    			tabela.addCell(subTabela3);	    			
					tabela.addCell(subTabela3);
					tabela.addCell("    ");
	    		}				
	    	}
		}
	   
	    
	    document.add(tabela);
	    
	    Paragraph pTotal = new Paragraph("TOTAL", fonts[3]);	    
		PdfPCell cTotal = new PdfPCell(new Paragraph(pTotal));
		cTotal.setVerticalAlignment(Element.ALIGN_CENTER);
		cTotal.setHorizontalAlignment(Element.ALIGN_CENTER);
	    
	    PdfPTable tTotal = new PdfPTable(new float [] { 0.90f, 0.10f});
		tTotal.setWidthPercentage(100.0f);
		tTotal.addCell(cTotal);
		tTotal.addCell("");
		
		document.add(tTotal);
	    
	    Paragraph pHorasComp = new Paragraph("HORAS A COMPENSAR:", fonts[4]);	    
		PdfPCell cHorasComp = new PdfPCell(new Paragraph(pHorasComp));
		cHorasComp.setVerticalAlignment(Element.ALIGN_CENTER);
		
		Paragraph pVistoDaChefia = new Paragraph("	VISTO DA CHEFIA IMEDIATA:", fonts[3]);	    
		PdfPCell cVistoDaChefia = new PdfPCell(new Paragraph(pVistoDaChefia));
		cVistoDaChefia.setVerticalAlignment(Element.ALIGN_CENTER);
		cVistoDaChefia.setBorderWidthTop(0f);
		cVistoDaChefia.setBorderWidthBottom(0f);
		cVistoDaChefia.setBorderWidthLeft(0f);
		cVistoDaChefia.setBorderWidthRight(0f);
		
		Paragraph pHorasDesc = new Paragraph("HORAS A DESCONTAR:", fonts[4]);	    
		PdfPCell cHorasDesc = new PdfPCell(new Paragraph(pHorasDesc));
		cHorasDesc.setVerticalAlignment(Element.ALIGN_CENTER);
		
		Paragraph pVistoDaDiretoria = new Paragraph("", fonts[3]);	    
		PdfPCell cVistoDaDiretoria = new PdfPCell(new Paragraph(pVistoDaDiretoria));
		cVistoDaDiretoria.setVerticalAlignment(Element.ALIGN_CENTER);
		cVistoDaDiretoria.setBorderWidthTop(0f);
		cVistoDaDiretoria.setBorderWidthBottom(0f);
		cVistoDaDiretoria.setBorderWidthLeft(0f);
		cVistoDaDiretoria.setBorderWidthRight(0f);
		
		document.add(pBlank);
	    	    
	    PdfPTable tabela2 = new PdfPTable(new float [] { 0.40f, 0.60f});
		tabela2.setWidthPercentage(100.0f);
		tabela2.addCell(cHorasComp);
		tabela2.addCell(cVistoDaChefia);
		document.add(tabela2);
				
		PdfPTable tabela3 = new PdfPTable(new float [] { 0.40f, 0.60f});
		tabela3.setWidthPercentage(100.0f);
		tabela3.addCell(cHorasDesc);
		tabela3.addCell(cVistoDaDiretoria);
		tabela3.setSpacingBefore(4); 
		document.add(tabela3);
		
		
	}
	
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
     	
     	document.add(pBlank);
     	
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
