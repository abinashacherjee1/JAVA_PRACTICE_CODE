import java.util.*;
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void displayList() {
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
        }
        System.out.println();
    }

    public Node sortedInsert(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            head.next = head;
        } else if (data < head.data) {
            Node temp1 = head;
            while (temp1.next != head) {
                temp1 = temp1.next;
            }
            newnode.next = head;
            temp1.next = newnode;
            head = newnode;
        } else {
            Node temp = head;
            while (temp.next != head && data > temp.next.data) {
                temp = temp.next;
            }
            newnode.next = temp.next;
            temp.next = newnode;
        }
        return head;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.sortedInsert(5);
        list.sortedInsert(10);
        list.sortedInsert(2);
        list.sortedInsert(7);

        System.out.println("Sorted Circular Linked List:");
        list.displayList();
    }
}
