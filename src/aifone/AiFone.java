package aifone;

import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import aifone.hitwitter.HiTwitter;
import aifone.hitwitter.IHiTwitter;
import aifone.iu.IUContainer;
import aifone.iu.IUTelaInicial;
import aifone.telefone.AppTelefone;
import aifone.telefone.IAppTelefone;
import central.ICentralRemote;
import entidades.Mensagem;
import entidades.Requisicao;
import entidades.RespostaDeRequisicao;
import entidades.Telefone;

@SuppressWarnings("serial")
public class AiFone extends UnicastRemoteObject implements IAiFone {

	private IAppTelefone apptelefone;
	private IHiTwitter hitwitter;
	private ICentralRemote servidor;
	private IPropriedades propriedades;

	protected AiFone() throws RemoteException {
		super();
		apptelefone = new AppTelefone(this);
		hitwitter = new HiTwitter(this);
		propriedades = new PropriedadesArquivo();

		conectarTelefone();
		abrirTelaInicial();
	}

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
		// System.out.println("AiFone: pedido de chamada recebido");
		// try {
		// ((ICentralRemote) getInstanciaServidor())
		// .confirmarAtendimento(getTelefone());
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	@Override
	public void informarChamadaEncerrada() {
		apptelefone.informarChamadaEncerrada();
	}

	@Override
	public void receberMensagem(Mensagem mensagem) {
		apptelefone.receberMensagem(mensagem);

		// Teste:
		System.out.println("AiFone - Mensagem recebida: "
				+ mensagem.getConteudo());
	}

	@Override
	public void informarChamadaConfirmada(Telefone telefone){
		apptelefone.informarAtendimentoConfirmado(telefone);

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

	@Override
	public void informarChamadaRejeitada() throws RemoteException {
		apptelefone.informarChamadaRejeitada();
	}

	@Override
	public void abrirTelaInicial() {
		IUContainer container = IUContainer.getInstance();
		container.setPanel(new IUTelaInicial(this));
		container.setVisible(true);
	}

	@Override
	public void abrirTelaTelefone() {
		apptelefone.abrirTelaDiscar();

	}

}
