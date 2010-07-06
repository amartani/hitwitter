package central;

import java.rmi.RemoteException;

import central.gerenciamento.GerenciadorUsuariosFacade;

import entidades.Mensagem;
import entidades.Requisicao;
import entidades.Telefone;

public class Central implements ICentralRemote {
	
	private GerenciadorUsuariosFacade gerenciadorUsuariosFacade;
	
	public Central() {
		gerenciadorUsuariosFacade = new GerenciadorUsuariosFacade();
	}

	@Override
	public void conectarTelefone(Telefone telefone) throws RemoteException {
		System.out.println("desconectaTelefone");
		gerenciadorUsuariosFacade.conectarTelefone(telefone);
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

}