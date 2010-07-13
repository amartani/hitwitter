package aifone;

import java.rmi.RemoteException;

import aifone.telefone.IAppTelefoneSaida;
import entidades.Requisicao;
import entidades.RespostaDeRequisicao;
import entidades.Telefone;

public interface IAiFoneSaida extends IAppTelefoneSaida {

	/**
	 * Conecta o telefone no sistema.
	 * 
	 * @param telefone
	 *            Telefone a ser conectado
	 * @param enderecoRMI
	 *            Endereço RMI do cliente
	 */
	public void conectarTelefone()
			throws RemoteException;

	/**
	 * Desconecta o telefone do sistema
	 * 
	 * @param telefone
	 *            Telefone a ser desconectado
	 */
	public void desconectarTelefone(Telefone telefone) throws RemoteException;

	/**
	 * Envia uma requisicao via Tunel
	 * 
	 * @param origem
	 *            Telefone de origem da requisicao
	 * @param requisicao
	 *            Requisicao a ser efetuada
	 * @throws RemoteException
	 */
	public RespostaDeRequisicao enviarRequisicaoViaTunel(Requisicao requisicao) throws RemoteException;
}
