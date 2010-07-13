package aifone;

import java.rmi.RemoteException;

import aifone.hitwitter.AppHiTwitter;
import aifone.hitwitter.rn.HiTwitter;
import aifone.telefone.AppTelefone;
import aifone.telefone.IAppTelefone;
import aifone.telefone.IAppTelefoneEntrada;
import aifone.telefone.IAppTelefoneIU;
import entidades.Telefone;

public class AiFone {
	private AiFoneEntrada entrada;
	private AiFoneSaida saida;
	private AiFoneIU iu;
	private AppTelefone apptelefone;
	private AppHiTwitter hitwitter;
	private IPropriedades propriedades;
	private String nomeListener;

	protected AiFone(IPropriedades propriedades) throws RemoteException {
		this.propriedades = propriedades;
		nomeListener = new String(((Long) System.currentTimeMillis())
				.toString().substring(7));
		entrada = new AiFoneEntrada(this);
		saida = new AiFoneSaida(this, nomeListener);
		iu = new AiFoneIU(this);
	}

	protected IAiFoneEntrada getEntrada() {
		return entrada;
	}

	protected IAiFoneSaida getSaida() {
		return saida;
	}

	protected IAiFoneIU getIU() {
		return iu;
	}

	protected Telefone getTelefone() {
		return new Telefone(propriedades.getNumeroTelefone());
	}

	protected IAppTelefone getAppTelefone() {
		if (apptelefone == null) {
			apptelefone = new AppTelefone(getSaida(), getIU(), getTelefone());
		}
		return apptelefone;
	}

	protected IAppTelefoneIU getAppTelefoneIU() {
		return getAppTelefone();
	}

	protected IAppTelefoneEntrada getAppTelefoneEntrada() {
		return getAppTelefone();
	}

	public AppHiTwitter getHitwitter() {
		if (hitwitter == null) {
			hitwitter = new AppHiTwitter(getSaida(), getIU());
		}
		return hitwitter;
	}

	protected IPropriedades getPropriedades() {
		return propriedades;
	}

	public String getNomeListener() {
		return nomeListener;
	}

}
