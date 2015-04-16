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
import estruturas.ListaContig;
import estruturas.ListaDupla;

public class OrdenaPesquisa {

	private static  final Integer[] NOME_ARQUIVO = {20};
	private static final String[] TIPO_ARQUIVO = {"OrdAsc", "OrdDesc", "DesOrd"};
	
	private Long tempoInicial, tempoFinal;


	Path path;
	Charset cs = StandardCharsets.UTF_8;
	ListaContig itens;
	
	public OrdenaPesquisa() {
		super();
		fazTudo();
	}
	
	private void fazTudo(){
		tempoInicial = System.nanoTime();
		
		for (int i = 0; i < NOME_ARQUIVO.length; i++) {
			itens = new ListaContig(this.NOME_ARQUIVO[i]); //cria a lista do tamanho desejado
			for (int j = 0; j < TIPO_ARQUIVO.length; j++) {
				lerArquivo(NOME_ARQUIVO[i], TIPO_ARQUIVO[j]);
				gravarArquivo(itens.quicksort(), NOME_ARQUIVO[i], TIPO_ARQUIVO[j]);
				itens.zeraLista();
			}
		}
		
		tempoFinal = System.nanoTime();
		
		System.out.println("Tempo decorido : "+(tempoFinal - tempoInicial) + " nano-Segundos");
		
		
	}
	
	public void lerArquivo(Integer nome, String tipo){
		String caminhoArquivo = "C:/Users/gladison/workspace/Trabalho_PO/src/arquivos/"+nome+tipo+".txt";
		System.out.println(caminhoArquivo);
		
		/* Leitura em arquivo de caracteres |"c:/xti/files/texto.txt"|  */
		path = Paths.get(caminhoArquivo);
		
		try(BufferedReader reader = Files.newBufferedReader(path, cs)){
			String line = null;
			while((line = reader.readLine()) != null){
				String[] tokens = line.split(";");
				for (int i = 0; i < tokens.length; i++) {
					boolean flag = itens.inserirUltimo(new Item(Integer.parseInt(tokens[i])));
					if(!flag){
						System.out.println("erro na flag inserirUltimo");
						flag = !flag;
					}
					else
						System.out.print(tokens[i] + " | ");
				}
//				System.out.println(line);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("ok lerArquivo");
	}

	public void gravarArquivo(Item[] items, Integer nome, String tipo){
		String caminhoArquivo = "C:/Users/gladison/workspace/Trabalho_PO/src/arquivos/"+nome+tipo+"Ordenado.txt";
		System.out.println(caminhoArquivo);
		path = Paths.get(caminhoArquivo);
		try(BufferedWriter w = Files.newBufferedWriter(path, cs)) { /* recebe o path e a codificação*/
			for (int i = 0; i < items.length; i++) {
				w.write(items[i].getChave()+"; ");// guarda na memoria os caracteres para serem escritos no arquivo	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("ok gravarArquivo");
		
	}

}

