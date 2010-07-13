package aifone;

import java.util.Random;

public class PropriedadesRandom extends PropriedadesArquivo {

	private String numeroTelefone;
	private Random random;

	public PropriedadesRandom() {
		super();
		random = new Random();
	}

	@Override
	public String getNumeroTelefone() {
		if (numeroTelefone == null) {
			gerarNumeroTelefone();
		}
		return numeroTelefone;
	}

	private void gerarNumeroTelefone() {
		while (numeroInvalido()) {
			numeroTelefone = String.valueOf(random.nextInt(100000000));
		}
	}

	private boolean numeroInvalido() {
		return numeroTelefone == null || numeroTelefone.startsWith("0");
	}
}
