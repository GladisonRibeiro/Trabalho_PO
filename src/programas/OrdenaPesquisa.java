package programas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import dados.Item;
import dados.Registro;
import estruturas.ListaContig;

/**
 * @author gladison.
 * @category class.
 * Descrição: Nesta classe será colocado todo o codigo referente a leitura e escrita dos arquivos.
 * 			
 * Obs: O codigo de pesquisa e Ordenação estará dentro da Estrutura de dados adotada ( ListaContig ).
 * 		Após o entendimento de todos aconselho retirar todos os comentarios desnecessarios!
 * 
 * 	Depois de rodar o programa tem que clicar com o mouse button right no pacote arquivos e ir em refresh
 */
public class OrdenaPesquisa {

	/*
	 * Variaveis(Arrays) para controle do nome dos arquivos, que e composto por um numero(tamanho) e 
	 * 	tipo de ordenação que ele possui.
	 */
	public static  final Integer[] NOME_ARQUIVO = {500, 1000, 5000, 10000, 50000};
	public static final String[] TIPO_ARQUIVO = {"alea", "inv", "ord"};
	private static final String ORDERNADO = "Ordenado";
	
	//variaveis para a contagem de tempo
	private Long tempoInicial, tempoFinal;


	
	Path path; //Classe que referência o caminho do arquivo
	Charset cs = StandardCharsets.US_ASCII; // codificação do arquivo para que não aja erro na hora de ler ( define o tipo de linguagem que o arquivo está)
	ListaContig itens; //Estrutura de dados para ser preechida com os registros para efetuar a busca e a pesquisa
	
	public OrdenaPesquisa() {
		super();
		fazTudo();
	}
	
	/*
	 * Método para concentrar todas as ações necessarias no trabalho
	 */
	private void fazTudo(){
		tempoInicial = System.nanoTime();
		leOrdenaQuickGrava();
		System.out.println("\nentre os métodos lerOrdenaquickGrava e lerOrdenadosQuick\n");
//		lerOrdenadosQuick();
		tempoFinal = System.nanoTime();
		System.out.println("\n\tTempo decorido : "+(tempoFinal - tempoInicial) + " nano-Segundos");
	}
	
	/*
	 * Esse método percore todos os arquivos possiveis ordenando com quickSort(Normal).
	 * algoritmo de quickSort é da Professora.
	 */
	public void leOrdenaQuickGrava() {		 
		/*
		 * Estes for`s são para percorrer todos os arquivos e: 
		 * 1 - ler;
		 * 2 - grava ( dentro de gravar eu chamo o metodo quicksort(), da classe ListaContig que faz o quicksort [;)] 
		 * 				e retorna um vetor de Itens );
		 * 3 - zera a lista, porque estava dando treta sem isso....  
		 */
		for (int i = 0; i < OrdenaPesquisa.NOME_ARQUIVO.length; i++) {
			itens = new ListaContig(OrdenaPesquisa.NOME_ARQUIVO[i]); //cria a lista do tamanho desejado
			for (int j = 0; j < TIPO_ARQUIVO.length; j++) {
				lerArquivo(OrdenaPesquisa.NOME_ARQUIVO[i], OrdenaPesquisa.TIPO_ARQUIVO[j]); // 1
				gravarArquivo(itens.quicksortRegistro(), OrdenaPesquisa.NOME_ARQUIVO[i], OrdenaPesquisa.TIPO_ARQUIVO[j]); //2
				itens.zeraLista(); //3
			}
		}
	}
	
	public void lerOrdenadosQuick(){
		for (int i = 0; i < OrdenaPesquisa.NOME_ARQUIVO.length; i++) {
			itens = new ListaContig(OrdenaPesquisa.NOME_ARQUIVO[i]); //cria a lista do tamanho desejado
			for (int j = 0; j < TIPO_ARQUIVO.length; j++) {
				System.out.println("lendo Arquivo "+OrdenaPesquisa.NOME_ARQUIVO[i]+OrdenaPesquisa.TIPO_ARQUIVO[j]+OrdenaPesquisa.ORDERNADO);
				lerArquivo(OrdenaPesquisa.NOME_ARQUIVO[i], OrdenaPesquisa.TIPO_ARQUIVO[j], OrdenaPesquisa.ORDERNADO);
				
				itens.zeraLista();
			}
		}
	}
	
	/*
	 * o nome do metodo diz tudo.
	 */
	public void lerArquivo(Integer nome, String tipo){
		lerArquivo(nome, tipo, "");
	}
	public void lerArquivo(Integer nome, String tipo, String ordenado){
		 
		String caminhoArquivo = "src/arquivos_de_teste/cliente"+nome+tipo+ordenado+".txt";//camminnho relativo
		path = Paths.get(caminhoArquivo); // cria o caminho absoluto baseado no relativo( acho que e isso)
		
		try(BufferedReader reader = Files.newBufferedReader(path, cs)){
			String line = null;
			while((line = reader.readLine()) != null){
				try {
					String[] tokens = line.split(";");
//					for (int i = 0; i < tokens.length; i++) {
						String cpf = tokens[0];
						String name = tokens[1];
						String data = tokens[2];
						String valor = tokens[3];
						
						
						boolean flag = itens.inserirUltimo(new Registro(cpf,name,data,valor));
						//inicio Debug da flag.
						if(!flag){
							System.err.println("erro na flag inserirUltimo");
							flag = !flag;
						}
						else{
//							System.out.print(tokens[i] + " | ");
							//fim Debug da flag.
						}
//					}
				} catch (Exception e) {
					System.out.println("Erro no tokens");
				}
				
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		System.out.println("\nok lerArquivo -> "+caminhoArquivo); //Debug.
	}

	/*
	 * O nome do metodo diz tudo.
	 * A ideia do Parametro "Item[] items" e para que possa ser chamado um método de ordenação qualquer 
	 * que retorne este tipo de Objeto(todos os métodos de ordenação que criaremoos podem retornar este tipo)
	 * então este método de gravar pode ser usado para gravar todos os seus resultados!
	 */
	public void gravarArquivo(Item[] items, Integer nome, String tipo){
		String caminhoArquivo = "src/arquivos_gravados/cliente"+nome+tipo+OrdenaPesquisa.ORDERNADO+".txt";
		path = Paths.get(caminhoArquivo);
		try(BufferedWriter w = Files.newBufferedWriter(path, cs)) { /* recebe o path e a codificação*/
			for (int i = 0; i < items.length; i++) {
//				if(i == items.length-1){
					w.write(items[i].toString()+"\n");					
//				}else{
//					w.write(items[i].getChave()+"; ");// guarda na memoria os caracteres para serem escritos no arquivo.
//				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("ok gravarArquivo -> "+nome+tipo+"Ordenado.txt");//Debug.
		
	}

}

