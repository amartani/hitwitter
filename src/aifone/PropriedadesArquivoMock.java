package aifone;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropriedadesArquivoMock extends PropriedadesArquivo {

	private Properties configFile;
	
	public PropriedadesArquivoMock() {
		configFile = new Properties();
		try {
			configFile.load(new FileInputStream("files/aifonemock.properties"));
		} catch (IOException e) {
			System.err.println("Arquivo de configuracao nao encontrado. Abortando!");
			System.exit(1);
		}
	}
	
	

}
