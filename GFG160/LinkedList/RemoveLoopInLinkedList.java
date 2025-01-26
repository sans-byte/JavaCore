


public class RemoveLoopInLinkedList {
    public static void main(String[] args) {
        
    }

    public static void removeLoop(Node head) {
        if(head.next == null) return;
        Node slow = head;
        Node fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow) break;
        }
        
        if(fast == null || fast.next == null) return;
        
        slow = head;
        
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        
        
        while(slow.next != fast){
            slow = slow.next;
        }
        
        slow.next = null;
    }
}
