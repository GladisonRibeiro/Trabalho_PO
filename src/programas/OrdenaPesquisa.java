package programas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import dados.Item;
import estruturas.ListaDupla;

public class OrdenaPesquisa {

	private static  final String[] NOME_ARQUIVO = {"20"};
	private static final String[] TIPO_ARQUIVO = {"OrdAsc", "OrdDesc", "DesOrd"};


	Path path;
	Charset cs = StandardCharsets.UTF_8;
	
	
	private ListaDupla itens;
	
	public OrdenaPesquisa() {
		super();
		itens = new ListaDupla();
		fazTudo();
	}
	
	private void zerarListaDupla(){
		itens.clearListaDupla();
	}
	
	private void fazTudo(){
		zerarListaDupla();
		for (int i = 0; i < NOME_ARQUIVO.length; i++) {
			for (int j = 0; j < TIPO_ARQUIVO.length; j++) {
				lerArquivo(NOME_ARQUIVO[i], TIPO_ARQUIVO[j]);
				gravarArquivo(itens.ordena(), NOME_ARQUIVO[i], TIPO_ARQUIVO[j]);
				itens.clearListaDupla();
			}
		}
		
	}
	
	public void lerArquivo(String nome, String tipo){
		String caminhoArquivo = "C:/Users/gladison/workspace/Trabalho_PO/src/arquivos/"+nome+tipo+".txt";
		System.out.println(caminhoArquivo);
		
		/* Leitura em arquivo de caracteres |"c:/xti/files/texto.txt"|  */
		path = Paths.get(caminhoArquivo);
		
		try(BufferedReader reader = Files.newBufferedReader(path, cs)){
			String line = null;
			while((line = reader.readLine()) != null){
				String[] tokens = line.split(";");
				for (int i = 0; i < tokens.length; i++) {
					itens.inserirPrimeiro(new Item(Integer.parseInt(tokens[i])));					
				}
//				System.out.println(line);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("ok lerArquivo");
	}

	public void gravarArquivo(String text, String nome, String tipo){
		String caminhoArquivo = "C:/Users/gladison/workspace/Trabalho_PO/src/arquivos/"+nome+tipo+"Ordenado.txt";
		System.out.println(caminhoArquivo);
		path = Paths.get(caminhoArquivo);
		try(BufferedWriter w = Files.newBufferedWriter(path, cs)) { /* recebe o path e a codificação*/
			
			w.write(text);// guarda na memoria os caracteres para serem
								// escritos no arquivo
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("ok gravarArquivo");
		
	}

}

