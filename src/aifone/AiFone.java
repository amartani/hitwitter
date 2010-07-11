package aifone;

import java.rmi.RemoteException;

import entidades.Telefone;

import aifone.hitwitter.HiTwitter;
import aifone.telefone.AppTelefone;
import aifone.telefone.IAppTelefone;
import aifone.telefone.IAppTelefoneEntrada;
import aifone.telefone.IAppTelefoneIU;

public class AiFone {
	private AiFoneEntrada entrada;
	private AiFoneSaida saida;
	private AiFoneIU iu;
	private AppTelefone apptelefone;
	private HiTwitter hitwitter;
	private IPropriedades propriedades;

	protected AiFone(IPropriedades propriedades) throws RemoteException {
		this.propriedades = propriedades;
		entrada = new AiFoneEntrada(this);
		saida = new AiFoneSaida(this);
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
	
	protected HiTwitter getHitwitter() {
		if (hitwitter == null) {
			hitwitter = new HiTwitter(getSaida());
		}
		return hitwitter;
	}
	
	protected IPropriedades getPropriedades() {
		return propriedades;
	}
	
	protected Telefone getTelefone() {
		return new Telefone(getPropriedades().getNumeroTelefone());
	}

}
