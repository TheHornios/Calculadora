package calculadora.logica;


public class Operaciones{

	/**
	 * Suma dos números.
	 * 
	 * @param a el primer número.
	 * @param b el segundo número.
	 * @return la suma de a y b.
	 */
	public double sumar(double a, double b) {
        return a + b;
    }
	

	/**
	 * Resta dos números.
	 * 
	 * @param a el número al que se le restará.
	 * @param b el número que se restará a a.
	 * @return el resultado de a - b.
	 */
	public double restar(double a, double b) {
        return a - b;
    }
	
	/**
	 * Multiplica dos números.
	 * 
	 * @param a el primer número.
	 * @param b el segundo número.
	 * @return el producto de a y b.
	 */
	public double multiplicar(double a, double b) {
        return a * b;
    }
	
	/**
	 * Divide dos números.
	 * 
	 * @param a el dividendo.
	 * @param b el divisor. No debe ser cero.
	 * @return el resultado de dividir a entre b.
	 * @throws ArithmeticException si b es igual a 0, ya que no se puede dividir entre cero.
	 */
	public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("División por cero no permitida");
        }
        return a / b;
    }
}
