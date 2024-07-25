package logica;
import java.util.Random;

public class Computadora extends Jugador {
	
	public Computadora() {
		super("Computadora");
	}

	public Mano elegirMano() {
        Mano[] manos = Mano.values();
        Random rand = new Random();
        actualizarMano(manos[rand.nextInt(manos.length)]);
        return manoActual();
    }

}
