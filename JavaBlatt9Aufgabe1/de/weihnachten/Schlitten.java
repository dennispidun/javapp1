// Blatt 9 Aufgabe 1: Tobias Wenck, Dennis Pidun; JP051 

package de.weihnachten;


public class Schlitten extends WeihnachtsObjekt {

    private Geschenk[] geschenke;
    private Rentier[] rentiere;
    
    public Schlitten(Geschenk[] geschenke, Rentier[] rentiere) {
        this.geschenke = geschenke;
        this.rentiere = rentiere;
    } 
    
    public Geschenk getNaechstesGeschenk() {
        
        //Speicher naechstes Geschenk ab
        Geschenk naechstesGeschenk = geschenke[0];
        
        //Erstelle neues Array mit geschenke.length - 1 Pluetzen
        Geschenk[] neueGeschenke = new Geschenk[geschenke.length - 1];
        for (int i = 1; i < geschenke.length; i++) {
            //ueberfuehre altes Array in Neues um Geschenke aufruecken zu lassen
            neueGeschenke[i - 1] = geschenke[i];
        }
        
        //ueberschreibe altes Array mit Neuem
        this.geschenke = neueGeschenke;
        
        // Gebe naechstesGeschenk zurueck
        return naechstesGeschenk;
    }
    
    // Berechnen des Gesamtgewichts unter Beruecksichtigung der Geschenkgewichte
    public int getGewicht() {
        int gewicht = 0;
        for (Geschenk geschenk : geschenke) {
            gewicht += geschenk.getGewicht();
        }
        return gewicht;
    }
    
    // Anwendung der Fliegen-Formel
    public boolean kannFliegen() {
        return getGewicht() <= 100 * Math.sqrt(this.getAnzahlRentiere());
    }
    
    public boolean istLeer() {
        return getAnzahlGeschenke() == 0;
    }
    
    public int getAnzahlRentiere() {
        return rentiere.length;
    }
    
    public int getAnzahlGeschenke() {
        return geschenke.length;
    }
    
    /*
     * In der Aufgabe steht, dass index zwischen 0 und getAnzahlRentiere liegen
     * muss. Das ergibt leider keinen Sinn, da man so auf einen Index zugreifen
     * kuennte, der ausserhalb des Arrays liegt.
     */
    public Rentier getRentier(int index) {
        Rentier tmp = null;
        if (index < getAnzahlRentiere()) {
            tmp = rentiere[index];
        }
        return tmp;
    }
}
