package August24th;
import java.util.*;

public class FindLeavesofBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leaves = new ArrayList<>();
        
        findLeaves(root, leaves);
        
        return leaves;
    }
    
    private int findLeaves(TreeNode root, List<List<Integer>> leaves) {
        if(root == null) return -1;
        
        int left = findLeaves(root.left, leaves);
        int right = findLeaves(root.right, leaves);
        
        int cur = 1 + Math.max(left, right);
        
        if(leaves.size() <= cur) {
            leaves.add(new ArrayList<Integer>());
        }
        leaves.get(cur).add(root.val);
        
        return cur;
    }
    
    class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    }

}
