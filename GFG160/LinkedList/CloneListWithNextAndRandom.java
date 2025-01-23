package GFG160.LinkedList;

import java.util.LinkedList;

class Node {
    int data;
    Node next;
    Node random;

    Node() {
    }

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}

public class CloneListWithNextAndRandom {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(5);
        Node n4 = new Node(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        n1.random = n3;
        n2.random = n3;
        n3.random = null;
        n4.random = n3;
        Node head = n1;
        cloneLinkedList(head);
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }

    public static Node cloneLinkedList(Node head) {
        Node copyHead = new Node();

        // Insert the new nodes after the old nodes
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.data);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        temp = head;
        // Get the random pointers
        while (temp != null) {
            if (temp.random == null) {
                temp.next.random = null;
            } else {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        // Break the two lists and get the next nodes
        temp = head;
        copyHead = head.next;
        Node copyTemp = copyHead;

        while (copyTemp.next != null) {
            temp.next = temp.next.next;
            copyTemp.next = copyTemp.next.next;
            temp = temp.next;
            copyTemp = copyTemp.next;
        }

        temp.next = null;
        copyTemp.next = null;
        return copyHead;
    }
}
