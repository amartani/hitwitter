package central.gerenciamento.ip;

import entidades.Telefone;

public class IPConexaoMemoria implements IIPConexao {

	/* (non-Javadoc)
	 * @see central.gerenciamento.ip.IIPConexao#inserir(entidades.Telefone, java.lang.String)
	 */
	@Override
	public void inserir(Telefone telefone, String enderecoRMI) {

	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.ip.IIPConexao#procurar(entidades.Telefone)
	 */
	@Override
	public String procurar(Telefone telefone) {
		return null;
	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.ip.IIPConexao#apagar(entidades.Telefone)
	 */
	@Override
	public void apagar(Telefone telefone) {

	}

}
