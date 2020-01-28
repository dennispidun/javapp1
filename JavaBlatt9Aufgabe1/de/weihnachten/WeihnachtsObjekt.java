// Blatt 9 Aufgabe 1: Tobias Wenck, Dennis Pidun; JP051 

package de.weihnachten;

public class WeihnachtsObjekt {

    public int getGewicht() {
        return 0;
    }
    
    public boolean kannKollidieren(WeihnachtsObjekt object) {
        
        // ist "this" Weihnachtsmann, Rentier oder ein Geschenk
        boolean selbstIstKeinKollisionsObjekt = 
                (this instanceof Weihnachtsmann
                || this instanceof Rentier
                || this instanceof Geschenk);
        
        // ist "object" Weihnachtsmann, Rentier oder ein Geschenk
        boolean objectIstKeinKollisionsObjekt = 
                (object instanceof Weihnachtsmann
                || object instanceof Rentier
                || object instanceof Geschenk);
        
        // Wenn "this" oder "object" ein Objekt ist, dass nicht 
        // kollidieren darf, gebe falls false zur�ck.
        return !(selbstIstKeinKollisionsObjekt
            || objectIstKeinKollisionsObjekt); 
    }
    
    public static void main(String[] args) {
        
        Schlitten schlitten = new Schlitten(null, null);
        Schlitten schlitten2 = new Schlitten(null, null);
        Weihnachtsmann weihnachtsmann = new Weihnachtsmann(0, schlitten);
        Rentier rentier = new Rentier();
        Geschenk geschenk = new Geschenk();
        
        System.out.println(schlitten.kannKollidieren(schlitten2)); // true
        System.out.println(schlitten.kannKollidieren(weihnachtsmann)); // false
        System.out.println(weihnachtsmann.kannKollidieren(schlitten2)); // false
        System.out.println(rentier.kannKollidieren(weihnachtsmann)); // false
        System.out.println(rentier.kannKollidieren(geschenk)); // false
    }
    
}
