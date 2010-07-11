package central;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

import aifone.IAiFoneRemote;
import central.gerenciamento.Gerenciamento;
import central.gerenciamento.IGerenciamentoEntrada;
import central.telefone.CentralTelefonica;
import central.telefone.ICentralTelefonicaEntrada;
import central.tunel.ITunelEntrada;
import central.tunel.Tunel;
import entidades.Mensagem;
import entidades.Requisicao;
import entidades.RespostaDeRequisicao;
import entidades.Telefone;

@SuppressWarnings("serial")
public class Central extends UnicastRemoteObject implements ICentral {

	private IGerenciamentoEntrada gerenciamento;
	private ITunelEntrada tunel;
	private ICentralTelefonicaEntrada centraltelefonica;

	public Central() throws RemoteException {
		super();
		gerenciamento = new Gerenciamento();
		centraltelefonica = new CentralTelefonica(this, gerenciamento);
		tunel = new Tunel();
	}

	public Central(ICentralTelefonicaEntrada centraltelefonica,
			IGerenciamentoEntrada gerenciamento, ITunelEntrada tunel)
			throws RemoteException {
		super();
		this.centraltelefonica = centraltelefonica;
		this.gerenciamento = gerenciamento;
		this.tunel = tunel;
	}

	@Override
	public void conectarTelefone(Telefone telefone, String enderecoRMI) {
		System.out.println("conectaTelefone: " + telefone.getNumero());
		try {
			System.out.println("Client host: " + getClientHost());
		} catch (ServerNotActiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gerenciamento.conectarTelefone(telefone, enderecoRMI);
	}

	@Override
	public void desconectarTelefone(Telefone telefone) {
		System.out.println("desconectarTelefone");
		gerenciamento.desconectarTelefone(telefone);
	}

	@Override
	public void efetuarChamada(Telefone origem, Telefone destino) {
		System.out.println("efetuarChamada");
		centraltelefonica.efetuarChamada(origem, destino);
	}

	@Override
	public void informarChamadaEncerrada(Telefone telefone) {
		centraltelefonica.informarChamadaEncerrada(telefone);
	}

	@Override
	public void informarChamadaRejeitada(Telefone telefone) {
		centraltelefonica.informarChamadaRejeitada(telefone);
	}

	@Override
	public void confirmarAtendimento(Telefone telefone) {
		centraltelefonica.confirmarAtendimento(telefone);
	}

	@Override
	public void enviarMensagem(Telefone origem, Mensagem mensagem) {
		centraltelefonica.enviarMensagem(origem, mensagem);
	}

	@Override
	public RespostaDeRequisicao enviarRequisicaoViaTunel(Telefone origem,
			Requisicao requisicao) {
		return tunel.enviarRequisicao(origem, requisicao);
	}

	/**
	 * Instância do objeto RMI do cliente
	 */
	private IAiFoneRemote getInstanciaCliente(Telefone telefone) {
		IAiFoneRemote cliente = null;
		try {
			cliente = (IAiFoneRemote) Naming.lookup(gerenciamento
					.enderecoRMIDoCliente(telefone));
		} catch (Exception e) {
			System.out
					.println("Nao foi possivel conectar ao servidor. Excecao: ");
			e.printStackTrace();
			System.exit(1);
		}
		return cliente;
	}

	/*
	 * Metodos da interface de saida ICentralSaida
	 */

	@Override
	public void encerrarChamada(Telefone telefone) throws RemoteException {
		getInstanciaCliente(telefone).encerrarChamada();

	}

	@Override
	public void enviarPedidoChamada(Telefone origem, Telefone destino)
			throws RemoteException {
		getInstanciaCliente(destino).receberChamada(origem);

	}

	@Override
	public void enviarMensagemParaCliente(Telefone telefone, Mensagem mensagem)
			throws RemoteException {
		getInstanciaCliente(telefone).receberMensagem(mensagem);

	}

	@Override
	public void confirmarChamada(Telefone telefone) throws RemoteException {
		getInstanciaCliente(telefone).confirmarChamada(telefone);
	}

	@Override
	public void rejeitarChamada(Telefone telefone) throws RemoteException {
		getInstanciaCliente(telefone).rejeitarChamada();
	}

}