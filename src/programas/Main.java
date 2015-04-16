package programas;

import classesAuxiliares.Nome;

public class Main {

	
	public static void main(String[] args) {
//		new OrdenaPesquisa();

		Nome gladison = new Nome("Gladison Ribeiro da Silva");
		Nome eliane = new Nome("Eliane Sabadini");
		
		if(eliane.campareNome(gladison)){
			System.out.println(gladison.getPrimeiroNome() + " " +gladison.getSobrenome()+
					"\n" + eliane.getPrimeiroNome() + " " + eliane.getSobrenome());
		}
		else{
			System.out.println(eliane.getPrimeiroNome() + " " + eliane.getSobrenome()+
					"\n" +gladison.getPrimeiroNome() + " " +gladison.getSobrenome() );
			
		}
		
		
	}

}
