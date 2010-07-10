package aifone;

import java.rmi.RemoteException;

import entidades.Mensagem;
import entidades.Requisicao;
import entidades.RespostaDeRequisicao;
import entidades.Telefone;

public interface IAiFoneSaida {

	/**
	 * Conecta o telefone no sistema.
	 * 
	 * @param telefone
	 *            Telefone a ser conectado
	 * @param enderecoRMI
	 *            Endereço RMI do cliente
	 */
	public void conectarTelefone(Telefone telefone, String enderecoRMI)
			throws RemoteException;

	/**
	 * Desconecta o telefone do sistema
	 * 
	 * @param telefone
	 *            Telefone a ser desconectado
	 */
	public void desconectarTelefone(Telefone telefone) throws RemoteException;

	/**
	 * Inicia uma chamada
	 * 
	 * @param origem
	 *            Telefone de origem
	 * @param destino
	 *            Telefone de destino
	 * @throws RemoteException
	 */
	public void efetuarChamada(Telefone origem, Telefone destino)
			throws RemoteException;

	/**
	 * O cliente deve chamar este método quando a chamada for encerrada pela
	 * parte do mesmo
	 * 
	 * @param telefone
	 *            Telefone do cliente que encerrou a chamada
	 * @throws RemoteException
	 */
	public void informarChamadaEncerrada(Telefone telefone)
			throws RemoteException;

	/**
	 * O cliente deve chamar este método quando a chamada que está sendo
	 * conectada for rejeitada pelo mesmo
	 * 
	 * @param telefone
	 *            Telefone do cliente
	 * @throws RemoteException
	 */
	public void informarChamadaRejeitada(Telefone telefone)
			throws RemoteException;

	/**
	 * O cliente deve chamar este método quando a chamada for atendida
	 * 
	 * @param telefone
	 *            Telefone do cliente
	 * @throws RemoteException
	 */
	public void confirmarAtendimento(Telefone telefone) throws RemoteException;

	/**
	 * Envia uma mensagem
	 * 
	 * Deve haver uma chamada em andamento
	 * 
	 * @param origem
	 *            Telefone de origem da mensagem
	 * @param mensagem
	 *            Mensagem à ser enviada
	 * @throws RemoteException
	 */
	public void enviarMensagem(Telefone origem, Mensagem mensagem)
			throws RemoteException;

	/**
	 * Envia uma requisicao via Tunel
	 * 
	 * @param origem
	 *            Telefone de origem da requisicao
	 * @param requisicao
	 *            Requisicao a ser efetuada
	 * @throws RemoteException
	 */
	public RespostaDeRequisicao enviarRequisicaoViaTunel(Telefone origem, Requisicao requisicao)
			throws RemoteException;
}