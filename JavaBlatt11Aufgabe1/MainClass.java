// Blatt 11: Tobias Wenck, Dennis Pidun; JP051

import containerUtils.OneElementArrayCapacityStrategy;
import containerUtils.Sorting;
import containers.ArrayList;

/**
 * Diese Klasse beinhaltet das Hauptprogramm.
 * @author Dennis Pidun, 296267, JP051
 * @author Tobias Wenck, 296441, JP051
 */
public class MainClass {

    /**
     * Einstiegspunkt.
     * @param args Uebergebene Parameter beim Programmstart
     */
    public static void main(String[] args) {
        
        ArrayList list = new ArrayList(new OneElementArrayCapacityStrategy());

        list.add("Hallo");
        list.add("wie");
        list.add("geht");
        list.add("es");
        list.add("Ihnen?");
        
        System.out.println(list.toString());
        
        Sorting.sort(list, (o1, o2) -> ((String) o1).compareTo(String
            .valueOf((String) o2)));
        
        System.out.println(list.toString());
    }

}
