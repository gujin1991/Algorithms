package August6th;

public class IntersectionofTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        
        if(p1 == null || p2 == null) return null;
        
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            
            if(p1 == null && p2 == null) {
                return null;
            }
            
            if(p1 == null) p1 = headB;
            if(p2 == null) p2 = headA;
        }
        
        return p1;
    }
	
	class ListNode {
		int val;
		ListNode next;
	}
}
