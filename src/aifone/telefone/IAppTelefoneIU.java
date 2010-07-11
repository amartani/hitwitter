package aifone.telefone;

import entidades.Telefone;

public interface IAppTelefoneIU {
	public void abrirTelaDiscar();
	public void abrirTelaEfetuandoChamada();
	public void abrirTelaRecebimentoDeChamada();
	public void abrirTelaConversa();
	public void abrirTelaInicial();
	public Telefone getTelefone();
}
