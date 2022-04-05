package sait.sll;

import sait.sll.utility.SLL;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        final SLL list = new SLL();

        list.append("1");
        list.append("2");
        list.append("3");
        list.append("4");
        list.append("5");
        list.append("10");

        System.out.println(list);
        System.out.println(list.size());

        list.clear();

        list.append("1");
        list.append("10");

        System.out.println(list);
        System.out.println(list.size());
    }
}
