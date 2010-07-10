package aifone.telefone;

import javax.swing.JPanel;

import aifone.telefone.iu.IUDiscar;

public interface IAppTelefoneIU {
	/**
	 * Recebe uma tela de discagem com seu RN
	 * 
	 * @param telaRetorno
	 *            Jpanel para onde se deve retornar
	 * 
	 */
	public IUDiscar getIUDiscarInstance(JPanel telaRetorno);
}
