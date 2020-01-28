package de.uni_hildesheim.persons;

public class Date {
    
    int day, month, year;

    public void setData(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public String asString() {
        return this.day + "." + this.month + "." + this.year;
    }
    
    public int getYearDiff(Date newdate) {
        return Math.abs(newdate.year - this.year);
    }
    
    public static void main(String[] args) {
        Date testdate = new Date();
        Date testdate2 = new Date();
        testdate.setData(3, 4, 1990);
        testdate2.setData(12, 12, 2018);
        System.out.println(testdate.asString());
        System.out.println(testdate.getYearDiff(testdate2));
    }
}
