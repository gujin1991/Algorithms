import java.util.*;
public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        if(map.containsKey(root)) return map.get(root);
        
        int max = -1;
        int leftContains = 0;
        int rightContains = 0;
        
        if(root.left != null) {
            leftContains += rob(root.left.left) + rob(root.left.right);  
        }
        
        if(root.right != null) {
            rightContains += rob(root.right.left) + rob(root.right.right);
        }
        
        max = Math.max(max, root.val + leftContains + rightContains);
        max = Math.max(max, rob(root.left) + rob(root.right));
        
        map.put(root, max);
        return max;
    }
    
    public int robWithBetterMemo(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    
    private int[] dfs(TreeNode root) {
        if(root == null) return new int[2];
        
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        
        int[] res = new int[2];
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return res;
    }
    
    
    private class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	
    	public TreeNode(int v) {this.val = v;}
    }
}
