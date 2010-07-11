package aifone.telefone;

import java.rmi.RemoteException;

import entidades.Mensagem;
import entidades.Telefone;

public interface IAppTelefoneSaida {
	/**
	 * Inicia uma chamada
	 * 
	 * @param destino
	 *            Telefone de destino
	 * @throws RemoteException
	 */
	public void efetuarChamada(Telefone destino) throws RemoteException;

	/**
	 * O cliente deve chamar este método quando a chamada for encerrada pela
	 * parte do mesmo
	 * 
	 * @throws RemoteException
	 */
	public void informarChamadaEncerrada()
			throws RemoteException;

	/**
	 * O cliente deve chamar este método quando a chamada que está sendo
	 * conectada for rejeitada pelo mesmo
	 * 
	 * @param telefone
	 *            Telefone do cliente
	 * @throws RemoteException
	 */
	public void informarChamadaRejeitada()
			throws RemoteException;

	/**
	 * O cliente deve chamar este método quando a chamada for atendida
	 * 
	 * @param telefone
	 *            Telefone do cliente
	 * @throws RemoteException
	 */
	public void confirmarAtendimento() throws RemoteException;

	/**
	 * Envia uma mensagem
	 * 
	 * Deve haver uma chamada em andamento
	 * 
	 * @param mensagem
	 *            Mensagem a ser enviada
	 * @throws RemoteException
	 */
	public void enviarMensagem(Mensagem mensagem)
			throws RemoteException;

}
