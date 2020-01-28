// Blatt 10 Aufgabe 1: Tobias Wenck, Dennis Pidun; JP051
package containers;

public class LinkedList extends Container {

    private LinkedListElement start;
    private int size;
    
    /**
     * Default Konstrukor.
     */
    public LinkedList() {
        this.size = 0;
        this.start = null;
    }
    
    @Override
    public void add(Object obj) {
        LinkedListElement next = new LinkedListElement(obj);
        if (this.start != null) {
            LinkedListElement element = this.start;
            
            // finden des letzten Elements
            while (element.getNext() != null) {
                element = element.getNext(); 
            }
            element.setNext(next);
        } else {
            this.start = next;
        }
        this.size++;
    }

    @Override
    public void remove(Object obj) {
        if (start != null) {
            //sollte das erste Element o beinhalten
            if (start.getData().equals(obj)) {
                // setze nächstes Element als neues Startelement
                start = start.getNext();
                this.size--;
                
                //entferne restliche Elemente
                remove(obj);
            } else {
                LinkedListElement next = start;
                while (next.getNext() != null) {
                    if (next.getNext().getData().equals(obj)) {
                        next.setNext(next.getNext().getNext());
                        this.size--;
                    } else {
                        next = next.getNext();
                    }
                }
            }
        } 
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size];    
        LinkedListElement element = this.start;
        int i = 0;
        while (element != null) {
            array[i] = element.getData();
            element = element.getNext();
            i++;
        }
        return array;
    }
    
    @Override
    public String toString() {
        String result = "[";
        LinkedListElement item = start;
        
        while (item != null) {
            if (item.equals(start)) {
                // Füge Wert ohne Komma an das Ergebnis an
                result += item.getData().toString();
            } else {
                // Für Werte nach dem ersten Objekt, füge Wert mit 
                // Komma an das Ergebnis an
                result += ", " + item.getData().toString();
            }
            // gehe ein Element weiter
            item = item.getNext();
        }
        
        result += "]";
        return result;
    }

}
