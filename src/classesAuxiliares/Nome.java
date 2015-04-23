package classesAuxiliares;

public class Nome {

	private String nome;
	private Long valor = 0L;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public Nome(String nome) {
		this.nome = nome;
		defineValor(nome);
	}

	// retorna true se o valor do nome for igual ao do nome comparado
	public boolean ÈIgual(Nome nome){
		if(this.valor.equals(nome.getValor()) )
			return true;
		else
			return false;
	}
	// retorna true se o valor do nome for menor ao do nome comparado
	public boolean ÈMenor(Nome nome){
		if(this.valor < nome.getValor() )
			return true;
		else
			return false;
	}
	// retorna true se o valor do nome for maior ao do nome comparado
	public boolean ÈMaior(Nome nome){
		if(this.valor > nome.getValor() )
			return true;
		else
			return false;
	}

	//MÈtodo criado com base no conceito da Professora
	//para definir um valor para comparaÁ„o
	private void defineValor(String nome) {
		char[] c = nome.toCharArray();
		//definir um valor statico para a quantidade de caracteres a ser olhada ser a mesma
		//substituir o c.length por 6.
		for (int i = 0; i < 6; i++) {
			int aux = (int)(Character.valueOf(c[i]) * Math.pow(3, i));
			this.valor += aux;
		}
	}

	@Override
	public String toString() {
		return "nome=" + nome + ", valor=" + valor;
	}
	
	

}
