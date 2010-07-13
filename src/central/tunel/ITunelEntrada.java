package central.tunel;

import entidades.Requisicao;
import entidades.RespostaDeRequisicao;
import entidades.Telefone;

public interface ITunelEntrada {

	public RespostaDeRequisicao enviarRequisicao(Telefone origem,
			Requisicao requisicao);

}