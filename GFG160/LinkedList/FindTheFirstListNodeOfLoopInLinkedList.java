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
        if (head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null && fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null || fast.next == null)
            return null;
        slow = head;
        fast = fast.next;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
