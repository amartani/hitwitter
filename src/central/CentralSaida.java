package central;

import java.rmi.Naming;
import java.rmi.RemoteException;

import aifone.IAiFoneEntrada;
import central.gerenciamento.IGerenciamentoEntrada;
import entidades.Mensagem;
import entidades.Telefone;

public class CentralSaida implements ICentralSaida {

	private IGerenciamentoEntrada gerenciamento;

	public CentralSaida(IGerenciamentoEntrada gerenciamento) {
		super();
		this.gerenciamento = gerenciamento;
	}

	/**
	 * Instância do objeto RMI do cliente
	 */
	private IAiFoneEntrada getInstanciaCliente(Telefone telefone) {
		IAiFoneEntrada cliente = null;
		try {
			cliente = (IAiFoneEntrada) Naming.lookup(gerenciamento
					.enderecoRMIDoCliente(telefone));
		} catch (Exception e) {
			System.out
					.println("Nao foi possivel conectar ao servidor. Excecao: ");
			e.printStackTrace();
			System.exit(1);
		}
		return cliente;
	}

	/*
	 * Metodos da interface de saida ICentralSaida
	 */

	@Override
	public void informarChamadaEncerrada(Telefone telefone)
			throws RemoteException {
		getInstanciaCliente(telefone).informarChamadaEncerrada();

	}

	@Override
	public void receberChamada(Telefone origem, Telefone destino)
			throws RemoteException {
		getInstanciaCliente(destino).receberChamada(origem);

	}

	@Override
	public void receberMensagem(Telefone telefone, Mensagem mensagem)
			throws RemoteException {
		getInstanciaCliente(telefone).receberMensagem(mensagem);

	}

	@Override
	public void informarChamadaConfirmada(Telefone telefone)
			throws RemoteException {
		getInstanciaCliente(telefone).informarChamadaConfirmada();
	}

	@Override
	public void informarChamadaRejeitada(Telefone telefone)
			throws RemoteException {
		getInstanciaCliente(telefone).informarChamadaRejeitada();
	}

}
