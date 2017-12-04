package multiplica;

/**
 * @author Diego Díaz
 * Clase que representa
 * números naturales / números enteros sin signo
 */
public class Natural {

	private long natural = 0;
	  
	  public Natural(int n) {
	    setValue(n); 
	  }
	  public Natural(long n) {
	    setValue(n);
	  }
	  
	  public long value() {
	    return longValue();
	  }
	  public int intValue() {
	    return (int) natural;
	  }
	  public void setValue(int n) {
	    natural = n & 0xFFFFFFFFL;
	  }
	  public void setValue(long n) {
	    if(n >= 0) 
	      natural = n;
	    else
	      System.err.println("Representacion incorrecta del numero entero sin signo");
	  }
	  public void setValue(Natural n) {
	    natural = n.value(); 
	  }
	  public long longValue() {
	    return natural;
	  }

	  public double doubleValue() {
	    System.err.println("Representacion incorrecta del numero entero sin signo");
	    return 0;
	  }
	  public float floatValue() {
	    System.err.println("Representacion incorrecta del numero entero sin signo");
	    return 0;
	  }
	
}
