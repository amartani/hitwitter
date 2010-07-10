package aifone;

import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JPanel;

import aifone.hitwitter.HiTwitter;
import aifone.hitwitter.IHiTwitter;
import aifone.telefone.AppTelefone;
import aifone.telefone.IAppTelefone;
import aifone.telefone.iu.IUDiscar;
import central.ICentralRemote;
import entidades.Mensagem;
import entidades.Requisicao;
import entidades.RespostaDeRequisicao;
import entidades.Telefone;

@SuppressWarnings("serial")
public class AiFone extends UnicastRemoteObject implements IAiFoneRemote,
		IAiFoneSaida, IAiFoneIU {

	IAppTelefone apptelefone;
	IHiTwitter hitwitter;

	protected AiFone() throws RemoteException {
		super();
		apptelefone = new AppTelefone(this);
		hitwitter = new HiTwitter(this);
		propriedades = new PropriedadesArquivo();

		conectarTelefone();
	}

	private ICentralRemote servidor;
	private IPropriedades propriedades;

	public void testeConectarTelefone() throws RemoteException {
		getInstanciaServidor().efetuarChamada(getTelefone(), getTelefone());
		Mensagem mensagem = new Mensagem("Hi there!");
		getInstanciaServidor().enviarMensagem(getTelefone(), mensagem);
		getInstanciaServidor().desconectarTelefone(getTelefone());
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
			servidor = (ICentralRemote) Naming.lookup(propriedades
					.getEnderecoServidor());
		} catch (Exception e) {
			System.out
					.println("Nao foi possivel conectar ao servidor. Excecao: ");
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void receberChamada(Telefone origem) {
		apptelefone.receberChamada(origem);

		// Teste: aceitação automática da chamada
		System.out.println("AiFone: pedido de chamada recebido");
		try {
			((ICentralRemote) getInstanciaServidor())
					.confirmarAtendimento(getTelefone());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void encerrarChamada() {
		apptelefone.encerrarChamada();
	}

	@Override
	public void receberMensagem(Mensagem mensagem) {
		apptelefone.receberMensagem(mensagem);

		// Teste:
		System.out.println("AiFone - Mensagem recebida: "
				+ mensagem.getConteudo());
	}

	@Override
	public void confirmarChamada(Telefone telefone) throws RemoteException {
		apptelefone.confirmarChamada(telefone);

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
	public void informarChamadaEncerrada(Telefone telefone)
			throws RemoteException {
		getInstanciaServidor().informarChamadaEncerrada(telefone);
	}

	@Override
	public void informarChamadaRejeitada() throws RemoteException {
		getInstanciaServidor().informarChamadaRejeitada(getTelefone());
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

	@Override
	public IUDiscar getIUDiscarInstance(JPanel telaRetorno) {
		return apptelefone.getIUDiscarInstance(telaRetorno);
	}

	@Override
	public void rejeitarChamada() throws RemoteException {
		apptelefone.rejeitarChamada();
	}

}
