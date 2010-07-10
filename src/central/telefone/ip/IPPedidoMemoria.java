package central.telefone.ip;

import java.util.HashMap;
import java.util.Map;

import entidades.Telefone;

public class IPPedidoMemoria implements IIPPedidoChamada {

	private Map<Telefone, Telefone> banco;
	
	public IPPedidoMemoria() {
		banco = new HashMap<Telefone, Telefone>();
	}	
	
	@Override
	public void apagar(Telefone telefone) {
		banco.remove(telefone);	
	}

	@Override
	public void inserir(Telefone chave, Telefone interlocutor) {
		banco.put(chave, interlocutor);		
	}

	@Override
	public Telefone procurar(Telefone telefone) {
		return banco.get(telefone);
	}

}
