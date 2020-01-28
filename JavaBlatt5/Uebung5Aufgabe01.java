//Blatt 5 Aufgabe 1: Dennis Pidun 296267, Tobias Wenck 296441
import java.util.Scanner;

//<<Hauptprogramm Uebung05Aufgabe1 mit Scanner in Uebung05Aufgabe1.java>>
public class Uebung5Aufgabe01 {
    
    public static void main(String[] args) {
        
        /*
         * <<Abfrage "Was moechten Sie tun?" Deklariere Variable Typ int Name
         * operation mit Wert von eingabe>>
         */
        Scanner eingabe = new Scanner(System.in);
        System.out.println("Was moechten Sie tun?");
        System.out.println(" 1: Prim aufrufen");
        System.out.println(" 2: Sum aufrufen");
        System.out.println("Jede andere Zahl ruft Prim und danach Sum auf");
        int operation = eingabe.nextInt();
        
        //<<Switch-Menü mit Typ int bis Ende 2 von operation>>
        switch(operation) {
        //<|op1:1|><|Text1: 1: Prim aufrufen|><|code1:|>
        case 1: {
            System.out.println("Prim: Prueft ob eine eingebende Zahl eine"
                + " Primzahl ist.");
            System.out.println("Bitte geben Sie eine Zahl ein, auf welche "
                + "der Primzahlentest angewendet werden soll:");
            prim(eingabe.nextInt());
            break; }
        //<|op2:2|><|Text2: 2: Sum aufrufen|><|code2:|>
        case 2: {
            System.out.println("Sum: Die Zahlen von 1 bis zu einer "
                + "eingegeben Zahl summiert.");
            System.out.println("Bitte geben Sie eine Zahl ein bis zu der "
                + "aufsummiert werden soll:");
            sum(eingabe.nextInt());
            break; }
        /*
         * <|default|><|Text3: Jede andere Zahl ruft Prim und danach Sum auf|>
         * <|code3:|>
        */
        default: {
            System.out.println("Prim: Prueft ob eine eingebende Zahl eine"
                + " Primzahl ist.");
            System.out.println("Bitte geben Sie eine Zahl ein, auf welche "
                + "der Primzahlentest angewendet werden soll:");
            prim(eingabe.nextInt());
            System.out.println("Sum: Die Zahlen von 1 bis zu einer "
                + "eingegeben Zahl summiert.");
            System.out.println("Bitte geben Sie eine Zahl ein bis zu der "
                + "aufsummiert werden soll:");
            sum(eingabe.nextInt());
            break; }
        }
    }

    public static void prim(int input) {
        if (input > 1) {
            boolean isprim = true;
            //<<Schleife von i = 2 bis i < input>>
            for (int i = 2; i < input; i++) {
                if (input % i == 0) {
                    isprim = false;
                }
            }
            if (isprim) {
                //<<Schreibe Hinweis input + " ist eine Primzahl" adK>>
                System.out.println(input + " ist eine Primzahl");
            } else {
                //<<Schreibe Hinweis input + " ist keine Primzahl" adK>>
                System.out.println(input + " ist keine Primzahl");
            }
        } else {
            /*
             * <<Schreibe Hinweis input + "Die Zahl muss groesser als 1 sein und
             * dies ist " + input + " nicht!" auf die Konsole>>
            */
            System.out.println("Die Zahl muss groesser als 1 sein und dies ist "
                + input + " nicht!");
        }
    }
    
    public static void sum(int input) {
        if (input > 0) {
            int summe = 0;
            //<<Schleife von i = 0 bis input>>
            for (int i = 0; i <= input; i++) {
                //<<Erhöhe Summe um i>>
                summe += i;
            }
            //<<Schreibe Hinweis summe auf die Konsole>>
            System.out.println(summe);
        } else {
            /*
             * <<Schreibe Hinweis "Die Zahl muss groesser als 0 sein und dies
             * ist " + input + " nicht!" auf die Konsole>>
             */
            System.out.println("Die Zahl muss groesser als 0 sein und dies ist "
                + input + " nicht!");
        }
    }
    
}