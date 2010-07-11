package central.telefone.rn;

import static org.easymock.EasyMock.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import central.telefone.ICentralTelefonicaSaida;
import entidades.Mensagem;
import entidades.Telefone;

public class GerenciadorChamadasTest {
	
	private GerenciadorChamadas gerenciadorchamadas;
	private ICentralTelefonicaSaida central;
	private Telefone origem;
	private Telefone destino;
	private Mensagem mensagem;

	@Before
	public void setUp() throws Exception {
		central = createMock(ICentralTelefonicaSaida.class);
		gerenciadorchamadas = new GerenciadorChamadas(central);
		origem = new Telefone("12345678");
		destino = new Telefone("87654321");
		mensagem = new Mensagem("Ola, tudo bem?");
	}

	@After
	public void tearDown() throws Exception {
	}
	
//	public void bla() {
//		Telefone telefone, origem, destino;
//		Mensagem mensagem;
//		gerenciadorchamadas.confirmarAtendimento(telefone);
//		gerenciadorchamadas.efetuarChamada(origem, destino);
//		gerenciadorchamadas.enviarMensagem(origem, mensagem);
//		gerenciadorchamadas.informarChamadaEncerrada(telefone);
//		gerenciadorchamadas.informarChamadaRejeitada(telefone);
//		
//	}
	
	@Test
	public void efetuarChamada() throws Exception {
		expect(central.verificarConectado(destino)).andReturn(true);
		central.enviarPedidoChamada(origem, destino);
		
		replay(central);
		gerenciadorchamadas.efetuarChamada(origem, destino);
		verify(central);
	}
	
	@Test
	public void confirmarAtendimento() throws Exception {
		expect(central.verificarConectado(destino)).andReturn(true);
		central.enviarPedidoChamada(origem, destino);
		central.confirmarChamada(destino);
		central.confirmarChamada(origem);
		
		replay(central);
		gerenciadorchamadas.efetuarChamada(origem, destino);
		gerenciadorchamadas.confirmarAtendimento(destino);
		verify(central);
	}
	
	@Test
	public void informarChamadaRejeitada() throws Exception {
		expect(central.verificarConectado(destino)).andReturn(true);
		central.enviarPedidoChamada(origem, destino);
		central.rejeitarChamada(origem);
		
		replay(central);
		gerenciadorchamadas.efetuarChamada(origem, destino);
		gerenciadorchamadas.informarChamadaRejeitada(destino);
		verify(central);
	}
	
	@Test
	public void enviarMensagem() throws Exception {
		expect(central.verificarConectado(destino)).andReturn(true);
		central.enviarPedidoChamada(origem, destino);
		central.confirmarChamada(destino);
		central.confirmarChamada(origem);
		central.enviarMensagemParaCliente(destino, mensagem);
		central.enviarMensagemParaCliente(destino, mensagem);
		central.enviarMensagemParaCliente(origem, mensagem);
		central.enviarMensagemParaCliente(destino, mensagem);
		
		replay(central);
		gerenciadorchamadas.efetuarChamada(origem, destino);
		gerenciadorchamadas.confirmarAtendimento(destino);
		gerenciadorchamadas.enviarMensagem(origem, mensagem);
		gerenciadorchamadas.enviarMensagem(origem, mensagem);
		gerenciadorchamadas.enviarMensagem(destino, mensagem);
		gerenciadorchamadas.enviarMensagem(origem, mensagem);
		verify(central);
	}
	
	@Test
	public void informarChamadaEncerrada() throws Exception {
		expect(central.verificarConectado(destino)).andReturn(true);
		central.enviarPedidoChamada(origem, destino);
		central.confirmarChamada(destino);
		central.confirmarChamada(origem);
		
		
		replay(central);
		gerenciadorchamadas.efetuarChamada(origem, destino);
		gerenciadorchamadas.confirmarAtendimento(destino);
		gerenciadorchamadas.informarChamadaEncerrada(destino);
		verify(central);
	}

}
