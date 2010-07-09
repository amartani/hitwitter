package central.gerenciamento;

import central.gerenciamento.rn.GerenciadorUsuarios;
import entidades.Telefone;

public class GerenciadorUsuariosFacade {
	
	private GerenciadorUsuarios gerenciadorUsuarios;

	public GerenciadorUsuariosFacade() {
		gerenciadorUsuarios = new GerenciadorUsuarios();
	}

	/**
	 * Conecta o telefone no sistema, registrando seu endereço RMI.
	 * 
	 * @param telefone Telefone a ser conectado
	 * @param enderecoRMI Endereço RMI do cliente
	 */
	public void conectarTelefone(Telefone telefone, String enderecoRMI) {
		gerenciadorUsuarios.conectarTelefone(telefone, enderecoRMI);
	}

	/**
	 * Desconecta o telefone do sistema
	 * 
	 * @param telefone Telefone a ser desconectado
	 */
	public void desconectarTelefone(Telefone telefone) {
		gerenciadorUsuarios.desconectarTelefone(telefone);
	}
	
	/**
	 * Verifica se o telefone está ativo.
	 * 
	 * @param telefone Telefone a ser verificado
	 * @return True se o telefone está ativo
	 */
	public boolean verificarPermissao(Telefone telefone) {
		return gerenciadorUsuarios.verificarPermissao(telefone);
	}
	
	/**
	 * Obtem o endereço RMI do cliente
	 * 
	 * Pré-condição: verificarConectado(telefone)
	 * 
	 * @param telefone Telefone do cliente
	 * @return Endereco RMI correspondente ao cliente
	 */
	public String enderecoRMIDoCliente(Telefone telefone) {
		return gerenciadorUsuarios.enderecoRMIDoCliente(telefone);
	}
	
	/**
	 * Verifica se o telefone está conectado no sistema
	 * 
	 * @param telefone Telefone do cliente
	 * @return True se estiver conectado
	 */
	public boolean verificarConectado(Telefone telefone) {
		return gerenciadorUsuarios.verificarConectado(telefone);
	}
}
