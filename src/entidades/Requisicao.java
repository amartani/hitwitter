package entidades;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class Requisicao implements Serializable {
	String login;
	String senha;
	String method;
	String url;
	Map<String, String> params = new HashMap<String, String>();

	public Requisicao(String login, String senha, String method, String url, Map<String, String> params) {
		super();
		this.login = login;
		this.senha = senha;
		this.method = method;
		this.url = url;
		this.params = params;
	}

	public Map<String, String> getParams() {
		return params;
	}
	
	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public String getMethod() {
		return method;
	}

	public String getUrl() {
		return url;
	}
	
	@Override
	public String toString() {
		return getMethod() + " " + getUrl();
	}
}
