package central.telefone;

import entidades.Telefone;

public interface ICentralTelefonica extends ICentralTelefonicaEntrada,
		ICentralTelefonicaSaida {
	/**
	 * Verifica se o telefone está conectado no sistema
	 * 
	 * @param telefone
	 *            Telefone do cliente
	 * @return True se estiver conectado
	 */
	public boolean verificarConectado(Telefone telefone);
}
