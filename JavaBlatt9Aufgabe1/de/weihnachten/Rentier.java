// Blatt 9 Aufgabe 1: Tobias Wenck, Dennis Pidun; JP051 

package de.weihnachten;


public class Rentier extends GewichtigesWeihnachtsObjekt {

    private double hunger;
    
    public Rentier() {
        // Kalkullieren des Gewichts
        super(XMasUtils.getRandomIntegerInclusive(200, 300));
        this.hunger =  XMasUtils.getRandomDoubleInclusive(1, 2);
    }
    
    public String asString() {
        //Ausgabe des Gewichts unter Benutzung der Funktion aus der Oberklasse
        return "Dieses Rentier wiegt " + this.getGewicht() + " Kilogramm "
                + "und es braucht " + this.getHunger() + " Essensrationen!";
    }

    // Getter fuer den Hunger
    public double getHunger() {
        return this.hunger;
    }
    
    // Getter fuer den individuellen Hunger unter Beruecksichtigung 
    // des Gesamt-Gewichts
    public double getHunger(double gGewicht) {
        return this.hunger + 0.01 * gGewicht;
    }
    
    public static void main(String[] args) {
        Rentier rentier = new Rentier();
        System.out.println(rentier.asString());

        System.out.println("Fuer einen 100 KG Schlitten braucht es " 
                + rentier.getHunger(100) + " Essensrationen!");
    }
    
}
