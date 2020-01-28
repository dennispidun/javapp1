//Blatt 11: Tobias Wenck, Dennis Pidun; JP051

package containerUtils;

import containers.ArrayList;
import containers.IArrayCapacityStrategy;

/** 
 * Diese abstrakte Klasse liefert Moeglichkeiten um eine 
 * ArrayCapacityStrategy zu testen. Ausserdem implementiert sie das
 * IArrayCapacityStrategy.
 * @see containers.IArrayCapacityStrategy
 * @author Dennis Pidun, 296267, JP051
 * @author Tobias Wenck, 296441, JP051
 */
public abstract class AbstractArrayCapacityStrategy 
    implements IArrayCapacityStrategy {


    /** 
     * Mithilfe dieser Methode kann man einen vorgegebenen Testablauf
     * bzgl. ArrayLists/CapacityStrategies durchfuehren. Dieser Testablauf 
     * muss eine Strategie uebergeben bekommen, welche getestet werden soll.
     * @param strategy Die zu testende Strategie
     */
    public static void testArrayList(IArrayCapacityStrategy strategy) {
        String strategieName = strategy.getClass().getName().split("\\.")[1];
        System.out.println("Testausgabe zur " + strategieName);
        
        System.out.println("Aufbau der Testausgabe:");
        System.out.println("<Aktion> -> <soll> : <ist>\n");
        
        // Anlegen einer ArrayList mit der zu testenden Strategie
        ArrayList listUnderTest = new ArrayList(strategy);

        // List Size -> 0
        System.out.print("List Size -> 0 : ");
        System.out.println(listUnderTest.size() + "\n");
        
        // Pr�fen der Add-Methoden
        listUnderTest.add("A");
        listUnderTest.add("B");
        listUnderTest.add(1, "C");
        
        // Ausgabe der Liste -> [A, C, B]
        System.out.print("Ausgabe der Liste -> [A, C, B] : ");
        System.out.println(listUnderTest.toString() + "\n");
        
        // List Size -> 3
        System.out.print("List Size -> 3 : ");
        System.out.println(listUnderTest.size() + "\n");
        
        listUnderTest.remove(2);
                
        // List Size -> 2
        System.out.print("List Size -> 2 : ");
        System.out.println(listUnderTest.size() + "\n");
        
        // Ausgabe der ver�nderten Liste -> [A, C]
        System.out.print("Ausgabe der ver�nderten Liste -> [A, C] : ");
        System.out.println(listUnderTest.toString() + "\n");
        
        // Pr�fen der get Methode -> A
        System.out.print("Pr�fen der get Methode -> A : ");
        System.out.println(listUnderTest.get(0) + "\n");
        
        // Pr�fen der at Methode -> 1
        System.out.print("Pr�fen der at Methode -> 1 : ");
        System.out.println(listUnderTest.at("C") + "\n");
        
        // Testen der set Methode und erneute Ausgabe der Liste -> [A, B]
        listUnderTest.set(1, "B");
        
        System.out.print("Ausgabe der Liste -> [A, B] : ");
        System.out.println(listUnderTest.toString() + "\n");

        System.out.println("Entfernen der restlichen Elemente:");
        
        // List Size -> 2
        System.out.print("List Size -> 2 : ");
        System.out.println(listUnderTest.size());
        
        listUnderTest.remove(0);
        
        // List Size -> 2
        System.out.print("List Size -> 1 : ");
        System.out.println(listUnderTest.size());
        
        listUnderTest.remove(0);
        
        // List Size -> 2
        System.out.print("List Size -> 0 : ");
        System.out.println(listUnderTest.size());
    }

}
