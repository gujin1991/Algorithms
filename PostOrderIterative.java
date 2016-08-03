package August2nd;
import java.util.Stack;

public class PostOrderIterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void postOrder(TreeNode root) {
		TreeNode prev = null;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode top = stack.peek();
			if((top.left == null && top.right == null) ||  (prev != null && (top.left == prev || top.right == prev))) {
				TreeNode cur = stack.pop();
				System.out.println(cur.val);
				prev = cur;
			} else {
				if(top.right != null) {
					stack.push(top.right);
				}
				
				if(top.left != null) {
					stack.push(top.left);
				}
			}
		}
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}
