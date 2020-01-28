// Blatt 10 Aufgabe 1: Tobias Wenck, Dennis Pidun; JP051
package containers;

public abstract class Container {

    /**
     * Fuegt Object obj dem Container hinzu. 
     * @param obj Objekt, das dem Container hinzugefuegt werden soll
     */
    public abstract void add(Object obj); 
    
    /**
     * Entfernt alle Objekte, die dem Object obj gleichen.
     * @param obj Objekt, welches entfernt werden soll.
     */
    public abstract void remove(Object obj);
    
    /**
     * Gibt die Groesse des Containers zurueck.
     * @return int Groesse des Containers
     */
    public abstract int size();
    
    /**
     * Berechnet ein Object Array des Containers.
     * @return Object[] Container als Object Array
     */
    public abstract Object[] toArray();
    
}
