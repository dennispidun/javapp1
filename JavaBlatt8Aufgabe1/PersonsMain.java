import de.uni_hildesheim.persons.*;

public class PersonsMain {
    
    public static void main(String[] args) {
        Date birthday = new Date();
        birthday.setData(13, 12, 2011);
        Date today = new Date();
        today.setData(12, 12, 2018);
        Person[] personen = new Person[5];
        personen[0] = new Person();
        personen[1] = new Person();
        personen[2] = new Person();
        personen[3] = new Person();
        personen[4] = new Actor();
        personen[0].setData("a", "b", birthday);
        personen[1].setData("c", "d", birthday);
        personen[2].setData("e", "f", birthday);
        personen[3].setData("g", "h", birthday);
        personen[4].setData("h", "i", birthday);
        for (int i = 0; i < 5; i++) {
            System.out.println(personen[i].asString());
            System.out.println(personen[i].getAge(today));
        }
    }
}
