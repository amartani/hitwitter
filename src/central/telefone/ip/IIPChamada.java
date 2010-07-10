package central.telefone.ip;

import entidades.Telefone;

public interface IIPChamada {
	/**
	 * Armazena uma chamada em andamento
	 * 
	 * @param origem
	 *            Telefone que ligou
	 * @param destino
	 *            Telefone que atendeu a chamada
	 */
	public abstract void inserir(Telefone origem, Telefone destino);
	
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

