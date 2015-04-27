package classesAuxiliares;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class IoFiles {

	public IoFiles() {
		super();
	}
	
	public static String[] lerArquivo(int tamanho, String caminho){
		 String[] result = new String[tamanho];
		try( Scanner s = new Scanner(new File(caminho)) ) {	
			int i = 0;
			while(s.hasNext()){
				String line = s.nextLine();
				result[i] = line;
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean gravarArquivo(String[] obj, String caminho){
		
		Charset cs = Charset.defaultCharset();
		Path path = Paths.get(caminho);
		try(BufferedWriter w = Files.newBufferedWriter(path, cs)) { 
			for (int i = 0; i < obj.length; i++) {
				if(obj[i] != null)
				w.write(obj[i]+"\n");					
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
