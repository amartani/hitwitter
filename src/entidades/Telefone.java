package entidades;

import java.io.Serializable;

public class Telefone implements Serializable {

	private String numero;

	protected String getNumero() {
		return numero;
	}

	protected void setNumero(String numero) {
		this.numero = numero;
	}

}
