package August8th;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        return findDepth(root) == -1 ? false : true;
    }
    
    private int findDepth(TreeNode root) {
        if(null == root) return 0;
        
        int leftDepth = 1 + findDepth(root.left);
        int rightDepth = 1 + findDepth(root.right);
        
        if(Math.abs(leftDepth - rightDepth) > 1) return -1;
        
        if(leftDepth == 0 || rightDepth == 0) return -1;
        
        return Math.max(leftDepth, rightDepth);
    }
    
    class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    }

}
