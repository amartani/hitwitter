package aifone;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropriedadesArquivo implements IPropriedades {

	private Properties configFile;
	
	public PropriedadesArquivo() {
		configFile = new Properties();
		try {
			configFile.load(new FileInputStream("files/aifone.properties"));
		} catch (IOException e) {
			System.err.println("Arquivo de configuracao nao encontrado. Abortando!");
			System.exit(1);
		}
	}
	
	@Override
	public String getEnderecoServidor() {
		return configFile.getProperty("EnderecoServidor");
	}

}
