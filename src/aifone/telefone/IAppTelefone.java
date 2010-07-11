package aifone.telefone;

import entidades.Telefone;

public interface IAppTelefone extends IAppTelefoneEntrada, IAppTelefoneSaida,
		IAppTelefoneIU {
public Telefone getTelefone();
}
