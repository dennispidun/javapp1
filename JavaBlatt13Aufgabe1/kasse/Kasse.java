// Blatt 13 Aufgabe 1: Dennis Pidun, Tobias Wenck

package kasse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utils.InputUtils;

/**
 * Kassen Klasse, hier liegt das Hauptprogramm mit dem Kassenmenue.
 * @author Tobias Wenck, 296441, JP051
 * @author Dennis Pidun, 296267, JP051
 *
 */
public class Kasse {

    /**
     * Liste mit den Rechnungen.
     */
    private static List<Rechnung> rechnungen;
    
    /**
     * Warenlager.
     */
    private static Warenlager lager;
    

    //<<Hauptprogramm Kasse in Kasse.java mit Scanner scanner>>
    /**
     * Hauptprogramm, welches ein Kassenmenue aufruft.
     * @param args Startargumente
     */
    public static void main(String[] args) {
        rechnungen = new ArrayList<Rechnung>();
        lager = new Warenlager();
        
        //<<Aufruf von menueAnzeigen() bis Benutzer "E" eingibt mit Scanner 
        //  scanner>>
        Scanner scanner = new Scanner(System.in);
        String eingabe;
        do {
            menueAnzeigen();
            eingabe = scanner.nextLine();
            switch(eingabe.toLowerCase()) {
            //<<Falls eingabe "R" ist rufe Unterprogramm neueRechnung() auf>>
            case "r": neueRechnung();
                break;
            //<<Falls eingabe "Z" ist rufe Unterprogramm zeigeRechnungen() auf>>
            case "z": zeigeRechnungen();
                break;
            //<<Falls eingabe "W" ist rufe Unterprogramm neueWare() auf>>
            case "w": neueWare();
                break;
            //<<Falls eingabe "A" ist rufe Unterprogramm warenZeigen() auf>>
            case "a": zeigeWaren();
                break;
            default: break;       
            
            }
        } while(!eingabe.equalsIgnoreCase("e"));

    }
    
    //<<Unterprogramm menueAnzeigen() in Kasse>>
    /**
     * Zeigt das Eingabemenue an.
     */
    public static void menueAnzeigen() {
        //<<Ausgabe "Willkommen im Kassensystem, 
        //  bitte treffen Sie eine Auswahl:" auf der Konsole>>
        System.out.println("Willkommen im Kassensystem, bitte treffen "
                + "Sie eine Auswahl:");
        //<<Ausgabe "R: Neue Rechnung anlegen" auf der Konsole>>
        System.out.println("R: Neue Rechnung anlegen");
        //<<Ausgabe "Z: Gespeicherte Rechnungen anzeigen" auf der Konsole>>
        System.out.println("Z: Gespeicherte Rechnungen anzeigen");
        //<<Ausgabe "W: Neue Waren dem Warenlager hinzufuegen" auf der Konsole>>
        System.out.println("W: Neue Waren dem Warenlager hinzufuegen");
        //<<Ausgabe "A: Waren aus dem Warenlager anzeigen" auf der Konsole>>
        System.out.println("A: Waren aus dem Warenlager anzeigen");
        //<<Ausgabe "E: Programm beenden" auf der Konsole>>
        System.out.println("E: Programm beenden");
    }
    
    //<<Unterprogramm neueRechnung() in Kasse mit Scanner scanner>>
    /**
     * Fordert den Nutzer auf eine neue Rechnung zu erstellen
     * indem er eine ID fuer eine Ware eingibt.
     */
    public static void neueRechnung() {
        //<<Wiederhole Eingabe solange bis eingabe leer ist>>
        String eingabe;
        boolean eingabeBeenden = false;
        boolean mindestensEineWare = false;
        Scanner scanner = new Scanner(System.in);
        Rechnung r = new Rechnung();
        do {
            //<<Ausgabe "Bitte geben Sie die ID der Ware ein: 
            //  " auf der Konsole>>
            System.out.println("Bitte geben Sie die ID der Ware ein: ");
            eingabe = scanner.nextLine();
            //<<Falls eingabe eine Zahl > 0 ist, suche Ware und erstelle 
            //  neue Rechnung>>
            if (eingabe.matches("[0-9]+") && Integer.parseInt(eingabe) > 0) {
                int id = Integer.parseInt(eingabe);
                
                //<<[...]suche Ware und erstelle neue Rechnung>>
                Ware ware = lager.getWare(id);
                if (ware != null) {
                    //<<Ausgabe "Rechnung mit der Ware (#ID) wurde angelegt." 
                    //  auf der Konsole>>
                    System.out.println("Rechnung mit der Ware (ID: " 
                            + id + ") wurde angelegt.");
                    r.addWare(ware);
                    mindestensEineWare = true;
                } else { // Falls ware nicht gefunden wurde.
                    System.out.println("Ware wurde nicht gefunden");
                }
                
            } else if (eingabe.length() == 0) { //<<Falls eingabe leer ist>>
                //<<Ausgabe "Rechnungseingabe beendet" auf der Konsole>>
                System.out.println("Rechnungseingabe beendet");
                eingabeBeenden = true;
                
            } else { //<<Falls eingabe keine Zahl ist>>
                //<<Ausgabe "Eingabe muss eine positive Ganzzahl 
                //  sein" auf der Konsole>>
                System.out.println("Eingabe muss eine positive Ganzzahl sein");
            }
        } while(!eingabeBeenden);
        
        if (mindestensEineWare) {
            rechnungen.add(r);
        }
           
    }
    
    //<<Unterprogramm zeigeRechnungen() in Kasse>>
    /**
     * Listet alle aktuellen Rechnungen auf, die sich in der Kasse befinden.
     */
    public static void zeigeRechnungen() {
        //<<Ausgabe "Dies sind die aktuellen Rechnungen im System: "
        //  auf der Konsole>>
        System.out.println("\nDies sind die aktuellen Rechnungen im System: ");
        //<<Durchlaufe alle Rechnungen und gib diese auf der Konsole aus>>
        for (Rechnung rechnung : rechnungen) {
            System.out.println(rechnung.toString());
        }
        System.out.println("");
        
    }
    
    //<<Unterprogramm neueWare() in Kasse mit Scanner scanner>>
    /**
     * Fordert den Nutzer auf, eine neue Ware zu definieren.
     * Die Ware wird dann im System gespeichert.
     */
    public static void neueWare() {
      //<<Ausgabe "Bitte geben Sie den Namen der Ware ein: " auf der Konsole>>
        System.out.println("Bitte geben Sie den Namen der Ware ein: ");
      
        Scanner scanner = new Scanner(System.in);

        //<<Wiederhole Eingabe solange bis nameEingabe korrekt 
        //  (ein gueltiger Name) ist>>
        //<<falls nameEingabe inkorrekt>>
        //<<Ausgabe "Name darf nicht leer sein!" auf der Konsole>>
        String nameEingabe = InputUtils.readString(scanner, 
            (name) -> !name.isEmpty(), "Name darf nicht leer sein!");

        //<<Ausgabe "Bitte geben Sie die Id der Ware ein: " auf der Konsole>>
        System.out.println("Bitte geben Sie die Id der Ware ein: ");    
        
        //<<Wiederhole Eingabe solange bis idEingabe korrekt (> 0) ist>>
        //<<falls idEingabe inkorrekt>>
        //<<Ausgabe "ID muss positiv sein!" auf der Konsole>>
        int idEingabe = InputUtils.readInt(scanner, -1, 
            (id) -> id > 0, "ID muss positiv sein!");
        
        if (idEingabe != -1) {
            //<<Ausgabe "Bitte geben Sie den Preis der Ware ein: "
            //  auf der Konsole>>
            System.out.println("Bitte geben Sie den Preis der "
                    + "Ware ein: ");       

            //<<Wiederhole Eingabe solange bis preisEingabe korrekt (>= 0) ist>>
            //<<falls preisEingabe inkorrekt>>
                //<<Ausgabe "Preis darf nicht negativ sein!" auf der Konsole>>  
            double preisEingabe = InputUtils.readDouble(scanner, -1, 
                (preis) -> preis >= 0, "Preis muss positiv sein!");
            
            if (preisEingabe != -1) {
                Ware ware = new Ware(idEingabe, nameEingabe, preisEingabe);
                lager.addWare(ware);  
                System.out.println("Ware wurde hinzugefuegt.");
            } else {
                System.out.println("Preis Eingabe ist Fehlgeschlagen");
                return;
            }
            
            
        } else {
            System.out.println("ID Eingabe ist Fehlgeschlagen");
        }
             
        
        
    }

    //<<Unterprogramm zeigeWaren() in Kasse>>
    /**
     * Durchlaeuft das Lager und gibt die Waren aus.
     */
    public static void zeigeWaren() {
        //<<Ausgabe "Dies sind die aktuellen Waren im System: "
        //  auf der Konsole>>
        System.out.println("\nDies sind die aktuellen Waren im System: ");
        //<<Durchlaufe alle Waren und gib diese auf der Konsole aus>>
        for (Ware ware : lager) {
            System.out.println(ware.toString());
        }
    }

}
