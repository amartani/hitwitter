package aifone.hitwitter;

import java.rmi.RemoteException;
import java.util.List;

import entidades.Requisicao;
import entidades.RespostaDeRequisicao;

public class Tunel {
	private HiTwitter hiTwitter;
	
	public Tunel(HiTwitter hiTwitter) {
		super();
		this.hiTwitter = hiTwitter;
	}

	public List<Tweet> getTweetsFromRemote() throws RemoteException{
		Requisicao requisicao = new Requisicao(getHiTwitter().getLogin(), getHiTwitter().getSenha(), "GET", "/statuses/friends_timeline.xml");
		System.out.println(requisicao.getMethod());
		RespostaDeRequisicao resposta =  getHiTwitter().getAifone().enviarRequisicaoViaTunel(requisicao);
		return resposta.toTweets();
	}
	
	public void sendTweet(String message) throws RemoteException{
		Requisicao requisicao = new Requisicao(getHiTwitter().getLogin(), getHiTwitter().getSenha(), "POST", "/statuses/update.xml");
		requisicao.addParam("status", message);
		RespostaDeRequisicao resposta = getHiTwitter().getAifone().enviarRequisicaoViaTunel(requisicao);
		if(resposta.getCodigoDeStatus() == 300){
			System.out.println("Enviado tweet!");
		}else{
			System.out.println("ERRO "+resposta.getCodigoDeStatus()+": Tweet não enviado!");
		}
	}

	public HiTwitter getHiTwitter() {
		return hiTwitter;
	}
	
	
}
