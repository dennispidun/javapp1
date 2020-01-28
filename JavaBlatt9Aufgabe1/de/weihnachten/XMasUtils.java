// Blatt 9 Aufgabe 1: Tobias Wenck, Dennis Pidun; JP051 

package de.weihnachten;

public class XMasUtils {
    
    public static double getRandomDoubleInclusive(double min, double max) {
        double random = Math.random() * (max - min + 0.01) + min; 
        if (random > max) { // Durch das + 0.01 ist das Maximum bei max+0.01
            random = max; // hierdurch wird dies korrigiert
        }
        
        return random;
    }
    
    // Auf Basis der getRandomDoubleInclusive Funktion:
    public static int getRandomIntegerInclusive(int min, int max) {
        return (int) getRandomDoubleInclusive(min, max);
    }
    
    public static void main(String[] args) {
        System.out.println("Pseudo-Random Double: "
            + getRandomDoubleInclusive(10, 20.567));
        System.out.println("Pseudo-Random Integer: "
            + getRandomIntegerInclusive(10, 20));
    }
    
}
