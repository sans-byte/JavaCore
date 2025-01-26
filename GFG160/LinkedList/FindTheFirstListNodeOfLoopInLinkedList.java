package GFG160.LinkedList;

class ListNode {
    int data;
    ListNode next;

    ListNode(int x) {
        data = x;
        next = null;
    }

    ListNode(int x, ListNode next) {
        data = x;
        this.next = next;
    }
}

public class FindTheFirstListNodeOfLoopInLinkedList {
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n2 = new ListNode(2, n4);
        ListNode n3 = new ListNode(3, n2);
        ListNode n1 = new ListNode(1, n3);
        n5.next = n3;

        System.out.println(findFirstListNode(n1).data);
    }

    public static ListNode findFirstListNode(ListNode head) {
        if (head == null || head.next == null) {
            return null; // No loop possible in an empty or single-node list
        }
    
        ListNode slow = head;
        ListNode fast = head;
    
        // Detect the loop using Floyd's Cycle Detection Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
    
            // If slow and fast meet, there is a loop
            if (slow == fast) {
                break;
            }
        }
    
        // If no loop is found, return null
        if (fast == null || fast.next == null) {
            return null;
        }
    
        // Find the starting node of the loop
        slow = head;
    
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
    
        // Both pointers now point to the start of the loop
        return slow;
    }
}
