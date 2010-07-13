package aifone.hitwitter;

import java.rmi.RemoteException;

import entidades.Requisicao;
import entidades.RespostaDeRequisicao;
import aifone.IAiFoneIU;
import aifone.IAiFoneSaida;
import aifone.hitwitter.iu.IUEnviarTweet;
import aifone.hitwitter.iu.IULerTweets;
import aifone.hitwitter.iu.IULogin;
import aifone.hitwitter.rn.HiTwitter;
import aifone.hitwitter.rn.Tunel;
import aifone.iu.IUContainer;

public class AppHiTwitter {
	private Tunel tunel;
	private HiTwitter hiTwitter;
	private IAiFoneSaida aifone;
	private IAiFoneIU aifoneiu;
		
	public AppHiTwitter(IAiFoneSaida aifone, IAiFoneIU aifoneiu){
		this.aifone = aifone;
		this.aifoneiu = aifoneiu;
		this.hiTwitter = new HiTwitter();
		this.tunel = new Tunel(hiTwitter, this);
		this.hiTwitter.setTunel(tunel);
	}
	
	public RespostaDeRequisicao enviarRequisicaoViaTunel(Requisicao requisicao) throws RemoteException{
		return aifone.enviarRequisicaoViaTunel(requisicao);
	}
	
	
	public void abrirTelaLerTweets() {
		IUContainer container = IUContainer.getInstance();
		container.setPanel(new IULerTweets(this, hiTwitter));
		container.setVisible(true);
	}
	
	
	public void abrirHiTwitter(){
		IUContainer container = IUContainer.getInstance();
		container.setPanel(new IULogin(this, hiTwitter));
		container.setVisible(true);
	}
	
	
	public void abrirTelaEnviarTweet() {
		IUContainer container = IUContainer.getInstance();
		container.setPanel(new IUEnviarTweet(this, hiTwitter));
		container.setVisible(true);
	}
	
	public void voltarTelaInicial() {
		aifoneiu.abrirTelaInicial();
	}
}
