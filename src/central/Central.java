package central;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import central.gerenciamento.Gerenciamento;
import central.gerenciamento.IGerenciamento;

import entidades.Mensagem;
import entidades.Requisicao;
import entidades.Telefone;

public class Central extends UnicastRemoteObject implements ICentralRemote {

	private IGerenciamento gerenciamento;

	public Central() throws RemoteException {
		gerenciamento = new Gerenciamento();
	}

	@Override
	public void conectarTelefone(Telefone telefone, String enderecoRMI)
			throws RemoteException {
		System.out.println("desconectaTelefone");
		gerenciamento.conectarTelefone(telefone, enderecoRMI);
	}

	@Override
	public void desconectarTelefone(Telefone telefone) throws RemoteException {
		System.out.println("desconectaTelefone");
	}

	@Override
	public void efetuarChamada(Telefone telefone) throws RemoteException {
		System.out.println("efetuaChamada");
	}

	@Override
	public void informarChamadaEncerrada(Telefone telefone)
			throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void informarChamadaRejeitada(Telefone telefone)
			throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void confirmarAtendimento(Telefone telefone) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void enviarMensagem(Mensagem mensagem) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void enviarRequisicaoViaTunel(Requisicao requisicao)
			throws RemoteException {
		// TODO Auto-generated method stub

	}

	private static final long serialVersionUID = -4137275903989772036L;
}