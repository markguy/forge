package com.zm.research.link;

/**
 * Created by 志明 on 14-1-4.
 */
class Queue {
    Node first, last;

    public void enqueue(Node n) {
        if (first == null) {
            first = n;
            last = first;
        } else {
            last.setNext(n);
            last = n;
        }
    }

    public Node dequeue() {
        if (first == null) {
            return null;
        } else {
            Node temp = new Node(first.getVal());
            first = first.getNext();
            if (last == temp) last = first;
            return temp;
        }
    }
}
