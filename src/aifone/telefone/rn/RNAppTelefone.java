package aifone.telefone.rn;

import javax.swing.JPanel;

import aifone.iu.IUContainer;
import aifone.telefone.IAppTelefone;
import aifone.telefone.iu.IUDiscar;
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

	public void confirmarChamada(Telefone telefone) {
		// TODO Auto-generated method stub

	}

	public void encerrarChamada() {
		// TODO Auto-generated method stub

	}

	public void receberChamada(Telefone origem) {
		System.out.println("RNApp: chamada recebida");
		interlocutor = origem.getNumero();
		IUContainer iuContainer = appTelefone.getIUContainerInstance();
		System.out.println("RNApp: chamada recebida");
		JPanel panelAtual = (JPanel)iuContainer.getContentPane();
		iuContainer.setPanel(new IUDiscar(this,panelAtual));
	}

	public void receberMensagem(Mensagem mensagem) {
		// TODO Auto-generated method stub

	}

	/*
	 * Saida
	 */

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

	public void informarChamadaRejeitada() {
		try {
			appTelefone.informarChamadaRejeitada();
		} catch (Exception e) {
			System.out.println("Nao foi possivel rejeitar chamada. Excecao: ");
			e.printStackTrace();
		}
	}

	public void informarChamadaEncerrada() {
		try {
			appTelefone.informarChamadaEncerrada();
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
