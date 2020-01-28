// Blatt 10 Aufgabe 1: Tobias Wenck, Dennis Pidun; JP051
package containers;

public abstract class List extends Container {

    /**
     * Fuegt Object obj der Liste an der Stelle pos hinzu. 
     * @param pos Index, wo das Objekt eingefuegt werden soll
     * @param obj Objekt, das eingefuegt werden soll
     */
    public abstract void add(int pos, Object obj);
    
    /**
     * Gibt das Objekt an der Stell pos der Liste zurueck.    
     * @param pos Index, wo das Objekt "gesucht" werden soll
     * @return Objekt, an der Stelle Pos.
     */
    public abstract Object get(int pos);
    
    /**
     * Entfernt das Objekt an der Stelle pos in der Liste.
     * @param pos Position, an der das Objekt geloescht werden soll.
     */
    public abstract void remove(int pos);
    
    /**
     * Gibt den ersten Index des Objekts zurueck, falls es nicht gefunden
     * wurde wird -1 zurueckgegeben.    
     * @param obj Das Objekt, dessen Index gesucht wird.
     * @return 0 <= index < size() falls Objekt gefunden wurde, andernfalls -1
     */
    public abstract int at(Object obj);
   
}
