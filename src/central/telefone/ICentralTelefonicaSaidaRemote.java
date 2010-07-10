package central.telefone;

import java.rmi.RemoteException;

import entidades.Mensagem;
import entidades.Telefone;

public interface ICentralTelefonicaSaidaRemote {
	/**
	 * Envia um pedido de chamada telefonica
	 * 
	 * @param origem
	 *            Telefone de origem da chamada
	 * 
	 * @param destino
	 *            Telefone de destino da chamada
	 */
	public void enviarPedidoChamada(Telefone origem, Telefone destino)
			throws RemoteException;

	/**
	 * Informa o cliente que a chamada foi encerrada
	 * 
	 * @param telefone
	 *            Telefone do cliente que deve ser avisado
	 */
	public void encerrarChamada(Telefone telefone) throws RemoteException;

	/**
	 * Informa o cliente que a chamada foi rejeitada
	 * 
	 * @param telefone
	 *            Telefone do cliente que deve ser avisado
	 * @throws RemoteException
	 */
	public void rejeitarChamada(Telefone telefone) throws RemoteException;

	/**
	 * Envia uma mensagem do servidor para o telefone de destino
	 * 
	 * @param telefone
	 *            Telefone de destino
	 * 
	 * @param mensagem
	 *            Mensagem enviada
	 */
	public void enviarMensagemParaCliente(Telefone telefone, Mensagem mensagem)
			throws RemoteException;

	/**
	 * Confirma início da chamada
	 * 
	 * @param telefone
	 *            Telefone interlocutor
	 */
	public void confirmarChamada(Telefone telefone) throws RemoteException;

}
