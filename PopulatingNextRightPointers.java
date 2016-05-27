import java.util.*;
public class PopulatingNextRightPointers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size - 1; i++) {
                TreeLinkNode cur = queue.poll();
                cur.next = queue.peek();
                if(cur.left != null)    queue.offer(cur.left);
                if(cur.right != null)   queue.offer(cur.right);
            }
            TreeLinkNode last = queue.poll();
            if(last.left != null)    queue.offer(last.left);
            if(last.right != null)   queue.offer(last.right);
        }
        
    }
	
	private class TreeLinkNode {
		 int val;
		 TreeLinkNode left, right, next;
		 TreeLinkNode(int x) { val = x; }
	}

}
