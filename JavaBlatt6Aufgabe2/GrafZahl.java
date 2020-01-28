// Blatt 6 Aufgabe 2: Dennis Pidun, Tobias Wenck

import java.util.Scanner;

//<<Hauptprogramm2 mit Scanner GrafZahl in GrafZahl.java>>
public class GrafZahl {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Hallo Graf Zahl. Bitte geben Sie die Unter- " 
            + "und Obergrenze für die Suche nach knuddeligen Zahlen ein:");
        
        int zahlA = 0, zahlB = 0;
        String fehler = null;
        do {
            if (fehler != null) {
                System.out.println(fehler);
            }
            
            //<<Deklariere Variable Typ Integer Name zahlA mit Wert 
            //  von scanner>>
            zahlA = scanner.nextInt();
            //<<Deklariere Variable Typ Integer Name zahlB mit Wert
            //  von scanner>>
            zahlB = scanner.nextInt();
            
            //<<Überprüfe Eingabe von zahlA und zahlB in Unterprogramm 
            //  pruefeEingabe(zahlA, zahlB)>>
            fehler = pruefeEingabe(zahlA, zahlB);
            
        } while (fehler != null);
        
        //<<Wenn zahlA > zahlB werden zahlA und zahlB vertausche>>
        if (zahlA > zahlB) {
            int temp = zahlB;
            zahlB = zahlA;
            zahlA = temp;
            
            System.out.println("Sie meinten sicher Untergrenze "
                + zahlA + " und Obergrenze " + zahlB + ". Korrigiert.");
        }
        
        //<<Gib "Knuddelig-Status" für Zahlen im Zahlenbereich 
        //  [zahlA; zahlB] auf der Konsole aus>>
        System.out.print("Die knuddeligen Zahlen im Bereich " + zahlA 
            + " bis " + zahlB + " sind: ");
            
        int counterKZahlen = 0;
        for (int i = zahlA; i <= zahlB; i++) {
            
            // Wenn Zahl i eine Knuddelige-Zahl ist:
            if (isKnuddelig(i)) {
                
                // Falls erste Knuddelige-Zahl: schreibe Zahl ohne 
                // Komma+Leerzeichen
                if (counterKZahlen == 0) {
                    System.out.print(i);
                } else {
                    System.out.print(", " + i);
                }
                
                counterKZahlen++;
            }
        }
        
        System.out.println("\nAuf Wiedersehen, Herr Graf.");
    }
    
    public static String pruefeEingabe(int zahlA, int zahlB) {
        
        String fehler = null;
        // ZahlA muss größer gleich 2 sein
        if (zahlA < 2) {
            fehler = "Aber Herr Graf. Die Untergrenze ist kleiner "
                + "als 2 und damit nicht gültig. Bitte geben Sie "
                + "Unter- und Obergrenze erneut ein.";
        }
        // ZahlB muss größer gleich 2 sein
        if (zahlB < 2) {
            fehler = "Aber Herr Graf. Die Obergrenze ist kleiner "
                + "als 2 und damit nicht gültig. Bitte geben Sie "
                + "Unter- und Obergrenze erneut ein.";
        }
        
        return fehler;
    }
    
    //<<Berechne "Knuddelig-Status" in Unterprogramm isKnuddelig(int zahl)>>
    public static boolean isKnuddelig(int zahl) {
        //<<Für 1 bis zahl-1 addiere echte Teiler und lege sie in 
        //  teilerSumme ab>>
        int teilerSumme = 0;
        
        for (int i = 1; i < zahl; i++) {
            if (zahl % i == 0) {
                teilerSumme += i;
            }
        }
        
        //<<Wenn teilerSumme >= zahl, gib true als "Knuddelig-Status" zurück>>
        return teilerSumme >= zahl;
    }   
    
}

   
   
   
   