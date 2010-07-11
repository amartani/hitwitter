package central.gerenciamento.ip;

import entidades.Telefone;

public interface IIPConexao {

	/**
	 * Armazena um telefone conectado
	 * 
	 * @param telefone
	 *            Telefone
	 * @param enderecoRMI
	 *            Endereço RMI do Telefone
	 */
	public abstract void inserir(Telefone telefone, String enderecoRMI);

	/**
	 * Procura um telefone no banco
	 * 
	 * @param telefone
	 *            Telefone a procurar
	 * @return Endereço RMI referente ao telefone, ou null se não encontrado
	 */
	public abstract String procurar(Telefone telefone);

	/**
	 * Apaga o telefone do banco
	 * 
	 * @param telefone
	 *            Telefone a apagar
	 */
	public abstract void apagar(Telefone telefone);

}