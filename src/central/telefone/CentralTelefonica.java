package central.telefone;

import java.rmi.RemoteException;

import central.ICentralSaida;
import central.gerenciamento.IGerenciamentoEntrada;
import central.telefone.rn.GerenciadorChamadas;
import entidades.Mensagem;
import entidades.Telefone;

public class CentralTelefonica implements ICentralTelefonica {
	
	private GerenciadorChamadas gerenciadorChamadas;
	private IGerenciamentoEntrada gerenciamento;
	private ICentralSaida central;

	public CentralTelefonica(ICentralSaida central, IGerenciamentoEntrada gerenciamento) {
		this.gerenciadorChamadas = new GerenciadorChamadas(this);
		this.central = central;
		this.gerenciamento = gerenciamento;
	}

	@Override
	public void efetuarChamada(Telefone origem, Telefone destino) {
		gerenciadorChamadas.efetuarChamada(origem, destino);
		
	}

	@Override
	public void informarChamadaEncerrada(Telefone telefone) {
		gerenciadorChamadas.informarChamadaEncerrada(telefone);
		
	}

	@Override
	public void informarChamadaRejeitada(Telefone telefone) {
		gerenciadorChamadas.informarChamadaRejeitada(telefone);
		
	}

	@Override
	public void confirmarAtendimento(Telefone telefone) {
		gerenciadorChamadas.confirmarAtendimento(telefone);
		
	}

	@Override
	public void enviarMensagem(Telefone origem, Mensagem mensagem) {
		gerenciadorChamadas.enviarMensagem(origem, mensagem);
		
	}

	@Override
	public void confirmarChamada(Telefone telefone) throws RemoteException {
		central.confirmarChamada(telefone);
		
	}

	@Override
	public void encerrarChamada(Telefone telefone) throws RemoteException {
		central.encerrarChamada(telefone);
		
	}

	@Override
	public void enviarMensagemParaCliente(Telefone telefone, Mensagem mensagem)
			throws RemoteException {
		central.enviarMensagemParaCliente(telefone, mensagem);
		
	}

	@Override
	public void enviarPedidoChamada(Telefone origem, Telefone destino)
			throws RemoteException {
		central.enviarPedidoChamada(origem, destino);
		
	}

	@Override
	public boolean verificarConectado(Telefone telefone) {
		return gerenciamento.verificarConectado(telefone);
	}

	@Override
	public void rejeitarChamada(Telefone telefone) throws RemoteException {
		central.rejeitarChamada(telefone);
	}

}
