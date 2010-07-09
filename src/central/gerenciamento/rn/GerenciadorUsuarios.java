package central.gerenciamento.rn;

import central.gerenciamento.ip.IIPConexao;
import central.gerenciamento.ip.IPConexaoMemoria;
import entidades.Telefone;

public class GerenciadorUsuarios {

	private IIPConexao ipconexao;
	
	public GerenciadorUsuarios() {
		ipconexao = new IPConexaoMemoria();
	}
	
	/**
	 * Conecta o telefone no sistema, registrando seu endereço RMI.
	 * 
	 * @param telefone Telefone a ser conectado
	 * @param enderecoRMI Endereço RMI do cliente
	 */
	public void conectarTelefone(Telefone telefone, String enderecoRMI) {
		ipconexao.inserir(telefone, enderecoRMI);
	}

	/**
	 * Desconecta o telefone do sistema
	 * 
	 * @param telefone Telefone a ser desconectado
	 */
	public void desconectarTelefone(Telefone telefone) {
		ipconexao.apagar(telefone);
	}
	
	/**
	 * Verifica se o telefone está ativo.
	 * 
	 * @param telefone Telefone a ser verificado
	 * @return True se o telefone está ativo
	 */
	public boolean verificarPermissao(Telefone telefone) {
		return false;
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
		return null;
	}
	
	/**
	 * Verifica se o telefone está conectado no sistema
	 * 
	 * @param telefone Telefone do cliente
	 * @return True se estiver conectado
	 */
	public boolean verificarConectado(Telefone telefone) {
		return false;
	}

	/**
	 * Adiciona telefone no sistema
	 * 
	 * @param telefone Telefone a ser adicionado
	 */
	public void adicionarTelefone(Telefone telefone) {
		
	}

	/**
	 * Remove telefone do sistema
	 * 
	 * @param telefone Telefone a ser removido
	 */
	public void removerTelefone(Telefone telefone) {
		
	}
}
