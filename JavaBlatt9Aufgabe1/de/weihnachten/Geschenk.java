// Blatt 9 Aufgabe 1: Tobias Wenck, Dennis Pidun; JP051 

package de.weihnachten;

public class Geschenk extends GewichtigesWeihnachtsObjekt {

    public Geschenk() {
        // Kalkullieren des Gewichts
        super(XMasUtils.getRandomIntegerInclusive(1, 20));
    }
    
    public String asString() {
        //Ausgabe des Gewichts unter Benutzung der Funktion aus der Oberklasse
        return "Dieses Geschenk wiegt " + this.getGewicht() + " Kilogramm!";
    }
    
    public static void main(String[] args) {
        Geschenk meinGeschenk = new Geschenk();
        
        System.out.println(meinGeschenk.asString());
    }

}
