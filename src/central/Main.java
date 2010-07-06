package central;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setSecurityManager(null);
		System.out.println("Ativando servidor");
		try {
			LocateRegistry.createRegistry(1099);
		} catch (Exception e) {
			System.out.println("Registro RMI ja estava ativo");
		}
		try {
			ICentralRemote servidor = new Central();
			Naming.rebind("centralaifone", servidor);
			System.out.println("Servidor ativo");
		} catch (Exception e2) {
			System.out.println("Impossivel ativar servidor. Excecao: ");
			e2.printStackTrace();
		}
	}

}
