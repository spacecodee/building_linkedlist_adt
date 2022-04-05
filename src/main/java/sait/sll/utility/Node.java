package sait.sll.utility;

import java.io.Serializable;

public class Node implements Serializable {

    private Object data;
    private Node next;
    private static int size = 0;

    public Node(Object data) {
        this.data = data;
        this.next = null;
        Node.size++;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }


    public void setData(Object data) {
        this.data = data;
    }


    public Node getNext() {
        return next;
    }


    public void setNext(Node next) {
        this.next = next;
    }
}
