package mobil;

public class Auto extends Vehikel {

    public Auto(String kennzeichen, int ps) throws IllegalArgumentException {
        super(kennzeichen, ps);
    }

    public double getSteuer() {
        double kW = getKW();
        double result;
        if (kW <= 40) {
            result = 2 * kW;
        } else if (kW <= 120) {
            result = 3.11 * kW;
        } else {
            result = 4 * kW + 130;
        }
        return result;
    }

    public boolean mayDriveOnHighway() {
        return getPS() >= 40;
    }
}
