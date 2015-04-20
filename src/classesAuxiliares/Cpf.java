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

	public boolean ÈIgual(Cpf cpf){
		if(this.cpf.equals(cpf.getCpf()))
			return true;
		else
			return false;
	}
}
