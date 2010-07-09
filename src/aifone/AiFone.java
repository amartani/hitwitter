package aifone;

import java.net.UnknownHostException;
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
		getInstanciaServidor().conectarTelefone(getTelefone(), getEnderecoRMI());
		getInstanciaServidor().efetuarChamada(getTelefone(), getTelefone());
		getInstanciaServidor().desconectarTelefone(getTelefone());
		getInstanciaServidor().efetuarChamada(getTelefone(), getTelefone());
	}
	
	private String getEnderecoRMI() {
		try {
			return "rmi://"+java.net.InetAddress.getLocalHost().getHostAddress()+"/aifone";
		} catch (UnknownHostException e) {
			System.err.println("Nao foi possivel obter endereco local");
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	private Telefone getTelefone() {
		return new Telefone(propriedades.getNumeroTelefone());
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
		System.out.println("Recebendo chamada de " + origem.getNumero());
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
