package classesAuxiliares;

public class Nome {
	
	private String primeiroNome, sobrenome;
	private String regex = " ";
	
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public Nome(String nome) {
		String[] tokens = nome.split(regex);
		this.primeiroNome = tokens[0];   
		for (int i = 1; i < tokens.length; i++) {
			this.sobrenome += tokens[i]+ " ";
		}
	}
	
	//compara a primeira letra do nome e a do sobrenome 
	//retorna true se a letra for menor que a do nome passado 
	public boolean campareNome(Nome nome){
		char pthis = this.primeiroNome.toLowerCase().charAt(0);
		char pnome = nome.getPrimeiroNome().toLowerCase().charAt(0);
		char sthis = this.sobrenome.toLowerCase().charAt(0);
		char snome = nome.getSobrenome().toLowerCase().charAt(0);
		
		if(pthis == pnome){
			if(sthis >= snome)
				return true;
		}
		else if(pthis >= pnome){
			return true;
		}
		
		return false;
	}

}
