package central;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import aifone.IAiFoneRemote;

import central.gerenciamento.Gerenciamento;
import central.gerenciamento.IGerenciamento;

import entidades.Mensagem;
import entidades.Requisicao;
import entidades.Telefone;

public class Central extends UnicastRemoteObject implements ICentralRemote {

	private IGerenciamento gerenciamento;

	public Central() throws RemoteException {
		super();
		gerenciamento = new Gerenciamento();
	}

	@Override
	public void conectarTelefone(Telefone telefone, String enderecoRMI)
			throws RemoteException {
		System.out.println("conectaTelefone");
		gerenciamento.conectarTelefone(telefone, enderecoRMI);
	}

	@Override
	public void desconectarTelefone(Telefone telefone) throws RemoteException {
		System.out.println("desconectaTelefone");
		gerenciamento.desconectarTelefone(telefone);
	}

	@Override
	public void efetuarChamada(Telefone telefone) throws RemoteException {
		System.out.println("efetuaChamada");
		getInstanciaCliente(telefone).receberChamada(telefone);
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
	
	/**
	 * Instância do objeto RMI do cliente
	 */
	private IAiFoneRemote getInstanciaCliente(Telefone telefone) {
		IAiFoneRemote cliente = null;
		try {
			cliente = (IAiFoneRemote) Naming.lookup(gerenciamento.enderecoRMIDoCliente(telefone));
		} catch (Exception e) {
			System.out
					.println("Nao foi possivel conectar ao servidor. Excecao: ");
			e.printStackTrace();
			System.exit(1);
		}
		return cliente;
	}

	private static final long serialVersionUID = -4137275903989772036L;
}