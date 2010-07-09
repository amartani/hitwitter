package central.gerenciamento.ip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import entidades.Telefone;

public class IPTelefoneSerializado implements IIPTelefone {

	private HashSet<Telefone> banco;

	private static final String FILENAME = "files/telefones";

	public IPTelefoneSerializado() {
		carregarTelefonesDoArquivo();
	}

	@SuppressWarnings("unchecked")
	private void carregarTelefonesDoArquivo() {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(FILENAME);
			in = new ObjectInputStream(fis);
			banco = (HashSet<Telefone>) in.readObject();
			in.close();
		} catch (ClassNotFoundException e) {
			banco = new HashSet<Telefone>();
		} catch (IOException e) {
			banco = new HashSet<Telefone>();
		}
	}

	private void gravarTelefonesNoArquivo() {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(FILENAME);
			out = new ObjectOutputStream(fos);
			out.writeObject(banco);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.ip.IIPTelefone#inserir(entidades.Telefone)
	 */
	@Override
	public void inserir(Telefone telefone) {
		banco.add(telefone);
		gravarTelefonesNoArquivo();
	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.ip.IIPTelefone#procurar(entidades.Telefone)
	 */
	@Override
	public boolean procurar(Telefone telefone) {
		return banco.contains(telefone);
	}

	/* (non-Javadoc)
	 * @see central.gerenciamento.ip.IIPTelefone#apagar(entidades.Telefone)
	 */
	@Override
	public void apagar(Telefone telefone) {
		banco.remove(telefone);
		gravarTelefonesNoArquivo();
	}


}
