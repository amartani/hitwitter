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
import aifone.telefone.IAppTelefoneEntrada;
import central.ICentralRemote;
import entidades.Mensagem;
import entidades.Requisicao;
import entidades.RespostaDeRequisicao;
import entidades.Telefone;

@SuppressWarnings("serial")
public class AiFoneEntrada extends UnicastRemoteObject implements IAiFoneEntrada {

	private AiFone aifone;

	public AiFoneEntrada(AiFone aifone) throws RemoteException {
		super();
		this.aifone = aifone;
	}

	@Override
	public void receberChamada(Telefone origem) {
		getApptelefone().receberChamada(origem);

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
		getApptelefone().informarChamadaEncerrada();
	}

	@Override
	public void receberMensagem(Mensagem mensagem) {
		getApptelefone().receberMensagem(mensagem);

		// Teste:
		System.out.println("AiFone - Mensagem recebida: "
				+ mensagem.getConteudo());
	}

	@Override
	public void informarChamadaConfirmada(Telefone telefone) {
		getApptelefone().informarAtendimentoConfirmado(telefone);

	}

	@Override
	public void informarChamadaRejeitada() throws RemoteException {
		getApptelefone().informarChamadaRejeitada();
	}

	private IAppTelefoneEntrada getApptelefone() {
		return aifone.getAppTelefoneEntrada();
	}

}
