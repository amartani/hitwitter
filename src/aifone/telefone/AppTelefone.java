package aifone.telefone;

import java.rmi.RemoteException;

import javax.swing.JPanel;

import aifone.IAiFoneSaida;
import aifone.telefone.iu.IUDiscar;
import aifone.telefone.rn.RNAppTelefone;
import entidades.Mensagem;
import entidades.Telefone;

public class AppTelefone implements IAppTelefone {

	private IAiFoneSaida aifone;
	private RNAppTelefone rnAppTelefone;

	public AppTelefone(IAiFoneSaida aifone) {
		this.aifone = aifone;
		this.rnAppTelefone = new RNAppTelefone(this);
	}

	@Override
	public void confirmarChamada(Telefone telefone) {
		// TODO Auto-generated method stub

	}

	@Override
	public void encerrarChamada() {
		// TODO Auto-generated method stub

	}

	@Override
	public void receberChamada(Telefone origem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void receberMensagem(Mensagem mensagem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void confirmarAtendimento() throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void efetuarChamada(Telefone destino) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void enviarMensagem(Mensagem mensagem) throws RemoteException {
		aifone.enviarMensagem(mensagem);

	}

	@Override
	public void informarChamadaEncerrada(Telefone telefone)
			throws RemoteException {
		aifone.informarChamadaEncerrada(telefone);

	}

	@Override
	public void informarChamadaRejeitada() throws RemoteException {
		aifone.informarChamadaRejeitada();

	}

	@Override
	public IUDiscar getIUDiscarInstance(JPanel telaRetorno) {
		return new IUDiscar(rnAppTelefone, telaRetorno);
	}

	@Override
	public void rejeitarChamada() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
