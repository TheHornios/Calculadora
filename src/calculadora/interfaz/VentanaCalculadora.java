package calculadora.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCalculadora extends JFrame {
    // Panel de display
	private JTextField pantalla;

	/**
	 * Método que genera la estructura principal de la calculadora,
	 * sus apartados y botones
	 */
    public VentanaCalculadora() {
        // Configuración de la ventana
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel para el display
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
            "0", ".", "+", "="
        };
        
        // Disposición y características de los botones numéricos y de operaciones
        for (String texto : botonesNumericos) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.BOLD, 18));
            boton.addActionListener(new ManejadorBoton());
            panelBotones.add(boton);
        }
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }

    /**
     * Clase que controla el funcionamiento de los botones
     */
    private class ManejadorBoton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	// Se captura la acción realizada como entrada
            String comando = e.getActionCommand();
            
            String textoActual = pantalla.getText();

            // Switch donde se decide la acción según el boton
            switch (comando) {
                case "Borrar":
                    // Comprueba si hay algún elemento que borrar
                    if (!textoActual.isEmpty()) {
                    	// Borra el último elemento en la pantalla
                        pantalla.setText(textoActual.substring(0, textoActual.length() - 1));
                    }
                    
                    break;
                case "Borrar Todo":
                    // Comprueba si hay algún elemento que borrar
                    if (!textoActual.isEmpty()) {
                    	// Borra el último elemento en la pantalla
                    	pantalla.setText("");
                    }
                    
                    break;
                case "Salir":
                    // Cierra la aplicación
                    System.exit(0);
                    
                    break;
                case "=":
                	/* TODO
                	 * Se debe recorrer el contenido de la pantalla
                	 * para identificar un operando 1, un operador y un operando 2
                	 * y llamar a la función correspondiente de funcionalidad pasandole
                	 * esos dos operandos
                	 *  */
                	break;         
                default:
                	 // Agrega el texto del botón presionado al display
                    pantalla.setText(pantalla.getText() + comando);
                    
                    break;
            }
        }
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaCalculadora());
    }
}
