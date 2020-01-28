// Blatt 3 Aufgabe 1: Dennis Pidun, Tobias Wenck

import java.util.Scanner;

//<<Hauptprogramm2 mit Scanner Uebung03 in Uebung03.java>>
public class Uebung03 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //<<Schreibe "Bitte Name eingeben:" auf die Konsole>>
        System.out.println("Bitte Name eingeben:");
        
        //<<Deklariere Variable Typ String Name userName mit Wert von scanner>>
        String userName = scanner.nextLine();
        
        //<<Schreibe "Hallo <userName>" auf die Konsole>>
        System.out.print("Hallo ");
        System.out.println(userName);
        
        //<<Schreibe "Bitte erste Ganzzahl eingeben:" auf die Konsole>>
        System.out.println("Bitte erste Ganzzahl eingeben:");
        //<<Deklariere Variable Typ int Name zahl1 mit Wert von Scanner>>
        int zahl1 = scanner.nextInt();
        
        //<<Schreibe "Bitte zweite Ganzzahl eingeben:" auf die Konsole>>
        System.out.println("Bitte zweite Ganzzahl eingeben:");
        
        //<<Deklariere Variable Typ int Name zahl2 mit Wert von Scanner>>
        int zahl2 = scanner.nextInt();
        
        //<<Schreibe den Wert von zahl1 auf die Konsole>>
        System.out.print("Zahl 1 hat den Wert: ");
        System.out.println(zahl1);
        
        //<<Schreibe den Wert von zahl2 auf die Konsole>>
        System.out.print("Zahl 2 hat den Wert: ");
        System.out.println(zahl2);
        
        //<<Schreibe die Differenz von zahl1 und zahl2 auf die Konsole>>
        System.out.print("Die Differenz der Variablen zahl1 und zahl2 ist: ");
        System.out.println(zahl1-zahl2);
        
        //<<Schreibe das Ergebnis von "(zahl1 + zahl2) % 5 == 0" auf die Konsole>>
        System.out.print("Ist (zahl1+zahl2) durch 5 teilbar: ");
        System.out.println((zahl1 + zahl2) % 5 == 0);
    }
}