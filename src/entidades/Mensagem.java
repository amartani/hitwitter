package entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Mensagem implements Serializable {
	
	private String conteudo;

	public Mensagem(String conteudo) {
		super();
		this.conteudo = conteudo;
	}

	public String getConteudo() {
		return conteudo;
	}

	@Override
	public String toString() {
		return "Mensagem [conteudo=" + conteudo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((conteudo == null) ? 0 : conteudo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensagem other = (Mensagem) obj;
		if (conteudo == null) {
			if (other.conteudo != null)
				return false;
		} else if (!conteudo.equals(other.conteudo))
			return false;
		return true;
	}

}
