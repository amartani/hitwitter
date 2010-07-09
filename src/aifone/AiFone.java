package aifone;

import java.rmi.Naming;
import java.rmi.RemoteException;

import central.ICentralRemote;

public class AiFone {

	public static final String ENDERECO_CENTRAL = "rmi://alexandre11.redecasd.ita.br/centralaifone";

	private ICentralRemote servidor;

	public void testeConectarTelefone() throws RemoteException {
		getInstanciaServidor().conectarTelefone(null);
	}

	/**
	 * Obtém uma instância do objeto RMI no servidor
	 * 
	 * @return Objeto remoto
	 */
	private ICentralRemote getInstanciaServidor() {
		if (servidor == null) {
			criarInstanciaServidor();
		}
		return this.servidor;
	}

	/**
	 * Cria a instância do objeto RMI do servidor
	 */
	private void criarInstanciaServidor() {
		try {
			servidor = (ICentralRemote) Naming.lookup(ENDERECO_CENTRAL);
		} catch (Exception e) {
			System.out
					.println("Nao foi possivel conectar ao servidor. Excecao: ");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
