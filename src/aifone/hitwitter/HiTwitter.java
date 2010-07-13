package aifone.hitwitter;

import java.rmi.RemoteException;
import java.util.List;
import aifone.IAiFoneSaida;

public class HiTwitter implements IHiTwitter {

	private IAiFoneSaida aifone;
	private String login;
	private String senha;
	private Tunel tunel;

	public HiTwitter(IAiFoneSaida aifone) {
		this.aifone = aifone;
		this.tunel = new Tunel(this);
	}

	public List<Tweet> getTweets() throws RemoteException{
		return getTunel().getTweetsFromRemote();
	}

	public void sendTweet(String conteudo) throws RemoteException{
		getTunel().sendTweet(conteudo);
	}

	public Tunel getTunel() {
		return tunel;
	}
	
	public IAiFoneSaida getAifone(){
		return aifone;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
