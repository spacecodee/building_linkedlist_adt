package sait.sll.utility;

import java.io.Serializable;

public class SLL implements LinkedListADT, Serializable {

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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            if (this.head.getData() != null) {
                this.head = head.getNext();
            } else {
                this.head = null;
                tail = null;
            }
            size--;

        } else if (index == this.size - 1) {
            Node previusNode = null;
            Node currentNode = this.head;

            while (currentNode.getNext() != null) {
                previusNode = currentNode;
                currentNode = currentNode.getNext();
            }
            assert previusNode != null;
            previusNode.setNext(null);
            this.tail = previusNode;
            size--;
        } else {
            Node previusNode = this.head;
            Node currentNode = this.head.getNext();
            for (int i = 1; i < this.size; i++) {
                if (i != index) {
                    previusNode = currentNode;
                    currentNode = currentNode.getNext();

                } else {
                    previusNode.setNext(currentNode.getNext());
                    size--;
                }
            }
        }
    }

    @Override
    public Object retrieve(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return this.head.getData();
        } else if (index == (this.size - 1)) {
            return this.tail.getData();
        } else {
            Node currentNode = this.head;
            int counter = 0;
            while (index != counter) {
                currentNode = currentNode.getNext();
                counter++;
            }
            return currentNode.getData();
        }
    }

    @Override
    public int indexOf(Object data) {
        int index = 0;

        // looping and searching for node with element=e

        for (Node currentNode = this.head; currentNode != null; currentNode = currentNode.getNext()) {

            if (currentNode.getData().equals(data)) {

                // found, returning index

                return index;
            }
            // updating index
            index++;
        }
        // not found
        return -1;
    }

    @Override
    public boolean contains(Object data) {

        // looping and checking if any node's value equals e

        for (Node currentNode = this.head; currentNode != null; currentNode = currentNode.getNext()) {

            if (currentNode.getData().equals(data)) {

                // found
                return true;
            }
        }
        // not found
        return false;
    }

/*
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
    }*/

    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node tempNode = this.head;
        for (int i = 0; i < size; i++) {
            assert tempNode != null;
            result.append(tempNode.getData());
            tempNode = tempNode.getNext();
            if (tempNode != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }
        }

        return result.toString();
    }
}
