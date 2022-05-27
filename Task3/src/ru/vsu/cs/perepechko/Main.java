package ru.vsu.cs.perepechko;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину очереди 'n' : ");
        int n = scanner.nextInt();
        SimpleLinkedListQueue2<Object> queue1 = new SimpleLinkedListQueue2<>();
        System.out.println("Очередь через реализованный класс: ");
        System.out.print("{ ");
        for (int i = 1; i <= n; i++) {
            SimpleLinkedListQueue2 queue2 = new SimpleLinkedListQueue2();
            System.out.print("{");
            for (int j = 1; j <= i; j++) {
                queue2.add(j);
                queue1.add(queue2.remove());
                if (j >= 2) {
                    System.out.print(",");
                }
                System.out.print(queue1.remove());
            }
            if (i==n) {
                System.out.print("} ");
            }
            else {
                System.out.print("}, ");
            }
        }
        System.out.print("}\n");

        System.out.println("Очередь через встроенный класс:");
        ArrayDeque<Object> queue3 = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            Queue queue4 = new PriorityQueue();
            for (int j = 1; j <= i; j++) {
                queue4.add(j);
            }
            queue3.addLast(queue4);
        }
        System.out.println(queue3);

    }


}
