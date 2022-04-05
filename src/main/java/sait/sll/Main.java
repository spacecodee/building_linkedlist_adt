package sait.sll;

import sait.sll.utility.SLL;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        final SLL list = new SLL();
        list.append("1");
        list.append("10");

        list.prepend("0");

        list.insert("2", 0);
        list.insert("15", 4);
        list.insert("4to", 4);
        list.insert("20", 5);
        list.insert("80", 6);

        //list.insert("300", 3);

        System.out.println(list);
        System.out.println(list.size());
    }
}
