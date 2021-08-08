import java.util.LinkedList;

public class MyCircularDeque {
    /**
     * 641. 设计循环双端队列
     */


    class Node {
        public int val;
        public Node prev;
        public Node next;

        public Node(int v) {
            val = v;
        }
    }

    private int size;
    private int capacity;
    private Node head;
    private Node tail;


    public MyCircularDeque(int k) {
        capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size == capacity) {
            return false;
        }
        if (head == null) {
            head = new Node(value);
            tail = head;
        } else {
            Node node = new Node(value);
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size == capacity) {
            return false;
        }
        if (tail == null) {
            tail = new Node(value);
            head = tail;
        } else {
            Node node = new Node(value);
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        if (head.next == null) {
            head = tail = null;
        } else {
            Node next = head.next;
            next.prev = null;
            head.next = null;
            head = next;
        }
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        if (tail.prev == null) {
            head = tail = null;
        } else {
            Node node = tail.prev;
            node.next = null;
            tail.prev = null;
            tail = node;
        }
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (head == null) {
            return -1;
        }
        return head.val;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (tail == null) {
            return -1;
        }
        return tail.val;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == capacity;
    }
}
