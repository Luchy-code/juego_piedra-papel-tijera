package logica;

public enum Mano {
    PIEDRA, PAPEL, TIJERA;

    public boolean ganaA(Mano otraMano) {
        switch (this) {
            case PIEDRA:
                return otraMano == TIJERA;
            case PAPEL:
                return otraMano == PIEDRA;
            case TIJERA:
                return otraMano == PAPEL;
            default:
                return false;
        }
    }
}
