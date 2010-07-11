package central;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import central.gerenciamento.Gerenciamento;
import central.gerenciamento.ip.IPConexaoMemoria;
import central.gerenciamento.ip.IPTelefoneMemoria;
import central.gerenciamento.ip.IPTelefoneStub;
import central.gerenciamento.rn.GerenciadorUsuarios;
import central.telefone.CentralTelefonica;
import central.tunel.Tunel;

public class MainTelefoneQualquer {

	/**
	 * @param args
	 */
	public void ativarServidorRMI(ICentralRemote servidor) {
		System.setSecurityManager(null);
		System.out.println("Ativando servidor");
		try {
			LocateRegistry.createRegistry(1099);
		} catch (Exception e) {
			System.out.println("Registro RMI ja estava ativo");
		}
		try {
			Naming.rebind("centralaifone", servidor);
			System.out.println("Servidor ativo");
		} catch (Exception e2) {
			System.out.println("Impossivel ativar servidor. Excecao: ");
			e2.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws Exception {
		MainTelefoneQualquer main = new MainTelefoneQualquer();
		Gerenciamento gerenciamento = new Gerenciamento(new GerenciadorUsuarios(new IPTelefoneStub(), new IPConexaoMemoria()));
		CentralSaida saida = new CentralSaida(gerenciamento);
		CentralTelefonica centraltelefonica = new CentralTelefonica(saida, gerenciamento);
		Tunel tunel = new Tunel();
		CentralEntrada entrada = new CentralEntrada(centraltelefonica, gerenciamento, tunel);
		main.ativarServidorRMI(entrada);
	}

}
