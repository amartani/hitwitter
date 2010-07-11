package central.telefone.rn;

import static org.easymock.EasyMock.*;

import java.rmi.RemoteException;

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

	@Test
	public void efetuarChamada() throws Exception {
		expect(central.verificarConectado(destino)).andReturn(true);
		central.receberChamada(origem, destino);

		replay(central);
		gerenciadorchamadas.efetuarChamada(origem, destino);
		verify(central);
	}

	@Test
	public void confirmarAtendimento() throws Exception {
		efetuarChamada();
		reset(central);

		central.informarChamadaConfirmada(origem);
		central.informarChamadaConfirmada(destino);

		replay(central);
		gerenciadorchamadas.confirmarAtendimento(destino);
		verify(central);
	}

	@Test
	public void informarChamadaRejeitada() throws Exception {
		efetuarChamada();
		reset(central);
		central.informarChamadaRejeitada(origem);

		replay(central);
		gerenciadorchamadas.informarChamadaRejeitada(destino);
		verify(central);
	}

	@Test
	public void enviarMensagem() throws Exception {
		confirmarAtendimento();
		reset(central);

		central.receberMensagem(destino, mensagem);
		central.receberMensagem(destino, mensagem);
		central.receberMensagem(origem, mensagem);
		central.receberMensagem(destino, mensagem);

		replay(central);
		gerenciadorchamadas.enviarMensagem(origem, mensagem);
		gerenciadorchamadas.enviarMensagem(origem, mensagem);
		gerenciadorchamadas.enviarMensagem(destino, mensagem);
		gerenciadorchamadas.enviarMensagem(origem, mensagem);
		verify(central);
	}

	@Test
	public void informarChamadaEncerrada() throws Exception {
		confirmarAtendimento();
		reset(central);

		central.informarChamadaEncerrada(origem);

		replay(central);
		gerenciadorchamadas.informarChamadaEncerrada(destino);
		verify(central);
	}

	@Test
	public void informarChamadaEncerradaPelaOrigem() throws Exception {
		confirmarAtendimento();
		reset(central);

		central.informarChamadaEncerrada(destino);

		replay(central);
		gerenciadorchamadas.informarChamadaEncerrada(origem);
		verify(central);
	}

	@Test
	public void efetuarChamadaComDestinoDesconectado() throws Exception {
		expect(central.verificarConectado(destino)).andReturn(false);
		// TODO: Provavelmente deveria ter outro método de resposta para quando
		// o cara nao atende,
		// mas entre os que tem acho q o melhor eh esse.
		central.informarChamadaRejeitada(origem);

		replay(central);
		gerenciadorchamadas.efetuarChamada(origem, destino);
		verify(central);
	}

	@Test
	public void efetuarChamadaComDestinoComFalhaDeConexao() throws Exception {
		expect(central.verificarConectado(destino)).andReturn(true);
		central.receberChamada(origem, destino);
		expectLastCall().andThrow(new RemoteException());
		// Deve informar a origem que a chamada nao pode ser completada
		central.informarChamadaRejeitada(origem);

		replay(central);
		gerenciadorchamadas.efetuarChamada(origem, destino);
		verify(central);
	}

	@Test
	public void enviarMensagemComFalhaDeConexao() throws Exception {
		confirmarAtendimento();
		reset(central);

		central.receberMensagem(destino, mensagem);
		expectLastCall().andThrow(new RemoteException());
		// Deve encerrar a chamada imediatamente com o que ainda esta on
		central.informarChamadaEncerrada(origem);

		replay(central);
		gerenciadorchamadas.enviarMensagem(origem, mensagem);
		verify(central);
	}

	@Test
	public void enviarMensagemComFalhaDeConexaoNaOrigem() throws Exception {
		confirmarAtendimento();
		reset(central);

		central.receberMensagem(origem, mensagem);
		expectLastCall().andThrow(new RemoteException());
		// Deve encerrar a chamada imediatamente com o que ainda esta on
		central.informarChamadaEncerrada(destino);

		replay(central);
		gerenciadorchamadas.enviarMensagem(destino, mensagem);
		verify(central);
	}

	@Test
	public void efetuarChamadaComDestinoOcupado() throws Exception {
		confirmarAtendimento();
		reset(central);
		Telefone terceiro = new Telefone("38291035");
		central.informarChamadaRejeitada(terceiro);

		replay(central);
		gerenciadorchamadas.efetuarChamada(terceiro, origem);
		verify(central);
	}

}
