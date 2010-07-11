package aifone;

import java.rmi.RemoteException;

import aifone.hitwitter.HiTwitter;
import aifone.hitwitter.IHiTwitter;
import aifone.telefone.AppTelefone;
import aifone.telefone.IAppTelefone;
import central.ICentralRemote;

public class AiFoneMock extends AiFone {

	private IAppTelefone apptelefone;
	private IHiTwitter hitwitter;
	private ICentralRemote servidor;
	private IPropriedades propriedades;	

	protected AiFoneMock() throws RemoteException {
		super();
		apptelefone = new AppTelefone(this);
		hitwitter = new HiTwitter(this);
		propriedades = new PropriedadesArquivoMock();

		conectarTelefone();
	}

}
