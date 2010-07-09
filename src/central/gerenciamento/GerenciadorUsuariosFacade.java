package central.gerenciamento;

import central.gerenciamento.rn.GerenciadorUsuarios;
import entidades.Telefone;

public class GerenciadorUsuariosFacade {
	
	private GerenciadorUsuarios gerenciadorUsuarios;

	public GerenciadorUsuariosFacade() {
		gerenciadorUsuarios = new GerenciadorUsuarios();
	}

	public void conectarTelefone(Telefone telefone, String enderecoRMI) {
		gerenciadorUsuarios.conectarTelefone(telefone, enderecoRMI);
	}

	public void desconectarTelefone(Telefone telefone) {
		gerenciadorUsuarios.desconectarTelefone(telefone);
	}

	public void verificarPermissao(Telefone telefone) {
		gerenciadorUsuarios.verificarPermissao(telefone);
	}
}
