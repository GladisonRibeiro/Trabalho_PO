package programas;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

import classesAuxiliares.IoFiles;
import dados.Item;
import dados.Registro;
import estruturas.ListaContig;

public class OrdenaPesquisaComScanner {

	public static  final Integer[] NOME_ARQUIVO = {500, 1000, 5000, 10000, 50000};
	public static final String[] TIPO_ARQUIVO = {"alea", "inv", "ord"};
	private static final String ORDERNADO = "Ordenado";
	private Long tempoInicial, tempoFinal;

	Path path;
//	Charset cs = StandardCharsets.UTF_8;
	Charset cs = Charset.defaultCharset();
	ListaContig itens;
	
	public OrdenaPesquisaComScanner() {
		super();
		fazTudo();
	}

	private void fazTudo(){
		tempoInicial = System.nanoTime();
		leOrdenaQuickGrava();
		System.out.println("\nentre os métodos lerOrdenaquickGrava e lerOrdenadosQuick\n");
//		lerOrdenadosQuick();
		tempoFinal = System.nanoTime();
		System.out.println("\n\tTempo decorido : "+(tempoFinal - tempoInicial) + " nano-Segundos");
	}
	
	public void leOrdenaQuickGrava() {		 

		for (int i = 0; i < OrdenaPesquisaComScanner.NOME_ARQUIVO.length; i++) {
			itens = new ListaContig(OrdenaPesquisaComScanner.NOME_ARQUIVO[i]);
			for (int j = 0; j < TIPO_ARQUIVO.length; j++) {
				lerArquivo(OrdenaPesquisaComScanner.NOME_ARQUIVO[i], OrdenaPesquisaComScanner.TIPO_ARQUIVO[j]);
				gravarArquivo(itens.quicksortRegistro(), OrdenaPesquisaComScanner.NOME_ARQUIVO[i], OrdenaPesquisaComScanner.TIPO_ARQUIVO[j]);
				itens.zeraLista(); //3
			}
		}
	}
	
	public void lerOrdenadosQuick(){
		for (int i = 0; i < OrdenaPesquisaComScanner.NOME_ARQUIVO.length; i++) {
			itens = new ListaContig(OrdenaPesquisaComScanner.NOME_ARQUIVO[i]); //cria a lista do tamanho desejado
			for (int j = 0; j < TIPO_ARQUIVO.length; j++) {
				System.out.println("lendo Arquivo "+OrdenaPesquisaComScanner.NOME_ARQUIVO[i]+OrdenaPesquisaComScanner.TIPO_ARQUIVO[j]+OrdenaPesquisaComScanner.ORDERNADO);
				lerArquivo(OrdenaPesquisaComScanner.NOME_ARQUIVO[i], OrdenaPesquisaComScanner.TIPO_ARQUIVO[j], OrdenaPesquisaComScanner.ORDERNADO);
				
				itens.zeraLista();
			}
		}
	}
	
	public void lerArquivo(Integer nome, String tipo){
		lerArquivo(nome, tipo, "");
	}
	public void lerArquivo(Integer nome, String tipo, String ordenado){
		String caminhoArquivo = "src\\arquivos_de_teste\\cliente"+nome+tipo+ordenado+".txt";
		try {
			String[] arquivo = IoFiles.lerArquivo(nome, caminhoArquivo);
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

	public void gravarArquivo(Item[] items, Integer nome, String tipo){
		String caminhoArquivo = "src/arquivos_gravados/cliente"+nome+tipo+OrdenaPesquisaComScanner.ORDERNADO+".txt";
		path = Paths.get(caminhoArquivo);
		IoFiles.gravarArquivo(items, caminhoArquivo);
		System.out.println("ok gravarArquivo -> "+nome+tipo+"Ordenado.txt");//Debug.
		
	}

}

