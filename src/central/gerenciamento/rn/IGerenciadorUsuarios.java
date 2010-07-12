package central.gerenciamento.rn;

import entidades.Telefone;

public interface IGerenciadorUsuarios {

	/**
	 * Conecta o telefone no sistema, registrando seu endereço RMI.
	 * 
	 * @param telefone
	 *            Telefone a ser conectado
	 * @param enderecoRMI
	 *            Endereço RMI do cliente
	 */
	public abstract void conectarTelefone(Telefone telefone, String enderecoRMI);

	/**
	 * Desconecta o telefone do sistema
	 * 
	 * @param telefone
	 *            Telefone a ser desconectado
	 */
	public abstract void desconectarTelefone(Telefone telefone);

	/**
	 * Verifica se o telefone está ativo.
	 * 
	 * @param telefone
	 *            Telefone a ser verificado
	 * @return True se o telefone está ativo
	 */
	public abstract boolean verificarPermissao(Telefone telefone);

	/**
	 * Obtem o endereço RMI do cliente
	 * 
	 * @precondition verificarConectado(telefone)
	 * @param telefone
	 *            Telefone do cliente
	 * @return Endereco RMI correspondente ao cliente
	 */
	public abstract String enderecoRMIDoCliente(Telefone telefone);

	/**
	 * Verifica se o telefone está conectado no sistema
	 * 
	 * @param telefone
	 *            Telefone do cliente
	 * @return True se estiver conectado
	 */
	public abstract boolean verificarConectado(Telefone telefone);

	/**
	 * Adiciona telefone no sistema
	 * 
	 * @param telefone
	 *            Telefone a ser adicionado
	 */
	public abstract void adicionarTelefone(Telefone telefone);

	/**
	 * Remove telefone do sistema
	 * 
	 * @param telefone
	 *            Telefone a ser removido
	 */
	public abstract void removerTelefone(Telefone telefone);

}