import java.util.*;

public class UniqueBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numTrees(int n) {
        if(n == 0) {
            return 0;
        }   
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            int num = i - 1;
            for(int j = 0; j <= num; j++) {
                dp[i] += dp[j] * dp[num - j];
            }
        }
        
        return dp[n];
    }
	
	public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new ArrayList<TreeNode>();
        }
        return buildTree(1, n);     
    }
    
    private List<TreeNode> buildTree(int lo, int hi) {
        List<TreeNode> trees = new ArrayList<>();
        if(lo > hi) {
            trees.add(null);
            return trees;
        }
        
        for(int i = lo; i <= hi; i++) {
            List<TreeNode> leftTrees = buildTree(lo, i - 1);
            List<TreeNode> rightTrees = buildTree(i + 1, hi);
            
            for(TreeNode left : leftTrees) {
                for(TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    trees.add(root);
                }
            }
        }
        
        return trees;
    }
    
    private class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	
    	public TreeNode(int x) {this.val = x;}
    }


}
