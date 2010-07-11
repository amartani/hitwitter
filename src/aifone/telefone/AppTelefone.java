package aifone.telefone;

import java.rmi.RemoteException;

import aifone.IAiFone;
import aifone.iu.IUContainer;
import aifone.telefone.iu.IUConversa;
import aifone.telefone.iu.IUDiscar;
import aifone.telefone.iu.IUEfetuandoChamada;
import aifone.telefone.iu.IURecebimentoDeChamada;
import aifone.telefone.rn.RNAppTelefone;
import entidades.Mensagem;
import entidades.Telefone;

public class AppTelefone implements IAppTelefone {

	private IAiFone aifone;
	private RNAppTelefone rnAppTelefone;
        private Telefone telefone;

	public AppTelefone(IAiFone aifone, Telefone telefone) {
		this.aifone = aifone;
		this.rnAppTelefone = new RNAppTelefone(this);
                this.telefone = telefone;
	}

    public Telefone getTelefone() {
        return telefone;
    }
	


	protected RNAppTelefone getRnAppTelefone(){
		return rnAppTelefone;
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
	public void rejeitarChamada() throws RemoteException {
		// TODO Auto-generated method stub
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
		IUContainer.getInstance().setPanel(new IUEfetuandoChamada(this, rnAppTelefone));
		
	}

	@Override
	public void abrirTelaInicial() {
		try {
			aifone.abrirTelaInicial();		
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void abrirTelaRecebimentoDeChamada() {
		IUContainer.getInstance().setPanel(new IURecebimentoDeChamada(this, rnAppTelefone));
		
	}

	@Override
	public void informarAtendimentoConfirmado(Telefone telefone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void informarChamadaEncerrada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void informarChamadaRejeitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void encerrarChamada() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
