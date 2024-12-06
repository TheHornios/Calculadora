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
	
	/**
	 * Calcula la raíz cuadrada de un número.
	 * 
	 * @param a el número del cual se desea obtener la raíz cuadrada.
	 *          Debe ser mayor o igual a 0.
	 * @return la raíz cuadrada de a.
	 * @throws ArithmeticException si a es negativo, ya que no se puede calcular
	 *                             la raíz cuadrada de un número negativo en el
	 *                             dominio de los números reales.
	 */
	public double raiz(double a) {
	    if (a < 0) {
	        throw new ArithmeticException("No se puede calcular la raíz cuadrada de un número negativo");
	    }
	    return Math.sqrt(a);
	}
	
	/**
	 * Resuelve una ecuación de segundo grado de la forma ax^2 + bx + c = 0.
	 * 
	 * @param a coeficiente cuadrático. No debe ser 0.
	 * @param b coeficiente lineal.
	 * @param c término independiente.
	 * @return un arreglo de doubles que contiene las soluciones. Puede tener:
	 *         - Dos soluciones reales (en caso de discriminante positivo).
	 *         - Una solución doble (en caso de discriminante igual a 0).
	 *         - Un arreglo vacío si las soluciones no son reales (discriminante negativo).
	 * @throws ArithmeticException si el coeficiente a es igual a 0, ya que no sería
	 *                             una ecuación de segundo grado.
	 */
	public double[] ecuacionSegundoGrado(double a, double b, double c) {
	    if (a == 0) {
	        throw new ArithmeticException("El coeficiente 'a' no puede ser 0. No es una ecuación de segundo grado.");
	    }

	    double discriminante = b * b - 4 * a * c;

	    if (discriminante > 0) {
	        // Dos soluciones reales
	        double raizDiscriminante = Math.sqrt(discriminante);
	        double x1 = (-b + raizDiscriminante) / (2 * a);
	        double x2 = (-b - raizDiscriminante) / (2 * a);
	        return new double[] { x1, x2 };
	    } else if (discriminante == 0) {
	        // Una solución doble
	        double x = -b / (2 * a);
	        return new double[] { x };
	    } else {
	        // Sin soluciones reales
	        return new double[0];
	    }
	}
}
