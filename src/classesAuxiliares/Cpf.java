package classesAuxiliares;

public class Cpf {

	private Long cpf;
	
	
	public Long getCpf() {
		return cpf;
	}


	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = Long.parseLong(cpf);
	}

	public Cpf(String cpf) {
		this.cpf = Long.parseLong(cpf);
	}

	public boolean �Igual(Cpf cpf){
		if(this.cpf.equals(cpf.getCpf()))
			return true;
		else
			return false;
	}
	
	public boolean �Menor(Cpf cpf) {
		if(this.cpf < cpf.getCpf())
			return true;
		else
			return false;
	}

	public boolean �Maior(Cpf cpf) {
		if(this.cpf > cpf.getCpf())
			return true;
		else
			return false;
	}
}
