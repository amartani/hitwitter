package aifone.telefone;

import entidades.Mensagem;
import entidades.Telefone;

public interface IAppTelefoneEntrada {
	/**
	 * Recebe uma chamada telefonica
	 * 
	 * @param origem
	 *            Telefone de origem da chamada
	 */
	public void receberChamada(Telefone origem);

	/**
	 * Encerra uma chamada em andamento
	 */
	public void informarChamadaEncerrada();

	/**
	 * Rejeita uma chamada que está para ser feita
	 */
	public void informarChamadaRejeitada();

	/**
	 * Recebe uma mensagem
	 * 
	 * @param mensagem
	 *            Mensagem enviada
	 */
	public void receberMensagem(Mensagem mensagem);

	/**
	 * Confirma início da chamada
	 */
	public void informarAtendimentoConfirmado();
}
