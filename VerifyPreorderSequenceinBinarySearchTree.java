package July31th;
import java.util.*;

public class VerifyPreorderSequenceinBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        if(preorder.length <= 1) return true;
        
        int min = Integer.MIN_VALUE;
        for(int val : preorder) {
            if(val < min) {
                return false;
            }
            
            while(!stack.isEmpty() && val > stack.peek()) {
                min = stack.peek();
                stack.pop();
                
            }
            
            stack.push(val);
        }
        
        return true;
        
    }
}
