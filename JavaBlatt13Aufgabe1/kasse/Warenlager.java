// Blatt 13 Aufgabe 1: Dennis Pidun, Tobias Wenck

package kasse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Diese Datenstruktur realisiert ein Warenlager.
 * @author Tobias Wenck, 296441, JP051
 * @author Dennis Pidun, 296267, JP051
 *
 */
public class Warenlager implements Iterable<Ware> {

    /**
     * Feld um die Waren zu speichern, realisiert ueber 
     * ein Key-Value-Store mit Key = ID.
     */
    private Map<Integer, Ware> waren;
    
    /**
     * Erstellt ein neues Warenlager.
     */
    public Warenlager() {
        this.waren = new HashMap<Integer, Ware>();
    }

    /**
     * Diese Methode fuegt dem aktuellen Lager eine Ware hinzu.
     * @param ware die dem Lager hinzugefuegt werden soll
     * @return Null, falls die Ware noch nicht im Lager ist andernfalls
     * die hinzugefuegte Ware, falls sie bereits im Lager vorhanden ist.
     * @throws IllegalArgumentException Falls {@code ware == null}
     */
    public Ware addWare(Ware ware) throws IllegalArgumentException {
        if (ware == null) {
            throw new IllegalArgumentException("Parameter Ware darf nicht "
                    + "null sein!");
        }
        
        Ware result = null;
        
        if (waren.containsKey(ware.getId())) {
            result = ware;
        }
        waren.put(ware.getId(), ware);
        
        return result;
    }
    
    /**
     * Sucht die Ware im Warenlager.
     * @param id die gesucht werden soll
     * @return Ware, die gefunden wurde, 
     * {@code null} falls Ware nicht gefunden wurde.
     */
    public Ware getWare(int id) {
        Ware result = null;
        for (Ware ware : waren.values()) {
            if (ware.getId() == id) {
                result = ware;
                break;
            }
        }
        
        return result;
    }
    
    /**
     * Gibt die Anzahl der Waren aus.
     * @return Anzahl der Waren
     */
    public int anzahl() {
        return this.waren.size();
    }


    /** Erstellt einen {@code Iterator<Ware>}.
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public Iterator<Ware> iterator() {
        return this.waren.values().iterator();
    }
    
    /** 
     * Testet die Klasse Warenlager.
     * @param args Startargumente
     */
    public static void main(String[] args) {
        Warenlager lager = new Warenlager();
        Ware ware = new Ware(1, "Blumentopf", 10.5);
        lager.addWare(ware);
        
        for (Ware wareLager : lager) {
            System.out.println(wareLager.toString());
        }

    }

}
