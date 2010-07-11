package aifone.telefone;

import javax.swing.JPanel;

import aifone.iu.IUContainer;
import aifone.iu.IUTelaInicial;
import aifone.telefone.iu.IUDiscar;

public interface IAppTelefoneIU {
	public void abrirTelaDiscar();
	public void abrirTelaEfetuandoChamada();
	public void abrirTelaRecebimentoDeChamada();
	public void abrirTelaConversa();
	public void abrirTelaInicial();

}
