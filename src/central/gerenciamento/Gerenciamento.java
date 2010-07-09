package central.gerenciamento;

import central.gerenciamento.rn.GerenciadorUsuarios;
import entidades.Telefone;

public class Gerenciamento implements IGerenciamento {
	
	private GerenciadorUsuarios gerenciadorUsuarios;

	public Gerenciamento() {
		gerenciadorUsuarios = new GerenciadorUsuarios();
	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.IGerenciamento#conectarTelefone(entidades.Telefone, java.lang.String)
	 */
	@Override
	public void conectarTelefone(Telefone telefone, String enderecoRMI) {
		gerenciadorUsuarios.conectarTelefone(telefone, enderecoRMI);
	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.IGerenciamento#desconectarTelefone(entidades.Telefone)
	 */
	@Override
	public void desconectarTelefone(Telefone telefone) {
		gerenciadorUsuarios.desconectarTelefone(telefone);
	}
	
	/* (non-Javadoc)
	 * @see central.gerenciamento.IGerenciamento#verificarPermissao(entidades.Telefone)
	 */
	@Override
	public boolean verificarPermissao(Telefone telefone) {
		return gerenciadorUsuarios.verificarPermissao(telefone);
	}
	
	/* (non-Javadoc)
	 * @see central.gerenciamento.IGerenciamento#enderecoRMIDoCliente(entidades.Telefone)
	 */
	@Override
	public String enderecoRMIDoCliente(Telefone telefone) {
		return gerenciadorUsuarios.enderecoRMIDoCliente(telefone);
	}
	
	/* (non-Javadoc)
	 * @see central.gerenciamento.IGerenciamento#verificarConectado(entidades.Telefone)
	 */
	@Override
	public boolean verificarConectado(Telefone telefone) {
		return gerenciadorUsuarios.verificarConectado(telefone);
	}
}
