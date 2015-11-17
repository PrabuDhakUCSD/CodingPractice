import java.io.*;
import java.util.*;

public class BasicList {

    Node headOfList;
    Node tailOfList;

    private class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = this.prev = null;
        }

        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        int getData() {
            return this.data;
        }
    }

    public BasicList() {
        headOfList = tailOfList = null;
    }

    public BasicList(List<Integer> items) {
        for(Integer aNumber: items) {
            addItem(aNumber.intValue());
        }
    }

    void addItem(int number) {
        if (headOfList == null) {
            headOfList = tailOfList = new Node(number);
            return;
        }

        Node newNode = new Node(number, null, tailOfList);
        tailOfList.next = newNode;
        tailOfList = newNode;
    }

    void removeItem(int number) {
    }

    void iterateOverList() {
        Node currentNode = headOfList;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.next;
        }
    }

    public static void main(String args[]) {
        BasicList bl = new BasicList();
        bl.addItem(5);
        bl.addItem(10);
        bl.addItem(3);
        bl.addItem(2);

        bl.iterateOverList();
    }
}
