package dados;

import classesAuxiliares.Data;
import classesAuxiliares.Nome;

public class Registro extends Item {
	//Os registros serão compostos dos campos CPF e nome do cliente, data e valor de sua compra
	private String cpf, valor;
	private Nome nome;
	private Data data;

	public Registro() {
		super();
	}

	public Registro(int chave) {
		super(chave);
	}

}
