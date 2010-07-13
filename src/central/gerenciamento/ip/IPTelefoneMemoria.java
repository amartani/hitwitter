package central.gerenciamento.ip;

import java.util.HashSet;
import java.util.Set;

import entidades.Telefone;

public class IPTelefoneMemoria implements IIPTelefone {

	private Set<Telefone> banco;

	public IPTelefoneMemoria() {
		banco = new HashSet<Telefone>();
	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.ip.IIPTelefone#inserir(entidades.Telefone)
	 */
	@Override
	public void inserir(Telefone telefone) {
		banco.add(telefone);
	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.ip.IIPTelefone#procurar(entidades.Telefone)
	 */
	@Override
	public boolean procurar(Telefone telefone) {
		return banco.contains(telefone);
	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.ip.IIPTelefone#apagar(entidades.Telefone)
	 */
	@Override
	public void apagar(Telefone telefone) {
		banco.remove(telefone);
	}

}
