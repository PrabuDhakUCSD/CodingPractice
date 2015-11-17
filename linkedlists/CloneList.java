package linkedlists;

public class CloneList {
    public static Node cloneList(Node head) {
        if (head == null)
            return null;
        
        // clone each node and splice new node next to the original node.
        Node current = head;
        
        while(current != null) {
            Node newNode = new Node(current.c);
            newNode.next = current.next;
            current.next = newNode;
            current = current.next.next;
        }
        
        // Set random pointer for the new nodes.
        current = head;
        
        while (current != null) {
            if (current.random == null)
                current.next.random = null;
            else
                current.next.random = current.random.next;
            current = current.next.next;
        }
        
        // Now reset the original list and also recover the new list
        Node newHead = null;
        Node tail = null;
        
        current = head;
        
        while(current != null) {
            if (newHead == null) {
                newHead = tail = current.next;
            } else {
                tail.next = current.next;
                tail = tail.next;
            }
            
            current.next = current.next.next;
            current = current.next;
        }
        
        return newHead;
    }
}

class Node {
    public Node(char c) {
        this.c = c;
        this.next = this.random = null;
    }
    
    public char c;
    public Node next;
    public Node random;
}
