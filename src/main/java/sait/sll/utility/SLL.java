package sait.sll.utility;

public class SLL implements LinkedListADT {

    private Node head;
    private Node tail;

    private int size = 0;

    public SLL() {
        head = tail = null;
    }

    public Node getHead() {
        return this.head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return this.tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.head = this.tail = null;
    }

    //TODO: add last node
    @Override
    public void append(Object data) {
        if (this.head != null) {
            this.tail.setNext(new Node(data));
            this.tail = this.getTail().getNext();
        } else {
            this.head = this.tail = new Node(data);
        }

        this.size++;
    }

    //TODO: add first node
    @Override
    public void prepend(Object data) {
        this.head = new Node(data, this.head);

        if (this.tail == null)
            this.tail = this.head;

        this.size++;
    }

    @Override
    public void insert(Object data, int index) throws IndexOutOfBoundsException {
        if (index == 0) {
            this.prepend(data);
        } else if (this.size == index) {
            this.append(data);
        } else {
            Node tempNode = this.head;

            for (int i = 1; i < index; i++) {
                tempNode = tempNode.getNext();
            }

            Node temp = tempNode.getNext();
            tempNode.setNext(new Node(data, temp));
            tempNode.getNext().setNext(temp);

            size++;
        }

    }

    @Override
    public void replace(Object data, int index) throws IndexOutOfBoundsException {
        int i = 1;
        for (Node tempNode = this.head; tempNode != null; tempNode = tempNode.getNext()) {
            if (index == i) {
                tempNode.setData(data);
            }
            i++;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub

    }

    @Override
    public Object retrieve(int index) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int indexOf(Object data) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean contains(Object data) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node tempNode = this.head; tempNode != null; tempNode = tempNode.getNext()) {
            sb.append(tempNode.getData().toString()).append(", ");
        }

        if (sb.length() > 0) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        return sb.toString();
    }
}
