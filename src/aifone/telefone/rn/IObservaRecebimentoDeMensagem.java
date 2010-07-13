package aifone.telefone.rn;

import entidades.Mensagem;
import entidades.Telefone;

public interface IObservaRecebimentoDeMensagem {
	public void mensagemRecebida(Telefone telefone, Mensagem mensagem);
}
