package central.tunel;

import java.util.HashMap;

import entidades.Requisicao;
import entidades.Telefone;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tunel tunel = new Tunel();
		HashMap<String, String> params = new HashMap<String, String>();
		// Ler tweets
		Requisicao requisicao = new Requisicao("dalthon", "senha!", "GET", "/statuses/friends_timeline.xml", params);
		// Twittar!
		params.put("status", "POXA EH INCRIVEL COMO TWITTAR VIA UM PROGRAMINHA ESTUPIDO EM JAVA ENCHE O SACO!");
		requisicao = new Requisicao("dalthon", "senha!", "POST", "/statuses/update.xml", params);
		tunel.enviarRequisicao(new Telefone("99998888"), requisicao);
	}

}
