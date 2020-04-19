package funcoes;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FuncoesEnviarPDF {
	String biblioteca = InfoMySql.biblioteca;
	String url = InfoMySql.url;
	String login = InfoMySql.usuario;
	String senha = InfoMySql.senha;
	
	String urlArquivos = new FuncoesConfiguracoes().pegaURLSaida();
	
	String nomeSistema = funcoes.InfoMySql.nomeSistema;
	
	@SuppressWarnings("rawtypes")
	public void carregaTabela(DefaultTableModel tm, String SQL, JComboBox jcb1, JComboBox jcb2){
		try {//ESSE METODO LIMPA TODA A TABELA ANTES DE PREENCHER NOVAMENTE.
			int n = 0;
			n = tm.getRowCount();
			for (int i = 0; i < n;) {
				tm.removeRow(i);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		try {
			Class.forName(biblioteca);
			java.sql.Connection c = DriverManager.getConnection(url, login,
					senha);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(SQL);
			while (r.next()) {
				tm.addRow(new String[] { r.getString(1), r.getString(2), r.getString(3), urlArquivos+"/"+(String) jcb2.getSelectedItem()+"/"+jcb1.getSelectedItem()+"/"+r.getString(1)+"/"+r.getString(2)});
			}
			c.close();
		} catch (ClassNotFoundException e1) {
			new TrataErros().erroClassNotFound(e1);
		} catch (SQLException e1) {
			new TrataErros().erroSQL(e1);
		}
	}
	
	public void enviaEmails(DefaultTableModel tm, JTextField tf1, JTextArea ta1) throws UnsupportedEncodingException{
		for(int i = 0; i < tm.getRowCount(); i++){
			
			String dirStr = (String) tm.getValueAt(i, 3);			
			File dir = new File(dirStr);
			
	    	// Listo todos os arquivos do diretório
			File[] pdfNoDiretorio = dir.listFiles();
			List<File> arquivos = new ArrayList<File>();
			 
			// Jogo no ArrayList apenas os que possuem extensão 'pdf'
			for (int cont=0; cont<pdfNoDiretorio.length; cont++) {
			   if (pdfNoDiretorio[cont].getName().endsWith("pdf")) {
			      arquivos.add(pdfNoDiretorio[cont]);
			   }
			}
			
			Properties props = new Properties();
			/* Parâmetros de conexão com servidor Gmail */
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");

			Session session = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(new funcoes.FuncoesConfiguracoes().pegaDadosEmail(1), new funcoes.FuncoesConfiguracoes().pegaDadosEmail(2));
						}
					});

			/** Ativa Debug para sessão */
			session.setDebug(true);

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(new funcoes.FuncoesConfiguracoes().pegaDadosEmail(1), nomeSistema)); // Remetente
				Address[] toUser = InternetAddress.parse((String) tm.getValueAt(i, 2)); // Destinatário(s)
				message.setRecipients(Message.RecipientType.TO, toUser);
				message.setSubject(tf1.getText());// Assunto
				//message.setText(ta1.getText());//Texto

				Multipart mp = new MimeMultipart();
				MimeBodyPart mbp1 = new MimeBodyPart();
				mbp1.setContent(ta1.getText(), "text/plain");
				mp.addBodyPart(mbp1);
				
				for (int i1 = 0; i1 < arquivos.size(); i1++) {
					MimeBodyPart mbp = new MimeBodyPart();
					mbp.setFileName (arquivos.get(i1).getName());
					mbp.setDataHandler(new DataHandler(new FileDataSource(arquivos.get(i1))));
					mp.addBodyPart(mbp);
				}
				
				message.setContent(mp);
				
				/** Método para enviar a mensagem criada */
				Transport.send(message);


		} catch (MessagingException e) {
			funcoes.ExceptionDialog id = new funcoes.ExceptionDialog("O email não pôde ser enviado!", "Verifique sua conexao com internet. Se o problema é persistente, consulte o setor de suporte informando este erro.", e);
			id.setVisible(true);
			throw new RuntimeException(e);
		}catch (NullPointerException e){
			funcoes.ExceptionDialog id = new funcoes.ExceptionDialog("Falha ao anexar os arquivos!", "Verifique se você realmente já gerou os arquivos do mês em questão.", e);
			id.setVisible(true);
		}
	    	
		}
		JOptionPane.showMessageDialog(null, "Processo finalizado!");
	}
	
}
