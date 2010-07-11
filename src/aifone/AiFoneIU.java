package aifone;

import java.rmi.RemoteException;

import aifone.iu.IUContainer;
import aifone.iu.IUTelaInicial;
import aifone.telefone.IAppTelefoneIU;

public class AiFoneIU implements IAiFoneIU {
	private AiFone aifone;

	public AiFoneIU(AiFone aifone) {
		super();
		this.aifone = aifone;
	}

	@Override
	public void abrirTelaInicial() {
		IUContainer container = IUContainer.getInstance();
		container.setPanel(new IUTelaInicial(this));
		container.setVisible(true);
	}

	@Override
	public void abrirTelaTelefone() {
		getAppTelefoneIU().abrirTelaDiscar();
	}
	
	private IAppTelefoneIU getAppTelefoneIU() {
		return aifone.getAppTelefoneIU();
	}

}
