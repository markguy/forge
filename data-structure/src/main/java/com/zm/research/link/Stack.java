package com.zm.research.link;

/**
 * Created by 志明 on 14-1-4.
 */
public class Stack {
    private Node top;

    public Node peek() {
        if (top != null) {
            return top;
        }

        return null;
    }

    public Node pop() {
        if (top == null) {
            return null;
        } else {
            Node temp = new Node(top.getVal());
            top = top.getNext();
            return temp;
        }
    }

    public void push(Node n) {
        if (n != null) {
            n.setNext(top);
            top = n;
        }
    }
}
