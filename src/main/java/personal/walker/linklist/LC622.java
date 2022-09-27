package personal.walker.linklist;

import personal.walker.Solution;

import java.util.LinkedList;

public class LC622 implements Solution {
    @Override
    public void runTestCases() {

    }

    class MyCircularQueue {
        class Node {
            int value;
            Node next;

            public Node(int value) {
                this.value = value;
            }
        }

        int cap;
        int size;
        Node head;
        Node tail;

        public MyCircularQueue(int k) {
            size = 0;
            cap = k;

        }

        public boolean enQueue(int value) {
            if (size >= cap) {
                return false;
            }
            if (head == null){
                head = new Node(value);
                tail = head;
            }else {
                tail.next = new Node(value);
                tail = tail.next;
            }
            size++;
            return true;
        }

        public boolean deQueue() {
            if (size == 0){
                return false;
            }
            if (head == tail){
                head = null;
                tail = null;
            }else {
                head = head.next;
            }
            size--;
            return true;
        }

        public int Front() {
            if (head == null){
                return -1;
            }
            return head.value;
        }

        public int Rear() {
            if (tail == null){
                return -1;
            }
            return tail.value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == cap;
        }
    }

}
