package entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RespostaDeRequisicao implements Serializable {
	String errorMessage = "";
	String statusCode = "";
	String message = "";

	public RespostaDeRequisicao(String errorMessage, String statusCode, String message) {
		super();
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
		this.message = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}
}