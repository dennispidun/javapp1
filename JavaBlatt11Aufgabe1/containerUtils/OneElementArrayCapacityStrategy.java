//Blatt 11: Tobias Wenck, Dennis Pidun; JP051

package containerUtils;

import containers.IArrayCapacityStrategy;

/** 
 * Dieses Interface bietet Moeglichkeiten um allgemein zwei Objekte 
 * zu vergleichen.
 * @author Dennis Pidun, 296267, JP051
 * @author Tobias Wenck, 296441, JP051
 */
public class OneElementArrayCapacityStrategy 
    extends AbstractArrayCapacityStrategy {

    /**
     * Default-Constructor, tut nichts und ist nicht weiter spezifiziert worden.
     */
    public OneElementArrayCapacityStrategy() {
        
    }

    /** 
     * Ueberprueft ob das DatenArray vergroessert werden muss und kopiert 
     * den Inhalt des Arrays an die entsprechenden Stellen im neuen Array.
     * @see containers.IArrayCapacityStrategy#grow(java.lang.Object[], int, int)
     */
    @Override
    public Object[] grow(Object[] data, int pos, int size) {
        
        // Wir haben  keinen Weg gefunden, wo data.length != size ist.
        // Somit reservieren wir immer Platz fuer ein neues Objekt
        Object[] newData = new Object[size + 1];

        // Kopieren des alten Arrays bis pos
        for (int i = 0; i < pos; i++) {
            newData[i] = data[i];
        }
        
        // Kopieren des alten Arrays von pos, allerdings gespeichert in i + 1
        for (int i = pos; i < size; i++) {
            newData[i + 1] = data[i];
        }
        
        return newData;
    }

    /** 
     * Ueberprueft ob das DatenArray verkleinert werden muss und kopiert 
     * den Inhalt des Arrays an die entsprechenden Stellen im neuen Array.
     * @see containers.IArrayCapacityStrategy
     * #shrink(java.lang.Object[], int, int)
     */
    @Override
    public Object[] shrink(Object[] data, int pos, int size) {
        
        // Siehe grow(...), es muss somit Platz fuer size-1 
        // Objekten reserviert werden.
        Object[] newData = new Object[size - 1];
        
        // Kopieren des alten Arrays bis pos
        for (int i = 0; i < pos; i++) {
            newData[i] = data[i];
        }
        
        // Kopieren des alten Arrays von pos, allerdings gespeichert in i - 1
        for (int i = pos + 1; i < size; i++) {
            newData[i - 1] = data[i];
        }
        
        return newData;
    }

    /**
     * Einstiegspunkt, testet die OneElementArrayCapacityStrategy Strategie.
     * @param args Uebergebene Argumente beim Programmstart
     */
    public static void main(String[] args) {
        IArrayCapacityStrategy strategy = new OneElementArrayCapacityStrategy();
        AbstractArrayCapacityStrategy.testArrayList(strategy);
    }

}
