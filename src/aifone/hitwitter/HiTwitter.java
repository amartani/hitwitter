package aifone.hitwitter;

import java.rmi.RemoteException;
import entidades.Requisicao;
import entidades.RespostaDeRequisicao;

import aifone.IAiFoneSaida;

public class HiTwitter implements IHiTwitter {

	private IAiFoneSaida aifone;
	private String login;
	private String senha;

	public HiTwitter(IAiFoneSaida aifone) {
		this.aifone = aifone;
	}

	public void getTweetsFromRemote() throws RemoteException{
		Requisicao requisicao = new Requisicao(getLogin(), getSenha(), "GET", "/statuses/friends_timeline.xml");
		RespostaDeRequisicao resposta = aifone.enviarRequisicaoViaTunel(requisicao);
		setTweets(resposta);
	}
	
	public void sendTweet(String message) throws RemoteException{
		Requisicao requisicao = new Requisicao(getLogin(), getSenha(), "POST", "/statuses/friends_timeline.xml");
		requisicao.addParam("status", message);
		RespostaDeRequisicao resposta = aifone.enviarRequisicaoViaTunel(requisicao);
		if(resposta.getCodigoDeStatus() == 300){
			System.out.println("Worked!");
		}else{
			System.out.println("Fodeu!");
		}
			
	}
	
	private void setTweets(RespostaDeRequisicao resposta){
		
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
