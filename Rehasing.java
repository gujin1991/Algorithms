package July21th;

public class Rehasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode[] rehashing(ListNode[] hashTable) {
        int len = hashTable.length;
        ListNode[] newTable = new ListNode[len * 2];
        
        for(int i = 0; i < len; i++) {
            if(hashTable[i] != null) {
                ListNode p = hashTable[i];
                
                while(p != null) {
                    ListNode next = p.next;
                    int idx = (p.val % (len * 2) + (len * 2)) % (len * 2);
                    p.next = null;
                    if(newTable[idx] == null) {
                        newTable[idx] = p;
                    } else {
                        ListNode last = newTable[idx];
                        while(last.next != null) {
                            last = last.next;
                        }
                        last.next = p;
                        
                    }
                    p = next;
                }
            }
        }
        
        return newTable;
        
        
    }
	
	class ListNode {
		int val;
		ListNode next;
	}

}
