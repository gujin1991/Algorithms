package August8th;
import java.util.*;

public class SerializeandDeserializeBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String serialize(TreeNode root) {
        if(null == root) return "# ";
        String res = root.val + " " + serialize(root.left) + serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.charAt(0) == '#') return null;
        
        int end = data.indexOf(" ");
        int val1 = Integer.parseInt(data.substring(0, end));
        data = data.substring(end + 1);
        TreeNode root = new TreeNode(val1);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        TreeNode p = root;
        boolean right = false;
        while(data.length() > 0) {
                    //System.out.println(data);
            if(data.charAt(0) == '#') {
                if(!stack.isEmpty()) {
                    if(p == stack.peek()) {
                        p = stack.pop();
                        right = true;
                    } else {
                        p = stack.pop();
                    }
                }
                data = data.substring(2);
            } else {
                int idx = data.indexOf(" ");
                int val = Integer.parseInt(data.substring(0, idx));
                if(!right) {
                    p.left = new TreeNode(val);
                    p = p.left;
                    stack.push(p);    
                } else {
                    p.right = new TreeNode(val);
                    p = p.right;
                    stack.push(p);    
                    right = false;
                }
                data = data.substring(idx + 1);
            }
        }
        
        return root;
        
        
    }
    
    class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	public TreeNode(int v) {
    		this.val = v;
    	}
    }

}
