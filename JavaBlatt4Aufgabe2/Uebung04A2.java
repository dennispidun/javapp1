// Blatt 3 Aufgabe 1: Dennis Pidun, Tobias Wenck

import java.util.Scanner;

//<<Hauptprogramm2 mit Scanner Uebung04A2 in Uebung04A2.java>>
public class Uebung04A2 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //<<Schreibe "Bitte geben Sie eine Zahl ein" auf die Konsole>>
        System.out.println("Bitte geben Sie eine Zahl ein");
        
        //<<Deklariere Variable Typ Integer Name eingabe mit Wert von scanner>>
        int eingabe = scanner.nextInt();
        
        switch(eingabe % 13) {
        //<<Wenn eingabe durch 13 ohne Rest teilbar ist>>
            //<<Schreibe eingabe + "/7 ist " + (eingabe/7) auf die Konsole>>
        case 0: 
            System.out.println(eingabe + "/7 ist " + (eingabe / 7));
            break;
    
        //<<Wenn eingabe nicht durch 13 ohne Rest teilbar ist>>
            //<<Schreibe eingabe + "%3 = "+ (eingabe%3) auf die Konsole>>
        default:
            System.out.println(eingabe + "%3 = " + (eingabe % 3));
            break;
        }
  
    }
}