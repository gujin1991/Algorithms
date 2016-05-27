
public class ConsecutiveBTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        DFS(root, 0, root.val);
        
        return max;
    }
    
    public void DFS(TreeNode root, int cur, int target) {
        if(root == null) {
            return;
        }
        
        int val = root.val;
        if(val == target) {
            cur++;
        } else {
            cur = 1;
        }
        
        max = Math.max(max, cur);
        DFS(root.left, cur, val + 1);
        DFS(root.right, cur, val + 1);
        
    }
    
    private class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	
    	public TreeNode(int x) {this.val = x;}
    }

}
