package igu;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Label;
import java.awt.Font;
import java.awt.Button;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaPrincipal frame = new VentanaPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public VentanaPrincipal() {
        setAlwaysOnTop(true);
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(176, 224, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Label label = new Label("Ingrese su nombre:");
        label.setBounds(50, 84, 140, 25);
        label.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        contentPane.add(label);

        TextField nombre = new TextField();
        nombre.setBounds(186, 87, 166, 22);
        contentPane.add(nombre);

        Button button = new Button("Jugar!");
        button.setFont(new Font("Dialog", Font.PLAIN, 25));
        button.setBounds(147, 161, 125, 55);
        button.setBackground(new Color(250, 250, 210));
        contentPane.add(button);
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = nombre.getText();
                Juego juego = new Juego(nombreUsuario);
                juego.setVisible(true);
                dispose();
            }
        });
    }
}
