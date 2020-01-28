//Blatt 11: Tobias Wenck, Dennis Pidun; JP051

package containerUtils;

/** 
 * Dieses Interface bietet Moeglichkeiten um allgemein zwei Objekte 
 * zu vergleichen.
 * @author Dennis Pidun, 296267, JP051
 * @author Tobias Wenck, 296441, JP051
 */
public interface IElementComparator {

    /**
     * Vergleicht zwei Objekte mit einander und berechnet deren Rangfolge.
     * @param o1 erstes Objekt, welches mit dem Zweiten verglichen wird.
     * @param o2 zweites Objekt, welches mit dem Ersten verglichen wird.
     * @return int -1, falls Object o1 vor/kleiner als Object o2 ist,
     * int 0, falls die zu vergleichenden Objekte gleich sind und
     * int 1, falls Object o1 hinter/groesser als Object o2 ist,
     */
    int compare(Object o1, Object o2);
    
    
}
