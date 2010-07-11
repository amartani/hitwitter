package aifone;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import aifone.telefone.IAppTelefoneEntrada;
import entidades.Mensagem;
import entidades.Telefone;

@SuppressWarnings("serial")
public class AiFoneEntrada extends UnicastRemoteObject implements
		IAiFoneEntrada {

	private AiFone aifone;

	public AiFoneEntrada(AiFone aifone) throws RemoteException {
		super();
		this.aifone = aifone;
	}

	/*
	 * Entrada
	 */

	@Override
	public void receberChamada(Telefone origem) {
		getApptelefone().receberChamada(origem);

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
		System.out.println("AiFoneEntrada " + aifone.getTelefone().getNumero()
				+ ": minha chamada foi confirmada");
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
