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
	public boolean igualNome(Nome nome){
		if(this.valor.equals(nome.getValor()) )
			return true;
		else
			return false;
	}
	// retorna true se o valor do nome for menor ao do nome comparado
	public boolean menorNome(Nome nome){
		if(this.valor < nome.getValor() )
			return true;
		return false;
	}

	//Método criado com base no conceito da Professora
	//para definir um valor para comparação
	private void defineValor(String nome) {
		char[] c = nome.toCharArray();
		System.out.print("\nc.length = "+c.length);
		for (int i = 0; i < c.length; i++) {
			int aux = (int)(Character.valueOf(c[i]) * Math.pow(3, i));
			this.valor += aux;
		}
	}

	@Override
	public String toString() {
		return "nome=" + nome + ", valor=" + valor;
	}
	
	

}
