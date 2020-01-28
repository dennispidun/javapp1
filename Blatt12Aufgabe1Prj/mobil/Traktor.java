package mobil;

public class Traktor extends Vehikel {

    public Traktor(String kennzeichen, int ps) throws IllegalArgumentException {
        super(kennzeichen, ps);
        // TODO Auto-generated constructor stub
    }

    public double getSteuer() {
        return 0.7 * getKW();
    }

    public boolean mayDriveOnHighway() {
        return false;
    }

}
