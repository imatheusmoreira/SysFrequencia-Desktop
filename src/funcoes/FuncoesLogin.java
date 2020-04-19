package funcoes;

import java.io.UnsupportedEncodingException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import grafico.Principal;

public class FuncoesLogin {
	
SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d' de 'MMMM' de 'yyyy"); // Apenas para criar uma variável de data.
   
String biblioteca = InfoMySql.biblioteca;
String url = InfoMySql.url;
String login = InfoMySql.usuario;
String senha = InfoMySql.senha;

String nomeSistema = funcoes.InfoMySql.nomeSistema;

@SuppressWarnings("static-access")
public void validaLogin(JTextField txtMatricula, JPasswordField ftxtSenha, javax.swing.JFrame dialog) {
	int verificador = 0;
	try {
		java.sql.Connection c = DriverManager.getConnection(url, login, senha);
		
		PreparedStatement pst = c.prepareStatement("SELECT nome FROM servidores WHERE matricula = ? AND senha = ? LIMIT 1");
		pst.setString(1, txtMatricula.getText());
		pst.setString(2, new String(ftxtSenha.getPassword()));
		
		ResultSet r = pst.executeQuery();
		
		while (r.next()) {
			verificador = 1;
			new funcoes.InfoMySql().matricula = txtMatricula.getText();
			new funcoes.InfoMySql().nvAcesso = new funcoes.FuncoesUsuarios().nivelAcesso(txtMatricula.getText());
		}
		
		if(verificador == 0){
			JOptionPane.showMessageDialog(null, "Senha inválida!");
		}
		if(verificador == 1){
			dialog.dispose();
			Principal p = new Principal();
			p.setVisible(true);
		}

	} catch (SQLException e1) {
		new TrataErros().erroSQL(e1);
	}
}

public void validaEmail(String email){
	try{
    	Class.forName(biblioteca);
		java.sql.Connection c = DriverManager.getConnection(url, login,	senha);
		
		PreparedStatement pst = c.prepareStatement("SELECT nome, senha FROM servidores WHERE email = ? AND ehusuario = 'SIM'");
		pst.setString(1, email);
		
		ResultSet r = pst.executeQuery();
		
		if (r.next()) {
			String texto = r.getString(2);
			enviaEmail(email, texto);
			
		}else{
			JOptionPane.showMessageDialog(null, "Parece que esse email não pertence a nenhum funcionário cadastrado como usuário.");
		}
    	} catch (ClassNotFoundException e1) {
    		new TrataErros().erroClassNotFound(e1);
    	} catch (SQLException e1) {
    		new TrataErros().erroSQL(e1);
    } catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
}

public void enviaEmail(String email, String texto) throws UnsupportedEncodingException{
	Properties props = new Properties();
	/* Parâmetros de conexão com servidor Gmail */
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.socketFactory.port", "465");
	props.put("mail.smtp.socketFactory.class",
			"javax.net.ssl.SSLSocketFactory");
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.port", "465");

	Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(
							"cti.maracanau@ifce.edu.br", "@ti!2017");
				}
			});

	/** Ativa Debug para sessão */
	session.setDebug(true);

	try {

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("cti.maracanau@ifce.edu.br", nomeSistema)); // Remetente

		Address[] toUser = InternetAddress.parse(email);// Destinatário(s)

		message.setRecipients(Message.RecipientType.TO, toUser);
		message.setSubject("SysFrequência - Recuperação de senha");// Assunto
		message.setText("Olá, Você solicitou que o sistema gerador de frequências enviasse sua senha para " +  email
				+ "\nSua senha é: " + texto);//Mensagem
		
		/** Método para enviar a mensagem criada */
		Transport.send(message);

		JOptionPane.showMessageDialog(null, "Email enviado com sucesso!");

		} catch (MessagingException e) {
			funcoes.ExceptionDialog id = new funcoes.ExceptionDialog("O email não pôde ser enviado!", "Verifique sua conexao com internet. Se o problema é persistente, consulte o setor de suporte informando este erro.", e);
			id.setVisible(true);
			throw new RuntimeException(e);
		}
	}
}


