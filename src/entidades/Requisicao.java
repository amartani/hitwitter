package entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Requisicao implements Serializable {
	String login;
	String password;
	String method;
	String url;

	public Requisicao(	String login, String password, String method, String url) {
		super();
		this.login = login;
		this.password = password;
		this.method = method;
		this.url = url;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
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
