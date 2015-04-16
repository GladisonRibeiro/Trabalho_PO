package classesAuxiliares;


public class Data {

	private int dia, mes, ano;
	private String regex = "/";
	
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	
	public Data(String data) {
		String[] tokens = data.split(regex);
		this.dia = Integer.parseInt(tokens[0]);
		this.mes = Integer.parseInt(tokens[1]);
		this.ano = Integer.parseInt(tokens[2]);				
	}
	
	//retorna true se mais atual que a data passada
	public boolean compareData(Data data2){
		
		if(this.ano == data2.getAno() ){
			if(this.mes == data2.getMes()){	
				if(this.dia >= data2.getDia()){
					return true;
				}
			}
			else if(this.mes > data2.getMes()){
				return true;
			}
		}
		else if(this.ano > data2.getAno()){
			return true;
		}
		
		return false;
	}

}
