package central.telefone.rn;

import java.rmi.RemoteException;

import central.telefone.ICentralTelefonicaSaida;
import central.telefone.ip.IIPChamada;
import central.telefone.ip.IIPPedidoChamada;
import central.telefone.ip.IPChamadaMemoria;
import central.telefone.ip.IPPedidoMemoria;
import entidades.Mensagem;
import entidades.Telefone;

public class GerenciadorChamadas {

	private ICentralTelefonicaSaida centralTelefonica;
	private IIPChamada ipchamada;
	private IIPPedidoChamada ippedido;

	public GerenciadorChamadas(ICentralTelefonicaSaida centralTelefonica) {
		this.centralTelefonica = centralTelefonica;
		this.ipchamada = new IPChamadaMemoria();
		this.ippedido = new IPPedidoMemoria();
	}

	public GerenciadorChamadas(ICentralTelefonicaSaida centralTelefonica,
			IIPChamada ipchamada, IIPPedidoChamada ippedido) {
		this.centralTelefonica = centralTelefonica;
		this.ipchamada = ipchamada;
		this.ippedido = ippedido;
	}

	public void confirmarAtendimento(Telefone telefone) {
		System.out.println("Gerenciador de Chamadas: atendimento confirmado");
		Telefone origem = ippedido.procurar(telefone);
		if (origem != null) {
			ipchamada.inserir(origem, telefone);
			ipchamada.inserir(telefone, origem);
			ippedido.apagar(telefone);
			ippedido.apagar(origem);
			try {
				centralTelefonica.informarChamadaConfirmada(origem);
			} catch (RemoteException e) {
				System.out
						.println("Nao foi possivel confirmar chamada. Excecao: ");
				e.printStackTrace();
				ipchamada.apagar(telefone);
				ipchamada.apagar(origem);
			}
			try {
				centralTelefonica.informarChamadaConfirmada(origem);
			} catch (RemoteException e) {
				System.out
						.println("Nao foi possivel confirmar chamada. Excecao: ");
				e.printStackTrace();
				ipchamada.apagar(telefone);
				ipchamada.apagar(origem);

			}

		} else
			throw new RuntimeException("Telefone nao esta sendo chamado.");

	}

	public void efetuarChamada(Telefone origem, Telefone destino) {
		System.out.println("Gerenciador de Chamadas: "
				+ origem.getNumero().toString() + " chamando "
				+ destino.getNumero().toString());

		if (ippedido.procurar(destino) == null
				&& ipchamada.procurar(destino) == null
				&& verificarConectado(destino) == true
				&& !destino.equals(origem)) {

			ippedido.inserir(origem, destino);
			ippedido.inserir(destino, origem);

			try {
				System.out.println("Gerenciador de Chamadas: ok, chamando destino...");
				centralTelefonica.receberChamada(origem, destino);
			} catch (RemoteException e) {
				ippedido.apagar(origem);
				ippedido.apagar(destino);
				try {
					centralTelefonica.informarChamadaRejeitada(origem);
				} catch (RemoteException e1) {
					System.out
							.println("Problema de conexao, nao foi possivel informar chamada rejeitada");
					e1.printStackTrace();
				}
				System.out
						.println("Nao foi possivel efetuar chamada. Excecao: ");
				e.printStackTrace();
			}
		} else {
			try {
				centralTelefonica.informarChamadaRejeitada(origem);
			} catch (RemoteException e) {
				System.out
						.println("Nao foi possivel encerrar o pedido de chamada. Excecao: ");
				e.printStackTrace();
			}
		}

	}

	public void enviarMensagem(Telefone origem, Mensagem mensagem) {
		Telefone destino = ipchamada.procurar(origem);
		if (destino != null) {
			try {
				centralTelefonica.receberMensagem(destino, mensagem);
			} catch (RemoteException e) {
				System.out
						.println("Nao foi possivel enviar mensagem. Excecao: ");
				e.printStackTrace();
				try {
					centralTelefonica.informarChamadaEncerrada(origem);
				} catch (RemoteException e1) {
					System.out
							.println("Nao foi possivel informar chamada encerrada. Excecao: ");
					e1.printStackTrace();
				}
			}
		}

	}

	public void informarChamadaEncerrada(Telefone telefone) {
		System.out
				.println("Gerenciador de Chamadas: informar chamada encerrada");
		Telefone destino = ipchamada.procurar(telefone);
		if (destino != null) {
			try {
				centralTelefonica.informarChamadaEncerrada(destino);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ipchamada.apagar(telefone);
			ipchamada.apagar(destino);
		}

	}

	public void informarChamadaRejeitada(Telefone telefone) {
		System.out
				.println("Gerenciador de Chamadas: informar chamada rejeitada");
		Telefone origem = ippedido.procurar(telefone);
		if (origem != null) {
			try {
				centralTelefonica.informarChamadaRejeitada(origem);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ippedido.apagar(telefone);
			ippedido.apagar(origem);
		}

	}

	private boolean verificarConectado(Telefone telefone) {
		return centralTelefonica.verificarConectado(telefone);
	}
}
