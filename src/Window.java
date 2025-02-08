import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Window extends JFrame {
    private JTextField nombre;
    private JTextField apellido;
    private JTextField edad;
    private JTextField numero;
    private JTextField cita;
    private JButton Guardar;
    private JButton cancelarButton;
    private JTextField dpi;

    // Constructor
    public Window() {
        // Configuración de la ventana
        setTitle("Guardar Datos de Pacientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Crear los componentes de la interfaz
        nombre = new JTextField(20);
        apellido = new JTextField(20);
        edad = new JTextField(20);
        numero = new JTextField(20);
        cita = new JTextField(20);
        dpi = new JTextField(20);

        Guardar = new JButton("Guardar");
        cancelarButton = new JButton("Cancelar");

        // Crear un panel para agregar los componentes
        JPanel panel = new JPanel();
        panel.add(new JLabel("DPI:"));
        panel.add(dpi);
        panel.add(new JLabel("Nombre:"));
        panel.add(nombre);
        panel.add(new JLabel("Apellido:"));
        panel.add(apellido);
        panel.add(new JLabel("Edad:"));
        panel.add(edad);
        panel.add(new JLabel("Número:"));
        panel.add(numero);
        panel.add(new JLabel("Cita:"));
        panel.add(cita);
        panel.add(Guardar);
        panel.add(cancelarButton);

        // Establecer el contentPane
        setContentPane(panel);

        // Acción del botón Guardar
        Guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });

        // Acción del botón Cancelar
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();  // Cerrar la ventana
            }
        });
    }

    // Método para guardar los datos en un archivo de texto
    private void guardarDatos() {
        // Obtener los valores de los campos de texto
        String nombreText = nombre.getText();
        String apellidoText = apellido.getText();
        String edadText = edad.getText();
        String numeroText = numero.getText();
        String citaText = cita.getText();
        String dpiText = dpi.getText();

        // Crear el texto a escribir en el archivo
        String datos = "DPI: " + dpiText + "\n" +
                "Nombre: " + nombreText + "\n" +
                "Apellido: " + apellidoText + "\n" +
                "Edad: " + edadText + "\n" +
                "Número: " + numeroText + "\n" +
                "Razón de Cita: " + citaText + "\n" +
                "---------------------------\n\n";

        // Guardar los datos en un archivo de texto
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("datosPacientes.txt", true))) {
            writer.write(datos);
            JOptionPane.showMessageDialog(this, "Datos guardados con éxito.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + e.getMessage());
        }
    }
}
