package aifone;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import aifone.iu.IUContainer;
import aifone.iu.IUTelaInicial;

public class Main {

	private void iniciarServidorRMI() {
		System.setSecurityManager(null);
		System.out.println("Ativando aifone");
		try {
			LocateRegistry.createRegistry(1100);
		} catch (Exception e) {
			System.out.println("Registro RMI ja estava ativo");
		}
		try {
			IAiFoneRemote servidor = new AiFone();
			Naming.rebind("aifone", servidor);
			System.out.println("Servidor ativo");
			((AiFone) servidor).testeConectarTelefone();
		} catch (Exception e2) {
			System.out.println("Impossivel ativar servidor. Excecao: ");
			e2.printStackTrace();
			System.exit(1);
		}
	}

	private void iniciarIU(AiFone aiFone) {
		IUContainer container = IUContainer.getInstance();
		container.setPanel(new IUTelaInicial(aiFone));
		container.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		AiFone aiFone = new AiFone();
		main.iniciarServidorRMI();
		main.iniciarIU(aiFone);
	}

}
