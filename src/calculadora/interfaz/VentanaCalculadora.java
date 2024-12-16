package calculadora.interfaz;

<<<<<<< HEAD
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCalculadora extends JFrame {
    // Panel de display
	private JTextField pantalla;

    public VentanaCalculadora() {
        // Configuración de la ventana
        setTitle("Calculadora");
        setSize(300, 400);
=======
import calculadora.logica.Operaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCalculadora extends JFrame {
    private JTextField pantalla; // Display principal
    private Operaciones operaciones; // Instancia de la lógica
    private String historial = ""; // Historial de operaciones

    public VentanaCalculadora() {
        operaciones = new Operaciones(); // Inicializamos la lógica

        // Configuración de la ventana
        setTitle("Calculadora");
        setSize(400, 550);
>>>>>>> a8f4d035539c6ab0404ff989e6500fd39dec9ec1
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

<<<<<<< HEAD
        // TODO Panel para el display
        pantalla = new JTextField();
        pantalla.setFont(new Font("Arial", Font.BOLD, 24));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        add(pantalla, BorderLayout.NORTH);

        // Panel de botones de control
        JPanel panelControles = new JPanel();
        panelControles.setLayout(new GridLayout(1, 3, 5, 5));
        String[] botonesControles = {
            "Salir", "Borrar", "Borrar Todo"
        };
        
        // Disposición y características de los botones de control
        for (String texto : botonesControles) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.BOLD, 18));
            boton.addActionListener(new ManejadorBoton());
            panelControles.add(boton);
        }
        
        // TODO Panel de botones de funcionalidades 
        JPanel panelFuncionalidades = new JPanel();
        panelFuncionalidades.setLayout(new GridLayout(1, 4, 5, 5));
        String[] botonesFuncionales = {
            "TODO", "TODO", "TODO", "TODO"
        };
        
        // Disposición y características de los botones de funcionalidades
        for (String texto : botonesFuncionales) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.BOLD, 18));
            boton.addActionListener(new ManejadorBoton());
            panelFuncionalidades.add(boton);
        }

        // Se combinan los anteriores en un unico panel central
        JPanel panelSuperior = new JPanel(new BorderLayout());
        
        // Los botones de control van arriba
        panelSuperior.add(panelControles, BorderLayout.NORTH);
        
        // Los botones de funcionalidades van abajo
        panelSuperior.add(panelFuncionalidades, BorderLayout.CENTER);
        add(panelSuperior, BorderLayout.CENTER);

        // Panel de botones numéricos
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 4, 5, 5));
        String[] botonesNumericos = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "+"
        };
        
        // Disposición y características de los botones numéricos y de operaciones
        for (String texto : botonesNumericos) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.BOLD, 18));
            boton.addActionListener(new ManejadorBoton());
            panelBotones.add(boton);
        }
        add(panelBotones, BorderLayout.SOUTH);
=======
        // **Pantalla del display - más grande**
        pantalla = new JTextField();
        pantalla.setFont(new Font("Arial", Font.BOLD, 40));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        pantalla.setPreferredSize(new Dimension(0, 80));
        add(pantalla, BorderLayout.NORTH);

        // **Panel de botones**
        JPanel panelBotones = new JPanel(new GridLayout(7, 4, 5, 5)); // 7 filas, 4 columnas
        String[] botones = {
            "Historial", "Borrar", "Borrar Todo", "Salir", // Primera fila
            "x²", "ax²+bx+c", "√", "/",                  // Segunda fila
            "7", "8", "9", "*",                         // Tercera fila
            "4", "5", "6", "-",                         // Cuarta fila
            "1", "2", "3", "+",                         // Quinta fila
            "0", ".", "(", ")",                         // Sexta fila - paréntesis
            "π", "^", "log", "="                        // Última fila
        };

        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.PLAIN, 16));
            boton.addActionListener(new ManejadorBoton());
            panelBotones.add(boton);
        }
        add(panelBotones, BorderLayout.CENTER);
>>>>>>> a8f4d035539c6ab0404ff989e6500fd39dec9ec1

        setVisible(true);
    }

<<<<<<< HEAD
    // TODO Clase interna para manejar los eventos de los botones 
=======
    /**
     * Clase que controla el funcionamiento de los botones
     */
>>>>>>> a8f4d035539c6ab0404ff989e6500fd39dec9ec1
    private class ManejadorBoton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
<<<<<<< HEAD
            // Aquí puedes implementar la lógica de la calculadora
            System.out.println("Botón presionado: " + comando);
        }
    }

    // Método principal para ejecutar la aplicación
=======
            String textoActual = pantalla.getText();

            try {
                switch (comando) {
                    case "Historial":
                        JOptionPane.showMessageDialog(null, historial.isEmpty() ? "No hay historial" : historial,
                                "Historial de operaciones", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case "Borrar":
                        if (!textoActual.isEmpty()) {
                            pantalla.setText(textoActual.substring(0, textoActual.length() - 1));
                        }
                        break;

                    case "Borrar Todo":
                        pantalla.setText("");
                        break;

                    case "Salir":
                        System.exit(0);
                        break;

                    case "x²": // Elevar al cuadrado inmediatamente
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

                    case "=":
                        double resultado = calcularResultado(textoActual);
                        historial += textoActual + " = " + resultado + "\n";
                        pantalla.setText(String.valueOf(resultado));
                        break;

                    default:
                        pantalla.setText(pantalla.getText() + comando);
                        break;
                }
            } catch (Exception ex) {
                pantalla.setText("Error");
            }
        }

        private double calcularResultado(String input) {
            String operador = input.replaceAll("[0-9.]", "").trim();
            String[] operandos = input.split("[+\\-*/^]");

            if (operandos.length == 2) {
                double a = Double.parseDouble(operandos[0]);
                double b = Double.parseDouble(operandos[1]);

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
                }
            }
            throw new IllegalArgumentException("Formato inválido");
        }
    }

>>>>>>> a8f4d035539c6ab0404ff989e6500fd39dec9ec1
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaCalculadora());
    }
}
