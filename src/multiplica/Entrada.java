package multiplica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Entrada {
    private FileReader fr = null;
    private BufferedReader br = null;
	
	public Entrada ( String filename ) throws FileNotFoundException {
		File archivo = new File (filename);
		this.fr = new FileReader (archivo);
		this.br = new BufferedReader(this.fr);
	}
	
	// Lee el fichero como un String
	public String readFile(String path, Charset encoding) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}
	
	public String leeLinea() throws IOException { 
		String linea= null;
		try {
			linea=this.br.readLine();
		} catch (IOException e) {
			throw (e);
		}
		return linea;			
	}

	public void cierra () {
		try{                    
			if( null != this.fr ){   
				this.fr.close();
			}
         } catch (Exception e){ 
        	 e.printStackTrace();
         }
	}
}
