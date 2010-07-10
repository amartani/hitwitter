package central.telefone;

import central.Central;
import central.telefone.rn.GerenciadorChamadas;
import entidades.Mensagem;
import entidades.Telefone;

public class CentralTelefonica implements ICentralTelefonica {
	
	private GerenciadorChamadas gerenciadorChamadas;	

	public CentralTelefonica(Central central) {
		this.gerenciadorChamadas = new GerenciadorChamadas(central);
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

}
