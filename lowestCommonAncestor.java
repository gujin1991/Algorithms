
import java.util.*;
public class lowestCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }    
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        return left == null ? right : right == null ? left : root;    
    }
	
	public GraphNode lowestCommonAncestor(GraphNode root, GraphNode p, GraphNode q) {
		if(root == null || root == p || root == q) {
			return root;
		}
		
		LinkedList<GraphNode> children = new LinkedList<>();
		for(GraphNode neigh : root.neighbors) {
			GraphNode tmp = lowestCommonAncestor(neigh, p, q);
			if(tmp != null && tmp != p && tmp != q) {
				return tmp;
			} else if(tmp != null) {
				children.add(tmp);
			}
		}
		
		if(children.size() == 2) {
			return root;
		} else if(children.size() == 1) {
			return children.get(0);
		} else {
			return null;
		}
	}
	
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {this.val = val;}
	}
	
	private class GraphNode {
		int val;
		LinkedList<GraphNode> neighbors;
		
		public GraphNode(int val) {
			this.val = val;
			neighbors = new LinkedList<>();
		}
	}
}
