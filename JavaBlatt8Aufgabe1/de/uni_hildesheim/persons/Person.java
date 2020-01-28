package de.uni_hildesheim.persons;

public class Person {
    
    String name, surname;
    Date birthday;
    
    public void setData(String name, String surname, Date birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }
    
    public int getAge(Date currentdate) {
        return this.birthday.getYearDiff(currentdate);
    }
    
    public String asString() {
        return this.surname + ", " + this.name + " " + this.birthday.asString();
    }
    
    public static void main(String[] args) {
        Date testbirthday = new Date();
        testbirthday.setData(1, 2, 1990);
        Date testdate = new Date();
        testdate.setData(12, 12, 2018);
        Person testperson = new Person();
        testperson.setData("Max", "Mustermann", testbirthday);
        System.out.println(testperson.asString());
        System.out.println(testperson.getAge(testdate));
    }
}
