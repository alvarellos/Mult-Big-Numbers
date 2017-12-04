package multiplica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.StringTokenizer;


/**
 * @author Diego Díaz
 * Clase principal de la multiplicación de grandes
 * números. Incluye métodos y argumentos
 * de Entrada Salida
 */
public class Principal {

	static boolean num2_negativo;
	static boolean num1_negativo;
	
	public static void ayuda(){
		 System.out.println("SINTAXIS:");
		 System.out.println("multiplica [-t][-h] [fichero_entrada] [fichero_salida]");
		 System.out.println("-t                  Traza");
		 System.out.println("-h                  Muestra esta ayuda");
		 System.out.println("fichero_entrada     Nombre fichero de entrada");
		 System.out.println("fichero_salida      Nombre fichero de salida");
	}
	
	public static void ficheroEntrada(String argv, Boolean Traza) throws IOException{
		try {
			// Creamos nuevos numeros
			BigInt Numero1 = new BigInt();
			BigInt Numero2 = new BigInt();
			
			// Alimentamos el problema con los datos de la entrada
			Entrada entrada = new Entrada(argv);
			
			// Se eliminan los saltos de línea que se sustituyen por espacio en blanco
			String text = entrada.readFile(argv, Charset.defaultCharset());
			text = text.replaceAll(System.getProperty("line.separator"), " ");
			
			// Control de signo de los numeros
			if (text.startsWith("-")) {
				text = text.replaceFirst("-", " ");
				num1_negativo = true;
			}
			
			if (text.contains("-")){
					text = text.replace("-", " ");
					num2_negativo = true;
			
				
			text = text.replace("-", "");
			} // Fin control signo


			try  {

				//String linea = entrada.leeLinea();

					// Divide la entrada en tokens separados por espacio
					StringTokenizer tokens = new StringTokenizer(text, " ");
					
					// Se crea un array de String (cada posición de array representa un numero)
					int nDatos = tokens.countTokens();						
					String[] datos = new String[nDatos];
					int j=0;
					// Se introducen los valores en el array
					while (tokens.hasMoreTokens()){
						String str = tokens.nextToken();
						// Se separan los dígitos de la cadena
						datos[j] = str.replaceAll(".(?=.)", "$0 ");
						j++;
					}
					// Se eligen los dos primeros números del array
					Numero1 = new BigInt(datos[0]);
					Numero2 = new BigInt(datos[1]);

		
			} catch ( Exception e ) {
				System.err.println("Error en la lectura del fichero de entrada");
			}
			entrada.cierra();

			// Resuelve el problema
			
			if ( Traza == true ){
			  	BigInt resultado = Algoritmo.kO(Numero1, Numero2, true); // con traza
			  	
				// Imprimimos los resultados
				System.out.println();
			  	System.out.println(" MULTIPLICACION ");
			  	if (num1_negativo == true){
			  		Numero1.print(true);
			  	}
			  	else {
				  	Numero1.print(false);
			  	}

			  	System.out.println(" X ");
			  	
			  	if (num2_negativo == true){
			  		Numero2.print(true);
			  	}
			  	else {
				  	Numero2.print(false);
			  	}

				System.out.println();
				
				if ((num1_negativo && num2_negativo) | (!num1_negativo && !num2_negativo)){
					resultado.print(false);
				}
				else{
					resultado.print(true);
				}
				// Fin imprimir resultados
			}
			else {
			  	BigInt resultado = Algoritmo.kO(Numero1, Numero2, false); // Sin traza
				// Imprimimos los resultados
				System.out.println();
			  	System.out.println(" MULTIPLICACION ");
			  	if (num1_negativo == true){
			  		Numero1.print(true);
			  	}
			  	else {
				  	Numero1.print(false);
			  	}

			  	System.out.println(" X ");
			  	
			  	if (num2_negativo == true){
			  		Numero2.print(true);
			  	}
			  	else {
				  	Numero2.print(false);
			  	}

				System.out.println();
				
				if ((num1_negativo && num2_negativo) | (!num1_negativo && !num2_negativo)){
					resultado.print(false);
				}
				else{
					resultado.print(true);
				}
				// Fin imprimir resultados
			}

		} catch (FileNotFoundException e) {
			System.err.println("Error: no se ha podido abrir el fichero indicado "+ argv);
		}
	}
	
	public static void ficheroIO(String arg1, String arg2, Boolean Traza) throws IOException{
		try {
			// Creamos nuevos numeros
			BigInt Numero1 = new BigInt();
			BigInt Numero2 = new BigInt();
			Boolean negativo;
			
			// Alimentamos el problema con los datos de la entrada
			Entrada entrada = new Entrada(arg1);
			
			// Se eliminan los saltos de línea que se sustituyen por espacio en blanco
			String text = entrada.readFile(arg1, Charset.defaultCharset());
			text = text.replaceAll(System.getProperty("line.separator"), " ");
			
			// Control de signo de los numeros
			if (text.startsWith("-")) {
				text = text.replaceFirst("-", " ");
				num1_negativo = true;
			}
			
			if (text.contains("-")){
					text = text.replace("-", " ");
					num2_negativo = true;
			
				
			text = text.replace("-", "");
			}
			
			try  {

				//String linea = entrada.leeLinea();

					// Divide la entrada en tokens separados por espacio
					StringTokenizer tokens = new StringTokenizer(text, " ");
					
					// Se crea un array de String (cada posición de array representa un numero)
					int nDatos = tokens.countTokens();						
					String[] datos = new String[nDatos];
					int j=0;
					// Se introducen los valores en el array
					while (tokens.hasMoreTokens()){
						String str = tokens.nextToken();
						// Se separan los dígitos de la cadena
						datos[j] = str.replaceAll(".(?=.)", "$0 ");
						j++;
					}
					// Se eligen los dos primeros números del array
					Numero1 = new BigInt(datos[0]);
					Numero2 = new BigInt(datos[1]);

		
			} catch ( Exception e ) {
				System.err.println("Error en la lectura del fichero de entrada");
			}
			entrada.cierra();

			// Resuelve el problema
			if (Traza == true){
			  	BigInt resultado = Algoritmo.kO(Numero1, Numero2, true); // con traza
			  	
				if ((num1_negativo && num2_negativo) | (!num1_negativo && !num2_negativo)){
					negativo = false;
				}
				else{
					negativo = true;
				}
				// Fin imprimir resultados
				
			  	// Imprimimos los resultados en fichero	
				// SALIDA
				try{
	 			    PrintWriter writer = new PrintWriter(arg2, "UTF-8");
	 			    
	 			    // -------------------------------------------------------
	 			    int len = resultado.length();
	 			    if(len == 0) {
	 			      writer.println("0");
	 			      // return null;
	 			    }
	 			    // Si es negativo
	 			    if (negativo == true){
	 			    	writer.print("-");
	 			    }
	 			    // -------------------
	 			    for(int i1 = len - 1; i1 >= 0; i1--) {
	 			      String zfill = "";
	 			      for(int j = 1 - 1; j > 0; j--) {
	 			        if(resultado.getDigito(i1).value() < (long)Math.pow(10, j)) {
	 			          if(i1 < len - 1)
	 			            zfill += "0";
	 			        }
	 			        else break;
	 			      }
	 			      writer.print(zfill + resultado.getDigito(i1).value());
	 			    }
	 			    writer.println("\n");
	 			    writer.close(); 			    
	 			    // -------------------------------------------------------

	 			    
	 			} catch (Exception e) {
	 				System.err.println("Ha fallado el proceso de escritura en el fichero "+ arg2);
	 			}
				// FIN SALIDA
			}
			
			else {
			  	BigInt resultado = Algoritmo.kO(Numero1, Numero2, false); // Sin traza
			  	
				if ((num1_negativo && num2_negativo) | (!num1_negativo && !num2_negativo)){
					negativo = false;
				}
				else{
					negativo = true;
				}
				
			  	// Imprimimos los resultados		
				// SALIDA
				try{
	 			    PrintWriter writer = new PrintWriter(arg2, "UTF-8");
	 			    
	 			    // -------------------------------------------------------
	 			    int len = resultado.length();
	 			    if(len == 0) {
	 			      writer.println("0");
	 			      // return null;
	 			    }
	 			    // Si es negativo
	 			    if (negativo == true){
	 			    	writer.print("-");
	 			    }
	 			    // -------------------
	 			    for(int i1 = len - 1; i1 >= 0; i1--) {
	 			      String zfill = "";
	 			      for(int j = 1 - 1; j > 0; j--) {
	 			        if(resultado.getDigito(i1).value() < (long)Math.pow(10, j)) {
	 			          if(i1 < len - 1)
	 			            zfill += "0";
	 			        }
	 			        else break;
	 			      }
	 			      writer.print(zfill + resultado.getDigito(i1).value());
	 			    }
	 			    writer.println("\n");
	 			    writer.close(); 			    
	 			    // -------------------------------------------------------

	 			    
	 			} catch (Exception e) {
	 				System.err.println("Ha fallado el proceso de escritura en el fichero "+ arg2);
	 			}
				// FIN SALIDA
			}


		} catch (FileNotFoundException e) {
			System.err.println("Error: no se ha podido abrir el fichero indicado "+ arg1);
		}
	}
  
	
	// ***************     METODO PRINCIPAL        ********************
	// ----------------------------------------------------------------
	
  public static void main(String[] argv) throws IOException {
	  
	  
	  // CON UN ARGUMENTO
	  // ------------------------------------------------------------------
	 if ( argv.length == 1 ) { 
	 for (int i=0; i<argv.length; i++){
		 switch(argv[i]){
		 case "-h":{
			 	ayuda();
			 break;
		 }
		 case "-t":{

			    // Traza ejemplo enunciado
			 
 			  	BigInt a = new BigInt("4 7 2 8 4 7 4 5 7 7 6 7 4 6 1 6 1 6 1 8 3 9 3 0 3 4 9 5 7 5 6 4 5 3 5 2 4 2 6 2 7 3 7 3 7 3 7 3 6 2 7 2 8 2 7 3 6 7 3 8 2 7 2 6 3 6 4 7 8 4 5 8 5 7 4 6 3 8 3 6 4 7 4 3 7");
			  	BigInt b = new BigInt("1 3 1 4 2 6 3 5 2 4 2 6 2 6 2 5 3 6 7 3 7 4 8 5 8 6 9 7 0 6 9 5 6 5 6 4 5 3 5 2 4 1 2 3 1 3 1 4 2 5 3 6 4 7 5 8 6 9 6 9 6 8 5 7 4 6 3 4 5 3 5 4 2 3 5 3 5 4 7 5 8 6 9 4 5 7 3 6 2 6 1 8 1 9 1 7 2 6 3 6 3 7 2 7 2 5 2 4 2 4 2 5 3 7 3 8");
	

			  	BigInt resultado = Algoritmo.kO(a, b, true);

			  	System.out.println("Multiplicación ");
			  	a.print(false);
			  	System.out.println(" x ");
			  	b.print(false);
			  	System.out.println(" = ");
			  	resultado.print(false);

				 break;
		 }

		 default:{
			 	ficheroEntrada(argv[0], false);
			 break;
		 }
		 }

	 }
	 }

	  // CON DOS ARGUMENTOS
	  // ------------------------------------------------------------------
	 else if ( argv.length == 2 ) { 

		 		if (argv[0].equals("-h") || argv[1].equals("-h")) {
			 		// [-h] [*]  | [*][-h]
		 			ayuda();
		 		}
		 		
		 		else if (argv[0].equals("-t")){
			 		// [-t] [fichero de entrada]
		 			ficheroEntrada(argv[1], true);
		 		}
		 		
		 		else if (argv[1].equals("-t")){
			 		// [fichero de entrada] [-t] 
		 			ficheroEntrada(argv[0], true);
		 		}
		 		
		 		else {
		 			// [fichero_entrada] [fichero_salida]
		 			ficheroIO(argv[0], argv[1], false);
		 		}
	 }

	 // CON TRES ARGUMENTOS
	 // ------------------------------------------------------------------	 
	 else if ( argv.length == 3 ) {
		 
		 
		 if (argv[0].equals("-h") || argv[1].equals("-h") || argv[2].equals("-h")) {
			 // [-h][*][*] | [*][-h][*] | [*][*][-h]
			 ayuda();
		 }
		 
		 else if (argv[0].equals("-t")) {
			// [-t] [fichero entrada] [fichero salida]
			 ficheroIO(argv[1], argv[2], true); 
		 }
		 
		 else if (argv[1].equals("-t")) {
			// [fichero entrada] [-t] [fichero salida]
			 ficheroIO(argv[0], argv[2], true); 
		 }
		 
		 else if (argv[2].equals("-t")) {
			// [fichero entrada] [fichero salida] [-t]
			 ficheroIO(argv[0], argv[1], true); 
		 }
		 
		 else {
			 System.out.println("Los argumentos no son correctos");
		 }
	 }
	 
	 // CON 4 ARGUMENTOS (sólo sale la ayuda)
	 // ------------------------------------------------------------------		 
	 else if ( argv.length == 4 ) {
		 if (argv[0].equals("-h") || argv[1].equals("-h") || argv[2].equals("-h") || argv[3].equals("-h")) {
			 // [-h][*][*][*] | [*][-h][*][*] | [*][*][-h][*] | [*][*][*][-h]
			 ayuda();
		 }
		 else {
			 System.out.println("Los argumentos no son correctos");
		 }
	 }
	 

	 // CON MÁS DE 4 ARGUMENTOS
	 // ------------------------------------------------------------------	 	 
	 else if ( argv.length > 4 ) {
		 System.out.println("No se ha introducido un número de argumentos válido");
	 }

	 // SIN ARGUMENTOS
	 // ------------------------------------------------------------------	 
	 else{
		  	// Con números negativos solamente funciona desde el fichero
		 	// -----------------------------------
		  	String cadena = "4728474577674616161839303495756453524262737373736272827367382726364784585746383647437";
		  	
		  	// Cambia todos los caracteres excepto el último con el mismo caracter 
		  	// seguido por un espacio
		  	String conFormatoCorrecto = cadena.replaceAll(".(?=.)", "$0 ");
		  	
		  	BigInt c = new BigInt("1 3 1 4 2 6 3 5 2 4 2 6 2 6 2 5 3 6 7 3 7 4 8 5 8 6 9 7 0 6 9 5 6 5 6 4 5 3 5 2 4 1 2 3 1 3 1 4 2 5 3 6 4 7 5 8 6 9 6 9 6 8 5 7 4 6 3 4 5 3 5 4 2 3 5 3 5 4 7 5 8 6 9 4 5 7 3 6 2 6 1 8 1 9 1 7 2 6 3 6 3 7 2 7 2 5 2 4 2 4 2 5 3 7 3 8");
		  	BigInt d = new BigInt(conFormatoCorrecto);
		  	
		  	
		  	BigInt resultado = Algoritmo.kO(c, d, false);
		  	System.out.println("Este es resultado de ejemplo del enunciado");
		  	System.out.println("------------------------------------------");
		  	System.out.println("" );
		  	c.print(false);
		  	System.out.println(" X " );
		  	d.print(false);
		  	System.out.println(" = ");
		  	resultado.print(false);
		 
	 }
	  	
  }
	
}
