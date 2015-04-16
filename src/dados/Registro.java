package dados;

public class Registro extends Item {
	//Os registros serão compostos dos campos CPF e nome do cliente, data e valor de sua compra
	private String cpf, nome, data, valor;
	

	public Registro() {
		super();
	}

	public Registro(int chave) {
		super(chave);
	}

}
