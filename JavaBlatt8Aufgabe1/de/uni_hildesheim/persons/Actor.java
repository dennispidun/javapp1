package de.uni_hildesheim.persons;

public class Actor extends Person {
    
    @Override
    public int getAge(Date currentdate) {
        return 35;
    }
    
    public static void main(String[] args) {
        Actor testactor = new Actor();
        Date actorsbirthday = new Date();
        actorsbirthday.setData(1, 2, 1823);
        testactor.setData("Andreas", "Kieling", actorsbirthday);
        Date today = new Date();
        today.setData(12, 12, 2018);
        System.out.println(testactor.getAge(today));
    }

}
