package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import aifone.hitwitter.Tweet;

@SuppressWarnings("serial")
public class RespostaDeRequisicao implements Serializable {
	String mensagemDeErro = "";
	int codigoDeStatus = 300;
	String conteudo = "";

	public RespostaDeRequisicao() {
		super();
	}
	
	public RespostaDeRequisicao(String mensagemDeErro, int codigoDeStatus, String conteudo) {
		super();
		this.mensagemDeErro = mensagemDeErro;
		this.codigoDeStatus = codigoDeStatus;
		this.conteudo = conteudo;
	}

	public List<Tweet> toTweets(){
		return new ArrayList<Tweet>();
	}
	
	public String getMensagemDeErro() {
		return mensagemDeErro;
	}

	public void setMensagemDeErro(String mensagemDeErro) {
		this.mensagemDeErro = mensagemDeErro;
	}

	public int getCodigoDeStatus() {
		return codigoDeStatus;
	}

	public void setCodigoDeStatus(int codigoDeStatus) {
		this.codigoDeStatus = codigoDeStatus;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
}