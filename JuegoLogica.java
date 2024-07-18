package logica;

import java.util.Random;

public class JuegoLogica {

    private Jugador jugador;
    private Computadora computadora;

    public JuegoLogica(Jugador jugador, Computadora computadora) {
        this.jugador = jugador;
        this.computadora = computadora;
    }

    public Mano generarManoComputadora() {
        Random rand = new Random();
        Mano[] manos = Mano.values();
        return manos[rand.nextInt(manos.length)];
    }

    public String jugar(Mano manoJugador, Mano manoComputadora) {
        if (manoJugador == manoComputadora) {
            return "Empate";
        }

        switch (manoJugador) {
            case PIEDRA:
                if (manoComputadora == Mano.TIJERA) {
                    jugador.sumar();
                    return "Ganaste esta ronda";
                } else {
                    computadora.sumar();
                    return "La computadora ganó esta ronda";
                }
            case PAPEL:
                if (manoComputadora == Mano.PIEDRA) {
                    jugador.sumar();
                    return "Ganaste esta ronda";
                } else {
                    computadora.sumar();
                    return "La computadora ganó esta ronda";
                }
            case TIJERA:
                if (manoComputadora == Mano.PAPEL) {
                    jugador.sumar();
                    return "Ganaste esta ronda";
                } else {
                    computadora.sumar();
                    return "La computadora ganó esta ronda";
                }
        }
        return "";
    }

    public int getPuntosJugador() {
        return jugador.puntos();
    }

    public int getPuntosComputadora() {
        return computadora.puntos();
    }
}
