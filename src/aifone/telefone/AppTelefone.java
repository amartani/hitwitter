package aifone.telefone;

import aifone.IAiFoneSaida;

import entidades.Mensagem;
import entidades.Telefone;

public class AppTelefone implements IAppTelefone {

	private IAiFoneSaida aifone;

	public AppTelefone(IAiFoneSaida aifone) {
		this.aifone = aifone;
	}

	@Override
	public void receberChamada(Telefone origem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void encerrarChamada() {
		// TODO Auto-generated method stub

	}

	@Override
	public void receberMensagem(Mensagem mensagem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void confirmarChamada(Telefone telefone) {
		// TODO Auto-generated method stub

	}

}
