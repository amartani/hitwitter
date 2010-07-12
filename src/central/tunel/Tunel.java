package central.tunel;

import java.io.IOException;
import java.util.Iterator;
import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import entidades.Requisicao;
import entidades.RespostaDeRequisicao;
import entidades.Telefone;

public class Tunel implements ITunel {

	@Override
	public RespostaDeRequisicao enviarRequisicao(Telefone origem, Requisicao requisicao) {
		if(requisicao.getMethod() == "GET")
			return executarMetodoGet(requisicao);
		else
			return executarMetodoPost(requisicao);
	}

	private void executarMetodoHTTP(HttpMethodBase method, Requisicao requisicao) throws NullPointerException, HttpException, IOException {
		HttpClient client = new HttpClient(); 
		Credentials credentials = new UsernamePasswordCredentials(requisicao.getLogin(), requisicao.getSenha());
		client.getState().setCredentials(new AuthScope(requisicao.getUrl(), 80, AuthScope.ANY_REALM), credentials);
		HostConfiguration host = client.getHostConfiguration();
		host.setHost(new URI("http://"+requisicao.getUrl(), true));
		client.executeMethod(host, method);
		System.out.println(method.getResponseBody());
	}

	private NameValuePair[] construirParametros(Requisicao requisicao){
		NameValuePair params[] = new NameValuePair[requisicao.getParams().size()];
		Iterator<String> iterator = requisicao.getParams().keySet().iterator();
		int params_count = 0;
		while(iterator.hasNext()){
			params[0] = new NameValuePair(iterator.next(), requisicao.getParams().get(iterator.next()));
			params_count++;
		}
		return params;
	}
	
	private RespostaDeRequisicao executarMetodoPost(Requisicao requisicao){
		RespostaDeRequisicao resposta = new RespostaDeRequisicao();
		PostMethod post = new PostMethod(requisicao.getUrl());
		NameValuePair params[] = construirParametros(requisicao);
		post.setRequestBody(params);
		try {
			executarMetodoHTTP(post, requisicao);
			resposta.setCodigoDeStatus(post.getStatusCode());
			resposta.setConteudo(post.getResponseBodyAsString());
		} catch (URIException e) {
			resposta.setMensagemDeErro(e.getMessage());
		} catch (NullPointerException e) {
			resposta.setMensagemDeErro(e.getMessage());
		} catch (IOException e) {
			resposta.setMensagemDeErro(e.getMessage());
		} finally {
			post.releaseConnection();
		}
		return resposta;
	}
	
	private RespostaDeRequisicao executarMetodoGet(Requisicao requisicao){
		RespostaDeRequisicao resposta = new RespostaDeRequisicao();
		GetMethod get = new GetMethod(requisicao.getUrl());
		try {
			executarMetodoHTTP(get, requisicao);
			resposta.setCodigoDeStatus(get.getStatusCode());
			resposta.setConteudo(get.getResponseBodyAsString());
		} catch (URIException e) {
			resposta.setMensagemDeErro(e.getMessage());
		} catch (NullPointerException e) {
			resposta.setMensagemDeErro(e.getMessage());
		} catch (IOException e) {
			resposta.setMensagemDeErro(e.getMessage());
		} finally {
			get.releaseConnection();
		}
		return resposta;
	}
}
