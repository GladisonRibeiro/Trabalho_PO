package dados;

import classesAuxiliares.*;

public class Registro extends Item {
	// Os registros serão compostos dos campos CPF e nome do cliente, data e
	// valor de sua compra
	private Cpf cpf;
	private Nome nome;
	private Data data;
	private Double valor;

	public Cpf getCpf() {
		return cpf;
	}

	public void setCpf(Cpf cpf) {
		this.cpf = cpf;
	}

	public Nome getNome() {
		return nome;
	}

	public void setNome(Nome nome) {
		this.nome = nome;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setValor(String valor) {
		this.valor = Double.parseDouble(valor);
	}

	public Registro() {
		super();
	}

	public Registro(String cpf, String nome, String data, String valor) {
		super();
		this.cpf = new Cpf(cpf);
		this.nome = new Nome(nome);
		this.data = new Data(data);
		this.setValor(valor);
	}

	public Registro(int chave) {
		super(chave);
	}
	
	@Override
	public String toString() {
		return "Nome = "+this.nome + 
				"; Cpf = "+ this.cpf+
				"; Data = "+ this.data +
				"; Valor = "+ this.valor;
	}

}
