//Blatt 11: Tobias Wenck, Dennis Pidun; JP051

package containerUtils;

/**
 * Diese Klasse implementiert eine Strategie zum Vergrößern bzw. Verkleinern
 * von ArrayLists. Das Daten-Array wird größer dimensioniert als benoetigt und
 * um mehr als ein Element vergroessert bzw. verkleinert.
 * 
 * @author Tobias Wenck, 296441, JP051
 * @author Dennis Pidun, 296267, JP051
 *
 */
public class ResidualElementArrayCapacityStrategy
    extends AbstractArrayCapacityStrategy {

    /**
     * Speichert die maximale Ueberkapazitaet für die Klasse sichtbar.
     */
    private int residual;
    
    /**
     * Der Konstruktor bekommt die maximale Ueberkapazitaet übergeben und
     * speichert diese.
     * 
     * @param residual maximale Ueberkapazitaet
     */
    public ResidualElementArrayCapacityStrategy(int residual) {
        this.residual = residual;
        
        if (this.residual < 2) {
            this.residual = 2;
        }
    }

    /**
     * Es wird ein neues Array newData erstellt, was mit dem übergebenen Array
     * data belegt wird. Wenn das Array keinen Platz mehr hat, so wird es
     * um die maximale Ueberkapazitaet residual vergroessert und alle Elemente
     * ab der Stelle pos werden verschoben. Wenn im Array noch Platz ist, wird
     * nur verschoben.
     * 
     * @param data zu vergrößerndes Array
     * @param pos Position, ab der verschoben wird
     * @param size Anzahl an Elementen im Array
     * 
     * @return newData neues Array
     * 
     * @see containers.IArrayCapacityStrategy#grow(java.lang.Object[], int, int)
     */
    @Override
    public Object[] grow(Object[] data, int pos, int size) {
        Object[] newData = data;
        
        // Wenn Array wachsen muss:
        if (data.length == size) {
            newData = new Object[size + residual];
            
            for (int i = 0; i < pos; i++) {
                newData[i] = data[i];
            }
        }

        for (int i = pos; i < size; i++) {
            newData[i + 1] = data[i];
        }
        
        return newData;
    }

    /**
     * Ueberprueft ob das DatenArray verkleinert werden muss und kopiert 
     * den Inhalt des Arrays an die entsprechenden Stellen im neuen Array.
     * 
     * @see containers.IArrayCapacityStrategy#shrink(java.lang.Object[], int,
     *  int)
     */
    @Override
    public Object[] shrink(Object[] data, int pos, int size) {
        Object[] newData = data;
        
        // Wenn Array schrumpfen muss:
        if (data.length == size) {
            newData = new Object[size - 1];
            
            for (int i = 0; i < pos; i++) {
                newData[i] = data[i];
            }
        }
        
        for (int i = pos + 1; i < data.length; i++) {
            newData[i - 1] = data[i];
        }
        
        return newData;
    }

    /**
     * Einstiegspunkt, testet die ResidualElementArrayCapacity-Strategie.
     * @param args Übergebene Argumente für den Programmstart.
     */
    public static void main(String[] args) {
        AbstractArrayCapacityStrategy.testArrayList(new
            ResidualElementArrayCapacityStrategy(2));
    }

}
