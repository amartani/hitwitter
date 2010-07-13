package aifone;

import aifone.hitwitter.iu.IUEnviarTweet;
import aifone.hitwitter.iu.IULerTweets;
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

	
	
	private IAppTelefoneIU getAppTelefoneIU() {
		return aifone.getAppTelefoneIU();
	}

	@Override
	public Telefone getTelefone() {
		return aifone.getTelefone();
	}

	private AiFone getAifone() {
		return aifone;
	}

	@Override
	public void abrirTelaLerTweets() {
		getAifone().getHitwitter().abrirTelaLerTweets();
	}
	
	@Override
	public void abrirHiTwitter(){
		getAifone().getHitwitter().abrirHiTwitter();
	}
	
	@Override
	public void abrirTelaEnviarTweet() {
		getAifone().getHitwitter().abrirTelaEnviarTweet();
	}

}
