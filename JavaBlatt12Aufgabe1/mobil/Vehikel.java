package mobil;

/**
 * Diese Klasse bildet das allgemeine Fahrzeug. Es bietet Moeglichkeiten, um 
 * das Kennzeichen und die Antriebsleistung anzunehmen. Ausserdem kann berechnet
 * werden, wieviel Steuern zu bezahlen sind, und ob das Fahrzeug auf der 
 * Autobahn fahren darf.
 * 
 * @author Tobias Wenck, 296441, JP051
 * @author Dennis Pidun, 296267, JP051
 * 
 */
public abstract class Vehikel {
    
    public static final  double KW_PS_FAKTOR = 0.735;
    public static final  String KENNZEICHEN_FORMAT = "[A-Z]+[-][A-Z]+[ ]" 
        + "[1-9]+[0-9]*";
    
    private String kennzeichen;
    private int pferdeStaerke;
    
    /**
     * Konstruktor fuer Vehikel: Ueberprueft ob das Kennzeichen im richtigen 
     * Format vorliegt.
     * @param kennzeichen Kennzeichen des Fahrzeuges
     * @param pferdeStaerke Die Antriebsleistung in PS
     * @throws IllegalArgumentException wenn das Kennzeichen leer ist
     * @throws IllegalArgumentException wenn das Kennzeichen nicht dem Format 
     * (B-B Z) entspricht
     * @throws IllegalArgumentException wenn die Pferdestaerke nicht positiv 
     * (>=1) ist
     */
    public Vehikel(String kennzeichen, int pferdeStaerke) 
        throws IllegalArgumentException {
        if (kennzeichen.length() == 0) {
            throw new IllegalArgumentException("Das Vehikel konnte nicht "
                + "erstellt werden, es benoetigt ein Kennzeichen "
                + "im Format: B-B Z und darf nicht leer sein!");
        }
        
        if (pferdeStaerke < 1) {
            throw new IllegalArgumentException("Das Vehikel wurde nicht"
                + "erstellt, es benoetigt eine positive Antriebsstaerke");
        }
        
        if (!kennzeichen.toUpperCase().matches(KENNZEICHEN_FORMAT)) {
            throw new IllegalArgumentException("Das Vehikel konnte nicht " 
                + "erstellt werden, das Kennzeichen entspricht nicht dem " 
                + "Format: B-B Z");
        }
        
        this.kennzeichen = kennzeichen.toUpperCase();
        this.pferdeStaerke = pferdeStaerke;
    }

    /**
     * Gibt das Kennzeichen des Vehikels zurueck.
     * @return Das Kennzeichen als String
     */
    public String getKennzeichen() {
        return this.kennzeichen;
    }
    
    /**
     * Gibt die Antriebsleistung des Vehikels zurueck.
     * @return Die Antriebsleistung als Integer in Pferdestaerke
     */
    public int getPS() {
        return this.pferdeStaerke;
    }
    
    /**
     * Gibt die Antriebsleistung des Vehikels zurueck.
     * @return Die Antriebsleistung als Double in Kilowatt
     */
    public double getKW() {
        return this.getPS() * KW_PS_FAKTOR;
    }
    
    /**
     * Gibt die Steuer des Vehikels zurueck.
     * @return Die Steuer als Double in Euro
     */
    public abstract double getSteuer(); 

    /**
     * Gibt zurueck ob das Vehikel auf der Autobahn fahren darf.
     * @return Die Erlaubnis, ob das Vehikel auf der Autobahn fahren darf
     */
    public abstract boolean mayDriveOnHighway();
    
    /**
     * Gibt die Eigenschaften zurueck.
     * @return Die formatierten Eigenschaften des Objekts
     */
    @Override
    public String toString() {
        return "Das Fahrzeug mit dem Kennzeichzen " + kennzeichen + "hat eine "
            + "Geschwingidkeit von " + getPS() + "PS und eine Leistung von "
            + getKW() + "kW, eine Steuer von " + getSteuer() + " Euro und darf "
            + (mayDriveOnHighway() ? "" : "nicht")
            + " auf der Autobahn fahren.";
    }
    
    /**
     * Testet das Vehikel.
     * @param vehikel Ein Vehikel.
     */
    public static void testVehikel(Vehikel vehikel) {
        System.out.println(vehikel.toString());    
    }
}
