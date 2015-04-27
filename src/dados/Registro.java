package dados;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Registro extends Item {
	// Os registros serão compostos dos campos CPF e nome do cliente, data e
	// valor de sua compra
	private Long cpf;
	private String nome;
	private Date data;
	private Double valor;

	
	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = Long.parseLong(cpf);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}
	public String getDataString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(this.data);
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public void setData(String data) {
		// tentar transformar String em data
		DateFormat f = DateFormat.getDateInstance();
		try {
			this.data = f.parse(data);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		this.setCpf(cpf);
		this.nome = nome;
		this.setData(data);
		this.setValor(valor);
	}

	public Registro(int chave) {
		super(chave);
	}
	
	@Override
	public String toString() {
//		String aux = "";
//		int auxCpf = String.valueOf(this.cpf).length();
//		while(auxCpf < 11){
//			aux += "0";
//			auxCpf++;
//		}
		
		return 	this.cpf+";"+ 
				this.nome+";"+
				this.getDataString() +";"+
				+this.valor;
	}

}
