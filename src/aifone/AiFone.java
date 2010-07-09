package aifone;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import central.ICentralRemote;
import entidades.Mensagem;
import entidades.Telefone;

@SuppressWarnings("serial")
public class AiFone extends UnicastRemoteObject implements IAiFoneRemote {

	protected AiFone() throws RemoteException {
		super();
	}

	private ICentralRemote servidor;
	private IPropriedades propriedades;

	public void testeConectarTelefone() throws RemoteException {
		propriedades = new PropriedadesArquivo();
		getInstanciaServidor().conectarTelefone(null, null);
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
			servidor = (ICentralRemote) Naming.lookup(propriedades.getEnderecoServidor());
		} catch (Exception e) {
			System.out
					.println("Nao foi possivel conectar ao servidor. Excecao: ");
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void receberChamada(Telefone origem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void encerrarChamada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receberMensagem(Mensagem mensagem) {
		// TODO Auto-generated method stub
		
	}
}
