package aifone;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entidades.Mensagem;
import entidades.Telefone;

public interface IAiFoneRemote extends Remote {

	/**
	 * Recebe uma chamada telefonica
	 * 
	 * @param origem Telefone de origem da chamada
	 */
	public void receberChamada(Telefone origem) throws RemoteException;
	
	/**
	 * Encerra uma chamada em andamento
	 */
	public void encerrarChamada() throws RemoteException;
	
	/**
	 * Recebe uma mensagem
	 * 
	 * @param mensagem Mensagem enviada
	 */
	public void receberMensagem(Mensagem mensagem) throws RemoteException;
	
}
