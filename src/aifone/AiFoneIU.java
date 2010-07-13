package aifone;

import aifone.hitwitter.iu.IULogin;
import aifone.iu.IUContainer;
import aifone.iu.IUTelaInicial;
import aifone.telefone.IAppTelefoneIU;
import entidades.Telefone;

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

	@Override
	public void abrirHiTwitter(){
		IUContainer container = IUContainer.getInstance();
		container.setPanel(new IULogin(this));
		container.setVisible(true);
	}
	
	private IAppTelefoneIU getAppTelefoneIU() {
		return aifone.getAppTelefoneIU();
	}

	@Override
	public Telefone getTelefone() {
		return aifone.getTelefone();
	}

}
