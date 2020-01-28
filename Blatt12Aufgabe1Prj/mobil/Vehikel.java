package mobil;

public abstract class Vehikel {
    
    private String kennzeichen;
    private int ps;
    public static final double kw = 0.735;
    
    /**
     * @param kennzeichen
     * @param ps
     */
    public Vehikel(String kennzeichen, int ps) throws IllegalArgumentException {
        if (kennzeichen.isEmpty()) {
            throw new IllegalArgumentException("Das Kennzeichen darf nicht"
                + " leer sein!");
        } else if (kennzeichen.matches("[A-ZÄÖÜ]+ [A-ZÄÖÜ]+ [0-9]+")) {
            throw new IllegalArgumentException("Das Kennzeichen entspricht "
                + "nicht dem Format B B Z!");
        } else {
            this.kennzeichen = kennzeichen;
            this.ps = ps;
        }
        
    }
    
    /**
     * @return the kennzeichen
     */
    public String getKennzeichen() {
        return kennzeichen;
    }
    
    /**
     * @return the ps
     */
    public int getPS() {
        return ps;
    }
    
    /**
     * @return
     */
    public double getKW() {
        return ps * kw;
    }
    
    public abstract double getSteuer();
    
    public abstract boolean mayDriveOnHighway();
    
    public String toString() {
        return "Das Fahrzeug mit dem Kennzeichzen " + kennzeichen + "hat eine "
            + "Geschwingidkeit von " + ps + "PS und eine Leistung von "
            + getKW() + "kW, eine Steuer von " + getSteuer() + " Euro und darf "
            + (mayDriveOnHighway() ? "" : "nicht")
            + " auf der Autobahn fahren.";
    }

}
