package ru.vsu.cs.perepechko;

import java.util.Scanner;

public class Time {

    private int sec;
    private int min;
    private int hour;
    private int msec;

    public static String formatSecondDateTime(int msec) {
        if (msec <= 0) return "";
        int hour = msec / 3600;
        int min = msec % 3600 / 60;
        int sec = msec % 60;
        return ("h: " +hour + "m: " +min + "s: "+sec);
    }


    public Time(int hour, int min, int sec) {
        setHour(hour);
        setMin(min);
        setSec(sec);
    }

    public Time(int hour, int min) {
        this(hour,min,0);
    }

    public Time(){
        this(0,0,0);
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

    public int hour(){
        return hour;
    }

    public int min(){
        return min;
    }

    public int sec(){
        return sec;
    }

    public void print() {
        System.out.println(toString());
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }

    static Time read(Scanner scanner) {
        Time time = new Time();
        System.out.println("hour: ");
        time.setHour(scanner.nextInt());

        System.out.println("min: ");
        time.setMin((scanner.nextInt()));

        System.out.println("sec: ");
        time.setSec((scanner.nextInt()));

        return time;
    }

    public void addSec(int sec){
        this.sec+=sec;

        this.min+=this.sec / 60;
        this.sec = this.sec % 60;

        this.hour += this.min / 60;
        this.min = this.min % 60;

        this.hour = this.hour % 24;

        if (this.hour >=0);
    }

    public void addMin(int min) {
        addSec(min*60);
    }

    public void addHour(int hour) {
        addSec(hour*60*60);
    }
}
