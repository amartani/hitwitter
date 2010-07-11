package central.gerenciamento.rn;

import central.gerenciamento.ip.IIPConexao;
import central.gerenciamento.ip.IIPTelefone;
import central.gerenciamento.ip.IPConexaoMemoria;
import central.gerenciamento.ip.IPTelefoneSerializado;
import entidades.Telefone;

public class GerenciadorUsuarios implements IGerenciadorUsuarios {

	private IIPConexao ipconexao;
	private IIPTelefone iptelefone;

	public GerenciadorUsuarios() {
		ipconexao = new IPConexaoMemoria();
		iptelefone = new IPTelefoneSerializado();
	}

	public GerenciadorUsuarios(IIPTelefone iptelefone, IIPConexao ipconexao) {
		this.iptelefone = iptelefone;
		this.ipconexao = ipconexao;
	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.rn.IGerenciadorUsuarios#conectarTelefone(entidades.Telefone, java.lang.String)
	 */
	@Override
	public void conectarTelefone(Telefone telefone, String enderecoRMI) {
		if (verificarPermissao(telefone)) {
			ipconexao.inserir(telefone, enderecoRMI);
		} else {
			// TODO: criar exception
			throw new RuntimeException("Telefone nao cadastrado: "
					+ telefone.getNumero());
		}
	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.rn.IGerenciadorUsuarios#desconectarTelefone(entidades.Telefone)
	 */
	@Override
	public void desconectarTelefone(Telefone telefone) {
		ipconexao.apagar(telefone);
	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.rn.IGerenciadorUsuarios#verificarPermissao(entidades.Telefone)
	 */
	@Override
	public boolean verificarPermissao(Telefone telefone) {
		return iptelefone.procurar(telefone);
	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.rn.IGerenciadorUsuarios#enderecoRMIDoCliente(entidades.Telefone)
	 */
	@Override
	public String enderecoRMIDoCliente(Telefone telefone) {
		return ipconexao.procurar(telefone);
	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.rn.IGerenciadorUsuarios#verificarConectado(entidades.Telefone)
	 */
	@Override
	public boolean verificarConectado(Telefone telefone) {
		if (ipconexao.procurar(telefone) != null) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.rn.IGerenciadorUsuarios#adicionarTelefone(entidades.Telefone)
	 */
	@Override
	public void adicionarTelefone(Telefone telefone) {
		iptelefone.inserir(telefone);
	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.rn.IGerenciadorUsuarios#removerTelefone(entidades.Telefone)
	 */
	@Override
	public void removerTelefone(Telefone telefone) {
		iptelefone.apagar(telefone);
	}
}
