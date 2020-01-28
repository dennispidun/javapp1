// Blatt 13 Aufgabe 1: Dennis Pidun, Tobias Wenck

package kasse;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Dies ist die Datenstruktur, 
 * womit Rechnung/Kasse und Warenlager arbeiten.
 * @author Tobias Wenck, 296441, JP051
 * @author Dennis Pidun, 296267, JP051
 *
 */
public class Ware {

    
    /**
     * Id der Ware.
     */
    private int id;
    
    /**
     * Name der Ware.
     */
    private String name;
    
    
    /**
     * Preis der Ware.
     */
    private double preis;
    
    /**
     * Erstellt eine neue Ware.
     * @param id die beim Erstellen verwendet werden soll
     * @param name der beim Erstellen verwendet werden soll
     * @param preis der beim Erstellen verwendet werden soll
     * @throws IllegalArgumentException falls 
     * {@code name == null} oder {@code name.isEmpty()}
     */
    public Ware(int id, String name, double preis) 
            throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException("Parameter Name darf "
                    + "nicht null sein.");
        }
        
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Parameter Name darf "
                    + "nicht leer sein.");
        }
        
        this.id = id;
        this.name = name;
        this.preis = preis;
    }
    
    

    /**
     * Gibt die ID, der Ware zurueck.
     * @return die Id, der Ware
     */
    public int getId() {
        return id;
    }
    

    /**
     * Gibt den Namen, der Ware zurueck.
     * @return den Namen, der Ware
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt den Preis, der Ware zurueck.
     * @return den Preis, der Ware
     */
    public double getPreis() {
        return preis;
    }


    /**
     * Formatiert die Ware in einen String und gibt diesen zurueck.
     * @return formatierte Ware
     */
    @Override
    public String toString() {
        NumberFormat format = DecimalFormat.getNumberInstance();
        format.setMaximumFractionDigits(2);
        
        return "Ware [ID=" + getId() + ", Name=" 
            + getName() + ", Preis=" + format.format(getPreis()) + "]";
    }



    /**
     * Testet die Klasse Ware.
     * @param args Startargumente
     */
    public static void main(String[] args) {
        System.out.println(new Ware(1, "dsfsd", 10.43555435).toString());
    }

}
