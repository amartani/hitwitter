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
	 * Rejeita uma chamada que está para ser feita
	 */
	public void rejeitarChamada() throws RemoteException;
	
	/**
	 * Recebe uma mensagem
	 * 
	 * @param mensagem Mensagem enviada
	 */
	public void receberMensagem(Mensagem mensagem) throws RemoteException;
	
	/**
	 * Confirma início da chamada
	 * 
	 * @param telefone
	 *            Telefone interlocutor
	 */
	public void confirmarChamada(Telefone telefone) throws RemoteException;		
	
}
