package aifone;

import entidades.Mensagem;
import entidades.Telefone;

public interface IAiFoneRemote {

	/**
	 * Recebe uma chamada telefonica
	 * 
	 * @param origem Telefone de origem da chamada
	 */
	public void receberChamada(Telefone origem);
	
	/**
	 * Encerra uma chamada em andamento
	 */
	public void encerrarChamada();
	
	/**
	 * Recebe uma mensagem
	 * 
	 * @param mensagem Mensagem enviada
	 */
	public void receberMensagem(Mensagem mensagem);
	
}
