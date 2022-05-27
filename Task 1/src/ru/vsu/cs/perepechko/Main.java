package ru.vsu.cs.perepechko;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        10.	Дата + Время (реализация должна быть выполнена на основе 2-х предыдущих классов).

        DateTime test = new DateTime(2,2,3,4,5,6);
        DateTime test2 = new DateTime(1,2,3,4,5,6);

        test.Sravnenie(test,test2);
        System.out.println(test.getDateTime());

        test.addMonth(5);
        test.Sravnenie(test,test2);

        test2.addSec(32000);
        test2.addMonth(6);
        test.Sravnenie(test,test2);

        test.addMonth(3);
        test.Sravnenie(test,test2);
        test2.Sravnenie(test2,test);

        test2.addMonth(8);
        System.out.println(test2.getDateTime());

        DateTime test3 = new DateTime(2,2,3,4,5,6);

        test3.addMin(90);
        System.out.println(test3.getDateTime());
        test3.addHour(1);
        test3.addDay(27);
        System.out.println(test3.getDateTime());

        test3.setTime(5,6,7);
        test3.setDate(3,9,2000);

        System.out.println(test3.getDateTime());

    }
}
