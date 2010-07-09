package central.gerenciamento.rn;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

import static org.junit.Assert.*;

import entidades.Telefone;

public class GerenciadorUsuariosTest {

	private GerenciadorUsuarios gerenciadorUsuario;

	@Before
	public void setUp() throws Exception {
		gerenciadorUsuario = new GerenciadorUsuarios();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = Exception.class)
	public void conectarSemCadastro() {
		Telefone telefone = new Telefone("1234-5678");
		String enderecoRMI = "rmi://test/instance";
		gerenciadorUsuario.conectarTelefone(telefone, enderecoRMI);
	}

	@Test
	public void conectarAposCadastro() {
		Telefone telefone = new Telefone("1234-5678");
		gerenciadorUsuario.adicionarTelefone(telefone);
		String enderecoRMI = "rmi://test/instance";
		gerenciadorUsuario.conectarTelefone(telefone, enderecoRMI);
	}
	
	@Test
	public void desconectarAposConectar() {
		Telefone telefone = new Telefone("1234-5678");
		gerenciadorUsuario.adicionarTelefone(telefone);
		String enderecoRMI = "rmi://test/instance";
		gerenciadorUsuario.conectarTelefone(telefone, enderecoRMI);
		gerenciadorUsuario.desconectarTelefone(telefone);
	}
	
	@Test
	public void desconectarSemConectar() {
		Telefone telefone = new Telefone("1234-5678");
		gerenciadorUsuario.adicionarTelefone(telefone);
		gerenciadorUsuario.desconectarTelefone(telefone);
	}

	@Test
	public void verificarPermissaoSemCadastro() {
		Telefone telefone = new Telefone("1234-5678");
		assertFalse(gerenciadorUsuario.verificarPermissao(telefone));
	}
	
	@Test
	public void verificarPermissaoAposCadastro() {
		Telefone telefone = new Telefone("1234-5678");
		gerenciadorUsuario.adicionarTelefone(telefone);
		assertTrue(gerenciadorUsuario.verificarPermissao(telefone));
	}
	
	@Test
	public void removerTelefone() {
		Telefone telefone = new Telefone("1234-5678");
		gerenciadorUsuario.adicionarTelefone(telefone);
		gerenciadorUsuario.removerTelefone(telefone);
	}
	
	@Test
	public void verificarPermissaoAposRemoverCadastro() {
		Telefone telefone = new Telefone("1234-5678");
		gerenciadorUsuario.adicionarTelefone(telefone);
		gerenciadorUsuario.removerTelefone(telefone);
		assertFalse(gerenciadorUsuario.verificarPermissao(telefone));
	}
	
	@Test
	public void verificarConectadoSemConectar() {
		Telefone telefone = new Telefone("1234-5678");
		assertFalse(gerenciadorUsuario.verificarConectado(telefone));
	}
	
	@Test
	public void verificarConectadoAposConectar() {
		Telefone telefone = new Telefone("1234-5678");
		gerenciadorUsuario.adicionarTelefone(telefone);
		String enderecoRMI = "rmi://test/instance";
		gerenciadorUsuario.conectarTelefone(telefone, enderecoRMI);
		assertTrue(gerenciadorUsuario.verificarConectado(telefone));
	}
	
	@Test
	public void verificarConectadoAposDesconectar() {
		Telefone telefone = new Telefone("1234-5678");
		gerenciadorUsuario.adicionarTelefone(telefone);
		String enderecoRMI = "rmi://test/instance";
		gerenciadorUsuario.conectarTelefone(telefone, enderecoRMI);
		gerenciadorUsuario.desconectarTelefone(telefone);
		assertFalse(gerenciadorUsuario.verificarConectado(telefone));
	}
	
	@Test
	public void enderecoRMIDoCliente() {
		Telefone telefone = new Telefone("1234-5678");
		gerenciadorUsuario.adicionarTelefone(telefone);
		String enderecoRMI = "rmi://test/instance";
		gerenciadorUsuario.conectarTelefone(telefone, enderecoRMI);
		assertEquals(enderecoRMI, gerenciadorUsuario.enderecoRMIDoCliente(telefone));
	}
	
	@Test
	public void enderecoRMIDoClienteAposDesconectarEReconectar() {
		Telefone telefone = new Telefone("1234-5678");
		gerenciadorUsuario.adicionarTelefone(telefone);
		String enderecoRMI = "rmi://test/instance";
		gerenciadorUsuario.conectarTelefone(telefone, enderecoRMI);
		gerenciadorUsuario.desconectarTelefone(telefone);
		enderecoRMI = "rmi://test2/instance2";
		gerenciadorUsuario.conectarTelefone(telefone, enderecoRMI);
		assertEquals(enderecoRMI, gerenciadorUsuario.enderecoRMIDoCliente(telefone));
	}

}
