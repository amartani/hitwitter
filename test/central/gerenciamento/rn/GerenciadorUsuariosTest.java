package central.gerenciamento.rn;

import central.gerenciamento.ip.IIPConexao;
import central.gerenciamento.ip.IIPTelefone;
import central.gerenciamento.ip.IPConexaoMemoria;
import central.gerenciamento.ip.IPTelefoneMemoria;
import central.gerenciamento.rn.GerenciadorUsuarios;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import entidades.Telefone;

public class GerenciadorUsuariosTest {

	private GerenciadorUsuarios gerenciadorUsuario;
	private Telefone telefone;

	@Before
	public void setUp() throws Exception {
		IIPTelefone iptelefone = new IPTelefoneMemoria();
		IIPConexao ipconexao = new IPConexaoMemoria();
		gerenciadorUsuario = new GerenciadorUsuarios(iptelefone, ipconexao);
		telefone = new Telefone("12345678");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = Exception.class)
	public void conectarSemCadastro() {
		String enderecoRMI = "rmi://test/instance";
		gerenciadorUsuario.conectarTelefone(telefone, enderecoRMI);
	}

	@Test
	public void conectarAposCadastro() {
		gerenciadorUsuario.adicionarTelefone(telefone);
		String enderecoRMI = "rmi://test/instance";
		gerenciadorUsuario.conectarTelefone(telefone, enderecoRMI);
	}
	
	@Test
	public void desconectarAposConectar() {
		gerenciadorUsuario.adicionarTelefone(telefone);
		String enderecoRMI = "rmi://test/instance";
		gerenciadorUsuario.conectarTelefone(telefone, enderecoRMI);
		gerenciadorUsuario.desconectarTelefone(telefone);
	}
	
	@Test
	public void desconectarSemConectar() {
		gerenciadorUsuario.adicionarTelefone(telefone);
		gerenciadorUsuario.desconectarTelefone(telefone);
	}

	@Test
	public void verificarPermissaoSemCadastro() {
		assertFalse(gerenciadorUsuario.verificarPermissao(telefone));
	}
	
	@Test
	public void verificarPermissaoAposCadastro() {
		gerenciadorUsuario.adicionarTelefone(telefone);
		assertTrue(gerenciadorUsuario.verificarPermissao(telefone));
	}
	
	@Test
	public void removerTelefone() {
		gerenciadorUsuario.adicionarTelefone(telefone);
		gerenciadorUsuario.removerTelefone(telefone);
	}
	
	@Test
	public void verificarPermissaoAposRemoverCadastro() {
		gerenciadorUsuario.adicionarTelefone(telefone);
		gerenciadorUsuario.removerTelefone(telefone);
		assertFalse(gerenciadorUsuario.verificarPermissao(telefone));
	}
	
	@Test
	public void verificarConectadoSemConectar() {
		assertFalse(gerenciadorUsuario.verificarConectado(telefone));
	}
	
	@Test
	public void verificarConectadoAposConectar() {
		gerenciadorUsuario.adicionarTelefone(telefone);
		String enderecoRMI = "rmi://test/instance";
		gerenciadorUsuario.conectarTelefone(telefone, enderecoRMI);
		assertTrue(gerenciadorUsuario.verificarConectado(telefone));
	}
	
	@Test
	public void verificarConectadoAposDesconectar() {
		gerenciadorUsuario.adicionarTelefone(telefone);
		String enderecoRMI = "rmi://test/instance";
		gerenciadorUsuario.conectarTelefone(telefone, enderecoRMI);
		gerenciadorUsuario.desconectarTelefone(telefone);
		assertFalse(gerenciadorUsuario.verificarConectado(telefone));
	}
	
	@Test
	public void enderecoRMIDoCliente() {
		gerenciadorUsuario.adicionarTelefone(telefone);
		String enderecoRMI = "rmi://test/instance";
		gerenciadorUsuario.conectarTelefone(telefone, enderecoRMI);
		assertEquals(enderecoRMI, gerenciadorUsuario.enderecoRMIDoCliente(telefone));
	}
	
	@Test
	public void enderecoRMIDoClienteAposDesconectarEReconectar() {
		gerenciadorUsuario.adicionarTelefone(telefone);
		String enderecoRMI = "rmi://test/instance";
		gerenciadorUsuario.conectarTelefone(telefone, enderecoRMI);
		gerenciadorUsuario.desconectarTelefone(telefone);
		enderecoRMI = "rmi://test2/instance2";
		gerenciadorUsuario.conectarTelefone(telefone, enderecoRMI);
		assertEquals(enderecoRMI, gerenciadorUsuario.enderecoRMIDoCliente(telefone));
	}

}
