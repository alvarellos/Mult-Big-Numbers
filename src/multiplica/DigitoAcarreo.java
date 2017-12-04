package multiplica;

/**
 * @author Diego Díaz
 * Clase dígito (digit) y acarreo (carry)
 * con los métodos de operaciones aritméticas
 */
public class DigitoAcarreo {

	private Natural digito = new Natural(0);
	private Natural acarreo = new Natural(0);

	public Natural digito() {
		return digito;
	}
	
	public Natural acarreo() {
		return acarreo;
	}

	// Constructor
	
	public DigitoAcarreo() {
		super();
	}

	// Métodos (suma, resta y multiplicación)
	
	/**
	 * @param a digito 1
	 * @param b digito 2
	 * @param c acarreo
	 * @return digito/acarreo
	 */
	public static DigitoAcarreo sumaDigitos(Natural a, Natural b, Natural c) {
	    long sum = a.value() + b.value() + c.value();
	    DigitoAcarreo dac = new DigitoAcarreo();
	    dac.digito(sum % BigInt.base);
	    dac.acarreo(sum / BigInt.base);
		    return dac;
		  }
	  
	/**
	 * @param a digito1
	 * @param b digito2
	 * @param c acarreo
	 * @return digito/acarreo
	 */
	public static DigitoAcarreo restaDigitos(Natural a, Natural b, Natural c) {
		DigitoAcarreo dac = new DigitoAcarreo();
		long sum;
		if(a.value() >= (b.value() + c.value())) {
			sum = a.value() - (b.value() + c.value());
		    dac.digito(sum % BigInt.base);
		    dac.acarreo(sum / BigInt.base);
		}
		else {
			sum = (BigInt.base + a.value()) - (b.value() + c.value());
		    dac.digito(sum);
		    dac.acarreo(1);
		    }
		    return dac;
		  }
		  
	/**
	 * @param a digito1
	 * @param b digito2
	 * @return digito/acarreo
	 */
	public static DigitoAcarreo mulDigitos(Natural a, Natural b) {
		long prod = a.value() * b.value();
		DigitoAcarreo dac = new DigitoAcarreo();
		dac.digito(prod % BigInt.base);
		dac.acarreo(prod / BigInt.base);
		return dac;
  }
	


	// Digito
	public void digito(long d) {
		digito.setValue(d);
	}

	public void digito(int d) {
		digito.setValue(d);
	}
  
	// Acarreo
	public void acarreo(int a) {
		acarreo.setValue(a);
	}
  
	public void acarreo(long a) {
		acarreo.setValue(a);
	}
}
