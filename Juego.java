package igu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.util.Random;
import logica.*;

public class Juego extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JuegoLogica juegoLogica;
    private JLabel lblScorePlayer;
    private JLabel lblScoreComputadora;
    private JLabel lblResultado;
    
    // Declaración de los botones como campos de la clase
    private JButton btnTijera;
    private JButton btnPiedra;
    private JButton btnPapel;
    private JButton btnRandom;

    public Juego(String nombreUsuario) {
        setTitle("Juego de Piedra, Papel o Tijera");
        setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 566, 444);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 240, 245));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Jugador jugador = new Jugador(nombreUsuario);
        Computadora computadora = new Computadora();
        juegoLogica = new JuegoLogica(jugador, computadora);

        JLabel nombre_juego = new JLabel("Jugador:");
        nombre_juego.setFont(new Font("Tahoma", Font.PLAIN, 15));
        nombre_juego.setBounds(10, 11, 56, 19);
        contentPane.add(nombre_juego);

        JLabel computadoraLabel = new JLabel("Computadora");
        computadoraLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        computadoraLabel.setBounds(300, 13, 112, 14);
        contentPane.add(computadoraLabel);

        JLabel lblNewLabel = new JLabel("Puntos:");
        lblNewLabel.setBounds(10, 32, 46, 14);
        contentPane.add(lblNewLabel);

        lblScorePlayer = new JLabel("0");
        lblScorePlayer.setBounds(53, 32, 46, 14);
        contentPane.add(lblScorePlayer);

        JLabel lblNewLabel_1 = new JLabel("Puntos:");
        lblNewLabel_1.setBounds(300, 32, 46, 14);
        contentPane.add(lblNewLabel_1);

        lblScoreComputadora = new JLabel("0");
        lblScoreComputadora.setBounds(346, 32, 46, 14);
        contentPane.add(lblScoreComputadora);

        JLabel imgPlayerPrimera = new JLabel("");
        imgPlayerPrimera.setIcon(new ImageIcon("C:\\Users\\luchi\\Downloads\\primera.png"));
        imgPlayerPrimera.setBounds(10, 57, 261, 219);
        contentPane.add(imgPlayerPrimera);

        JLabel imgPlayerPiedra = new JLabel("");
        imgPlayerPiedra.setIcon(new ImageIcon("C:\\Users\\luchi\\Downloads\\piedra.png"));
        imgPlayerPiedra.setBounds(10, 57, 214, 219);
        contentPane.add(imgPlayerPiedra);
        imgPlayerPiedra.setVisible(false);

        JLabel imgPlayerPapel = new JLabel("");
        imgPlayerPapel.setIcon(new ImageIcon("C:\\Users\\luchi\\Downloads\\Papel.png"));
        imgPlayerPapel.setBounds(10, 57, 214, 219);
        contentPane.add(imgPlayerPapel);
        imgPlayerPapel.setVisible(false);

        JLabel imgPlayerTijera = new JLabel("");
        imgPlayerTijera.setIcon(new ImageIcon("C:\\Users\\luchi\\Downloads\\Tijera.png"));
        imgPlayerTijera.setBounds(10, 57, 214, 219);
        contentPane.add(imgPlayerTijera);
        imgPlayerTijera.setVisible(false);

        JLabel imgComputadoraPrimera = new JLabel("");
        imgComputadoraPrimera.setIcon(new ImageIcon("C:\\Users\\luchi\\Downloads\\primera.png"));
        imgComputadoraPrimera.setBounds(281, 57, 259, 219);
        contentPane.add(imgComputadoraPrimera);

        JLabel imgComputadoraPiedra = new JLabel("");
        imgComputadoraPiedra.setIcon(new ImageIcon("C:\\Users\\luchi\\Downloads\\piedra.png"));
        imgComputadoraPiedra.setBounds(326, 57, 214, 219);
        contentPane.add(imgComputadoraPiedra);
        imgComputadoraPiedra.setVisible(false);

        JLabel imgComputadoraPapel = new JLabel("");
        imgComputadoraPapel.setIcon(new ImageIcon("C:\\Users\\luchi\\Downloads\\Papel.png"));
        imgComputadoraPapel.setBounds(326, 57, 214, 219);
        contentPane.add(imgComputadoraPapel);
        imgComputadoraPapel.setVisible(false);

        JLabel imgComputadoraTijera = new JLabel("");
        imgComputadoraTijera.setIcon(new ImageIcon("C:\\Users\\luchi\\Downloads\\Tijera.png"));
        imgComputadoraTijera.setBounds(326, 57, 214, 219);
        contentPane.add(imgComputadoraTijera);
        imgComputadoraTijera.setVisible(false);

        lblResultado = new JLabel("");
        lblResultado.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblResultado.setBounds(135, 300, 300, 30);
        contentPane.add(lblResultado);

        // Inicialización de los botones
        btnTijera = new JButton("Tijera");
        btnTijera.setBackground(new Color(250, 250, 210));
        btnTijera.setBounds(10, 303, 89, 23);
        contentPane.add(btnTijera);
        btnTijera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jugar(Mano.TIJERA, imgPlayerPrimera, imgPlayerPiedra, imgPlayerPapel, imgPlayerTijera, imgComputadoraPrimera, imgComputadoraPiedra, imgComputadoraPapel, imgComputadoraTijera);
            }
        });

        btnPiedra = new JButton("Piedra");
        btnPiedra.setBackground(new Color(250, 250, 210));
        btnPiedra.setBounds(10, 337, 89, 23);
        contentPane.add(btnPiedra);
        btnPiedra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jugar(Mano.PIEDRA, imgPlayerPrimera, imgPlayerPiedra, imgPlayerPapel, imgPlayerTijera, imgComputadoraPrimera, imgComputadoraPiedra, imgComputadoraPapel, imgComputadoraTijera);
            }
        });

        btnPapel = new JButton("Papel");
        btnPapel.setBackground(new Color(250, 250, 210));
        btnPapel.setBounds(10, 371, 89, 23);
        contentPane.add(btnPapel);
        btnPapel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jugar(Mano.PAPEL, imgPlayerPrimera, imgPlayerPiedra, imgPlayerPapel, imgPlayerTijera, imgComputadoraPrimera, imgComputadoraPiedra, imgComputadoraPapel, imgComputadoraTijera);
            }
        });

        btnRandom = new JButton("Aleatorio");
        btnRandom.setBackground(new Color(253, 245, 230));
        btnRandom.setBounds(135, 337, 89, 23);
        contentPane.add(btnRandom);
        btnRandom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                Mano[] manos = Mano.values();
                Mano manoAleatoria = manos[rand.nextInt(manos.length)];
                jugar(manoAleatoria, imgPlayerPrimera, imgPlayerPiedra, imgPlayerPapel, imgPlayerTijera, imgComputadoraPrimera, imgComputadoraPiedra, imgComputadoraPapel, imgComputadoraTijera);
            }
        });

        JButton btnRevancha = new JButton("Revancha");
        btnRevancha.setBackground(new Color(240, 248, 255));
        btnRevancha.setBounds(438, 354, 112, 23);
        contentPane.add(btnRevancha);
        btnRevancha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Juego juego = new Juego(nombreUsuario);
                juego.setVisible(true);
                dispose();
            }
        });

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(240, 255, 240));
        btnVolver.setBounds(438, 382, 112, 23);
        contentPane.add(btnVolver);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaPrincipal menu = new VentanaPrincipal();
                menu.setVisible(true);
                dispose();
            }
        });

        JLabel lblNombre = new JLabel(nombreUsuario.isEmpty() ? "Player" : nombreUsuario);
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNombre.setBounds(76, 13, 83, 14);
        contentPane.add(lblNombre);
    }

    private void bloquearJuego() {
        btnTijera.setEnabled(false);
        btnPiedra.setEnabled(false);
        btnPapel.setEnabled(false);
        btnRandom.setEnabled(false);
    }

    private void jugar(Mano manoJugador, JLabel imgPlayerPrimera, JLabel imgPlayerPiedra, JLabel imgPlayerPapel, JLabel imgPlayerTijera,
                       JLabel imgComputadoraPrimera, JLabel imgComputadoraPiedra, JLabel imgComputadoraPapel, JLabel imgComputadoraTijera) {
        imgPlayerPrimera.setVisible(false);
        imgPlayerPiedra.setVisible(false);
        imgPlayerPapel.setVisible(false);
        imgPlayerTijera.setVisible(false);

        switch (manoJugador) {
            case PIEDRA:
                imgPlayerPiedra.setVisible(true);
                break;
            case PAPEL:
                imgPlayerPapel.setVisible(true);
                break;
            case TIJERA:
                imgPlayerTijera.setVisible(true);
                break;
        }

        Mano manoComputadora = juegoLogica.generarManoComputadora();
        imgComputadoraPrimera.setVisible(false);
        imgComputadoraPiedra.setVisible(false);
        imgComputadoraPapel.setVisible(false);
        imgComputadoraTijera.setVisible(false);

        switch (manoComputadora) {
            case PIEDRA:
                imgComputadoraPiedra.setVisible(true);
                break;
            case PAPEL:
                imgComputadoraPapel.setVisible(true);
                break;
            case TIJERA:
                imgComputadoraTijera.setVisible(true);
                break;
        }

        String resultado = juegoLogica.jugar(manoJugador, manoComputadora);

        lblScorePlayer.setText(String.valueOf(juegoLogica.getPuntosJugador()));
        lblScoreComputadora.setText(String.valueOf(juegoLogica.getPuntosComputadora()));

        if (juegoLogica.getPuntosJugador() == 3) {
            lblResultado.setText("¡Has ganado!");
            contentPane.setBackground(new Color(124, 252, 0));
            bloquearJuego();

        } else if (juegoLogica.getPuntosComputadora() == 3) {
            lblResultado.setText("¡La computadora ha ganado!");
            contentPane.setBackground(new Color(250, 69, 0));
            bloquearJuego();
        } else {
            lblResultado.setText(resultado);
        }
    }
}
