// Blatt 9 Aufgabe 1: Tobias Wenck, Dennis Pidun; JP051 

package de.weihnachten;

public class Weihnachtsmann extends WeihnachtsObjekt {
    
    private double futtervorrat;
    private Schlitten schlitten;
    
    public Weihnachtsmann(double futtervorrat, Schlitten schlitten) {
        this.futtervorrat = futtervorrat;
        this.schlitten = schlitten;
    }
    
    public boolean istFertig() {
        return this.schlitten.getAnzahlGeschenke() == 0;
    }
    
    // Es ist nicht eindeutig ob man den Hunger in Relation des 
    // Gesamtgewichts verwenden soll oder den "normmalen" Hunger
    // Hier wurde sich fuer den Gesamtgewicht-Hunger entschieden:
    public boolean kannNochFuettern() {
        int benoetigtesFutter = getGesamtHungerRentiere();
        
        return benoetigtesFutter <= futtervorrat;
    }

    // Gibt den Gesamthunger der Rentiere zurueck
    private int getGesamtHungerRentiere() {
        int gesamtGewicht = this.schlitten.getGewicht();
        int benoetigtesFutter = 0;
        for (int i = 0; i < this.schlitten.getAnzahlRentiere(); i++) {
            benoetigtesFutter += this.schlitten.getRentier(i)
                .getHunger(gesamtGewicht);
        }
        return benoetigtesFutter;
    }
    
    // Liefer das naechste Geschenk aus, bzw gibt es auf der Konsole aus
    public void naechstesGeschenkAusliefern() {
        if (!this.istFertig()) {
            Geschenk naechstesGeschenk = this.schlitten.getNaechstesGeschenk();
            System.out.println(naechstesGeschenk.asString());
        }
    }
    
    // Fuettert alle Rentiere aufeinmal
    public void fuettern() {
        if (kannNochFuettern()) {
            futtervorrat -= getGesamtHungerRentiere();
        }
    }
}
