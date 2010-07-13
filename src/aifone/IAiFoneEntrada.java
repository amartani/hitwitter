package aifone;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entidades.Mensagem;
import entidades.Telefone;

public interface IAiFoneEntrada extends Remote {

	/**
	 * Recebe uma chamada telefonica
	 * 
	 * @param origem
	 *            Telefone de origem da chamada
	 */
	public void receberChamada(Telefone origem) throws RemoteException;

	/**
	 * Encerra uma chamada em andamento
	 */
	public void informarChamadaEncerrada() throws RemoteException;

	/**
	 * Cancela um pedido de chamada recebido
	 */
	public void informarChamadaCancelada() throws RemoteException;

	/**
	 * Rejeita uma chamada que está para ser feita
	 */
	public void informarChamadaRejeitada() throws RemoteException;

	/**
	 * Recebe uma mensagem
	 * 
	 * @param mensagem
	 *            Mensagem enviada
	 */
	public void receberMensagem(Mensagem mensagem) throws RemoteException;

	/**
	 * Confirma início da chamada
	 */
	public void informarChamadaConfirmada() throws RemoteException;

}
