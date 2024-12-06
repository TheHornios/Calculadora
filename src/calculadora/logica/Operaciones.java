package calculadora.logica;


public class Operaciones{

	public double sumar(double a, double b) {
        return a + b;
    }
	
	public double restar(double a, double b) {
        return a - b;
    }
	
	public double multiplicar(double a, double b) {
        return a * b;
    }
	
	public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("División por cero no permitida");
        }
        return a / b;
    }
}
