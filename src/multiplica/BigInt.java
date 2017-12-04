package multiplica;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;


/**
 * @author Diego Díaz
 * Clase que contiene el tipo de entero largo
 * y los métodos necesarios para su representación
 */
public class BigInt {
	// Declaraciones

	private static final int tamanyoDigito = 1; // longitud dígito (0-9)base10
	public static final int base = 10; // Base en la que estan representados los digitos
	public static final int maximo = 7000; // número máximo de dígitos
	
	private Vector<Natural> digitos = null; 
	public static Natural cero = new Natural(0);
	  
	  
	  // Constructores de la clase
	  
	public BigInt() { 
	    digitos = new Vector<Natural>();
	}
	  
	// Con entero
	public BigInt(int n) {
		digitos = new Vector<Natural>();
	}
	
	// Con una lista de dígitos
	public BigInt(List<Natural> ivals) {
		digitos = new Vector<Natural>(ivals);
	}
	  
	// Con digitos en una cadena
	public BigInt(String sval) { 
		digitos = new Vector<Natural>();
	    inputDigits(sval);
	}
	  

	  // ------------------------------------------
	  
	  /**
	 * @return El BigInt con los ceros añadidos al final (dcha)
	 * para mantener iguales el tamaño de dígitos
	 */
	public BigInt divide(int r, int s) {
	    assert((0 <= r) && (r <= s)); 
	    while(s + 1 >= digitos.size())
	      digitos.add(cero);
	    return new BigInt(digitos.subList(r, s + 1));
	  }
	  
	  public void setDigito(int index, Natural digit) {
	    assert(index < maximo);
	    assert(digit.value() < base);
	    if(index < digitos.size())
	      digitos.set(index, digit);
	    else
	      digitos.add(index, digit);
	  }
	  
	  public Natural getDigito(int index) {
	    assert(index < maximo);
	    if(index < digitos.size()) 
	      return digitos.get(index);
	    else
	      return cero;
	  }
	  

	  public int length() {
	    for(int i = digitos.size() - 1; i >= 0; i--) {
	      if(getDigito(i).value() == 0)
	        digitos.remove(i);
	      else break;
	    }
	    return digitos.size();
	  }
	  
	  /**
	 * añade una cantidad específica de ceros
	 * a la izquierda del vector de dígitos
	 * 
	 */
	public void addCeros(int n) {
	    assert(n >= 0);
	    for(int i = 0; i < n; i++) {
	      digitos.add(0, cero);
	    }
	  } 
 
	  public void addCeros(Natural n) {
	    this.addCeros(n.intValue());
	  }
	  
	  
	  /**
	 * Metodo de entrada del BigInt como una
	 * cadena de caracteres
	 */
	public void inputDigits(String numCadena) {
		digitos.clear(); // vacia vector
	    Vector<Natural> vEntrada = new Vector<Natural>();
	    // parseo de la cadena de caracteres 
	    // los tokens son los dígitos de entrada
	    Scanner scan = new Scanner(numCadena);
	    while(scan.hasNext()) {
	      try {
	        int n = scan.nextInt();
	        if(n >= base) {
	          System.err.println("El digito " + n + " no está en base " + base);
	          System.exit(1);
	        }
	        else if (n < 0){
	            System.err.println("El digito " + n + " es un numero negativo");
	            System.exit(1);
	        }
	        vEntrada.add(new Natural(n));
	      }
	      catch(InputMismatchException e) {
	        System.err.println("El símbolo introducido \"" + scan.next() + "\" no está entre 0 y 9" );
	        System.exit(1);
	      }
	    }
	    scan.close();

	    int cnt = vEntrada.size();
	    for(int i = 0; i < cnt; i++) {
	      setDigito(i, vEntrada.get(cnt - i - 1));
	    }
	    if(this.length() >= maximo / 2)
	      System.err.println("El cálculo con un número de longitud " + this.length() + " puede causar overflow");
	  }
	  
	  
	  /**
	 * Imprime BigInt como una cadena de caracteres
	 * Si es negativo introduce el símbolo
	 */
	public void print(Boolean negativo) {
	    int len = this.length();
	    if(len == 0) {
	      System.out.println("0");
	      return;
	    }
	    // Si es negativo
	    if (negativo == true){
	    	System.out.print("-");
	    }
	    // -------------------
	    for(int i = len - 1; i >= 0; i--) {
	      String numCero = "";
	      for(int j = tamanyoDigito - 1; j > 0; j--) {
	        if(getDigito(i).value() < (long)Math.pow(10, j)) {
	          if(i < len - 1)
	            numCero += "0";
	        }
	        else break;
	      }
	      System.out.print(numCero + getDigito(i).value());
	    }
	    System.out.print("\n");
		return;
	  }
	  

	  /**
	 * @return Imprime un BigInt como un String
	 * Solamente para resultados positivos
	 */
	public String print2() {
		    int len = this.length();
		    if(len == 0) {
		      System.out.println("0");
		      return null;
		    }
		    for(int i = len - 1; i >= 0; i--) {
		      String numCero = "";
		      for(int j = tamanyoDigito - 1; j > 0; j--) {
		        if(getDigito(i).value() < (long)Math.pow(10, j)) {
		          if(i < len - 1)
		            numCero += "0";
		        }
		        else break;
		      }
		      System.out.print(numCero + getDigito(i).value());
		    }
		    System.out.print("\n");
			return null;
		  }
	  
	  

	  /**
	 * @return Representa un BigInt como un tipo long
	 * se utiliza para imprimir la traza
	 * si se utilizan números demasiado grandes
	 * es mejor utilizar el metodo print2()
	 */
	public long value() {

	    long valor = 0;
	    int len = this.length();
	    	if (len>30){
	    		System.err.println("Para numeros tan grandes utiliza print2()");
	    		return 0;
	    	}
	    	else {
	    		for(int i = 0; i < len; i++) {
	    			valor += digitos.get(i).value() * (long)Math.pow(base, i);
	    		}
	    		return valor;
	    	}
	  }


}
