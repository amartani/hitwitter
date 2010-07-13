package central.telefone;

import java.rmi.RemoteException;

import entidades.Mensagem;
import entidades.Telefone;

public interface ICentralTelefonicaEntrada {

	/**
	 * Inicia uma chamada
	 * 
	 * @param origem
	 *            Telefone de origem
	 * @param destino
	 *            Telefone de destino
	 */
	public void efetuarChamada(Telefone origem, Telefone destino);

	/**
	 * O cliente deve chamar este método quando a chamada for atendida
	 * 
	 * @param telefone
	 *            Telefone do cliente
	 */
	public void confirmarAtendimento(Telefone telefone);

	/**
	 * Envia uma mensagem
	 * 
	 * Deve haver uma chamada em andamento
	 * 
	 * @param origem
	 *            Telefone de origem da mensagem
	 * @param mensagem
	 *            Mensagem a ser enviada
	 */
	public void enviarMensagem(Telefone origem, Mensagem mensagem);

	/**
	 * O cliente deve chamar este método quando a chamada for encerrada pela
	 * parte do mesmo
	 * 
	 * @param telefone
	 *            Telefone do cliente que encerrou a chamada
	 */
	public void encerrarChamada(Telefone telefone);
	
	/**
	 * O cliente deve chamar este método quando desiste de fazer a chamada
	 * 
	 * @throws RemoteException
	 */
	public void cancelarChamada(Telefone telefone) throws RemoteException;

	/**
	 * O cliente deve chamar este método quando a chamada que está sendo
	 * conectada for rejeitada pelo mesmo
	 * 
	 * @param telefone
	 *            Telefone do cliente
	 */
	public void rejeitarChamada(Telefone telefone);
}
