package calculadora.interfaz;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

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

        setVisible(true);
    }

    // TODO Clase interna para manejar los eventos de los botones 
    private class ManejadorBoton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();
            // Aquí puedes implementar la lógica de la calculadora
            System.out.println("Botón presionado: " + comando);
        }
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaCalculadora());
    }
}
