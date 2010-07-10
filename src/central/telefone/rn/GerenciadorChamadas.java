package central.telefone.rn;

import central.Central;
import central.telefone.ip.IIPChamada;
import central.telefone.ip.IIPPedidoChamada;
import central.telefone.ip.IPChamadaMemoria;
import central.telefone.ip.IPPedidoMemoria;
import entidades.Mensagem;
import entidades.Telefone;

public class GerenciadorChamadas {
	
	private Central central;
	private IIPChamada ipchamada;
	private IIPPedidoChamada ippedido;
	
	public GerenciadorChamadas(Central central) {
		this.central = central;
		this.ipchamada = new IPChamadaMemoria();
		this.ippedido = new IPPedidoMemoria();
	}

	public void confirmarAtendimento(Telefone telefone) {
		Telefone origem = ippedido.procurar(telefone);
		if(origem != null){
			ipchamada.inserir(origem, telefone);
			ipchamada.inserir(telefone, origem);
			ippedido.apagar(telefone);
			ippedido.apagar(origem);
			try {
				central.confirmarChamada(telefone);
			} catch(Exception e){
				System.out.println("Nao foi possivel confirmar chamada. Excecao: ");
				e.printStackTrace();
				ipchamada.apagar(telefone);
				ipchamada.apagar(origem);
			}
			try {
				central.confirmarChamada(origem);
			} catch(Exception e){
				System.out.println("Nao foi possivel confirmar chamada. Excecao: ");
				e.printStackTrace();
				ipchamada.apagar(telefone);
				ipchamada.apagar(origem);
				
			}			
			
		}
		else throw new RuntimeException("Telefone nao esta sendo chamado.");
		
	}

	public void efetuarChamada(Telefone origem, Telefone destino) {
		System.out.println("Gerenciador de Chamadas: pedido de chamada recebido");
		if(ippedido.procurar(destino) == null &&
				ipchamada.procurar(destino) == null){
			
			ippedido.inserir(origem, destino);
			ippedido.inserir(destino, origem);
			
			try {
				central.enviarPedidoChamada(origem, destino);
			} catch(Exception e){
				ippedido.apagar(origem);
				ippedido.apagar(destino);
				System.out.println("Nao foi possivel efetuar chamada. Excecao: ");
				e.printStackTrace();
			}
		}
		else{
			try {
				central.encerrarChamada(origem);
			} catch(Exception e){
				System.out.println("Nao foi possivel encerrar o pedido de chamada. Excecao: ");
				e.printStackTrace();
			}
		}
		
	}

	public void enviarMensagem(Telefone origem, Mensagem mensagem) {
		Telefone destino = ipchamada.procurar(origem);
		if(destino != null){
			try {
				central.enviarMensagemSaida(destino, mensagem);
			} catch(Exception e) {
				System.out.println("Nao foi possivel enviar mensagem. Excecao: ");
				e.printStackTrace();
			}
		}
		
	}

	public void informarChamadaEncerrada(Telefone telefone) {
		Telefone destino = ipchamada.procurar(telefone);
		if(destino != null){
			central.informarChamadaEncerrada(destino);
			ipchamada.apagar(telefone);
			ipchamada.apagar(destino);
		}
		
	}

	public void informarChamadaRejeitada(Telefone telefone) {
		Telefone origem = ippedido.procurar(telefone);
		if(origem != null){
			central.informarChamadaRejeitada(origem);
			ippedido.apagar(telefone);
			ippedido.apagar(origem);
		}
		
	}
}
