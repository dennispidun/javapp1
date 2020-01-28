// Blatt 10 Aufgabe 1: Tobias Wenck, Dennis Pidun; JP051
import containers.ArrayList;
import containers.Container;
import containers.LinkedList;
import containers.List;

public class Main {

    private static final String LINE_BREAK = "\n";
    
    /**
     * Haupteinstiegsmethode, testet die Klassen: Container, List, 
     * LinkedList, LinkedListElement und ArrayList.
     * @param args Programmargumente, die beim Starten mituebergeben werden.
     */
    public static void main(String[] args) {
        
        // Erstellen einer ArrayList
        List liste = new ArrayList();

        // Ausgabe der Elemente
        System.out.println("Inhalt der ArrayList (vor Hinzufuegen): " 
                + LINE_BREAK + " ~> " 
                + liste.toString() + LINE_BREAK);
        
        // Hinzufügen der Elemente
        liste.add("2");
        liste.add("4");
        
        // Testen der add Methode mit Positionsangabe
        liste.add(2, "3");
        liste.add(0, "1");
        liste.add(4, "5");
        
        // Ausgabe der Elemente
        System.out.println("Inhalt der ArrayList (nach Hinzufuegen): " 
                + LINE_BREAK + " ~> " 
                + liste.toString() + LINE_BREAK);

        // Entfernen der Elemente an den Stellen 0, 3 und 1 nacheinander
        liste.remove(0);
        liste.remove(3);
        liste.remove(1);
        
        System.out.println("Inhalt der ArrayList (nach Entfernen): " 
                + LINE_BREAK + " ~> " 
                + liste.toString() + LINE_BREAK);
        
        // Anlegen einer neuen LinkedList
        Container linkedList = new LinkedList();

        System.out.println("Inhalt der LinkedList (vor Hinzufuegen): " 
                + LINE_BREAK + " ~> " 
                + linkedList.toString() + LINE_BREAK);
        
        // Hinzufügen der Werte
        linkedList.add("z");
        linkedList.add("y");
        linkedList.add("x");
        linkedList.add("w");
        linkedList.add("v");
        
        System.out.println("Inhalt der LinkedList (nach Hinzufuegen): " 
                + LINE_BREAK + " ~> " 
                + linkedList.toString() + LINE_BREAK);

        // Entfernen der Werte z, x und v nacheinander
        linkedList.remove("z");
        linkedList.remove("x");
        linkedList.remove("v");

        System.out.println("Inhalt der LinkedList (nach Loeschen): "
                + LINE_BREAK + " ~> " 
                + linkedList.toString() + LINE_BREAK); 
    }
}
