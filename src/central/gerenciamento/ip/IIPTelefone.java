package central.gerenciamento.ip;

import entidades.Telefone;

public interface IIPTelefone {

	/**
	 * Armazena um telefone registrado
	 * 
	 * @param telefone
	 *            Telefone
	 */
	public abstract void inserir(Telefone telefone);

	/**
	 * Procura um telefone no banco
	 * 
	 * @param telefone
	 *            Telefone à procurar
	 * @return true se o telefone estiver registrado
	 */
	public abstract boolean procurar(Telefone telefone);

	/**
	 * Apaga o telefone do banco
	 * 
	 * @param telefone
	 *            Telefone a apagar
	 */
	public abstract void apagar(Telefone telefone);

}