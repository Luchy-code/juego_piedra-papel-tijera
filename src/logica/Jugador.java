package logica;

public class Jugador {
	public int punto;
	public String nombre;
	private Mano manoActual;

	public Jugador(String nombre) {
		this.punto = 0;
		this.nombre = nombre;
	}
	
	public void sumar() {
		this.punto+=1;
	}

	public int puntos() {
		return punto;
	}

	public String nombre() {
		return nombre;
	}

    public Mano manoActual() {
        return manoActual;
    }

    public void actualizarMano(Mano manoActual) {
        this.manoActual = manoActual;
    }
    
    public boolean gano() {
    	return punto==3;
    }
}
