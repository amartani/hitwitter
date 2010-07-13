package aifone.hitwitter.rn;

import java.rmi.RemoteException;
import java.util.List;

import aifone.hitwitter.AppHiTwitter;

import entidades.Requisicao;
import entidades.RespostaDeRequisicao;

public class Tunel {
	private HiTwitter hiTwitter;
	private AppHiTwitter appHiTwitter;
	
	public Tunel(HiTwitter hiTwitter, AppHiTwitter appHiTwitter) {
		super();
		this.appHiTwitter = appHiTwitter;
		this.hiTwitter = hiTwitter;
	}

	public List<Tweet> getTweetsFromRemote() throws RemoteException{
		Requisicao requisicao = new Requisicao(getHiTwitter().getLogin(), getHiTwitter().getSenha(), "GET", "/statuses/friends_timeline.xml");
		System.out.println(requisicao.getMethod());
		RespostaDeRequisicao resposta =  appHiTwitter.enviarRequisicaoViaTunel(requisicao);
		return resposta.toTweets();
	}
	
	public void sendTweet(String message) throws RemoteException{
		Requisicao requisicao = new Requisicao(getHiTwitter().getLogin(), getHiTwitter().getSenha(), "POST", "/statuses/update.xml");
		requisicao.addParam("status", message);
		RespostaDeRequisicao resposta = appHiTwitter.enviarRequisicaoViaTunel(requisicao);
		if(resposta.getCodigoDeStatus() == 300 || resposta.getCodigoDeStatus() == 200){
			System.out.println("Enviado tweet!");
		}else{
			System.out.println("ERRO "+resposta.getCodigoDeStatus()+": Tweet não enviado!");
		}
	}

	public HiTwitter getHiTwitter() {
		return hiTwitter;
	}
	
	
}
