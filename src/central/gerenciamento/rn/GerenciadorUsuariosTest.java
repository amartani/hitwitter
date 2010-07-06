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
		gerenciadorUsuario.conectarTelefone(telefone);
	}

	@Test
	public void conectarAposCadastro() {
		Telefone telefone = new Telefone("1234-5678");
		gerenciadorUsuario.adicionarTelefone(telefone);
		gerenciadorUsuario.conectarTelefone(telefone);
	}
	
	@Test
	public void desconectarAposConectar() {
		Telefone telefone = new Telefone("1234-5678");
		gerenciadorUsuario.adicionarTelefone(telefone);
		gerenciadorUsuario.conectarTelefone(telefone);
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
	public void verificarPermissaoAposRemoverTelefone() {
		Telefone telefone = new Telefone("1234-5678");
		gerenciadorUsuario.adicionarTelefone(telefone);
		gerenciadorUsuario.removerTelefone(telefone);
		assertFalse(gerenciadorUsuario.verificarPermissao(telefone));
	}
	
	
	

}
