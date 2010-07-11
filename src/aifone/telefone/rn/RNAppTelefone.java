package aifone.telefone.rn;

import aifone.telefone.IAppTelefone;
import entidades.Mensagem;
import entidades.Telefone;

public class RNAppTelefone {

	private IAppTelefone appTelefone;
	private String interlocutor;

	public RNAppTelefone(IAppTelefone appTelefone) {
		super();
		this.appTelefone = appTelefone;
	}

	public String getInterlocutor() {
		return interlocutor;
	}

	public void setInterlocutor(String interlocutor) {
		this.interlocutor = interlocutor;
	}

	/*
	 * Entrada
	 */

	public void receberChamada(Telefone origem) {
		System.out.println("RNApp: chamada recebida");
		interlocutor = origem.getNumero();
		appTelefone.abrirTelaRecebimentoDeChamada();
	}

	public void receberMensagem(Mensagem mensagem) {
		appTelefone.exibirMensagem(getInterlocutor(), mensagem);

	}

	public void informarChamadaRejeitada() {
		System.out.println("RNApp: informarChamadaRejeitada recebido");
		setInterlocutor(null);
		appTelefone.abrirTelaInicial();
	}

	public void informarChamadaEncerrada() {
		System.out.println("RNApp: informarChamadaEncerrada recebido");
		setInterlocutor(null);
		appTelefone.abrirTelaInicial();
	}

	public void informarAtendimentoConfirmado(Telefone telefone) {
		System.out.println("RNApp: informarAtendimentoConfirmado recebido");
		appTelefone.abrirTelaConversa();
	}

	/*
	 * Saida
	 */

	public void rejeitarChamada() {
		if (interlocutor != null) {
			try {
				appTelefone.rejeitarChamada();
			} catch (Exception e) {
				System.out
						.println("Nao foi possivel rejeitar chamada. Excecao: ");
				e.printStackTrace();
			}
		}
	}

	public void efetuarChamada() {
		if (interlocutor != null) {
			try {
				appTelefone.efetuarChamada(new Telefone(interlocutor));
			} catch (Exception e) {
				System.out
						.println("Nao foi possivel efetuar chamada. Excecao: ");
				e.printStackTrace();
			}
		}
	}

	public void encerrarChamada() {
		try {
			appTelefone.encerrarChamada();
		} catch (Exception e) {
			System.out.println("Nao foi possivel encerrar chamada. Excecao: ");
			e.printStackTrace();
		}

	}

	public void enviarMensagem(Mensagem mensagem) {
		try {
			appTelefone.enviarMensagem(mensagem);
		} catch (Exception e) {
			System.out.println("Nao foi possivel enviar mensagem. Excecao: ");
			e.printStackTrace();
		}
	}

	public void confirmarAtendimento() {
		try {
			appTelefone.confirmarAtendimento();
		} catch (Exception e) {
			System.out
					.println("Nao foi possivel confirmar atendimento. Excecao: ");
			e.printStackTrace();
		}
	}
}
