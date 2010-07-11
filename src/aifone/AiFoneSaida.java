package aifone;

import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import central.ICentralRemote;

import entidades.Mensagem;
import entidades.Requisicao;
import entidades.RespostaDeRequisicao;
import entidades.Telefone;

public class AiFoneSaida implements IAiFoneSaida {
	
	private AiFone aifone;

	public AiFoneSaida(AiFone aifone) {
		super();
		this.aifone = aifone;
	}
	
	private String getEnderecoRMI() {
		try {
			return "rmi://"
					+ java.net.InetAddress.getLocalHost().getHostAddress()
					+ "/aifone";
		} catch (UnknownHostException e) {
			System.err.println("Nao foi possivel obter endereco local");
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}

	private Telefone getTelefone() {
		return new Telefone(getPropriedades().getNumeroTelefone());
	}
	
	private ICentralRemote servidor;
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
			servidor = (ICentralRemote) Naming.lookup(getPropriedades()
					.getEnderecoServidor());
		} catch (Exception e) {
			System.out
					.println("Nao foi possivel conectar ao servidor. Excecao: ");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	@Override
	public void conectarTelefone() throws RemoteException {
		getInstanciaServidor()
				.conectarTelefone(getTelefone(), getEnderecoRMI());
	}

	@Override
	public void desconectarTelefone(Telefone telefone) throws RemoteException {
		getInstanciaServidor().desconectarTelefone(telefone);
	}

	@Override
	public void efetuarChamada(Telefone destino) throws RemoteException {
		getInstanciaServidor().efetuarChamada(getTelefone(), destino);

	}

	@Override
	public void encerrarChamada() throws RemoteException {
		getInstanciaServidor().encerrarChamada(getTelefone());
	}

	@Override
	public void rejeitarChamada() throws RemoteException {
		getInstanciaServidor().rejeitarChamada(getTelefone());
	}

	@Override
	public void confirmarAtendimento() throws RemoteException {
		getInstanciaServidor().confirmarAtendimento(getTelefone());
	}

	@Override
	public void enviarMensagem(Mensagem mensagem) throws RemoteException {
		getInstanciaServidor().enviarMensagem(getTelefone(), mensagem);
	}

	@Override
	public RespostaDeRequisicao enviarRequisicaoViaTunel(Telefone origem,
			Requisicao requisicao) throws RemoteException {
		return getInstanciaServidor().enviarRequisicaoViaTunel(origem,
				requisicao);
	}
	
	private IPropriedades getPropriedades() {
		return aifone.getPropriedades();
	}
}
