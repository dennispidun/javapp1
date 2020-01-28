// Blatt 9 Aufgabe 1: Tobias Wenck, Dennis Pidun; JP051 

package de.weihnachten;

public class GewichtigesWeihnachtsObjekt extends WeihnachtsObjekt {

    private int gewicht;

    public GewichtigesWeihnachtsObjekt(int gewicht) {
        this.gewicht = gewicht;
    }
    
    @Override
    public int getGewicht() {
        return this.gewicht;
    }
    
}
