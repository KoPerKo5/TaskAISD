package ru.vsu.cs.perepechko;


public class SimpleLinkedListQueue2<T> implements SimpleQueue<T> {

    private class SimpleLinkedListNode {
        public T value;
        public SimpleLinkedListNode next;

        public SimpleLinkedListNode(T value, SimpleLinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public SimpleLinkedListNode(T value) {
            this(value, null);
        }
        public void printQueue() {
            System.out.print("{" + value + "}");
        }
    }

    private SimpleLinkedListNode head = null;  // first, top
    private SimpleLinkedListNode tail = null;  // last
    private int count = 0;

    @Override
    public void add(T value) {
        if (count == 0) {
            head = tail = new SimpleLinkedListNode(value);
        } else {
            tail.next = new SimpleLinkedListNode(value);
            tail = tail.next;
        }
        count++;
    }

    @Override
    public T remove() throws Exception {
        T result = element();
        head = head.next;
        if (count == 1) {
            tail = null;
        }
        count--;
        return result;
    }

    public void print(int j, int i) throws Exception {
        if (j==1) {
            System.out.print("{" + head.value);
        }
        else {
            System.out.print(head.value);
        }
        if (j==i) {
            System.out.print("}");
        }
    }

    @Override
    public T element() throws Exception {
        if (count() == 0) {
            throw new Exception("Queue is empty");
        }
        return head.value;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean empty() {
        return count() == 0;
    }
}