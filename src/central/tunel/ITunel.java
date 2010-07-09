package central.tunel;

import entidades.Requisicao;
import entidades.RespostaDeRequisicao;
import entidades.Telefone;

public interface ITunel {
	abstract public RespostaDeRequisicao enviarRequisicao(Telefone origem, Requisicao requisicao);
}
