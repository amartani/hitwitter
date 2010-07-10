package central.telefone.ip;

import java.util.HashMap;
import java.util.Map;

import entidades.Telefone;

public class IPChamadaMemoria implements IIPChamada {
	
	private Map<Telefone, Telefone> banco;

	public IPChamadaMemoria() {
		banco = new HashMap<Telefone, Telefone>();
	}

	@Override
	public void apagar(Telefone telefone) {
		//remove entrada com a key do interlocutor
		banco.remove(procurar(telefone));
		banco.remove(telefone);
		
	}

	@Override
	public void inserir(Telefone origem, Telefone destino) {
		banco.put(origem, destino);
		banco.put(destino, origem);
		
	}

	@Override
	public Telefone procurar(Telefone telefone) {
		return banco.get(telefone);
	}
}
