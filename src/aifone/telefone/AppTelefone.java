package aifone.telefone;

import java.rmi.RemoteException;

import aifone.IAiFoneIU;
import aifone.iu.IUContainer;
import aifone.telefone.iu.IUConversa;
import aifone.telefone.iu.IUDiscar;
import aifone.telefone.iu.IUEfetuandoChamada;
import aifone.telefone.iu.IURecebimentoDeChamada;
import aifone.telefone.rn.RNAppTelefone;
import entidades.Mensagem;
import entidades.Telefone;

public class AppTelefone implements IAppTelefone {

	private IAppTelefoneSaida aifonesaida;
	private IAiFoneIU aifoneiu;
	private RNAppTelefone rnAppTelefone;
	private Telefone telefone;

	public AppTelefone(IAppTelefoneSaida aifone, IAiFoneIU aifoneiu,
			Telefone telefone) {
		this.aifonesaida = aifone;
		this.aifoneiu = aifoneiu;
		this.telefone = telefone;
		this.rnAppTelefone = new RNAppTelefone(this);

	}

	protected RNAppTelefone getRnAppTelefone() {
		return rnAppTelefone;
	}

	/*
	 * Entrada
	 */

	@Override
	public void receberChamada(Telefone origem) {
		rnAppTelefone.receberChamada(origem);

	}

	@Override
	public void receberMensagem(Mensagem mensagem) {
		rnAppTelefone.receberMensagem(mensagem);

	}

	@Override
	public void informarAtendimentoConfirmado() {
		rnAppTelefone.informarAtendimentoConfirmado();

	}

	@Override
	public void informarChamadaEncerrada() {
		rnAppTelefone.informarChamadaEncerrada();

	}

	@Override
	public void informarChamadaRejeitada() {
		rnAppTelefone.informarChamadaRejeitada();

	}

	/*
	 * Saida
	 */

	@Override
	public void confirmarAtendimento() throws RemoteException {
		aifonesaida.confirmarAtendimento();

	}

	@Override
	public void efetuarChamada(Telefone destino) throws RemoteException {
		aifonesaida.efetuarChamada(destino);

	}

	@Override
	public void enviarMensagem(Mensagem mensagem) throws RemoteException {
		aifonesaida.enviarMensagem(mensagem);

	}

	@Override
	public void rejeitarChamada() throws RemoteException {
		aifonesaida.rejeitarChamada();
	}

	@Override
	public void encerrarChamada() throws RemoteException {
		aifonesaida.encerrarChamada();

	}

	/*
	 * Telas
	 */
	@Override
	public void abrirTelaConversa() {
		IUContainer.getInstance().setPanel(new IUConversa(this, rnAppTelefone));

	}

	@Override
	public void abrirTelaDiscar() {
		IUContainer.getInstance().setPanel(new IUDiscar(this, rnAppTelefone));

	}

	@Override
	public void abrirTelaEfetuandoChamada() {
		IUContainer.getInstance().setPanel(
				new IUEfetuandoChamada(this, rnAppTelefone));

	}

	@Override
	public void abrirTelaInicial() {
		aifoneiu.abrirTelaInicial();
		/*try {
			aifoneiu.abrirTelaInicial();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	@Override
	public void abrirTelaRecebimentoDeChamada() {
		System.out.println("Abrir tela recebimento");
		IUContainer.getInstance().setPanel(
				new IURecebimentoDeChamada(this, rnAppTelefone));

	}

	@Override
	public Telefone getTelefone() {
		return telefone;
	}


}
