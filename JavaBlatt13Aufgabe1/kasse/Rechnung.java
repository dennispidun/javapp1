// Blatt 13 Aufgabe 1: Dennis Pidun, Tobias Wenck

package kasse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Rechnungsklasse, welche Speicher fuer Waren 
 * und ein Datum beinhaltet.
 * @author Tobias Wenck, 296441, JP051
 * @author Dennis Pidun, 296267, JP051
 *
 */
public class Rechnung {

    /**
     * Speicher fuer die Waren.
     */
    private List<Ware> waren;
    
        
    /**
     * Datum von der Rechnung.
     */
    private Date datum;
    
    /**
     * Default Konstruktor, der das aktuelle Datum speichert
     * und eine neue Waren-Liste anlegt.
     */
    public Rechnung() {
        this.datum = new Date();
        waren = new ArrayList<Ware>();
    }
    
    
    /**
     * Fuegt die Ware dem Speicher hinzu.
     * @param ware die hinzugefuegt werden soll.
     * @throws IllegalArgumentException falls {@code ware == null} ist
     */
    public void addWare(Ware ware) throws IllegalArgumentException {
        if (ware == null) {
            throw new IllegalArgumentException("Parameter Ware darf nicht "
                    + "null sein.");
        }
        this.waren.add(ware);
    }
    
    /**
     * Errechnet den Gesamtpreis aller Waren.
     * @return Kumulierter Preis aller Waren
     */
    public double getPreis() {
        double preis = 0;
       
        for (Ware ware : this.waren) {
            preis += ware.getPreis();
        }
        
        return preis;
    }
    
    /**
     * Formatiert die Rechnung als String und gibt diesen zurueck.
     * @see java.lang.Object#toString()
     * @return Formatierte Rechnung
     */
    @Override
    public String toString() {
        String pattern = "dd.MM.yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String datum = simpleDateFormat.format(this.datum);
        String warenString = "";
        
        
        for (Ware ware : this.waren) {
            warenString += "\t" + ware.toString() + "\n";
        }
        
        return "Rechnung vom " + datum 
            + " mit folgenden Waren: \n" 
            + warenString 
            + "Gesamtpreis: " 
            + getPreis();
    }

    /**
     * Testet die Rechnungsklasse.
     * @param args Startargumente
     */
    public static void main(String[] args) {
        Ware wareEins = new Ware(1, "Blumentopf", 10.5);
        Ware wareZwei = new Ware(2, "Rose", 2.55);
        Rechnung r = new Rechnung();
        r.addWare(wareEins);
        r.addWare(wareZwei);
        
        System.out.println(r.toString());
    }

}
