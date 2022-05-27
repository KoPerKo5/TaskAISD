package ru.vsu.cs.course1;

public class DobavlenieNylei {

    public static int[][] MasVList (int [][] mas) throws SimpleLinkedList.SimpleLinkedListException {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        for (int i = 0; i < mas[0].length; i++) {
            list.addLast(mas[0][i]);
        }
        dobavlenie(list);

        int[][] mas2 = new int[1][list.size()];
        for (int j = 0; j < list.size(); j++) {
            mas2[0][j] = list.get(j);
        }
        return mas2;
    }

    public static SimpleLinkedList<Integer> dobavlenie (SimpleLinkedList List) throws SimpleLinkedList.SimpleLinkedListException {
        for (int i = 0; i < List.size(); i++) {
            int k = List.getInt(i);
            boolean z = true;
            for (int j = 2; j < k; j++) {
                if ( k % j == 0) {
                    z = false;
                    break;
                }
            }
            if (z && k != 0) {
                List.Dobavlenie(0,i);
                i++;
            }
            if (!z) {
                List.Neprostoe(i);
            }
        }
        return List;
    }
}
