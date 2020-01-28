//Blatt 11: Tobias Wenck, Dennis Pidun; JP051

/**
 * 
 */
package containerUtils;

import containers.ArrayList;

/**
 * Diese Klasse implementiert den Sortieralgorithmus.
 * 
 * @author Tobias Wenck, 296441, JP051
 * @author Dennis Pidun, 296267, JP051
 *
 */
public class Sorting {

    
    /**
     * Die Methode laeuft über die Liste list und ruft an jeder Stelle die
     * Funktion compare des Interfaces com mit dem Objekt an der aktuellen
     * Stelle und dem naechsten Objekt auf.
     *  
     * @param list Liste, die sortiert werden soll
     * @param com Interface, in dem die Vergleichsmethode deklariert wird
     */
    public static void sort(ArrayList list, IElementComparator com) {
        
        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                Object o1 = list.get(i);
                Object o2 = list.get(i + 1);
                
                if (com.compare(o1, o2) > 0) {
                    sorted = false;
                    list.set(i, o2);
                    list.set(i + 1, o1);
                }
            }
        } while(!sorted); 
    }
}
