/**
 * 
 */
package mobil;

/**
 * Diese Klasse erweitert {@code Vehikel} und implementiert die abstrakten 
 * Methoden {@code getSteuer()} und {@code mayDriveOnHighway()}.
 * 
 * @author Tobias Wenck, 296441, JP051
 * @author Dennis Pidun, 296267, JP051
 *
 */
public class Auto extends Vehikel {

    /**
     * Konstruktor fuer Auto.
     * @param kennzeichen Ein Kennzeichen
     * @param pferdeStaerke Angabe für Pferdestärke
     */
    public Auto(String kennzeichen, int pferdeStaerke) {
        super(kennzeichen, pferdeStaerke);
    }

    /**
     * Berechnet die Steuern nach der in der Aufgabenstellung gegebenen Formel.
     * @see mobil.Vehikel#getSteuer()
     */
    @Override
    public double getSteuer() {
        double steuerSatz = 0;
        
        if (this.getKW() >= 0 && this.getKW() <= 40) {
            steuerSatz = 2 * this.getKW();
        } else if (this.getKW() > 40 && this.getKW() <= 120) {
            steuerSatz = 3.11 * this.getKW();
        } else if (this.getKW() > 120) {
            steuerSatz = (4 * this.getKW()) + 130;
        }
       
        return steuerSatz;
    }

    /**
     * Das Auto darf auf dem Highway fahren, wenn es inklusive 40PS oder mehr
     * auf dem Kasten hat.
     * @see mobil.Vehikel#mayDriveOnHighway()
     */
    @Override
    public boolean mayDriveOnHighway() {
        return this.getPS() >= 40;
    }
    
    /**
     * .
     * @return Gibt das aktuelle Auto als String zurueck.
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Auto: " + super.toString();
    }

    /**
     * Testet nicht die Funktionalität der Auto-Klasse.
     * @param args Argumente
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
