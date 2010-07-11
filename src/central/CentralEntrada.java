package central;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import central.gerenciamento.IGerenciamentoEntrada;
import central.telefone.ICentralTelefonicaEntrada;
import central.tunel.ITunelEntrada;
import entidades.Mensagem;
import entidades.Requisicao;
import entidades.RespostaDeRequisicao;
import entidades.Telefone;

@SuppressWarnings("serial")
public class CentralEntrada extends UnicastRemoteObject implements ICentralRemote {

	private IGerenciamentoEntrada gerenciamento;
	private ITunelEntrada tunel;
	private ICentralTelefonicaEntrada centraltelefonica;

	public CentralEntrada(ICentralTelefonicaEntrada centraltelefonica,
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
	public void encerrarChamada(Telefone telefone) {
		centraltelefonica.encerrarChamada(telefone);
	}

	@Override
	public void rejeitarChamada(Telefone telefone) {
		centraltelefonica.rejeitarChamada(telefone);
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


}