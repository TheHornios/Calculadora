package calculadora.interfaz;

import calculadora.logica.Operaciones;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana de la calculadora, contiene los botones y una pantalla de resultados
 */
public class VentanaCalculadora extends JFrame {
    private JTextField pantalla; // Display principal
    private Operaciones operaciones; // Instancia de la lógica
    private String historial = ""; // Historial de operaciones

    public VentanaCalculadora() {
    	// Se cambia el estilo del UI manager
    	try {
            // Se cambia el "look and feel" (aspectos visuales) al default de windows
    		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    	// Inicializamos la lógica
        operaciones = new Operaciones(); 

        // Configuración de la ventana
        setTitle("Calculadora");
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Pantalla del display
        pantalla = new JTextField();
        pantalla.setFont(new Font("Arial", Font.BOLD, 40));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        pantalla.setPreferredSize(new Dimension(0, 80));
        add(pantalla, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(7, 4, 5, 5)); // 7 filas, 4 columnas
        String[] botones = {
            "Historial", "Borrar", "Borrar Todo", "Salir",  // Primera fila
            "x²", "ax²+bx+c", "√", "/",                     // Segunda fila
            "7", "8", "9", "*",                             // Tercera fila
            "4", "5", "6", "-",                             // Cuarta fila
            "1", "2", "3", "+",                             // Quinta fila
            "0", ".", "(", ")",                             // Sexta fila - paréntesis
            "π", "^", "log", "="                            // Última fila
        };

        // Se añaden los event listeners para todos los botones
        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.PLAIN, 16));
            boton.addActionListener(new ManejadorBoton());
            panelBotones.add(boton);
        }
        
        // Se centra y establece la visibilidad del panel de botones
        add(panelBotones, BorderLayout.CENTER);
        setVisible(true);
    }

    /**
     * Clase que controla el funcionamiento de los botones
     */
    private class ManejadorBoton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	// Variables que controlan los botones pulsados y el texto del display
            String comando = e.getActionCommand();
            String textoActual = pantalla.getText();

            try {
            	// Se comprueba el botón pulsado
                switch (comando) {
                    case "Historial": // Muestra la pestaña de historial
                    	// Se comprueba si hay historial y se muestra el contenido
                        JOptionPane.showMessageDialog(null, historial.isEmpty() ? "No hay historial" : historial,
                                "Historial de operaciones", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case "Borrar":
                        // Si se ha utilizado anteriormente mal un operador, entonces borra todo
                        if (textoActual.contains("Error")) {
                            pantalla.setText("");
                        }else if (!textoActual.isEmpty()) {
                        	// En caso contrario solo borra el último digito
                            pantalla.setText(textoActual.substring(0, textoActual.length() - 1));
                        }
                        break;

                    case "Borrar Todo": // Se borra todo en la pantalla
                        pantalla.setText("");
                        break;

                    case "Salir": // Cierra el programa
                        System.exit(0);
                        break;

                    case "x²": // Elevar al cuadrado
                        if (!textoActual.isEmpty()) {
                            double valor = Double.parseDouble(textoActual);
                            double resultado = operaciones.multiplicar(valor, valor);
                            pantalla.setText(String.valueOf(resultado));
                            historial += textoActual + "² = " + resultado + "\n";
                        }
                        break;

                    case "ax²+bx+c": // Resolver ecuación de segundo grado
                        String a = JOptionPane.showInputDialog("Introduce el coeficiente a:");
                        String b = JOptionPane.showInputDialog("Introduce el coeficiente b:");
                        String c = JOptionPane.showInputDialog("Introduce el coeficiente c:");
                        double[] soluciones = operaciones.ecuacionSegundoGrado(Double.parseDouble(a), Double.parseDouble(b), Double.parseDouble(c));
                        String mensaje = (soluciones.length == 0) ? "Sin soluciones reales" : "Soluciones: x1=" + soluciones[0] + ", x2=" + (soluciones.length > 1 ? soluciones[1] : soluciones[0]);
                        pantalla.setText(mensaje);
                        historial += "Ecuación: " + a + "x² + " + b + "x + " + c + " → " + mensaje + "\n";
                        break;

                    case "=": // Ejecuta las operaciones
                    	// Llama al calculo del resultado
                        double resultado = calcularResultado(textoActual);
                        historial += textoActual + " = " + resultado + "\n";
                        
                        // Muestra el resultado
                        pantalla.setText(String.valueOf(resultado));
                        break;

                    default:
                        pantalla.setText(pantalla.getText() + comando);
                        break;
                }
            } catch (Exception ex) {
            	// En caso de excepción muestra "Error" en la pantalla
                pantalla.setText("Error");
            }
        }
        
        /**
         * Clase que calcula los resultados, es llamada por el ManejadorBoton
         * 
         * @param String de entrada
         * @return double del resultado de la operación
         */
        private double calcularResultado(String input) {
            String operador = input.replaceAll("[0-9.]", "").trim();
            String[] operandos = input.split("[+\\-*/^√]");

            // Procesar dependiendo de la posición del operador
            if (operador.equals("√")) {
                // Si el formato es incorrecto devuelve una excepción
                if (operador.equals("√") && input.matches(".*[0-9]\\s*√")) {
                    throw new IllegalArgumentException("El operador '√' no puede estar después de un número.");
                }
                
                // Toma el único operador de este tipo de operación
                String operando = input.replace("√", "").trim();
                double a = Double.parseDouble(operando);
                
                // Devuelve la raiz
                return operaciones.raiz(a);
            }

            // Comprueba que la llamada este bien formada
            if (operandos.length == 2) {
                double a = Double.parseDouble(operandos[0]);
                double b = Double.parseDouble(operandos[1]);
                
                // Una vez separados los operandos comprueba a que operación pertenece esta llamada
                switch (operador) {
                    case "+":
                        return operaciones.sumar(a, b);
                    case "-":
                        return operaciones.restar(a, b);
                    case "*":
                        return operaciones.multiplicar(a, b);
                    case "/":
                        return operaciones.dividir(a, b);
                    case "^":
                        return operaciones.potenciar(a, b);
                    case "√":
                        return operaciones.raiz(a);
                }
            }
            // Si no es una operación correcta devuelve error
            throw new IllegalArgumentException("Formato inválido");
        }
    }

    public static void main(String[] args) {
    	// Genera la ventana de la calculadora
        SwingUtilities.invokeLater(() -> new VentanaCalculadora());
    }
}
