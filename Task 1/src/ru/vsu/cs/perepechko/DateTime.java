package ru.vsu.cs.perepechko;

import java.util.Scanner;

public class DateTime {

    private int day;
    private int month;
    private int year;
    private int sec;
    private int min;
    private int hour;
    private int msec;

    public DateTime(int hour, int min, int sec, int day, int month, int year) {
        setHour(hour);
        setMin(min);
        setSec(sec);
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public DateTime(){
        this(0,0,0,0,0,0);
    }

//    Геттер времени и даты

    public String getDateTime(){
        return (getTime() + " " + getDate());
    }

//      Сеттеры даты
    public void setDate(int day, int month, int year){
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public void setDay(int day) {
        if (day < 0 || day > 30)
            this.day = 1;
        else
            this.day = day;
    }

    public void setMonth(int month) {
        if (month < 0 || month > 12)
            this.month = 1;
        else
            this.month = month;
    }

    public void setYear(int year) {
        if (year < 0)
            this.year = 1;
        else
            this.year = year;
    }

//      Геттеры даты
    public String getDate(){
        return ("Date DMY: " + getDay() + "." + getMonth() + "." + getYear());
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

    //    Геттеры времени
    public String getTime() {
        return ("Time HMS: " + getHour() + ":" + getMin() + ":" + getSec());
    }

    public int getHour(){
        return hour;
    }

    public int getMin(){
        return min;
    }

    public int getSec(){
        return sec;
    }

//    Сеттеры времени
    public void setTime(int hour, int min, int sec){
        setHour(hour);
        setMin(min);
        setSec(sec);
    }

    public void setHour(int hour){
    if (hour < 0 || hour > 23)
        this.hour = 0;
    else
        this.hour = hour;
}

    public void setMin(int min){
        if (min < 0 || min > 59)
            this.min = 0;
        else
            this.min = min;
    }

    public void setSec(int sec){
        if (sec < 0 || sec > 59)
            this.sec = 0;
        else
            this.sec = sec;
    }



// Добавление дня, месяца, года
    public void addDay(int day) {

        this.day+=day;
        if (this.day == 31) {
            this.month++;
            this.day = this.day % 31;
        }
        if (this.day > 31) {
            this.month += this.day / 31;
            this.day = this.day % 31;
        }
        if (this.day == 0) this.day = 1;
    }

    private void addDay1(int day) {

        this.month+= this.day / 30;
        this.day = this.day % 30;
        if (this.day == 0) this.day = 1;

        this.year+= this.month / 13;
        this.month = this.month % 13 + 1;
        if (this.month == 0) this.month = 1;

    }

    public void addMonth(int month){
        this.month += month;
        if (this.month == 12) {
            this.year+= this.month / 12;
            this.month = 1;
        }
        if (this.month > 12) {
            this.year+= this.month / 12;
            this.month = this.month % 12;
        }
    }

    public void addYear(int year) {
        this.year += year;
    }

    //    Добавление секунд, минут, часов
    public void addSec(int sec){
        this.sec+=sec;

        this.min+=this.sec / 60;
        this.sec = this.sec % 60;

        this.hour += this.min / 60;
        if (this.hour >= 24) {
            this.day += this.hour / 24;
            addDay1(day);
        }
        this.min = this.min % 60;

        this.hour = this.hour % 24;
    }

    public void addMin(int min) {
        addSec(min*60);
    }

    public void addHour(int hour) {
        addSec(hour*60*60);
    }


    public static String formatSecondDateTime(int msec) {
        if (msec <= 0) return "";
        int hour = msec / 3600;
        int min = msec % 3600 / 60;
        int sec = msec % 60;
        return ("h: " +hour + "m: " +min + "s: "+sec);
    }

    public void print() {
        System.out.println(toString());
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }

    static DateTime read(Scanner scanner) {
        DateTime datetime = new DateTime();
        System.out.println("hour: ");
        datetime.setHour(scanner.nextInt());

        System.out.println("min: ");
        datetime.setMin(scanner.nextInt());

        System.out.println("sec: ");
        datetime.setSec(scanner.nextInt());

        System.out.println("day: ");
        datetime.setDay(scanner.nextInt());

        System.out.println("month: ");
        datetime.setMonth(scanner.nextInt());

        System.out.println("year: ");
        datetime.setYear(scanner.nextInt());

        return datetime;
    }

//    Сравнение дат и времени
    public void Sravnenie(DateTime a, DateTime b) {
        if (a.getYear() > b.getYear()) {
            System.out.println("Дата " + a.getDateTime() + " позже даты " + b.getDateTime() );
        }
        if (a.getYear() < b.getYear()) {
            System.out.println("Дата " + a.getDateTime() + " раньше даты " + b.getDateTime() );
        }
        if (a.getYear() == b.getYear()) {

            if(a.getMonth() > b.getMonth()) {
                System.out.println("Дата " + a.getDateTime() + " позже даты " + b.getDateTime() );
            }
            if(a.getMonth() < b.getMonth()) {
                System.out.println("Дата " + a.getDateTime() + " раньше даты " + b.getDateTime() );
            }
            if(a.getMonth() == b.getMonth()) {

                if (a.getDay() > b.getDay()) {
                    System.out.println("Дата " + a.getDateTime() + " позже даты " + b.getDateTime());
                }
                if (a.getDay() < b.getDay()) {
                    System.out.println("Дата " + a.getDateTime() + " раньше даты " + b.getDateTime());
                }
                if (a.getDay() == b.getDay()) {

                    if (a.getHour() > b.getHour()) {
                        System.out.println("Дата " + a.getDateTime() + " позже даты " + b.getDateTime());
                    }
                    if (a.getHour() < b.getHour()) {
                        System.out.println("Дата " + a.getDateTime() + " раньше даты " + b.getDateTime());
                    }
                    if (a.getHour() == b.getHour()) {

                        if (a.getMin() > b.getMin()) {
                            System.out.println("Дата " + a.getDateTime() + " позже даты " + b.getDateTime());
                        }
                        if (a.getMin() < b.getMin()) {
                            System.out.println("Дата " + a.getDateTime() + " раньше даты " + b.getDateTime());
                        }
                        if (a.getMin() == b.getMin()) {

                            if (a.getSec() > b.getSec()) {
                                System.out.println("Дата " + a.getDateTime() + " позже даты " + b.getDateTime());
                            }
                            if (a.getSec() < b.getSec()) {
                                System.out.println("Дата " + a.getDateTime() + " раньше даты " + b.getDateTime());
                            }
                            if (a.getSec() == b.getSec()) {
                                System.out.println("Даты идентичны");
                            }
                        }
                    }
                }
            }
        }

    }
}
