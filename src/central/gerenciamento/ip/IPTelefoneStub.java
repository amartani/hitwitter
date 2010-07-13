package central.gerenciamento.ip;

import entidades.Telefone;

public class IPTelefoneStub implements IIPTelefone {

	@Override
	public void inserir(Telefone telefone) {
	}

	@Override
	public boolean procurar(Telefone telefone) {
		return true;
	}

	@Override
	public void apagar(Telefone telefone) {
	}

}
