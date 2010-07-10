package central.telefone;

import java.rmi.RemoteException;

import entidades.Mensagem;
import entidades.Telefone;

public interface ICentralTelefonicaSaida {
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
	 * Encerra uma chamada em andamento
	 * 
	 * @param telefone
	 *            Telefone que está em uma chamada ou tentando chamar
	 */
	public void encerrarChamada(Telefone telefone) throws RemoteException;

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

	/**
	 * O cliente deve chamar este método quando a chamada for encerrada pela
	 * parte do mesmo
	 * 
	 * @param telefone
	 *            Telefone do cliente que encerrou a chamada
	 */
	public void informarChamadaEncerrada(Telefone telefone);

	/**
	 * O cliente deve chamar este método quando a chamada que está sendo
	 * conectada for rejeitada pelo mesmo
	 * 
	 * @param telefone
	 *            Telefone do cliente
	 */
	public void informarChamadaRejeitada(Telefone telefone);
}
