package central;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entidades.Mensagem;
import entidades.Requisicao;
import entidades.Telefone;

public interface ICentralRemote extends Remote {
	public void conectarTelefone(Telefone telefone, String enderecoRMI) throws RemoteException;
	public void desconectarTelefone(Telefone telefone) throws RemoteException;
	public void efetuarChamada(Telefone origem, Telefone destino) throws RemoteException;
	public void informarChamadaEncerrada(Telefone telefone) throws RemoteException;
	public void informarChamadaRejeitada(Telefone telefone) throws RemoteException;
	public void confirmarAtendimento(Telefone telefone) throws RemoteException;
	public void enviarMensagem(Telefone origem, Mensagem mensagem) throws RemoteException;
	public void enviarRequisicaoViaTunel(Telefone origem, Requisicao requisicao) throws RemoteException;
}
