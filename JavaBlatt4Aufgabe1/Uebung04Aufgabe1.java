//Blatt 4 Aufgabe 1: Dennis Pidun 296267, Tobias Wenck 296441

import java.util.Scanner;

//<<Hauptprogramm Uebung04Aufgabe1 mit Scanner in Uebung04Aufgabe1.java>>
public class Uebung04Aufgabe1 {
    
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        
        /*Eingabe
        *<<Abfrage "Geben Sie eine ganze Zahl ein: " Deklariere Variable Typ int
        *Name zahl1 mit Wert von scanner>>*/
        System.out.println("Geben Sie eine ganze Zahl ein:");
        int zahl1 = eingabe.nextInt();
        
        /*<<Abfrage "Geben Sie eine weitere ganze Zahl ein:" Deklariere Variable
        *Typ int Name zahl2 mit Wert von scanner>>*/
        System.out.println("Geben Sie eine weitere ganze Zahl ein:");
        int zahl2 = eingabe.nextInt();
        /*<<Abfrage "Geben Sie eine letzte ganze Zahl ein:" Deklariere Variable
        *Typ int Name zahl3 mit Wert von scanner>>*/
        System.out.println("Geben Sie eine letzte ganze Zahl ein:");
        int zahl3 = eingabe.nextInt();
        
        //Verarbeitung
        int groessteZahl = zahl1;
        //<<Falls zahl2 größer als zahl1 und zahl3 dann groessteZahl=zahl2>>
        if (zahl2 > zahl1 && zahl2 > zahl3) {
            groessteZahl = zahl2;
        }
        //<<Falls zahl3 größer als zahl1 und zahl2 dann groessteZahl=zahl3>>
        if (zahl3 > zahl1 && zahl3 > zahl2) {
            groessteZahl = zahl3;
        }
        
        /*<< Schreibe Hinweis "Die größte Zahl ist: " und groessteZahl auf die
        *Konsole>>*/
        System.out.println("Die groesste Zahl ist: " + groessteZahl);
    }
}
