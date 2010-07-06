package aifone;

import java.rmi.Naming;
import java.rmi.RemoteException;

import central.ICentralRemote;

public class AiFone {

	public static final String ENDERECO_CENTRAL = "rmi://alexandre11.redecasd.ita.br/centralaifone";

	public void testeConectarTelefone() throws RemoteException {
		getInstanciaServidor().conectarTelefone(null);
	}

	private ICentralRemote getInstanciaServidor() {
		ICentralRemote servidor = null;
		try {
			servidor = (ICentralRemote) Naming.lookup(ENDERECO_CENTRAL);

		} catch (Exception e) {
			System.out
					.println("Nao foi possivel conectar ao servidor. Excecao: ");
			e.printStackTrace();
		}
		return servidor;
	}
}
