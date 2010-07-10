package central.telefone;

import entidades.Telefone;

public interface ICentralTelefonicaSaida extends ICentralTelefonicaSaidaRemote {

	/**
	 * Verifica se o telefone está conectado no sistema
	 * 
	 * @param telefone
	 *            Telefone do cliente
	 * @return True se estiver conectado
	 */
	public boolean verificarConectado(Telefone telefone);

}