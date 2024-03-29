package aifone;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class MainRandom {
	
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
		} catch (Exception e2) {
			System.out.println("Impossivel ativar servidor. Excecao: ");
			e2.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		MainRandom main = new MainRandom();
		IPropriedades propriedades = new PropriedadesRandom();
		System.out.println("Conectando a " + propriedades.getEnderecoServidor());
		AiFone aifone = new AiFone(propriedades);
		main.iniciarServidorRMI(aifone.getEntrada(), 1100, aifone.getNomeListener());
		aifone.getIU().abrirTelaInicial();
		aifone.getSaida().conectarTelefone();
	}

}
