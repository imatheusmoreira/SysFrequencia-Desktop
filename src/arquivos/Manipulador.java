/**
 * 
 */
package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.swing.JOptionPane;

/**
 * @author Matheus Moreira
 *
 */
public class Manipulador {
	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		File fileExiste = new File("dados.properties");
		
        if(!fileExiste.exists()){        	
        	FileWriter arqProp = new FileWriter("dados.properties");
            PrintWriter gravarArqProp = new PrintWriter(arqProp);
         
            gravarArqProp.printf("#Arquivo de configurações do SysPonto");
            gravarArqProp.printf("\nprop.server.host = 127.0.0.1");
            gravarArqProp.printf("\nprop.server.database = sistemaponto");
            gravarArqProp.printf("\nprop.server.user = root");
            gravarArqProp.printf("\nprop.server.password = 123456");
         
            arqProp.close();
            JOptionPane.showMessageDialog(null, "O sistema não encontrou o arquivo de propriedades, e por isso criou um novo.\n"
            		+ "Caso seja necessário se conectar com outro banco de dados, basta editar o arquivo de propriedades na pasta do programa\n"
            		+ "<html><b>Execute novamente o programa!",
            		"SysPonto", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }else{        	
        	FileInputStream file = new FileInputStream("dados.properties");
    		props.load(file);  
    	}
        return props;
	}
	
	public String infoPass() {
		String password; //Vari�vel que guardar� o password do us�ario.		
		Properties prop = null;
		try {
			prop = getProp();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao ler a senha do banco de dados no arquivo!\n"+e, ""+e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
		password = prop.getProperty("prop.server.password");
				
		System.out.println("Password = " + password);
		return password;
	}
	
	public String infoDatabase(){
		String host; //Variavel que guardar� o host do servidor.
		String database; //Variavel que guardar� o banco de dados do servidor.
		Properties prop = null;
		try {
			prop = getProp();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao ler a localização do banco de dados no arquivo!\n"+e, ""+e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
		
		host = prop.getProperty("prop.server.host");
		database = prop.getProperty("prop.server.database");
	
		System.out.println("Host = " + host);
		System.out.println("Database = " + database);
		return "jdbc:mysql://"+host+":3306/"+database+"";
	}

	public String infoUser(){
		String user; //Vari�vel que guardar� o nome do us�ario.		
		Properties prop = null;
		try {
			prop = getProp();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao ler o usuário do banco de dados no arquivo!\n"+e, ""+e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
		user = prop.getProperty("prop.server.user");

		System.out.println("User = " + user);
		return user;
	}
}
