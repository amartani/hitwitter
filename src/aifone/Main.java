package aifone;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Main {
	
	IAiFoneEntrada entrada;
	IAiFoneSaida saida;
	IAiFoneIU iu;

	private void iniciarServidorRMI(IAiFoneEntrada aifone, int porta, String nomeListener) {
		System.setSecurityManager(null);
		System.out.println("Ativando aifone");
		try {
			LocateRegistry.createRegistry(porta);
		} catch (Exception e) {
			System.out.println("Registro RMI ja estava ativo");
		}
		try {
			IAiFoneEntrada servidor = aifone;
			Naming.rebind("aifone" + nomeListener, servidor);
			System.out.println("Servidor ativo");
			//((AiFone) servidor).testeConectarTelefone();
		} catch (Exception e2) {
			System.out.println("Impossivel ativar servidor. Excecao: ");
			e2.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		IPropriedades propriedades = new PropriedadesArquivo();
		System.out.println("Conectando a " + propriedades.getEnderecoServidor());
		AiFone aifone = new AiFone(propriedades);
		main.iniciarServidorRMI(aifone.getEntrada(), 1100, aifone.getNomeListener());
		aifone.getIU().abrirTelaInicial();
		aifone.getSaida().conectarTelefone();
	}

}
