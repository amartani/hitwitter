package central.tunel;

import entidades.Requisicao;
import entidades.Telefone;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tunel tunel = new Tunel();
		// Ler tweets
		Requisicao requisicao = new Requisicao("dalthon", "senha!", "GET", "/statuses/friends_timeline.xml");
		// Twittar!
		requisicao = new Requisicao("dalthon", "senha!", "POST", "/statuses/update.xml");
		requisicao.addParam("status", "POXA EH INCRIVEL COMO TWITTAR VIA UM PROGRAMINHA ESTUPIDO EM JAVA ENCHE O SACO!");
		tunel.enviarRequisicao(new Telefone("99998888"), requisicao);
	}

}
