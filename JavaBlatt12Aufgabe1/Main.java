import java.util.Scanner;

import containers.ArrayList;
import containers.List;
import mobil.Auto;
import mobil.Traktor;
import mobil.Vehikel;

/**
 * Test-Klasse.
 * @author Tobias Wenck, 296441, JP051
 * @author Dennis Pidun, 296267, JP051
 *
 */
public class Main {

    private static List vehikelList = new ArrayList();
    
    /**
     * Test-Methode.
     * @param args Argumente
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String eingabe = "";
        do {
            displayMenu();
            System.out.print("Wie lautet Ihre Eingabe: ");
            eingabe = scanner.nextLine();

            chooseMethod(eingabe.toUpperCase());
        } while (!eingabe.equalsIgnoreCase("e"));
        scanner.close();
    }
    
    /**
     * Gibt das Menue aus.
     */
    private static void displayMenu() {
        System.out.println("Waehlen Sie bitte einen Menuepunkt: ");
        System.out.println("\tN: Neues Vehikel anlegen.");
        System.out.println("\tL: Vehikel l�schen");
        System.out.println("\tZ: Alle Vehikel anzeigen");
        System.out.println("\tE: Programm beenden.\n");
    }
    
    /**
     * Hier wird die gewünschte Methode gewählt.
     * @param eingabe Die Eingabe
     */
    private static void chooseMethod(String eingabe) {
        switch (eingabe) {
        case "N": neuesVehikel();
            break;
        case "L": loescheVehikel();
            break;
        case "Z": zeigeVehikel();
            break;
        default:
            break;
        }
    }
    
    /**
     * Erstellt ein neues Fahrzeug.
     */
    private static void neuesVehikel() {
        clearConsole();
        Scanner scanner = new Scanner(System.in);
        String type = "";
        do {
            if (type.length() > 0) {
                System.out.println("Fahrzeugart (" + type + ") ist nicht"
                    + "gueltig."); 
            }
            
            System.out.print("Welche Art von Fahrzeug wollen Sie abspeichern?"
                + "(Auto/Traktor): ");
            type = scanner.nextLine();
            
        } while (!type.equalsIgnoreCase("auto") && !type.equals("traktor"));
        
        String kennzeichen = "";
        
        do {            
            System.out.print("Wie lautet das Kennzeichen? (Format: B-B Z): ");
            kennzeichen = scanner.nextLine();
            
        } while(kennzeichen.length() <= 0);
        
        int ps = 0;
        
        do {
            if (ps < 0) {
                System.out.println("PS (" + ps + ") muessen positiv sein"); 
            }
            
            System.out.print("Wie viel Pferdestaerke hat Ihr Fahrzeug?: ");
            ps = scanner.nextInt();
            
        } while(ps <= 0);

        clearConsole();
        Vehikel vehikel = null;
        
        try {
            switch(type.toLowerCase()) {
            case "auto": vehikel = new Auto(kennzeichen, ps);
                break;
            case "traktor": vehikel = new Traktor(kennzeichen, ps);
                break; 
            default:
                break;
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        
        if (vehikel != null) {
            vehikelList.add(vehikel);
            System.out.println("Folgendes Fahrzeug wurde gespeichert: ");
            System.out.println(" ~> " + vehikel.toString());
        }
        System.out.println("\n\n\n");

        
        scanner.close();
        
    }
    
    /**
     * Löscht das Fahrzeug.
     */
    private static void loescheVehikel() {
        clearConsole();
        String kennzeichen = "";
        Scanner scanner = new Scanner(System.in);
        
        do {            
            System.out.print("Wie lautet das Kennzeichen, das entfernt werden"
                + "soll?: ");
            kennzeichen = scanner.nextLine();
            
        } while(kennzeichen.length() <= 0);
        clearConsole();
        Vehikel vehikel = null;
        for (int i = 0; i < vehikelList.size(); i++) {
            Vehikel foundVehikel = (Vehikel) vehikelList.get(i);
            if (foundVehikel.getKennzeichen().equalsIgnoreCase(kennzeichen)) {
                vehikel = foundVehikel;
                break;
            }
        }
        if (vehikel == null) {
            System.out.println("Kein Fahrzeug mit dem Kennzeichen "
                + kennzeichen + " gefunden!"); 
        } else {
            System.out.println("Fahrzeug mit dem Kennzeichen " + kennzeichen
                + " gefunden und geloescht!"); 
            System.out.println(" ~> " + vehikel.toString());
            vehikelList.remove(vehikel);
        }
       
        scanner.close();
    }
    
    /**
     * Zeigt das Fahrzeug.
     */
    private static void zeigeVehikel() {
        clearConsole();
        if (vehikelList.size() == 0) {
            System.out.println("Aktuell befinden sich keine Fahrzeuge im"
                + " Speicher!");
            System.out.println("\n\n\n");
            return;
        }
        
        System.out.println("Es sind folgende Fahrzeuge im Speicher: \n");
        for (int i = 0; i < vehikelList.size(); i++) {
            Vehikel vehikel = (Vehikel) vehikelList.get(i);
            
            System.out.println(vehikel.toString());
        }
        
        if (vehikelList.size() > 4) {
            System.out.println("\nFuer die vollstaendige Ausgabe bitte nach Obe"
                + "n scrollen!");
        }
        System.out.println("\n\n");
        
    }
    
    /**
     * Bereinigt die Konsole.
     */
    private static void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n");
    }
}
