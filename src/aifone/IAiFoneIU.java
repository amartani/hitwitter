package aifone;

import entidades.Telefone;

public interface IAiFoneIU {

	public void abrirTelaInicial();

	public void abrirTelaTelefone();

	public Telefone getTelefone();

	public void abrirHiTwitter();

	public void abrirTelaEnviarTweet();

	public AiFone getAifone();

	public void abrirTelaLerTweets();
}
