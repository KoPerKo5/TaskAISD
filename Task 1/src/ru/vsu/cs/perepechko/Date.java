package ru.vsu.cs.perepechko;

public class Date {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        setDate(day,month,year);
    }

    public void setDate(int day, int month, int year){
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public String getDate(){
        return (getDay() + "." + getMonth() + "." + getYear());
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear(){
        return year;
    }

    public void addDay(int day) {

        this.day+=day;

        this.month+= this.day / 30;
        this.day = this.day % 30;
        if (this.day == 0) this.day = 1;

        this.year+= this.month / 13;
        this.month=this.month % 13;
        if (this.month == 0) this.month = 1;

       /* while (day < 31) {
            this.day += day;
            System.out.println(day + month);
            this.day -= 31;
        }
        if (day > 31) { //&& (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 )) {
            this.day += day - 31;
            month += 1; *?

        } */
    }

    public void addMonth(int month){
        addDay(month * 30);
    }

    public void addYear(int year) {
        this.year += year;
    }

}
