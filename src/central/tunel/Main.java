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
		Requisicao requisicao = new Requisicao("dalthon", "TWITTER3fqfgr", "GET", "/statuses/friends_timeline.xml");
		tunel.enviarRequisicao(new Telefone("99997777"), requisicao);
		// Twittar!
		requisicao = new Requisicao("dalthon", "TWITTER3fqfgr", "POST", "/statuses/update.xml");
		requisicao.addParam("status", "Ta começando a funcionar essa merda!");
		tunel.enviarRequisicao(new Telefone("99998888"), requisicao);
	}

}
