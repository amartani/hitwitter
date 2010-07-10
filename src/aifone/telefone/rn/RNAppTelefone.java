package aifone.telefone.rn;

import aifone.telefone.IAppTelefone;
import entidades.Telefone;

public class RNAppTelefone {

	private IAppTelefone appTelefone;
	private String interlocutor;

	public RNAppTelefone(IAppTelefone appTelefone) {
		super();
		this.appTelefone = appTelefone;
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

	public String getInterlocutor() {
		return interlocutor;
	}

	public void setInterlocutor(String interlocutor) {
		this.interlocutor = interlocutor;
	}
}
