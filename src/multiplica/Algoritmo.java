package multiplica;


/**
 * @author Diego Díaz
 * Clase en la que se implementa el algoritmo Divide y vencerás con 
 * el método de multiplicación de Karatsuba Ofman
 */
public class Algoritmo {

	  // Divide y Vencerás / Multiplicación de Karatsuba Ofman
	  public static BigInt kO(BigInt A, BigInt B, Boolean Traza) {
		  	
		  
		  if ( Traza == true){
			  
			 // Con la Traza activada
			  
		  	int n = Math.max(A.length(), B.length());

		  	// BASE
		  	if (n < 2) {
		  		System.out.println("***** Caso base");
		  		DigitoAcarreo dc = DigitoAcarreo.mulDigitos(A.getDigito(0), B.getDigito(0));
		  		BigInt result = new BigInt(2);
		  		result.setDigito(0, dc.digito());
		  		result.setDigito(1, dc.acarreo());
		  		
		  	    // Se activa la Traza 
		  		System.out.println("     digitos " + A.value() + "," + B.value());

		  		if (result.length() > 1){
			  		System.out.println("     [Acarreo][Digito] = " + result.value());
			  		//result.print(false);
		  		}
		  		else {
			  		System.out.println("     [Acarreo][Digito] = 0" + result.value());
			  		//result.print(false);
		  		}
		  		// Fin de la traza
		  		System.out.println("***** Fin caso base");
		  		
		  		return result;	
		  	}
		  	
		  	// DIVIDE
		  	int menor = n/2 -1;
			int mayor = menor +1;
			
			
			BigInt a0 = A.divide(0, menor);
			BigInt a1 = A.divide(mayor, n-1);

			BigInt b0 = B.divide(0, menor);
			BigInt b1 = B.divide(mayor, n-1);
			
	  	    // Se activa la Traza
			System.out.println("*** Divide ");
			System.out.print("    ");
	  		a0.print(false);
			System.out.print("    ");
	  		a1.print(false);
			System.out.print("    ");
	  		b0.print(false);
			System.out.print("    ");
	  		b1.print(false);
			System.out.println("*** Fin del Divide");

	  		// Fin de la traza
			
			// COMBINA
			System.out.println(" Combina");
			System.out.println(" LLamada recursiva para cálculo de A ");
			BigInt l = kO(a0, b0, true);
			l.print(false);
			System.out.println(" Fin llamada recursiva para cálculo de A");
			System.out.println("");
			System.out.println(" Llamada recursiva para cálculo de C");
			BigInt h = kO(a1, b1, true);
			h.print(false);
			System.out.println(" Fin llamada recursiva para cálculo de C");
			System.out.println("");


			System.out.println(" Llamada recursiva para cálculo de B");
			BigInt a = suma(a0, a1);
			BigInt b = suma(b0, b1);
			BigInt hplusl = suma(h, l);
			BigInt m = resta(kO(a, b, true), hplusl);
			m.print(false);
			System.out.println(" Fin llamada recursiva para cálculo de B");
			
			m.addCeros(menor + 1);
			h.addCeros(2*(menor + 1));

			System.out.println(" **** Subsolución Concatena (C,B,A) ****");
			BigInt result = suma(l, (suma(m, h)));
			result.print(false);
			System.out.println(" **** Fin Concatena (C,B,A) ****");
			
			return result;
		  } // Fin de algoritmo con Traza
		  
		  else{
			  // Sin traza
			  	int n = Math.max(A.length(), B.length());

			  	// BASE
			  	if (n < 2) {

			  		DigitoAcarreo dc = DigitoAcarreo.mulDigitos(A.getDigito(0), B.getDigito(0));
			  		BigInt result = new BigInt(2);
			  		result.setDigito(0, dc.digito());
			  		result.setDigito(1, dc.acarreo());
			  				  		
			  		return result;
			  	}
			  	
			  	// DIVIDE
			  	int menor = n/2 -1;
				int mayor = menor +1;
				
				
				BigInt a0 = A.divide(0, menor);
				BigInt a1 = A.divide(mayor, n-1);

				BigInt b0 = B.divide(0, menor);
				BigInt b1 = B.divide(mayor, n-1);
				
		  		// Fin de la traza
				
				// COMBINA

				BigInt l = kO(a0, b0, false);
				BigInt h = kO(a1, b1, false);

				BigInt a = suma(a0, a1);
				BigInt b = suma(b0, b1);
				BigInt hplusl = suma(h, l);
				BigInt m = resta(kO(a, b, false), hplusl);
				
				m.addCeros(menor + 1);
				h.addCeros(2*(menor + 1));

				BigInt result = suma(l, (suma(m, h)));
				
				return result;			  
		  }
		  	  
	  }
	  
	  
	  public static BigInt suma(BigInt A, BigInt B) {
			
			int longRes = Math.max(A.length(), B.length())+1;
			
			BigInt resultado = new BigInt(longRes);
			DigitoAcarreo dac = new DigitoAcarreo();
			
			for (int i = 0; i < longRes; i++) {
				Natural digitoA = A.getDigito(i);
				Natural digitoB = B.getDigito(i);
				dac = DigitoAcarreo.sumaDigitos(digitoA, digitoB, dac.acarreo());
				resultado.setDigito(i, dac.digito()); 	
			}
			return resultado;  	  
	  }
	  
	  public static BigInt resta(BigInt A, BigInt B) {
			
			int longRes = Math.max(A.length(), B.length())+1;
					
			BigInt resultado = new BigInt(longRes);			
			DigitoAcarreo dac = new DigitoAcarreo();

			for (int i = 0; i < longRes; i++) {
				Natural digitoA = A.getDigito(i);
				Natural digitoB = B.getDigito(i);
				dac = DigitoAcarreo.restaDigitos(digitoA, digitoB, dac.acarreo());
				resultado.setDigito(i, dac.digito()); 	
			}
			 
			return resultado;
	  }
}
