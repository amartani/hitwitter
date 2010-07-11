package aifone.telefone;

import java.rmi.RemoteException;

import javax.swing.JPanel;

import aifone.IAiFoneSaida;
import aifone.iu.IUContainer;
import aifone.iu.IUTelaInicial;
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
	public void informarAtendimentoConfirmado(Telefone telefone) {
		rnAppTelefone.confirmarChamada(telefone);

	}

	@Override
	public void informarChamadaEncerrada() {
		rnAppTelefone.encerrarChamada();

	}

	@Override
	public void receberChamada(Telefone origem) {
		rnAppTelefone.receberChamada(origem);

	}

	@Override
	public void receberMensagem(Mensagem mensagem) {
		rnAppTelefone.receberMensagem(mensagem);

	}

	@Override
	public void confirmarAtendimento() throws RemoteException {
		aifone.confirmarAtendimento();

	}

	@Override
	public void efetuarChamada(Telefone destino) throws RemoteException {
		aifone.efetuarChamada(destino);

	}

	@Override
	public void enviarMensagem(Mensagem mensagem) throws RemoteException {
		aifone.enviarMensagem(mensagem);

	}

	@Override
	public void encerrarChamada() throws RemoteException {
		aifone.encerrarChamada();

	}

	@Override
	public void rejeitarChamada() throws RemoteException {
		aifone.rejeitarChamada();

	}

	@Override
	public IUDiscar getIUDiscarInstance(JPanel telaRetorno) {
		return new IUDiscar(rnAppTelefone, telaRetorno);
	}

	@Override
	public IUContainer getIUContainerInstance() {
		return IUContainer.getInstance();
	}

	@Override
	public void informarChamadaRejeitada() {
		// TODO Auto-generated method stub

	}
}
