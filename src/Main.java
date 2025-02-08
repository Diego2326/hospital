import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Crear una nueva instancia de la ventana
        Window window = new Window();
        window.setSize(400, 300); // Ajusta el tamaño de la ventana según sea necesario
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Asegúrate de que la aplicación se cierre al cerrar la ventana
        window.setVisible(true); // Hacer visible la ventana
    }
}
