package programas;

import classesAuxiliares.IoFiles;
import dados.Registro;
import estruturas.ListaContig;

public class OrdenaPesquisa {

	public static  final Integer[] NOME_ARQUIVO = {500, 1000, 5000, 10000, 50000};
	public static final String[] TIPO_ARQUIVO = {"alea", "inv", "ord"};
	private static final String[] FLAG = {"Ordenado", "ResultadoPesquisa"};
	private Long tempoInicial, tempoFinal;

	private ListaContig itens;
	
	private static final String CAMINHO_TESTE = "src\\arquivos_de_teste\\cliente";
	private static final String CAMINHO_GRAVADOS = "src\\arquivos_gravados\\cliente";
	private static final String CAMINHO_CPF = "src\\arquivos_de_teste\\cpf.txt";
	private String[] cpfs;
	
	public OrdenaPesquisa() {
		super();
		cpfs = IoFiles.lerArquivo(200, OrdenaPesquisa.CAMINHO_CPF);
		fazTudo();
	}

	private void fazTudo(){
		tempoInicial = System.nanoTime();
		leOrdenaQuickGrava();
		lerOrdenadosQuickFazPesquisa();
		tempoFinal = System.nanoTime();
		System.out.println("\n\tTempo decorido : "+(tempoFinal - tempoInicial) + " nano-Segundos");
	}
	
	public void leOrdenaQuickGrava() {		 

		for (int i = 0; i < OrdenaPesquisa.NOME_ARQUIVO.length; i++) {
			itens = new ListaContig(OrdenaPesquisa.NOME_ARQUIVO[i]);
			for (int j = 0; j < TIPO_ARQUIVO.length; j++) {
				String caminho = OrdenaPesquisa.CAMINHO_TESTE + OrdenaPesquisa.NOME_ARQUIVO[i] + OrdenaPesquisa.TIPO_ARQUIVO[j] + ".txt";
				lerArquivo(OrdenaPesquisa.NOME_ARQUIVO[i], caminho);
				
				itens.quicksortRegistro();
				
				caminho = OrdenaPesquisa.CAMINHO_GRAVADOS + OrdenaPesquisa.NOME_ARQUIVO[i] + OrdenaPesquisa.TIPO_ARQUIVO[j] + OrdenaPesquisa.FLAG[0] + ".txt";
				gravarArquivo(itens.toArrayString(), caminho);
				
				itens.zeraLista(); //3
			}
		}
	}
	
	public void lerOrdenadosQuickFazPesquisa(){
		for (int i = 0; i < OrdenaPesquisa.NOME_ARQUIVO.length; i++) 
		{
			itens = new ListaContig(OrdenaPesquisa.NOME_ARQUIVO[i]); //cria a lista do tamanho desejado
			for (int j = 0; j < TIPO_ARQUIVO.length; j++) 
			{
				System.out.println("lendo Arquivo "+OrdenaPesquisa.NOME_ARQUIVO[i]+OrdenaPesquisa.TIPO_ARQUIVO[j]+OrdenaPesquisa.FLAG[0]);
				
				String caminho = OrdenaPesquisa.CAMINHO_GRAVADOS + OrdenaPesquisa.NOME_ARQUIVO[i]+OrdenaPesquisa.TIPO_ARQUIVO[j] + OrdenaPesquisa.FLAG[0] +".txt";
				lerArquivo(OrdenaPesquisa.NOME_ARQUIVO[i], caminho);			
				
				//faz a pesquisa
				String[] aux = new String[200];
				for (int k = 0; k < cpfs.length; k++) 
				{
					String auxiliar = itens.pesquisaBinaria(Long.parseLong(this.cpfs[k]));
					if(auxiliar == null)
					{
						auxiliar = this.cpfs[k] + " CPF INEXISTENTE.";
					}
					
					aux[k] = auxiliar;
				}
				
				caminho = OrdenaPesquisa.CAMINHO_GRAVADOS + OrdenaPesquisa.NOME_ARQUIVO[i]+OrdenaPesquisa.TIPO_ARQUIVO[j] + OrdenaPesquisa.FLAG[1] +".txt";
				gravarArquivo(aux, caminho);
				
				itens.zeraLista();
				System.out.println("\nok lerOrdenadosQuickFazPesquisa() -> "+ OrdenaPesquisa.NOME_ARQUIVO[i] + OrdenaPesquisa.TIPO_ARQUIVO[j] + OrdenaPesquisa.FLAG[1]); //Debug.
			}
		}
	}
	
	
	public void lerArquivo(int tamanho, String caminhoArquivo){
		try {
			String[] arquivo = IoFiles.lerArquivo(tamanho, caminhoArquivo);
				for (int i = 0; i < arquivo.length; i++) {		
					String[] tokens = arquivo[i].split(";");
					boolean flag = itens.inserirUltimo( new Registro(tokens[0],tokens[1],tokens[2],tokens[3]) );
					//inicio Debug da flag.
					if(!flag){
						System.err.println("erro na flag inserirUltimo");
						flag = !flag;
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		System.out.println("\nok lerArquivo -> "+caminhoArquivo); //Debug.
	}

	public void gravarArquivo(String[] items, String caminhoArquivo){
		IoFiles.gravarArquivo(items, caminhoArquivo);
		System.out.println("ok gravarArquivo -> "+caminhoArquivo);//Debug.
		
	}
	
}

