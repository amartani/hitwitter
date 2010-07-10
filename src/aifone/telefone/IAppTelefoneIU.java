package aifone.telefone;

import javax.swing.JPanel;

import aifone.iu.IUContainer;
import aifone.telefone.iu.IUDiscar;

public interface IAppTelefoneIU {
	/**
	 * Retorna uma tela de discagem com seu RN
	 * 
	 * @param telaRetorno
	 *            Jpanel para onde se deve retornar
	 * 
	 */
	public IUDiscar getIUDiscarInstance(JPanel telaRetorno);

	/**
	 * Retorna um container de telas
	 * 
	 * 
	 */
	public IUContainer getIUContainerInstance();
}
