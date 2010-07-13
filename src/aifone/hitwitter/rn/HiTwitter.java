package aifone.hitwitter.rn;

import java.rmi.RemoteException;
import java.util.List;
import aifone.IAiFoneSaida;

public class HiTwitter implements IHiTwitter {

	private String login;
	private String senha;
	private Tunel tunel;

	public HiTwitter() {
	}
	
	public void setTunel(Tunel tunel) {
		this.tunel = tunel;
	}

	public List<Tweet> getTweets() throws RemoteException {
		return getTunel().getTweetsFromRemote();
	}

	public void sendTweet(String conteudo) throws RemoteException {
		getTunel().sendTweet(conteudo);
	}

	public Tunel getTunel() {
		return tunel;
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
