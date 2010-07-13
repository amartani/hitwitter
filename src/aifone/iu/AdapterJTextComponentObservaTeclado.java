package aifone.iu;

import javax.swing.text.JTextComponent;

public class AdapterJTextComponentObservaTeclado implements IObservaTeclado{
	JTextComponent componente;

	public AdapterJTextComponentObservaTeclado(JTextComponent componente) {
		super();
		this.componente = componente;
	}

	@Override
	public void inserirCaractere(String caractere) {
		componente.setText(componente.getText().concat(caractere));
		
	}

	@Override
	public void apagar() {
		String texto = componente.getText();
		componente.setText(texto.substring(0, texto.length() - 1));	
	}
	
	
}
