// Blatt 9 Aufgabe 1: Tobias Wenck, Dennis Pidun; JP051 

package de.weihnachten;
import java.util.Scanner;

public class Weihnachten {
    
    //Beginn Aufgabenteil b)
    
    public static int getNumRentiere(Scanner in) {
        boolean wrongInput = true;
        int num = 0;
        do {
            System.out.println("Bitte geben Sie eine positive ganze Zahl fuer"
                + " die Anzahl an Rentieren ein:");
            num = in.nextInt();
            if (num > 0) {
                wrongInput = false;
            } else {
                System.out.println("Die Eingabe muss groesser als Null sein!");
            }
        } while (wrongInput);
        return num;
    }
    
    public static int getNumGeschenke(Scanner in) {
        boolean wrongInput = true;
        int num = 0;
        do {
            System.out.println("Bitte geben Sie eine positive ganze Zahl fuer "
                + "die Anzahl an Geschenken ein:");
            num = in.nextInt();
            if (num > 0) {
                wrongInput = false;
            } else {
                System.out.println("Die Eingabe muss groesser als Null sein!");
            }
        } while (wrongInput);
        return num;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean wrongInput = true;
        int numRentiere = 0;
        int numGeschenke = 0;
        double numFutter = 0;

        // Abfrage der Anzahlen:
        numRentiere = getNumRentiere(input);
        numGeschenke = getNumGeschenke(input);
        do {
            System.out.println("Bitte geben Sie eine positive Fliesskommazahl "
                + "fuer die Groesse des Futtervorrates ein:");
            numFutter = input.nextInt();
            if (numFutter > 0) {
                wrongInput = false;
            } else {
                System.out.println("Die Eingabe muss groesser als Null sein!");
            }
        } while (wrongInput);
        input.close();
        
        // Erstellen der Instanzen
        Geschenk[] geschenke = new Geschenk[numGeschenke];
        for (int i = 0; i < numGeschenke; i++) {
            geschenke[i] = new Geschenk();
        }
        Rentier[] rentiere = new Rentier[numRentiere];
        for (int i = 0; i < numRentiere; i++) {
            rentiere[i] = new Rentier();
        }
        
        Schlitten cl500 = new Schlitten(geschenke, rentiere);
        Weihnachtsmann grinch = new Weihnachtsmann(numFutter, cl500);
        
        // Beginn der Auslieferung
        if (cl500.kannFliegen()) {
            System.out.println("Der Schlitten hat " + cl500.getAnzahlGeschenke()
                + " Geschenk(e) und " + cl500.getAnzahlRentiere() + " Rentier(e"
                + ") und wiegt " + cl500.getGewicht() + "kg. Dies sind die "
                + "Rentiere:");
            for (int i = 0; i < numRentiere; i++) {
                System.out.println(rentiere[i].asString());
            }
            do {
                grinch.naechstesGeschenkAusliefern();
                if (grinch.kannNochFuettern()) {
                    grinch.fuettern();
                } else {
                    /*
                     * Diese Überprüfung ist notwendig, da es auch möglich ist,
                     * dass nach dem Ausliefern des letzten Geschenkes nicht
                     * mehr genug Futter übrig ist. In diesem Fall hat das
                     * Futter aber trotzdem gereicht, um alle Geschenke
                     * auszuliefern.
                     */
                    if (!grinch.istFertig()) {
                        System.out.println("Der Vorrat reicht nicht mehr, um"
                            + " weiter auszuliefern!");
                        return;
                    }
                }
            } while (!grinch.istFertig());
            System.out.println("Es sind alle Geschenke ausgeliefert.");
        } else {
            System.out.println("Der Schlitten kann nicht fliegen.");
        }
    }
}
