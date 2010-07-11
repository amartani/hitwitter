package central.gerenciamento.ip;

import java.util.HashMap;
import java.util.Map;

import entidades.Telefone;

public class IPConexaoMemoria implements IIPConexao {
	
	private Map<Telefone, String> banco;

	public IPConexaoMemoria() {
		banco = new HashMap<Telefone, String>();
	}
	
	/* (non-Javadoc)
	 * @see central.gerenciamento.ip.IIPConexao#inserir(entidades.Telefone, java.lang.String)
	 */
	@Override
	public void inserir(Telefone telefone, String enderecoRMI) {
		banco.put(telefone, enderecoRMI);
	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.ip.IIPConexao#procurar(entidades.Telefone)
	 */
	@Override
	public String procurar(Telefone telefone) {
		return banco.get(telefone);
	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.ip.IIPConexao#apagar(entidades.Telefone)
	 */
	@Override
	public void apagar(Telefone telefone) {
		banco.remove(telefone);
	}

}
