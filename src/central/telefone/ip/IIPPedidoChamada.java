package central.telefone.ip;

import entidades.Telefone;

public interface IIPPedidoChamada {
	/**
	 * Armazena um pedido de chamada em andamento
	 * 
	 * @param chave
	 *            Telefone chave (origem ou destino)
	 * @param interlocutor
	 *            Telefone interlocutor (destino ou origem)
	 */
	public abstract void inserir(Telefone chave, Telefone interlocutor);
	
	/**
	 * Procura um telefone no banco
	 * 
	 * @param telefone
	 *            Telefone a procurar
	 * @return Telefone interlocutor referente à chamada atual, ou null se não estiver ocupado
	 */
	public abstract Telefone procurar(Telefone telefone);
	
	/**
	 * Apaga o telefone do banco
	 * 
	 * @param telefone
	 *            Telefone a apagar
	 */
	public abstract void apagar(Telefone telefone);	
}
