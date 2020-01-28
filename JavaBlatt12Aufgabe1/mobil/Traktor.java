package mobil;

/**
 * Diese Klasse erweitert {@code Vehikel} und implementiert die abstrakten 
 * Methoden {@code getSteuer()} und {@code mayDriveOnHighway()}.
 *
 * @author Tobias Wenck, 296441, JP051
 * @author Dennis Pidun, 296267, JP051
 *
 */
public class Traktor extends Vehikel {

    /**
     * Konstruktor fuer Traktor.
     * @param kennzeichen Kennzeichen des Traktors
     * @param pferdeStaerke Die Antriebsleistung in PS
     */
    public Traktor(String kennzeichen, int pferdeStaerke) {
        super(kennzeichen, pferdeStaerke);
    }

    /**
     * Berechnet die Steuern nach der Formel: {@code this.getKW() * 0.7}.
     * @see mobil.Vehikel#getSteuer()
     */
    @Override
    public double getSteuer() {
        return this.getKW() * 0.7;
    }

    /**
     * Traktoren duerfen nicht auf dem Highway fahren.
     * @see mobil.Vehikel#mayDriveOnHighway()
     */
    @Override
    public boolean mayDriveOnHighway() {
        return false;
    }
    
    /**
     * Gibt den aktuellen Traktor als String zurueck.
     * @returns Die formatierten Eigenschaften des Objekts
     */    
    @Override
    public String toString() {
        return "Traktor: " + super.toString();
    }
    
    /**
     * Einstiegspunkt fuer Traktor, um die Klasse zu testen.
     * @param args Programmargumente
     */
    public static void main(String[] args) {
        Traktor meinTraktor = new Traktor("HI-AB 123", 1220);
        Vehikel.testVehikel(meinTraktor);
    }

}
