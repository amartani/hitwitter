package central;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entidades.Mensagem;
import entidades.Requisicao;
import entidades.Telefone;

public interface ICentralRemote extends Remote {
	public void conectarTelefone(Telefone telefone) throws RemoteException;
	public void desconectarTelefone(Telefone telefone) throws RemoteException;
	public void efetuarChamada(Telefone telefone) throws RemoteException;
	public void informarChamadaEncerrada(Telefone telefone) throws RemoteException;
	public void informarChamadaRejeitada(Telefone telefone) throws RemoteException;
	public void confirmarAtendimento(Telefone telefone) throws RemoteException;
	public void enviarMensagem(Mensagem mensagem) throws RemoteException;
	public void enviarRequisicaoViaTunel(Requisicao requisicao) throws RemoteException;
}
