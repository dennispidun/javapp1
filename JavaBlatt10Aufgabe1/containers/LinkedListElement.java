// Blatt 10 Aufgabe 1: Tobias Wenck, Dennis Pidun; JP051
package containers;

class LinkedListElement {

    private Object data;
    
    private LinkedListElement next;
    
    /**
     * Konstruktor.
     * @param data Inhalt des Elements
     */
    public LinkedListElement(Object data) {
        next = null;
        this.data = data;
    }
    
    /**
     * Gibt den Inhalt des Elements zurueck.
     * @return Data
     */
    public Object getData() {
        return this.data;
    }
    
    /**
     * Verweist auf das naechste Element.
     * @return Naechstes Element.
     */
    public LinkedListElement getNext() {
        return this.next;
    }
    
    /**
     * Setzt naechstes Element.
     * @param next Element, das gesetzt werden soll.
     */
    public void setNext(LinkedListElement next) {
        if (next != null && next.getData() != null) {
            this.next = next; 
        }
        
    }
    
}
